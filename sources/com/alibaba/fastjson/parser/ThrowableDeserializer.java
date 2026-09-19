package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ThrowableDeserializer extends JavaBeanDeserializer {
    public ThrowableDeserializer(ParserConfig parserConfig, Class<?> cls) {
        super(parserConfig, cls, cls);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0036  */
    /* JADX WARN: Code duplicated, block: B:98:0x0185  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r8v4 */
    @Override // com.alibaba.fastjson.parser.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Class<?> clsLoadClass;
        Object objStringVal;
        String str;
        Object obj2;
        int i;
        JavaBeanDeserializer javaBeanDeserializer;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        Type type2 = null;
        if (jSONLexer.token == 8) {
            jSONLexer.nextToken();
            return null;
        }
        int i2 = 0;
        if (defaultJSONParser.resolveStatus == 2) {
            defaultJSONParser.resolveStatus = 0;
        } else if (jSONLexer.token != 12) {
            throw new JSONException("syntax error");
        }
        if (type == null || !(type instanceof Class)) {
            clsLoadClass = null;
        } else {
            clsLoadClass = (Class) type;
            if (!Throwable.class.isAssignableFrom(clsLoadClass)) {
                clsLoadClass = null;
            }
        }
        HashMap map = null;
        Throwable th = null;
        Object obj3 = null;
        StackTraceElement[] stackTraceElementArr = null;
        while (true) {
            String strScanSymbol = jSONLexer.scanSymbol(defaultJSONParser.symbolTable);
            if (strScanSymbol == null) {
                if (jSONLexer.token == 13) {
                    jSONLexer.nextToken(16);
                    str = obj3;
                    break;
                }
                if (jSONLexer.token == 16) {
                    continue;
                }
                obj3 = obj3;
            }
            jSONLexer.nextTokenWithChar(':');
            if (JSON.DEFAULT_TYPE_KEY.equals(strScanSymbol)) {
                if (jSONLexer.token == 4) {
                    clsLoadClass = TypeUtils.loadClass(jSONLexer.stringVal(), defaultJSONParser.config.defaultClassLoader, false);
                    jSONLexer.nextToken(16);
                    obj3 = obj3;
                } else {
                    throw new JSONException("syntax error");
                }
            } else if ("message".equals(strScanSymbol)) {
                if (jSONLexer.token == 8) {
                    objStringVal = type2;
                } else if (jSONLexer.token == 4) {
                    objStringVal = jSONLexer.stringVal();
                } else {
                    throw new JSONException("syntax error");
                }
                jSONLexer.nextToken();
                obj3 = objStringVal;
            } else if ("cause".equals(strScanSymbol)) {
                th = (Throwable) deserialze(defaultJSONParser, type2, "cause");
                obj3 = obj3;
            } else if ("stackTrace".equals(strScanSymbol)) {
                stackTraceElementArr = (StackTraceElement[]) defaultJSONParser.parseObject((Class) StackTraceElement[].class);
                obj3 = obj3;
            } else {
                if (map == null) {
                    map = new HashMap();
                }
                map.put(strScanSymbol, defaultJSONParser.parse());
                obj3 = obj3;
            }
            if (jSONLexer.token == 13) {
                jSONLexer.nextToken(16);
                str = obj3;
                break;
            }
            type2 = null;
            obj3 = obj3;
        }
        if (clsLoadClass == null) {
            obj2 = (T) new Exception(str, th);
        } else {
            try {
                Constructor<?>[] constructors = clsLoadClass.getConstructors();
                int length = constructors.length;
                Type type3 = type2;
                Type type4 = type3;
                Constructor constructor = type4;
                int i3 = 0;
                Constructor constructor2 = type3;
                Constructor constructor3 = type4;
                while (i3 < length) {
                    Constructor<?> constructor4 = constructors[i3];
                    if (constructor4.getParameterTypes().length == 0) {
                        i = i2;
                        constructor = constructor4;
                    } else {
                        i = i2;
                        if (constructor4.getParameterTypes().length == 1 && constructor4.getParameterTypes()[i] == String.class) {
                            constructor3 = constructor4;
                        } else if (constructor4.getParameterTypes().length == 2 && constructor4.getParameterTypes()[i] == String.class && constructor4.getParameterTypes()[1] == Throwable.class) {
                            constructor2 = constructor4;
                        }
                    }
                    i3++;
                    i2 = i;
                    constructor2 = constructor2;
                    constructor3 = constructor3;
                    constructor = constructor;
                }
                int i4 = i2;
                if (constructor2 != 0) {
                    obj2 = (T) ((Throwable) constructor2.newInstance(str, th));
                } else if (constructor3 != 0) {
                    obj2 = (Throwable) constructor3.newInstance(str);
                } else {
                    obj2 = constructor != 0 ? (Throwable) constructor.newInstance(new Object[i4]) : null;
                }
                if (obj2 == null) {
                    obj2 = (T) new Exception(str, th);
                }
            } catch (Exception e) {
                throw new JSONException("create instance error", e);
            }
        }
        if (stackTraceElementArr != null) {
            ((Throwable) obj2).setStackTrace(stackTraceElementArr);
        }
        if (map != null) {
            if (clsLoadClass == null) {
                javaBeanDeserializer = null;
            } else if (clsLoadClass == this.clazz) {
                javaBeanDeserializer = this;
            } else {
                ObjectDeserializer deserializer = defaultJSONParser.config.getDeserializer(clsLoadClass);
                if (deserializer instanceof JavaBeanDeserializer) {
                    javaBeanDeserializer = (JavaBeanDeserializer) deserializer;
                } else {
                    javaBeanDeserializer = null;
                }
            }
            if (javaBeanDeserializer != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str2 = (String) entry.getKey();
                    Object value = entry.getValue();
                    FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(str2);
                    if (fieldDeserializer != null) {
                        fieldDeserializer.setValue(obj2, value);
                    }
                }
            }
        }
        return (T) obj2;
    }
}
