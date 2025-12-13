package de.openaqua.batchdemo.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FieldTest {
    private final LocalDateTime localDateTime = LocalDateTime.now();

    @Test
    public void gettersTest() {
        Field f = Field.builder()
                .userId(100)
                .username("username")
                .amount(101)
                .transactionDate(getTestDate())
                .type(FieldType.INPUT)
                .build();

        assertEquals(100, f.getUserId());
        assertEquals("username", f.getUsername());
        assertEquals(101, f.getAmount());
        assertEquals(getTestDate(), f.getTransactionDate());
        assertEquals(FieldType.INPUT, f.getType());
    }

    LocalDateTime getTestDate() {
        return localDateTime;
    }
}