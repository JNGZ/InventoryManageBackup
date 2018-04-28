package Delivery;

import CSV.Utility;
import Stock.Item;

import java.util.ArrayList;

public class RefrigeratedTruck extends Truck {

    double cost;
    int cargoCap, temperature;
    ArrayList<Object[]> cargo;
    Utility utility;

    RefrigeratedTruck(){
        this.utility = new Utility();
        this.cargo = new ArrayList<>();
        this.loadCargo();
        this.cargoCap = 800;
        this.temperature = getTemperature();
        this.cost = 900+(200*Math.pow(0.7, temperature/5));
    }

    @Override
    public void loadCargo() {
        cargo = utility.readManifest("./assets/manifest.csv", true);
    }

    @Override
    public ArrayList<Object[]> getCargo(){
        return cargo;
    }

    public int getTemperature(){
        int temp = 0;
        Item item;
        for (Object[] obj:cargo) {
            item = utility.getItem(obj[0].toString());
            if (item.temperature < temp){
                temp = item.temperature;
            }
        }
        return temp;
    }

}
