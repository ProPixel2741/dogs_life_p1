package com.example.superheroes.controller;

import com.example.superheroes.model.Hero;
import com.example.superheroes.service.HeroService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HeroController {
    @Autowired
    HeroService heroService;

    /*public List<Hero> GetHeroes() {

        return null;
    }*/

    @GetMapping("/heroes")
    public List<Hero> getAllHeroes() {
        return heroService.getAllHeroes();
    }

    @GetMapping("/heroes/{letter}")
    public List<Hero> getHeroesStartingWithLetter(@PathVariable String letter) {
        //@PathVariable, means to take from endpoint, not regular string
        //http://localhost:8080/heroes/A
        return heroService.getHeroesStartingWithLetter(letter);
    }

    @PostMapping("/heroes")
    public HttpStatus saveNewHero(@RequestBody Hero hero) {
        Hero result = heroService.saveHero(hero);
        if (result == null) {
            return HttpStatus.PRECONDITION_FAILED;
        }
        return HttpStatus.CREATED;
    }
}
