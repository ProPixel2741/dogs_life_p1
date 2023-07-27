package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;

import java.util.ArrayList;
import java.util.List;

public class DogHandler {

    private DogsRepository itsDogRepo; //injecting rather than instantiating
    public DogHandler(DogsRepository itsDogRepo)
    {
        this.itsDogRepo = itsDogRepo;
    }

    public long addDog(Dog theDog) {
        return itsDogRepo.save( theDog );
    }

    public long getNoOfDogs() {
        return itsDogRepo.count();
    }

    public Dog getDogByName(String name) {
        Dog myDog = new Dog();
        myDog.setName(name);
        List<Dog> dogs = itsDogRepo.findByName(myDog);
        if (dogs.isEmpty() || itsDogRepo.count() > 1) {
            return null;
        }

        /*
        for (int i = 0; i < dogs.size(); i++ ) {
            if (dogs.get(i).getName() == name) {
                return null;
            }
        }*/
        return dogs.get(0);
    }

    public Dog getDogById(long id) {
        if (itsDogRepo.existsById(id)) {
            Dog myDog = new Dog();
            myDog.setId(id);
            return myDog;
        }
        return null;
    }

    public long updateDogDetails(Dog dog) {
        return dog.getId();
    }

    public boolean removeDog(long id) {
        if(itsDogRepo.existsById(id)) {
            return false;
        }
        return true;
    }
}
