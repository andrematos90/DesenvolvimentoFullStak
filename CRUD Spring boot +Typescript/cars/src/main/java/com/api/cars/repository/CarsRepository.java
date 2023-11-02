package com.api.cars.repository;

import com.api.cars.CarsApplication;
import com.api.cars.model.CarsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarsRepository extends JpaRepository<CarsModel, UUID>{

}
