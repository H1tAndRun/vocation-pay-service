package ru.neoflex.calculateapp.exception;

import java.math.BigDecimal;

public class NoCorrectSumException extends RuntimeException {

    private static final String MESSAGE = "The amount cannot be negative (%s)";

    public NoCorrectSumException(BigDecimal sum) {
        super(String.format(MESSAGE,sum.toString()));
    }
}
