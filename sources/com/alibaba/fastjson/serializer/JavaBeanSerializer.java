package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class JavaBeanSerializer implements ObjectSerializer {
    protected int features;
    private final FieldSerializer[] getters;
    private final FieldSerializer[] sortedGetters;
    protected final String typeKey;
    protected final String typeName;
    private static final char[] true_chars = {'t', 'r', 'u', 'e'};
    private static final char[] false_chars = {'f', 'a', 'l', 's', 'e'};

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JavaBeanSerializer(Class<?> cls) {
        this(cls, (PropertyNamingStrategy) null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JavaBeanSerializer(Class<?> cls, PropertyNamingStrategy propertyNamingStrategy) {
        this(cls, cls.getModifiers(), null, false, true, true, true, propertyNamingStrategy);
    }

    public JavaBeanSerializer(Class<?> cls, String... strArr) {
        this(cls, cls.getModifiers(), map(strArr), false, true, true, true, null);
    }

    private static Map<String, String> map(String... strArr) {
        HashMap map = new HashMap();
        for (String str : strArr) {
            map.put(str, str);
        }
        return map;
    }

    public JavaBeanSerializer(Class<?> cls, int i, Map<String, String> map, boolean z, boolean z2, boolean z3, boolean z4, PropertyNamingStrategy propertyNamingStrategy) {
        PropertyNamingStrategy propertyNamingStrategy2;
        String strTypeName;
        String strTypeKey;
        PropertyNamingStrategy propertyNamingStrategyNaming;
        this.features = 0;
        JSONType jSONType = z2 ? (JSONType) cls.getAnnotation(JSONType.class) : null;
        if (jSONType != null) {
            this.features = SerializerFeature.of(jSONType.serialzeFeatures());
            strTypeName = jSONType.typeName();
            if (strTypeName.length() == 0) {
                strTypeName = null;
                strTypeKey = null;
            } else {
                strTypeKey = null;
                for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
                    JSONType jSONType2 = (JSONType) superclass.getAnnotation(JSONType.class);
                    if (jSONType2 == null) {
                        break;
                    }
                    strTypeKey = jSONType2.typeKey();
                    if (strTypeKey.length() != 0) {
                        break;
                    }
                }
                for (Class<?> cls2 : cls.getInterfaces()) {
                    JSONType jSONType3 = (JSONType) cls2.getAnnotation(JSONType.class);
                    if (jSONType3 != null) {
                        strTypeKey = jSONType3.typeKey();
                        if (strTypeKey.length() != 0) {
                            break;
                        }
                    }
                }
                if (strTypeKey != null && strTypeKey.length() == 0) {
                    strTypeKey = null;
                }
            }
            propertyNamingStrategy2 = (propertyNamingStrategy != null || (propertyNamingStrategyNaming = jSONType.naming()) == PropertyNamingStrategy.CamelCase) ? propertyNamingStrategy : propertyNamingStrategyNaming;
        } else {
            propertyNamingStrategy2 = propertyNamingStrategy;
            strTypeName = null;
            strTypeKey = null;
        }
        this.typeName = strTypeName;
        this.typeKey = strTypeKey;
        List<FieldInfo> listComputeGetters = TypeUtils.computeGetters(cls, i, z, jSONType, map, false, z3, z4, propertyNamingStrategy2);
        ArrayList arrayList = new ArrayList();
        Iterator<FieldInfo> it = listComputeGetters.iterator();
        while (it.hasNext()) {
            arrayList.add(new FieldSerializer(it.next()));
        }
        FieldSerializer[] fieldSerializerArr = (FieldSerializer[]) arrayList.toArray(new FieldSerializer[arrayList.size()]);
        this.getters = fieldSerializerArr;
        String[] strArrOrders = jSONType != null ? jSONType.orders() : null;
        if (strArrOrders != null && strArrOrders.length != 0) {
            List<FieldInfo> listComputeGetters2 = TypeUtils.computeGetters(cls, i, z, jSONType, map, true, z3, z4, propertyNamingStrategy2);
            ArrayList arrayList2 = new ArrayList();
            Iterator<FieldInfo> it2 = listComputeGetters2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(new FieldSerializer(it2.next()));
            }
            this.sortedGetters = (FieldSerializer[]) arrayList2.toArray(new FieldSerializer[arrayList2.size()]);
            return;
        }
        FieldSerializer[] fieldSerializerArr2 = new FieldSerializer[fieldSerializerArr.length];
        System.arraycopy(fieldSerializerArr, 0, fieldSerializerArr2, 0, fieldSerializerArr.length);
        Arrays.sort(fieldSerializerArr2);
        if (Arrays.equals(fieldSerializerArr2, fieldSerializerArr)) {
            this.sortedGetters = fieldSerializerArr;
        } else {
            this.sortedGetters = fieldSerializerArr2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:121:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:142:0x0232 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:143:0x0234  */
    /* JADX WARN: Code duplicated, block: B:146:0x023a A[Catch: all -> 0x0670, Exception -> 0x0673, TryCatch #7 {Exception -> 0x0673, all -> 0x0670, blocks: (B:39:0x008b, B:41:0x0093, B:43:0x0097, B:44:0x009b, B:45:0x009f, B:47:0x00aa, B:49:0x00b3, B:50:0x00b9, B:52:0x00c4, B:55:0x00cf, B:57:0x00d8, B:59:0x00dc, B:72:0x0106, B:74:0x010a, B:75:0x0110, B:77:0x0116, B:81:0x0126, B:83:0x012f, B:87:0x013b, B:91:0x0147, B:95:0x0155, B:96:0x016b, B:101:0x018a, B:103:0x018e, B:108:0x0197, B:112:0x01a0, B:113:0x01a4, B:115:0x01aa, B:127:0x01d4, B:129:0x01da, B:144:0x0236, B:146:0x023a, B:155:0x0255, B:156:0x025b, B:158:0x0261, B:170:0x028e, B:172:0x0292, B:181:0x02ad, B:182:0x02b4, B:184:0x02ba, B:191:0x02d7, B:193:0x02db, B:195:0x02e2, B:197:0x02e6, B:198:0x02eb, B:200:0x02ef, B:201:0x02f4, B:202:0x02fa, B:204:0x0300, B:212:0x0320, B:214:0x0334, B:216:0x0342, B:218:0x0346, B:221:0x0350, B:223:0x0354, B:279:0x040e, B:281:0x0414, B:283:0x0418, B:285:0x041c, B:287:0x0420, B:289:0x0424, B:296:0x0436, B:298:0x043a, B:300:0x043e, B:305:0x0451, B:307:0x045a, B:309:0x045e, B:310:0x0462, B:311:0x0467, B:313:0x047a, B:316:0x0481, B:317:0x0486, B:322:0x0493, B:323:0x0496, B:329:0x04a9, B:331:0x04ad, B:333:0x04b3, B:291:0x0428, B:293:0x042c, B:225:0x035a, B:228:0x0364, B:230:0x0372, B:232:0x0376, B:235:0x037f, B:237:0x0383, B:240:0x038d, B:242:0x0395, B:244:0x03a3, B:246:0x03a7, B:249:0x03b0, B:251:0x03b4, B:253:0x03ba, B:254:0x03bf, B:256:0x03c7, B:258:0x03d5, B:260:0x03d9, B:263:0x03e3, B:265:0x03e7, B:267:0x03ed, B:269:0x03f6, B:271:0x03fa, B:174:0x0299, B:176:0x029d, B:177:0x02a2, B:179:0x02a6, B:148:0x0241, B:150:0x0245, B:151:0x024a, B:153:0x024e, B:131:0x01ed, B:133:0x01f1, B:134:0x0204, B:136:0x0208, B:137:0x0219, B:61:0x00e2, B:63:0x00e8, B:67:0x00f1, B:69:0x00f8, B:70:0x0100, B:66:0x00ed), top: B:457:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:148:0x0241 A[Catch: all -> 0x0670, Exception -> 0x0673, TryCatch #7 {Exception -> 0x0673, all -> 0x0670, blocks: (B:39:0x008b, B:41:0x0093, B:43:0x0097, B:44:0x009b, B:45:0x009f, B:47:0x00aa, B:49:0x00b3, B:50:0x00b9, B:52:0x00c4, B:55:0x00cf, B:57:0x00d8, B:59:0x00dc, B:72:0x0106, B:74:0x010a, B:75:0x0110, B:77:0x0116, B:81:0x0126, B:83:0x012f, B:87:0x013b, B:91:0x0147, B:95:0x0155, B:96:0x016b, B:101:0x018a, B:103:0x018e, B:108:0x0197, B:112:0x01a0, B:113:0x01a4, B:115:0x01aa, B:127:0x01d4, B:129:0x01da, B:144:0x0236, B:146:0x023a, B:155:0x0255, B:156:0x025b, B:158:0x0261, B:170:0x028e, B:172:0x0292, B:181:0x02ad, B:182:0x02b4, B:184:0x02ba, B:191:0x02d7, B:193:0x02db, B:195:0x02e2, B:197:0x02e6, B:198:0x02eb, B:200:0x02ef, B:201:0x02f4, B:202:0x02fa, B:204:0x0300, B:212:0x0320, B:214:0x0334, B:216:0x0342, B:218:0x0346, B:221:0x0350, B:223:0x0354, B:279:0x040e, B:281:0x0414, B:283:0x0418, B:285:0x041c, B:287:0x0420, B:289:0x0424, B:296:0x0436, B:298:0x043a, B:300:0x043e, B:305:0x0451, B:307:0x045a, B:309:0x045e, B:310:0x0462, B:311:0x0467, B:313:0x047a, B:316:0x0481, B:317:0x0486, B:322:0x0493, B:323:0x0496, B:329:0x04a9, B:331:0x04ad, B:333:0x04b3, B:291:0x0428, B:293:0x042c, B:225:0x035a, B:228:0x0364, B:230:0x0372, B:232:0x0376, B:235:0x037f, B:237:0x0383, B:240:0x038d, B:242:0x0395, B:244:0x03a3, B:246:0x03a7, B:249:0x03b0, B:251:0x03b4, B:253:0x03ba, B:254:0x03bf, B:256:0x03c7, B:258:0x03d5, B:260:0x03d9, B:263:0x03e3, B:265:0x03e7, B:267:0x03ed, B:269:0x03f6, B:271:0x03fa, B:174:0x0299, B:176:0x029d, B:177:0x02a2, B:179:0x02a6, B:148:0x0241, B:150:0x0245, B:151:0x024a, B:153:0x024e, B:131:0x01ed, B:133:0x01f1, B:134:0x0204, B:136:0x0208, B:137:0x0219, B:61:0x00e2, B:63:0x00e8, B:67:0x00f1, B:69:0x00f8, B:70:0x0100, B:66:0x00ed), top: B:457:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:150:0x0245 A[Catch: all -> 0x0670, Exception -> 0x0673, TryCatch #7 {Exception -> 0x0673, all -> 0x0670, blocks: (B:39:0x008b, B:41:0x0093, B:43:0x0097, B:44:0x009b, B:45:0x009f, B:47:0x00aa, B:49:0x00b3, B:50:0x00b9, B:52:0x00c4, B:55:0x00cf, B:57:0x00d8, B:59:0x00dc, B:72:0x0106, B:74:0x010a, B:75:0x0110, B:77:0x0116, B:81:0x0126, B:83:0x012f, B:87:0x013b, B:91:0x0147, B:95:0x0155, B:96:0x016b, B:101:0x018a, B:103:0x018e, B:108:0x0197, B:112:0x01a0, B:113:0x01a4, B:115:0x01aa, B:127:0x01d4, B:129:0x01da, B:144:0x0236, B:146:0x023a, B:155:0x0255, B:156:0x025b, B:158:0x0261, B:170:0x028e, B:172:0x0292, B:181:0x02ad, B:182:0x02b4, B:184:0x02ba, B:191:0x02d7, B:193:0x02db, B:195:0x02e2, B:197:0x02e6, B:198:0x02eb, B:200:0x02ef, B:201:0x02f4, B:202:0x02fa, B:204:0x0300, B:212:0x0320, B:214:0x0334, B:216:0x0342, B:218:0x0346, B:221:0x0350, B:223:0x0354, B:279:0x040e, B:281:0x0414, B:283:0x0418, B:285:0x041c, B:287:0x0420, B:289:0x0424, B:296:0x0436, B:298:0x043a, B:300:0x043e, B:305:0x0451, B:307:0x045a, B:309:0x045e, B:310:0x0462, B:311:0x0467, B:313:0x047a, B:316:0x0481, B:317:0x0486, B:322:0x0493, B:323:0x0496, B:329:0x04a9, B:331:0x04ad, B:333:0x04b3, B:291:0x0428, B:293:0x042c, B:225:0x035a, B:228:0x0364, B:230:0x0372, B:232:0x0376, B:235:0x037f, B:237:0x0383, B:240:0x038d, B:242:0x0395, B:244:0x03a3, B:246:0x03a7, B:249:0x03b0, B:251:0x03b4, B:253:0x03ba, B:254:0x03bf, B:256:0x03c7, B:258:0x03d5, B:260:0x03d9, B:263:0x03e3, B:265:0x03e7, B:267:0x03ed, B:269:0x03f6, B:271:0x03fa, B:174:0x0299, B:176:0x029d, B:177:0x02a2, B:179:0x02a6, B:148:0x0241, B:150:0x0245, B:151:0x024a, B:153:0x024e, B:131:0x01ed, B:133:0x01f1, B:134:0x0204, B:136:0x0208, B:137:0x0219, B:61:0x00e2, B:63:0x00e8, B:67:0x00f1, B:69:0x00f8, B:70:0x0100, B:66:0x00ed), top: B:457:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:151:0x024a A[Catch: all -> 0x0670, Exception -> 0x0673, TryCatch #7 {Exception -> 0x0673, all -> 0x0670, blocks: (B:39:0x008b, B:41:0x0093, B:43:0x0097, B:44:0x009b, B:45:0x009f, B:47:0x00aa, B:49:0x00b3, B:50:0x00b9, B:52:0x00c4, B:55:0x00cf, B:57:0x00d8, B:59:0x00dc, B:72:0x0106, B:74:0x010a, B:75:0x0110, B:77:0x0116, B:81:0x0126, B:83:0x012f, B:87:0x013b, B:91:0x0147, B:95:0x0155, B:96:0x016b, B:101:0x018a, B:103:0x018e, B:108:0x0197, B:112:0x01a0, B:113:0x01a4, B:115:0x01aa, B:127:0x01d4, B:129:0x01da, B:144:0x0236, B:146:0x023a, B:155:0x0255, B:156:0x025b, B:158:0x0261, B:170:0x028e, B:172:0x0292, B:181:0x02ad, B:182:0x02b4, B:184:0x02ba, B:191:0x02d7, B:193:0x02db, B:195:0x02e2, B:197:0x02e6, B:198:0x02eb, B:200:0x02ef, B:201:0x02f4, B:202:0x02fa, B:204:0x0300, B:212:0x0320, B:214:0x0334, B:216:0x0342, B:218:0x0346, B:221:0x0350, B:223:0x0354, B:279:0x040e, B:281:0x0414, B:283:0x0418, B:285:0x041c, B:287:0x0420, B:289:0x0424, B:296:0x0436, B:298:0x043a, B:300:0x043e, B:305:0x0451, B:307:0x045a, B:309:0x045e, B:310:0x0462, B:311:0x0467, B:313:0x047a, B:316:0x0481, B:317:0x0486, B:322:0x0493, B:323:0x0496, B:329:0x04a9, B:331:0x04ad, B:333:0x04b3, B:291:0x0428, B:293:0x042c, B:225:0x035a, B:228:0x0364, B:230:0x0372, B:232:0x0376, B:235:0x037f, B:237:0x0383, B:240:0x038d, B:242:0x0395, B:244:0x03a3, B:246:0x03a7, B:249:0x03b0, B:251:0x03b4, B:253:0x03ba, B:254:0x03bf, B:256:0x03c7, B:258:0x03d5, B:260:0x03d9, B:263:0x03e3, B:265:0x03e7, B:267:0x03ed, B:269:0x03f6, B:271:0x03fa, B:174:0x0299, B:176:0x029d, B:177:0x02a2, B:179:0x02a6, B:148:0x0241, B:150:0x0245, B:151:0x024a, B:153:0x024e, B:131:0x01ed, B:133:0x01f1, B:134:0x0204, B:136:0x0208, B:137:0x0219, B:61:0x00e2, B:63:0x00e8, B:67:0x00f1, B:69:0x00f8, B:70:0x0100, B:66:0x00ed), top: B:457:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:153:0x024e A[Catch: all -> 0x0670, Exception -> 0x0673, TryCatch #7 {Exception -> 0x0673, all -> 0x0670, blocks: (B:39:0x008b, B:41:0x0093, B:43:0x0097, B:44:0x009b, B:45:0x009f, B:47:0x00aa, B:49:0x00b3, B:50:0x00b9, B:52:0x00c4, B:55:0x00cf, B:57:0x00d8, B:59:0x00dc, B:72:0x0106, B:74:0x010a, B:75:0x0110, B:77:0x0116, B:81:0x0126, B:83:0x012f, B:87:0x013b, B:91:0x0147, B:95:0x0155, B:96:0x016b, B:101:0x018a, B:103:0x018e, B:108:0x0197, B:112:0x01a0, B:113:0x01a4, B:115:0x01aa, B:127:0x01d4, B:129:0x01da, B:144:0x0236, B:146:0x023a, B:155:0x0255, B:156:0x025b, B:158:0x0261, B:170:0x028e, B:172:0x0292, B:181:0x02ad, B:182:0x02b4, B:184:0x02ba, B:191:0x02d7, B:193:0x02db, B:195:0x02e2, B:197:0x02e6, B:198:0x02eb, B:200:0x02ef, B:201:0x02f4, B:202:0x02fa, B:204:0x0300, B:212:0x0320, B:214:0x0334, B:216:0x0342, B:218:0x0346, B:221:0x0350, B:223:0x0354, B:279:0x040e, B:281:0x0414, B:283:0x0418, B:285:0x041c, B:287:0x0420, B:289:0x0424, B:296:0x0436, B:298:0x043a, B:300:0x043e, B:305:0x0451, B:307:0x045a, B:309:0x045e, B:310:0x0462, B:311:0x0467, B:313:0x047a, B:316:0x0481, B:317:0x0486, B:322:0x0493, B:323:0x0496, B:329:0x04a9, B:331:0x04ad, B:333:0x04b3, B:291:0x0428, B:293:0x042c, B:225:0x035a, B:228:0x0364, B:230:0x0372, B:232:0x0376, B:235:0x037f, B:237:0x0383, B:240:0x038d, B:242:0x0395, B:244:0x03a3, B:246:0x03a7, B:249:0x03b0, B:251:0x03b4, B:253:0x03ba, B:254:0x03bf, B:256:0x03c7, B:258:0x03d5, B:260:0x03d9, B:263:0x03e3, B:265:0x03e7, B:267:0x03ed, B:269:0x03f6, B:271:0x03fa, B:174:0x0299, B:176:0x029d, B:177:0x02a2, B:179:0x02a6, B:148:0x0241, B:150:0x0245, B:151:0x024a, B:153:0x024e, B:131:0x01ed, B:133:0x01f1, B:134:0x0204, B:136:0x0208, B:137:0x0219, B:61:0x00e2, B:63:0x00e8, B:67:0x00f1, B:69:0x00f8, B:70:0x0100, B:66:0x00ed), top: B:457:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:154:0x0253  */
    /* JADX WARN: Code duplicated, block: B:158:0x0261 A[Catch: all -> 0x0670, Exception -> 0x0673, TryCatch #7 {Exception -> 0x0673, all -> 0x0670, blocks: (B:39:0x008b, B:41:0x0093, B:43:0x0097, B:44:0x009b, B:45:0x009f, B:47:0x00aa, B:49:0x00b3, B:50:0x00b9, B:52:0x00c4, B:55:0x00cf, B:57:0x00d8, B:59:0x00dc, B:72:0x0106, B:74:0x010a, B:75:0x0110, B:77:0x0116, B:81:0x0126, B:83:0x012f, B:87:0x013b, B:91:0x0147, B:95:0x0155, B:96:0x016b, B:101:0x018a, B:103:0x018e, B:108:0x0197, B:112:0x01a0, B:113:0x01a4, B:115:0x01aa, B:127:0x01d4, B:129:0x01da, B:144:0x0236, B:146:0x023a, B:155:0x0255, B:156:0x025b, B:158:0x0261, B:170:0x028e, B:172:0x0292, B:181:0x02ad, B:182:0x02b4, B:184:0x02ba, B:191:0x02d7, B:193:0x02db, B:195:0x02e2, B:197:0x02e6, B:198:0x02eb, B:200:0x02ef, B:201:0x02f4, B:202:0x02fa, B:204:0x0300, B:212:0x0320, B:214:0x0334, B:216:0x0342, B:218:0x0346, B:221:0x0350, B:223:0x0354, B:279:0x040e, B:281:0x0414, B:283:0x0418, B:285:0x041c, B:287:0x0420, B:289:0x0424, B:296:0x0436, B:298:0x043a, B:300:0x043e, B:305:0x0451, B:307:0x045a, B:309:0x045e, B:310:0x0462, B:311:0x0467, B:313:0x047a, B:316:0x0481, B:317:0x0486, B:322:0x0493, B:323:0x0496, B:329:0x04a9, B:331:0x04ad, B:333:0x04b3, B:291:0x0428, B:293:0x042c, B:225:0x035a, B:228:0x0364, B:230:0x0372, B:232:0x0376, B:235:0x037f, B:237:0x0383, B:240:0x038d, B:242:0x0395, B:244:0x03a3, B:246:0x03a7, B:249:0x03b0, B:251:0x03b4, B:253:0x03ba, B:254:0x03bf, B:256:0x03c7, B:258:0x03d5, B:260:0x03d9, B:263:0x03e3, B:265:0x03e7, B:267:0x03ed, B:269:0x03f6, B:271:0x03fa, B:174:0x0299, B:176:0x029d, B:177:0x02a2, B:179:0x02a6, B:148:0x0241, B:150:0x0245, B:151:0x024a, B:153:0x024e, B:131:0x01ed, B:133:0x01f1, B:134:0x0204, B:136:0x0208, B:137:0x0219, B:61:0x00e2, B:63:0x00e8, B:67:0x00f1, B:69:0x00f8, B:70:0x0100, B:66:0x00ed), top: B:457:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:161:0x0276 A[LOOP:3: B:156:0x025b->B:161:0x0276, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:163:0x027e  */
    /* JADX WARN: Code duplicated, block: B:166:0x0286  */
    /* JADX WARN: Code duplicated, block: B:167:0x0288 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:168:0x028a  */
    /* JADX WARN: Code duplicated, block: B:169:0x028c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:180:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:184:0x02ba A[Catch: all -> 0x0670, Exception -> 0x0673, LOOP:4: B:182:0x02b4->B:184:0x02ba, LOOP_END, TryCatch #7 {Exception -> 0x0673, all -> 0x0670, blocks: (B:39:0x008b, B:41:0x0093, B:43:0x0097, B:44:0x009b, B:45:0x009f, B:47:0x00aa, B:49:0x00b3, B:50:0x00b9, B:52:0x00c4, B:55:0x00cf, B:57:0x00d8, B:59:0x00dc, B:72:0x0106, B:74:0x010a, B:75:0x0110, B:77:0x0116, B:81:0x0126, B:83:0x012f, B:87:0x013b, B:91:0x0147, B:95:0x0155, B:96:0x016b, B:101:0x018a, B:103:0x018e, B:108:0x0197, B:112:0x01a0, B:113:0x01a4, B:115:0x01aa, B:127:0x01d4, B:129:0x01da, B:144:0x0236, B:146:0x023a, B:155:0x0255, B:156:0x025b, B:158:0x0261, B:170:0x028e, B:172:0x0292, B:181:0x02ad, B:182:0x02b4, B:184:0x02ba, B:191:0x02d7, B:193:0x02db, B:195:0x02e2, B:197:0x02e6, B:198:0x02eb, B:200:0x02ef, B:201:0x02f4, B:202:0x02fa, B:204:0x0300, B:212:0x0320, B:214:0x0334, B:216:0x0342, B:218:0x0346, B:221:0x0350, B:223:0x0354, B:279:0x040e, B:281:0x0414, B:283:0x0418, B:285:0x041c, B:287:0x0420, B:289:0x0424, B:296:0x0436, B:298:0x043a, B:300:0x043e, B:305:0x0451, B:307:0x045a, B:309:0x045e, B:310:0x0462, B:311:0x0467, B:313:0x047a, B:316:0x0481, B:317:0x0486, B:322:0x0493, B:323:0x0496, B:329:0x04a9, B:331:0x04ad, B:333:0x04b3, B:291:0x0428, B:293:0x042c, B:225:0x035a, B:228:0x0364, B:230:0x0372, B:232:0x0376, B:235:0x037f, B:237:0x0383, B:240:0x038d, B:242:0x0395, B:244:0x03a3, B:246:0x03a7, B:249:0x03b0, B:251:0x03b4, B:253:0x03ba, B:254:0x03bf, B:256:0x03c7, B:258:0x03d5, B:260:0x03d9, B:263:0x03e3, B:265:0x03e7, B:267:0x03ed, B:269:0x03f6, B:271:0x03fa, B:174:0x0299, B:176:0x029d, B:177:0x02a2, B:179:0x02a6, B:148:0x0241, B:150:0x0245, B:151:0x024a, B:153:0x024e, B:131:0x01ed, B:133:0x01f1, B:134:0x0204, B:136:0x0208, B:137:0x0219, B:61:0x00e2, B:63:0x00e8, B:67:0x00f1, B:69:0x00f8, B:70:0x0100, B:66:0x00ed), top: B:457:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:186:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:189:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:190:0x02d5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:193:0x02db A[Catch: all -> 0x0670, Exception -> 0x0673, TryCatch #7 {Exception -> 0x0673, all -> 0x0670, blocks: (B:39:0x008b, B:41:0x0093, B:43:0x0097, B:44:0x009b, B:45:0x009f, B:47:0x00aa, B:49:0x00b3, B:50:0x00b9, B:52:0x00c4, B:55:0x00cf, B:57:0x00d8, B:59:0x00dc, B:72:0x0106, B:74:0x010a, B:75:0x0110, B:77:0x0116, B:81:0x0126, B:83:0x012f, B:87:0x013b, B:91:0x0147, B:95:0x0155, B:96:0x016b, B:101:0x018a, B:103:0x018e, B:108:0x0197, B:112:0x01a0, B:113:0x01a4, B:115:0x01aa, B:127:0x01d4, B:129:0x01da, B:144:0x0236, B:146:0x023a, B:155:0x0255, B:156:0x025b, B:158:0x0261, B:170:0x028e, B:172:0x0292, B:181:0x02ad, B:182:0x02b4, B:184:0x02ba, B:191:0x02d7, B:193:0x02db, B:195:0x02e2, B:197:0x02e6, B:198:0x02eb, B:200:0x02ef, B:201:0x02f4, B:202:0x02fa, B:204:0x0300, B:212:0x0320, B:214:0x0334, B:216:0x0342, B:218:0x0346, B:221:0x0350, B:223:0x0354, B:279:0x040e, B:281:0x0414, B:283:0x0418, B:285:0x041c, B:287:0x0420, B:289:0x0424, B:296:0x0436, B:298:0x043a, B:300:0x043e, B:305:0x0451, B:307:0x045a, B:309:0x045e, B:310:0x0462, B:311:0x0467, B:313:0x047a, B:316:0x0481, B:317:0x0486, B:322:0x0493, B:323:0x0496, B:329:0x04a9, B:331:0x04ad, B:333:0x04b3, B:291:0x0428, B:293:0x042c, B:225:0x035a, B:228:0x0364, B:230:0x0372, B:232:0x0376, B:235:0x037f, B:237:0x0383, B:240:0x038d, B:242:0x0395, B:244:0x03a3, B:246:0x03a7, B:249:0x03b0, B:251:0x03b4, B:253:0x03ba, B:254:0x03bf, B:256:0x03c7, B:258:0x03d5, B:260:0x03d9, B:263:0x03e3, B:265:0x03e7, B:267:0x03ed, B:269:0x03f6, B:271:0x03fa, B:174:0x0299, B:176:0x029d, B:177:0x02a2, B:179:0x02a6, B:148:0x0241, B:150:0x0245, B:151:0x024a, B:153:0x024e, B:131:0x01ed, B:133:0x01f1, B:134:0x0204, B:136:0x0208, B:137:0x0219, B:61:0x00e2, B:63:0x00e8, B:67:0x00f1, B:69:0x00f8, B:70:0x0100, B:66:0x00ed), top: B:457:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:195:0x02e2 A[Catch: all -> 0x0670, Exception -> 0x0673, TryCatch #7 {Exception -> 0x0673, all -> 0x0670, blocks: (B:39:0x008b, B:41:0x0093, B:43:0x0097, B:44:0x009b, B:45:0x009f, B:47:0x00aa, B:49:0x00b3, B:50:0x00b9, B:52:0x00c4, B:55:0x00cf, B:57:0x00d8, B:59:0x00dc, B:72:0x0106, B:74:0x010a, B:75:0x0110, B:77:0x0116, B:81:0x0126, B:83:0x012f, B:87:0x013b, B:91:0x0147, B:95:0x0155, B:96:0x016b, B:101:0x018a, B:103:0x018e, B:108:0x0197, B:112:0x01a0, B:113:0x01a4, B:115:0x01aa, B:127:0x01d4, B:129:0x01da, B:144:0x0236, B:146:0x023a, B:155:0x0255, B:156:0x025b, B:158:0x0261, B:170:0x028e, B:172:0x0292, B:181:0x02ad, B:182:0x02b4, B:184:0x02ba, B:191:0x02d7, B:193:0x02db, B:195:0x02e2, B:197:0x02e6, B:198:0x02eb, B:200:0x02ef, B:201:0x02f4, B:202:0x02fa, B:204:0x0300, B:212:0x0320, B:214:0x0334, B:216:0x0342, B:218:0x0346, B:221:0x0350, B:223:0x0354, B:279:0x040e, B:281:0x0414, B:283:0x0418, B:285:0x041c, B:287:0x0420, B:289:0x0424, B:296:0x0436, B:298:0x043a, B:300:0x043e, B:305:0x0451, B:307:0x045a, B:309:0x045e, B:310:0x0462, B:311:0x0467, B:313:0x047a, B:316:0x0481, B:317:0x0486, B:322:0x0493, B:323:0x0496, B:329:0x04a9, B:331:0x04ad, B:333:0x04b3, B:291:0x0428, B:293:0x042c, B:225:0x035a, B:228:0x0364, B:230:0x0372, B:232:0x0376, B:235:0x037f, B:237:0x0383, B:240:0x038d, B:242:0x0395, B:244:0x03a3, B:246:0x03a7, B:249:0x03b0, B:251:0x03b4, B:253:0x03ba, B:254:0x03bf, B:256:0x03c7, B:258:0x03d5, B:260:0x03d9, B:263:0x03e3, B:265:0x03e7, B:267:0x03ed, B:269:0x03f6, B:271:0x03fa, B:174:0x0299, B:176:0x029d, B:177:0x02a2, B:179:0x02a6, B:148:0x0241, B:150:0x0245, B:151:0x024a, B:153:0x024e, B:131:0x01ed, B:133:0x01f1, B:134:0x0204, B:136:0x0208, B:137:0x0219, B:61:0x00e2, B:63:0x00e8, B:67:0x00f1, B:69:0x00f8, B:70:0x0100, B:66:0x00ed), top: B:457:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:197:0x02e6 A[Catch: all -> 0x0670, Exception -> 0x0673, TryCatch #7 {Exception -> 0x0673, all -> 0x0670, blocks: (B:39:0x008b, B:41:0x0093, B:43:0x0097, B:44:0x009b, B:45:0x009f, B:47:0x00aa, B:49:0x00b3, B:50:0x00b9, B:52:0x00c4, B:55:0x00cf, B:57:0x00d8, B:59:0x00dc, B:72:0x0106, B:74:0x010a, B:75:0x0110, B:77:0x0116, B:81:0x0126, B:83:0x012f, B:87:0x013b, B:91:0x0147, B:95:0x0155, B:96:0x016b, B:101:0x018a, B:103:0x018e, B:108:0x0197, B:112:0x01a0, B:113:0x01a4, B:115:0x01aa, B:127:0x01d4, B:129:0x01da, B:144:0x0236, B:146:0x023a, B:155:0x0255, B:156:0x025b, B:158:0x0261, B:170:0x028e, B:172:0x0292, B:181:0x02ad, B:182:0x02b4, B:184:0x02ba, B:191:0x02d7, B:193:0x02db, B:195:0x02e2, B:197:0x02e6, B:198:0x02eb, B:200:0x02ef, B:201:0x02f4, B:202:0x02fa, B:204:0x0300, B:212:0x0320, B:214:0x0334, B:216:0x0342, B:218:0x0346, B:221:0x0350, B:223:0x0354, B:279:0x040e, B:281:0x0414, B:283:0x0418, B:285:0x041c, B:287:0x0420, B:289:0x0424, B:296:0x0436, B:298:0x043a, B:300:0x043e, B:305:0x0451, B:307:0x045a, B:309:0x045e, B:310:0x0462, B:311:0x0467, B:313:0x047a, B:316:0x0481, B:317:0x0486, B:322:0x0493, B:323:0x0496, B:329:0x04a9, B:331:0x04ad, B:333:0x04b3, B:291:0x0428, B:293:0x042c, B:225:0x035a, B:228:0x0364, B:230:0x0372, B:232:0x0376, B:235:0x037f, B:237:0x0383, B:240:0x038d, B:242:0x0395, B:244:0x03a3, B:246:0x03a7, B:249:0x03b0, B:251:0x03b4, B:253:0x03ba, B:254:0x03bf, B:256:0x03c7, B:258:0x03d5, B:260:0x03d9, B:263:0x03e3, B:265:0x03e7, B:267:0x03ed, B:269:0x03f6, B:271:0x03fa, B:174:0x0299, B:176:0x029d, B:177:0x02a2, B:179:0x02a6, B:148:0x0241, B:150:0x0245, B:151:0x024a, B:153:0x024e, B:131:0x01ed, B:133:0x01f1, B:134:0x0204, B:136:0x0208, B:137:0x0219, B:61:0x00e2, B:63:0x00e8, B:67:0x00f1, B:69:0x00f8, B:70:0x0100, B:66:0x00ed), top: B:457:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:198:0x02eb A[Catch: all -> 0x0670, Exception -> 0x0673, TryCatch #7 {Exception -> 0x0673, all -> 0x0670, blocks: (B:39:0x008b, B:41:0x0093, B:43:0x0097, B:44:0x009b, B:45:0x009f, B:47:0x00aa, B:49:0x00b3, B:50:0x00b9, B:52:0x00c4, B:55:0x00cf, B:57:0x00d8, B:59:0x00dc, B:72:0x0106, B:74:0x010a, B:75:0x0110, B:77:0x0116, B:81:0x0126, B:83:0x012f, B:87:0x013b, B:91:0x0147, B:95:0x0155, B:96:0x016b, B:101:0x018a, B:103:0x018e, B:108:0x0197, B:112:0x01a0, B:113:0x01a4, B:115:0x01aa, B:127:0x01d4, B:129:0x01da, B:144:0x0236, B:146:0x023a, B:155:0x0255, B:156:0x025b, B:158:0x0261, B:170:0x028e, B:172:0x0292, B:181:0x02ad, B:182:0x02b4, B:184:0x02ba, B:191:0x02d7, B:193:0x02db, B:195:0x02e2, B:197:0x02e6, B:198:0x02eb, B:200:0x02ef, B:201:0x02f4, B:202:0x02fa, B:204:0x0300, B:212:0x0320, B:214:0x0334, B:216:0x0342, B:218:0x0346, B:221:0x0350, B:223:0x0354, B:279:0x040e, B:281:0x0414, B:283:0x0418, B:285:0x041c, B:287:0x0420, B:289:0x0424, B:296:0x0436, B:298:0x043a, B:300:0x043e, B:305:0x0451, B:307:0x045a, B:309:0x045e, B:310:0x0462, B:311:0x0467, B:313:0x047a, B:316:0x0481, B:317:0x0486, B:322:0x0493, B:323:0x0496, B:329:0x04a9, B:331:0x04ad, B:333:0x04b3, B:291:0x0428, B:293:0x042c, B:225:0x035a, B:228:0x0364, B:230:0x0372, B:232:0x0376, B:235:0x037f, B:237:0x0383, B:240:0x038d, B:242:0x0395, B:244:0x03a3, B:246:0x03a7, B:249:0x03b0, B:251:0x03b4, B:253:0x03ba, B:254:0x03bf, B:256:0x03c7, B:258:0x03d5, B:260:0x03d9, B:263:0x03e3, B:265:0x03e7, B:267:0x03ed, B:269:0x03f6, B:271:0x03fa, B:174:0x0299, B:176:0x029d, B:177:0x02a2, B:179:0x02a6, B:148:0x0241, B:150:0x0245, B:151:0x024a, B:153:0x024e, B:131:0x01ed, B:133:0x01f1, B:134:0x0204, B:136:0x0208, B:137:0x0219, B:61:0x00e2, B:63:0x00e8, B:67:0x00f1, B:69:0x00f8, B:70:0x0100, B:66:0x00ed), top: B:457:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:200:0x02ef A[Catch: all -> 0x0670, Exception -> 0x0673, TryCatch #7 {Exception -> 0x0673, all -> 0x0670, blocks: (B:39:0x008b, B:41:0x0093, B:43:0x0097, B:44:0x009b, B:45:0x009f, B:47:0x00aa, B:49:0x00b3, B:50:0x00b9, B:52:0x00c4, B:55:0x00cf, B:57:0x00d8, B:59:0x00dc, B:72:0x0106, B:74:0x010a, B:75:0x0110, B:77:0x0116, B:81:0x0126, B:83:0x012f, B:87:0x013b, B:91:0x0147, B:95:0x0155, B:96:0x016b, B:101:0x018a, B:103:0x018e, B:108:0x0197, B:112:0x01a0, B:113:0x01a4, B:115:0x01aa, B:127:0x01d4, B:129:0x01da, B:144:0x0236, B:146:0x023a, B:155:0x0255, B:156:0x025b, B:158:0x0261, B:170:0x028e, B:172:0x0292, B:181:0x02ad, B:182:0x02b4, B:184:0x02ba, B:191:0x02d7, B:193:0x02db, B:195:0x02e2, B:197:0x02e6, B:198:0x02eb, B:200:0x02ef, B:201:0x02f4, B:202:0x02fa, B:204:0x0300, B:212:0x0320, B:214:0x0334, B:216:0x0342, B:218:0x0346, B:221:0x0350, B:223:0x0354, B:279:0x040e, B:281:0x0414, B:283:0x0418, B:285:0x041c, B:287:0x0420, B:289:0x0424, B:296:0x0436, B:298:0x043a, B:300:0x043e, B:305:0x0451, B:307:0x045a, B:309:0x045e, B:310:0x0462, B:311:0x0467, B:313:0x047a, B:316:0x0481, B:317:0x0486, B:322:0x0493, B:323:0x0496, B:329:0x04a9, B:331:0x04ad, B:333:0x04b3, B:291:0x0428, B:293:0x042c, B:225:0x035a, B:228:0x0364, B:230:0x0372, B:232:0x0376, B:235:0x037f, B:237:0x0383, B:240:0x038d, B:242:0x0395, B:244:0x03a3, B:246:0x03a7, B:249:0x03b0, B:251:0x03b4, B:253:0x03ba, B:254:0x03bf, B:256:0x03c7, B:258:0x03d5, B:260:0x03d9, B:263:0x03e3, B:265:0x03e7, B:267:0x03ed, B:269:0x03f6, B:271:0x03fa, B:174:0x0299, B:176:0x029d, B:177:0x02a2, B:179:0x02a6, B:148:0x0241, B:150:0x0245, B:151:0x024a, B:153:0x024e, B:131:0x01ed, B:133:0x01f1, B:134:0x0204, B:136:0x0208, B:137:0x0219, B:61:0x00e2, B:63:0x00e8, B:67:0x00f1, B:69:0x00f8, B:70:0x0100, B:66:0x00ed), top: B:457:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:204:0x0300 A[Catch: all -> 0x0670, Exception -> 0x0673, TRY_LEAVE, TryCatch #7 {Exception -> 0x0673, all -> 0x0670, blocks: (B:39:0x008b, B:41:0x0093, B:43:0x0097, B:44:0x009b, B:45:0x009f, B:47:0x00aa, B:49:0x00b3, B:50:0x00b9, B:52:0x00c4, B:55:0x00cf, B:57:0x00d8, B:59:0x00dc, B:72:0x0106, B:74:0x010a, B:75:0x0110, B:77:0x0116, B:81:0x0126, B:83:0x012f, B:87:0x013b, B:91:0x0147, B:95:0x0155, B:96:0x016b, B:101:0x018a, B:103:0x018e, B:108:0x0197, B:112:0x01a0, B:113:0x01a4, B:115:0x01aa, B:127:0x01d4, B:129:0x01da, B:144:0x0236, B:146:0x023a, B:155:0x0255, B:156:0x025b, B:158:0x0261, B:170:0x028e, B:172:0x0292, B:181:0x02ad, B:182:0x02b4, B:184:0x02ba, B:191:0x02d7, B:193:0x02db, B:195:0x02e2, B:197:0x02e6, B:198:0x02eb, B:200:0x02ef, B:201:0x02f4, B:202:0x02fa, B:204:0x0300, B:212:0x0320, B:214:0x0334, B:216:0x0342, B:218:0x0346, B:221:0x0350, B:223:0x0354, B:279:0x040e, B:281:0x0414, B:283:0x0418, B:285:0x041c, B:287:0x0420, B:289:0x0424, B:296:0x0436, B:298:0x043a, B:300:0x043e, B:305:0x0451, B:307:0x045a, B:309:0x045e, B:310:0x0462, B:311:0x0467, B:313:0x047a, B:316:0x0481, B:317:0x0486, B:322:0x0493, B:323:0x0496, B:329:0x04a9, B:331:0x04ad, B:333:0x04b3, B:291:0x0428, B:293:0x042c, B:225:0x035a, B:228:0x0364, B:230:0x0372, B:232:0x0376, B:235:0x037f, B:237:0x0383, B:240:0x038d, B:242:0x0395, B:244:0x03a3, B:246:0x03a7, B:249:0x03b0, B:251:0x03b4, B:253:0x03ba, B:254:0x03bf, B:256:0x03c7, B:258:0x03d5, B:260:0x03d9, B:263:0x03e3, B:265:0x03e7, B:267:0x03ed, B:269:0x03f6, B:271:0x03fa, B:174:0x0299, B:176:0x029d, B:177:0x02a2, B:179:0x02a6, B:148:0x0241, B:150:0x0245, B:151:0x024a, B:153:0x024e, B:131:0x01ed, B:133:0x01f1, B:134:0x0204, B:136:0x0208, B:137:0x0219, B:61:0x00e2, B:63:0x00e8, B:67:0x00f1, B:69:0x00f8, B:70:0x0100, B:66:0x00ed), top: B:457:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:207:0x0316  */
    /* JADX WARN: Code duplicated, block: B:210:0x031c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:274:0x0404  */
    /* JADX WARN: Code duplicated, block: B:277:0x040a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:303:0x044d  */
    /* JADX WARN: Code duplicated, block: B:305:0x0451 A[Catch: all -> 0x0670, Exception -> 0x0673, TryCatch #7 {Exception -> 0x0673, all -> 0x0670, blocks: (B:39:0x008b, B:41:0x0093, B:43:0x0097, B:44:0x009b, B:45:0x009f, B:47:0x00aa, B:49:0x00b3, B:50:0x00b9, B:52:0x00c4, B:55:0x00cf, B:57:0x00d8, B:59:0x00dc, B:72:0x0106, B:74:0x010a, B:75:0x0110, B:77:0x0116, B:81:0x0126, B:83:0x012f, B:87:0x013b, B:91:0x0147, B:95:0x0155, B:96:0x016b, B:101:0x018a, B:103:0x018e, B:108:0x0197, B:112:0x01a0, B:113:0x01a4, B:115:0x01aa, B:127:0x01d4, B:129:0x01da, B:144:0x0236, B:146:0x023a, B:155:0x0255, B:156:0x025b, B:158:0x0261, B:170:0x028e, B:172:0x0292, B:181:0x02ad, B:182:0x02b4, B:184:0x02ba, B:191:0x02d7, B:193:0x02db, B:195:0x02e2, B:197:0x02e6, B:198:0x02eb, B:200:0x02ef, B:201:0x02f4, B:202:0x02fa, B:204:0x0300, B:212:0x0320, B:214:0x0334, B:216:0x0342, B:218:0x0346, B:221:0x0350, B:223:0x0354, B:279:0x040e, B:281:0x0414, B:283:0x0418, B:285:0x041c, B:287:0x0420, B:289:0x0424, B:296:0x0436, B:298:0x043a, B:300:0x043e, B:305:0x0451, B:307:0x045a, B:309:0x045e, B:310:0x0462, B:311:0x0467, B:313:0x047a, B:316:0x0481, B:317:0x0486, B:322:0x0493, B:323:0x0496, B:329:0x04a9, B:331:0x04ad, B:333:0x04b3, B:291:0x0428, B:293:0x042c, B:225:0x035a, B:228:0x0364, B:230:0x0372, B:232:0x0376, B:235:0x037f, B:237:0x0383, B:240:0x038d, B:242:0x0395, B:244:0x03a3, B:246:0x03a7, B:249:0x03b0, B:251:0x03b4, B:253:0x03ba, B:254:0x03bf, B:256:0x03c7, B:258:0x03d5, B:260:0x03d9, B:263:0x03e3, B:265:0x03e7, B:267:0x03ed, B:269:0x03f6, B:271:0x03fa, B:174:0x0299, B:176:0x029d, B:177:0x02a2, B:179:0x02a6, B:148:0x0241, B:150:0x0245, B:151:0x024a, B:153:0x024e, B:131:0x01ed, B:133:0x01f1, B:134:0x0204, B:136:0x0208, B:137:0x0219, B:61:0x00e2, B:63:0x00e8, B:67:0x00f1, B:69:0x00f8, B:70:0x0100, B:66:0x00ed), top: B:457:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:307:0x045a A[Catch: all -> 0x0670, Exception -> 0x0673, TryCatch #7 {Exception -> 0x0673, all -> 0x0670, blocks: (B:39:0x008b, B:41:0x0093, B:43:0x0097, B:44:0x009b, B:45:0x009f, B:47:0x00aa, B:49:0x00b3, B:50:0x00b9, B:52:0x00c4, B:55:0x00cf, B:57:0x00d8, B:59:0x00dc, B:72:0x0106, B:74:0x010a, B:75:0x0110, B:77:0x0116, B:81:0x0126, B:83:0x012f, B:87:0x013b, B:91:0x0147, B:95:0x0155, B:96:0x016b, B:101:0x018a, B:103:0x018e, B:108:0x0197, B:112:0x01a0, B:113:0x01a4, B:115:0x01aa, B:127:0x01d4, B:129:0x01da, B:144:0x0236, B:146:0x023a, B:155:0x0255, B:156:0x025b, B:158:0x0261, B:170:0x028e, B:172:0x0292, B:181:0x02ad, B:182:0x02b4, B:184:0x02ba, B:191:0x02d7, B:193:0x02db, B:195:0x02e2, B:197:0x02e6, B:198:0x02eb, B:200:0x02ef, B:201:0x02f4, B:202:0x02fa, B:204:0x0300, B:212:0x0320, B:214:0x0334, B:216:0x0342, B:218:0x0346, B:221:0x0350, B:223:0x0354, B:279:0x040e, B:281:0x0414, B:283:0x0418, B:285:0x041c, B:287:0x0420, B:289:0x0424, B:296:0x0436, B:298:0x043a, B:300:0x043e, B:305:0x0451, B:307:0x045a, B:309:0x045e, B:310:0x0462, B:311:0x0467, B:313:0x047a, B:316:0x0481, B:317:0x0486, B:322:0x0493, B:323:0x0496, B:329:0x04a9, B:331:0x04ad, B:333:0x04b3, B:291:0x0428, B:293:0x042c, B:225:0x035a, B:228:0x0364, B:230:0x0372, B:232:0x0376, B:235:0x037f, B:237:0x0383, B:240:0x038d, B:242:0x0395, B:244:0x03a3, B:246:0x03a7, B:249:0x03b0, B:251:0x03b4, B:253:0x03ba, B:254:0x03bf, B:256:0x03c7, B:258:0x03d5, B:260:0x03d9, B:263:0x03e3, B:265:0x03e7, B:267:0x03ed, B:269:0x03f6, B:271:0x03fa, B:174:0x0299, B:176:0x029d, B:177:0x02a2, B:179:0x02a6, B:148:0x0241, B:150:0x0245, B:151:0x024a, B:153:0x024e, B:131:0x01ed, B:133:0x01f1, B:134:0x0204, B:136:0x0208, B:137:0x0219, B:61:0x00e2, B:63:0x00e8, B:67:0x00f1, B:69:0x00f8, B:70:0x0100, B:66:0x00ed), top: B:457:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:309:0x045e A[Catch: all -> 0x0670, Exception -> 0x0673, TryCatch #7 {Exception -> 0x0673, all -> 0x0670, blocks: (B:39:0x008b, B:41:0x0093, B:43:0x0097, B:44:0x009b, B:45:0x009f, B:47:0x00aa, B:49:0x00b3, B:50:0x00b9, B:52:0x00c4, B:55:0x00cf, B:57:0x00d8, B:59:0x00dc, B:72:0x0106, B:74:0x010a, B:75:0x0110, B:77:0x0116, B:81:0x0126, B:83:0x012f, B:87:0x013b, B:91:0x0147, B:95:0x0155, B:96:0x016b, B:101:0x018a, B:103:0x018e, B:108:0x0197, B:112:0x01a0, B:113:0x01a4, B:115:0x01aa, B:127:0x01d4, B:129:0x01da, B:144:0x0236, B:146:0x023a, B:155:0x0255, B:156:0x025b, B:158:0x0261, B:170:0x028e, B:172:0x0292, B:181:0x02ad, B:182:0x02b4, B:184:0x02ba, B:191:0x02d7, B:193:0x02db, B:195:0x02e2, B:197:0x02e6, B:198:0x02eb, B:200:0x02ef, B:201:0x02f4, B:202:0x02fa, B:204:0x0300, B:212:0x0320, B:214:0x0334, B:216:0x0342, B:218:0x0346, B:221:0x0350, B:223:0x0354, B:279:0x040e, B:281:0x0414, B:283:0x0418, B:285:0x041c, B:287:0x0420, B:289:0x0424, B:296:0x0436, B:298:0x043a, B:300:0x043e, B:305:0x0451, B:307:0x045a, B:309:0x045e, B:310:0x0462, B:311:0x0467, B:313:0x047a, B:316:0x0481, B:317:0x0486, B:322:0x0493, B:323:0x0496, B:329:0x04a9, B:331:0x04ad, B:333:0x04b3, B:291:0x0428, B:293:0x042c, B:225:0x035a, B:228:0x0364, B:230:0x0372, B:232:0x0376, B:235:0x037f, B:237:0x0383, B:240:0x038d, B:242:0x0395, B:244:0x03a3, B:246:0x03a7, B:249:0x03b0, B:251:0x03b4, B:253:0x03ba, B:254:0x03bf, B:256:0x03c7, B:258:0x03d5, B:260:0x03d9, B:263:0x03e3, B:265:0x03e7, B:267:0x03ed, B:269:0x03f6, B:271:0x03fa, B:174:0x0299, B:176:0x029d, B:177:0x02a2, B:179:0x02a6, B:148:0x0241, B:150:0x0245, B:151:0x024a, B:153:0x024e, B:131:0x01ed, B:133:0x01f1, B:134:0x0204, B:136:0x0208, B:137:0x0219, B:61:0x00e2, B:63:0x00e8, B:67:0x00f1, B:69:0x00f8, B:70:0x0100, B:66:0x00ed), top: B:457:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:310:0x0462 A[Catch: all -> 0x0670, Exception -> 0x0673, TryCatch #7 {Exception -> 0x0673, all -> 0x0670, blocks: (B:39:0x008b, B:41:0x0093, B:43:0x0097, B:44:0x009b, B:45:0x009f, B:47:0x00aa, B:49:0x00b3, B:50:0x00b9, B:52:0x00c4, B:55:0x00cf, B:57:0x00d8, B:59:0x00dc, B:72:0x0106, B:74:0x010a, B:75:0x0110, B:77:0x0116, B:81:0x0126, B:83:0x012f, B:87:0x013b, B:91:0x0147, B:95:0x0155, B:96:0x016b, B:101:0x018a, B:103:0x018e, B:108:0x0197, B:112:0x01a0, B:113:0x01a4, B:115:0x01aa, B:127:0x01d4, B:129:0x01da, B:144:0x0236, B:146:0x023a, B:155:0x0255, B:156:0x025b, B:158:0x0261, B:170:0x028e, B:172:0x0292, B:181:0x02ad, B:182:0x02b4, B:184:0x02ba, B:191:0x02d7, B:193:0x02db, B:195:0x02e2, B:197:0x02e6, B:198:0x02eb, B:200:0x02ef, B:201:0x02f4, B:202:0x02fa, B:204:0x0300, B:212:0x0320, B:214:0x0334, B:216:0x0342, B:218:0x0346, B:221:0x0350, B:223:0x0354, B:279:0x040e, B:281:0x0414, B:283:0x0418, B:285:0x041c, B:287:0x0420, B:289:0x0424, B:296:0x0436, B:298:0x043a, B:300:0x043e, B:305:0x0451, B:307:0x045a, B:309:0x045e, B:310:0x0462, B:311:0x0467, B:313:0x047a, B:316:0x0481, B:317:0x0486, B:322:0x0493, B:323:0x0496, B:329:0x04a9, B:331:0x04ad, B:333:0x04b3, B:291:0x0428, B:293:0x042c, B:225:0x035a, B:228:0x0364, B:230:0x0372, B:232:0x0376, B:235:0x037f, B:237:0x0383, B:240:0x038d, B:242:0x0395, B:244:0x03a3, B:246:0x03a7, B:249:0x03b0, B:251:0x03b4, B:253:0x03ba, B:254:0x03bf, B:256:0x03c7, B:258:0x03d5, B:260:0x03d9, B:263:0x03e3, B:265:0x03e7, B:267:0x03ed, B:269:0x03f6, B:271:0x03fa, B:174:0x0299, B:176:0x029d, B:177:0x02a2, B:179:0x02a6, B:148:0x0241, B:150:0x0245, B:151:0x024a, B:153:0x024e, B:131:0x01ed, B:133:0x01f1, B:134:0x0204, B:136:0x0208, B:137:0x0219, B:61:0x00e2, B:63:0x00e8, B:67:0x00f1, B:69:0x00f8, B:70:0x0100, B:66:0x00ed), top: B:457:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:313:0x047a A[Catch: all -> 0x0670, Exception -> 0x0673, TryCatch #7 {Exception -> 0x0673, all -> 0x0670, blocks: (B:39:0x008b, B:41:0x0093, B:43:0x0097, B:44:0x009b, B:45:0x009f, B:47:0x00aa, B:49:0x00b3, B:50:0x00b9, B:52:0x00c4, B:55:0x00cf, B:57:0x00d8, B:59:0x00dc, B:72:0x0106, B:74:0x010a, B:75:0x0110, B:77:0x0116, B:81:0x0126, B:83:0x012f, B:87:0x013b, B:91:0x0147, B:95:0x0155, B:96:0x016b, B:101:0x018a, B:103:0x018e, B:108:0x0197, B:112:0x01a0, B:113:0x01a4, B:115:0x01aa, B:127:0x01d4, B:129:0x01da, B:144:0x0236, B:146:0x023a, B:155:0x0255, B:156:0x025b, B:158:0x0261, B:170:0x028e, B:172:0x0292, B:181:0x02ad, B:182:0x02b4, B:184:0x02ba, B:191:0x02d7, B:193:0x02db, B:195:0x02e2, B:197:0x02e6, B:198:0x02eb, B:200:0x02ef, B:201:0x02f4, B:202:0x02fa, B:204:0x0300, B:212:0x0320, B:214:0x0334, B:216:0x0342, B:218:0x0346, B:221:0x0350, B:223:0x0354, B:279:0x040e, B:281:0x0414, B:283:0x0418, B:285:0x041c, B:287:0x0420, B:289:0x0424, B:296:0x0436, B:298:0x043a, B:300:0x043e, B:305:0x0451, B:307:0x045a, B:309:0x045e, B:310:0x0462, B:311:0x0467, B:313:0x047a, B:316:0x0481, B:317:0x0486, B:322:0x0493, B:323:0x0496, B:329:0x04a9, B:331:0x04ad, B:333:0x04b3, B:291:0x0428, B:293:0x042c, B:225:0x035a, B:228:0x0364, B:230:0x0372, B:232:0x0376, B:235:0x037f, B:237:0x0383, B:240:0x038d, B:242:0x0395, B:244:0x03a3, B:246:0x03a7, B:249:0x03b0, B:251:0x03b4, B:253:0x03ba, B:254:0x03bf, B:256:0x03c7, B:258:0x03d5, B:260:0x03d9, B:263:0x03e3, B:265:0x03e7, B:267:0x03ed, B:269:0x03f6, B:271:0x03fa, B:174:0x0299, B:176:0x029d, B:177:0x02a2, B:179:0x02a6, B:148:0x0241, B:150:0x0245, B:151:0x024a, B:153:0x024e, B:131:0x01ed, B:133:0x01f1, B:134:0x0204, B:136:0x0208, B:137:0x0219, B:61:0x00e2, B:63:0x00e8, B:67:0x00f1, B:69:0x00f8, B:70:0x0100, B:66:0x00ed), top: B:457:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:315:0x047f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:316:0x0481 A[Catch: all -> 0x0670, Exception -> 0x0673, TryCatch #7 {Exception -> 0x0673, all -> 0x0670, blocks: (B:39:0x008b, B:41:0x0093, B:43:0x0097, B:44:0x009b, B:45:0x009f, B:47:0x00aa, B:49:0x00b3, B:50:0x00b9, B:52:0x00c4, B:55:0x00cf, B:57:0x00d8, B:59:0x00dc, B:72:0x0106, B:74:0x010a, B:75:0x0110, B:77:0x0116, B:81:0x0126, B:83:0x012f, B:87:0x013b, B:91:0x0147, B:95:0x0155, B:96:0x016b, B:101:0x018a, B:103:0x018e, B:108:0x0197, B:112:0x01a0, B:113:0x01a4, B:115:0x01aa, B:127:0x01d4, B:129:0x01da, B:144:0x0236, B:146:0x023a, B:155:0x0255, B:156:0x025b, B:158:0x0261, B:170:0x028e, B:172:0x0292, B:181:0x02ad, B:182:0x02b4, B:184:0x02ba, B:191:0x02d7, B:193:0x02db, B:195:0x02e2, B:197:0x02e6, B:198:0x02eb, B:200:0x02ef, B:201:0x02f4, B:202:0x02fa, B:204:0x0300, B:212:0x0320, B:214:0x0334, B:216:0x0342, B:218:0x0346, B:221:0x0350, B:223:0x0354, B:279:0x040e, B:281:0x0414, B:283:0x0418, B:285:0x041c, B:287:0x0420, B:289:0x0424, B:296:0x0436, B:298:0x043a, B:300:0x043e, B:305:0x0451, B:307:0x045a, B:309:0x045e, B:310:0x0462, B:311:0x0467, B:313:0x047a, B:316:0x0481, B:317:0x0486, B:322:0x0493, B:323:0x0496, B:329:0x04a9, B:331:0x04ad, B:333:0x04b3, B:291:0x0428, B:293:0x042c, B:225:0x035a, B:228:0x0364, B:230:0x0372, B:232:0x0376, B:235:0x037f, B:237:0x0383, B:240:0x038d, B:242:0x0395, B:244:0x03a3, B:246:0x03a7, B:249:0x03b0, B:251:0x03b4, B:253:0x03ba, B:254:0x03bf, B:256:0x03c7, B:258:0x03d5, B:260:0x03d9, B:263:0x03e3, B:265:0x03e7, B:267:0x03ed, B:269:0x03f6, B:271:0x03fa, B:174:0x0299, B:176:0x029d, B:177:0x02a2, B:179:0x02a6, B:148:0x0241, B:150:0x0245, B:151:0x024a, B:153:0x024e, B:131:0x01ed, B:133:0x01f1, B:134:0x0204, B:136:0x0208, B:137:0x0219, B:61:0x00e2, B:63:0x00e8, B:67:0x00f1, B:69:0x00f8, B:70:0x0100, B:66:0x00ed), top: B:457:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:320:0x048f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:321:0x0491 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:322:0x0493 A[Catch: all -> 0x0670, Exception -> 0x0673, TryCatch #7 {Exception -> 0x0673, all -> 0x0670, blocks: (B:39:0x008b, B:41:0x0093, B:43:0x0097, B:44:0x009b, B:45:0x009f, B:47:0x00aa, B:49:0x00b3, B:50:0x00b9, B:52:0x00c4, B:55:0x00cf, B:57:0x00d8, B:59:0x00dc, B:72:0x0106, B:74:0x010a, B:75:0x0110, B:77:0x0116, B:81:0x0126, B:83:0x012f, B:87:0x013b, B:91:0x0147, B:95:0x0155, B:96:0x016b, B:101:0x018a, B:103:0x018e, B:108:0x0197, B:112:0x01a0, B:113:0x01a4, B:115:0x01aa, B:127:0x01d4, B:129:0x01da, B:144:0x0236, B:146:0x023a, B:155:0x0255, B:156:0x025b, B:158:0x0261, B:170:0x028e, B:172:0x0292, B:181:0x02ad, B:182:0x02b4, B:184:0x02ba, B:191:0x02d7, B:193:0x02db, B:195:0x02e2, B:197:0x02e6, B:198:0x02eb, B:200:0x02ef, B:201:0x02f4, B:202:0x02fa, B:204:0x0300, B:212:0x0320, B:214:0x0334, B:216:0x0342, B:218:0x0346, B:221:0x0350, B:223:0x0354, B:279:0x040e, B:281:0x0414, B:283:0x0418, B:285:0x041c, B:287:0x0420, B:289:0x0424, B:296:0x0436, B:298:0x043a, B:300:0x043e, B:305:0x0451, B:307:0x045a, B:309:0x045e, B:310:0x0462, B:311:0x0467, B:313:0x047a, B:316:0x0481, B:317:0x0486, B:322:0x0493, B:323:0x0496, B:329:0x04a9, B:331:0x04ad, B:333:0x04b3, B:291:0x0428, B:293:0x042c, B:225:0x035a, B:228:0x0364, B:230:0x0372, B:232:0x0376, B:235:0x037f, B:237:0x0383, B:240:0x038d, B:242:0x0395, B:244:0x03a3, B:246:0x03a7, B:249:0x03b0, B:251:0x03b4, B:253:0x03ba, B:254:0x03bf, B:256:0x03c7, B:258:0x03d5, B:260:0x03d9, B:263:0x03e3, B:265:0x03e7, B:267:0x03ed, B:269:0x03f6, B:271:0x03fa, B:174:0x0299, B:176:0x029d, B:177:0x02a2, B:179:0x02a6, B:148:0x0241, B:150:0x0245, B:151:0x024a, B:153:0x024e, B:131:0x01ed, B:133:0x01f1, B:134:0x0204, B:136:0x0208, B:137:0x0219, B:61:0x00e2, B:63:0x00e8, B:67:0x00f1, B:69:0x00f8, B:70:0x0100, B:66:0x00ed), top: B:457:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:325:0x049a  */
    /* JADX WARN: Code duplicated, block: B:326:0x049c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:327:0x049e A[Catch: all -> 0x05fe, Exception -> 0x0603, TRY_ENTER, TRY_LEAVE, TryCatch #5 {Exception -> 0x0603, all -> 0x05fe, blocks: (B:98:0x016e, B:106:0x0193, B:124:0x01ce, B:327:0x049e, B:337:0x04d7, B:139:0x0220), top: B:461:0x016e }] */
    /* JADX WARN: Code duplicated, block: B:329:0x04a9 A[Catch: all -> 0x0670, Exception -> 0x0673, TRY_ENTER, TryCatch #7 {Exception -> 0x0673, all -> 0x0670, blocks: (B:39:0x008b, B:41:0x0093, B:43:0x0097, B:44:0x009b, B:45:0x009f, B:47:0x00aa, B:49:0x00b3, B:50:0x00b9, B:52:0x00c4, B:55:0x00cf, B:57:0x00d8, B:59:0x00dc, B:72:0x0106, B:74:0x010a, B:75:0x0110, B:77:0x0116, B:81:0x0126, B:83:0x012f, B:87:0x013b, B:91:0x0147, B:95:0x0155, B:96:0x016b, B:101:0x018a, B:103:0x018e, B:108:0x0197, B:112:0x01a0, B:113:0x01a4, B:115:0x01aa, B:127:0x01d4, B:129:0x01da, B:144:0x0236, B:146:0x023a, B:155:0x0255, B:156:0x025b, B:158:0x0261, B:170:0x028e, B:172:0x0292, B:181:0x02ad, B:182:0x02b4, B:184:0x02ba, B:191:0x02d7, B:193:0x02db, B:195:0x02e2, B:197:0x02e6, B:198:0x02eb, B:200:0x02ef, B:201:0x02f4, B:202:0x02fa, B:204:0x0300, B:212:0x0320, B:214:0x0334, B:216:0x0342, B:218:0x0346, B:221:0x0350, B:223:0x0354, B:279:0x040e, B:281:0x0414, B:283:0x0418, B:285:0x041c, B:287:0x0420, B:289:0x0424, B:296:0x0436, B:298:0x043a, B:300:0x043e, B:305:0x0451, B:307:0x045a, B:309:0x045e, B:310:0x0462, B:311:0x0467, B:313:0x047a, B:316:0x0481, B:317:0x0486, B:322:0x0493, B:323:0x0496, B:329:0x04a9, B:331:0x04ad, B:333:0x04b3, B:291:0x0428, B:293:0x042c, B:225:0x035a, B:228:0x0364, B:230:0x0372, B:232:0x0376, B:235:0x037f, B:237:0x0383, B:240:0x038d, B:242:0x0395, B:244:0x03a3, B:246:0x03a7, B:249:0x03b0, B:251:0x03b4, B:253:0x03ba, B:254:0x03bf, B:256:0x03c7, B:258:0x03d5, B:260:0x03d9, B:263:0x03e3, B:265:0x03e7, B:267:0x03ed, B:269:0x03f6, B:271:0x03fa, B:174:0x0299, B:176:0x029d, B:177:0x02a2, B:179:0x02a6, B:148:0x0241, B:150:0x0245, B:151:0x024a, B:153:0x024e, B:131:0x01ed, B:133:0x01f1, B:134:0x0204, B:136:0x0208, B:137:0x0219, B:61:0x00e2, B:63:0x00e8, B:67:0x00f1, B:69:0x00f8, B:70:0x0100, B:66:0x00ed), top: B:457:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:331:0x04ad A[Catch: all -> 0x0670, Exception -> 0x0673, TryCatch #7 {Exception -> 0x0673, all -> 0x0670, blocks: (B:39:0x008b, B:41:0x0093, B:43:0x0097, B:44:0x009b, B:45:0x009f, B:47:0x00aa, B:49:0x00b3, B:50:0x00b9, B:52:0x00c4, B:55:0x00cf, B:57:0x00d8, B:59:0x00dc, B:72:0x0106, B:74:0x010a, B:75:0x0110, B:77:0x0116, B:81:0x0126, B:83:0x012f, B:87:0x013b, B:91:0x0147, B:95:0x0155, B:96:0x016b, B:101:0x018a, B:103:0x018e, B:108:0x0197, B:112:0x01a0, B:113:0x01a4, B:115:0x01aa, B:127:0x01d4, B:129:0x01da, B:144:0x0236, B:146:0x023a, B:155:0x0255, B:156:0x025b, B:158:0x0261, B:170:0x028e, B:172:0x0292, B:181:0x02ad, B:182:0x02b4, B:184:0x02ba, B:191:0x02d7, B:193:0x02db, B:195:0x02e2, B:197:0x02e6, B:198:0x02eb, B:200:0x02ef, B:201:0x02f4, B:202:0x02fa, B:204:0x0300, B:212:0x0320, B:214:0x0334, B:216:0x0342, B:218:0x0346, B:221:0x0350, B:223:0x0354, B:279:0x040e, B:281:0x0414, B:283:0x0418, B:285:0x041c, B:287:0x0420, B:289:0x0424, B:296:0x0436, B:298:0x043a, B:300:0x043e, B:305:0x0451, B:307:0x045a, B:309:0x045e, B:310:0x0462, B:311:0x0467, B:313:0x047a, B:316:0x0481, B:317:0x0486, B:322:0x0493, B:323:0x0496, B:329:0x04a9, B:331:0x04ad, B:333:0x04b3, B:291:0x0428, B:293:0x042c, B:225:0x035a, B:228:0x0364, B:230:0x0372, B:232:0x0376, B:235:0x037f, B:237:0x0383, B:240:0x038d, B:242:0x0395, B:244:0x03a3, B:246:0x03a7, B:249:0x03b0, B:251:0x03b4, B:253:0x03ba, B:254:0x03bf, B:256:0x03c7, B:258:0x03d5, B:260:0x03d9, B:263:0x03e3, B:265:0x03e7, B:267:0x03ed, B:269:0x03f6, B:271:0x03fa, B:174:0x0299, B:176:0x029d, B:177:0x02a2, B:179:0x02a6, B:148:0x0241, B:150:0x0245, B:151:0x024a, B:153:0x024e, B:131:0x01ed, B:133:0x01f1, B:134:0x0204, B:136:0x0208, B:137:0x0219, B:61:0x00e2, B:63:0x00e8, B:67:0x00f1, B:69:0x00f8, B:70:0x0100, B:66:0x00ed), top: B:457:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:332:0x04b1  */
    /* JADX WARN: Code duplicated, block: B:336:0x04d5  */
    /* JADX WARN: Code duplicated, block: B:340:0x04e3 A[Catch: all -> 0x0668, Exception -> 0x066c, TryCatch #6 {Exception -> 0x066c, all -> 0x0668, blocks: (B:410:0x05e3, B:339:0x04db, B:344:0x04ef, B:348:0x04f9, B:353:0x0506, B:355:0x050c, B:357:0x0510, B:358:0x0512, B:360:0x051a, B:362:0x051e, B:363:0x0522, B:366:0x0532, B:367:0x053b, B:368:0x0540, B:370:0x0544, B:371:0x054c, B:374:0x0552, B:375:0x055c, B:380:0x056e, B:382:0x0575, B:384:0x057e, B:387:0x0586, B:388:0x058a, B:389:0x058e, B:391:0x0592, B:392:0x0596, B:393:0x059c, B:396:0x05a2, B:398:0x05ab, B:403:0x05bf, B:404:0x05c3, B:405:0x05c8, B:406:0x05d3, B:407:0x05d8, B:408:0x05dd, B:340:0x04e3, B:415:0x0608, B:420:0x0618, B:421:0x061e, B:423:0x0624, B:424:0x062f, B:426:0x0632, B:428:0x063b, B:429:0x0641, B:431:0x064c, B:433:0x0650, B:434:0x0654, B:436:0x065b), top: B:459:0x05e3 }] */
    /* JADX WARN: Code duplicated, block: B:341:0x04e9  */
    /* JADX WARN: Code duplicated, block: B:343:0x04ed A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:377:0x0568 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:378:0x056a  */
    /* JADX WARN: Code duplicated, block: B:380:0x056e A[Catch: all -> 0x0668, Exception -> 0x066c, TryCatch #6 {Exception -> 0x066c, all -> 0x0668, blocks: (B:410:0x05e3, B:339:0x04db, B:344:0x04ef, B:348:0x04f9, B:353:0x0506, B:355:0x050c, B:357:0x0510, B:358:0x0512, B:360:0x051a, B:362:0x051e, B:363:0x0522, B:366:0x0532, B:367:0x053b, B:368:0x0540, B:370:0x0544, B:371:0x054c, B:374:0x0552, B:375:0x055c, B:380:0x056e, B:382:0x0575, B:384:0x057e, B:387:0x0586, B:388:0x058a, B:389:0x058e, B:391:0x0592, B:392:0x0596, B:393:0x059c, B:396:0x05a2, B:398:0x05ab, B:403:0x05bf, B:404:0x05c3, B:405:0x05c8, B:406:0x05d3, B:407:0x05d8, B:408:0x05dd, B:340:0x04e3, B:415:0x0608, B:420:0x0618, B:421:0x061e, B:423:0x0624, B:424:0x062f, B:426:0x0632, B:428:0x063b, B:429:0x0641, B:431:0x064c, B:433:0x0650, B:434:0x0654, B:436:0x065b), top: B:459:0x05e3 }] */
    /* JADX WARN: Code duplicated, block: B:382:0x0575 A[Catch: all -> 0x0668, Exception -> 0x066c, TryCatch #6 {Exception -> 0x066c, all -> 0x0668, blocks: (B:410:0x05e3, B:339:0x04db, B:344:0x04ef, B:348:0x04f9, B:353:0x0506, B:355:0x050c, B:357:0x0510, B:358:0x0512, B:360:0x051a, B:362:0x051e, B:363:0x0522, B:366:0x0532, B:367:0x053b, B:368:0x0540, B:370:0x0544, B:371:0x054c, B:374:0x0552, B:375:0x055c, B:380:0x056e, B:382:0x0575, B:384:0x057e, B:387:0x0586, B:388:0x058a, B:389:0x058e, B:391:0x0592, B:392:0x0596, B:393:0x059c, B:396:0x05a2, B:398:0x05ab, B:403:0x05bf, B:404:0x05c3, B:405:0x05c8, B:406:0x05d3, B:407:0x05d8, B:408:0x05dd, B:340:0x04e3, B:415:0x0608, B:420:0x0618, B:421:0x061e, B:423:0x0624, B:424:0x062f, B:426:0x0632, B:428:0x063b, B:429:0x0641, B:431:0x064c, B:433:0x0650, B:434:0x0654, B:436:0x065b), top: B:459:0x05e3 }] */
    /* JADX WARN: Code duplicated, block: B:384:0x057e A[Catch: all -> 0x0668, Exception -> 0x066c, TryCatch #6 {Exception -> 0x066c, all -> 0x0668, blocks: (B:410:0x05e3, B:339:0x04db, B:344:0x04ef, B:348:0x04f9, B:353:0x0506, B:355:0x050c, B:357:0x0510, B:358:0x0512, B:360:0x051a, B:362:0x051e, B:363:0x0522, B:366:0x0532, B:367:0x053b, B:368:0x0540, B:370:0x0544, B:371:0x054c, B:374:0x0552, B:375:0x055c, B:380:0x056e, B:382:0x0575, B:384:0x057e, B:387:0x0586, B:388:0x058a, B:389:0x058e, B:391:0x0592, B:392:0x0596, B:393:0x059c, B:396:0x05a2, B:398:0x05ab, B:403:0x05bf, B:404:0x05c3, B:405:0x05c8, B:406:0x05d3, B:407:0x05d8, B:408:0x05dd, B:340:0x04e3, B:415:0x0608, B:420:0x0618, B:421:0x061e, B:423:0x0624, B:424:0x062f, B:426:0x0632, B:428:0x063b, B:429:0x0641, B:431:0x064c, B:433:0x0650, B:434:0x0654, B:436:0x065b), top: B:459:0x05e3 }] */
    /* JADX WARN: Code duplicated, block: B:388:0x058a A[Catch: all -> 0x0668, Exception -> 0x066c, TryCatch #6 {Exception -> 0x066c, all -> 0x0668, blocks: (B:410:0x05e3, B:339:0x04db, B:344:0x04ef, B:348:0x04f9, B:353:0x0506, B:355:0x050c, B:357:0x0510, B:358:0x0512, B:360:0x051a, B:362:0x051e, B:363:0x0522, B:366:0x0532, B:367:0x053b, B:368:0x0540, B:370:0x0544, B:371:0x054c, B:374:0x0552, B:375:0x055c, B:380:0x056e, B:382:0x0575, B:384:0x057e, B:387:0x0586, B:388:0x058a, B:389:0x058e, B:391:0x0592, B:392:0x0596, B:393:0x059c, B:396:0x05a2, B:398:0x05ab, B:403:0x05bf, B:404:0x05c3, B:405:0x05c8, B:406:0x05d3, B:407:0x05d8, B:408:0x05dd, B:340:0x04e3, B:415:0x0608, B:420:0x0618, B:421:0x061e, B:423:0x0624, B:424:0x062f, B:426:0x0632, B:428:0x063b, B:429:0x0641, B:431:0x064c, B:433:0x0650, B:434:0x0654, B:436:0x065b), top: B:459:0x05e3 }] */
    /* JADX WARN: Code duplicated, block: B:389:0x058e A[Catch: all -> 0x0668, Exception -> 0x066c, TryCatch #6 {Exception -> 0x066c, all -> 0x0668, blocks: (B:410:0x05e3, B:339:0x04db, B:344:0x04ef, B:348:0x04f9, B:353:0x0506, B:355:0x050c, B:357:0x0510, B:358:0x0512, B:360:0x051a, B:362:0x051e, B:363:0x0522, B:366:0x0532, B:367:0x053b, B:368:0x0540, B:370:0x0544, B:371:0x054c, B:374:0x0552, B:375:0x055c, B:380:0x056e, B:382:0x0575, B:384:0x057e, B:387:0x0586, B:388:0x058a, B:389:0x058e, B:391:0x0592, B:392:0x0596, B:393:0x059c, B:396:0x05a2, B:398:0x05ab, B:403:0x05bf, B:404:0x05c3, B:405:0x05c8, B:406:0x05d3, B:407:0x05d8, B:408:0x05dd, B:340:0x04e3, B:415:0x0608, B:420:0x0618, B:421:0x061e, B:423:0x0624, B:424:0x062f, B:426:0x0632, B:428:0x063b, B:429:0x0641, B:431:0x064c, B:433:0x0650, B:434:0x0654, B:436:0x065b), top: B:459:0x05e3 }] */
    /* JADX WARN: Code duplicated, block: B:391:0x0592 A[Catch: all -> 0x0668, Exception -> 0x066c, TryCatch #6 {Exception -> 0x066c, all -> 0x0668, blocks: (B:410:0x05e3, B:339:0x04db, B:344:0x04ef, B:348:0x04f9, B:353:0x0506, B:355:0x050c, B:357:0x0510, B:358:0x0512, B:360:0x051a, B:362:0x051e, B:363:0x0522, B:366:0x0532, B:367:0x053b, B:368:0x0540, B:370:0x0544, B:371:0x054c, B:374:0x0552, B:375:0x055c, B:380:0x056e, B:382:0x0575, B:384:0x057e, B:387:0x0586, B:388:0x058a, B:389:0x058e, B:391:0x0592, B:392:0x0596, B:393:0x059c, B:396:0x05a2, B:398:0x05ab, B:403:0x05bf, B:404:0x05c3, B:405:0x05c8, B:406:0x05d3, B:407:0x05d8, B:408:0x05dd, B:340:0x04e3, B:415:0x0608, B:420:0x0618, B:421:0x061e, B:423:0x0624, B:424:0x062f, B:426:0x0632, B:428:0x063b, B:429:0x0641, B:431:0x064c, B:433:0x0650, B:434:0x0654, B:436:0x065b), top: B:459:0x05e3 }] */
    /* JADX WARN: Code duplicated, block: B:392:0x0596 A[Catch: all -> 0x0668, Exception -> 0x066c, TryCatch #6 {Exception -> 0x066c, all -> 0x0668, blocks: (B:410:0x05e3, B:339:0x04db, B:344:0x04ef, B:348:0x04f9, B:353:0x0506, B:355:0x050c, B:357:0x0510, B:358:0x0512, B:360:0x051a, B:362:0x051e, B:363:0x0522, B:366:0x0532, B:367:0x053b, B:368:0x0540, B:370:0x0544, B:371:0x054c, B:374:0x0552, B:375:0x055c, B:380:0x056e, B:382:0x0575, B:384:0x057e, B:387:0x0586, B:388:0x058a, B:389:0x058e, B:391:0x0592, B:392:0x0596, B:393:0x059c, B:396:0x05a2, B:398:0x05ab, B:403:0x05bf, B:404:0x05c3, B:405:0x05c8, B:406:0x05d3, B:407:0x05d8, B:408:0x05dd, B:340:0x04e3, B:415:0x0608, B:420:0x0618, B:421:0x061e, B:423:0x0624, B:424:0x062f, B:426:0x0632, B:428:0x063b, B:429:0x0641, B:431:0x064c, B:433:0x0650, B:434:0x0654, B:436:0x065b), top: B:459:0x05e3 }] */
    /* JADX WARN: Code duplicated, block: B:393:0x059c A[Catch: all -> 0x0668, Exception -> 0x066c, TryCatch #6 {Exception -> 0x066c, all -> 0x0668, blocks: (B:410:0x05e3, B:339:0x04db, B:344:0x04ef, B:348:0x04f9, B:353:0x0506, B:355:0x050c, B:357:0x0510, B:358:0x0512, B:360:0x051a, B:362:0x051e, B:363:0x0522, B:366:0x0532, B:367:0x053b, B:368:0x0540, B:370:0x0544, B:371:0x054c, B:374:0x0552, B:375:0x055c, B:380:0x056e, B:382:0x0575, B:384:0x057e, B:387:0x0586, B:388:0x058a, B:389:0x058e, B:391:0x0592, B:392:0x0596, B:393:0x059c, B:396:0x05a2, B:398:0x05ab, B:403:0x05bf, B:404:0x05c3, B:405:0x05c8, B:406:0x05d3, B:407:0x05d8, B:408:0x05dd, B:340:0x04e3, B:415:0x0608, B:420:0x0618, B:421:0x061e, B:423:0x0624, B:424:0x062f, B:426:0x0632, B:428:0x063b, B:429:0x0641, B:431:0x064c, B:433:0x0650, B:434:0x0654, B:436:0x065b), top: B:459:0x05e3 }] */
    /* JADX WARN: Code duplicated, block: B:395:0x05a0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:396:0x05a2 A[Catch: all -> 0x0668, Exception -> 0x066c, TryCatch #6 {Exception -> 0x066c, all -> 0x0668, blocks: (B:410:0x05e3, B:339:0x04db, B:344:0x04ef, B:348:0x04f9, B:353:0x0506, B:355:0x050c, B:357:0x0510, B:358:0x0512, B:360:0x051a, B:362:0x051e, B:363:0x0522, B:366:0x0532, B:367:0x053b, B:368:0x0540, B:370:0x0544, B:371:0x054c, B:374:0x0552, B:375:0x055c, B:380:0x056e, B:382:0x0575, B:384:0x057e, B:387:0x0586, B:388:0x058a, B:389:0x058e, B:391:0x0592, B:392:0x0596, B:393:0x059c, B:396:0x05a2, B:398:0x05ab, B:403:0x05bf, B:404:0x05c3, B:405:0x05c8, B:406:0x05d3, B:407:0x05d8, B:408:0x05dd, B:340:0x04e3, B:415:0x0608, B:420:0x0618, B:421:0x061e, B:423:0x0624, B:424:0x062f, B:426:0x0632, B:428:0x063b, B:429:0x0641, B:431:0x064c, B:433:0x0650, B:434:0x0654, B:436:0x065b), top: B:459:0x05e3 }] */
    /* JADX WARN: Code duplicated, block: B:398:0x05ab A[Catch: all -> 0x0668, Exception -> 0x066c, TryCatch #6 {Exception -> 0x066c, all -> 0x0668, blocks: (B:410:0x05e3, B:339:0x04db, B:344:0x04ef, B:348:0x04f9, B:353:0x0506, B:355:0x050c, B:357:0x0510, B:358:0x0512, B:360:0x051a, B:362:0x051e, B:363:0x0522, B:366:0x0532, B:367:0x053b, B:368:0x0540, B:370:0x0544, B:371:0x054c, B:374:0x0552, B:375:0x055c, B:380:0x056e, B:382:0x0575, B:384:0x057e, B:387:0x0586, B:388:0x058a, B:389:0x058e, B:391:0x0592, B:392:0x0596, B:393:0x059c, B:396:0x05a2, B:398:0x05ab, B:403:0x05bf, B:404:0x05c3, B:405:0x05c8, B:406:0x05d3, B:407:0x05d8, B:408:0x05dd, B:340:0x04e3, B:415:0x0608, B:420:0x0618, B:421:0x061e, B:423:0x0624, B:424:0x062f, B:426:0x0632, B:428:0x063b, B:429:0x0641, B:431:0x064c, B:433:0x0650, B:434:0x0654, B:436:0x065b), top: B:459:0x05e3 }] */
    /* JADX WARN: Code duplicated, block: B:400:0x05ba  */
    /* JADX WARN: Code duplicated, block: B:401:0x05bc  */
    /* JADX WARN: Code duplicated, block: B:403:0x05bf A[Catch: all -> 0x0668, Exception -> 0x066c, TryCatch #6 {Exception -> 0x066c, all -> 0x0668, blocks: (B:410:0x05e3, B:339:0x04db, B:344:0x04ef, B:348:0x04f9, B:353:0x0506, B:355:0x050c, B:357:0x0510, B:358:0x0512, B:360:0x051a, B:362:0x051e, B:363:0x0522, B:366:0x0532, B:367:0x053b, B:368:0x0540, B:370:0x0544, B:371:0x054c, B:374:0x0552, B:375:0x055c, B:380:0x056e, B:382:0x0575, B:384:0x057e, B:387:0x0586, B:388:0x058a, B:389:0x058e, B:391:0x0592, B:392:0x0596, B:393:0x059c, B:396:0x05a2, B:398:0x05ab, B:403:0x05bf, B:404:0x05c3, B:405:0x05c8, B:406:0x05d3, B:407:0x05d8, B:408:0x05dd, B:340:0x04e3, B:415:0x0608, B:420:0x0618, B:421:0x061e, B:423:0x0624, B:424:0x062f, B:426:0x0632, B:428:0x063b, B:429:0x0641, B:431:0x064c, B:433:0x0650, B:434:0x0654, B:436:0x065b), top: B:459:0x05e3 }] */
    /* JADX WARN: Code duplicated, block: B:404:0x05c3 A[Catch: all -> 0x0668, Exception -> 0x066c, TryCatch #6 {Exception -> 0x066c, all -> 0x0668, blocks: (B:410:0x05e3, B:339:0x04db, B:344:0x04ef, B:348:0x04f9, B:353:0x0506, B:355:0x050c, B:357:0x0510, B:358:0x0512, B:360:0x051a, B:362:0x051e, B:363:0x0522, B:366:0x0532, B:367:0x053b, B:368:0x0540, B:370:0x0544, B:371:0x054c, B:374:0x0552, B:375:0x055c, B:380:0x056e, B:382:0x0575, B:384:0x057e, B:387:0x0586, B:388:0x058a, B:389:0x058e, B:391:0x0592, B:392:0x0596, B:393:0x059c, B:396:0x05a2, B:398:0x05ab, B:403:0x05bf, B:404:0x05c3, B:405:0x05c8, B:406:0x05d3, B:407:0x05d8, B:408:0x05dd, B:340:0x04e3, B:415:0x0608, B:420:0x0618, B:421:0x061e, B:423:0x0624, B:424:0x062f, B:426:0x0632, B:428:0x063b, B:429:0x0641, B:431:0x064c, B:433:0x0650, B:434:0x0654, B:436:0x065b), top: B:459:0x05e3 }] */
    /* JADX WARN: Code duplicated, block: B:405:0x05c8 A[Catch: all -> 0x0668, Exception -> 0x066c, TryCatch #6 {Exception -> 0x066c, all -> 0x0668, blocks: (B:410:0x05e3, B:339:0x04db, B:344:0x04ef, B:348:0x04f9, B:353:0x0506, B:355:0x050c, B:357:0x0510, B:358:0x0512, B:360:0x051a, B:362:0x051e, B:363:0x0522, B:366:0x0532, B:367:0x053b, B:368:0x0540, B:370:0x0544, B:371:0x054c, B:374:0x0552, B:375:0x055c, B:380:0x056e, B:382:0x0575, B:384:0x057e, B:387:0x0586, B:388:0x058a, B:389:0x058e, B:391:0x0592, B:392:0x0596, B:393:0x059c, B:396:0x05a2, B:398:0x05ab, B:403:0x05bf, B:404:0x05c3, B:405:0x05c8, B:406:0x05d3, B:407:0x05d8, B:408:0x05dd, B:340:0x04e3, B:415:0x0608, B:420:0x0618, B:421:0x061e, B:423:0x0624, B:424:0x062f, B:426:0x0632, B:428:0x063b, B:429:0x0641, B:431:0x064c, B:433:0x0650, B:434:0x0654, B:436:0x065b), top: B:459:0x05e3 }] */
    /* JADX WARN: Code duplicated, block: B:406:0x05d3 A[Catch: all -> 0x0668, Exception -> 0x066c, TryCatch #6 {Exception -> 0x066c, all -> 0x0668, blocks: (B:410:0x05e3, B:339:0x04db, B:344:0x04ef, B:348:0x04f9, B:353:0x0506, B:355:0x050c, B:357:0x0510, B:358:0x0512, B:360:0x051a, B:362:0x051e, B:363:0x0522, B:366:0x0532, B:367:0x053b, B:368:0x0540, B:370:0x0544, B:371:0x054c, B:374:0x0552, B:375:0x055c, B:380:0x056e, B:382:0x0575, B:384:0x057e, B:387:0x0586, B:388:0x058a, B:389:0x058e, B:391:0x0592, B:392:0x0596, B:393:0x059c, B:396:0x05a2, B:398:0x05ab, B:403:0x05bf, B:404:0x05c3, B:405:0x05c8, B:406:0x05d3, B:407:0x05d8, B:408:0x05dd, B:340:0x04e3, B:415:0x0608, B:420:0x0618, B:421:0x061e, B:423:0x0624, B:424:0x062f, B:426:0x0632, B:428:0x063b, B:429:0x0641, B:431:0x064c, B:433:0x0650, B:434:0x0654, B:436:0x065b), top: B:459:0x05e3 }] */
    /* JADX WARN: Code duplicated, block: B:407:0x05d8 A[Catch: all -> 0x0668, Exception -> 0x066c, TryCatch #6 {Exception -> 0x066c, all -> 0x0668, blocks: (B:410:0x05e3, B:339:0x04db, B:344:0x04ef, B:348:0x04f9, B:353:0x0506, B:355:0x050c, B:357:0x0510, B:358:0x0512, B:360:0x051a, B:362:0x051e, B:363:0x0522, B:366:0x0532, B:367:0x053b, B:368:0x0540, B:370:0x0544, B:371:0x054c, B:374:0x0552, B:375:0x055c, B:380:0x056e, B:382:0x0575, B:384:0x057e, B:387:0x0586, B:388:0x058a, B:389:0x058e, B:391:0x0592, B:392:0x0596, B:393:0x059c, B:396:0x05a2, B:398:0x05ab, B:403:0x05bf, B:404:0x05c3, B:405:0x05c8, B:406:0x05d3, B:407:0x05d8, B:408:0x05dd, B:340:0x04e3, B:415:0x0608, B:420:0x0618, B:421:0x061e, B:423:0x0624, B:424:0x062f, B:426:0x0632, B:428:0x063b, B:429:0x0641, B:431:0x064c, B:433:0x0650, B:434:0x0654, B:436:0x065b), top: B:459:0x05e3 }] */
    /* JADX WARN: Code duplicated, block: B:408:0x05dd A[Catch: all -> 0x0668, Exception -> 0x066c, TryCatch #6 {Exception -> 0x066c, all -> 0x0668, blocks: (B:410:0x05e3, B:339:0x04db, B:344:0x04ef, B:348:0x04f9, B:353:0x0506, B:355:0x050c, B:357:0x0510, B:358:0x0512, B:360:0x051a, B:362:0x051e, B:363:0x0522, B:366:0x0532, B:367:0x053b, B:368:0x0540, B:370:0x0544, B:371:0x054c, B:374:0x0552, B:375:0x055c, B:380:0x056e, B:382:0x0575, B:384:0x057e, B:387:0x0586, B:388:0x058a, B:389:0x058e, B:391:0x0592, B:392:0x0596, B:393:0x059c, B:396:0x05a2, B:398:0x05ab, B:403:0x05bf, B:404:0x05c3, B:405:0x05c8, B:406:0x05d3, B:407:0x05d8, B:408:0x05dd, B:340:0x04e3, B:415:0x0608, B:420:0x0618, B:421:0x061e, B:423:0x0624, B:424:0x062f, B:426:0x0632, B:428:0x063b, B:429:0x0641, B:431:0x064c, B:433:0x0650, B:434:0x0654, B:436:0x065b), top: B:459:0x05e3 }] */
    /* JADX WARN: Code duplicated, block: B:455:0x067a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:467:0x0279 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:468:0x0271 A[SYNTHETIC] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws Throwable {
        FieldSerializer[] fieldSerializerArr;
        SerialContext serialContext;
        char cWriteBefore;
        int i;
        String str;
        boolean z;
        Object propertyValue;
        boolean z2;
        Object objEmptyList;
        int i2;
        boolean z3;
        boolean z4;
        boolean z5;
        char c;
        boolean z6;
        String strProcess;
        boolean z7;
        boolean z8;
        Object obj3;
        boolean z9;
        Object obj4;
        List<PropertyFilter> list;
        boolean z10;
        String string;
        boolean z11;
        String str2;
        boolean z12;
        char[] cArr;
        int length;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z13;
        Iterator<ValueFilter> it;
        Object objProcess;
        Object objValueOf;
        Iterator<NameFilter> it2;
        boolean z14;
        Object obj5;
        Iterator<PropertyFilter> it3;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        if ((jSONSerializer.context == null || (jSONSerializer.context.features & SerializerFeature.DisableCircularReferenceDetect.mask) == 0) && jSONSerializer.references != null && jSONSerializer.references.containsKey(obj)) {
            jSONSerializer.writeReference(obj);
            return;
        }
        if ((serializeWriter.features & SerializerFeature.SortField.mask) != 0) {
            fieldSerializerArr = this.sortedGetters;
        } else {
            fieldSerializerArr = this.getters;
        }
        SerialContext serialContext2 = jSONSerializer.context;
        if ((serializeWriter.features & SerializerFeature.DisableCircularReferenceDetect.mask) == 0) {
            jSONSerializer.context = new SerialContext(serialContext2, obj, obj2, this.features);
            if (jSONSerializer.references == null) {
                jSONSerializer.references = new IdentityHashMap<>();
            }
            jSONSerializer.references.put(obj, jSONSerializer.context);
        }
        boolean z21 = ((this.features & SerializerFeature.BeanToArray.mask) == 0 && (serializeWriter.features & SerializerFeature.BeanToArray.mask) == 0) ? false : true;
        char c2 = z21 ? '[' : '{';
        char c3 = z21 ? ']' : '}';
        try {
            int i7 = serializeWriter.count + 1;
            if (i7 > serializeWriter.buf.length) {
                if (serializeWriter.writer == null) {
                    serializeWriter.expandCapacity(i7);
                } else {
                    serializeWriter.flush();
                    i7 = 1;
                }
            }
            serializeWriter.buf[serializeWriter.count] = c2;
            serializeWriter.count = i7;
            if (fieldSerializerArr.length > 0 && (serializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0) {
                jSONSerializer.incrementIndent();
                jSONSerializer.println();
            }
            if (((this.features & SerializerFeature.WriteClassName.mask) == 0 && ((serializeWriter.features & SerializerFeature.WriteClassName.mask) == 0 || (type == null && (serializeWriter.features & SerializerFeature.NotWriteRootClassName.mask) != 0 && (jSONSerializer.context == null || jSONSerializer.context.parent == null)))) || obj.getClass() == type) {
                cWriteBefore = 0;
            } else {
                String str3 = this.typeKey;
                if (str3 == null) {
                    str3 = jSONSerializer.config.typeKey;
                }
                serializeWriter.writeFieldName(str3, false);
                String name = this.typeName;
                if (name == null) {
                    name = obj.getClass().getName();
                }
                jSONSerializer.write(name);
                cWriteBefore = ',';
            }
            if (jSONSerializer.beforeFilters != null) {
                Iterator<BeforeFilter> it4 = jSONSerializer.beforeFilters.iterator();
                while (it4.hasNext()) {
                    cWriteBefore = it4.next().writeBefore(jSONSerializer, obj, cWriteBefore);
                }
            }
            boolean z22 = cWriteBefore == ',';
            boolean z23 = (serializeWriter.features & SerializerFeature.QuoteFieldNames.mask) != 0 && (serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) == 0;
            boolean z24 = (serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0;
            boolean z25 = (SerializerFeature.NotWriteDefaultValue.mask & serializeWriter.features) != 0;
            List<PropertyFilter> list2 = jSONSerializer.propertyFilters;
            boolean z26 = false;
            List<NameFilter> list3 = jSONSerializer.nameFilters;
            boolean z27 = true;
            List<ValueFilter> list4 = jSONSerializer.valueFilters;
            boolean z28 = z22;
            List<PropertyPreFilter> list5 = jSONSerializer.propertyPreFilters;
            boolean z29 = z28;
            boolean z30 = z21;
            int i8 = 0;
            boolean z31 = z23;
            boolean z32 = z25;
            boolean z33 = z24;
            while (i8 < fieldSerializerArr.length) {
                try {
                    FieldSerializer fieldSerializer = fieldSerializerArr[i8];
                    int i9 = i8;
                    FieldInfo fieldInfo = fieldSerializer.fieldInfo;
                    List<NameFilter> list6 = list3;
                    Class<?> cls = fieldInfo.fieldClass;
                    List<ValueFilter> list7 = list4;
                    String str4 = fieldInfo.name;
                    boolean z34 = z31;
                    if (((serializeWriter.features & SerializerFeature.SkipTransientField.mask) == 0 || fieldInfo.field == null || !fieldInfo.fieldTransient) && ((str = this.typeKey) == null || !str.equals(str4))) {
                        if (list5 == null) {
                            z = z27;
                            break;
                        }
                        Iterator<PropertyPreFilter> it5 = list5.iterator();
                        while (true) {
                            if (!it5.hasNext()) {
                                z = z27;
                                break;
                            }
                            Iterator<PropertyPreFilter> it6 = it5;
                            if (!it5.next().apply(jSONSerializer, obj, str4)) {
                                z = z26 ? 1 : 0;
                                break;
                            }
                            it5 = it6;
                        }
                        if (z) {
                            long j = 0;
                            if (fieldInfo.fieldAccess) {
                                objEmptyList = null;
                                if (cls == Integer.TYPE) {
                                    i2 = fieldInfo.field.getInt(obj);
                                    z3 = z26 ? 1 : 0;
                                    z4 = z3 ? 1 : 0;
                                } else {
                                    if (cls == Long.TYPE) {
                                        z2 = z27;
                                        j = fieldInfo.field.getLong(obj);
                                        objEmptyList = null;
                                        i2 = z26 ? 1 : 0;
                                        z3 = i2 == true ? 1 : 0;
                                        z4 = z3 ? 1 : 0;
                                    } else if (cls == Boolean.TYPE) {
                                        z3 = fieldInfo.field.getBoolean(obj);
                                        i2 = z26 ? 1 : 0;
                                        z4 = i2 == true ? 1 : 0;
                                    } else {
                                        propertyValue = fieldInfo.field.get(obj);
                                    }
                                    if (list2 != null) {
                                        if (z2) {
                                            z5 = z2;
                                            if (cls == Integer.TYPE) {
                                                objEmptyList = Integer.valueOf(i2);
                                            } else if (cls == Long.TYPE) {
                                                objEmptyList = Long.valueOf(j);
                                            } else {
                                                if (cls == Boolean.TYPE) {
                                                    objEmptyList = Boolean.valueOf(z3);
                                                }
                                                if (z6) {
                                                    if (list6 != null) {
                                                        if (z5 || z4) {
                                                            objValueOf = objEmptyList;
                                                        } else {
                                                            if (cls == Integer.TYPE) {
                                                                objValueOf = Integer.valueOf(i2);
                                                            } else if (cls == Long.TYPE) {
                                                                objValueOf = Long.valueOf(j);
                                                            } else if (cls == Boolean.TYPE) {
                                                                objValueOf = Boolean.valueOf(z3);
                                                            } else {
                                                                objValueOf = objEmptyList;
                                                            }
                                                            z4 = z27;
                                                        }
                                                        it2 = list6.iterator();
                                                        strProcess = str4;
                                                        z14 = z32;
                                                        while (it2.hasNext()) {
                                                            strProcess = it2.next().process(obj, strProcess, objValueOf);
                                                            z14 = z14;
                                                        }
                                                        objEmptyList = objValueOf;
                                                        z7 = z14;
                                                    } else {
                                                        strProcess = str4;
                                                        z7 = z32;
                                                    }
                                                    z8 = z7;
                                                    if (list7 != null) {
                                                        if (z5 && !z4) {
                                                            if (cls == Integer.TYPE) {
                                                                objEmptyList = Integer.valueOf(i2);
                                                            } else if (cls == Long.TYPE) {
                                                                objEmptyList = Long.valueOf(j);
                                                            } else if (cls == Boolean.TYPE) {
                                                                objEmptyList = Boolean.valueOf(z3);
                                                            }
                                                            z4 = z27;
                                                        }
                                                        it = list7.iterator();
                                                        objProcess = objEmptyList;
                                                        while (it.hasNext()) {
                                                            Iterator<ValueFilter> it7 = it;
                                                            objProcess = it.next().process(obj, str4, objProcess);
                                                            it = it7;
                                                        }
                                                        obj3 = objEmptyList;
                                                        objEmptyList = objProcess;
                                                    } else {
                                                        obj3 = objEmptyList;
                                                    }
                                                    if (z4 || objEmptyList != null) {
                                                        z9 = z33;
                                                    } else {
                                                        z13 = z33;
                                                        int i10 = fieldInfo.serialzeFeatures | this.features | serializeWriter.features;
                                                        if (cls == Boolean.class) {
                                                            int i11 = SerializerFeature.WriteNullBooleanAsFalse.mask;
                                                            int i12 = i11 | SerializerFeature.WriteMapNullValue.mask;
                                                            if (z30 || (i10 & i12) != 0 || (serializeWriter.features & i12) != 0) {
                                                                if ((i10 & i11) != 0 || (serializeWriter.features & i11) != 0) {
                                                                    z9 = z13;
                                                                    objEmptyList = Boolean.valueOf(z26);
                                                                    z9 = z13;
                                                                }
                                                            }
                                                            z20 = z13;
                                                            z19 = z8;
                                                            list = list2;
                                                            z18 = z20;
                                                            z17 = z19;
                                                            z18 = z9;
                                                            z17 = z8;
                                                            serialContext2 = serialContext2;
                                                            z10 = z26 ? 1 : 0;
                                                            z16 = z18;
                                                            z15 = z17;
                                                        } else if (cls == String.class) {
                                                            int i13 = SerializerFeature.WriteNullStringAsEmpty.mask;
                                                            int i14 = i13 | SerializerFeature.WriteMapNullValue.mask;
                                                            if (!z30 && (i10 & i14) == 0 && (serializeWriter.features & i14) == 0) {
                                                                z20 = z13;
                                                                z19 = z8;
                                                                list = list2;
                                                                z18 = z20;
                                                                z17 = z19;
                                                                z18 = z9;
                                                                z17 = z8;
                                                                serialContext2 = serialContext2;
                                                                z10 = z26 ? 1 : 0;
                                                                z16 = z18;
                                                                z15 = z17;
                                                            } else if ((i10 & i13) != 0 || (serializeWriter.features & i13) != 0) {
                                                                z9 = z13;
                                                                objEmptyList = "";
                                                                z9 = z13;
                                                            }
                                                        } else if (Number.class.isAssignableFrom(cls)) {
                                                            int i15 = SerializerFeature.WriteNullNumberAsZero.mask;
                                                            int i16 = i15 | SerializerFeature.WriteMapNullValue.mask;
                                                            if (!z30 && (i10 & i16) == 0 && (serializeWriter.features & i16) == 0) {
                                                                z20 = z13;
                                                                z19 = z8;
                                                                list = list2;
                                                                z18 = z20;
                                                                z17 = z19;
                                                                z18 = z9;
                                                                z17 = z8;
                                                                serialContext2 = serialContext2;
                                                                z10 = z26 ? 1 : 0;
                                                                z16 = z18;
                                                                z15 = z17;
                                                            } else if ((i10 & i15) != 0 || (serializeWriter.features & i15) != 0) {
                                                                z9 = z13;
                                                                objEmptyList = Integer.valueOf(z26 ? 1 : 0);
                                                                z9 = z13;
                                                            }
                                                        } else if (Collection.class.isAssignableFrom(cls)) {
                                                            int i17 = SerializerFeature.WriteNullListAsEmpty.mask;
                                                            int i18 = i17 | SerializerFeature.WriteMapNullValue.mask;
                                                            if (!z30 && (i10 & i18) == 0 && (serializeWriter.features & i18) == 0) {
                                                                z9 = z13;
                                                                z20 = z13;
                                                                z19 = z8;
                                                                list = list2;
                                                                z18 = z20;
                                                                z17 = z19;
                                                                z18 = z9;
                                                                z17 = z8;
                                                                serialContext2 = serialContext2;
                                                                z10 = z26 ? 1 : 0;
                                                                z16 = z18;
                                                                z15 = z17;
                                                            } else {
                                                                z9 = z13;
                                                                z9 = z13;
                                                                z9 = z13;
                                                                if ((i10 & i17) != 0 || (serializeWriter.features & i17) != 0) {
                                                                    z9 = z13;
                                                                    objEmptyList = Collections.emptyList();
                                                                    z9 = z13;
                                                                }
                                                            }
                                                        } else if (!z30) {
                                                            z9 = z13;
                                                            if (!fieldSerializer.writeNull && !serializeWriter.isEnabled(SerializerFeature.WriteMapNullValue)) {
                                                                z9 = z13;
                                                                z20 = z13;
                                                                z19 = z8;
                                                                list = list2;
                                                                z18 = z20;
                                                                z17 = z19;
                                                                z18 = z9;
                                                                z17 = z8;
                                                                serialContext2 = serialContext2;
                                                                z10 = z26 ? 1 : 0;
                                                                z16 = z18;
                                                                z15 = z17;
                                                            }
                                                        }
                                                    }
                                                    z9 = z13;
                                                    z9 = z13;
                                                    z9 = z13;
                                                    z9 = z13;
                                                    z9 = z13;
                                                    obj4 = objEmptyList;
                                                    if (z4 || obj4 == null || !z8) {
                                                        list = list2;
                                                    } else {
                                                        list = list2;
                                                        if ((cls == Byte.TYPE || cls == Short.TYPE || cls == Integer.TYPE || cls == Long.TYPE || cls == Float.TYPE || cls == Double.TYPE) && (obj4 instanceof Number) && ((Number) obj4).byteValue() == 0) {
                                                            z18 = z9;
                                                            z17 = z8;
                                                        } else if (cls != Boolean.TYPE || !(obj4 instanceof Boolean) || ((Boolean) obj4).booleanValue()) {
                                                        }
                                                        z18 = z9;
                                                        z17 = z8;
                                                        serialContext2 = serialContext2;
                                                        z10 = z26 ? 1 : 0;
                                                        z16 = z18;
                                                        z15 = z17;
                                                    }
                                                    if (z29) {
                                                        i6 = serializeWriter.count + 1;
                                                        if (i6 > serializeWriter.buf.length) {
                                                            if (serializeWriter.writer == null) {
                                                                serializeWriter.expandCapacity(i6);
                                                            } else {
                                                                serializeWriter.flush();
                                                                i6 = z27;
                                                            }
                                                        }
                                                        serializeWriter.buf[serializeWriter.count] = ',';
                                                        serializeWriter.count = i6;
                                                        if ((serializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0) {
                                                            jSONSerializer.println();
                                                        }
                                                    }
                                                    if (strProcess != str4) {
                                                        if (!z30) {
                                                            serializeWriter.writeFieldName(strProcess, z27);
                                                        }
                                                        jSONSerializer.write(obj4);
                                                    } else {
                                                        if (obj3 != obj4) {
                                                            if (!z30) {
                                                                fieldSerializer.writePrefix(jSONSerializer);
                                                            }
                                                            jSONSerializer.write(obj4);
                                                        } else {
                                                            if (!z30) {
                                                                if (z34) {
                                                                    cArr = fieldSerializer.name_chars;
                                                                    length = cArr.length;
                                                                    i3 = serializeWriter.count + length;
                                                                    if (i3 <= serializeWriter.buf.length) {
                                                                        i4 = z26 ? 1 : 0;
                                                                    } else if (serializeWriter.writer == null) {
                                                                        serializeWriter.expandCapacity(i3);
                                                                        i4 = z26 ? 1 : 0;
                                                                    } else {
                                                                        i5 = z26 ? 1 : 0;
                                                                        do {
                                                                            int length2 = serializeWriter.buf.length - serializeWriter.count;
                                                                            System.arraycopy(cArr, i5, serializeWriter.buf, serializeWriter.count, length2);
                                                                            serializeWriter.count = serializeWriter.buf.length;
                                                                            serializeWriter.flush();
                                                                            length -= length2;
                                                                            i5 += length2;
                                                                        } while (length > serializeWriter.buf.length);
                                                                        i4 = i5;
                                                                        i3 = length;
                                                                    }
                                                                    System.arraycopy(cArr, i4, serializeWriter.buf, serializeWriter.count, length);
                                                                    serializeWriter.count = i3;
                                                                } else {
                                                                    fieldSerializer.writePrefix(jSONSerializer);
                                                                }
                                                            }
                                                            if (z5 || z4) {
                                                                if (!z30) {
                                                                    if (cls == String.class) {
                                                                        int i19 = fieldSerializer.features | this.features;
                                                                        if (obj4 == null) {
                                                                            if ((serializeWriter.features & SerializerFeature.WriteNullStringAsEmpty.mask) == 0 || (i19 & SerializerFeature.WriteNullStringAsEmpty.mask) != 0) {
                                                                                serializeWriter.writeString("");
                                                                            } else {
                                                                                serializeWriter.writeNull();
                                                                            }
                                                                        } else {
                                                                            str2 = (String) obj4;
                                                                            if (z9) {
                                                                                serializeWriter.writeStringWithSingleQuote(str2);
                                                                            } else {
                                                                                serializeWriter.writeStringWithDoubleQuote(str2, (char) 0, true);
                                                                            }
                                                                        }
                                                                    } else if (!fieldInfo.isEnum) {
                                                                        z10 = false;
                                                                        fieldSerializer.writeValue(jSONSerializer, obj4);
                                                                    } else if (obj4 != null) {
                                                                        if ((serializeWriter.features & SerializerFeature.WriteEnumUsingToString.mask) != 0) {
                                                                            string = ((Enum) obj4).toString();
                                                                            if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
                                                                                z11 = true;
                                                                            } else {
                                                                                z11 = false;
                                                                            }
                                                                            if (z11) {
                                                                                serializeWriter.writeStringWithSingleQuote(string);
                                                                            } else {
                                                                                z10 = false;
                                                                                serializeWriter.writeStringWithDoubleQuote(string, (char) 0, false);
                                                                            }
                                                                        } else {
                                                                            z10 = false;
                                                                            serializeWriter.writeInt(((Enum) obj4).ordinal());
                                                                        }
                                                                    } else {
                                                                        z10 = false;
                                                                        serializeWriter.writeNull();
                                                                    }
                                                                } else {
                                                                    z10 = false;
                                                                    fieldSerializer.writeValue(jSONSerializer, obj4);
                                                                }
                                                            } else if (cls == Integer.TYPE) {
                                                                int i20 = i2;
                                                                if (i20 == Integer.MIN_VALUE) {
                                                                    serializeWriter.write("-2147483648");
                                                                    z10 = z26 ? 1 : 0;
                                                                } else {
                                                                    int i21 = i20 < 0 ? -(i20 == true ? 1 : 0) : i20 == true ? 1 : 0;
                                                                    int i22 = z26 ? 1 : 0;
                                                                    while (i21 > SerializeWriter.sizeTable[i22]) {
                                                                        i22++;
                                                                        z26 = false;
                                                                    }
                                                                    int i23 = i22 + 1;
                                                                    if (i20 < 0) {
                                                                        i23 = i22 + 2;
                                                                    }
                                                                    int i24 = serializeWriter.count + i23;
                                                                    if (i24 <= serializeWriter.buf.length) {
                                                                        z12 = false;
                                                                    } else if (serializeWriter.writer == null) {
                                                                        serializeWriter.expandCapacity(i24);
                                                                        z12 = false;
                                                                    } else {
                                                                        char[] cArr2 = new char[i23];
                                                                        SerializeWriter.getChars(i20 == true ? 1L : 0L, i23, cArr2);
                                                                        serializeWriter.write(cArr2, z26 ? 1 : 0, i23);
                                                                        z12 = true;
                                                                    }
                                                                    if (!z12) {
                                                                        SerializeWriter.getChars(i20 == true ? 1L : 0L, i24, serializeWriter.buf);
                                                                        serializeWriter.count = i24;
                                                                    }
                                                                }
                                                            } else if (cls == Long.TYPE) {
                                                                jSONSerializer.out.writeLong(j);
                                                            } else if (cls == Boolean.TYPE) {
                                                                if (z3) {
                                                                    SerializeWriter serializeWriter2 = jSONSerializer.out;
                                                                    char[] cArr3 = true_chars;
                                                                    serializeWriter2.write(cArr3, 0, cArr3.length);
                                                                } else {
                                                                    SerializeWriter serializeWriter3 = jSONSerializer.out;
                                                                    char[] cArr4 = false_chars;
                                                                    serializeWriter3.write(cArr4, 0, cArr4.length);
                                                                }
                                                            }
                                                            z10 = false;
                                                        }
                                                        z29 = true;
                                                        z16 = z9;
                                                        z15 = z8;
                                                    }
                                                    serialContext2 = serialContext2;
                                                    z10 = z26 ? 1 : 0;
                                                    z29 = true;
                                                    z16 = z9;
                                                    z15 = z8;
                                                }
                                            }
                                            z4 = z27;
                                        } else {
                                            z5 = z2;
                                        }
                                        obj5 = objEmptyList;
                                        it3 = list2.iterator();
                                        while (true) {
                                            if (it3.hasNext()) {
                                                c = c3;
                                                if (!it3.next().apply(obj, str4, obj5)) {
                                                    objEmptyList = obj5;
                                                    z6 = z26 ? 1 : 0;
                                                    break;
                                                }
                                                c3 = c;
                                            } else {
                                                c = c3;
                                                objEmptyList = obj5;
                                            }
                                        }
                                        if (z6) {
                                            if (list6 != null) {
                                                if (z5) {
                                                    objValueOf = objEmptyList;
                                                } else {
                                                    objValueOf = objEmptyList;
                                                }
                                                it2 = list6.iterator();
                                                strProcess = str4;
                                                z14 = z32;
                                                while (it2.hasNext()) {
                                                    strProcess = it2.next().process(obj, strProcess, objValueOf);
                                                    z14 = z14;
                                                }
                                                objEmptyList = objValueOf;
                                                z7 = z14;
                                            } else {
                                                strProcess = str4;
                                                z7 = z32;
                                            }
                                            z8 = z7;
                                            if (list7 != null) {
                                                if (z5) {
                                                    if (cls == Integer.TYPE) {
                                                        objEmptyList = Integer.valueOf(i2);
                                                    } else if (cls == Long.TYPE) {
                                                        objEmptyList = Long.valueOf(j);
                                                    } else if (cls == Boolean.TYPE) {
                                                        objEmptyList = Boolean.valueOf(z3);
                                                    }
                                                    z4 = z27;
                                                }
                                                it = list7.iterator();
                                                objProcess = objEmptyList;
                                                while (it.hasNext()) {
                                                    Iterator<ValueFilter> it8 = it;
                                                    objProcess = it.next().process(obj, str4, objProcess);
                                                    it = it8;
                                                }
                                                obj3 = objEmptyList;
                                                objEmptyList = objProcess;
                                            } else {
                                                obj3 = objEmptyList;
                                            }
                                            if (z4) {
                                                z9 = z33;
                                            } else {
                                                z9 = z33;
                                            }
                                            z9 = z13;
                                            z9 = z13;
                                            z9 = z13;
                                            z9 = z13;
                                            z9 = z13;
                                            obj4 = objEmptyList;
                                            if (z4) {
                                                list = list2;
                                            } else {
                                                list = list2;
                                            }
                                            if (z29) {
                                                i6 = serializeWriter.count + 1;
                                                if (i6 > serializeWriter.buf.length) {
                                                    if (serializeWriter.writer == null) {
                                                        serializeWriter.expandCapacity(i6);
                                                    } else {
                                                        serializeWriter.flush();
                                                        i6 = z27;
                                                    }
                                                }
                                                serializeWriter.buf[serializeWriter.count] = ',';
                                                serializeWriter.count = i6;
                                                if ((serializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0) {
                                                    jSONSerializer.println();
                                                }
                                            }
                                            if (strProcess != str4) {
                                                if (!z30) {
                                                    serializeWriter.writeFieldName(strProcess, z27);
                                                }
                                                jSONSerializer.write(obj4);
                                            } else {
                                                if (obj3 != obj4) {
                                                    if (!z30) {
                                                        fieldSerializer.writePrefix(jSONSerializer);
                                                    }
                                                    jSONSerializer.write(obj4);
                                                } else {
                                                    if (!z30) {
                                                        if (z34) {
                                                            cArr = fieldSerializer.name_chars;
                                                            length = cArr.length;
                                                            i3 = serializeWriter.count + length;
                                                            if (i3 <= serializeWriter.buf.length) {
                                                                i4 = z26 ? 1 : 0;
                                                            } else if (serializeWriter.writer == null) {
                                                                serializeWriter.expandCapacity(i3);
                                                                i4 = z26 ? 1 : 0;
                                                            } else {
                                                                i5 = z26 ? 1 : 0;
                                                                do {
                                                                    int length3 = serializeWriter.buf.length - serializeWriter.count;
                                                                    System.arraycopy(cArr, i5, serializeWriter.buf, serializeWriter.count, length3);
                                                                    serializeWriter.count = serializeWriter.buf.length;
                                                                    serializeWriter.flush();
                                                                    length -= length3;
                                                                    i5 += length3;
                                                                } while (length > serializeWriter.buf.length);
                                                                i4 = i5;
                                                                i3 = length;
                                                            }
                                                            System.arraycopy(cArr, i4, serializeWriter.buf, serializeWriter.count, length);
                                                            serializeWriter.count = i3;
                                                        } else {
                                                            fieldSerializer.writePrefix(jSONSerializer);
                                                        }
                                                    }
                                                    if (z5) {
                                                        if (!z30) {
                                                            if (cls == String.class) {
                                                                int i110 = fieldSerializer.features | this.features;
                                                                if (obj4 == null) {
                                                                    if ((serializeWriter.features & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                                        serializeWriter.writeString("");
                                                                    } else {
                                                                        serializeWriter.writeString("");
                                                                    }
                                                                } else {
                                                                    str2 = (String) obj4;
                                                                    if (z9) {
                                                                        serializeWriter.writeStringWithSingleQuote(str2);
                                                                    } else {
                                                                        serializeWriter.writeStringWithDoubleQuote(str2, (char) 0, true);
                                                                    }
                                                                }
                                                            } else if (!fieldInfo.isEnum) {
                                                                z10 = false;
                                                                fieldSerializer.writeValue(jSONSerializer, obj4);
                                                            } else if (obj4 != null) {
                                                                if ((serializeWriter.features & SerializerFeature.WriteEnumUsingToString.mask) != 0) {
                                                                    string = ((Enum) obj4).toString();
                                                                    if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
                                                                        z11 = true;
                                                                    } else {
                                                                        z11 = false;
                                                                    }
                                                                    if (z11) {
                                                                        serializeWriter.writeStringWithSingleQuote(string);
                                                                    } else {
                                                                        z10 = false;
                                                                        serializeWriter.writeStringWithDoubleQuote(string, (char) 0, false);
                                                                    }
                                                                } else {
                                                                    z10 = false;
                                                                    serializeWriter.writeInt(((Enum) obj4).ordinal());
                                                                }
                                                            } else {
                                                                z10 = false;
                                                                serializeWriter.writeNull();
                                                            }
                                                            z10 = false;
                                                        } else {
                                                            z10 = false;
                                                            fieldSerializer.writeValue(jSONSerializer, obj4);
                                                        }
                                                    } else if (!z30) {
                                                        if (cls == String.class) {
                                                            int i111 = fieldSerializer.features | this.features;
                                                            if (obj4 == null) {
                                                                if ((serializeWriter.features & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                                    serializeWriter.writeString("");
                                                                } else {
                                                                    serializeWriter.writeString("");
                                                                }
                                                            } else {
                                                                str2 = (String) obj4;
                                                                if (z9) {
                                                                    serializeWriter.writeStringWithSingleQuote(str2);
                                                                } else {
                                                                    serializeWriter.writeStringWithDoubleQuote(str2, (char) 0, true);
                                                                }
                                                            }
                                                        } else if (!fieldInfo.isEnum) {
                                                            z10 = false;
                                                            fieldSerializer.writeValue(jSONSerializer, obj4);
                                                        } else if (obj4 != null) {
                                                            if ((serializeWriter.features & SerializerFeature.WriteEnumUsingToString.mask) != 0) {
                                                                string = ((Enum) obj4).toString();
                                                                if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
                                                                    z11 = true;
                                                                } else {
                                                                    z11 = false;
                                                                }
                                                                if (z11) {
                                                                    serializeWriter.writeStringWithSingleQuote(string);
                                                                } else {
                                                                    z10 = false;
                                                                    serializeWriter.writeStringWithDoubleQuote(string, (char) 0, false);
                                                                }
                                                            } else {
                                                                z10 = false;
                                                                serializeWriter.writeInt(((Enum) obj4).ordinal());
                                                            }
                                                        } else {
                                                            z10 = false;
                                                            serializeWriter.writeNull();
                                                        }
                                                        z10 = false;
                                                    } else {
                                                        z10 = false;
                                                        fieldSerializer.writeValue(jSONSerializer, obj4);
                                                    }
                                                }
                                                z29 = true;
                                                z16 = z9;
                                                z15 = z8;
                                            }
                                            serialContext2 = serialContext2;
                                            z10 = z26 ? 1 : 0;
                                            z29 = true;
                                            z16 = z9;
                                            z15 = z8;
                                        }
                                    } else {
                                        z5 = z2;
                                        c = c3;
                                    }
                                    z6 = z27;
                                    if (z6) {
                                        if (list6 != null) {
                                            if (z5) {
                                                objValueOf = objEmptyList;
                                            } else {
                                                objValueOf = objEmptyList;
                                            }
                                            it2 = list6.iterator();
                                            strProcess = str4;
                                            z14 = z32;
                                            while (it2.hasNext()) {
                                                strProcess = it2.next().process(obj, strProcess, objValueOf);
                                                z14 = z14;
                                            }
                                            objEmptyList = objValueOf;
                                            z7 = z14;
                                        } else {
                                            strProcess = str4;
                                            z7 = z32;
                                        }
                                        z8 = z7;
                                        if (list7 != null) {
                                            if (z5) {
                                                if (cls == Integer.TYPE) {
                                                    objEmptyList = Integer.valueOf(i2);
                                                } else if (cls == Long.TYPE) {
                                                    objEmptyList = Long.valueOf(j);
                                                } else if (cls == Boolean.TYPE) {
                                                    objEmptyList = Boolean.valueOf(z3);
                                                }
                                                z4 = z27;
                                            }
                                            it = list7.iterator();
                                            objProcess = objEmptyList;
                                            while (it.hasNext()) {
                                                Iterator<ValueFilter> it9 = it;
                                                objProcess = it.next().process(obj, str4, objProcess);
                                                it = it9;
                                            }
                                            obj3 = objEmptyList;
                                            objEmptyList = objProcess;
                                        } else {
                                            obj3 = objEmptyList;
                                        }
                                        if (z4) {
                                            z9 = z33;
                                        } else {
                                            z9 = z33;
                                        }
                                        z9 = z13;
                                        z9 = z13;
                                        z9 = z13;
                                        z9 = z13;
                                        z9 = z13;
                                        obj4 = objEmptyList;
                                        if (z4) {
                                            list = list2;
                                        } else {
                                            list = list2;
                                        }
                                        if (z29) {
                                            i6 = serializeWriter.count + 1;
                                            if (i6 > serializeWriter.buf.length) {
                                                if (serializeWriter.writer == null) {
                                                    serializeWriter.expandCapacity(i6);
                                                } else {
                                                    serializeWriter.flush();
                                                    i6 = z27;
                                                }
                                            }
                                            serializeWriter.buf[serializeWriter.count] = ',';
                                            serializeWriter.count = i6;
                                            if ((serializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0) {
                                                jSONSerializer.println();
                                            }
                                        }
                                        if (strProcess != str4) {
                                            if (!z30) {
                                                serializeWriter.writeFieldName(strProcess, z27);
                                            }
                                            jSONSerializer.write(obj4);
                                        } else {
                                            if (obj3 != obj4) {
                                                if (!z30) {
                                                    fieldSerializer.writePrefix(jSONSerializer);
                                                }
                                                jSONSerializer.write(obj4);
                                            } else {
                                                if (!z30) {
                                                    if (z34) {
                                                        cArr = fieldSerializer.name_chars;
                                                        length = cArr.length;
                                                        i3 = serializeWriter.count + length;
                                                        if (i3 <= serializeWriter.buf.length) {
                                                            i4 = z26 ? 1 : 0;
                                                        } else if (serializeWriter.writer == null) {
                                                            serializeWriter.expandCapacity(i3);
                                                            i4 = z26 ? 1 : 0;
                                                        } else {
                                                            i5 = z26 ? 1 : 0;
                                                            do {
                                                                int length4 = serializeWriter.buf.length - serializeWriter.count;
                                                                System.arraycopy(cArr, i5, serializeWriter.buf, serializeWriter.count, length4);
                                                                serializeWriter.count = serializeWriter.buf.length;
                                                                serializeWriter.flush();
                                                                length -= length4;
                                                                i5 += length4;
                                                            } while (length > serializeWriter.buf.length);
                                                            i4 = i5;
                                                            i3 = length;
                                                        }
                                                        System.arraycopy(cArr, i4, serializeWriter.buf, serializeWriter.count, length);
                                                        serializeWriter.count = i3;
                                                    } else {
                                                        fieldSerializer.writePrefix(jSONSerializer);
                                                    }
                                                }
                                                if (z5) {
                                                    if (!z30) {
                                                        if (cls == String.class) {
                                                            int i112 = fieldSerializer.features | this.features;
                                                            if (obj4 == null) {
                                                                if ((serializeWriter.features & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                                    serializeWriter.writeString("");
                                                                } else {
                                                                    serializeWriter.writeString("");
                                                                }
                                                            } else {
                                                                str2 = (String) obj4;
                                                                if (z9) {
                                                                    serializeWriter.writeStringWithSingleQuote(str2);
                                                                } else {
                                                                    serializeWriter.writeStringWithDoubleQuote(str2, (char) 0, true);
                                                                }
                                                            }
                                                        } else if (!fieldInfo.isEnum) {
                                                            z10 = false;
                                                            fieldSerializer.writeValue(jSONSerializer, obj4);
                                                        } else if (obj4 != null) {
                                                            if ((serializeWriter.features & SerializerFeature.WriteEnumUsingToString.mask) != 0) {
                                                                string = ((Enum) obj4).toString();
                                                                if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
                                                                    z11 = true;
                                                                } else {
                                                                    z11 = false;
                                                                }
                                                                if (z11) {
                                                                    serializeWriter.writeStringWithSingleQuote(string);
                                                                } else {
                                                                    z10 = false;
                                                                    serializeWriter.writeStringWithDoubleQuote(string, (char) 0, false);
                                                                }
                                                            } else {
                                                                z10 = false;
                                                                serializeWriter.writeInt(((Enum) obj4).ordinal());
                                                            }
                                                        } else {
                                                            z10 = false;
                                                            serializeWriter.writeNull();
                                                        }
                                                        z10 = false;
                                                    } else {
                                                        z10 = false;
                                                        fieldSerializer.writeValue(jSONSerializer, obj4);
                                                    }
                                                } else if (!z30) {
                                                    if (cls == String.class) {
                                                        int i113 = fieldSerializer.features | this.features;
                                                        if (obj4 == null) {
                                                            if ((serializeWriter.features & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                                serializeWriter.writeString("");
                                                            } else {
                                                                serializeWriter.writeString("");
                                                            }
                                                        } else {
                                                            str2 = (String) obj4;
                                                            if (z9) {
                                                                serializeWriter.writeStringWithSingleQuote(str2);
                                                            } else {
                                                                serializeWriter.writeStringWithDoubleQuote(str2, (char) 0, true);
                                                            }
                                                        }
                                                    } else if (!fieldInfo.isEnum) {
                                                        z10 = false;
                                                        fieldSerializer.writeValue(jSONSerializer, obj4);
                                                    } else if (obj4 != null) {
                                                        if ((serializeWriter.features & SerializerFeature.WriteEnumUsingToString.mask) != 0) {
                                                            string = ((Enum) obj4).toString();
                                                            if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
                                                                z11 = true;
                                                            } else {
                                                                z11 = false;
                                                            }
                                                            if (z11) {
                                                                serializeWriter.writeStringWithSingleQuote(string);
                                                            } else {
                                                                z10 = false;
                                                                serializeWriter.writeStringWithDoubleQuote(string, (char) 0, false);
                                                            }
                                                        } else {
                                                            z10 = false;
                                                            serializeWriter.writeInt(((Enum) obj4).ordinal());
                                                        }
                                                    } else {
                                                        z10 = false;
                                                        serializeWriter.writeNull();
                                                    }
                                                    z10 = false;
                                                } else {
                                                    z10 = false;
                                                    fieldSerializer.writeValue(jSONSerializer, obj4);
                                                }
                                            }
                                            z29 = true;
                                            z16 = z9;
                                            z15 = z8;
                                        }
                                        serialContext2 = serialContext2;
                                        z10 = z26 ? 1 : 0;
                                        z29 = true;
                                        z16 = z9;
                                        z15 = z8;
                                    }
                                }
                                z2 = z27;
                                if (list2 != null) {
                                    if (z2) {
                                        z5 = z2;
                                        if (cls == Integer.TYPE) {
                                            objEmptyList = Integer.valueOf(i2);
                                        } else if (cls == Long.TYPE) {
                                            objEmptyList = Long.valueOf(j);
                                        } else {
                                            if (cls == Boolean.TYPE) {
                                                objEmptyList = Boolean.valueOf(z3);
                                            }
                                            if (z6) {
                                                if (list6 != null) {
                                                    if (z5) {
                                                        objValueOf = objEmptyList;
                                                    } else {
                                                        objValueOf = objEmptyList;
                                                    }
                                                    it2 = list6.iterator();
                                                    strProcess = str4;
                                                    z14 = z32;
                                                    while (it2.hasNext()) {
                                                        strProcess = it2.next().process(obj, strProcess, objValueOf);
                                                        z14 = z14;
                                                    }
                                                    objEmptyList = objValueOf;
                                                    z7 = z14;
                                                } else {
                                                    strProcess = str4;
                                                    z7 = z32;
                                                }
                                                z8 = z7;
                                                if (list7 != null) {
                                                    if (z5) {
                                                        if (cls == Integer.TYPE) {
                                                            objEmptyList = Integer.valueOf(i2);
                                                        } else if (cls == Long.TYPE) {
                                                            objEmptyList = Long.valueOf(j);
                                                        } else if (cls == Boolean.TYPE) {
                                                            objEmptyList = Boolean.valueOf(z3);
                                                        }
                                                        z4 = z27;
                                                    }
                                                    it = list7.iterator();
                                                    objProcess = objEmptyList;
                                                    while (it.hasNext()) {
                                                        Iterator<ValueFilter> it10 = it;
                                                        objProcess = it.next().process(obj, str4, objProcess);
                                                        it = it10;
                                                    }
                                                    obj3 = objEmptyList;
                                                    objEmptyList = objProcess;
                                                } else {
                                                    obj3 = objEmptyList;
                                                }
                                                if (z4) {
                                                    z9 = z33;
                                                } else {
                                                    z9 = z33;
                                                }
                                                z9 = z13;
                                                z9 = z13;
                                                z9 = z13;
                                                z9 = z13;
                                                z9 = z13;
                                                obj4 = objEmptyList;
                                                if (z4) {
                                                    list = list2;
                                                } else {
                                                    list = list2;
                                                }
                                                if (z29) {
                                                    i6 = serializeWriter.count + 1;
                                                    if (i6 > serializeWriter.buf.length) {
                                                        if (serializeWriter.writer == null) {
                                                            serializeWriter.expandCapacity(i6);
                                                        } else {
                                                            serializeWriter.flush();
                                                            i6 = z27;
                                                        }
                                                    }
                                                    serializeWriter.buf[serializeWriter.count] = ',';
                                                    serializeWriter.count = i6;
                                                    if ((serializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0) {
                                                        jSONSerializer.println();
                                                    }
                                                }
                                                if (strProcess != str4) {
                                                    if (!z30) {
                                                        serializeWriter.writeFieldName(strProcess, z27);
                                                    }
                                                    jSONSerializer.write(obj4);
                                                } else {
                                                    if (obj3 != obj4) {
                                                        if (!z30) {
                                                            fieldSerializer.writePrefix(jSONSerializer);
                                                        }
                                                        jSONSerializer.write(obj4);
                                                    } else {
                                                        if (!z30) {
                                                            if (z34) {
                                                                cArr = fieldSerializer.name_chars;
                                                                length = cArr.length;
                                                                i3 = serializeWriter.count + length;
                                                                if (i3 <= serializeWriter.buf.length) {
                                                                    i4 = z26 ? 1 : 0;
                                                                } else if (serializeWriter.writer == null) {
                                                                    serializeWriter.expandCapacity(i3);
                                                                    i4 = z26 ? 1 : 0;
                                                                } else {
                                                                    i5 = z26 ? 1 : 0;
                                                                    do {
                                                                        int length5 = serializeWriter.buf.length - serializeWriter.count;
                                                                        System.arraycopy(cArr, i5, serializeWriter.buf, serializeWriter.count, length5);
                                                                        serializeWriter.count = serializeWriter.buf.length;
                                                                        serializeWriter.flush();
                                                                        length -= length5;
                                                                        i5 += length5;
                                                                    } while (length > serializeWriter.buf.length);
                                                                    i4 = i5;
                                                                    i3 = length;
                                                                }
                                                                System.arraycopy(cArr, i4, serializeWriter.buf, serializeWriter.count, length);
                                                                serializeWriter.count = i3;
                                                            } else {
                                                                fieldSerializer.writePrefix(jSONSerializer);
                                                            }
                                                        }
                                                        if (z5) {
                                                            if (!z30) {
                                                                if (cls == String.class) {
                                                                    int i114 = fieldSerializer.features | this.features;
                                                                    if (obj4 == null) {
                                                                        if ((serializeWriter.features & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                                            serializeWriter.writeString("");
                                                                        } else {
                                                                            serializeWriter.writeString("");
                                                                        }
                                                                    } else {
                                                                        str2 = (String) obj4;
                                                                        if (z9) {
                                                                            serializeWriter.writeStringWithSingleQuote(str2);
                                                                        } else {
                                                                            serializeWriter.writeStringWithDoubleQuote(str2, (char) 0, true);
                                                                        }
                                                                    }
                                                                } else if (!fieldInfo.isEnum) {
                                                                    z10 = false;
                                                                    fieldSerializer.writeValue(jSONSerializer, obj4);
                                                                } else if (obj4 != null) {
                                                                    if ((serializeWriter.features & SerializerFeature.WriteEnumUsingToString.mask) != 0) {
                                                                        string = ((Enum) obj4).toString();
                                                                        if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
                                                                            z11 = true;
                                                                        } else {
                                                                            z11 = false;
                                                                        }
                                                                        if (z11) {
                                                                            serializeWriter.writeStringWithSingleQuote(string);
                                                                        } else {
                                                                            z10 = false;
                                                                            serializeWriter.writeStringWithDoubleQuote(string, (char) 0, false);
                                                                        }
                                                                    } else {
                                                                        z10 = false;
                                                                        serializeWriter.writeInt(((Enum) obj4).ordinal());
                                                                    }
                                                                } else {
                                                                    z10 = false;
                                                                    serializeWriter.writeNull();
                                                                }
                                                                z10 = false;
                                                            } else {
                                                                z10 = false;
                                                                fieldSerializer.writeValue(jSONSerializer, obj4);
                                                            }
                                                        } else if (!z30) {
                                                            if (cls == String.class) {
                                                                int i115 = fieldSerializer.features | this.features;
                                                                if (obj4 == null) {
                                                                    if ((serializeWriter.features & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                                        serializeWriter.writeString("");
                                                                    } else {
                                                                        serializeWriter.writeString("");
                                                                    }
                                                                } else {
                                                                    str2 = (String) obj4;
                                                                    if (z9) {
                                                                        serializeWriter.writeStringWithSingleQuote(str2);
                                                                    } else {
                                                                        serializeWriter.writeStringWithDoubleQuote(str2, (char) 0, true);
                                                                    }
                                                                }
                                                            } else if (!fieldInfo.isEnum) {
                                                                z10 = false;
                                                                fieldSerializer.writeValue(jSONSerializer, obj4);
                                                            } else if (obj4 != null) {
                                                                if ((serializeWriter.features & SerializerFeature.WriteEnumUsingToString.mask) != 0) {
                                                                    string = ((Enum) obj4).toString();
                                                                    if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
                                                                        z11 = true;
                                                                    } else {
                                                                        z11 = false;
                                                                    }
                                                                    if (z11) {
                                                                        serializeWriter.writeStringWithSingleQuote(string);
                                                                    } else {
                                                                        z10 = false;
                                                                        serializeWriter.writeStringWithDoubleQuote(string, (char) 0, false);
                                                                    }
                                                                } else {
                                                                    z10 = false;
                                                                    serializeWriter.writeInt(((Enum) obj4).ordinal());
                                                                }
                                                            } else {
                                                                z10 = false;
                                                                serializeWriter.writeNull();
                                                            }
                                                            z10 = false;
                                                        } else {
                                                            z10 = false;
                                                            fieldSerializer.writeValue(jSONSerializer, obj4);
                                                        }
                                                    }
                                                    z29 = true;
                                                    z16 = z9;
                                                    z15 = z8;
                                                }
                                                serialContext2 = serialContext2;
                                                z10 = z26 ? 1 : 0;
                                                z29 = true;
                                                z16 = z9;
                                                z15 = z8;
                                            }
                                        }
                                        z4 = z27;
                                    } else {
                                        z5 = z2;
                                    }
                                    obj5 = objEmptyList;
                                    it3 = list2.iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            c = c3;
                                            if (!it3.next().apply(obj, str4, obj5)) {
                                                objEmptyList = obj5;
                                                z6 = z26 ? 1 : 0;
                                                break;
                                            }
                                            c3 = c;
                                        } else {
                                            c = c3;
                                            objEmptyList = obj5;
                                        }
                                    }
                                    if (z6) {
                                        if (list6 != null) {
                                            if (z5) {
                                                objValueOf = objEmptyList;
                                            } else {
                                                objValueOf = objEmptyList;
                                            }
                                            it2 = list6.iterator();
                                            strProcess = str4;
                                            z14 = z32;
                                            while (it2.hasNext()) {
                                                strProcess = it2.next().process(obj, strProcess, objValueOf);
                                                z14 = z14;
                                            }
                                            objEmptyList = objValueOf;
                                            z7 = z14;
                                        } else {
                                            strProcess = str4;
                                            z7 = z32;
                                        }
                                        z8 = z7;
                                        if (list7 != null) {
                                            if (z5) {
                                                if (cls == Integer.TYPE) {
                                                    objEmptyList = Integer.valueOf(i2);
                                                } else if (cls == Long.TYPE) {
                                                    objEmptyList = Long.valueOf(j);
                                                } else if (cls == Boolean.TYPE) {
                                                    objEmptyList = Boolean.valueOf(z3);
                                                }
                                                z4 = z27;
                                            }
                                            it = list7.iterator();
                                            objProcess = objEmptyList;
                                            while (it.hasNext()) {
                                                Iterator<ValueFilter> it11 = it;
                                                objProcess = it.next().process(obj, str4, objProcess);
                                                it = it11;
                                            }
                                            obj3 = objEmptyList;
                                            objEmptyList = objProcess;
                                        } else {
                                            obj3 = objEmptyList;
                                        }
                                        if (z4) {
                                            z9 = z33;
                                        } else {
                                            z9 = z33;
                                        }
                                        z9 = z13;
                                        z9 = z13;
                                        z9 = z13;
                                        z9 = z13;
                                        z9 = z13;
                                        obj4 = objEmptyList;
                                        if (z4) {
                                            list = list2;
                                        } else {
                                            list = list2;
                                        }
                                        if (z29) {
                                            i6 = serializeWriter.count + 1;
                                            if (i6 > serializeWriter.buf.length) {
                                                if (serializeWriter.writer == null) {
                                                    serializeWriter.expandCapacity(i6);
                                                } else {
                                                    serializeWriter.flush();
                                                    i6 = z27;
                                                }
                                            }
                                            serializeWriter.buf[serializeWriter.count] = ',';
                                            serializeWriter.count = i6;
                                            if ((serializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0) {
                                                jSONSerializer.println();
                                            }
                                        }
                                        if (strProcess != str4) {
                                            if (!z30) {
                                                serializeWriter.writeFieldName(strProcess, z27);
                                            }
                                            jSONSerializer.write(obj4);
                                        } else {
                                            if (obj3 != obj4) {
                                                if (!z30) {
                                                    fieldSerializer.writePrefix(jSONSerializer);
                                                }
                                                jSONSerializer.write(obj4);
                                            } else {
                                                if (!z30) {
                                                    if (z34) {
                                                        cArr = fieldSerializer.name_chars;
                                                        length = cArr.length;
                                                        i3 = serializeWriter.count + length;
                                                        if (i3 <= serializeWriter.buf.length) {
                                                            i4 = z26 ? 1 : 0;
                                                        } else if (serializeWriter.writer == null) {
                                                            serializeWriter.expandCapacity(i3);
                                                            i4 = z26 ? 1 : 0;
                                                        } else {
                                                            i5 = z26 ? 1 : 0;
                                                            do {
                                                                int length6 = serializeWriter.buf.length - serializeWriter.count;
                                                                System.arraycopy(cArr, i5, serializeWriter.buf, serializeWriter.count, length6);
                                                                serializeWriter.count = serializeWriter.buf.length;
                                                                serializeWriter.flush();
                                                                length -= length6;
                                                                i5 += length6;
                                                            } while (length > serializeWriter.buf.length);
                                                            i4 = i5;
                                                            i3 = length;
                                                        }
                                                        System.arraycopy(cArr, i4, serializeWriter.buf, serializeWriter.count, length);
                                                        serializeWriter.count = i3;
                                                    } else {
                                                        fieldSerializer.writePrefix(jSONSerializer);
                                                    }
                                                }
                                                if (z5) {
                                                    if (!z30) {
                                                        if (cls == String.class) {
                                                            int i116 = fieldSerializer.features | this.features;
                                                            if (obj4 == null) {
                                                                if ((serializeWriter.features & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                                    serializeWriter.writeString("");
                                                                } else {
                                                                    serializeWriter.writeString("");
                                                                }
                                                            } else {
                                                                str2 = (String) obj4;
                                                                if (z9) {
                                                                    serializeWriter.writeStringWithSingleQuote(str2);
                                                                } else {
                                                                    serializeWriter.writeStringWithDoubleQuote(str2, (char) 0, true);
                                                                }
                                                            }
                                                        } else if (!fieldInfo.isEnum) {
                                                            z10 = false;
                                                            fieldSerializer.writeValue(jSONSerializer, obj4);
                                                        } else if (obj4 != null) {
                                                            if ((serializeWriter.features & SerializerFeature.WriteEnumUsingToString.mask) != 0) {
                                                                string = ((Enum) obj4).toString();
                                                                if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
                                                                    z11 = true;
                                                                } else {
                                                                    z11 = false;
                                                                }
                                                                if (z11) {
                                                                    serializeWriter.writeStringWithSingleQuote(string);
                                                                } else {
                                                                    z10 = false;
                                                                    serializeWriter.writeStringWithDoubleQuote(string, (char) 0, false);
                                                                }
                                                            } else {
                                                                z10 = false;
                                                                serializeWriter.writeInt(((Enum) obj4).ordinal());
                                                            }
                                                        } else {
                                                            z10 = false;
                                                            serializeWriter.writeNull();
                                                        }
                                                        z10 = false;
                                                    } else {
                                                        z10 = false;
                                                        fieldSerializer.writeValue(jSONSerializer, obj4);
                                                    }
                                                } else if (!z30) {
                                                    if (cls == String.class) {
                                                        int i117 = fieldSerializer.features | this.features;
                                                        if (obj4 == null) {
                                                            if ((serializeWriter.features & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                                serializeWriter.writeString("");
                                                            } else {
                                                                serializeWriter.writeString("");
                                                            }
                                                        } else {
                                                            str2 = (String) obj4;
                                                            if (z9) {
                                                                serializeWriter.writeStringWithSingleQuote(str2);
                                                            } else {
                                                                serializeWriter.writeStringWithDoubleQuote(str2, (char) 0, true);
                                                            }
                                                        }
                                                    } else if (!fieldInfo.isEnum) {
                                                        z10 = false;
                                                        fieldSerializer.writeValue(jSONSerializer, obj4);
                                                    } else if (obj4 != null) {
                                                        if ((serializeWriter.features & SerializerFeature.WriteEnumUsingToString.mask) != 0) {
                                                            string = ((Enum) obj4).toString();
                                                            if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
                                                                z11 = true;
                                                            } else {
                                                                z11 = false;
                                                            }
                                                            if (z11) {
                                                                serializeWriter.writeStringWithSingleQuote(string);
                                                            } else {
                                                                z10 = false;
                                                                serializeWriter.writeStringWithDoubleQuote(string, (char) 0, false);
                                                            }
                                                        } else {
                                                            z10 = false;
                                                            serializeWriter.writeInt(((Enum) obj4).ordinal());
                                                        }
                                                    } else {
                                                        z10 = false;
                                                        serializeWriter.writeNull();
                                                    }
                                                    z10 = false;
                                                } else {
                                                    z10 = false;
                                                    fieldSerializer.writeValue(jSONSerializer, obj4);
                                                }
                                            }
                                            z29 = true;
                                            z16 = z9;
                                            z15 = z8;
                                        }
                                        serialContext2 = serialContext2;
                                        z10 = z26 ? 1 : 0;
                                        z29 = true;
                                        z16 = z9;
                                        z15 = z8;
                                    }
                                } else {
                                    z5 = z2;
                                    c = c3;
                                }
                                z6 = z27;
                                if (z6) {
                                    if (list6 != null) {
                                        if (z5) {
                                            objValueOf = objEmptyList;
                                        } else {
                                            objValueOf = objEmptyList;
                                        }
                                        it2 = list6.iterator();
                                        strProcess = str4;
                                        z14 = z32;
                                        while (it2.hasNext()) {
                                            strProcess = it2.next().process(obj, strProcess, objValueOf);
                                            z14 = z14;
                                        }
                                        objEmptyList = objValueOf;
                                        z7 = z14;
                                    } else {
                                        strProcess = str4;
                                        z7 = z32;
                                    }
                                    z8 = z7;
                                    if (list7 != null) {
                                        if (z5) {
                                            if (cls == Integer.TYPE) {
                                                objEmptyList = Integer.valueOf(i2);
                                            } else if (cls == Long.TYPE) {
                                                objEmptyList = Long.valueOf(j);
                                            } else if (cls == Boolean.TYPE) {
                                                objEmptyList = Boolean.valueOf(z3);
                                            }
                                            z4 = z27;
                                        }
                                        it = list7.iterator();
                                        objProcess = objEmptyList;
                                        while (it.hasNext()) {
                                            Iterator<ValueFilter> it12 = it;
                                            objProcess = it.next().process(obj, str4, objProcess);
                                            it = it12;
                                        }
                                        obj3 = objEmptyList;
                                        objEmptyList = objProcess;
                                    } else {
                                        obj3 = objEmptyList;
                                    }
                                    if (z4) {
                                        z9 = z33;
                                    } else {
                                        z9 = z33;
                                    }
                                    z9 = z13;
                                    z9 = z13;
                                    z9 = z13;
                                    z9 = z13;
                                    z9 = z13;
                                    obj4 = objEmptyList;
                                    if (z4) {
                                        list = list2;
                                    } else {
                                        list = list2;
                                    }
                                    if (z29) {
                                        i6 = serializeWriter.count + 1;
                                        if (i6 > serializeWriter.buf.length) {
                                            if (serializeWriter.writer == null) {
                                                serializeWriter.expandCapacity(i6);
                                            } else {
                                                serializeWriter.flush();
                                                i6 = z27;
                                            }
                                        }
                                        serializeWriter.buf[serializeWriter.count] = ',';
                                        serializeWriter.count = i6;
                                        if ((serializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0) {
                                            jSONSerializer.println();
                                        }
                                    }
                                    if (strProcess != str4) {
                                        if (!z30) {
                                            serializeWriter.writeFieldName(strProcess, z27);
                                        }
                                        jSONSerializer.write(obj4);
                                    } else {
                                        if (obj3 != obj4) {
                                            if (!z30) {
                                                fieldSerializer.writePrefix(jSONSerializer);
                                            }
                                            jSONSerializer.write(obj4);
                                        } else {
                                            if (!z30) {
                                                if (z34) {
                                                    cArr = fieldSerializer.name_chars;
                                                    length = cArr.length;
                                                    i3 = serializeWriter.count + length;
                                                    if (i3 <= serializeWriter.buf.length) {
                                                        i4 = z26 ? 1 : 0;
                                                    } else if (serializeWriter.writer == null) {
                                                        serializeWriter.expandCapacity(i3);
                                                        i4 = z26 ? 1 : 0;
                                                    } else {
                                                        i5 = z26 ? 1 : 0;
                                                        do {
                                                            int length7 = serializeWriter.buf.length - serializeWriter.count;
                                                            System.arraycopy(cArr, i5, serializeWriter.buf, serializeWriter.count, length7);
                                                            serializeWriter.count = serializeWriter.buf.length;
                                                            serializeWriter.flush();
                                                            length -= length7;
                                                            i5 += length7;
                                                        } while (length > serializeWriter.buf.length);
                                                        i4 = i5;
                                                        i3 = length;
                                                    }
                                                    System.arraycopy(cArr, i4, serializeWriter.buf, serializeWriter.count, length);
                                                    serializeWriter.count = i3;
                                                } else {
                                                    fieldSerializer.writePrefix(jSONSerializer);
                                                }
                                            }
                                            if (z5) {
                                                if (!z30) {
                                                    if (cls == String.class) {
                                                        int i118 = fieldSerializer.features | this.features;
                                                        if (obj4 == null) {
                                                            if ((serializeWriter.features & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                                serializeWriter.writeString("");
                                                            } else {
                                                                serializeWriter.writeString("");
                                                            }
                                                        } else {
                                                            str2 = (String) obj4;
                                                            if (z9) {
                                                                serializeWriter.writeStringWithSingleQuote(str2);
                                                            } else {
                                                                serializeWriter.writeStringWithDoubleQuote(str2, (char) 0, true);
                                                            }
                                                        }
                                                    } else if (!fieldInfo.isEnum) {
                                                        z10 = false;
                                                        fieldSerializer.writeValue(jSONSerializer, obj4);
                                                    } else if (obj4 != null) {
                                                        if ((serializeWriter.features & SerializerFeature.WriteEnumUsingToString.mask) != 0) {
                                                            string = ((Enum) obj4).toString();
                                                            if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
                                                                z11 = true;
                                                            } else {
                                                                z11 = false;
                                                            }
                                                            if (z11) {
                                                                serializeWriter.writeStringWithSingleQuote(string);
                                                            } else {
                                                                z10 = false;
                                                                serializeWriter.writeStringWithDoubleQuote(string, (char) 0, false);
                                                            }
                                                        } else {
                                                            z10 = false;
                                                            serializeWriter.writeInt(((Enum) obj4).ordinal());
                                                        }
                                                    } else {
                                                        z10 = false;
                                                        serializeWriter.writeNull();
                                                    }
                                                    z10 = false;
                                                } else {
                                                    z10 = false;
                                                    fieldSerializer.writeValue(jSONSerializer, obj4);
                                                }
                                            } else if (!z30) {
                                                if (cls == String.class) {
                                                    int i119 = fieldSerializer.features | this.features;
                                                    if (obj4 == null) {
                                                        if ((serializeWriter.features & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                            serializeWriter.writeString("");
                                                        } else {
                                                            serializeWriter.writeString("");
                                                        }
                                                    } else {
                                                        str2 = (String) obj4;
                                                        if (z9) {
                                                            serializeWriter.writeStringWithSingleQuote(str2);
                                                        } else {
                                                            serializeWriter.writeStringWithDoubleQuote(str2, (char) 0, true);
                                                        }
                                                    }
                                                } else if (!fieldInfo.isEnum) {
                                                    z10 = false;
                                                    fieldSerializer.writeValue(jSONSerializer, obj4);
                                                } else if (obj4 != null) {
                                                    if ((serializeWriter.features & SerializerFeature.WriteEnumUsingToString.mask) != 0) {
                                                        string = ((Enum) obj4).toString();
                                                        if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
                                                            z11 = true;
                                                        } else {
                                                            z11 = false;
                                                        }
                                                        if (z11) {
                                                            serializeWriter.writeStringWithSingleQuote(string);
                                                        } else {
                                                            z10 = false;
                                                            serializeWriter.writeStringWithDoubleQuote(string, (char) 0, false);
                                                        }
                                                    } else {
                                                        z10 = false;
                                                        serializeWriter.writeInt(((Enum) obj4).ordinal());
                                                    }
                                                } else {
                                                    z10 = false;
                                                    serializeWriter.writeNull();
                                                }
                                                z10 = false;
                                            } else {
                                                z10 = false;
                                                fieldSerializer.writeValue(jSONSerializer, obj4);
                                            }
                                        }
                                        z29 = true;
                                        z16 = z9;
                                        z15 = z8;
                                    }
                                    serialContext2 = serialContext2;
                                    z10 = z26 ? 1 : 0;
                                    z29 = true;
                                    z16 = z9;
                                    z15 = z8;
                                }
                            } else {
                                propertyValue = fieldSerializer.getPropertyValue(obj);
                            }
                            z2 = z26 ? 1 : 0;
                            j = 0;
                            objEmptyList = propertyValue;
                            i2 = z2 ? 1 : 0;
                            z3 = i2 == true ? 1 : 0;
                            z4 = z27;
                            if (list2 != null) {
                                if (z2) {
                                    z5 = z2;
                                    if (cls == Integer.TYPE) {
                                        objEmptyList = Integer.valueOf(i2);
                                    } else if (cls == Long.TYPE) {
                                        objEmptyList = Long.valueOf(j);
                                    } else {
                                        if (cls == Boolean.TYPE) {
                                            objEmptyList = Boolean.valueOf(z3);
                                        }
                                        if (z6) {
                                            if (list6 != null) {
                                                if (z5) {
                                                    objValueOf = objEmptyList;
                                                } else {
                                                    objValueOf = objEmptyList;
                                                }
                                                it2 = list6.iterator();
                                                strProcess = str4;
                                                z14 = z32;
                                                while (it2.hasNext()) {
                                                    strProcess = it2.next().process(obj, strProcess, objValueOf);
                                                    z14 = z14;
                                                }
                                                objEmptyList = objValueOf;
                                                z7 = z14;
                                            } else {
                                                strProcess = str4;
                                                z7 = z32;
                                            }
                                            z8 = z7;
                                            if (list7 != null) {
                                                if (z5) {
                                                    if (cls == Integer.TYPE) {
                                                        objEmptyList = Integer.valueOf(i2);
                                                    } else if (cls == Long.TYPE) {
                                                        objEmptyList = Long.valueOf(j);
                                                    } else if (cls == Boolean.TYPE) {
                                                        objEmptyList = Boolean.valueOf(z3);
                                                    }
                                                    z4 = z27;
                                                }
                                                it = list7.iterator();
                                                objProcess = objEmptyList;
                                                while (it.hasNext()) {
                                                    Iterator<ValueFilter> it13 = it;
                                                    objProcess = it.next().process(obj, str4, objProcess);
                                                    it = it13;
                                                }
                                                obj3 = objEmptyList;
                                                objEmptyList = objProcess;
                                            } else {
                                                obj3 = objEmptyList;
                                            }
                                            if (z4) {
                                                z9 = z33;
                                            } else {
                                                z9 = z33;
                                            }
                                            z9 = z13;
                                            z9 = z13;
                                            z9 = z13;
                                            z9 = z13;
                                            z9 = z13;
                                            obj4 = objEmptyList;
                                            if (z4) {
                                                list = list2;
                                            } else {
                                                list = list2;
                                            }
                                            if (z29) {
                                                i6 = serializeWriter.count + 1;
                                                if (i6 > serializeWriter.buf.length) {
                                                    if (serializeWriter.writer == null) {
                                                        serializeWriter.expandCapacity(i6);
                                                    } else {
                                                        serializeWriter.flush();
                                                        i6 = z27;
                                                    }
                                                }
                                                serializeWriter.buf[serializeWriter.count] = ',';
                                                serializeWriter.count = i6;
                                                if ((serializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0) {
                                                    jSONSerializer.println();
                                                }
                                            }
                                            if (strProcess != str4) {
                                                if (!z30) {
                                                    serializeWriter.writeFieldName(strProcess, z27);
                                                }
                                                jSONSerializer.write(obj4);
                                            } else {
                                                if (obj3 != obj4) {
                                                    if (!z30) {
                                                        fieldSerializer.writePrefix(jSONSerializer);
                                                    }
                                                    jSONSerializer.write(obj4);
                                                } else {
                                                    if (!z30) {
                                                        if (z34) {
                                                            cArr = fieldSerializer.name_chars;
                                                            length = cArr.length;
                                                            i3 = serializeWriter.count + length;
                                                            if (i3 <= serializeWriter.buf.length) {
                                                                i4 = z26 ? 1 : 0;
                                                            } else if (serializeWriter.writer == null) {
                                                                serializeWriter.expandCapacity(i3);
                                                                i4 = z26 ? 1 : 0;
                                                            } else {
                                                                i5 = z26 ? 1 : 0;
                                                                do {
                                                                    int length8 = serializeWriter.buf.length - serializeWriter.count;
                                                                    System.arraycopy(cArr, i5, serializeWriter.buf, serializeWriter.count, length8);
                                                                    serializeWriter.count = serializeWriter.buf.length;
                                                                    serializeWriter.flush();
                                                                    length -= length8;
                                                                    i5 += length8;
                                                                } while (length > serializeWriter.buf.length);
                                                                i4 = i5;
                                                                i3 = length;
                                                            }
                                                            System.arraycopy(cArr, i4, serializeWriter.buf, serializeWriter.count, length);
                                                            serializeWriter.count = i3;
                                                        } else {
                                                            fieldSerializer.writePrefix(jSONSerializer);
                                                        }
                                                    }
                                                    if (z5) {
                                                        if (!z30) {
                                                            if (cls == String.class) {
                                                                int i1110 = fieldSerializer.features | this.features;
                                                                if (obj4 == null) {
                                                                    if ((serializeWriter.features & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                                        serializeWriter.writeString("");
                                                                    } else {
                                                                        serializeWriter.writeString("");
                                                                    }
                                                                } else {
                                                                    str2 = (String) obj4;
                                                                    if (z9) {
                                                                        serializeWriter.writeStringWithSingleQuote(str2);
                                                                    } else {
                                                                        serializeWriter.writeStringWithDoubleQuote(str2, (char) 0, true);
                                                                    }
                                                                }
                                                            } else if (!fieldInfo.isEnum) {
                                                                z10 = false;
                                                                fieldSerializer.writeValue(jSONSerializer, obj4);
                                                            } else if (obj4 != null) {
                                                                if ((serializeWriter.features & SerializerFeature.WriteEnumUsingToString.mask) != 0) {
                                                                    string = ((Enum) obj4).toString();
                                                                    if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
                                                                        z11 = true;
                                                                    } else {
                                                                        z11 = false;
                                                                    }
                                                                    if (z11) {
                                                                        serializeWriter.writeStringWithSingleQuote(string);
                                                                    } else {
                                                                        z10 = false;
                                                                        serializeWriter.writeStringWithDoubleQuote(string, (char) 0, false);
                                                                    }
                                                                } else {
                                                                    z10 = false;
                                                                    serializeWriter.writeInt(((Enum) obj4).ordinal());
                                                                }
                                                            } else {
                                                                z10 = false;
                                                                serializeWriter.writeNull();
                                                            }
                                                            z10 = false;
                                                        } else {
                                                            z10 = false;
                                                            fieldSerializer.writeValue(jSONSerializer, obj4);
                                                        }
                                                    } else if (!z30) {
                                                        if (cls == String.class) {
                                                            int i1111 = fieldSerializer.features | this.features;
                                                            if (obj4 == null) {
                                                                if ((serializeWriter.features & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                                    serializeWriter.writeString("");
                                                                } else {
                                                                    serializeWriter.writeString("");
                                                                }
                                                            } else {
                                                                str2 = (String) obj4;
                                                                if (z9) {
                                                                    serializeWriter.writeStringWithSingleQuote(str2);
                                                                } else {
                                                                    serializeWriter.writeStringWithDoubleQuote(str2, (char) 0, true);
                                                                }
                                                            }
                                                        } else if (!fieldInfo.isEnum) {
                                                            z10 = false;
                                                            fieldSerializer.writeValue(jSONSerializer, obj4);
                                                        } else if (obj4 != null) {
                                                            if ((serializeWriter.features & SerializerFeature.WriteEnumUsingToString.mask) != 0) {
                                                                string = ((Enum) obj4).toString();
                                                                if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
                                                                    z11 = true;
                                                                } else {
                                                                    z11 = false;
                                                                }
                                                                if (z11) {
                                                                    serializeWriter.writeStringWithSingleQuote(string);
                                                                } else {
                                                                    z10 = false;
                                                                    serializeWriter.writeStringWithDoubleQuote(string, (char) 0, false);
                                                                }
                                                            } else {
                                                                z10 = false;
                                                                serializeWriter.writeInt(((Enum) obj4).ordinal());
                                                            }
                                                        } else {
                                                            z10 = false;
                                                            serializeWriter.writeNull();
                                                        }
                                                        z10 = false;
                                                    } else {
                                                        z10 = false;
                                                        fieldSerializer.writeValue(jSONSerializer, obj4);
                                                    }
                                                }
                                                z29 = true;
                                                z16 = z9;
                                                z15 = z8;
                                            }
                                            serialContext2 = serialContext2;
                                            z10 = z26 ? 1 : 0;
                                            z29 = true;
                                            z16 = z9;
                                            z15 = z8;
                                        }
                                    }
                                    z4 = z27;
                                } else {
                                    z5 = z2;
                                }
                                obj5 = objEmptyList;
                                it3 = list2.iterator();
                                while (true) {
                                    if (it3.hasNext()) {
                                        c = c3;
                                        if (!it3.next().apply(obj, str4, obj5)) {
                                            objEmptyList = obj5;
                                            z6 = z26 ? 1 : 0;
                                            break;
                                        }
                                        c3 = c;
                                    } else {
                                        c = c3;
                                        objEmptyList = obj5;
                                    }
                                }
                                if (z6) {
                                    if (list6 != null) {
                                        if (z5) {
                                            objValueOf = objEmptyList;
                                        } else {
                                            objValueOf = objEmptyList;
                                        }
                                        it2 = list6.iterator();
                                        strProcess = str4;
                                        z14 = z32;
                                        while (it2.hasNext()) {
                                            strProcess = it2.next().process(obj, strProcess, objValueOf);
                                            z14 = z14;
                                        }
                                        objEmptyList = objValueOf;
                                        z7 = z14;
                                    } else {
                                        strProcess = str4;
                                        z7 = z32;
                                    }
                                    z8 = z7;
                                    if (list7 != null) {
                                        if (z5) {
                                            if (cls == Integer.TYPE) {
                                                objEmptyList = Integer.valueOf(i2);
                                            } else if (cls == Long.TYPE) {
                                                objEmptyList = Long.valueOf(j);
                                            } else if (cls == Boolean.TYPE) {
                                                objEmptyList = Boolean.valueOf(z3);
                                            }
                                            z4 = z27;
                                        }
                                        it = list7.iterator();
                                        objProcess = objEmptyList;
                                        while (it.hasNext()) {
                                            Iterator<ValueFilter> it14 = it;
                                            objProcess = it.next().process(obj, str4, objProcess);
                                            it = it14;
                                        }
                                        obj3 = objEmptyList;
                                        objEmptyList = objProcess;
                                    } else {
                                        obj3 = objEmptyList;
                                    }
                                    if (z4) {
                                        z9 = z33;
                                    } else {
                                        z9 = z33;
                                    }
                                    z9 = z13;
                                    z9 = z13;
                                    z9 = z13;
                                    z9 = z13;
                                    z9 = z13;
                                    obj4 = objEmptyList;
                                    if (z4) {
                                        list = list2;
                                    } else {
                                        list = list2;
                                    }
                                    if (z29) {
                                        i6 = serializeWriter.count + 1;
                                        if (i6 > serializeWriter.buf.length) {
                                            if (serializeWriter.writer == null) {
                                                serializeWriter.expandCapacity(i6);
                                            } else {
                                                serializeWriter.flush();
                                                i6 = z27;
                                            }
                                        }
                                        serializeWriter.buf[serializeWriter.count] = ',';
                                        serializeWriter.count = i6;
                                        if ((serializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0) {
                                            jSONSerializer.println();
                                        }
                                    }
                                    if (strProcess != str4) {
                                        if (!z30) {
                                            serializeWriter.writeFieldName(strProcess, z27);
                                        }
                                        jSONSerializer.write(obj4);
                                    } else {
                                        if (obj3 != obj4) {
                                            if (!z30) {
                                                fieldSerializer.writePrefix(jSONSerializer);
                                            }
                                            jSONSerializer.write(obj4);
                                        } else {
                                            if (!z30) {
                                                if (z34) {
                                                    cArr = fieldSerializer.name_chars;
                                                    length = cArr.length;
                                                    i3 = serializeWriter.count + length;
                                                    if (i3 <= serializeWriter.buf.length) {
                                                        i4 = z26 ? 1 : 0;
                                                    } else if (serializeWriter.writer == null) {
                                                        serializeWriter.expandCapacity(i3);
                                                        i4 = z26 ? 1 : 0;
                                                    } else {
                                                        i5 = z26 ? 1 : 0;
                                                        do {
                                                            int length9 = serializeWriter.buf.length - serializeWriter.count;
                                                            System.arraycopy(cArr, i5, serializeWriter.buf, serializeWriter.count, length9);
                                                            serializeWriter.count = serializeWriter.buf.length;
                                                            serializeWriter.flush();
                                                            length -= length9;
                                                            i5 += length9;
                                                        } while (length > serializeWriter.buf.length);
                                                        i4 = i5;
                                                        i3 = length;
                                                    }
                                                    System.arraycopy(cArr, i4, serializeWriter.buf, serializeWriter.count, length);
                                                    serializeWriter.count = i3;
                                                } else {
                                                    fieldSerializer.writePrefix(jSONSerializer);
                                                }
                                            }
                                            if (z5) {
                                                if (!z30) {
                                                    if (cls == String.class) {
                                                        int i1112 = fieldSerializer.features | this.features;
                                                        if (obj4 == null) {
                                                            if ((serializeWriter.features & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                                serializeWriter.writeString("");
                                                            } else {
                                                                serializeWriter.writeString("");
                                                            }
                                                        } else {
                                                            str2 = (String) obj4;
                                                            if (z9) {
                                                                serializeWriter.writeStringWithSingleQuote(str2);
                                                            } else {
                                                                serializeWriter.writeStringWithDoubleQuote(str2, (char) 0, true);
                                                            }
                                                        }
                                                    } else if (!fieldInfo.isEnum) {
                                                        z10 = false;
                                                        fieldSerializer.writeValue(jSONSerializer, obj4);
                                                    } else if (obj4 != null) {
                                                        if ((serializeWriter.features & SerializerFeature.WriteEnumUsingToString.mask) != 0) {
                                                            string = ((Enum) obj4).toString();
                                                            if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
                                                                z11 = true;
                                                            } else {
                                                                z11 = false;
                                                            }
                                                            if (z11) {
                                                                serializeWriter.writeStringWithSingleQuote(string);
                                                            } else {
                                                                z10 = false;
                                                                serializeWriter.writeStringWithDoubleQuote(string, (char) 0, false);
                                                            }
                                                        } else {
                                                            z10 = false;
                                                            serializeWriter.writeInt(((Enum) obj4).ordinal());
                                                        }
                                                    } else {
                                                        z10 = false;
                                                        serializeWriter.writeNull();
                                                    }
                                                    z10 = false;
                                                } else {
                                                    z10 = false;
                                                    fieldSerializer.writeValue(jSONSerializer, obj4);
                                                }
                                            } else if (!z30) {
                                                if (cls == String.class) {
                                                    int i1113 = fieldSerializer.features | this.features;
                                                    if (obj4 == null) {
                                                        if ((serializeWriter.features & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                            serializeWriter.writeString("");
                                                        } else {
                                                            serializeWriter.writeString("");
                                                        }
                                                    } else {
                                                        str2 = (String) obj4;
                                                        if (z9) {
                                                            serializeWriter.writeStringWithSingleQuote(str2);
                                                        } else {
                                                            serializeWriter.writeStringWithDoubleQuote(str2, (char) 0, true);
                                                        }
                                                    }
                                                } else if (!fieldInfo.isEnum) {
                                                    z10 = false;
                                                    fieldSerializer.writeValue(jSONSerializer, obj4);
                                                } else if (obj4 != null) {
                                                    if ((serializeWriter.features & SerializerFeature.WriteEnumUsingToString.mask) != 0) {
                                                        string = ((Enum) obj4).toString();
                                                        if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
                                                            z11 = true;
                                                        } else {
                                                            z11 = false;
                                                        }
                                                        if (z11) {
                                                            serializeWriter.writeStringWithSingleQuote(string);
                                                        } else {
                                                            z10 = false;
                                                            serializeWriter.writeStringWithDoubleQuote(string, (char) 0, false);
                                                        }
                                                    } else {
                                                        z10 = false;
                                                        serializeWriter.writeInt(((Enum) obj4).ordinal());
                                                    }
                                                } else {
                                                    z10 = false;
                                                    serializeWriter.writeNull();
                                                }
                                                z10 = false;
                                            } else {
                                                z10 = false;
                                                fieldSerializer.writeValue(jSONSerializer, obj4);
                                            }
                                        }
                                        z29 = true;
                                        z16 = z9;
                                        z15 = z8;
                                    }
                                    serialContext2 = serialContext2;
                                    z10 = z26 ? 1 : 0;
                                    z29 = true;
                                    z16 = z9;
                                    z15 = z8;
                                }
                            } else {
                                z5 = z2;
                                c = c3;
                            }
                            z6 = z27;
                            if (z6) {
                                if (list6 != null) {
                                    if (z5) {
                                        objValueOf = objEmptyList;
                                    } else {
                                        objValueOf = objEmptyList;
                                    }
                                    it2 = list6.iterator();
                                    strProcess = str4;
                                    z14 = z32;
                                    while (it2.hasNext()) {
                                        strProcess = it2.next().process(obj, strProcess, objValueOf);
                                        z14 = z14;
                                    }
                                    objEmptyList = objValueOf;
                                    z7 = z14;
                                } else {
                                    strProcess = str4;
                                    z7 = z32;
                                }
                                z8 = z7;
                                if (list7 != null) {
                                    if (z5) {
                                        if (cls == Integer.TYPE) {
                                            objEmptyList = Integer.valueOf(i2);
                                        } else if (cls == Long.TYPE) {
                                            objEmptyList = Long.valueOf(j);
                                        } else if (cls == Boolean.TYPE) {
                                            objEmptyList = Boolean.valueOf(z3);
                                        }
                                        z4 = z27;
                                    }
                                    it = list7.iterator();
                                    objProcess = objEmptyList;
                                    while (it.hasNext()) {
                                        Iterator<ValueFilter> it15 = it;
                                        objProcess = it.next().process(obj, str4, objProcess);
                                        it = it15;
                                    }
                                    obj3 = objEmptyList;
                                    objEmptyList = objProcess;
                                } else {
                                    obj3 = objEmptyList;
                                }
                                if (z4) {
                                    z9 = z33;
                                } else {
                                    z9 = z33;
                                }
                                z9 = z13;
                                z9 = z13;
                                z9 = z13;
                                z9 = z13;
                                z9 = z13;
                                obj4 = objEmptyList;
                                if (z4) {
                                    list = list2;
                                } else {
                                    list = list2;
                                }
                                if (z29) {
                                    i6 = serializeWriter.count + 1;
                                    if (i6 > serializeWriter.buf.length) {
                                        if (serializeWriter.writer == null) {
                                            serializeWriter.expandCapacity(i6);
                                        } else {
                                            serializeWriter.flush();
                                            i6 = z27;
                                        }
                                    }
                                    serializeWriter.buf[serializeWriter.count] = ',';
                                    serializeWriter.count = i6;
                                    if ((serializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0) {
                                        jSONSerializer.println();
                                    }
                                }
                                if (strProcess != str4) {
                                    if (!z30) {
                                        serializeWriter.writeFieldName(strProcess, z27);
                                    }
                                    jSONSerializer.write(obj4);
                                } else {
                                    if (obj3 != obj4) {
                                        if (!z30) {
                                            fieldSerializer.writePrefix(jSONSerializer);
                                        }
                                        jSONSerializer.write(obj4);
                                    } else {
                                        if (!z30) {
                                            if (z34) {
                                                cArr = fieldSerializer.name_chars;
                                                length = cArr.length;
                                                i3 = serializeWriter.count + length;
                                                if (i3 <= serializeWriter.buf.length) {
                                                    i4 = z26 ? 1 : 0;
                                                } else if (serializeWriter.writer == null) {
                                                    serializeWriter.expandCapacity(i3);
                                                    i4 = z26 ? 1 : 0;
                                                } else {
                                                    i5 = z26 ? 1 : 0;
                                                    do {
                                                        int length10 = serializeWriter.buf.length - serializeWriter.count;
                                                        System.arraycopy(cArr, i5, serializeWriter.buf, serializeWriter.count, length10);
                                                        serializeWriter.count = serializeWriter.buf.length;
                                                        serializeWriter.flush();
                                                        length -= length10;
                                                        i5 += length10;
                                                    } while (length > serializeWriter.buf.length);
                                                    i4 = i5;
                                                    i3 = length;
                                                }
                                                System.arraycopy(cArr, i4, serializeWriter.buf, serializeWriter.count, length);
                                                serializeWriter.count = i3;
                                            } else {
                                                fieldSerializer.writePrefix(jSONSerializer);
                                            }
                                        }
                                        if (z5) {
                                            if (!z30) {
                                                if (cls == String.class) {
                                                    int i1114 = fieldSerializer.features | this.features;
                                                    if (obj4 == null) {
                                                        if ((serializeWriter.features & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                            serializeWriter.writeString("");
                                                        } else {
                                                            serializeWriter.writeString("");
                                                        }
                                                    } else {
                                                        str2 = (String) obj4;
                                                        if (z9) {
                                                            serializeWriter.writeStringWithSingleQuote(str2);
                                                        } else {
                                                            serializeWriter.writeStringWithDoubleQuote(str2, (char) 0, true);
                                                        }
                                                    }
                                                } else if (!fieldInfo.isEnum) {
                                                    z10 = false;
                                                    fieldSerializer.writeValue(jSONSerializer, obj4);
                                                } else if (obj4 != null) {
                                                    if ((serializeWriter.features & SerializerFeature.WriteEnumUsingToString.mask) != 0) {
                                                        string = ((Enum) obj4).toString();
                                                        if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
                                                            z11 = true;
                                                        } else {
                                                            z11 = false;
                                                        }
                                                        if (z11) {
                                                            serializeWriter.writeStringWithSingleQuote(string);
                                                        } else {
                                                            z10 = false;
                                                            serializeWriter.writeStringWithDoubleQuote(string, (char) 0, false);
                                                        }
                                                    } else {
                                                        z10 = false;
                                                        serializeWriter.writeInt(((Enum) obj4).ordinal());
                                                    }
                                                } else {
                                                    z10 = false;
                                                    serializeWriter.writeNull();
                                                }
                                                z10 = false;
                                            } else {
                                                z10 = false;
                                                fieldSerializer.writeValue(jSONSerializer, obj4);
                                            }
                                        } else if (!z30) {
                                            if (cls == String.class) {
                                                int i1115 = fieldSerializer.features | this.features;
                                                if (obj4 == null) {
                                                    if ((serializeWriter.features & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                        serializeWriter.writeString("");
                                                    } else {
                                                        serializeWriter.writeString("");
                                                    }
                                                } else {
                                                    str2 = (String) obj4;
                                                    if (z9) {
                                                        serializeWriter.writeStringWithSingleQuote(str2);
                                                    } else {
                                                        serializeWriter.writeStringWithDoubleQuote(str2, (char) 0, true);
                                                    }
                                                }
                                            } else if (!fieldInfo.isEnum) {
                                                z10 = false;
                                                fieldSerializer.writeValue(jSONSerializer, obj4);
                                            } else if (obj4 != null) {
                                                if ((serializeWriter.features & SerializerFeature.WriteEnumUsingToString.mask) != 0) {
                                                    string = ((Enum) obj4).toString();
                                                    if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
                                                        z11 = true;
                                                    } else {
                                                        z11 = false;
                                                    }
                                                    if (z11) {
                                                        serializeWriter.writeStringWithSingleQuote(string);
                                                    } else {
                                                        z10 = false;
                                                        serializeWriter.writeStringWithDoubleQuote(string, (char) 0, false);
                                                    }
                                                } else {
                                                    z10 = false;
                                                    serializeWriter.writeInt(((Enum) obj4).ordinal());
                                                }
                                            } else {
                                                z10 = false;
                                                serializeWriter.writeNull();
                                            }
                                            z10 = false;
                                        } else {
                                            z10 = false;
                                            fieldSerializer.writeValue(jSONSerializer, obj4);
                                        }
                                    }
                                    z29 = true;
                                    z16 = z9;
                                    z15 = z8;
                                }
                                serialContext2 = serialContext2;
                                z10 = z26 ? 1 : 0;
                                z29 = true;
                                z16 = z9;
                                z15 = z8;
                            }
                        } else {
                            c = c3;
                        }
                        z19 = z32;
                        z20 = z33;
                        list = list2;
                        z18 = z20;
                        z17 = z19;
                        z18 = z9;
                        z17 = z8;
                        serialContext2 = serialContext2;
                        z10 = z26 ? 1 : 0;
                        z16 = z18;
                        z15 = z17;
                    } else {
                        c = c3;
                        z19 = z32;
                        z20 = z33;
                        list = list2;
                        z18 = z20;
                        z17 = z19;
                        z18 = z9;
                        z17 = z8;
                        serialContext2 = serialContext2;
                        z10 = z26 ? 1 : 0;
                        z16 = z18;
                        z15 = z17;
                    }
                    try {
                        z26 = z10;
                        list3 = list6;
                        list4 = list7;
                        z31 = z34;
                        list2 = list;
                        z33 = z16;
                        c3 = c;
                        z32 = z15;
                        serialContext2 = serialContext2;
                        z27 = true;
                        i8 = i9 + 1;
                    } catch (Exception e) {
                        e = e;
                        serialContext = serialContext2;
                        if (obj2 != null) {
                            try {
                            } catch (Throwable th) {
                                th = th;
                                jSONSerializer.context = serialContext;
                                throw th;
                            }
                        }
                        throw new JSONException(obj2 != null ? "write javaBean error, fastjson version 1.1.72, fieldName : " + obj2 : "write javaBean error, fastjson version 1.1.72", e);
                    } catch (Throwable th2) {
                        th = th2;
                        serialContext = serialContext2;
                        jSONSerializer.context = serialContext;
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    serialContext2 = serialContext2;
                    serialContext = serialContext2;
                    throw new JSONException(obj2 != null ? "write javaBean error, fastjson version 1.1.72, fieldName : " + obj2 : "write javaBean error, fastjson version 1.1.72", e);
                } catch (Throwable th3) {
                    th = th3;
                    serialContext2 = serialContext2;
                    serialContext = serialContext2;
                    jSONSerializer.context = serialContext;
                    throw th;
                }
            }
            serialContext2 = serialContext2;
            char c4 = c3;
            boolean z35 = z26 ? 1 : 0;
            if (jSONSerializer.afterFilters != null) {
                char cWriteAfter = z29 ? ',' : z35 ? 1 : 0;
                Iterator<AfterFilter> it16 = jSONSerializer.afterFilters.iterator();
                while (it16.hasNext()) {
                    cWriteAfter = it16.next().writeAfter(jSONSerializer, obj, cWriteAfter);
                }
            }
            if (fieldSerializerArr.length > 0 && (serializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0) {
                jSONSerializer.decrementIdent();
                jSONSerializer.println();
            }
            int i25 = serializeWriter.count + 1;
            if (i25 <= serializeWriter.buf.length) {
                i = i25;
            } else if (serializeWriter.writer == null) {
                serializeWriter.expandCapacity(i25);
                i = i25;
            } else {
                serializeWriter.flush();
                i = 1;
            }
            serializeWriter.buf[serializeWriter.count] = c4;
            serializeWriter.count = i;
            jSONSerializer.context = serialContext2;
        } catch (Exception e3) {
            e = e3;
            serialContext = serialContext2;
        } catch (Throwable th4) {
            th = th4;
            serialContext = serialContext2;
        }
    }

    public Map<String, Object> getFieldValuesMap(Object obj) throws Exception {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
        }
        return linkedHashMap;
    }
}
