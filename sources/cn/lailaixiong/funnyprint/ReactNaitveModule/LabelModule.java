package cn.lailaixiong.funnyprint.ReactNaitveModule;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Log;
import cn.lailaixiong.funnyprint.util.ImageUtil;
import com.alibaba.fastjson.JSON;
import com.ask.printersdk.TagPrintingManger;
import com.ask.printersdk.graph.BoardStyle;
import com.ask.printersdk.graph.common.GraphManger;
import com.ask.printersdk.graph.state.StateNode;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: LabelModule.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0002J,\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007H\u0007J,\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007H\u0007J\u0012\u0010\u001e\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0007J\u0018\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u000eH\u0007J$\u0010&\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007H\u0007J\u001c\u0010'\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007H\u0007J\u0018\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020+H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcn/lailaixiong/funnyprint/ReactNaitveModule/LabelModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "appContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "mDoneCallback", "Lcom/facebook/react/bridge/Callback;", "mCancelCallback", "draftManager", "Lcom/ask/printersdk/graph/common/GraphManger;", "dolewaEventEmitter", "Lcn/lailaixiong/funnyprint/ReactNaitveModule/DolewaEventEmitter;", "getName", "", "requireActivityOrNull", "Landroid/app/Activity;", "registerTagCallbacks", "", "emitDraft", "", "isImageEditor", "create", "width", "", "height", "onDone", "onCancel", "openFromJson", "node", "getDraftList", "pushDraftItemTo", "result", "Lcom/facebook/react/bridge/WritableArray;", "id", "", "delDraft", "draftId", "openDraft", "openImageEditor", "handlePrint", "bitmap", "Landroid/graphics/Bitmap;", "Lcom/ask/printersdk/graph/state/StateNode;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LabelModule extends ReactContextBaseJavaModule {
    private final ReactApplicationContext appContext;
    private final DolewaEventEmitter dolewaEventEmitter;
    private final GraphManger draftManager;
    private Callback mCancelCallback;
    private Callback mDoneCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LabelModule(ReactApplicationContext appContext) {
        super(appContext);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.appContext = appContext;
        this.draftManager = new GraphManger(appContext);
        this.dolewaEventEmitter = new DolewaEventEmitter(appContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "LabelModule";
    }

    private final Activity requireActivityOrNull() {
        Activity currentActivity = this.appContext.getCurrentActivity();
        if (currentActivity == null || currentActivity.isFinishing()) {
            return null;
        }
        return currentActivity;
    }

    static /* synthetic */ void registerTagCallbacks$default(LabelModule labelModule, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        labelModule.registerTagCallbacks(z, z2);
    }

    private final void registerTagCallbacks(final boolean emitDraft, final boolean isImageEditor) {
        TagPrintingManger.INSTANCE.setOnTagCallback(new TagPrintingManger.TagCallback() { // from class: cn.lailaixiong.funnyprint.ReactNaitveModule.LabelModule.registerTagCallbacks.1
            @Override // com.ask.printersdk.TagPrintingManger.TagCallback
            public void onSaveDraft(StateNode node) {
                Intrinsics.checkNotNullParameter(node, "node");
                if (!emitDraft || isImageEditor) {
                    return;
                }
                DolewaEventEmitter.INSTANCE.emitEvent(this.appContext, "Draft", MapsKt.mapOf(TuplesKt.to("node", JSON.toJSONString(node))));
            }

            @Override // com.ask.printersdk.TagPrintingManger.TagCallback
            public void onPrinting(Bitmap bitmap, StateNode node) {
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                Intrinsics.checkNotNullParameter(node, "node");
                this.handlePrint(bitmap, node);
            }
        });
    }

    @ReactMethod
    public final void create(int width, int height, Callback onDone, Callback onCancel) {
        if (width == 0) {
            width = 50;
        }
        if (height == 0) {
            height = 50;
        }
        this.mDoneCallback = onDone;
        this.mCancelCallback = onCancel;
        registerTagCallbacks$default(this, true, false, 2, null);
        Activity activityRequireActivityOrNull = requireActivityOrNull();
        if (activityRequireActivityOrNull == null) {
            Log.e("Label", "create: Activity is null");
            Callback callback = this.mCancelCallback;
            if (callback != null) {
                callback.invoke("E_NO_ACTIVITY");
                return;
            }
            return;
        }
        TagPrintingManger.INSTANCE.setup(activityRequireActivityOrNull, width, height, StringUtils.SPACE);
    }

    @ReactMethod
    public final void openFromJson(String node, boolean isImageEditor, Callback onDone, Callback onCancel) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.mDoneCallback = onDone;
        this.mCancelCallback = onCancel;
        registerTagCallbacks(true, isImageEditor);
        Activity activityRequireActivityOrNull = requireActivityOrNull();
        if (activityRequireActivityOrNull != null) {
            if (isImageEditor) {
                TagPrintingManger.INSTANCE.startPictureEditing(activityRequireActivityOrNull, node, StringUtils.SPACE);
                return;
            } else {
                TagPrintingManger.INSTANCE.setup(activityRequireActivityOrNull, node, StringUtils.SPACE);
                return;
            }
        }
        Log.e("Label", "openFromJson: Activity is null");
        Callback callback = this.mCancelCallback;
        if (callback != null) {
            callback.invoke("E_NO_ACTIVITY");
        }
    }

    @ReactMethod
    public final void getDraftList(Callback onDone) {
        long[] draftIds = this.draftManager.getDraftIds();
        if (draftIds == null) {
            draftIds = new long[0];
        }
        WritableArray writableArrayCreateArray = Arguments.createArray();
        for (long j : draftIds) {
            pushDraftItemTo(writableArrayCreateArray, j);
        }
        if (onDone != null) {
            onDone.invoke(writableArrayCreateArray);
        }
    }

    private final void pushDraftItemTo(WritableArray result, long id) {
        BoardStyle boardGraph;
        BoardStyle boardGraph2;
        StateNode stateNode = this.draftManager.getStateNode(id);
        Bitmap stateScreenshot = this.draftManager.getStateScreenshot(id);
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("id", stateNode != null ? Long.valueOf(stateNode.getDraftId()).toString() : null);
        writableMapCreateMap.putString("img", stateScreenshot != null ? ImageUtil.INSTANCE.bitmapToBase64String(stateScreenshot) : null);
        if (stateNode != null && (boardGraph2 = stateNode.getBoardGraph()) != null) {
            writableMapCreateMap.putInt("width", boardGraph2.getLabelPaperWidth());
        }
        if (stateNode != null && (boardGraph = stateNode.getBoardGraph()) != null) {
            writableMapCreateMap.putInt("height", boardGraph.getLabelPaperHeight());
        }
        result.pushMap(writableMapCreateMap);
    }

    @ReactMethod
    public final void delDraft(String draftId) {
        Object objM1405constructorimpl;
        Intrinsics.checkNotNullParameter(draftId, "draftId");
        try {
            Result.Companion companion = Result.INSTANCE;
            LabelModule labelModule = this;
            this.draftManager.deleteDraftId(Long.parseLong(draftId));
            objM1405constructorimpl = Result.m1405constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM1405constructorimpl = Result.m1405constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM1408exceptionOrNullimpl = Result.m1408exceptionOrNullimpl(objM1405constructorimpl);
        if (thM1408exceptionOrNullimpl != null) {
            Log.e("Label", "delDraft failed: " + draftId, thM1408exceptionOrNullimpl);
        }
    }

    @ReactMethod
    public final void openDraft(String draftId, Callback onDone, Callback onCancel) {
        Object objM1405constructorimpl;
        Intrinsics.checkNotNullParameter(draftId, "draftId");
        this.mDoneCallback = onDone;
        this.mCancelCallback = onCancel;
        try {
            Result.Companion companion = Result.INSTANCE;
            LabelModule labelModule = this;
            objM1405constructorimpl = Result.m1405constructorimpl(this.draftManager.getStateNode(Long.parseLong(draftId)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM1405constructorimpl = Result.m1405constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m1411isFailureimpl(objM1405constructorimpl)) {
            objM1405constructorimpl = null;
        }
        StateNode stateNode = (StateNode) objM1405constructorimpl;
        if (stateNode == null) {
            Log.e("Label", "openDraft: draft is null");
            Callback callback = this.mCancelCallback;
            if (callback != null) {
                callback.invoke("E_NO_DRAFT");
                return;
            }
            return;
        }
        registerTagCallbacks$default(this, true, false, 2, null);
        Activity activityRequireActivityOrNull = requireActivityOrNull();
        if (activityRequireActivityOrNull == null) {
            Log.e("Label", "openDraft: Activity is null");
            Callback callback2 = this.mCancelCallback;
            if (callback2 != null) {
                callback2.invoke("E_NO_ACTIVITY");
                return;
            }
            return;
        }
        TagPrintingManger.INSTANCE.setup(activityRequireActivityOrNull, stateNode, StringUtils.SPACE);
    }

    @ReactMethod
    public final void openImageEditor(Callback onDone, Callback onCancel) {
        this.mDoneCallback = onDone;
        this.mCancelCallback = onCancel;
        registerTagCallbacks(false, true);
        Activity activityRequireActivityOrNull = requireActivityOrNull();
        if (activityRequireActivityOrNull == null) {
            Log.e("Label", "openImageEditor: Activity is null");
            Callback callback = this.mCancelCallback;
            if (callback != null) {
                callback.invoke("E_NO_ACTIVITY");
                return;
            }
            return;
        }
        TagPrintingManger.INSTANCE.startPictureEditing(activityRequireActivityOrNull, StringUtils.SPACE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handlePrint(Bitmap bitmap, StateNode node) {
        String jSONString = JSON.toJSONString(node);
        String strBitmapToBase64String = ImageUtil.INSTANCE.bitmapToBase64String(bitmap);
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("node", jSONString);
        writableMapCreateMap.putString("img", strBitmapToBase64String);
        BoardStyle boardGraph = node.getBoardGraph();
        if (boardGraph != null) {
            writableMapCreateMap.putInt("width", boardGraph.getLabelPaperWidth());
        }
        BoardStyle boardGraph2 = node.getBoardGraph();
        if (boardGraph2 != null) {
            writableMapCreateMap.putInt("height", boardGraph2.getLabelPaperHeight());
        }
        Callback callback = this.mDoneCallback;
        if (callback != null) {
            callback.invoke(writableMapCreateMap);
        }
        TagPrintingManger.INSTANCE.destroy(this.appContext);
    }
}
