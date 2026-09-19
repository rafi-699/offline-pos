package com.ask.printersdk.utils;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: BoundedStack.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0002\u0010\fJ\r\u0010\r\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u000eJ\r\u0010\u000f\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\nJ\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ask/printersdk/utils/BoundedStack;", ExifInterface.LONGITUDE_EAST, "", SDKConstants.PARAM_CONTEXT_MAX_SIZE, "", "<init>", "(I)V", "elements", "", "push", "", "item", "(Ljava/lang/Object;)V", "pop", "()Ljava/lang/Object;", "peek", "isEmpty", "", "size", "clean", InAppPurchaseConstants.METHOD_TO_STRING, "", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BoundedStack<E> {
    private final List<E> elements = new ArrayList();
    private final int maxSize;

    public BoundedStack(int i) {
        this.maxSize = i;
    }

    public final void push(E item) {
        if (this.elements.size() == this.maxSize) {
            this.elements.remove(0);
        }
        this.elements.add(item);
    }

    public final E pop() {
        if (this.elements.isEmpty()) {
            return null;
        }
        List<E> list = this.elements;
        return list.remove(list.size() - 1);
    }

    public final E peek() {
        return (E) CollectionsKt.lastOrNull((List) this.elements);
    }

    public final boolean isEmpty() {
        return this.elements.isEmpty();
    }

    public final int size() {
        return this.elements.size();
    }

    public final void clean() {
        this.elements.clear();
    }

    public String toString() {
        return "BoundedStack(" + CollectionsKt.joinToString$default(this.elements, null, null, null, 0, null, null, 63, null) + ")";
    }
}
