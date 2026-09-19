package com.google.android.gms.internal.measurement;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.text.Typography;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@23.0.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzno {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    static String zza(zznm zznmVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzc(zznmVar, sb, 0);
        return sb.toString();
    }

    static void zzb(StringBuilder sb, int i, String str, Object obj) {
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
        if (obj instanceof String) {
            sb.append(": \"");
            zzlh zzlhVar = zzlh.zzb;
            sb.append(zzog.zza(new zzlg(((String) obj).getBytes(zzmp.zza))));
            sb.append(Typography.quote);
            return;
        }
        if (obj instanceof zzlh) {
            sb.append(": \"");
            sb.append(zzog.zza((zzlh) obj));
            sb.append(Typography.quote);
            return;
        }
        if (obj instanceof zzmf) {
            sb.append(" {");
            zzc((zzmf) obj, sb, i + 2);
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
    }

    /* JADX WARN: Code duplicated, block: B:101:0x020c  */
    /* JADX WARN: Code duplicated, block: B:129:0x020f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:130:0x020f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:131:0x020f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:0x020f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:133:0x020f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:134:0x020f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:135:0x020f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:137:0x020f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x0163  */
    /* JADX WARN: Code duplicated, block: B:59:0x017c  */
    /* JADX WARN: Code duplicated, block: B:61:0x0184  */
    /* JADX WARN: Code duplicated, block: B:63:0x0188  */
    /* JADX WARN: Code duplicated, block: B:66:0x0193  */
    /* JADX WARN: Code duplicated, block: B:68:0x0197  */
    /* JADX WARN: Code duplicated, block: B:71:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:73:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:76:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:78:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:81:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:83:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:84:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:86:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:89:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:91:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:94:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:99:0x01fe  */
    private static void zzc(zznm zznmVar, StringBuilder sb, int i) {
        int i2;
        Method method;
        Method method2;
        Object objZzcr;
        boolean zEquals;
        Method method3;
        Method method4;
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zznmVar.getClass().getDeclaredMethods();
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
                zzb(sb, i, strSubstring.substring(0, strSubstring.length() - 4), zzmf.zzcr(method4, zznmVar, new Object[0]));
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
                                objZzcr = zzmf.zzcr(method, zznmVar, new Object[0]);
                                if (method2 == null) {
                                    if (objZzcr instanceof Boolean) {
                                        if (((Boolean) objZzcr).booleanValue()) {
                                            zzb(sb, i, strSubstring, objZzcr);
                                        }
                                    } else if (objZzcr instanceof Integer) {
                                        if (((Integer) objZzcr).intValue() != 0) {
                                            zzb(sb, i, strSubstring, objZzcr);
                                        }
                                    } else if (objZzcr instanceof Float) {
                                        if (Float.floatToRawIntBits(((Float) objZzcr).floatValue()) != 0) {
                                            zzb(sb, i, strSubstring, objZzcr);
                                        }
                                    } else if (objZzcr instanceof Double) {
                                        if (objZzcr instanceof String) {
                                            zEquals = objZzcr.equals("");
                                        } else if (objZzcr instanceof zzlh) {
                                            zEquals = objZzcr.equals(zzlh.zzb);
                                        } else if (objZzcr instanceof zznm) {
                                            if (objZzcr != ((zznm) objZzcr).zzcE()) {
                                                zzb(sb, i, strSubstring, objZzcr);
                                            }
                                        } else if ((objZzcr instanceof Enum) || ((Enum) objZzcr).ordinal() != 0) {
                                            zzb(sb, i, strSubstring, objZzcr);
                                        }
                                        if (!zEquals) {
                                            zzb(sb, i, strSubstring, objZzcr);
                                        }
                                    } else if (Double.doubleToRawLongBits(((Double) objZzcr).doubleValue()) != 0) {
                                        zzb(sb, i, strSubstring, objZzcr);
                                    }
                                } else if (((Boolean) zzmf.zzcr(method2, zznmVar, new Object[0])).booleanValue()) {
                                    zzb(sb, i, strSubstring, objZzcr);
                                }
                            }
                        }
                    } else {
                        method = (Method) entry.getValue();
                        String.valueOf(strSubstring);
                        method2 = (Method) map.get("has".concat(String.valueOf(strSubstring)));
                        if (method != null) {
                            objZzcr = zzmf.zzcr(method, zznmVar, new Object[0]);
                            if (method2 == null) {
                                if (objZzcr instanceof Boolean) {
                                    if (((Boolean) objZzcr).booleanValue()) {
                                        zzb(sb, i, strSubstring, objZzcr);
                                    }
                                } else if (objZzcr instanceof Integer) {
                                    if (((Integer) objZzcr).intValue() != 0) {
                                        zzb(sb, i, strSubstring, objZzcr);
                                    }
                                } else if (objZzcr instanceof Float) {
                                    if (Float.floatToRawIntBits(((Float) objZzcr).floatValue()) != 0) {
                                        zzb(sb, i, strSubstring, objZzcr);
                                    }
                                } else if (objZzcr instanceof Double) {
                                    if (objZzcr instanceof String) {
                                        zEquals = objZzcr.equals("");
                                    } else if (objZzcr instanceof zzlh) {
                                        zEquals = objZzcr.equals(zzlh.zzb);
                                    } else if (objZzcr instanceof zznm) {
                                        if (objZzcr != ((zznm) objZzcr).zzcE()) {
                                            zzb(sb, i, strSubstring, objZzcr);
                                        }
                                    } else if (objZzcr instanceof Enum) {
                                        zzb(sb, i, strSubstring, objZzcr);
                                    } else {
                                        zzb(sb, i, strSubstring, objZzcr);
                                    }
                                    if (!zEquals) {
                                        zzb(sb, i, strSubstring, objZzcr);
                                    }
                                } else if (Double.doubleToRawLongBits(((Double) objZzcr).doubleValue()) != 0) {
                                    zzb(sb, i, strSubstring, objZzcr);
                                }
                            } else if (((Boolean) zzmf.zzcr(method2, zznmVar, new Object[0])).booleanValue()) {
                                zzb(sb, i, strSubstring, objZzcr);
                            }
                        }
                    }
                }
            } else {
                zzb(sb, i, strSubstring.substring(0, strSubstring.length() - 3), zzmf.zzcr(method3, zznmVar, new Object[0]));
            }
            i2 = 3;
        }
        if (zznmVar instanceof zzmc) {
            Iterator itZzc = ((zzmc) zznmVar).zzb.zzc();
            if (itZzc.hasNext()) {
                throw null;
            }
        }
        zzoj zzojVar = ((zzmf) zznmVar).zzc;
        if (zzojVar != null) {
            zzojVar.zzj(sb, i);
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
