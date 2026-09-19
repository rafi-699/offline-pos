package com.swmansion.reanimated.pseudoSelectors;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.fabric.FabricUIManager;
import com.swmansion.reanimated.nativeProxy.PseudoSelectorCallback;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: PseudoSelectorManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000eJ \u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J \u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J \u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J \u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J \u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J\u0016\u0010 \u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016J \u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0002J\u0018\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020\"H\u0002J\u0018\u0010*\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010#\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0011j\b\u0012\u0004\u0012\u00020\r`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/swmansion/reanimated/pseudoSelectors/PseudoSelectorManager;", "", "fabricUIManager", "Lcom/facebook/react/fabric/FabricUIManager;", "<init>", "(Lcom/facebook/react/fabric/FabricUIManager;)V", "detachActions", "Ljava/util/HashMap;", "", "Ljava/lang/Runnable;", "Lkotlin/collections/HashMap;", "activeCallbacks", "Ljava/util/LinkedHashMap;", "Landroid/view/View;", "Lcom/swmansion/reanimated/nativeProxy/PseudoSelectorCallback;", "Lkotlin/collections/LinkedHashMap;", "activeDeepestViews", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "attach", "", "tag", "", "selector", "callback", "attachFocusWithin", ViewHierarchyConstants.VIEW_KEY, SDKConstants.PARAM_KEY, "attachFocus", "attachHover", "attachActive", "attachActiveDeepest", "detach", "hasDeepestDescendantAt", "", "ancestor", "rawX", "", "rawY", "fireActiveCallbacksUpTree", "source", "isActive", "isDescendantOf", "react-native-reanimated_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PseudoSelectorManager {
    private final LinkedHashMap<View, PseudoSelectorCallback> activeCallbacks;
    private final LinkedHashSet<View> activeDeepestViews;
    private final HashMap<String, Runnable> detachActions;
    private final FabricUIManager fabricUIManager;

    public PseudoSelectorManager(FabricUIManager fabricUIManager) {
        Intrinsics.checkNotNullParameter(fabricUIManager, "fabricUIManager");
        this.fabricUIManager = fabricUIManager;
        this.detachActions = new HashMap<>();
        this.activeCallbacks = new LinkedHashMap<>();
        this.activeDeepestViews = new LinkedHashSet<>();
    }

    public final void attach(final int tag, final int selector, final PseudoSelectorCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.swmansion.reanimated.pseudoSelectors.PseudoSelectorManager$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                PseudoSelectorManager.attach$lambda$0(this.f$0, tag, selector, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void attach$lambda$0(PseudoSelectorManager pseudoSelectorManager, int i, int i2, PseudoSelectorCallback pseudoSelectorCallback) {
        View viewResolveView = pseudoSelectorManager.fabricUIManager.resolveView(i);
        if (viewResolveView == null) {
            return;
        }
        String str = i + ":" + i2;
        if (i2 == 0) {
            pseudoSelectorManager.attachFocusWithin(viewResolveView, str, pseudoSelectorCallback);
            return;
        }
        if (i2 == 1) {
            pseudoSelectorManager.attachFocus(viewResolveView, str, pseudoSelectorCallback);
            return;
        }
        if (i2 == 2) {
            pseudoSelectorManager.attachHover(viewResolveView, str, pseudoSelectorCallback);
        } else if (i2 == 3) {
            pseudoSelectorManager.attachActive(viewResolveView, str, pseudoSelectorCallback);
        } else {
            if (i2 != 4) {
                return;
            }
            pseudoSelectorManager.attachActiveDeepest(viewResolveView, str, pseudoSelectorCallback);
        }
    }

    private final void attachFocusWithin(final View view, String key, final PseudoSelectorCallback callback) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener = new ViewTreeObserver.OnGlobalFocusChangeListener() { // from class: com.swmansion.reanimated.pseudoSelectors.PseudoSelectorManager$$ExternalSyntheticLambda1
            @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
            public final void onGlobalFocusChanged(View view2, View view3) {
                PseudoSelectorManager.attachFocusWithin$lambda$1(view, booleanRef, callback, view2, view3);
            }
        };
        view.getViewTreeObserver().addOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
        this.detachActions.put(key, new Runnable() { // from class: com.swmansion.reanimated.pseudoSelectors.PseudoSelectorManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                PseudoSelectorManager.attachFocusWithin$lambda$2(view, onGlobalFocusChangeListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void attachFocusWithin$lambda$1(View view, Ref.BooleanRef booleanRef, PseudoSelectorCallback pseudoSelectorCallback, View view2, View view3) {
        boolean zHasFocus = view.hasFocus();
        if (zHasFocus && !booleanRef.element) {
            booleanRef.element = true;
            pseudoSelectorCallback.onSelectorStateChanged(true);
        } else {
            if (zHasFocus || !booleanRef.element) {
                return;
            }
            booleanRef.element = false;
            pseudoSelectorCallback.onSelectorStateChanged(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void attachFocusWithin$lambda$2(View view, ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener) {
        view.getViewTreeObserver().removeOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
    }

    private final void attachFocus(final View view, String key, final PseudoSelectorCallback callback) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener = new ViewTreeObserver.OnGlobalFocusChangeListener() { // from class: com.swmansion.reanimated.pseudoSelectors.PseudoSelectorManager$$ExternalSyntheticLambda9
            @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
            public final void onGlobalFocusChanged(View view2, View view3) {
                PseudoSelectorManager.attachFocus$lambda$3(view, booleanRef, callback, view2, view3);
            }
        };
        view.getViewTreeObserver().addOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
        this.detachActions.put(key, new Runnable() { // from class: com.swmansion.reanimated.pseudoSelectors.PseudoSelectorManager$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                PseudoSelectorManager.attachFocus$lambda$4(view, onGlobalFocusChangeListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void attachFocus$lambda$3(View view, Ref.BooleanRef booleanRef, PseudoSelectorCallback pseudoSelectorCallback, View view2, View view3) {
        boolean zAreEqual = Intrinsics.areEqual(view3, view);
        if (zAreEqual && !booleanRef.element) {
            booleanRef.element = true;
            pseudoSelectorCallback.onSelectorStateChanged(true);
        } else {
            if (zAreEqual || !booleanRef.element) {
                return;
            }
            booleanRef.element = false;
            pseudoSelectorCallback.onSelectorStateChanged(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void attachFocus$lambda$4(View view, ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener) {
        view.getViewTreeObserver().removeOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
    }

    private final void attachHover(final View view, String key, final PseudoSelectorCallback callback) {
        view.setOnHoverListener(new View.OnHoverListener() { // from class: com.swmansion.reanimated.pseudoSelectors.PseudoSelectorManager$$ExternalSyntheticLambda4
            @Override // android.view.View.OnHoverListener
            public final boolean onHover(View view2, MotionEvent motionEvent) {
                return PseudoSelectorManager.attachHover$lambda$5(callback, view2, motionEvent);
            }
        });
        this.detachActions.put(key, new Runnable() { // from class: com.swmansion.reanimated.pseudoSelectors.PseudoSelectorManager$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                view.setOnHoverListener(null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean attachHover$lambda$5(PseudoSelectorCallback pseudoSelectorCallback, View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            pseudoSelectorCallback.onSelectorStateChanged(true);
        } else if (actionMasked == 10) {
            pseudoSelectorCallback.onSelectorStateChanged(false);
        }
        return false;
    }

    private final void attachActive(final View view, String key, PseudoSelectorCallback callback) {
        this.activeCallbacks.put(view, callback);
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.swmansion.reanimated.pseudoSelectors.PseudoSelectorManager$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return PseudoSelectorManager.attachActive$lambda$7(this.f$0, view, view2, motionEvent);
            }
        });
        this.detachActions.put(key, new Runnable() { // from class: com.swmansion.reanimated.pseudoSelectors.PseudoSelectorManager$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                PseudoSelectorManager.attachActive$lambda$8(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean attachActive$lambda$7(PseudoSelectorManager pseudoSelectorManager, View view, View view2, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            pseudoSelectorManager.fireActiveCallbacksUpTree(view, true);
        } else if (actionMasked == 1 || actionMasked == 3) {
            pseudoSelectorManager.fireActiveCallbacksUpTree(view, false);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void attachActive$lambda$8(PseudoSelectorManager pseudoSelectorManager, View view) {
        pseudoSelectorManager.activeCallbacks.remove(view);
        view.setOnTouchListener(null);
    }

    private final void attachActiveDeepest(final View view, String key, final PseudoSelectorCallback callback) {
        this.activeDeepestViews.add(view);
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.swmansion.reanimated.pseudoSelectors.PseudoSelectorManager$$ExternalSyntheticLambda6
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return PseudoSelectorManager.attachActiveDeepest$lambda$9(this.f$0, view, callback, view2, motionEvent);
            }
        });
        this.detachActions.put(key, new Runnable() { // from class: com.swmansion.reanimated.pseudoSelectors.PseudoSelectorManager$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                PseudoSelectorManager.attachActiveDeepest$lambda$10(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean attachActiveDeepest$lambda$9(PseudoSelectorManager pseudoSelectorManager, View view, PseudoSelectorCallback pseudoSelectorCallback, View view2, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            if (!pseudoSelectorManager.hasDeepestDescendantAt(view, motionEvent.getRawX(), motionEvent.getRawY())) {
                pseudoSelectorCallback.onSelectorStateChanged(true);
            }
            pseudoSelectorManager.fireActiveCallbacksUpTree(view, true);
        } else if (actionMasked == 1 || actionMasked == 3) {
            pseudoSelectorCallback.onSelectorStateChanged(false);
            pseudoSelectorManager.fireActiveCallbacksUpTree(view, false);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void attachActiveDeepest$lambda$10(PseudoSelectorManager pseudoSelectorManager, View view) {
        pseudoSelectorManager.activeDeepestViews.remove(view);
        view.setOnTouchListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void detach$lambda$11(PseudoSelectorManager pseudoSelectorManager, int i, int i2) {
        Runnable runnableRemove = pseudoSelectorManager.detachActions.remove(i + ":" + i2);
        if (runnableRemove != null) {
            runnableRemove.run();
        }
    }

    public final void detach(final int tag, final int selector) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.swmansion.reanimated.pseudoSelectors.PseudoSelectorManager$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                PseudoSelectorManager.detach$lambda$11(this.f$0, tag, selector);
            }
        });
    }

    private final boolean hasDeepestDescendantAt(View ancestor, float rawX, float rawY) {
        boolean z;
        int[] iArr = new int[2];
        Iterator<View> it = this.activeDeepestViews.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            }
            View next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            View view = next;
            if (view != ancestor && isDescendantOf(view, ancestor)) {
                view.getLocationOnScreen(iArr);
                int i = iArr[0];
                if (rawX >= i && rawX <= i + view.getWidth()) {
                    z = true;
                    int i2 = iArr[1];
                    if (rawY >= i2 && rawY <= i2 + view.getHeight()) {
                        break;
                    }
                }
            }
        }
        return z;
    }

    private final void fireActiveCallbacksUpTree(View source, boolean isActive) {
        PseudoSelectorCallback pseudoSelectorCallback;
        PseudoSelectorCallback pseudoSelectorCallback2 = this.activeCallbacks.get(source);
        if (pseudoSelectorCallback2 != null) {
            pseudoSelectorCallback2.onSelectorStateChanged(isActive);
        }
        for (ViewParent parent = source.getParent(); parent != null; parent = parent.getParent()) {
            if ((parent instanceof View) && (pseudoSelectorCallback = this.activeCallbacks.get(parent)) != null) {
                pseudoSelectorCallback.onSelectorStateChanged(isActive);
            }
        }
    }

    private final boolean isDescendantOf(View view, View ancestor) {
        Object parent = view.getParent();
        while (parent != null) {
            if (parent == ancestor) {
                return true;
            }
            View view2 = parent instanceof View ? (View) parent : null;
            parent = view2 != null ? view2.getParent() : null;
        }
        return false;
    }
}
