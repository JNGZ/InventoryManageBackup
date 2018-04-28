import CSV.CSVUtility;
import Stock.Stock;

import java.io.IOException;

public class Store {
    String name;
    double capital;
    Stock stock;

    protected Store(String name) {
        this.name = name;
        this.stock = new Stock();
    }

    private static class InstanceHolder{
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
