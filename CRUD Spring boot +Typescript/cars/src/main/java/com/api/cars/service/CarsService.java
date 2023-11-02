package com.api.cars.service;

import com.api.cars.model.CarsModel;
import com.api.cars.repository.CarsRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
public class CarsService {
    final CarsRepository carRepository;
    public CarsService(CarsRepository carRepository){
        this.carRepository = carRepository;
    }

    @Transactional
    public CarsModel save(CarsModel carsModel) {
        return carRepository.save(carsModel);

    }
}
