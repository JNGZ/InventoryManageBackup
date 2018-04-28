package Stock;

import CSV.Utility;

import java.util.ArrayList;

public class Stock {

    private ArrayList<Item> items;
    private Utility utility;

    public Stock(){
        items = new ArrayList<>();
        utility = new Utility();
        loadItems();
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public void loadItems() {
        items = utility.readItemList("./assets/item_properties.csv");
    }

    public void saveItems() {
        utility.writeItemList("./assets/item_properties.csv", items);
    }

    public ArrayList<Item> getItems(){
        return items;
    }
}
