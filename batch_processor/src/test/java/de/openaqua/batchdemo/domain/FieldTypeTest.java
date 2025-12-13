package de.openaqua.batchdemo.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class FieldTypeTest {

    @Test
    public void getType() {
        assertNotEquals(FieldType.INPUT, FieldType.OUTPUT);
    }

}