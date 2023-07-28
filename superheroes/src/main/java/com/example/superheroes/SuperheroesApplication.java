package com.example.superheroes;

import com.example.superheroes.model.Hero;
import com.example.superheroes.practice.Calculator;
import com.example.superheroes.repository.HeroRepository;
import com.example.superheroes.service.HeroService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SuperheroesApplication implements CommandLineRunner {
    @Autowired
    HeroService heroService;

    public static void main(String[] args) {
        SpringApplication.run(SuperheroesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Hero> heroes = heroService.getHeroesStartingWithLetter("C");
        List<Hero> allHeroes = heroService.getAllHeroes();
        List<Hero> lastThreeHeroesByName = heroService.getLastThreeHeroesByName();
        for (Hero hero: heroes){
            System.out.println(hero);
        }
        for (Hero hero: allHeroes){
            System.out.println(hero);
        }
        for (Hero hero: lastThreeHeroesByName){
            System.out.println(hero);
        }
    }

    @PostConstruct
    public void init(){
        System.out.println("Calculator has been created!");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Calculator will be destroyed");
    }
}
