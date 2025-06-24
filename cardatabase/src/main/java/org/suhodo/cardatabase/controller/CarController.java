package org.suhodo.cardatabase.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.suhodo.cardatabase.domain.Car;
import org.suhodo.cardatabase.repository.CarRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarRepository carRepository;

    @GetMapping("/cars")
    public List<Car> getCars(){
        return carRepository.findAll();
    }
}
