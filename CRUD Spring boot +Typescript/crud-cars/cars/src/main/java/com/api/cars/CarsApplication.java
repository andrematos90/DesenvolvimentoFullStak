package com.api.cars;

import com.api.cars.dto.CarsDto;
import com.api.cars.models.CarsModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class CarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarsApplication.class, args);
	}

}

