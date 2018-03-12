package fr.wcs.blablawild;

/**
 * Created by wilder on 12/03/18.
 */

abstract class VehicleAbstract {
    private String brand;
    private String model;


    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    abstract String getDescription();
}
