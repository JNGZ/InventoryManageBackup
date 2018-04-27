import Stock.Stock;

public class Store {
    String name;
    double capital;
    Stock inventory;

    protected Store(String name){
        this.name = name;
        this.inventory = new Stock();
    }

    private static class InstanceHolder {
        private final static Store INSTANCE = new Store("SuperMart");
    }

    public static Store getInstance(){
        return InstanceHolder.INSTANCE;
    }

    public String getName(){
        return this.name;
    }

    public double getCapital(){
        return this.capital;
    }
}
