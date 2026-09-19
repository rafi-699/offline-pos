package com.ask.printersdk.graph.state;

import com.ask.printersdk.utils.BoundedStack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StateManger.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006J\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006J\b\u0010\f\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006J\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u000f\u001a\u00020\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ask/printersdk/graph/state/StateManger;", "", "<init>", "()V", "backwardStateStack", "Lcom/ask/printersdk/utils/BoundedStack;", "Lcom/ask/printersdk/graph/state/StateNode;", "forwardStateStack", "pushBackwardState", "", "node", "popBackwardState", "peekBackwardState", "pushForwardState", "popForwardState", "cleanForwardState", "getBackwardStepCount", "", "getForwardStepCount", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StateManger {
    private final BoundedStack<StateNode> backwardStateStack = new BoundedStack<>(30);
    private final BoundedStack<StateNode> forwardStateStack = new BoundedStack<>(30);

    public final void pushBackwardState(StateNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.backwardStateStack.push(node);
    }

    public final StateNode popBackwardState() {
        return this.backwardStateStack.pop();
    }

    public final StateNode peekBackwardState() {
        return this.backwardStateStack.peek();
    }

    public final void pushForwardState(StateNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.forwardStateStack.push(node);
    }

    public final StateNode popForwardState() {
        return this.forwardStateStack.pop();
    }

    public final void cleanForwardState() {
        this.forwardStateStack.clean();
    }

    public final int getBackwardStepCount() {
        return this.backwardStateStack.size();
    }

    public final int getForwardStepCount() {
        return this.forwardStateStack.size();
    }
}
