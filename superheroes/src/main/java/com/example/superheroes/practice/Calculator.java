package com.example.superheroes.practice;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Calculator {
    public int addition( int x, int y ) {
        return x + y;
    }

    @PostConstruct
    public void init() {
        System.out.println( "Calculator had been created!!!" );
    }

    @PreDestroy
    public void destroy() {
        System.out.println( "Calculator will be destroyed" );
    }
}
