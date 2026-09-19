package com.bleplx.adapter.utils;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class IdGenerator {
    private static HashMap<IdGeneratorKey, Integer> idMap = new HashMap<>();
    private static int nextKey = 0;

    public static int getIdForKey(IdGeneratorKey idGeneratorKey) {
        Integer num = idMap.get(idGeneratorKey);
        if (num != null) {
            return num.intValue();
        }
        HashMap<IdGeneratorKey, Integer> map = idMap;
        int i = nextKey + 1;
        nextKey = i;
        map.put(idGeneratorKey, Integer.valueOf(i));
        return nextKey;
    }

    public static void clear() {
        idMap.clear();
        nextKey = 0;
    }
}
