package com.api.cars.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="TB_CARS")
public class CarsModel implements Serializable {
    private static final long serialVariable = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 40)
    private String modelCar;
    @Column(nullable = false, length = 40)
    private String brandCar;
    @Column(nullable = false, length = 3000)
    private int modelYear;
    @Column(nullable = false, length = 20)
    private String fuelType;
    @Column(nullable = false)
    private boolean imported;
    @Column(nullable = false)
    private float zeroToOneHundred;

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
