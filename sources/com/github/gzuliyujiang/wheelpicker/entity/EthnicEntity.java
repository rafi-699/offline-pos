package com.github.gzuliyujiang.wheelpicker.entity;

import com.github.gzuliyujiang.wheelview.contract.TextProvider;
import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class EthnicEntity implements TextProvider, Serializable {
    private static final boolean IS_CHINESE = Locale.getDefault().getDisplayLanguage().contains("中文");
    private String code;
    private String name;
    private String spelling;

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

    public String getSpelling() {
        return this.spelling;
    }

    public void setSpelling(String spelling) {
        this.spelling = spelling;
    }

    @Override // com.github.gzuliyujiang.wheelview.contract.TextProvider
    public String provideText() {
        if (IS_CHINESE) {
            return this.name;
        }
        return this.spelling;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EthnicEntity ethnicEntity = (EthnicEntity) o;
        return Objects.equals(this.code, ethnicEntity.code) || Objects.equals(this.name, ethnicEntity.name) || Objects.equals(this.spelling, ethnicEntity.spelling);
    }

    public int hashCode() {
        return Objects.hash(this.code, this.name, this.spelling);
    }

    public String toString() {
        return "EthnicEntity{code='" + this.code + "', name='" + this.name + "', spelling='" + this.spelling + "'}";
    }
}
