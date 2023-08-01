package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogsService
{

    @Autowired
    private DogsRepository itsDogsRepo;

    public List<Dog> getAllDogs()
    {
        return itsDogsRepo.findAll();
    }

    public Dog addDog(Dog theDog)
    {
        return itsDogsRepo.save( theDog );
    }

    public long getNoOfDogs()
    {
        return itsDogsRepo.count();
    }

    public boolean removeDog(int uniqueId)
    {
        boolean result = false;

        Optional<Dog> theDog = itsDogsRepo.findById(uniqueId);
        if(theDog.isPresent())
        {
            itsDogsRepo.delete(theDog.get());
            result = true;
        }

        return  result;
    }

    public Dog getDogById(int uniqueId)
    {
        return itsDogsRepo.findById(uniqueId).get();
    }

    public Dog getDogByName(String dogsName )
    {
        List<Dog> dogs = itsDogsRepo.getByName(dogsName);
        Dog result = null;

        if( dogs.size() == 1)
            result = dogs.get(0);

        return result;
    }

    public Dog updateDogDetails(Dog dogToUpdate)
    {
        return itsDogsRepo.save( dogToUpdate );
    }
}