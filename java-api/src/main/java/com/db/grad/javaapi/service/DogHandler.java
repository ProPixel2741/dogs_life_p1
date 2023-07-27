package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;

public class DogHandler {

    private DogsRepository itsDogsRepo;
    public DogHandler( DogsRepository repo ) {
        itsDogsRepo = repo;
    }

    public long addDog( Dog theDog ) {
        return itsDogsRepo.save( theDog );
    }

    public long getNoOfDogs() {
        return itsDogsRepo.count();
    }

    public Dog getDogById( long id ) {
        return itsDogsRepo.findById( id );
    }

    public boolean removeDog( long id ) {
        return itsDogsRepo.delete(itsDogsRepo.findById( id ));
    }

    /*
    public Dog getDogByName( String name ) {
        return itsDogsRepo.findByName();
    }
    */

    public long updateDogDetails( Dog dog ) {
        if ( itsDogsRepo.existsById( dog.getId() ) ) {
            return itsDogsRepo.save( dog );
        }
        return -1;
    }
}
