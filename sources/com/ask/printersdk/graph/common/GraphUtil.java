package com.ask.printersdk.graph.common;

import android.graphics.Matrix;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GraphUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/ask/printersdk/graph/common/GraphUtil;", "", "<init>", "()V", "autoIncId", "", "getAutoIncId", "matrixWidth", "", "matrix", "Landroid/graphics/Matrix;", "width", "matrixHeight", "height", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GraphUtil {
    public static final GraphUtil INSTANCE = new GraphUtil();
    private static long autoIncId = System.currentTimeMillis();

    private GraphUtil() {
    }

    public final long getAutoIncId() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = autoIncId;
        if (j == jCurrentTimeMillis) {
            autoIncId = j + 1;
        } else {
            autoIncId = jCurrentTimeMillis;
        }
        return autoIncId;
    }

    public final float matrixWidth(Matrix matrix, float width) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        float[] fArr = {0.0f, 0.0f, width, 0.0f};
        matrix.mapPoints(fArr);
        double d = 2;
        return (float) Math.sqrt(((float) Math.pow(fArr[2] - fArr[0], d)) + ((float) Math.pow(fArr[3] - fArr[1], d)));
    }

    public final float matrixHeight(Matrix matrix, float height) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        float[] fArr = {0.0f, 0.0f, 0.0f, height};
        matrix.mapPoints(fArr);
        double d = 2;
        return (float) Math.sqrt(((float) Math.pow(fArr[2] - fArr[0], d)) + ((float) Math.pow(fArr[3] - fArr[1], d)));
    }
}
