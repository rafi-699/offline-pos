package com.github.gzuliyujiang.wheelpicker.contract;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface LinkageProvider {
    public static final int INDEX_NO_FOUND = -1;

    int findFirstIndex(Object firstValue);

    int findSecondIndex(int firstIndex, Object secondValue);

    int findThirdIndex(int firstIndex, int secondIndex, Object thirdValue);

    boolean firstLevelVisible();

    List<?> linkageSecondData(int firstIndex);

    List<?> linkageThirdData(int firstIndex, int secondIndex);

    List<?> provideFirstData();

    boolean thirdLevelVisible();
}
