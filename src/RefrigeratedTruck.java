import java.util.ArrayList;

public class RefrigeratedTruck extends Truck {

    double cost;
    int cargoCap, temperature;
    ArrayList<Item> cargo;


    RefrigeratedTruck(double temperature){
        this.cost = 900+(200*Math.pow(0.7, temperature/5));
        this.cargoCap = 800;
        this.cargo = new ArrayList<>(cargoCap);
    }

}
