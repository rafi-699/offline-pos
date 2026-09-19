package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes2.dex */
public interface PropertyPreFilter extends SerializeFilter {
    boolean apply(JSONSerializer jSONSerializer, Object obj, String str);
}
