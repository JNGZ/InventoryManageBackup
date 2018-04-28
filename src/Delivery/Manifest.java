package Delivery;

import CSV.Utility;

import Stock.Item;

import java.util.ArrayList;

public class Manifest {

    ArrayList<Item> manifest;
    RefrigeratedTruck refTruck;
    OrdinaryTruck ordTruck;
    Utility utility;

    public Manifest(){
        utility = new Utility();
        refTruck = new RefrigeratedTruck();
        ordTruck = new OrdinaryTruck();
        manifest = new ArrayList<>();
    }

    public OrdinaryTruck getOrdTruck(){
        return ordTruck;
    }

    public RefrigeratedTruck getRefTruck(){
        return refTruck;
    }

    public void saveManifest() {
        utility.writeManifest("./assets/manifest.csv", refTruck.getCargo(), ordTruck.getCargo());
    }


}
