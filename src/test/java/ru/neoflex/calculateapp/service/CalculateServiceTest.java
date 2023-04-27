package ru.neoflex.calculateapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.neoflex.calculateapp.exception.NoCorrectDateException;
import ru.neoflex.calculateapp.exception.NoCorrectSumException;
import ru.neoflex.calculateapp.service.impl.CalculateServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CalculateServiceTest {

    private final CalculateService calculateService = new CalculateServiceImpl();

    @ParameterizedTest
    @CsvFileSource(resources = "/calculate_data.csv", delimiter = ';')
    @DisplayName("Проверка расчета отпускных")
    public void calculatePayTest(LocalDate startDate, LocalDate endDate, BigDecimal sum, BigDecimal result) {
        BigDecimal actual = calculateService.calculateVocationPay(startDate, endDate, sum);
        Assertions.assertEquals(result, actual);
    }

    @Test
    @DisplayName("Ожидание ошибки ввода некорректной суммы")
    public void testSumException() {
        Assertions.assertThrows(NoCorrectSumException.class,
                () -> calculateService.calculateVocationPay(LocalDate.of(2022, 1, 1),
                        LocalDate.of(2022, 1, 20),
                        new BigDecimal("0")));
    }

    @Test
    @DisplayName("Ожидание ошибки ввода некорректного диапазона дат")
    public void testDateException() {
        Assertions.assertThrows(NoCorrectDateException.class,
                () -> calculateService.calculateVocationPay(LocalDate.of(2022, 2, 20),
                        LocalDate.of(2022, 1, 20),
                        new BigDecimal("0")));
    }
}
