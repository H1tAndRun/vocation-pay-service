package ru.neoflex.calculateapp.exception;

import java.time.LocalDate;

public class NoCorrectDateException extends RuntimeException {

    private static final String MESSAGE = "The start date (%s) cannot be greater than the end date (%s)";

    public NoCorrectDateException(LocalDate start, LocalDate end) {
        super(String.format(MESSAGE, start, end));
    }
}
