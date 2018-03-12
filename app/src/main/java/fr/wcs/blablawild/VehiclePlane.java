package fr.wcs.blablawild;

/**
 * Created by wilder on 12/03/18.
 */
//subClass of VehicleAbstract
public class VehiclePlane extends VehicleAbstract {

    private int speed;

    public VehiclePlane(String brand, String model, int speed){
        super.setBrand(brand);
        super.setModel(model);
        this.speed = speed;
    }
    //surcharge de la méthode getDescription
    @Override
    public String getDescription() {

        return getBrand() + ", " + getModel() + ", " + speed;
    }
}
