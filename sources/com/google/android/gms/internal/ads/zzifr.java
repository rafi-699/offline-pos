package com.google.android.gms.internal.ads;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.text.Typography;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzifr {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    static String zza(zzifp zzifpVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzc(zzifpVar, sb, 0);
        return sb.toString();
    }

    static void zzb(StringBuilder sb, int i, String str, Object obj) {
        String strReplace;
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzb(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zzb(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        zzd(i, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i2 = 1; i2 < str.length(); i2++) {
                char cCharAt = str.charAt(i2);
                if (Character.isUpperCase(cCharAt)) {
                    sb2.append("_");
                }
                sb2.append(Character.toLowerCase(cCharAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (!(obj instanceof String)) {
            if (obj instanceof zzida) {
                sb.append(": \"");
                sb.append(zzigp.zza(((zzida) obj).zzA()));
                sb.append(Typography.quote);
                return;
            }
            if (obj instanceof zziee) {
                sb.append(" {");
                zzc((zziee) obj, sb, i + 2);
                sb.append("\n");
                zzd(i, sb);
                sb.append("}");
                return;
            }
            if (!(obj instanceof Map.Entry)) {
                sb.append(": ");
                sb.append(obj);
                return;
            }
            int i3 = i + 2;
            sb.append(" {");
            Map.Entry entry = (Map.Entry) obj;
            zzb(sb, i3, SDKConstants.PARAM_KEY, entry.getKey());
            zzb(sb, i3, "value", entry.getValue());
            sb.append("\n");
            zzd(i, sb);
            sb.append("}");
            return;
        }
        sb.append(": \"");
        String strReplace2 = (String) obj;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i4 = 0; i4 < strReplace2.length(); i4++) {
            char cCharAt2 = strReplace2.charAt(i4);
            if (cCharAt2 < ' ' || cCharAt2 > '~') {
                strReplace = zzigp.zza(strReplace2.getBytes(StandardCharsets.UTF_8));
                sb.append(strReplace);
                sb.append(Typography.quote);
            } else {
                if (cCharAt2 == '\"') {
                    z3 = true;
                } else if (cCharAt2 == '\'') {
                    z2 = true;
                } else if (cCharAt2 == '\\') {
                    z = true;
                }
            }
        }
        if (z) {
            strReplace2 = strReplace2.replace("\\", "\\\\");
        }
        strReplace = z2 ? strReplace2.replace("'", "\\'") : strReplace2;
        if (z3) {
            strReplace = strReplace.replace("\"", "\\\"");
        }
        sb.append(strReplace);
        sb.append(Typography.quote);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0200  */
    /* JADX WARN: Code duplicated, block: B:102:0x020e  */
    /* JADX WARN: Code duplicated, block: B:129:0x0211 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:130:0x0211 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x0163  */
    /* JADX WARN: Code duplicated, block: B:59:0x017c  */
    /* JADX WARN: Code duplicated, block: B:61:0x0184  */
    /* JADX WARN: Code duplicated, block: B:63:0x0188  */
    /* JADX WARN: Code duplicated, block: B:65:0x0191  */
    /* JADX WARN: Code duplicated, block: B:66:0x0194  */
    /* JADX WARN: Code duplicated, block: B:68:0x0198  */
    /* JADX WARN: Code duplicated, block: B:71:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:73:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:76:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:78:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:81:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:83:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:84:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:86:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:89:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:99:0x01fe  */
    private static void zzc(zzifp zzifpVar, StringBuilder sb, int i) {
        int i2;
        Method method;
        Method method2;
        Object objZzbB;
        boolean zBooleanValue;
        boolean zEquals;
        Method method3;
        Method method4;
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzifpVar.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i3 = 0;
        while (true) {
            i2 = 3;
            if (i3 >= length) {
                break;
            }
            Method method5 = declaredMethods[i3];
            if (!Modifier.isStatic(method5.getModifiers()) && method5.getName().length() >= 3) {
                if (method5.getName().startsWith("set")) {
                    hashSet.add(method5.getName());
                } else if (Modifier.isPublic(method5.getModifiers()) && method5.getParameterTypes().length == 0) {
                    if (method5.getName().startsWith("has")) {
                        map.put(method5.getName(), method5);
                    } else if (method5.getName().startsWith("get")) {
                        treeMap.put(method5.getName(), method5);
                    }
                }
            }
            i3++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String strSubstring = ((String) entry.getKey()).substring(i2);
            if (strSubstring.endsWith("List") && !strSubstring.endsWith("OrBuilderList") && !strSubstring.equals("List") && (method4 = (Method) entry.getValue()) != null && method4.getReturnType().equals(List.class)) {
                zzb(sb, i, strSubstring.substring(0, strSubstring.length() - 4), zziee.zzbB(method4, zzifpVar, new Object[0]));
            } else if (!strSubstring.endsWith("Map") || strSubstring.equals("Map") || (method3 = (Method) entry.getValue()) == null || !method3.getReturnType().equals(Map.class) || method3.isAnnotationPresent(Deprecated.class) || !Modifier.isPublic(method3.getModifiers())) {
                String.valueOf(strSubstring);
                if (hashSet.contains("set".concat(String.valueOf(strSubstring)))) {
                    if (strSubstring.endsWith("Bytes")) {
                        String strSubstring2 = strSubstring.substring(0, strSubstring.length() - 5);
                        String.valueOf(strSubstring2);
                        if (!treeMap.containsKey("get".concat(String.valueOf(strSubstring2)))) {
                            method = (Method) entry.getValue();
                            String.valueOf(strSubstring);
                            method2 = (Method) map.get("has".concat(String.valueOf(strSubstring)));
                            if (method != null) {
                                objZzbB = zziee.zzbB(method, zzifpVar, new Object[0]);
                                if (method2 == null) {
                                    zBooleanValue = ((Boolean) zziee.zzbB(method2, zzifpVar, new Object[0])).booleanValue();
                                } else if (objZzbB instanceof Boolean) {
                                    if (((Boolean) objZzbB).booleanValue()) {
                                        zBooleanValue = true;
                                    } else {
                                        zBooleanValue = false;
                                    }
                                } else if (objZzbB instanceof Integer) {
                                    if (((Integer) objZzbB).intValue() == 0) {
                                        zBooleanValue = false;
                                    } else {
                                        zBooleanValue = true;
                                    }
                                } else if (objZzbB instanceof Float) {
                                    if (Float.floatToRawIntBits(((Float) objZzbB).floatValue()) == 0) {
                                        zBooleanValue = false;
                                    } else {
                                        zBooleanValue = true;
                                    }
                                } else if (objZzbB instanceof Double) {
                                    if (objZzbB instanceof String) {
                                        zEquals = objZzbB.equals("");
                                    } else if (objZzbB instanceof zzida) {
                                        zEquals = objZzbB.equals(zzida.zza);
                                    } else if ((objZzbB instanceof zzifp) ? !((objZzbB instanceof Enum) && ((Enum) objZzbB).ordinal() == 0) : objZzbB != ((zzifp) objZzbB).zzbw()) {
                                        zBooleanValue = true;
                                    } else {
                                        zBooleanValue = false;
                                    }
                                    if (zEquals) {
                                        zBooleanValue = false;
                                    } else {
                                        zBooleanValue = true;
                                    }
                                } else if (Double.doubleToRawLongBits(((Double) objZzbB).doubleValue()) == 0) {
                                    zBooleanValue = false;
                                } else {
                                    zBooleanValue = true;
                                }
                                if (zBooleanValue) {
                                    zzb(sb, i, strSubstring, objZzbB);
                                }
                            }
                        }
                    } else {
                        method = (Method) entry.getValue();
                        String.valueOf(strSubstring);
                        method2 = (Method) map.get("has".concat(String.valueOf(strSubstring)));
                        if (method != null) {
                            objZzbB = zziee.zzbB(method, zzifpVar, new Object[0]);
                            if (method2 == null) {
                                zBooleanValue = ((Boolean) zziee.zzbB(method2, zzifpVar, new Object[0])).booleanValue();
                            } else if (objZzbB instanceof Boolean) {
                                if (((Boolean) objZzbB).booleanValue()) {
                                    zBooleanValue = false;
                                } else {
                                    zBooleanValue = true;
                                }
                            } else if (objZzbB instanceof Integer) {
                                if (((Integer) objZzbB).intValue() == 0) {
                                    zBooleanValue = false;
                                } else {
                                    zBooleanValue = true;
                                }
                            } else if (objZzbB instanceof Float) {
                                if (Float.floatToRawIntBits(((Float) objZzbB).floatValue()) == 0) {
                                    zBooleanValue = false;
                                } else {
                                    zBooleanValue = true;
                                }
                            } else if (objZzbB instanceof Double) {
                                if (objZzbB instanceof String) {
                                    zEquals = objZzbB.equals("");
                                } else if (objZzbB instanceof zzida) {
                                    zEquals = objZzbB.equals(zzida.zza);
                                } else if (objZzbB instanceof zzifp) {
                                    zBooleanValue = true;
                                } else {
                                    zBooleanValue = true;
                                }
                                if (zEquals) {
                                    zBooleanValue = false;
                                } else {
                                    zBooleanValue = true;
                                }
                            } else if (Double.doubleToRawLongBits(((Double) objZzbB).doubleValue()) == 0) {
                                zBooleanValue = false;
                            } else {
                                zBooleanValue = true;
                            }
                            if (zBooleanValue) {
                                zzb(sb, i, strSubstring, objZzbB);
                            }
                        }
                    }
                }
            } else {
                zzb(sb, i, strSubstring.substring(0, strSubstring.length() - 3), zziee.zzbB(method3, zzifpVar, new Object[0]));
            }
            i2 = 3;
        }
        if (zzifpVar instanceof zziea) {
            Iterator itZzc = ((zziea) zzifpVar).zza.zzc();
            while (itZzc.hasNext()) {
                Map.Entry entry2 = (Map.Entry) itZzc.next();
                int i4 = ((zzieb) entry2.getKey()).zza;
                StringBuilder sb2 = new StringBuilder(String.valueOf(i4).length() + 2);
                sb2.append("[");
                sb2.append(i4);
                sb2.append("]");
                zzb(sb, i, sb2.toString(), entry2.getValue());
            }
        }
        zzigu zziguVar = ((zziee) zzifpVar).zzt;
        if (zziguVar != null) {
            zziguVar.zzj(sb, i);
        }
    }

    private static void zzd(int i, StringBuilder sb) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb.append(zza, 0, i2);
            i -= i2;
        }
    }
}
