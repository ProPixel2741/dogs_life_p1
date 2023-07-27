package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;

import java.util.List;

public class DogHandler {
    private DogsRepository itsDogsRepo;
    public DogHandler(DogsRepository repo) {
        itsDogsRepo = repo;
    }

    public long addDog(Dog theDog) {
        return itsDogsRepo.save(theDog);
    }

    public long getNoOfDogs() {
        return itsDogsRepo.count();
    }

    public String getDogById(long id) {
        if(itsDogsRepo.existsById(id)){
            return "Dog exists";
        }
        return  null;
    }

    public Dog getDogByName(String dogName) {
        Dog searchDog = new Dog();
        searchDog.setName(dogName);
        List<Dog> foundDog = itsDogsRepo.findByName(searchDog);
        Dog result = null;

        if (foundDog.size() == 1) {
            result = foundDog.get(0);
        }

        return result;
    }
}
