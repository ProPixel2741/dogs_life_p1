package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import org.junit.jupiter.api.Test;

import com.db.grad.javaapi.repository.*;

import static org.junit.jupiter.api.Assertions.*;

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

        //act
        cut.addDog( theDog );

        //assert
        assertEquals( 1, cut.getNoOfDogs() );
    }

    @Test
    public void add_several_dogs_return_number_of_dogs_match_number_added() {
        //arrange
        DogHandler cut = new DogHandler( itsDogRepo );
        Dog dog1 = new Dog();
        dog1.setName("Jill");
        Dog dog2 = new Dog();
        dog2.setName("Jack");
        Dog dog3 = new Dog();
        dog3.setName("Cooper");
        Dog dog4 = new Dog();
        dog4.setName("Fluffy");

        //act
        cut.addDog( dog1 );
        cut.addDog( dog2 );
        cut.addDog( dog3 );
        cut.addDog( dog4 );

        //assert
        assertEquals( 4, cut.getNoOfDogs() );
    }

    @Test
    public void add_dog_and_remove_dog_return_number_of_dogs_is_zero() {
        //arrange
        DogHandler cut = new DogHandler( itsDogRepo );
        Dog dog = new Dog();
        dog.setName( "Cooper" );
        cut.addDog( dog );

        //act
        cut.removeDog( 1 );

        //assert
        assertEquals( 0, cut.getNoOfDogs() );
    }

    @Test
    public void add_dog_and_remove_dog_that_does_not_exist_return_number_of_dogs_is_one() {
        //arrange
        DogHandler cut = new DogHandler( itsDogRepo );
        Dog dog = new Dog();
        dog.setName( "Cooper" );
        cut.addDog( dog );

        //act
        cut.removeDog( 2 );

        //assert
        assertEquals( 1, cut.getNoOfDogs() );
    }

    @Test
    public void find_dog_by_valid_id_returns_one_dog() {
        //arrange
        DogHandler cut = new DogHandler( itsDogRepo );
        Dog dog1 = new Dog();
        dog1.setName( "Cooper" );
        cut.addDog( dog1 );
        Dog dog2 = new Dog();
        dog2.setName( "Jill" );
        cut.addDog( dog2 );

        //act
        Dog dog = cut.getDogById( 1 );

        //assert
        assertEquals( dog1, dog );
    }

    @Test
    public void find_dog_by_invalid_id_returns_null_dog() {
        //arrange
        DogHandler cut = new DogHandler( itsDogRepo );
        Dog dog1 = new Dog();
        dog1.setName( "Cooper" );
        cut.addDog( dog1 );
        Dog dog2 = new Dog();
        dog2.setName( "Jill" );
        cut.addDog( dog2 );

        //act
        Dog dog = cut.getDogById( 3 );

        //assert
        assertNull( dog );
    }

    @Test
    public void find_dog_by_name_returns_one_dog() {
        //arrange
        DogHandler cut = new DogHandler( itsDogRepo );
        Dog dog1 = new Dog();
        dog1.setName( "Cooper" );
        cut.addDog( dog1 );
        Dog dog2 = new Dog();
        dog2.setName( "Jill" );
        cut.addDog( dog2 );

        //act
        Dog dog = cut.getDogByName( "Cooper" );

        //assert
        assertEquals( dog1, dog );
    }

    @Test
    public void find_dog_by_name_returns_null_because_many_dogs_with_same_name() {
        //arrange
        DogHandler cut = new DogHandler( itsDogRepo );
        Dog dog1 = new Dog();
        dog1.setName( "Cooper" );
        cut.addDog( dog1 );
        Dog dog2 = new Dog();
        dog2.setName( "Cooper" );
        cut.addDog( dog2 );

        //act
        Dog dog = cut.getDogByName( "Cooper" );
        assertNull( dog );
    }

    @Test
    public void find_dog_by_invalid_name_returns_null_dog() {
        //arrange
        DogHandler cut = new DogHandler( itsDogRepo );
        Dog dog1 = new Dog();
        dog1.setName( "Cooper" );
        cut.addDog( dog1 );
        Dog dog2 = new Dog();
        dog2.setName( "Jill" );
        cut.addDog( dog2 );

        //act
        Dog dog = cut.getDogByName( "Jack" );

        assertNull( dog );
    }

    @Test
    public void update_dog_that_exists_returns_dog_id() {
        //arrange
        DogHandler cut = new DogHandler( itsDogRepo );
        Dog dog1 = new Dog();
        dog1.setName( "Cooper" );
        cut.addDog( dog1 );
        Dog dog2 = new Dog();
        dog2.setName( "Jill" );
        cut.addDog( dog2 );

        //act
        Long result = cut.updateDogDetails( dog1 );

        //assert
        assertEquals( 1, result );
    }

    @Test
    public void remove_dog_that_exists_returns_one_dog() {
        //arrange
        DogHandler cut = new DogHandler( itsDogRepo );
        Dog dog1 = new Dog();
        dog1.setName( "Cooper" );
        cut.addDog( dog1 );
        Dog dog2 = new Dog();
        dog2.setName( "Jill" );
        cut.addDog( dog2 );

        //act
        boolean result = cut.removeDog( 2 );

        //assert
        assertTrue( result );
    }

    @Test
    public void remove_dog_that_does_not_exist_returns_null() {
        //arrange
        DogHandler cut = new DogHandler( itsDogRepo );
        Dog dog1 = new Dog();
        dog1.setName( "Cooper" );
        cut.addDog( dog1 );
        Dog dog2 = new Dog();
        dog2.setName( "Jill" );
        cut.addDog( dog2 );

        //act
        boolean result = cut.removeDog( 3 );

        //assert
        assertFalse( result );
    }
}
