package com.api.cars.services;

import com.api.cars.dto.CarsDto;
import com.api.cars.models.CarsModel;
import com.api.cars.repositories.CarsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import javax.validation.Valid;
@Service
public class CarsService {
    final CarsRepository carsRepository;
    public CarsService(CarsRepository carsRepository){
        this.carsRepository = carsRepository;
    }
   @Transactional
    public CarsModel save(CarsModel carsModel) {
        return carsRepository.save(carsModel);
    }
}
