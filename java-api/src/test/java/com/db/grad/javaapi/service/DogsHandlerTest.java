package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import org.junit.jupiter.api.Test;

import com.db.grad.javaapi.repository.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DogsHandlerTest {

    private DogsRepository itsDogRepo = new DogsRepositoryStub();

    public void makeSureRepoIsEmpty() {
        itsDogRepo.deleteAll();
    }
    @Test
    public void add_a_dog_return_number_of_dogs_in_repo_is_one() {
        //arrange
        DogHandler cut = new DogHandler( itsDogRepo );
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );

        int expectedResult = 1;

        //act
        long actualResult = cut.getNoOfDogs();

        //assert
        assertEquals( expectedResult, actualResult );
    }

    @Test
    public void add_several_dogs_return_number_of_dogs_match_number_added() {

        DogHandler cut = new DogHandler( itsDogRepo );
        Dog dog1 = new Dog();
        dog1.setName("Jill");
        cut.addDog( dog1 );
        Dog dog2 = new Dog();
        dog2.setName("Jack");
        cut.addDog( dog2 );
        Dog dog3 = new Dog();
        dog3.setName("Cooper");
        cut.addDog( dog3 );
        Dog dog4 = new Dog();
        dog4.setName("Fluffy");
        cut.addDog( dog4 );

        int expectedResult = 4;
        long actualResult = cut.getNoOfDogs();

        assertEquals( expectedResult, actualResult );

    }
}
