package fr.wcs.blablawild;

/**
 * Created by wilder on 12/03/18.
 */
//subClass of VehicleAbstract
class VehicleCar extends VehicleAbstract {
    private int kilometers;

    public VehicleCar( String brand, String model, int kilometers) {
        super.setBrand(brand);
        super.setModel(model);
        this.kilometers = kilometers;
    }
    //surcharge de la méthode getDescription
    @Override
    public String getDescription() {

        return getBrand() + ", " + getModel() + ", " + kilometers;
    }
}
