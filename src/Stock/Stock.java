package Stock;

import CSV.CSVUtility;
import java.util.ArrayList;

public class Stock {

    ArrayList<Item> items;

    public Stock(){
        items = new ArrayList<>();
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public void loadArray(){

    }

}
