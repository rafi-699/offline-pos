package com.github.gzuliyujiang.wheelpicker.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class TimeEntity implements Serializable {
    private int hour;
    private int minute;
    private int second;

    public static TimeEntity target(int hourOfDay, int minute, int second) {
        TimeEntity timeEntity = new TimeEntity();
        timeEntity.setHour(hourOfDay);
        timeEntity.setMinute(minute);
        timeEntity.setSecond(second);
        return timeEntity;
    }

    public static TimeEntity target(Calendar calendar) {
        return target(calendar.get(11), calendar.get(12), calendar.get(13));
    }

    public static TimeEntity target(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return target(calendar);
    }

    public static TimeEntity now() {
        return target(Calendar.getInstance());
    }

    public static TimeEntity minuteOnFuture(int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(12, minute);
        return target(calendar);
    }

    public static TimeEntity hourOnFuture(int hourOfDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(11, hourOfDay);
        return target(calendar);
    }

    public int getHour() {
        return this.hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return this.second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public long toTimeInMillis() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, this.hour);
        calendar.set(12, this.minute);
        calendar.set(13, this.second);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public String toString() {
        return this.hour + ":" + this.minute + ":" + this.second;
    }
}
