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
import java.util.Optional;
import java.util.UUID;

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
    @GetMapping("/{id}")
    public ResponseEntity<Object> getCarById(@PathVariable(value = "id") UUID id){
        Optional<CarsModel> carsModelOptional = carsService.findById(id);
       if(!carsModelOptional.isPresent()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carro não encontrado!");
       }
        return  ResponseEntity.status(HttpStatus.OK).body(carsModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCar(@PathVariable(value = "id")UUID id, @RequestBody CarsDto carsDto){
        Optional<CarsModel> carsModelOptional = carsService.findById(id);
        if(!carsModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carro não encontrado!");
        }
        carsService.delete(carsModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Registro  excluido com sucesso!");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> putCar(@PathVariable( value = "id") UUID id, @RequestBody CarsDto carsDto){
        Optional<CarsModel> carsModelOptional = carsService.findById((id));
        if(!carsModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carro não encontrado!");
        }
        var carsModel = new CarsModel();
        BeanUtils.copyProperties(carsDto, carsModel);
        carsModel.setId(carsModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(carsService.save(carsModel));
    }

}
