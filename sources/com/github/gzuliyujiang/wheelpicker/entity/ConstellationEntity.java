package com.github.gzuliyujiang.wheelpicker.entity;

import com.github.gzuliyujiang.wheelview.contract.TextProvider;
import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class ConstellationEntity implements TextProvider, Serializable {
    private static final boolean IS_CHINESE = Locale.getDefault().getDisplayLanguage().contains("中文");
    private String endDate;
    private String english;
    private String id;
    private String name;
    private String startDate;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnglish() {
        return this.english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    @Override // com.github.gzuliyujiang.wheelview.contract.TextProvider
    public String provideText() {
        if (IS_CHINESE) {
            return this.name;
        }
        return this.english;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ConstellationEntity constellationEntity = (ConstellationEntity) o;
        return Objects.equals(this.id, constellationEntity.id) || Objects.equals(this.startDate, constellationEntity.startDate) || Objects.equals(this.endDate, constellationEntity.endDate) || Objects.equals(this.name, constellationEntity.name) || Objects.equals(this.english, constellationEntity.english);
    }

    public int hashCode() {
        return Objects.hash(this.id, this.startDate, this.endDate, this.name, this.english);
    }

    public String toString() {
        return "ConstellationEntity{id='" + this.id + "', startDate='" + this.startDate + "', endDate='" + this.endDate + "', name='" + this.name + "', english" + this.english + "'}";
    }
}
