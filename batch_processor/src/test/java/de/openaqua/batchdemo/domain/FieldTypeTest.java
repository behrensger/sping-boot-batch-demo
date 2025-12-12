package de.openaqua.batchdemo.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class FieldTypeTest {
    @Test
    void getType() {
        assertNotEquals(FieldType.INPUT, FieldType.OUTPUT);
    }
}