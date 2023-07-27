package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;

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
}
