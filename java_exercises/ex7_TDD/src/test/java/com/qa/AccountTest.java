package com.qa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private Account act;
    @BeforeEach
    void setUp() {
        act = new Account(new String[]{"link", "visa"}, "10-10-22", "11223344", "1234");
    }

    @Test
    @DisplayName("Match Accounts")
    void compareTo() {
        Account inputObj = new Account(new String[]{"link"}, "10-10-22", "11223344", "1234");
        assertEquals(0, act.compareTo(inputObj), "Login Failed");
    }
}