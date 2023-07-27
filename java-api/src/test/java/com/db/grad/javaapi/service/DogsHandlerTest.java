package com.db.grad.javaapi.service;

import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.model.Dog;

import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DogsHandlerTest {

    private DogsRepository itsDogRepo = new DogsRepositoryStub();

    @BeforeEach
    public void makeSureRepoIsEmpty() {
        itsDogRepo.deleteAll();
    }

    @Test
    public void add_a_dog_return_number_of_dogs_in_repo_is_one() {
        DogHandler cut = new DogHandler(itsDogRepo);

        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);

        int expectedRes = 1;
        long actualRes = cut.getNoOfDogs();

        assertEquals(expectedRes, actualRes);
    }

    @Test
    public void add_several_dogs_return_number_of_dogs_match_number_added() {
        DogHandler cut = new DogHandler(itsDogRepo);

        Dog theDog = new Dog();
        theDog.setName("Bruno");

        Dog theDog2 = new Dog();
        theDog.setName("Bruno");

        cut.addDog(theDog);
        cut.addDog(theDog2);

        int expectedRes = 2;
        long actualRes = cut.getNoOfDogs();

        assertEquals(expectedRes, actualRes);
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
    public void test_updateDogDetails() {
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");

        cut.addDog(theDog);

        theDog.setName("Carl");
        theDog.setId(5);
        cut.updateDogDetails(theDog);

        assertEquals(theDog, cut.getDogByName("Carl"));
    }

    @Test
    public void test_removeDog() {
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setId(100);
        cut.addDog(theDog);

        assertEquals(false, cut.removeDog(100));
    }

    @Test
    public void test_getDogById() {
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        theDog.setId(100);
        cut.addDog(theDog);

        assertEquals(null, cut.getDogById(100));
    }
}
