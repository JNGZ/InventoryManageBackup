package Delivery;

import CSV.Utility;

import java.util.ArrayList;

public class OrdinaryTruck extends Truck {

    double cost;
    int cargoCap;
    ArrayList<Object[]> cargo;
    Utility utility;

    OrdinaryTruck(){
        this.utility = new Utility();
        this.cargoCap = 1000;
        this.cargo = new ArrayList<>();
        this.loadCargo();
        this.cost = 750 + (0.25 * cargo.size());
    }

    @Override
    public void loadCargo() {
        cargo = utility.readManifest("./assets/manifest.csv", false);
    }

    @Override
    public ArrayList<Object[]> getCargo(){
        return cargo;
    }

}
