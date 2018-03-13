package fr.wcs.blablawild;

/**
 * Created by wilder on 13/03/18.
 */

public class VehiclePlane extends VehiculeAbstract {

    int speed = 0;



    public VehiclePlane(String brand, String model, int speed) {
        super(brand, model);
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    String getDescription() {
        return (getBrand()+", "+getModel()+", "+getSpeed());
    }
}
