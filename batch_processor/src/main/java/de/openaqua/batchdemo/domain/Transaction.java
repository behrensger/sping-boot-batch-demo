package de.openaqua.batchdemo.domain;

import java.time.LocalDateTime;

@SuppressWarnings("restriction")
//@XmlRootElement(name = "transactionRecord")
@Getter
@Setter
@ToString
public class Transaction {
    private String username;
    private int userId;
    private LocalDateTime transactionDate;
    private double amount;
}
