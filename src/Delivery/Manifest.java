package Delivery;

import CSV.Utility;

import Stock.Item;

import java.util.ArrayList;

public class Manifest {

    private ArrayList<Item> manifest;
    private RefrigeratedTruck refTruck;
    private OrdinaryTruck ordTruck;
    private Utility utility;

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
