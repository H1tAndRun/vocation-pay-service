package ru.neoflex.calculateapp.service.impl;

import org.springframework.stereotype.Service;
import ru.neoflex.calculateapp.enumerated.Holidays;
import ru.neoflex.calculateapp.exception.NoCorrectDateException;
import ru.neoflex.calculateapp.exception.NoCorrectSumException;
import ru.neoflex.calculateapp.service.CalculateService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Service
public class CalculateServiceImpl implements CalculateService {

    private static final int COUNT_WORKING_DAY = 247;

    @Override
    public BigDecimal calculateVocationPay(LocalDate start, LocalDate end, BigDecimal sum) {
        checkDate(start, end);
        checkSum(sum);
        long vocationDays = getVocationDays(start, end);
        return sum.divide(new BigDecimal(COUNT_WORKING_DAY), 2, RoundingMode.HALF_UP)
                .multiply(new BigDecimal(vocationDays));
    }

    private long getVocationDays(LocalDate start, LocalDate end) {
        Set<MonthDay> holidays = Arrays.stream(Holidays.values())
                .map(Holidays::getMonthDay)
                .collect(Collectors.toSet());
        long countDaysBetween = ChronoUnit.DAYS.between(start, end) + 1;
        long countWeekend = LongStream.range(0, countDaysBetween)
                .mapToObj(start::plusDays)
                .filter(date -> date.getDayOfWeek().equals(DayOfWeek.SATURDAY)
                        || date.getDayOfWeek().equals(DayOfWeek.SUNDAY)
                        || holidays.contains(MonthDay.from(date)))
                .count();
        return countDaysBetween - countWeekend;
    }

    private void checkDate(LocalDate start, LocalDate end) {
        if (start.isAfter(end)) {
            throw new NoCorrectDateException(start, end);
        }
    }

    private void checkSum(BigDecimal sum) {
        if (sum.compareTo(BigDecimal.ONE) < 0) {
            throw new NoCorrectSumException(sum);
        }
    }
}
