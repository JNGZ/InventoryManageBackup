import Delivery.Manifest;
import Stock.Stock;

public class Store {
    String name;
    float capital;
    Stock stock;
    Manifest manifest;

    protected Store(String name) {
        this.name = name;
        this.capital = 100000.00f;
        this.stock = new Stock();
        this.manifest = new Manifest();
    }

    private static class InstanceHolder{
        private final static Store INSTANCE = new Store("SuperMart");
    }

    public static Store getInstance(){
        return InstanceHolder.INSTANCE;
    }

    public double getCapital(){
        return this.capital;
    }

    public Stock getStock(){
        return this.stock;
    }

    public Manifest getManifest() {
        return this.manifest;
    }
}
