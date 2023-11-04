package com.api.cars.models;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;
@Entity
@Table(name = "TB_CARS")
public class CarsModel implements Serializable {

    private static final long serialVersionUID = 1L;

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
