package CSV;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Stock.Item;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class Utility {

    public ArrayList<Item> readItemList(String fileName){
        try{
            ArrayList<Item> items = new ArrayList<>();
            CSVReader csvReader = new CSVReader(new FileReader(fileName));
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null){
                items.add(convertStringArrToItem(nextRecord[0], nextRecord[1], nextRecord[2], nextRecord[3], nextRecord[4], nextRecord[5]));
            }
            csvReader.close();
            return items;

        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public void writeItemList(String fileName, ArrayList<Item> items){
        try{
            CSVWriter csvWriter = new CSVWriter(new FileWriter(fileName),
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            for (Item item:items) {
                String[] temp = convertItemToStringArr(item);
                csvWriter.writeNext(temp);
            }
            csvWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Object[]> readManifest(String fileName, boolean refrigerated){
        try{
            ArrayList<Object[]> items = new ArrayList<>();
            CSVReader csvReader = new CSVReader(new FileReader(fileName));
            boolean getData = false;
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null){
                if (refrigerated){
                    if (nextRecord[0].equalsIgnoreCase(">Refrigerated")){
                        getData = true;
                        continue;
                    } else if (nextRecord[0].equalsIgnoreCase(">Ordinary")){
                        getData = false;
                    }
                } else {
                    if (nextRecord[0].equalsIgnoreCase(">Refrigerated")){
                        getData = false;
                    } else if (nextRecord[0].equalsIgnoreCase(">Ordinary")){
                        getData = true;
                        continue;
                    }
                }
                if (getData){
                    items.add(new String[]{nextRecord[0], nextRecord[1]});
                }
            }
            csvReader.close();
            return items;

        } catch (Exception err){
            return null;
        }
    }

    public void writeManifest(String fileName, ArrayList<Object[]> refTruckCargo, ArrayList<Object[]> ordTruckCargo){
        try{
            CSVWriter csvWriter = new CSVWriter(new FileWriter(fileName),
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            csvWriter.writeNext(new String[]{">Refrigerated"});
            for (Object[] obj:refTruckCargo) {
                String[] temp = (String[])obj;
                csvWriter.writeNext(temp);
            }
            csvWriter.writeNext(new String[]{">Ordinary"});
            for (Object[] obj:ordTruckCargo) {
                String[] temp = (String[])obj;
                csvWriter.writeNext(temp);
            }
            csvWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public Item convertStringArrToItem(String name, String cost, String price, String reorderPoint, String reorderAmount, String temperature){
        return new Item(name, Integer.parseInt(cost), Integer.parseInt(price), Integer.parseInt(reorderPoint), Integer.parseInt(reorderAmount), Integer.parseInt(temperature));
    }

    public String[] convertItemToStringArr(Item item){
        String[] temp = {item.name, String.valueOf(item.cost), String.valueOf(item.price), String.valueOf(item.reorderPoint), String.valueOf(item.reorderAmount), String.valueOf(item.temperature)};
        return temp;
    }

}
