package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.service.DogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class DogsController {


    @Autowired
    DogsService dogsService;

    @GetMapping("/status")
    public String status() {
        return "Service is up and running!";
    }
    @GetMapping("/dogs")
    public List<Dog> getAllDogs() {
        return dogsService.getAllDogs();
    }

    @GetMapping("/dogs/count")
    public long getDogCount() {
        return dogsService.getNoOfDogs();
    }

    @GetMapping("/dogs/{id}")
    public Dog getDog(@PathVariable int id) {
        return dogsService.getDogById(id);
    }

    @GetMapping("/dogs/name/{name}")
    public Dog getDogByName(@PathVariable String name) {
        return dogsService.getDogByName(name);
    }
    @PostMapping("/dogs")
    public HttpStatus saveNewDog(@RequestBody Dog dog) {
        Dog result = dogsService.addDog(dog);
        if (result == null)
            return HttpStatus.PRECONDITION_FAILED;
        else
            return HttpStatus.CREATED;
    }
}