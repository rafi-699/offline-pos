package com.github.gzuliyujiang.wheelpicker.entity;

import java.io.Serializable;
import java.util.Calendar;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes3.dex */
public class DatimeEntity implements Serializable {
    private DateEntity date;
    private TimeEntity time;

    public static DatimeEntity now() {
        DatimeEntity datimeEntity = new DatimeEntity();
        datimeEntity.setDate(DateEntity.today());
        datimeEntity.setTime(TimeEntity.now());
        return datimeEntity;
    }

    public static DatimeEntity minuteOnFuture(int minute) {
        DatimeEntity datimeEntityNow = now();
        datimeEntityNow.setTime(TimeEntity.minuteOnFuture(minute));
        return datimeEntityNow;
    }

    public static DatimeEntity hourOnFuture(int hour) {
        DatimeEntity datimeEntityNow = now();
        datimeEntityNow.setTime(TimeEntity.hourOnFuture(hour));
        return datimeEntityNow;
    }

    public static DatimeEntity dayOnFuture(int day) {
        DatimeEntity datimeEntityNow = now();
        datimeEntityNow.setDate(DateEntity.dayOnFuture(day));
        return datimeEntityNow;
    }

    public static DatimeEntity monthOnFuture(int month) {
        DatimeEntity datimeEntityNow = now();
        datimeEntityNow.setDate(DateEntity.monthOnFuture(month));
        return datimeEntityNow;
    }

    public static DatimeEntity yearOnFuture(int year) {
        DatimeEntity datimeEntityNow = now();
        datimeEntityNow.setDate(DateEntity.yearOnFuture(year));
        return datimeEntityNow;
    }

    public DateEntity getDate() {
        return this.date;
    }

    public void setDate(DateEntity date) {
        this.date = date;
    }

    public TimeEntity getTime() {
        return this.time;
    }

    public void setTime(TimeEntity time) {
        this.time = time;
    }

    public long toTimeInMillis() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, this.date.getYear());
        calendar.set(2, this.date.getMonth() - 1);
        calendar.set(5, this.date.getDay());
        calendar.set(11, this.time.getHour());
        calendar.set(12, this.time.getMinute());
        calendar.set(13, this.time.getSecond());
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public String toString() {
        return this.date.toString() + StringUtils.SPACE + this.time.toString();
    }
}
