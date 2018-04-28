package CSV;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Stock.Item;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class CSVUtility {

    public void write(String fileName) throws IOException {
        try{
            CSVWriter csvWriter = new CSVWriter(new FileWriter(fileName, true),
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            String[] testRecord = {"1", "2", "3"};
            csvWriter.writeNext(testRecord);
            csvWriter.close();
        } catch (Exception err){

        }
    }

    public ArrayList<Item> read(String fileName) throws IOException {
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

}
