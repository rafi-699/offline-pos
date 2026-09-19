package com.ask.printersdk.graph;

import kotlin.Metadata;

/* JADX INFO: compiled from: ShapeStyle.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/ask/printersdk/graph/ShapeStyle;", "Lcom/ask/printersdk/graph/ImageStyle;", "<init>", "()V", "shapeType", "", "getShapeType", "()I", "setShapeType", "(I)V", "isDashed", "", "()Z", "setDashed", "(Z)V", "isRedTintColor", "setRedTintColor", "lineWeight", "", "getLineWeight", "()D", "setLineWeight", "(D)V", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShapeStyle extends ImageStyle {
    private boolean isDashed;
    private boolean isRedTintColor;
    private int shapeType = 5;
    private double lineWeight = 3.0d;

    public final int getShapeType() {
        return this.shapeType;
    }

    public final void setShapeType(int i) {
        this.shapeType = i;
    }

    /* JADX INFO: renamed from: isDashed, reason: from getter */
    public final boolean getIsDashed() {
        return this.isDashed;
    }

    public final void setDashed(boolean z) {
        this.isDashed = z;
    }

    /* JADX INFO: renamed from: isRedTintColor, reason: from getter */
    public final boolean getIsRedTintColor() {
        return this.isRedTintColor;
    }

    public final void setRedTintColor(boolean z) {
        this.isRedTintColor = z;
    }

    public final double getLineWeight() {
        return this.lineWeight;
    }

    public final void setLineWeight(double d) {
        this.lineWeight = d;
    }
}
