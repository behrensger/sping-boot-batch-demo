package de.openaqua.batchdemo.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {
    private final LocalDateTime localDateTime = LocalDateTime.now();

    @Test
    void gettersTest() {
        Field f = Field.builder()
                .userId(100)
                .username("username")
                .amount(101)
                .transactionDate(getTestDate())
                .build();
        assertEquals(100, f.getUserId());
        assertEquals("username", f.getUsername());
        assertEquals(101, f.getAmount());
        assertEquals(getTestDate(), f.getTransactionDate());

    }

    LocalDateTime getTestDate() {
        return localDateTime;
    }

}