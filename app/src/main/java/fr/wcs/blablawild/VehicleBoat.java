package fr.wcs.blablawild;

/**
 * Created by wilder on 12/03/18.
 */
//subClass of VehicleAbstract
public class VehicleBoat extends VehicleAbstract {

    private int hours;

    public VehicleBoat(String brand, String model, int hours){
        this.hours = hours;
        super.setBrand(brand);
        super.setModel(model);
    }
    //surcharge de la méthode getDescription
    @Override
    String getDescription() {
        return getBrand() + ", " + getModel() + ", " + hours;
    }
}
