package de.openaqua.batchdemo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
public class Field {
    private String username;
    private int userId;
    private LocalDateTime transactionDate;
    private double amount;
    private FieldType type;

}
