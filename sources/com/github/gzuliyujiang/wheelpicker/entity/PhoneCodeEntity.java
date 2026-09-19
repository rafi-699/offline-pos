package com.github.gzuliyujiang.wheelpicker.entity;

import com.github.gzuliyujiang.wheelview.contract.TextProvider;
import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class PhoneCodeEntity implements TextProvider, Serializable {
    private static final boolean IS_CHINESE = Locale.getDefault().getDisplayLanguage().contains("中文");
    private String code;
    private String english;
    private String name;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
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
        PhoneCodeEntity phoneCodeEntity = (PhoneCodeEntity) o;
        return Objects.equals(this.code, phoneCodeEntity.code) || Objects.equals(this.name, phoneCodeEntity.name) || Objects.equals(this.english, phoneCodeEntity.english);
    }

    public int hashCode() {
        return Objects.hash(this.code, this.name, this.english);
    }

    public String toString() {
        return "PhoneCodeEntity{code='" + this.code + "', name='" + this.name + "', english" + this.english + "'}";
    }
}
