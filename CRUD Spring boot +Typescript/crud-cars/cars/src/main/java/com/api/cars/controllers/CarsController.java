package com.api.cars.controllers;

import com.api.cars.dto.CarsDto;
import com.api.cars.models.CarsModel;
import com.api.cars.services.CarsService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cars")
public class CarsController {
    final CarsService carsService;
    public CarsController(CarsService carsService){
        this.carsService = carsService;
    }
    @PostMapping
    public ResponseEntity<Object> saveCar(@RequestBody CarsDto carsDto){
        var carsModel = new CarsModel();
        BeanUtils.copyProperties(carsDto, carsModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(carsService.save(carsModel));
    }
    @GetMapping
    public ResponseEntity<List<CarsModel>> getAllCars(){
        return  ResponseEntity.status(HttpStatus.OK).body(carsService.findAll());
    }

}
