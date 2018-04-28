package Stock;

import CSV.CSVFormatException;
import CSV.CSVUtility;

import java.util.ArrayList;

public class Stock {

    ArrayList<Item> items;
    CSVUtility csvUtility;

    public Stock(){
        items = new ArrayList<>();
        csvUtility = new CSVUtility();
        loadArray();
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public void loadArray() {
        try{
            items = csvUtility.read("./assets/item_properties.csv");
        } catch (CSVFormatException e){
            e.printStackTrace();
        }
    }

    public void saveArray() {
        try{
            csvUtility.writeItemList("./assets/item_properties.csv", items);
        } catch (CSVFormatException e){
            e.printStackTrace();
        }
    }

}
