package de.openaqua.batchdemo.conditionalflow.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@AllArgsConstructor
public class NumberInfo {
    private int number;

    public static NumberInfo from(int number) {
        return new NumberInfo(number);
    }

    public boolean isPositive() {
        return number > 0;
    }

    public boolean isEven() {
        return number % 2 == 0;
    }

}
