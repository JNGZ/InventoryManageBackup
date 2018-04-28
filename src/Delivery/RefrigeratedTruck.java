package Delivery;

import CSV.Utility;

import java.util.ArrayList;

public class RefrigeratedTruck extends Truck {

    private double cost;
    private int cargoCap, temperature;
    private ArrayList<Object[]> cargo;
    private Utility utility;

    RefrigeratedTruck(){
        this.utility = new Utility();
        this.cargo = new ArrayList<>();
        this.loadCargo();
        this.cargoCap = 800;
        //this.temperature = getTemperature();
        //this.cost = 900+(200*Math.pow(0.7, temperature/5));
    }

    @Override
    public void loadCargo() {
        cargo = utility.readManifest("./assets/manifest.csv", true);
    }

    @Override
    public ArrayList<Object[]> getCargo(){
        return this.cargo;
    }

    public int getTemperature(){
        int temp = 0;
        for (Object[] obj:this.cargo) {
            if ((int)obj[1] < temp){
                temp = (int)obj[1];
            }
        }
        return temp;
    }

}
