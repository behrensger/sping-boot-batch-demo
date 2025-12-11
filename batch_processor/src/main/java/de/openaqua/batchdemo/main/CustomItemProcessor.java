package de.openaqua.batchdemo.main;

import de.openaqua.batchdemo.domain.Field;
import de.openaqua.batchdemo.domain.Transaction;
import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Transaction, Transaction> {

    public Transaction process(Transaction item) {
        return item;
    }
}