package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DogsHandlerTest {
    private DogsRepository itsDogRepo = new DogsRepositoryStub();

    @BeforeEach //runs before each test is run
    public void makeSureRepoIsEmpty() {
        itsDogRepo.deleteAll();
    }
    @Test
    public void add_a_dog_return_number_of_dogs_in_repo_is_one () {
        //arrange
        DogHandler cut = new DogHandler( itsDogRepo );
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );

        int expectedResult = 1;

        //act
        long actualResult = cut.getNoOfDogs();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void add_several_dogs_return_number_of_dogs_match_number_added() {
        //arrange
        DogHandler cut = new DogHandler( itsDogRepo );

        Dog dog1 = new Dog();
        dog1.setName("1");
        cut.addDog( dog1 );

        Dog dog2 = new Dog();
        dog2.setName("2");
        cut.addDog( dog2 );

        Dog dog3 = new Dog();
        dog3.setName("3");
        cut.addDog( dog3 );

        //getDogByName method test


        int expectedResult = 3 /*several*/;

        //act
        long actualResult = cut.getNoOfDogs();

        //assert
        assertEquals(expectedResult, actualResult);
    }
}
