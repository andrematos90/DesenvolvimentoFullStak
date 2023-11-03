package com.api.cars.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class CarsDto {

   @NotBlank
    private String modelCar;
    @NotBlank
    private String brandCar;
    @NotBlank
    private String fuelType;
    @NotBlank
    private int modelYear;
    @NotBlank
    private float zeroToHundred;
    @NotBlank
    private boolean imported;

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public String getBrandCar() {
        return brandCar;
    }

    public void setBrandCar(String brandCar) {
        this.brandCar = brandCar;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public float getZeroToHundred() {
        return zeroToHundred;
    }

    public void setZeroToHundred(float zeroToHundred) {
        this.zeroToHundred = zeroToHundred;
    }

    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }
}
