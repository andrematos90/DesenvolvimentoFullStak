package com.api.cars.dto;

import javax.validation.constraints.NotBlank;

public class CarsDto {
    @NotBlank
    private String modelCar;
    @NotBlank
    private String brandCar;
    @NotBlank
    private int modelYear;
    @NotBlank
    private String fuelType;
    @NotBlank
    private boolean imported;
    @NotBlank
    private float zeroToOneHundred;

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

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }

    public float getZeroToOneHundred() {
        return zeroToOneHundred;
    }

    public void setZeroToOneHundred(float zeroToOneHundred) {
        this.zeroToOneHundred = zeroToOneHundred;
    }
}
