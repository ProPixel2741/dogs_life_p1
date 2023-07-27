package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;

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

    public Dog getDogByName(String name) {
        Dog find = new Dog();
        find.setName(name);
        List<Dog> found = itsDogsRepo.findByName(find);
        Dog result = null;

        if (found.size() == 1) {
            result = found.get(0);
        }

        return result;
    }

    public Dog getDogById(long id) {
        return itsDogsRepo.findById(id);
    }

    public long updateDogDetails(Dog dog) {
        return itsDogsRepo.save(dog);
    }

    public boolean removeDog(long id) {
        boolean result = false;

        Dog theDog = itsDogsRepo.findById(id);
        if (theDog != null) {
            itsDogsRepo.delete(theDog);
            result = true;
        }
        return result;
    }
}
