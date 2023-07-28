package com.example.superheroes.practice;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Calculator {

    public int addition(int int1, int int2) {
        return int1 + int2;
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Calculator will be destroyed");
    }

    @PostConstruct
    public void init() {
        System.out.println("Calculator has been created!");
    }
}
