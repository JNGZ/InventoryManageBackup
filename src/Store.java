public class Store {
    String name;
    double capital;
    Stock inventory;

    protected Store(String name){
        this.name = name;
        this.inventory = new Stock();
    }

    private static class InstanceHolder {
        private final static Store INSTANCE = new Store("Luke's Store");
    }

    public static Store getInstance(){
        return InstanceHolder.INSTANCE;
    }
}
