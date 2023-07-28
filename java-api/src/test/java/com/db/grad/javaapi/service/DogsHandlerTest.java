package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import org.junit.jupiter.api.Test;

import com.db.grad.javaapi.repository.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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

        assertEquals( 1, cut.getNoOfDogs() );
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

        assertEquals( 4, cut.getNoOfDogs() );
    }

    @Test
    public void add_dog_and_remove_dog_return_number_of_dogs_is_zero() {
        DogHandler cut = new DogHandler( itsDogRepo );
        Dog dog = new Dog();
        dog.setName( "Cooper" );
        cut.addDog( dog );

        assertEquals( 1, cut.getNoOfDogs() );

        cut.removeDog( 1 );

        assertEquals( 0, cut.getNoOfDogs() );
    }

    @Test
    public void add_dog_and_remove_dog_that_does_not_exist_return_number_of_dogs_is_one() {
        DogHandler cut = new DogHandler( itsDogRepo );
        Dog dog = new Dog();
        dog.setName( "Cooper" );
        cut.addDog( dog );

        assertEquals( 1, cut.getNoOfDogs() );

        cut.removeDog( 2 );

        assertEquals( 1, cut.getNoOfDogs() );
    }

    @Test
    public void find_dog_by_valid_id_returns_one_dog() {
        DogHandler cut = new DogHandler( itsDogRepo );
        Dog dog1 = new Dog();
        dog1.setName( "Cooper" );
        cut.addDog( dog1 );
        Dog dog2 = new Dog();
        dog2.setName( "Jill" );
        cut.addDog( dog2 );

        assertEquals( 2, cut.getNoOfDogs() );
        assertEquals( dog1, cut.getDogById( 1 ) );
    }

    @Test
    public void find_dog_by_invalid_id_returns_null_dog() {
        DogHandler cut = new DogHandler( itsDogRepo );
        Dog dog1 = new Dog();
        dog1.setName( "Cooper" );
        cut.addDog( dog1 );
        Dog dog2 = new Dog();
        dog2.setName( "Jill" );
        cut.addDog( dog2 );

        assertEquals( 2, cut.getNoOfDogs() );
        assertNull( cut.getDogById( 3 ) );
    }

    @Test
    public void find_dog_by_name_returns_one_dog() {
        DogHandler cut = new DogHandler( itsDogRepo );
        Dog dog1 = new Dog();
        dog1.setName( "Cooper" );
        cut.addDog( dog1 );
        Dog dog2 = new Dog();
        dog2.setName( "Jill" );
        cut.addDog( dog2 );

        assertEquals( 2, cut.getNoOfDogs() );
        assertEquals( dog1.getName(), cut.getDogByName( "Cooper" ) );
    }

    @Test
    public void find_dog_by_name_returns_null_because_many_dogs_with_same_name() {
        DogHandler cut = new DogHandler( itsDogRepo );
        Dog dog1 = new Dog();
        dog1.setName( "Cooper" );
        cut.addDog( dog1 );
        Dog dog2 = new Dog();
        dog2.setName( "Cooper" );
        cut.addDog( dog2 );

        assertEquals( 2, cut.getNoOfDogs() );
        assertNull( cut.getDogByName( "Cooper" ) );
    }

    @Test
    public void find_dog_by_invalid_name_returns_null_dog() {
        DogHandler cut = new DogHandler( itsDogRepo );
        Dog dog1 = new Dog();
        dog1.setName( "Cooper" );
        cut.addDog( dog1 );
        Dog dog2 = new Dog();
        dog2.setName( "Jill" );
        cut.addDog( dog2 );

        assertEquals( 2, cut.getNoOfDogs() );
        assertNull( cut.getDogByName( "Jack" ) );
    }

    @Test
    public void update_dog_that_exists_returns_dog_id() {
        DogHandler cut = new DogHandler( itsDogRepo );
        Dog dog1 = new Dog();
        dog1.setName( "Cooper" );
        cut.addDog( dog1 );
        Dog dog2 = new Dog();
        dog2.setName( "Jill" );
        cut.addDog( dog2 );

        assertEquals( 2, cut.getNoOfDogs() );
        assertEquals( 1, cut.updateDogDetails( dog1 ) );
    }

    @Test
    public void update_dog_that_does_not_exist_returns_null() {
        DogHandler cut = new DogHandler( itsDogRepo );
        Dog dog1 = new Dog();
        dog1.setName( "Cooper" );
        cut.addDog( dog1 );
        Dog dog2 = new Dog();
        dog2.setName( "Jill" );
        cut.addDog( dog2 );

        assertEquals( 2, cut.getNoOfDogs() );
        assertEquals( -1, cut.updateDogDetails( dog1 ) );
    }

    @Test
    public void remove_dog_that_exists_returns_one_dog() {
        DogHandler cut = new DogHandler( itsDogRepo );
        Dog dog1 = new Dog();
        dog1.setName( "Cooper" );
        cut.addDog( dog1 );
        Dog dog2 = new Dog();
        dog2.setName( "Jill" );
        cut.addDog( dog2 );

        assertEquals( 2, cut.getNoOfDogs() );
        assertEquals( dog2, cut.removeDog( 2 ) );
    }

    @Test
    public void remove_dog_that_does_not_exist_returns_null() {
        DogHandler cut = new DogHandler( itsDogRepo );
        Dog dog1 = new Dog();
        dog1.setName( "Cooper" );
        cut.addDog( dog1 );
        Dog dog2 = new Dog();
        dog2.setName( "Jill" );
        cut.addDog( dog2 );

        assertEquals( 2, cut.getNoOfDogs() );
        assertNull( cut.removeDog( 2 ) );
    }
}
