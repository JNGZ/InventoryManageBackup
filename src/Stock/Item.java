package Stock;

public class Item {

    public String name;
    public int cost, price, reorderPoint, reorderAmount, temperature;

    public Item(String name, int cost, int price, int reorderPoint, int reorderAmount, int temperature){
        this.name = name;
        this.cost = cost;
        this.price = price;
        this.reorderPoint = reorderPoint;
        this.reorderAmount = reorderAmount;
        this.temperature = temperature;
    }

    public Item(String name, int cost, int price, int reorderPoint, int reorderAmount){
        this.name = name;
        this.cost = cost;
        this.price = price;
        this.reorderPoint = reorderPoint;
        this.reorderAmount = reorderAmount;
    }
}
