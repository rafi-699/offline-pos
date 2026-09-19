package com.ask.printersdk.graph.state;

import com.ask.printersdk.graph.BoardStyle;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StateNode.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0007\"\u0004\b \u0010\tR\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/ask/printersdk/graph/state/StateNode;", "", "<init>", "()V", "selectId", "", "getSelectId", "()J", "setSelectId", "(J)V", "boardGraph", "Lcom/ask/printersdk/graph/BoardStyle;", "getBoardGraph", "()Lcom/ask/printersdk/graph/BoardStyle;", "setBoardGraph", "(Lcom/ask/printersdk/graph/BoardStyle;)V", "graphList", "Ljava/util/ArrayList;", "Lcom/ask/printersdk/graph/state/GraphState;", "Lkotlin/collections/ArrayList;", "getGraphList", "()Ljava/util/ArrayList;", "setGraphList", "(Ljava/util/ArrayList;)V", "imagePath", "", "getImagePath", "()Ljava/lang/String;", "setImagePath", "(Ljava/lang/String;)V", "draftId", "getDraftId", "setDraftId", "isPictureEditing", "", "()Z", "setPictureEditing", "(Z)V", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StateNode {
    private BoardStyle boardGraph;
    private boolean isPictureEditing;
    private long selectId = -1;
    private ArrayList<GraphState> graphList = new ArrayList<>();
    private String imagePath = "";
    private long draftId = -1;

    public final long getSelectId() {
        return this.selectId;
    }

    public final void setSelectId(long j) {
        this.selectId = j;
    }

    public final BoardStyle getBoardGraph() {
        return this.boardGraph;
    }

    public final void setBoardGraph(BoardStyle boardStyle) {
        this.boardGraph = boardStyle;
    }

    public final ArrayList<GraphState> getGraphList() {
        return this.graphList;
    }

    public final void setGraphList(ArrayList<GraphState> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.graphList = arrayList;
    }

    public final String getImagePath() {
        return this.imagePath;
    }

    public final void setImagePath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imagePath = str;
    }

    public final long getDraftId() {
        return this.draftId;
    }

    public final void setDraftId(long j) {
        this.draftId = j;
    }

    /* JADX INFO: renamed from: isPictureEditing, reason: from getter */
    public final boolean getIsPictureEditing() {
        return this.isPictureEditing;
    }

    public final void setPictureEditing(boolean z) {
        this.isPictureEditing = z;
    }
}
