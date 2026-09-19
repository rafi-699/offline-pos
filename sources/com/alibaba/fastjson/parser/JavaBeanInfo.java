package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class JavaBeanInfo {
    final Constructor<?> creatorConstructor;
    public final String[] creatorConstructorParameters;
    final Constructor<?> defaultConstructor;
    final int defaultConstructorParameterSize;
    final Method factoryMethod;
    final FieldInfo[] fields;
    final JSONType jsonType;
    boolean ordered = false;
    public final int parserFeatures;
    final FieldInfo[] sortedFields;
    final boolean supportBeanToArray;
    public final String typeKey;
    public final long typeKeyHashCode;
    public final String typeName;

    JavaBeanInfo(Class<?> cls, Constructor<?> constructor, Constructor<?> constructor2, Method method, FieldInfo[] fieldInfoArr, FieldInfo[] fieldInfoArr2, JSONType jSONType, String[] strArr) {
        int i;
        boolean z;
        int length = 0;
        this.defaultConstructor = constructor;
        this.creatorConstructor = constructor2;
        this.factoryMethod = method;
        this.fields = fieldInfoArr;
        this.jsonType = jSONType;
        if (strArr != null && strArr.length == fieldInfoArr.length) {
            this.creatorConstructorParameters = null;
        } else {
            this.creatorConstructorParameters = strArr;
        }
        if (jSONType != null) {
            String strTypeName = jSONType.typeName();
            this.typeName = strTypeName.length() <= 0 ? cls.getName() : strTypeName;
            String strTypeKey = jSONType.typeKey();
            this.typeKey = strTypeKey.length() > 0 ? strTypeKey : null;
            i = 0;
            for (Feature feature : jSONType.parseFeatures()) {
                i |= feature.mask;
            }
        } else {
            this.typeName = cls.getName();
            this.typeKey = null;
            i = 0;
        }
        String str = this.typeKey;
        if (str == null) {
            this.typeKeyHashCode = 0L;
        } else {
            this.typeKeyHashCode = TypeUtils.fnv_64_lower(str);
        }
        this.parserFeatures = i;
        if (jSONType != null) {
            Feature[] features = jSONType.parseFeatures();
            z = false;
            for (Feature feature2 : features) {
                if (feature2 == Feature.SupportArrayToBean) {
                    z = true;
                }
            }
        } else {
            z = false;
        }
        this.supportBeanToArray = z;
        FieldInfo[] fieldInfoArrComputeSortedFields = computeSortedFields(fieldInfoArr, fieldInfoArr2);
        this.sortedFields = Arrays.equals(fieldInfoArr, fieldInfoArrComputeSortedFields) ? fieldInfoArr : fieldInfoArrComputeSortedFields;
        if (constructor != null) {
            length = constructor.getParameterTypes().length;
        } else if (method != null) {
            length = method.getParameterTypes().length;
        }
        this.defaultConstructorParameterSize = length;
    }

    private FieldInfo[] computeSortedFields(FieldInfo[] fieldInfoArr, FieldInfo[] fieldInfoArr2) {
        String[] strArrOrders;
        JSONType jSONType = this.jsonType;
        if (jSONType != null && (strArrOrders = jSONType.orders()) != null && strArrOrders.length != 0) {
            for (String str : strArrOrders) {
                for (FieldInfo fieldInfo : fieldInfoArr2) {
                    if (fieldInfo.name.equals(str)) {
                    }
                }
                return fieldInfoArr2;
            }
            if (strArrOrders.length == fieldInfoArr.length) {
                for (int i = 0; i < strArrOrders.length; i++) {
                    if (!fieldInfoArr2[i].name.equals(strArrOrders[i])) {
                        FieldInfo[] fieldInfoArr3 = new FieldInfo[fieldInfoArr2.length];
                        for (int i2 = 0; i2 < strArrOrders.length; i2++) {
                            for (int i3 = 0; i3 < fieldInfoArr2.length; i3++) {
                                if (fieldInfoArr2[i3].name.equals(strArrOrders[i2])) {
                                    fieldInfoArr3[i2] = fieldInfoArr2[i3];
                                    break;
                                }
                            }
                        }
                        this.ordered = true;
                        return fieldInfoArr3;
                    }
                }
            } else {
                int length = fieldInfoArr2.length;
                FieldInfo[] fieldInfoArr4 = new FieldInfo[length];
                for (int i4 = 0; i4 < strArrOrders.length; i4++) {
                    for (int i5 = 0; i5 < fieldInfoArr2.length; i5++) {
                        if (fieldInfoArr2[i5].name.equals(strArrOrders[i4])) {
                            fieldInfoArr4[i4] = fieldInfoArr2[i5];
                            break;
                        }
                    }
                }
                int length2 = strArrOrders.length;
                for (int i6 = 0; i6 < fieldInfoArr2.length; i6++) {
                    int i7 = 0;
                    while (true) {
                        if (i7 < length && i7 < length2) {
                            if (fieldInfoArr4[i6].equals(fieldInfoArr2[i7])) {
                                break;
                            }
                            i7++;
                        } else {
                            fieldInfoArr4[length2] = fieldInfoArr2[i6];
                            length2++;
                            break;
                        }
                    }
                }
                this.ordered = true;
            }
        }
        return fieldInfoArr2;
    }

    static boolean addField(List<FieldInfo> list, FieldInfo fieldInfo, boolean z) {
        if (!z) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                FieldInfo fieldInfo2 = list.get(i);
                if (fieldInfo2.name.equals(fieldInfo.name) && (!fieldInfo2.getOnly || fieldInfo.getOnly)) {
                    return false;
                }
            }
        }
        list.add(fieldInfo);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:202:0x03ef  */
    /* JADX WARN: Code duplicated, block: B:220:0x0480 A[PHI: r18 r19 r21 r25 r28
  0x0480: PHI (r18v13 int) = (r5v39 int), (r5v39 int), (r5v39 int), (r18v17 int) binds: [B:219:0x047e, B:235:0x04db, B:237:0x04e5, B:215:0x0432] A[DONT_GENERATE, DONT_INLINE]
  0x0480: PHI (r19v13 int) = (r19v12 int), (r19v12 int), (r19v12 int), (r19v17 int) binds: [B:219:0x047e, B:235:0x04db, B:237:0x04e5, B:215:0x0432] A[DONT_GENERATE, DONT_INLINE]
  0x0480: PHI (r21v14 java.lang.reflect.Field[]) = 
  (r13v8 java.lang.reflect.Field[])
  (r13v8 java.lang.reflect.Field[])
  (r13v8 java.lang.reflect.Field[])
  (r21v20 java.lang.reflect.Field[])
 binds: [B:219:0x047e, B:235:0x04db, B:237:0x04e5, B:215:0x0432] A[DONT_GENERATE, DONT_INLINE]
  0x0480: PHI (r25v4 java.lang.reflect.Constructor<?>) = 
  (r9v20 java.lang.reflect.Constructor<?>)
  (r9v20 java.lang.reflect.Constructor<?>)
  (r9v20 java.lang.reflect.Constructor<?>)
  (r25v6 java.lang.reflect.Constructor<?>)
 binds: [B:219:0x047e, B:235:0x04db, B:237:0x04e5, B:215:0x0432] A[DONT_GENERATE, DONT_INLINE]
  0x0480: PHI (r28v5 java.lang.reflect.Method[]) = 
  (r24v6 java.lang.reflect.Method[])
  (r24v6 java.lang.reflect.Method[])
  (r24v6 java.lang.reflect.Method[])
  (r28v7 java.lang.reflect.Method[])
 binds: [B:219:0x047e, B:235:0x04db, B:237:0x04e5, B:215:0x0432] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:248:0x052b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:249:0x052d  */
    /* JADX WARN: Code duplicated, block: B:250:0x0536  */
    /* JADX WARN: Code duplicated, block: B:252:0x053a  */
    /* JADX WARN: Code duplicated, block: B:254:0x0551  */
    /* JADX WARN: Code duplicated, block: B:255:0x056c  */
    /* JADX WARN: Code duplicated, block: B:257:0x0575  */
    /* JADX WARN: Code duplicated, block: B:258:0x0577  */
    /* JADX WARN: Code duplicated, block: B:261:0x0586  */
    /* JADX WARN: Code duplicated, block: B:277:0x05e6  */
    /* JADX WARN: Code duplicated, block: B:279:0x05ee  */
    /* JADX WARN: Code duplicated, block: B:296:0x0629  */
    /* JADX WARN: Code duplicated, block: B:298:0x062d  */
    /* JADX WARN: Code duplicated, block: B:348:0x071f  */
    /* JADX WARN: Code duplicated, block: B:370:0x05f1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:377:0x0630 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public static JavaBeanInfo build(Class<?> cls, int i, Type type, boolean z, boolean z2, boolean z3, boolean z4, PropertyNamingStrategy propertyNamingStrategy) {
        int i2;
        Constructor<?> constructor;
        boolean z5;
        int i3;
        int i4;
        Method[] methodArr;
        Method method;
        Class<?> cls2;
        Constructor<?> constructor2;
        Field[] fieldArr;
        Method[] methodArr2;
        Constructor<?> constructor3;
        Method method2;
        String[] strArr;
        int i5;
        String[] strArr2;
        Class<?>[] clsArr;
        JSONField jSONField;
        int iOrdinal;
        int i6;
        JSONField jSONField2;
        int i7;
        JSONField jSONField3;
        Method[] methodArr3;
        char c;
        char c2;
        String strName;
        int i8;
        int i9;
        Class<?> returnType;
        int i10;
        int i11;
        int i12;
        String strDecapitalize;
        Field field;
        boolean z6;
        Field field2;
        int i13;
        int iOrdinal2;
        JSONField jSONField4;
        JSONField jSONField5;
        int iOf;
        Constructor<?> declaredConstructor;
        Class<?> cls3 = cls;
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        Constructor<?>[] declaredConstructors = cls3.getDeclaredConstructors();
        boolean zIsKotlin = TypeUtils.isKotlin(cls3);
        int i14 = i & 1024;
        int i15 = 1;
        int i16 = 0;
        if (i14 == 0 && (declaredConstructors.length == 1 || !zIsKotlin)) {
            try {
                declaredConstructor = cls3.getDeclaredConstructor(new Class[0]);
            } catch (Exception unused) {
                declaredConstructor = null;
            }
            if (declaredConstructor != null || !cls3.isMemberClass() || (i & 8) != 0) {
                i2 = i16;
                constructor = declaredConstructor;
                break;
            }
            int length = declaredConstructors.length;
            int i17 = 0;
            while (true) {
                if (i17 >= length) {
                    i2 = i16;
                    constructor = declaredConstructor;
                    break;
                }
                Constructor<?> constructor4 = declaredConstructors[i17];
                Class<?>[] parameterTypes = constructor4.getParameterTypes();
                i2 = i16;
                if (parameterTypes.length == 1 && parameterTypes[i2].equals(cls3.getDeclaringClass())) {
                    constructor = constructor4;
                    break;
                }
                i17++;
                i16 = i2;
            }
        } else {
            i2 = 0;
            constructor = null;
        }
        if (z) {
            z5 = zIsKotlin;
            i3 = i14;
            i4 = 1;
            methodArr = null;
            method = null;
        } else {
            ArrayList arrayList2 = new ArrayList();
            Class<?> superclass = cls3;
            Method method3 = null;
            while (superclass != null && superclass != Object.class) {
                Method[] declaredMethods = superclass.getDeclaredMethods();
                int length2 = declaredMethods.length;
                int i18 = i15;
                int i19 = i2;
                while (i19 < length2) {
                    boolean z7 = zIsKotlin;
                    Method method4 = declaredMethods[i19];
                    int i20 = i14;
                    int modifiers = method4.getModifiers();
                    if ((modifiers & 8) == 0) {
                        if ((modifiers & 2) == 0) {
                            cls2 = superclass;
                            if ((modifiers & 256) == 0 && (modifiers & 4) == 0) {
                                arrayList2.add(method4);
                            }
                        }
                        i19++;
                        zIsKotlin = z7;
                        i14 = i20;
                        superclass = cls2;
                    } else if (method4.isAnnotationPresent(JSONCreator.class)) {
                        if (method3 != null) {
                            throw new JSONException("multi-json creator");
                        }
                        method3 = method4;
                    }
                    cls2 = superclass;
                    i19++;
                    zIsKotlin = z7;
                    i14 = i20;
                    superclass = cls2;
                }
                superclass = superclass.getSuperclass();
                i15 = i18;
            }
            z5 = zIsKotlin;
            i3 = i14;
            i4 = i15;
            Method[] methodArr4 = new Method[arrayList2.size()];
            arrayList2.toArray(methodArr4);
            methodArr = methodArr4;
            method = method3;
        }
        Field[] declaredFields = cls3.getDeclaredFields();
        int i21 = (cls3.isInterface() || i3 != 0) ? i4 : i2;
        Method[] methodArr5 = methodArr;
        if (constructor == null || i21 != 0) {
            int length3 = declaredConstructors.length;
            int i22 = i2;
            while (true) {
                if (i22 >= length3) {
                    constructor2 = null;
                    break;
                }
                Constructor<?> constructor5 = declaredConstructors[i22];
                if (((JSONCreator) constructor5.getAnnotation(JSONCreator.class)) != null) {
                    constructor2 = constructor5;
                    break;
                }
                i22++;
            }
            String str = "illegal json creator";
            if (constructor2 != null) {
                TypeUtils.setAccessible(cls3, constructor2, i);
                Class<?>[] parameterTypes2 = constructor2.getParameterTypes();
                Type[] genericParameterTypes = z4 ? constructor2.getGenericParameterTypes() : parameterTypes2;
                Annotation[][] parameterAnnotations = constructor2.getParameterAnnotations();
                int i23 = i2;
                while (i23 < parameterTypes2.length) {
                    Annotation[] annotationArr = parameterAnnotations[i23];
                    int length4 = annotationArr.length;
                    Class<?>[] clsArr2 = parameterTypes2;
                    int i24 = i2;
                    while (true) {
                        if (i24 >= length4) {
                            i7 = i23;
                            jSONField3 = null;
                            break;
                        }
                        int i25 = i24;
                        Annotation annotation = annotationArr[i25];
                        i7 = i23;
                        if (annotation instanceof JSONField) {
                            jSONField3 = (JSONField) annotation;
                            break;
                        }
                        i24 = i25 + 1;
                        i23 = i7;
                    }
                    if (jSONField3 == null) {
                        throw new JSONException(str);
                    }
                    Method[] methodArr6 = methodArr5;
                    Class<?> cls4 = clsArr2[i7];
                    Type type2 = genericParameterTypes[i7];
                    Field field3 = TypeUtils.getField(cls3, jSONField3.name(), declaredFields, map);
                    if (field3 != null) {
                        TypeUtils.setAccessible(cls3, field3, i);
                    }
                    cls3 = cls;
                    addField(arrayList, new FieldInfo(jSONField3.name(), cls, cls4, type2, field3, jSONField3.ordinal(), SerializerFeature.of(jSONField3.serialzeFeatures())), z);
                    i23 = i7 + 1;
                    str = str;
                    declaredFields = declaredFields;
                    parameterTypes2 = clsArr2;
                    constructor2 = constructor2;
                    methodArr5 = methodArr6;
                }
                fieldArr = declaredFields;
                methodArr2 = methodArr5;
                constructor3 = constructor2;
                int size = arrayList.size();
                FieldInfo[] fieldInfoArr = new FieldInfo[size];
                arrayList.toArray(fieldInfoArr);
                FieldInfo[] fieldInfoArr2 = new FieldInfo[size];
                int i26 = i2;
                System.arraycopy(fieldInfoArr, i26, fieldInfoArr2, i26, size);
                Arrays.sort(fieldInfoArr2);
                if (z2) {
                }
                String[] strArr3 = new String[size];
                for (int i27 = 0; i27 < size; i27++) {
                    strArr3[i27] = fieldInfoArr[i27].name;
                }
                strArr2 = strArr3;
                method2 = method;
                i5 = 0;
            } else {
                fieldArr = declaredFields;
                methodArr2 = methodArr5;
                constructor3 = constructor2;
                if (method != null) {
                    TypeUtils.setAccessible(cls3, method, i);
                    Class<?>[] parameterTypes3 = method.getParameterTypes();
                    if (parameterTypes3.length > 0) {
                        Type[] genericParameterTypes2 = z4 ? method.getGenericParameterTypes() : parameterTypes3;
                        Annotation[][] parameterAnnotations2 = method.getParameterAnnotations();
                        int i28 = 0;
                        while (i28 < parameterTypes3.length) {
                            Annotation[] annotationArr2 = parameterAnnotations2[i28];
                            int length5 = annotationArr2.length;
                            int i29 = 0;
                            while (true) {
                                if (i29 >= length5) {
                                    jSONField2 = null;
                                    break;
                                }
                                Annotation annotation2 = annotationArr2[i29];
                                if (annotation2 instanceof JSONField) {
                                    jSONField2 = (JSONField) annotation2;
                                    break;
                                }
                                i29++;
                            }
                            if (jSONField2 == null) {
                                throw new JSONException("illegal json creator");
                            }
                            JSONField jSONField6 = jSONField2;
                            Class<?> cls5 = cls3;
                            cls3 = cls5;
                            addField(arrayList, new FieldInfo(jSONField6.name(), cls5, parameterTypes3[i28], genericParameterTypes2[i28], TypeUtils.getField(cls3, jSONField2.name(), fieldArr, map), jSONField6.ordinal(), SerializerFeature.of(jSONField6.serialzeFeatures())), z);
                            i28++;
                            parameterTypes3 = parameterTypes3;
                        }
                        int size2 = arrayList.size();
                        FieldInfo[] fieldInfoArr3 = new FieldInfo[size2];
                        arrayList.toArray(fieldInfoArr3);
                        FieldInfo[] fieldInfoArr4 = new FieldInfo[size2];
                        System.arraycopy(fieldInfoArr3, 0, fieldInfoArr4, 0, size2);
                        Arrays.sort(fieldInfoArr4);
                        return new JavaBeanInfo(cls3, null, null, method, fieldInfoArr3, Arrays.equals(fieldInfoArr3, fieldInfoArr4) ? fieldInfoArr3 : fieldInfoArr4, z2 ? (JSONType) cls3.getAnnotation(JSONType.class) : null, null);
                    }
                    method2 = method;
                    strArr = null;
                } else {
                    method2 = method;
                    strArr = null;
                    if (i21 == 0) {
                        if (z5 && declaredConstructors.length > 0) {
                            String[] koltinConstructorParameters = TypeUtils.getKoltinConstructorParameters(cls3);
                            if (koltinConstructorParameters != null) {
                                Constructor<?> constructor6 = constructor3;
                                for (Constructor<?> constructor7 : declaredConstructors) {
                                    Class<?>[] parameterTypes4 = constructor7.getParameterTypes();
                                    if ((parameterTypes4.length <= 0 || !parameterTypes4[parameterTypes4.length - 1].getName().equals("kotlin.jvm.internal.DefaultConstructorMarker")) && (constructor6 == null || constructor6.getParameterTypes().length < parameterTypes4.length)) {
                                        constructor6 = constructor7;
                                    }
                                }
                                constructor6.setAccessible(i4);
                                TypeUtils.setAccessible(cls3, constructor6, i);
                                Class<?>[] parameterTypes5 = constructor6.getParameterTypes();
                                Type[] genericParameterTypes3 = z4 ? constructor6.getGenericParameterTypes() : parameterTypes5;
                                Annotation[][] parameterAnnotations3 = constructor6.getParameterAnnotations();
                                int i30 = 0;
                                while (i30 < parameterTypes5.length) {
                                    String str2 = koltinConstructorParameters[i30];
                                    Annotation[] annotationArr3 = parameterAnnotations3[i30];
                                    int length6 = annotationArr3.length;
                                    int i31 = 0;
                                    while (true) {
                                        if (i31 >= length6) {
                                            clsArr = parameterTypes5;
                                            jSONField = null;
                                            break;
                                        }
                                        Annotation annotation3 = annotationArr3[i31];
                                        clsArr = parameterTypes5;
                                        if (annotation3 instanceof JSONField) {
                                            jSONField = (JSONField) annotation3;
                                            break;
                                        }
                                        i31++;
                                        parameterTypes5 = clsArr;
                                    }
                                    Class<?> cls6 = clsArr[i30];
                                    Type type3 = genericParameterTypes3[i30];
                                    Field field4 = TypeUtils.getField(cls3, str2, fieldArr, map);
                                    if (field4 != null && jSONField == null) {
                                        jSONField = (JSONField) field4.getAnnotation(JSONField.class);
                                    }
                                    if (jSONField != null) {
                                        iOrdinal = jSONField.ordinal();
                                        int iOf2 = SerializerFeature.of(jSONField.serialzeFeatures());
                                        String strName2 = jSONField.name();
                                        if (strName2.length() != 0) {
                                            str2 = strName2;
                                        }
                                        i6 = iOf2;
                                    } else {
                                        iOrdinal = 0;
                                        i6 = 0;
                                    }
                                    cls3 = cls;
                                    addField(arrayList, new FieldInfo(str2, cls, cls6, type3, field4, iOrdinal, i6), z);
                                    i30++;
                                    parameterTypes5 = clsArr;
                                }
                                int size3 = arrayList.size();
                                FieldInfo[] fieldInfoArr5 = new FieldInfo[size3];
                                arrayList.toArray(fieldInfoArr5);
                                FieldInfo[] fieldInfoArr6 = new FieldInfo[size3];
                                i5 = 0;
                                System.arraycopy(fieldInfoArr5, 0, fieldInfoArr6, 0, size3);
                                Arrays.sort(fieldInfoArr6);
                                String[] strArr4 = new String[size3];
                                for (int i32 = 0; i32 < size3; i32++) {
                                    strArr4[i32] = fieldInfoArr5[i32].name;
                                }
                                strArr2 = strArr4;
                                constructor3 = constructor6;
                            } else {
                                throw new JSONException("default constructor not found. " + cls3);
                            }
                        } else {
                            throw new JSONException("default constructor not found. " + cls3);
                        }
                    }
                }
                i5 = 0;
                strArr2 = strArr;
            }
        } else {
            fieldArr = declaredFields;
            methodArr2 = methodArr5;
            method2 = method;
            constructor3 = null;
            i5 = i2;
            strArr2 = null;
        }
        if (constructor != null) {
            TypeUtils.setAccessible(cls3, constructor, i);
        }
        int i33 = 3;
        int i34 = 4;
        if (z) {
            methodArr3 = methodArr2;
        } else {
            Method[] methodArr7 = methodArr2;
            int length7 = methodArr7.length;
            int i35 = i5;
            while (i35 < length7) {
                Method[] methodArr8 = methodArr7;
                Method method5 = methodArr8[i35];
                String name = method5.getName();
                if (name.length() >= i34 && (((returnType = method5.getReturnType()) == Void.TYPE || returnType == method5.getDeclaringClass()) && method5.getParameterTypes().length == 1)) {
                    JSONField supperMethodAnnotation = z3 ? (JSONField) method5.getAnnotation(JSONField.class) : null;
                    if (supperMethodAnnotation == null && z3) {
                        supperMethodAnnotation = TypeUtils.getSupperMethodAnnotation(cls3, method5);
                    }
                    if (supperMethodAnnotation == null) {
                        i10 = i35;
                        i11 = 0;
                        i12 = 0;
                    } else if (supperMethodAnnotation.deserialize()) {
                        int i36 = i35;
                        int iOrdinal3 = supperMethodAnnotation.ordinal();
                        int iOf3 = SerializerFeature.of(supperMethodAnnotation.serialzeFeatures());
                        if (supperMethodAnnotation.name().length() != 0) {
                            constructor = constructor;
                            fieldArr = fieldArr;
                            methodArr8 = methodArr8;
                            i10 = i36;
                            length7 = length7;
                            addField(arrayList, new FieldInfo(supperMethodAnnotation.name(), method5, null, cls3, type, iOrdinal3, iOf3, supperMethodAnnotation, null, z4), z);
                            TypeUtils.setAccessible(cls3, method5, i);
                        } else {
                            i10 = i36;
                            i11 = iOf3;
                            i12 = iOrdinal3;
                        }
                        fieldArr = fieldArr;
                    } else {
                        length7 = length7;
                        i10 = i35;
                        constructor = constructor;
                        methodArr8 = methodArr8;
                    }
                    if (name.startsWith("set")) {
                        char cCharAt = name.charAt(i33);
                        if (Character.isUpperCase(cCharAt)) {
                            if (TypeUtils.compatibleWithJavaBean) {
                                strDecapitalize = TypeUtils.decapitalize(name.substring(i33));
                            } else {
                                strDecapitalize = Character.toLowerCase(name.charAt(i33)) + name.substring(4);
                            }
                            field = TypeUtils.getField(cls3, strDecapitalize, fieldArr, map);
                            if (field == null || method5.getParameterTypes()[0] != Boolean.TYPE) {
                                z6 = true;
                            } else {
                                z6 = true;
                                field = TypeUtils.getField(cls3, "is" + Character.toUpperCase(strDecapitalize.charAt(0)) + strDecapitalize.substring(1), fieldArr, map);
                            }
                            field2 = field;
                            if (field2 == null) {
                                fieldArr = fieldArr;
                                map = map;
                                i13 = i11;
                                iOrdinal2 = i12;
                            } else {
                                if (z3) {
                                    jSONField4 = (JSONField) field2.getAnnotation(JSONField.class);
                                } else {
                                    jSONField4 = null;
                                }
                                if (jSONField4 != null) {
                                    jSONField5 = jSONField4;
                                    iOrdinal2 = jSONField5.ordinal();
                                    iOf = SerializerFeature.of(jSONField5.serialzeFeatures());
                                    if (jSONField5.name().length() != 0) {
                                        fieldArr = fieldArr;
                                        addField(arrayList, new FieldInfo(jSONField5.name(), method5, field2, cls3, type, iOrdinal2, iOf, supperMethodAnnotation, jSONField5, z4), z);
                                        cls3 = cls;
                                    } else {
                                        map = map;
                                        i13 = iOf;
                                        if (supperMethodAnnotation == null) {
                                            fieldArr = fieldArr;
                                            supperMethodAnnotation = jSONField5;
                                        }
                                    }
                                } else {
                                    fieldArr = fieldArr;
                                    map = map;
                                    i13 = i11;
                                    iOrdinal2 = i12;
                                }
                            }
                            fieldArr = fieldArr;
                            if (propertyNamingStrategy != null) {
                                strDecapitalize = propertyNamingStrategy.translate(strDecapitalize);
                            }
                            cls3 = cls;
                            addField(arrayList, new FieldInfo(strDecapitalize, method5, null, cls3, type, iOrdinal2, i13, supperMethodAnnotation, null, z4), z);
                            TypeUtils.setAccessible(cls3, method5, i);
                        } else if (cCharAt == '_') {
                            strDecapitalize = name.substring(4);
                        } else if (cCharAt == 'f') {
                            strDecapitalize = name.substring(i33);
                        } else if (name.length() < 5 || !Character.isUpperCase(name.charAt(4))) {
                            fieldArr = fieldArr;
                        } else {
                            strDecapitalize = TypeUtils.decapitalize(name.substring(i33));
                        }
                        field = TypeUtils.getField(cls3, strDecapitalize, fieldArr, map);
                        if (field == null) {
                        }
                        z6 = true;
                        field2 = field;
                        if (field2 == null) {
                            fieldArr = fieldArr;
                            map = map;
                            i13 = i11;
                            iOrdinal2 = i12;
                        } else {
                            if (z3) {
                                jSONField4 = (JSONField) field2.getAnnotation(JSONField.class);
                            } else {
                                jSONField4 = null;
                            }
                            if (jSONField4 != null) {
                                jSONField5 = jSONField4;
                                iOrdinal2 = jSONField5.ordinal();
                                iOf = SerializerFeature.of(jSONField5.serialzeFeatures());
                                if (jSONField5.name().length() != 0) {
                                    fieldArr = fieldArr;
                                    addField(arrayList, new FieldInfo(jSONField5.name(), method5, field2, cls3, type, iOrdinal2, iOf, supperMethodAnnotation, jSONField5, z4), z);
                                    cls3 = cls;
                                } else {
                                    map = map;
                                    i13 = iOf;
                                    if (supperMethodAnnotation == null) {
                                        fieldArr = fieldArr;
                                        supperMethodAnnotation = jSONField5;
                                    }
                                }
                            } else {
                                fieldArr = fieldArr;
                                map = map;
                                i13 = i11;
                                iOrdinal2 = i12;
                            }
                        }
                        fieldArr = fieldArr;
                        if (propertyNamingStrategy != null) {
                            strDecapitalize = propertyNamingStrategy.translate(strDecapitalize);
                        }
                        cls3 = cls;
                        addField(arrayList, new FieldInfo(strDecapitalize, method5, null, cls3, type, iOrdinal2, i13, supperMethodAnnotation, null, z4), z);
                        TypeUtils.setAccessible(cls3, method5, i);
                    } else {
                        fieldArr = fieldArr;
                    }
                } else {
                    length7 = length7;
                    i10 = i35;
                    constructor = constructor;
                    methodArr8 = methodArr8;
                }
                i35 = i10 + 1;
                length7 = length7;
                map = map;
                constructor = constructor;
                methodArr7 = methodArr8;
                i33 = 3;
                i34 = 4;
                i5 = 0;
            }
            methodArr3 = methodArr7;
        }
        Constructor<?> constructor8 = constructor;
        ArrayList<Field> arrayList3 = new ArrayList(fieldArr.length);
        for (Field field5 : fieldArr) {
            int modifiers2 = field5.getModifiers();
            if ((modifiers2 & 8) == 0) {
                if ((modifiers2 & 16) != 0) {
                    Class<?> type4 = field5.getType();
                    if (Map.class.isAssignableFrom(type4) || Collection.class.isAssignableFrom(type4)) {
                        if ((field5.getModifiers() & 1) != 0) {
                            arrayList3.add(field5);
                        }
                    }
                } else if ((field5.getModifiers() & 1) != 0) {
                    arrayList3.add(field5);
                }
            }
        }
        for (Class<? super Object> superclass2 = cls3.getSuperclass(); superclass2 != null && superclass2 != Object.class; superclass2 = superclass2.getSuperclass()) {
            for (Field field6 : superclass2.getDeclaredFields()) {
                int modifiers3 = field6.getModifiers();
                if ((modifiers3 & 8) == 0) {
                    if ((modifiers3 & 16) != 0) {
                        Class<?> type5 = field6.getType();
                        if (Map.class.isAssignableFrom(type5) || Collection.class.isAssignableFrom(type5)) {
                            if ((modifiers3 & 1) != 0) {
                                arrayList3.add(field6);
                            }
                        }
                    } else if ((modifiers3 & 1) != 0) {
                        arrayList3.add(field6);
                    }
                }
            }
        }
        for (Field field7 : arrayList3) {
            String name2 = field7.getName();
            int size4 = arrayList.size();
            boolean z8 = false;
            for (int i37 = 0; i37 < size4; i37++) {
                if (((FieldInfo) arrayList.get(i37)).name.equals(name2)) {
                    z8 = true;
                }
            }
            if (!z8) {
                JSONField jSONField7 = z3 ? (JSONField) field7.getAnnotation(JSONField.class) : null;
                if (jSONField7 != null) {
                    int iOrdinal4 = jSONField7.ordinal();
                    int iOf4 = SerializerFeature.of(jSONField7.serialzeFeatures());
                    if (jSONField7.name().length() != 0) {
                        name2 = jSONField7.name();
                    }
                    i8 = iOrdinal4;
                    i9 = iOf4;
                } else {
                    i8 = 0;
                    i9 = 0;
                }
                if (propertyNamingStrategy != null) {
                    name2 = propertyNamingStrategy.translate(name2);
                }
                TypeUtils.setAccessible(cls3, field7, i);
                addField(arrayList, new FieldInfo(name2, null, field7, cls3, type, i8, i9, null, jSONField7, z4), z);
                cls3 = cls;
            }
        }
        if (!z) {
            Method[] methodArr9 = methodArr3;
            int length8 = methodArr9.length;
            int i38 = 0;
            while (i38 < length8) {
                Method method6 = methodArr9[i38];
                String name3 = method6.getName();
                if (name3.length() >= 4 && name3.startsWith("get") && Character.isUpperCase(name3.charAt(3)) && method6.getParameterTypes().length == 0) {
                    Class<?> returnType2 = method6.getReturnType();
                    if (Collection.class.isAssignableFrom(returnType2) || Map.class.isAssignableFrom(returnType2)) {
                        JSONField jSONField8 = z3 ? (JSONField) method6.getAnnotation(JSONField.class) : null;
                        if (jSONField8 != null) {
                            strName = jSONField8.name();
                            if (strName.length() > 0) {
                                c = 3;
                                c2 = 4;
                            } else {
                                c = 3;
                                c2 = 4;
                                strName = Character.toLowerCase(name3.charAt(3)) + name3.substring(4);
                            }
                        } else {
                            c = 3;
                            c2 = 4;
                            strName = Character.toLowerCase(name3.charAt(3)) + name3.substring(4);
                        }
                        i38 = i38;
                        addField(arrayList, new FieldInfo(strName, method6, null, cls, type, 0, 0, jSONField8, null, z4), z);
                        TypeUtils.setAccessible(cls, method6, i);
                    }
                    i38++;
                }
                i38++;
            }
        }
        int size5 = arrayList.size();
        FieldInfo[] fieldInfoArr7 = new FieldInfo[size5];
        arrayList.toArray(fieldInfoArr7);
        FieldInfo[] fieldInfoArr8 = new FieldInfo[size5];
        System.arraycopy(fieldInfoArr7, 0, fieldInfoArr8, 0, size5);
        Arrays.sort(fieldInfoArr8);
        return new JavaBeanInfo(cls, constructor8, constructor3, method2, fieldInfoArr7, fieldInfoArr8, z2 ? (JSONType) cls.getAnnotation(JSONType.class) : null, strArr2);
    }
}
