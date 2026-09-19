package com.ask.printersdk.graph;

import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.ask.printersdk.utils.DateUtil;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: TimeGraph.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/ask/printersdk/graph/TimeGraph;", "Lcom/ask/printersdk/graph/TextGraph;", "context", "Landroid/content/Context;", "text", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "refreshTimeText", "", "initStyle", "Lcom/ask/printersdk/graph/TextStyle;", "restoreState", "json", "getOrderBy", "", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TimeGraph extends TextGraph {
    @Override // com.ask.printersdk.graph.TextGraph, com.ask.printersdk.graph.Graph
    public int getOrderBy() {
        return 70;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimeGraph(Context context, String text) {
        super(context, text);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(text, "text");
    }

    public /* synthetic */ TimeGraph(Context context, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? "" : str);
    }

    public final void refreshTimeText() {
        TextStyle style = getStyle();
        Intrinsics.checkNotNull(style, "null cannot be cast to non-null type com.ask.printersdk.graph.TimeStyle");
        TimeStyle timeStyle = (TimeStyle) style;
        String str = "";
        if (!Intrinsics.areEqual(timeStyle.getPrefixText(), "")) {
            str = timeStyle.getPrefixText() + "：";
        }
        if (timeStyle.getIsShowDate()) {
            str = ((Object) str) + (timeStyle.getIsRealTime() ? DateUtil.INSTANCE.formatDate(new Date(), timeStyle.getDateStyle()) : DateUtil.INSTANCE.formatDate(timeStyle.getCurrentDate(), timeStyle.getDateStyle()));
        }
        if (timeStyle.getIsShowTime()) {
            if (timeStyle.getIsShowDate()) {
                str = ((Object) str) + StringUtils.SPACE;
            }
            str = ((Object) str) + (timeStyle.getIsRealTime() ? DateUtil.INSTANCE.formatDate(new Date(), timeStyle.getTimeStyle()) : DateUtil.INSTANCE.formatDate(timeStyle.getCurrentDate(), timeStyle.getTimeStyle()));
        }
        updateText(str);
    }

    @Override // com.ask.printersdk.graph.TextGraph, com.ask.printersdk.graph.Graph
    public TextStyle initStyle() {
        return new TimeStyle();
    }

    @Override // com.ask.printersdk.graph.TextGraph, com.ask.printersdk.graph.Graph
    public void restoreState(String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        super.restoreState(json);
        Object object = JSON.parseObject(json, (Class<Object>) TimeStyle.class);
        Intrinsics.checkNotNullExpressionValue(object, "parseObject(...)");
        setStyle((TextStyle) object);
    }
}
