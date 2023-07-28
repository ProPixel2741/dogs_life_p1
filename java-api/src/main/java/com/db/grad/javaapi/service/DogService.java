package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService
{
    private DogsRepository itsDogsRepo;

    @Autowired
    public DogService(DogsRepository dogRepo )
    {
        itsDogsRepo = dogRepo;
    }

    public long addDog(Dog theDog)
    {
        return itsDogsRepo.save( theDog );
    }

    public long getNoOfDogs()
    {
        return itsDogsRepo.count();
    }

    public boolean removeDog(long uniqueId)
    {
        boolean result = false;

        Dog theDog = itsDogsRepo.findById(uniqueId);
        if( theDog != null )
        {
            itsDogsRepo.delete(theDog);
            result = true;
        }

        return  result;
    }

    public Dog getDogById(long uniqueId)
    {
        return itsDogsRepo.findById(uniqueId);
    }

    public Dog getDogByName(String dogsName )
    {
        Dog dogToFind = new Dog();
        dogToFind.setName(dogsName);
        List<Dog> dogs = itsDogsRepo.findByName(dogToFind);
        Dog result = null;

        if( dogs.size() == 1)
            result = dogs.get(0);

        return result;
    }

    public Dog updateDogDetails(Dog dogToUpdate)
    {
        itsDogsRepo.save( dogToUpdate );
        return dogToUpdate;
    }
}