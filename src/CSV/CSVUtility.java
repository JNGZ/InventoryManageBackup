package CSV;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Stock.Item;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class CSVUtility {

    public void writeItemList(String fileName, ArrayList<Item> items) throws CSVFormatException{
        try{
            CSVWriter csvWriter = new CSVWriter(new FileWriter(fileName, false),
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

    public void write(String fileName, ArrayList<Item> items, boolean append) throws CSVFormatException{
        try{
            CSVWriter csvWriter = new CSVWriter(new FileWriter(fileName, append),
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

    public ArrayList<Item> read(String fileName) throws CSVFormatException {
        try{
            ArrayList<Item> items = new ArrayList<>();
            CSVReader csvReader = new CSVReader(new FileReader(fileName));
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null){
                if (nextRecord.length == 6){
                    items.add(new Item(nextRecord[0], Integer.parseInt(nextRecord[1]), Integer.parseInt(nextRecord[2]), Integer.parseInt(nextRecord[3]), Integer.parseInt(nextRecord[4]), Integer.parseInt(nextRecord[5])));
                } else {
                    items.add(new Item(nextRecord[0], Integer.parseInt(nextRecord[1]), Integer.parseInt(nextRecord[2]), Integer.parseInt(nextRecord[3]), Integer.parseInt(nextRecord[4])));
                }
            }
            return items;

        } catch (Exception err){
            return null;
        }
    }

    public String[] convertItemToStringArr(Item item){
        String[] temp = {item.name, String.valueOf(item.cost), String.valueOf(item.price), String.valueOf(item.reorderPoint), String.valueOf(item.reorderAmount), String.valueOf(item.temperature)};
        return temp;
    }

}
