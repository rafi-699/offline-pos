package com.google.common.cache;

/* JADX INFO: loaded from: classes4.dex */
@ElementTypesAreNonnullByDefault
public interface Weigher<K, V> {
    int weigh(K key, V value);
}
