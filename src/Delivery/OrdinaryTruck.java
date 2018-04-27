package Delivery;

import Stock.Item;

import java.util.ArrayList;

public class OrdinaryTruck extends Truck {

    double cost;
    int cargoCap;
    ArrayList<Item> cargo;

    OrdinaryTruck(){
        this.cost = 750 + (0.25 * cargo.size());
        this.cargoCap = 1000;
        this.cargo = new ArrayList<>(cargoCap);
    }

}
