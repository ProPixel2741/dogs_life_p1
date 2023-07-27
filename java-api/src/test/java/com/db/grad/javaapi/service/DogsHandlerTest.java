package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.constraints.AssertFalse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class DogsHandlerTest {
    private DogsRepository itsDogRepo = new DogsRepositoryStub();

    @BeforeEach
    public void makeSureRepoIsEmpty(){
        itsDogRepo.deleteAll();
    }
    @Test
    public void add_a_dog_return_number_of_dogs_in_repo_is_one() {
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);

        long actualResult = cut.getNoOfDogs();

        int expectedResult = 1;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_getDogsByName() {
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");

        cut.addDog(theDog);

        assertEquals(theDog, cut.getDogByName("Bruno"));
    }

    @Test
    public void return_null_when_dog_not_found_by_id(){
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setId(101);
        cut.addDog(theDog);

        String actualResult = cut.getDogById(102);
        assertEquals(null,actualResult);
    }
}
