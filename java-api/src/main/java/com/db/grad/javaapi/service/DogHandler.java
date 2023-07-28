package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;

import java.util.List;
import java.util.Optional;

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
        boolean result = false;
        Optional<Dog> theDog = Optional.ofNullable(itsDogsRepo.findById(id));
        if ( theDog.isPresent() ) {
            itsDogsRepo.delete( theDog.get() );
            result = true;
        }
        return result;
    }

    public Dog getDogByName( String name ) {
        Dog dogToFind = new Dog();
        dogToFind.setName( name );
        List<Dog> dogs = itsDogsRepo.findByName( dogToFind );
        Dog result = null;
        if ( dogs.size() == 1 ) {
            result = dogs.get( 0 );
        }
        return result;
    }

    public long updateDogDetails( Dog dog ) {
        return itsDogsRepo.save( dog );
    }
}
