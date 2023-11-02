package com.api.cars.controller;

import com.api.cars.dto.CarsDto;
import com.api.cars.model.CarsModel;
import com.api.cars.service.CarsService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/cars")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CarsController {
    final CarsService carsService;
    public CarsController(CarsService carsService){
        this.carsService = carsService;
    }
    @PostMapping
    public ResponseEntity<Object>savaCar(@RequestBody @Valid CarsDto carsDto){
        CarsModel carsModel = new CarsModel();
        BeanUtils.copyProperties(carsDto, carsModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(carsService.save(carsModel));
    }
}
