package com.api.cars.controllers;

import com.api.cars.dto.CarsDto;
import com.api.cars.models.CarsModel;
import com.api.cars.services.CarsService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/cars")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CarsController {
    final CarsService carsService;
    public CarsController(CarsService carsService){
        this.carsService = carsService;
    }
    @PostMapping
    public ResponseEntity<Object> saveCar(@RequestBody @Valid CarsDto carsDto){
        var carsModel = new CarsModel();
        BeanUtils.copyProperties(carsDto, carsModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(carsService.save(carsModel));
    }

}
