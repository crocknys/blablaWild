package fr.wcs.blablawild;

/**
 * Created by wilder on 12/03/18.
 */

public class VehicleCar extends VehiculeAbstract {

    int km = 0;

    public VehicleCar(String brand, String model, int km) {
        super(brand, model);
        this.km = km;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    @Override
    String getDescription() {
        return (getBrand()+", "+getBrand()+", "+getKm());
    }
}
