package com.api.cars.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

public class CarsModel implements Serializable {
    final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 40)
    private String modelCar;
    @Column(nullable = false, length = 40)
    private String brandCar;
    @Column(nullable = false, length = 20)
    private String fuelType;
    @Column(nullable = false)
    private int modelYear;
    @Column(nullable = false)
    private float zeroToHundred;
    @Column(nullable = false)
    private boolean imported;

    public long getSerialVersionUID() {
        return SerialVersionUID;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
