package com.ask.printersdk.graph;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimeStyle.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\u001a\u0010\u001d\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\u001a\u0010\u001f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\b¨\u0006!"}, d2 = {"Lcom/ask/printersdk/graph/TimeStyle;", "Lcom/ask/printersdk/graph/TextStyle;", "<init>", "()V", "isRealTime", "", "()Z", "setRealTime", "(Z)V", "prefixText", "", "getPrefixText", "()Ljava/lang/String;", "setPrefixText", "(Ljava/lang/String;)V", "dateStyle", "getDateStyle", "setDateStyle", "currentDate", "Ljava/util/Date;", "getCurrentDate", "()Ljava/util/Date;", "setCurrentDate", "(Ljava/util/Date;)V", "timeStyle", "getTimeStyle", "setTimeStyle", "isShowDate", "setShowDate", "isShowTime", "setShowTime", "is24Hour", "set24Hour", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TimeStyle extends TextStyle {
    private boolean isRealTime = true;
    private String prefixText = "";
    private String dateStyle = "yyyy-MM-dd";
    private Date currentDate = new Date();
    private String timeStyle = "HH:mm:ss";
    private boolean isShowDate = true;
    private boolean isShowTime = true;
    private boolean is24Hour = true;

    /* JADX INFO: renamed from: isRealTime, reason: from getter */
    public final boolean getIsRealTime() {
        return this.isRealTime;
    }

    public final void setRealTime(boolean z) {
        this.isRealTime = z;
    }

    public final String getPrefixText() {
        return this.prefixText;
    }

    public final void setPrefixText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.prefixText = str;
    }

    public final String getDateStyle() {
        return this.dateStyle;
    }

    public final void setDateStyle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dateStyle = str;
    }

    public final Date getCurrentDate() {
        return this.currentDate;
    }

    public final void setCurrentDate(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.currentDate = date;
    }

    public final String getTimeStyle() {
        return this.timeStyle;
    }

    public final void setTimeStyle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.timeStyle = str;
    }

    /* JADX INFO: renamed from: isShowDate, reason: from getter */
    public final boolean getIsShowDate() {
        return this.isShowDate;
    }

    public final void setShowDate(boolean z) {
        this.isShowDate = z;
    }

    /* JADX INFO: renamed from: isShowTime, reason: from getter */
    public final boolean getIsShowTime() {
        return this.isShowTime;
    }

    public final void setShowTime(boolean z) {
        this.isShowTime = z;
    }

    /* JADX INFO: renamed from: is24Hour, reason: from getter */
    public final boolean getIs24Hour() {
        return this.is24Hour;
    }

    public final void set24Hour(boolean z) {
        this.is24Hour = z;
    }
}
