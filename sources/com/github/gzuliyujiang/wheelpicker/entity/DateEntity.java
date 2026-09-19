package com.github.gzuliyujiang.wheelpicker.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class DateEntity implements Serializable {
    private int day;
    private int month;
    private int year;

    public static DateEntity target(int year, int month, int dayOfMonth) {
        DateEntity dateEntity = new DateEntity();
        dateEntity.setYear(year);
        dateEntity.setMonth(month);
        dateEntity.setDay(dayOfMonth);
        return dateEntity;
    }

    public static DateEntity target(Calendar calendar) {
        return target(calendar.get(1), calendar.get(2) + 1, calendar.get(5));
    }

    public static DateEntity target(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return target(calendar);
    }

    public static DateEntity today() {
        return target(Calendar.getInstance());
    }

    public static DateEntity dayOnFuture(int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, dayOfMonth);
        return target(calendar);
    }

    public static DateEntity monthOnFuture(int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(2, month);
        return target(calendar);
    }

    public static DateEntity yearOnFuture(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(1, year);
        return target(calendar);
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public long toTimeInMillis() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, this.year);
        calendar.set(2, this.month - 1);
        calendar.set(5, this.day);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && getClass() == o.getClass()) {
            DateEntity dateEntity = (DateEntity) o;
            if (this.year == dateEntity.year && this.month == dateEntity.month && this.day == dateEntity.day) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.year), Integer.valueOf(this.month), Integer.valueOf(this.day));
    }

    public String toString() {
        return this.year + "-" + this.month + "-" + this.day;
    }
}
