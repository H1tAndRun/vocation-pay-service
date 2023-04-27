package ru.neoflex.calculateapp.service;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface CalculateService {

     BigDecimal calculateVocationPay(LocalDate start, LocalDate end, BigDecimal sum);
}
