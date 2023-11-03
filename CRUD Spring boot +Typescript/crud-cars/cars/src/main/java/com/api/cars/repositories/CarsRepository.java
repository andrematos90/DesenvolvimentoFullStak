package com.api.cars.repositories;

import com.api.cars.models.CarsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarsRepository extends JpaRepository<CarsModel, UUID> {}