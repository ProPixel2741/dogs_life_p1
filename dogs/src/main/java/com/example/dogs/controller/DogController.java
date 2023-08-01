package com.example.dogs.controller;

import com.example.dogs.model.Dog;
import com.example.dogs.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {
    @Autowired
    DogService dogService;

    @GetMapping("/dogs")
    public List<Dog> getAllDogs() {
        return dogService.getAllDogs();
    }


}
