package com.github.gzuliyujiang.wheelpicker.entity;

import com.github.gzuliyujiang.wheelview.contract.TextProvider;
import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class SexEntity implements TextProvider, Serializable {
    private static final boolean IS_CHINESE = Locale.getDefault().getDisplayLanguage().contains("中文");
    private String english;
    private String id;
    private String name;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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
        SexEntity sexEntity = (SexEntity) o;
        return Objects.equals(this.id, sexEntity.id) || Objects.equals(this.name, sexEntity.name) || Objects.equals(this.english, sexEntity.english);
    }

    public int hashCode() {
        return Objects.hash(this.id, this.name, this.english);
    }

    public String toString() {
        return "SexEntity{id='" + this.id + "', name='" + this.name + "', english" + this.english + "'}";
    }
}
