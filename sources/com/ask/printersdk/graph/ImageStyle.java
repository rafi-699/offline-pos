package com.ask.printersdk.graph;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageStyle.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/ask/printersdk/graph/ImageStyle;", "Lcom/ask/printersdk/graph/Style;", "<init>", "()V", "id", "", "getId", "()J", "setId", "(J)V", "imagePath", "", "getImagePath", "()Ljava/lang/String;", "setImagePath", "(Ljava/lang/String;)V", "imageUrl", "getImageUrl", "setImageUrl", "matrixValues", "", "getMatrixValues", "()[F", "setMatrixValues", "([F)V", "equalRatioScale", "", "getEqualRatioScale", "()Z", "setEqualRatioScale", "(Z)V", "contrast", "", "getContrast", "()I", "setContrast", "(I)V", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ImageStyle implements Style {
    private int contrast;

    @JSONField(serialize = false)
    private boolean equalRatioScale;
    private long id;
    private String imagePath = "";
    private String imageUrl = "";
    private float[] matrixValues;

    public ImageStyle() {
        float[] fArr = new float[9];
        for (int i = 0; i < 9; i++) {
            fArr[i] = 0.0f;
        }
        this.matrixValues = fArr;
        this.equalRatioScale = true;
        this.contrast = 50;
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final String getImagePath() {
        return this.imagePath;
    }

    public final void setImagePath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imagePath = str;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final void setImageUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imageUrl = str;
    }

    public final float[] getMatrixValues() {
        return this.matrixValues;
    }

    public final void setMatrixValues(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.matrixValues = fArr;
    }

    public final boolean getEqualRatioScale() {
        return this.equalRatioScale;
    }

    public final void setEqualRatioScale(boolean z) {
        this.equalRatioScale = z;
    }

    public final int getContrast() {
        return this.contrast;
    }

    public final void setContrast(int i) {
        this.contrast = i;
    }
}
