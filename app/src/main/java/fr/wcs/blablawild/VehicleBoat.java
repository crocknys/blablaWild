package fr.wcs.blablawild;

/**
 * Created by wilder on 12/03/18.
 */

public class VehicleBoat extends VehiculeAbstract {

    int hour = 0;

    public VehicleBoat(String brand, String model, int hour) {
        super(brand, model);
        this.hour = hour;
    }


    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }


    @Override
    String getDescription() {
        return (getBrand()+", "+getModel()+", "+getHour());
    }
}

