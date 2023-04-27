package ru.neoflex.calculateapp.enumerated;

import java.time.Month;
import java.time.MonthDay;

public enum Holidays {

    NEW_YEAR(MonthDay.of(Month.JANUARY, 1)),
    NEW_YEAR2(MonthDay.of(Month.JANUARY, 2)),
    NEW_YEAR3(MonthDay.of(Month.JANUARY, 3)),
    NEW_YEAR4(MonthDay.of(Month.JANUARY, 4)),
    NEW_YEAR5(MonthDay.of(Month.JANUARY, 5)),
    NEW_YEAR6(MonthDay.of(Month.JANUARY, 6)),
    CHRISTMAS(MonthDay.of(Month.JANUARY, 7)),
    NEW_YEAR8(MonthDay.of(Month.JANUARY, 8)),
    DEFENDER_DAY(MonthDay.of(Month.FEBRUARY, 23)),
    WOMEN_DAY(MonthDay.of(Month.MARCH, 8)),
    LABOR_DAY(MonthDay.of(Month.MAY, 1)),
    VICTORY_DAY(MonthDay.of(Month.MAY, 9)),
    RUSSIA_DAY(MonthDay.of(Month.JUNE, 12)),
    NATIONAL_UNITY_DAY(MonthDay.of(Month.NOVEMBER, 4));

    private final MonthDay monthDay;

    Holidays(MonthDay monthDay) {
        this.monthDay = monthDay;
    }

    public MonthDay getMonthDay() {
        return monthDay;
    }
}
