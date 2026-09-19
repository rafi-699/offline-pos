package com.ask.printersdk.graph.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.webkit.ProxyConfig;
import com.alibaba.fastjson.JSON;
import com.ask.printersdk.R;
import com.ask.printersdk.graph.BarCodeGraph;
import com.ask.printersdk.graph.BaseGraph;
import com.ask.printersdk.graph.BoardGraph;
import com.ask.printersdk.graph.BoardStyle;
import com.ask.printersdk.graph.EdgingGraph;
import com.ask.printersdk.graph.EdgingStyle;
import com.ask.printersdk.graph.Graph;
import com.ask.printersdk.graph.ImageGraph;
import com.ask.printersdk.graph.ImageStyle;
import com.ask.printersdk.graph.MaterialGraph;
import com.ask.printersdk.graph.MaterialStyle;
import com.ask.printersdk.graph.QRCodeGraph;
import com.ask.printersdk.graph.QRCodeStyle;
import com.ask.printersdk.graph.ShapeGraph;
import com.ask.printersdk.graph.ShapeStyle;
import com.ask.printersdk.graph.TextGraph;
import com.ask.printersdk.graph.TextStyle;
import com.ask.printersdk.graph.TimeGraph;
import com.ask.printersdk.graph.TimeStyle;
import com.ask.printersdk.graph.state.GraphState;
import com.ask.printersdk.graph.state.StateManger;
import com.ask.printersdk.graph.state.StateNode;
import com.ask.printersdk.graph.style.BarCodeStyle;
import com.ask.printersdk.utils.LogUtil;
import com.ask.printersdk.utils.PUtil;
import com.ask.printersdk.utils.SharedPreferUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: GraphManger.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b7\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010A\u001a\u00020B2\u0006\u0010/\u001a\u000200J\u000e\u0010C\u001a\u00020B2\u0006\u0010?\u001a\u00020@J\u0006\u0010D\u001a\u00020@J\u0016\u0010E\u001a\u00020B2\u0006\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\tJ\u0016\u0010H\u001a\u00020B2\u0006\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\tJ\u001e\u0010I\u001a\u00020B2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020K2\u0006\u0010M\u001a\u00020KJ\u0018\u0010N\u001a\u00020B2\u0006\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010RJ\u000e\u0010S\u001a\u00020B2\u0006\u0010T\u001a\u00020PJ\u0006\u0010U\u001a\u00020BJ\u000e\u0010V\u001a\u00020B2\u0006\u0010T\u001a\u00020PJ\u0006\u0010W\u001a\u00020BJ\u000e\u0010X\u001a\u00020B2\u0006\u0010Y\u001a\u00020PJ\u0006\u0010Z\u001a\u00020BJ\u0006\u0010[\u001a\u00020BJ\u0006\u0010\\\u001a\u00020BJ\u0006\u0010]\u001a\u00020BJ\u0016\u0010^\u001a\u00020B2\u0006\u0010_\u001a\u00020P2\u0006\u0010`\u001a\u00020PJ\u001a\u0010a\u001a\u0004\u0018\u00010\u000e2\u0006\u0010b\u001a\u00020K2\u0006\u0010c\u001a\u00020KH\u0002J\u0018\u0010d\u001a\u0004\u0018\u00010\u000e2\u0006\u0010b\u001a\u00020K2\u0006\u0010c\u001a\u00020KJ\u000e\u0010i\u001a\u00020B2\u0006\u0010j\u001a\u00020kJ\u000e\u0010l\u001a\u00020B2\u0006\u0010j\u001a\u00020kJ6\u0010m\u001a\u00020B2\u0006\u0010v\u001a\u00020K2\u0006\u0010w\u001a\u00020K2\u0006\u0010x\u001a\u00020K2\u0006\u0010y\u001a\u00020K2\u0006\u0010z\u001a\u00020K2\u0006\u0010{\u001a\u00020KJ\u0016\u0010|\u001a\u00020B2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010}\u001a\u00020~J\u0006\u0010\u007f\u001a\u00020BJ\u0007\u0010\u0080\u0001\u001a\u00020BJ\u0010\u0010\u0081\u0001\u001a\u00020B2\u0007\u0010\u0082\u0001\u001a\u00020@J\u0007\u0010\u0083\u0001\u001a\u00020BJ\u0010\u0010\u0084\u0001\u001a\u00020B2\u0007\u0010\u0085\u0001\u001a\u00020@J\u0011\u0010\u0086\u0001\u001a\u00020B2\b\u0010\u0087\u0001\u001a\u00030\u0088\u0001J\u0010\u0010\u0089\u0001\u001a\u00020B2\u0007\u0010\u008a\u0001\u001a\u00020\tJ\u0010\u0010\u008b\u0001\u001a\u00020B2\u0007\u0010\u008c\u0001\u001a\u00020@J\u000f\u0010\u008d\u0001\u001a\u00020B2\u0006\u0010T\u001a\u00020PJ\u0010\u0010\u008e\u0001\u001a\u00020B2\u0007\u0010\u008f\u0001\u001a\u00020@J\u0010\u0010\u0090\u0001\u001a\u00020B2\u0007\u0010\u0085\u0001\u001a\u00020@J\u0007\u0010\u0091\u0001\u001a\u00020BJ\u0010\u0010\u0092\u0001\u001a\u00020B2\u0007\u0010\u0085\u0001\u001a\u00020@J\u0010\u0010\u0093\u0001\u001a\u00020B2\u0007\u0010\u0094\u0001\u001a\u00020PJ\u0010\u0010\u0095\u0001\u001a\u00020B2\u0007\u0010\u0096\u0001\u001a\u00020PJ\u0010\u0010\u0097\u0001\u001a\u00020B2\u0007\u0010\u0085\u0001\u001a\u00020@J\u0010\u0010\u0098\u0001\u001a\u00020B2\u0007\u0010\u0094\u0001\u001a\u00020PJ\u0010\u0010\u0099\u0001\u001a\u00020B2\u0007\u0010\u0096\u0001\u001a\u00020PJ\u0010\u0010\u009a\u0001\u001a\u00020B2\u0007\u0010\u009b\u0001\u001a\u00020\tJ\u0010\u0010\u009c\u0001\u001a\u00020B2\u0007\u0010\u009d\u0001\u001a\u00020\tJ\u000f\u0010\u009e\u0001\u001a\u00020B2\u0006\u0010T\u001a\u00020PJ\u0010\u0010\u009f\u0001\u001a\u00020B2\u0007\u0010\u008f\u0001\u001a\u00020@J\u0010\u0010 \u0001\u001a\u00020B2\u0007\u0010\u0085\u0001\u001a\u00020@J\u000f\u0010¡\u0001\u001a\u00020B2\u0006\u0010Y\u001a\u00020PJ\u001b\u0010¢\u0001\u001a\u00020B2\u0007\u0010£\u0001\u001a\u00020\t2\t\b\u0002\u0010¤\u0001\u001a\u00020@J\u0010\u0010¥\u0001\u001a\u00020B2\u0007\u0010£\u0001\u001a\u00020KJ\u0010\u0010¦\u0001\u001a\u00020B2\u0007\u0010£\u0001\u001a\u00020KJ\u0010\u0010§\u0001\u001a\u00020B2\u0007\u0010¨\u0001\u001a\u00020@J\u0010\u0010©\u0001\u001a\u00020B2\u0007\u0010ª\u0001\u001a\u00020@J\u0010\u0010«\u0001\u001a\u00020B2\u0007\u0010¬\u0001\u001a\u00020@J\u0010\u0010\u00ad\u0001\u001a\u00020B2\u0007\u0010®\u0001\u001a\u00020@J\u0010\u0010¯\u0001\u001a\u00020B2\u0007\u0010°\u0001\u001a\u00020@J\u0012\u0010±\u0001\u001a\u00020B2\t\b\u0002\u0010²\u0001\u001a\u00020\tJ\u0012\u0010³\u0001\u001a\u00020B2\t\b\u0002\u0010²\u0001\u001a\u00020\tJ\u0010\u0010´\u0001\u001a\u00020B2\u0007\u0010µ\u0001\u001a\u00020\tJ\u0007\u0010¶\u0001\u001a\u00020BJ\u0007\u0010·\u0001\u001a\u00020BJ\u0007\u0010¸\u0001\u001a\u00020BJ\u0007\u0010¹\u0001\u001a\u00020BJ\u0007\u0010º\u0001\u001a\u00020BJ\u0007\u0010»\u0001\u001a\u00020BJ\u0010\u0010¼\u0001\u001a\u00020B2\u0007\u0010½\u0001\u001a\u00020\tJ\u0007\u0010¾\u0001\u001a\u00020BJ\b\u0010¿\u0001\u001a\u00030À\u0001J\u0010\u0010Á\u0001\u001a\u00030À\u00012\u0006\u0010\u0002\u001a\u00020\u0003J\u0011\u0010Â\u0001\u001a\u00020B2\b\u0010Ã\u0001\u001a\u00030À\u0001J\u0010\u0010Â\u0001\u001a\u00020B2\u0007\u0010Ä\u0001\u001a\u00020PJ\u0007\u0010Å\u0001\u001a\u00020RJ\u0007\u0010Æ\u0001\u001a\u00020BJ\u0012\u0010Ç\u0001\u001a\u00020\t2\u0007\u0010È\u0001\u001a\u00020\u000eH\u0002J\u0007\u0010É\u0001\u001a\u00020BJ\u0007\u0010Ê\u0001\u001a\u00020BJ\u0015\u0010Ë\u0001\u001a\u00020B2\n\u0010Ã\u0001\u001a\u0005\u0018\u00010À\u0001H\u0002J\u001f\u0010Ì\u0001\u001a\u00020B2\b\u0010Í\u0001\u001a\u00030Î\u00012\n\u0010Ã\u0001\u001a\u0005\u0018\u00010À\u0001H\u0002J\u0014\u0010Ï\u0001\u001a\u0005\u0018\u00010À\u00012\b\u0010Í\u0001\u001a\u00030Î\u0001J\u001c\u0010Ð\u0001\u001a\u00020P2\b\u0010Í\u0001\u001a\u00030Î\u00012\u0007\u0010Ñ\u0001\u001a\u00020RH\u0002J\u0013\u0010Ò\u0001\u001a\u0004\u0018\u00010R2\b\u0010Í\u0001\u001a\u00030Î\u0001J\u0013\u0010Ó\u0001\u001a\u00020B2\b\u0010Í\u0001\u001a\u00030Î\u0001H\u0002J\b\u0010Ô\u0001\u001a\u00030Õ\u0001J\u0011\u0010Ö\u0001\u001a\u00020B2\b\u0010Í\u0001\u001a\u00030Î\u0001J\n\u0010×\u0001\u001a\u00030Ø\u0001H\u0002J\t\u0010Ù\u0001\u001a\u00020BH\u0002J\n\u0010Ú\u0001\u001a\u00030Ø\u0001H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR*\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000b\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000b\"\u0004\b#\u0010 R\u001c\u0010$\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u000100X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0011\u0010;\u001a\u00020<¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u000e\u0010?\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010e\u001a\u00020@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001c\u0010m\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010&\"\u0004\bo\u0010(R\u001c\u0010p\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010&\"\u0004\br\u0010(R\u001a\u0010s\u001a\u00020@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010f\"\u0004\bu\u0010h¨\u0006Û\u0001"}, d2 = {"Lcom/ask/printersdk/graph/common/GraphManger;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "selectedStrokeWith", "", "getSelectedStrokeWith", "()I", "graphList", "Ljava/util/ArrayList;", "Lcom/ask/printersdk/graph/Graph;", "Lkotlin/collections/ArrayList;", "getGraphList", "()Ljava/util/ArrayList;", "setGraphList", "(Ljava/util/ArrayList;)V", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "setPaint", "(Landroid/graphics/Paint;)V", "framePaint", "getFramePaint", "setFramePaint", "viewWidth", "getViewWidth", "setViewWidth", "(I)V", "viewHeight", "getViewHeight", "setViewHeight", "curSelectGraph", "getCurSelectGraph", "()Lcom/ask/printersdk/graph/Graph;", "setCurSelectGraph", "(Lcom/ask/printersdk/graph/Graph;)V", "boardGraph", "Lcom/ask/printersdk/graph/BoardGraph;", "getBoardGraph", "()Lcom/ask/printersdk/graph/BoardGraph;", "setBoardGraph", "(Lcom/ask/printersdk/graph/BoardGraph;)V", "graphOpCallback", "Lcom/ask/printersdk/graph/common/GraphOpCallback;", "getGraphOpCallback", "()Lcom/ask/printersdk/graph/common/GraphOpCallback;", "setGraphOpCallback", "(Lcom/ask/printersdk/graph/common/GraphOpCallback;)V", "stateManger", "Lcom/ask/printersdk/graph/state/StateManger;", "getStateManger", "()Lcom/ask/printersdk/graph/state/StateManger;", "setStateManger", "(Lcom/ask/printersdk/graph/state/StateManger;)V", "imageCache", "Lcom/ask/printersdk/graph/common/ImageCache;", "getImageCache", "()Lcom/ask/printersdk/graph/common/ImageCache;", "isPictureEditing", "", "setOnGraphOpCallback", "", "setPictureEditing", "getPictureEditing", "setViewBound", "width", "height", "setDrawBoardSize", "onScaleDrawBoard", "scale", "", "currentFocusX", "currentFocusY", "addBitmapGraph", "localPath", "", "originBitmap", "Landroid/graphics/Bitmap;", "addMaterialGraph", "resName", "selectMaterial", "addEdgingGraph", "selectEdging", "addTextGraph", "text", "addBarCodeGraph", "addQRCodeGraph", "addTimeGraph", "addShapeGraph", "updateTextTypeface", "fontTypeface", "fontIdentifier", "getTouchGraph", "x", "y", "tapSelectGraph", "isTouchDown", "()Z", "setTouchDown", "(Z)V", "touchDown", "e", "Landroid/view/MotionEvent;", "touchUp", "moveGraph", "getMoveGraph", "setMoveGraph", "scaleGraph", "getScaleGraph", "setScaleGraph", "saveStateFlag", "getSaveStateFlag", "setSaveStateFlag", "startX", "startY", "endX", "endY", "distanceX", "distanceY", "drawAllGraph", "canvas", "Landroid/graphics/Canvas;", "onResetCurGraph", "onRotateCurGraph", "onRLockCurGraph", "isLock", "onDeleteCurGraph", "updateShapeRedTintColor", "isRed", "updateShapeLineWeight", "lineWeight", "", "updateShapeType", "shapeType", "updateShapeDashed", "isDashed", "updateEdgingResId", "updateEdgingReverse", "reverse", "updateEdgingRedTintColor", "updateTimeGraph", "updateQRCodeRedTintColor", "updateQRCodeFormat", "codeFormat", "updateQRCodeContentText", "contentText", "updateBarCodeRedTintColor", "updateBarCodeFormat", "updateBarCodeContentText", "updateBarCodeStyle", "codeStyle", "updateBarCodeFontSize", "fontSize", "updateMaterialResId", "updateMaterialReverse", "updateMaterialRedTintColor", "updateCurGraphText", "updateTextSize", "size", "saveFlag", "updateTextLetterSpacing", "updateTextLineSpacing", "updateTextBold", TtmlNode.BOLD, "updateTextUnderLine", "underLine", "updateTextItalic", TtmlNode.ITALIC, "setAutoFont", "autoFont", "setEqualScale", "equalRatio", "updateTextAlign", "align", "updateTextToBoundLayoutAlign", "updateImageContrast", "contrast", "onAlignLeftCurGraph", "onAlignRightCurGraph", "onAlignTopCurGraph", "onAlignMiddle2HoriCurGraph", "onAlignMiddleCurGraph", "onAlignBottomCurGraph", "onMoveStep", DevicePublicKeyStringDef.DIRECT, "cleanAllGraph", "saveCurrentNode", "Lcom/ask/printersdk/graph/state/StateNode;", "onSaveDraft", "openDraft", "node", "jsonString", "onPrinting", "saveBackwardGraphState", "getType", "graph", "popBackwardGraphState", "popForwardGraphState", "handleStateNode", "saveStateToJson", "draftId", "", "getStateNode", "saveStateScreenshot", "bitmap", "getStateScreenshot", "addDraftId", "getDraftIds", "", "deleteDraftId", "getDrawContentBounds", "Landroid/graphics/RectF;", "syncBoardBottom", "getBoardContentBounds", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GraphManger {
    private BoardGraph boardGraph;
    private final Context context;
    private Graph curSelectGraph;
    private Paint framePaint;
    private ArrayList<Graph> graphList;
    private GraphOpCallback graphOpCallback;
    private final ImageCache imageCache;
    private boolean isPictureEditing;
    private boolean isTouchDown;
    private Graph moveGraph;
    private Paint paint;
    private boolean saveStateFlag;
    private Graph scaleGraph;
    private final int selectedStrokeWith;
    private StateManger stateManger;
    private int viewHeight;
    private int viewWidth;

    public GraphManger(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.selectedStrokeWith = 2;
        this.graphList = new ArrayList<>();
        this.stateManger = new StateManger();
        this.imageCache = new ImageCache(context);
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.framePaint = paint2;
        paint2.setAntiAlias(true);
        this.framePaint.setStrokeWidth(PUtil.dip2px(context, 2));
        this.framePaint.setStyle(Paint.Style.STROKE);
        this.framePaint.setColor(PUtil.getColor(context, R.color.color_3F74FF));
        this.boardGraph = new BoardGraph(context);
    }

    public final Context getContext() {
        return this.context;
    }

    public final int getSelectedStrokeWith() {
        return this.selectedStrokeWith;
    }

    public final ArrayList<Graph> getGraphList() {
        return this.graphList;
    }

    public final void setGraphList(ArrayList<Graph> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.graphList = arrayList;
    }

    public final Paint getPaint() {
        return this.paint;
    }

    public final void setPaint(Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<set-?>");
        this.paint = paint;
    }

    public final Paint getFramePaint() {
        return this.framePaint;
    }

    public final void setFramePaint(Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<set-?>");
        this.framePaint = paint;
    }

    public final int getViewWidth() {
        return this.viewWidth;
    }

    public final void setViewWidth(int i) {
        this.viewWidth = i;
    }

    public final int getViewHeight() {
        return this.viewHeight;
    }

    public final void setViewHeight(int i) {
        this.viewHeight = i;
    }

    public final Graph getCurSelectGraph() {
        return this.curSelectGraph;
    }

    public final void setCurSelectGraph(Graph graph) {
        this.curSelectGraph = graph;
    }

    public final BoardGraph getBoardGraph() {
        return this.boardGraph;
    }

    public final void setBoardGraph(BoardGraph boardGraph) {
        Intrinsics.checkNotNullParameter(boardGraph, "<set-?>");
        this.boardGraph = boardGraph;
    }

    public final GraphOpCallback getGraphOpCallback() {
        return this.graphOpCallback;
    }

    public final void setGraphOpCallback(GraphOpCallback graphOpCallback) {
        this.graphOpCallback = graphOpCallback;
    }

    public final StateManger getStateManger() {
        return this.stateManger;
    }

    public final void setStateManger(StateManger stateManger) {
        Intrinsics.checkNotNullParameter(stateManger, "<set-?>");
        this.stateManger = stateManger;
    }

    public final ImageCache getImageCache() {
        return this.imageCache;
    }

    public final void setOnGraphOpCallback(GraphOpCallback graphOpCallback) {
        Intrinsics.checkNotNullParameter(graphOpCallback, "graphOpCallback");
        this.graphOpCallback = graphOpCallback;
    }

    public final void setPictureEditing(boolean isPictureEditing) {
        this.isPictureEditing = isPictureEditing;
        this.boardGraph.getBoardStyle().setPictureEditing(isPictureEditing);
    }

    /* JADX INFO: renamed from: getPictureEditing, reason: from getter */
    public final boolean getIsPictureEditing() {
        return this.isPictureEditing;
    }

    public final void setViewBound(int width, int height) {
        if (width == this.viewWidth && height == this.viewHeight) {
            return;
        }
        this.viewWidth = width;
        this.viewHeight = height;
        this.boardGraph.setViewSize(width, height);
    }

    public final void setDrawBoardSize(int width, int height) {
        this.boardGraph.setDrawBoardInfo(0.0f, 0.0f, width, height);
    }

    public final void onScaleDrawBoard(float scale, float currentFocusX, float currentFocusY) {
        this.boardGraph.scaleBoardGraph(scale, scale, currentFocusX, currentFocusY);
        GraphOpCallback graphOpCallback = this.graphOpCallback;
        if (graphOpCallback != null) {
            graphOpCallback.onDrawingBoardChanged();
        }
    }

    public final void addBitmapGraph(String localPath, Bitmap originBitmap) {
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        ImageGraph imageGraph = new ImageGraph(this.context, localPath);
        if (originBitmap != null) {
            imageGraph.setBitmap(originBitmap);
        } else {
            Bitmap image = this.imageCache.getImage(localPath);
            if (image == null) {
                return;
            } else {
                imageGraph.setBitmap(image);
            }
        }
        imageGraph.setId(GraphUtil.INSTANCE.getAutoIncId());
        imageGraph.setDrawBoardInfo(this.boardGraph.getBoardStyle());
        this.graphList.add(imageGraph);
        ImageGraph imageGraph2 = imageGraph;
        this.curSelectGraph = imageGraph2;
        GraphOpCallback graphOpCallback = this.graphOpCallback;
        if (graphOpCallback != null) {
            graphOpCallback.onSelected(imageGraph2);
        }
        saveBackwardGraphState();
    }

    public final void addMaterialGraph(String resName) {
        Intrinsics.checkNotNullParameter(resName, "resName");
        MaterialGraph materialGraph = new MaterialGraph(this.context);
        Bitmap imageSource = this.imageCache.getImageSource(resName);
        if (imageSource != null) {
            materialGraph.setBitmap(imageSource);
        }
        materialGraph.updateResName(resName);
        materialGraph.setId(GraphUtil.INSTANCE.getAutoIncId());
        materialGraph.setDrawBoardInfo(this.boardGraph.getBoardStyle());
        this.graphList.add(materialGraph);
        MaterialGraph materialGraph2 = materialGraph;
        this.curSelectGraph = materialGraph2;
        GraphOpCallback graphOpCallback = this.graphOpCallback;
        if (graphOpCallback != null) {
            graphOpCallback.onSelected(materialGraph2);
        }
        saveBackwardGraphState();
    }

    public final void selectMaterial() {
        MaterialGraph materialGraph = new MaterialGraph(this.context);
        GraphOpCallback graphOpCallback = this.graphOpCallback;
        if (graphOpCallback != null) {
            graphOpCallback.onSelected(materialGraph);
        }
    }

    public final void addEdgingGraph(String resName) {
        Intrinsics.checkNotNullParameter(resName, "resName");
        EdgingGraph edgingGraph = new EdgingGraph(this.context);
        Bitmap imageSource = this.imageCache.getImageSource(resName);
        if (imageSource != null) {
            edgingGraph.setBitmap(imageSource);
        }
        edgingGraph.updateResName(resName);
        edgingGraph.setId(GraphUtil.INSTANCE.getAutoIncId());
        edgingGraph.setDrawBoardInfo(this.boardGraph.getBoardStyle());
        this.graphList.add(edgingGraph);
        EdgingGraph edgingGraph2 = edgingGraph;
        this.curSelectGraph = edgingGraph2;
        GraphOpCallback graphOpCallback = this.graphOpCallback;
        if (graphOpCallback != null) {
            graphOpCallback.onSelected(edgingGraph2);
        }
        saveBackwardGraphState();
    }

    public final void selectEdging() {
        EdgingGraph edgingGraph = new EdgingGraph(this.context);
        GraphOpCallback graphOpCallback = this.graphOpCallback;
        if (graphOpCallback != null) {
            graphOpCallback.onSelected(edgingGraph);
        }
    }

    public final void addTextGraph(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        TextGraph textGraph = new TextGraph(this.context, text);
        textGraph.setId(GraphUtil.INSTANCE.getAutoIncId());
        textGraph.setDrawBoardInfo(this.boardGraph.getBoardStyle());
        this.graphList.add(textGraph);
        TextGraph textGraph2 = textGraph;
        this.curSelectGraph = textGraph2;
        GraphOpCallback graphOpCallback = this.graphOpCallback;
        if (graphOpCallback != null) {
            graphOpCallback.onSelected(textGraph2);
        }
        saveBackwardGraphState();
    }

    public final void addBarCodeGraph() {
        BarCodeGraph barCodeGraph = new BarCodeGraph(this.context);
        barCodeGraph.setId(GraphUtil.INSTANCE.getAutoIncId());
        barCodeGraph.setDrawBoardInfo(this.boardGraph.getBoardStyle());
        barCodeGraph.drawBarCodeImage();
        this.graphList.add(barCodeGraph);
        BarCodeGraph barCodeGraph2 = barCodeGraph;
        this.curSelectGraph = barCodeGraph2;
        GraphOpCallback graphOpCallback = this.graphOpCallback;
        if (graphOpCallback != null) {
            graphOpCallback.onSelected(barCodeGraph2);
        }
        saveBackwardGraphState();
    }

    public final void addQRCodeGraph() {
        QRCodeGraph qRCodeGraph = new QRCodeGraph(this.context);
        qRCodeGraph.setId(GraphUtil.INSTANCE.getAutoIncId());
        qRCodeGraph.setDrawBoardInfo(this.boardGraph.getBoardStyle());
        qRCodeGraph.drawBarCodeImage();
        this.graphList.add(qRCodeGraph);
        QRCodeGraph qRCodeGraph2 = qRCodeGraph;
        this.curSelectGraph = qRCodeGraph2;
        GraphOpCallback graphOpCallback = this.graphOpCallback;
        if (graphOpCallback != null) {
            graphOpCallback.onSelected(qRCodeGraph2);
        }
        saveBackwardGraphState();
    }

    public final void addTimeGraph() {
        TimeGraph timeGraph = new TimeGraph(this.context, null, 2, 0 == true ? 1 : 0);
        timeGraph.setId(GraphUtil.INSTANCE.getAutoIncId());
        timeGraph.setDrawBoardInfo(this.boardGraph.getBoardStyle());
        timeGraph.refreshTimeText();
        this.graphList.add(timeGraph);
        TimeGraph timeGraph2 = timeGraph;
        this.curSelectGraph = timeGraph2;
        GraphOpCallback graphOpCallback = this.graphOpCallback;
        if (graphOpCallback != null) {
            graphOpCallback.onSelected(timeGraph2);
        }
        saveBackwardGraphState();
    }

    public final void addShapeGraph() {
        ShapeGraph shapeGraph = new ShapeGraph(this.context);
        shapeGraph.setId(GraphUtil.INSTANCE.getAutoIncId());
        shapeGraph.setDrawBoardInfo(this.boardGraph.getBoardStyle());
        this.graphList.add(shapeGraph);
        ShapeGraph shapeGraph2 = shapeGraph;
        this.curSelectGraph = shapeGraph2;
        GraphOpCallback graphOpCallback = this.graphOpCallback;
        if (graphOpCallback != null) {
            graphOpCallback.onSelected(shapeGraph2);
        }
        saveBackwardGraphState();
    }

    public final void updateTextTypeface(String fontTypeface, String fontIdentifier) {
        Intrinsics.checkNotNullParameter(fontTypeface, "fontTypeface");
        Intrinsics.checkNotNullParameter(fontIdentifier, "fontIdentifier");
        Graph graph = this.curSelectGraph;
        if (graph == null || !(graph instanceof TextGraph)) {
            return;
        }
        TextGraph.updateTextTypeface$default((TextGraph) graph, fontTypeface, fontIdentifier, false, 4, null);
        saveBackwardGraphState();
    }

    private final Graph getTouchGraph(float x, float y) {
        int size = this.graphList.size();
        do {
            size--;
            if (-1 >= size) {
                return null;
            }
        } while (!this.graphList.get(size).getBound().contains(x, y));
        return this.graphList.get(size);
    }

    public final Graph tapSelectGraph(float x, float y) {
        Graph touchGraph = getTouchGraph(x, y);
        this.curSelectGraph = touchGraph;
        GraphOpCallback graphOpCallback = this.graphOpCallback;
        if (graphOpCallback != null) {
            graphOpCallback.onSelected(touchGraph);
        }
        return this.curSelectGraph;
    }

    /* JADX INFO: renamed from: isTouchDown, reason: from getter */
    public final boolean getIsTouchDown() {
        return this.isTouchDown;
    }

    public final void setTouchDown(boolean z) {
        this.isTouchDown = z;
    }

    public final void touchDown(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        this.isTouchDown = true;
        Graph graph = this.curSelectGraph;
        if (graph != null && graph.isTouchScalePoint(this.context, e.getX(), e.getY())) {
            this.scaleGraph = this.curSelectGraph;
            this.moveGraph = null;
            this.boardGraph.showScaleLine(true);
            return;
        }
        this.scaleGraph = null;
        Graph touchGraph = getTouchGraph(e.getX(), e.getY());
        this.moveGraph = touchGraph;
        if (touchGraph != null) {
            this.curSelectGraph = touchGraph;
            this.boardGraph.showScaleLine(true);
        }
    }

    public final void touchUp(MotionEvent e) {
        GraphOpCallback graphOpCallback;
        Intrinsics.checkNotNullParameter(e, "e");
        this.moveGraph = null;
        this.scaleGraph = null;
        Graph graph = this.curSelectGraph;
        if (graph != null && (graphOpCallback = this.graphOpCallback) != null) {
            graphOpCallback.onSelected(graph);
        }
        this.boardGraph.showScaleLine(false);
        if (this.saveStateFlag) {
            this.saveStateFlag = false;
            saveBackwardGraphState();
        }
    }

    public final Graph getMoveGraph() {
        return this.moveGraph;
    }

    public final void setMoveGraph(Graph graph) {
        this.moveGraph = graph;
    }

    public final Graph getScaleGraph() {
        return this.scaleGraph;
    }

    public final void setScaleGraph(Graph graph) {
        this.scaleGraph = graph;
    }

    public final boolean getSaveStateFlag() {
        return this.saveStateFlag;
    }

    public final void setSaveStateFlag(boolean z) {
        this.saveStateFlag = z;
    }

    public final void moveGraph(float startX, float startY, float endX, float endY, float distanceX, float distanceY) {
        Graph graph;
        Graph graph2 = this.moveGraph;
        boolean z = (graph2 != null && graph2.getIsLock()) || ((graph = this.scaleGraph) != null && graph.getIsLock());
        Graph graph3 = this.moveGraph;
        if ((graph3 == null && this.scaleGraph == null) || z) {
            this.boardGraph.moveGraph(distanceX, distanceY);
            GraphOpCallback graphOpCallback = this.graphOpCallback;
            if (graphOpCallback != null) {
                graphOpCallback.onDrawingBoardChanged();
                return;
            }
            return;
        }
        if (graph3 != null) {
            this.saveStateFlag = true;
            graph3.moveGraph(distanceX, distanceY);
        }
        Graph graph4 = this.scaleGraph;
        if (graph4 != null) {
            this.saveStateFlag = true;
            graph4.scaleGraph(startX, startY, endX, endY, distanceX, distanceY);
        }
    }

    public final void drawAllGraph(Context context, Canvas canvas) {
        Context context2;
        Canvas canvas2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.isPictureEditing) {
            canvas.drawColor(PUtil.getColor(context, R.color.color_f5));
            Iterator<T> it = this.graphList.iterator();
            while (it.hasNext()) {
                ((Graph) it.next()).onDraw(context, canvas, this.paint);
            }
            Graph graph = this.curSelectGraph;
            if (graph != null) {
                graph.drawBound(context, canvas, this.framePaint);
            }
            Graph graph2 = this.curSelectGraph;
            if (graph2 != null) {
                graph2.drawScalePoint(context, canvas, this.framePaint);
                return;
            }
            return;
        }
        this.boardGraph.onDraw(context, canvas, this.paint);
        Iterator<T> it2 = this.graphList.iterator();
        while (it2.hasNext()) {
            ((Graph) it2.next()).onDraw(context, canvas, this.paint);
        }
        Graph graph3 = this.curSelectGraph;
        if (graph3 != null) {
            graph3.drawBound(context, canvas, this.framePaint);
        }
        Graph graph4 = this.curSelectGraph;
        if (graph4 != null) {
            graph4.drawScalePoint(context, canvas, this.framePaint);
        }
        if (this.boardGraph.getShowScaleLine()) {
            Graph graph5 = this.curSelectGraph;
            if (graph5 != null) {
                context2 = context;
                canvas2 = canvas;
                graph5.onDrawScaleLine(context2, canvas2, this.paint, this.viewWidth, this.viewHeight);
            } else {
                context2 = context;
                canvas2 = canvas;
            }
            this.boardGraph.onDrawScaleLine(context2, canvas2, this.paint, this.viewWidth, this.viewHeight);
        }
    }

    public final void onResetCurGraph() {
        Graph graph = this.curSelectGraph;
        if (graph != null) {
            graph.reset();
            saveBackwardGraphState();
        }
    }

    public final void onRotateCurGraph() {
        Graph graph = this.curSelectGraph;
        if (graph != null) {
            graph.rotate();
            saveBackwardGraphState();
        }
    }

    public final void onRLockCurGraph(boolean isLock) {
        Graph graph = this.curSelectGraph;
        BaseGraph baseGraph = graph instanceof BaseGraph ? (BaseGraph) graph : null;
        if (baseGraph != null) {
            baseGraph.setLock(isLock);
        }
    }

    public final void onDeleteCurGraph() {
        Graph graph = this.curSelectGraph;
        if (graph != null) {
            TypeIntrinsics.asMutableCollection(this.graphList).remove(graph);
            saveBackwardGraphState();
        }
        this.curSelectGraph = null;
        GraphOpCallback graphOpCallback = this.graphOpCallback;
        if (graphOpCallback != null) {
            graphOpCallback.onSelected(null);
        }
    }

    public final void updateShapeRedTintColor(boolean isRed) {
        Graph graph = this.curSelectGraph;
        ShapeGraph shapeGraph = graph instanceof ShapeGraph ? (ShapeGraph) graph : null;
        if (shapeGraph != null) {
            ImageStyle style = shapeGraph.getStyle();
            Intrinsics.checkNotNull(style, "null cannot be cast to non-null type com.ask.printersdk.graph.ShapeStyle");
            ((ShapeStyle) style).setRedTintColor(isRed);
            saveBackwardGraphState();
        }
    }

    public final void updateShapeLineWeight(double lineWeight) {
        Graph graph = this.curSelectGraph;
        ShapeGraph shapeGraph = graph instanceof ShapeGraph ? (ShapeGraph) graph : null;
        if (shapeGraph != null) {
            ImageStyle style = shapeGraph.getStyle();
            Intrinsics.checkNotNull(style, "null cannot be cast to non-null type com.ask.printersdk.graph.ShapeStyle");
            ((ShapeStyle) style).setLineWeight(lineWeight);
            saveBackwardGraphState();
        }
    }

    public final void updateShapeType(int shapeType) {
        Graph graph = this.curSelectGraph;
        ShapeGraph shapeGraph = graph instanceof ShapeGraph ? (ShapeGraph) graph : null;
        if (shapeGraph != null) {
            ImageStyle style = shapeGraph.getStyle();
            Intrinsics.checkNotNull(style, "null cannot be cast to non-null type com.ask.printersdk.graph.ShapeStyle");
            ((ShapeStyle) style).setShapeType(shapeType);
            if (shapeType == 5) {
                shapeGraph.toSquare();
                shapeGraph.getStyle().setEqualRatioScale(true);
            } else {
                shapeGraph.getStyle().setEqualRatioScale(false);
            }
            saveBackwardGraphState();
        }
    }

    public final void updateShapeDashed(boolean isDashed) {
        Graph graph = this.curSelectGraph;
        ShapeGraph shapeGraph = graph instanceof ShapeGraph ? (ShapeGraph) graph : null;
        if (shapeGraph != null) {
            ImageStyle style = shapeGraph.getStyle();
            Intrinsics.checkNotNull(style, "null cannot be cast to non-null type com.ask.printersdk.graph.ShapeStyle");
            ((ShapeStyle) style).setDashed(isDashed);
            saveBackwardGraphState();
        }
    }

    public final void updateEdgingResId(String resName) {
        Intrinsics.checkNotNullParameter(resName, "resName");
        Graph graph = this.curSelectGraph;
        if (graph != null) {
            EdgingGraph edgingGraph = graph instanceof EdgingGraph ? (EdgingGraph) graph : null;
            if (edgingGraph != null) {
                edgingGraph.updateResName(resName);
            }
            saveBackwardGraphState();
        }
    }

    public final void updateEdgingReverse(boolean reverse) {
        Graph graph = this.curSelectGraph;
        EdgingGraph edgingGraph = graph instanceof EdgingGraph ? (EdgingGraph) graph : null;
        if (edgingGraph != null) {
            ImageStyle style = edgingGraph.getStyle();
            Intrinsics.checkNotNull(style, "null cannot be cast to non-null type com.ask.printersdk.graph.EdgingStyle");
            ((EdgingStyle) style).setReverse(reverse);
            saveBackwardGraphState();
        }
    }

    public final void updateEdgingRedTintColor(boolean isRed) {
        Graph graph = this.curSelectGraph;
        EdgingGraph edgingGraph = graph instanceof EdgingGraph ? (EdgingGraph) graph : null;
        if (edgingGraph != null) {
            ImageStyle style = edgingGraph.getStyle();
            Intrinsics.checkNotNull(style, "null cannot be cast to non-null type com.ask.printersdk.graph.EdgingStyle");
            ((EdgingStyle) style).setRedTintColor(isRed);
            saveBackwardGraphState();
        }
    }

    public final void updateTimeGraph() {
        Graph graph = this.curSelectGraph;
        TimeGraph timeGraph = graph instanceof TimeGraph ? (TimeGraph) graph : null;
        if (timeGraph != null) {
            timeGraph.refreshTimeText();
            saveBackwardGraphState();
        }
    }

    public final void updateQRCodeRedTintColor(boolean isRed) {
        Graph graph = this.curSelectGraph;
        QRCodeGraph qRCodeGraph = graph instanceof QRCodeGraph ? (QRCodeGraph) graph : null;
        if (qRCodeGraph != null) {
            ImageStyle style = qRCodeGraph.getStyle();
            Intrinsics.checkNotNull(style, "null cannot be cast to non-null type com.ask.printersdk.graph.QRCodeStyle");
            ((QRCodeStyle) style).setRedTintColor(isRed);
            qRCodeGraph.drawBarCodeImage();
            saveBackwardGraphState();
        }
    }

    public final void updateQRCodeFormat(String codeFormat) {
        Intrinsics.checkNotNullParameter(codeFormat, "codeFormat");
        Graph graph = this.curSelectGraph;
        QRCodeGraph qRCodeGraph = graph instanceof QRCodeGraph ? (QRCodeGraph) graph : null;
        if (qRCodeGraph != null) {
            ImageStyle style = qRCodeGraph.getStyle();
            Intrinsics.checkNotNull(style, "null cannot be cast to non-null type com.ask.printersdk.graph.QRCodeStyle");
            ((QRCodeStyle) style).setCodeType(codeFormat);
            qRCodeGraph.drawBarCodeImage();
            saveBackwardGraphState();
        }
    }

    public final void updateQRCodeContentText(String contentText) {
        Intrinsics.checkNotNullParameter(contentText, "contentText");
        Graph graph = this.curSelectGraph;
        QRCodeGraph qRCodeGraph = graph instanceof QRCodeGraph ? (QRCodeGraph) graph : null;
        if (qRCodeGraph != null) {
            ImageStyle style = qRCodeGraph.getStyle();
            Intrinsics.checkNotNull(style, "null cannot be cast to non-null type com.ask.printersdk.graph.QRCodeStyle");
            ((QRCodeStyle) style).setContentText(contentText);
            qRCodeGraph.drawBarCodeImage();
            saveBackwardGraphState();
        }
    }

    public final void updateBarCodeRedTintColor(boolean isRed) {
        Graph graph = this.curSelectGraph;
        BarCodeGraph barCodeGraph = graph instanceof BarCodeGraph ? (BarCodeGraph) graph : null;
        if (barCodeGraph != null) {
            ImageStyle style = barCodeGraph.getStyle();
            Intrinsics.checkNotNull(style, "null cannot be cast to non-null type com.ask.printersdk.graph.style.BarCodeStyle");
            ((BarCodeStyle) style).setRedTintColor(isRed);
            barCodeGraph.drawBarCodeImage();
            saveBackwardGraphState();
        }
    }

    public final void updateBarCodeFormat(String codeFormat) {
        Intrinsics.checkNotNullParameter(codeFormat, "codeFormat");
        Graph graph = this.curSelectGraph;
        BarCodeGraph barCodeGraph = graph instanceof BarCodeGraph ? (BarCodeGraph) graph : null;
        if (barCodeGraph != null) {
            ImageStyle style = barCodeGraph.getStyle();
            Intrinsics.checkNotNull(style, "null cannot be cast to non-null type com.ask.printersdk.graph.style.BarCodeStyle");
            ((BarCodeStyle) style).setCodeType(codeFormat);
            barCodeGraph.drawBarCodeImage();
            saveBackwardGraphState();
        }
    }

    public final void updateBarCodeContentText(String contentText) {
        Intrinsics.checkNotNullParameter(contentText, "contentText");
        Graph graph = this.curSelectGraph;
        BarCodeGraph barCodeGraph = graph instanceof BarCodeGraph ? (BarCodeGraph) graph : null;
        if (barCodeGraph != null) {
            ImageStyle style = barCodeGraph.getStyle();
            Intrinsics.checkNotNull(style, "null cannot be cast to non-null type com.ask.printersdk.graph.style.BarCodeStyle");
            ((BarCodeStyle) style).setContentText(contentText);
            barCodeGraph.drawBarCodeImage();
            saveBackwardGraphState();
        }
    }

    public final void updateBarCodeStyle(int codeStyle) {
        Graph graph = this.curSelectGraph;
        BarCodeGraph barCodeGraph = graph instanceof BarCodeGraph ? (BarCodeGraph) graph : null;
        if (barCodeGraph != null) {
            ImageStyle style = barCodeGraph.getStyle();
            Intrinsics.checkNotNull(style, "null cannot be cast to non-null type com.ask.printersdk.graph.style.BarCodeStyle");
            ((BarCodeStyle) style).setPositionStyle(codeStyle);
            barCodeGraph.drawBarCodeImage();
            saveBackwardGraphState();
        }
    }

    public final void updateBarCodeFontSize(int fontSize) {
        Graph graph = this.curSelectGraph;
        BarCodeGraph barCodeGraph = graph instanceof BarCodeGraph ? (BarCodeGraph) graph : null;
        if (barCodeGraph != null) {
            ImageStyle style = barCodeGraph.getStyle();
            Intrinsics.checkNotNull(style, "null cannot be cast to non-null type com.ask.printersdk.graph.style.BarCodeStyle");
            ((BarCodeStyle) style).setTextFontSize(fontSize);
            barCodeGraph.drawBarCodeImage();
            saveBackwardGraphState();
        }
    }

    public final void updateMaterialResId(String resName) {
        Intrinsics.checkNotNullParameter(resName, "resName");
        Graph graph = this.curSelectGraph;
        if (graph != null) {
            ((MaterialGraph) graph).updateResName(resName);
            saveBackwardGraphState();
        }
    }

    public final void updateMaterialReverse(boolean reverse) {
        Graph graph = this.curSelectGraph;
        if (graph != null) {
            ImageStyle style = ((MaterialGraph) graph).getStyle();
            Intrinsics.checkNotNull(style, "null cannot be cast to non-null type com.ask.printersdk.graph.MaterialStyle");
            ((MaterialStyle) style).setReverse(reverse);
            saveBackwardGraphState();
        }
    }

    public final void updateMaterialRedTintColor(boolean isRed) {
        Graph graph = this.curSelectGraph;
        MaterialGraph materialGraph = graph instanceof MaterialGraph ? (MaterialGraph) graph : null;
        if (materialGraph != null) {
            ImageStyle style = materialGraph.getStyle();
            Intrinsics.checkNotNull(style, "null cannot be cast to non-null type com.ask.printersdk.graph.MaterialStyle");
            ((MaterialStyle) style).setRedTintColor(isRed);
            saveBackwardGraphState();
        }
    }

    public final void updateCurGraphText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        Graph graph = this.curSelectGraph;
        if (graph != null) {
            ((TextGraph) graph).updateText(text);
            saveBackwardGraphState();
        }
    }

    public static /* synthetic */ void updateTextSize$default(GraphManger graphManger, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        graphManger.updateTextSize(i, z);
    }

    public final void updateTextSize(int size, boolean saveFlag) {
        Graph graph = this.curSelectGraph;
        if (graph != null) {
            ((TextGraph) graph).updateTextSize(size);
            if (saveFlag) {
                saveBackwardGraphState();
            }
        }
    }

    public final void updateTextLetterSpacing(float size) {
        Graph graph = this.curSelectGraph;
        if (graph != null) {
            ((TextGraph) graph).updateTextLetterSpacing(size);
            saveBackwardGraphState();
        }
    }

    public final void updateTextLineSpacing(float size) {
        Graph graph = this.curSelectGraph;
        if (graph != null) {
            ((TextGraph) graph).updateTextLineSpacing(size);
            saveBackwardGraphState();
        }
    }

    public final void updateTextBold(boolean bold) {
        Graph graph = this.curSelectGraph;
        if (graph != null) {
            ((TextGraph) graph).updateTextBold(bold);
            saveBackwardGraphState();
        }
    }

    public final void updateTextUnderLine(boolean underLine) {
        Graph graph = this.curSelectGraph;
        if (graph != null) {
            ((TextGraph) graph).updateTextUnderLine(underLine);
            saveBackwardGraphState();
        }
    }

    public final void updateTextItalic(boolean italic) {
        Graph graph = this.curSelectGraph;
        if (graph != null) {
            ((TextGraph) graph).updateTextItalic(italic);
            saveBackwardGraphState();
        }
    }

    public final void setAutoFont(boolean autoFont) {
        Graph graph = this.curSelectGraph;
        TextGraph textGraph = graph instanceof TextGraph ? (TextGraph) graph : null;
        if (textGraph != null) {
            textGraph.getStyle().setAutoFont(autoFont);
            saveBackwardGraphState();
        }
    }

    public final void setEqualScale(boolean equalRatio) {
        Graph graph = this.curSelectGraph;
        if (graph != null) {
            ((ImageGraph) graph).setEqualScale(equalRatio);
        }
    }

    public static /* synthetic */ void updateTextAlign$default(GraphManger graphManger, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        graphManger.updateTextAlign(i);
    }

    public final void updateTextAlign(int align) {
        Graph graph = this.curSelectGraph;
        if (graph != null) {
            ((TextGraph) graph).updateTextAlign(align);
            saveBackwardGraphState();
        }
    }

    public static /* synthetic */ void updateTextToBoundLayoutAlign$default(GraphManger graphManger, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        graphManger.updateTextToBoundLayoutAlign(i);
    }

    public final void updateTextToBoundLayoutAlign(int align) {
        Graph graph = this.curSelectGraph;
        if (graph != null) {
            ((TextGraph) graph).updateToBoundLayoutAlign(align);
            saveBackwardGraphState();
        }
    }

    public final void updateImageContrast(int contrast) {
        Graph graph = this.curSelectGraph;
        if (graph != null) {
            ((ImageGraph) graph).getStyle().setContrast(contrast);
        }
    }

    public final void onAlignLeftCurGraph() {
        Graph graph = this.curSelectGraph;
        if (graph != null) {
            graph.onAlignLeftCurGraph();
            saveBackwardGraphState();
        }
    }

    public final void onAlignRightCurGraph() {
        Graph graph = this.curSelectGraph;
        if (graph != null) {
            graph.onAlignRightCurGraph();
            saveBackwardGraphState();
        }
    }

    public final void onAlignTopCurGraph() {
        Graph graph = this.curSelectGraph;
        if (graph != null) {
            graph.onAlignTopCurGraph();
            saveBackwardGraphState();
        }
    }

    public final void onAlignMiddle2HoriCurGraph() {
        Graph graph = this.curSelectGraph;
        if (graph != null) {
            graph.onAlignMiddle2HoriCurGraph();
            saveBackwardGraphState();
        }
    }

    public final void onAlignMiddleCurGraph() {
        Graph graph = this.curSelectGraph;
        if (graph != null) {
            graph.onAlignMiddleCurGraph();
            saveBackwardGraphState();
        }
    }

    public final void onAlignBottomCurGraph() {
        Graph graph = this.curSelectGraph;
        if (graph != null) {
            graph.onAlignBottomCurGraph();
            saveBackwardGraphState();
        }
    }

    public final void onMoveStep(int direct) {
        Graph graph = this.curSelectGraph;
        if (graph != null) {
            graph.onMoveStep(direct);
            saveBackwardGraphState();
        }
    }

    public final void cleanAllGraph() {
        ArrayList<Graph> arrayList = this.graphList;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.graphList = new ArrayList<>();
        this.curSelectGraph = null;
        GraphOpCallback graphOpCallback = this.graphOpCallback;
        if (graphOpCallback != null) {
            graphOpCallback.onSelected(null);
        }
        saveBackwardGraphState();
    }

    public final StateNode saveCurrentNode() {
        StateNode stateNode = new StateNode();
        stateNode.setPictureEditing(this.isPictureEditing);
        for (Graph graph : this.graphList) {
            int type = getType(graph);
            GraphState graphState = new GraphState();
            graphState.setType(type);
            graphState.setState(graph.saveState());
            stateNode.getGraphList().add(graphState);
        }
        Graph graph2 = this.curSelectGraph;
        if (graph2 != null) {
            Intrinsics.checkNotNull(graph2);
            stateNode.setSelectId(graph2.getId());
        }
        this.curSelectGraph = null;
        stateNode.setBoardGraph(this.boardGraph.getBoardStyle());
        return stateNode;
    }

    public final StateNode onSaveDraft(Context context) {
        Bitmap bitmapCreateBitmap;
        Intrinsics.checkNotNullParameter(context, "context");
        StateNode stateNodeSaveCurrentNode = saveCurrentNode();
        this.curSelectGraph = null;
        if (this.isPictureEditing) {
            RectF drawContentBounds = getDrawContentBounds();
            float f = 5;
            drawContentBounds.left += f;
            drawContentBounds.top += f;
            bitmapCreateBitmap = Bitmap.createBitmap(((int) drawContentBounds.width()) + 10, ((int) drawContentBounds.height()) + 10, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.translate(-drawContentBounds.left, -drawContentBounds.top);
            canvas.drawColor(PUtil.getColor(context, R.color.color_f5));
            for (Graph graph : this.graphList) {
                if (graph instanceof TextGraph) {
                    ((TextGraph) graph).onPictureDraw(context, canvas, drawContentBounds);
                } else {
                    graph.onDraw(context, canvas, this.paint);
                }
            }
            Intrinsics.checkNotNull(bitmapCreateBitmap);
        } else {
            bitmapCreateBitmap = Bitmap.createBitmap(this.viewWidth, this.viewHeight, Bitmap.Config.ARGB_8888);
            drawAllGraph(context, new Canvas(bitmapCreateBitmap));
            Intrinsics.checkNotNull(bitmapCreateBitmap);
        }
        stateNodeSaveCurrentNode.setDraftId(System.currentTimeMillis());
        stateNodeSaveCurrentNode.setImagePath(saveStateScreenshot(stateNodeSaveCurrentNode.getDraftId(), bitmapCreateBitmap));
        LogUtil.d("GraphManager", "截图路径：" + stateNodeSaveCurrentNode.getImagePath());
        BoardStyle boardGraph = stateNodeSaveCurrentNode.getBoardGraph();
        Integer numValueOf = boardGraph != null ? Integer.valueOf(boardGraph.getLabelPaperWidth()) : null;
        BoardStyle boardGraph2 = stateNodeSaveCurrentNode.getBoardGraph();
        LogUtil.d("GraphManager", "画布大小：" + numValueOf + ProxyConfig.MATCH_ALL_SCHEMES + (boardGraph2 != null ? Integer.valueOf(boardGraph2.getLabelPaperHeight()) : null) + "mm");
        return stateNodeSaveCurrentNode;
    }

    public final void openDraft(StateNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.isPictureEditing = node.getIsPictureEditing();
        BoardGraph boardGraph = this.boardGraph;
        BoardStyle boardGraph2 = node.getBoardGraph();
        Intrinsics.checkNotNull(boardGraph2);
        boardGraph.setDrawBoardData(boardGraph2);
        handleStateNode(node);
    }

    public final void openDraft(String jsonString) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        StateNode stateNode = (StateNode) JSON.parseObject(jsonString, StateNode.class);
        Intrinsics.checkNotNull(stateNode);
        openDraft(stateNode);
    }

    public final Bitmap onPrinting() {
        this.curSelectGraph = null;
        if (this.isPictureEditing) {
            RectF drawContentBounds = getDrawContentBounds();
            float f = 5;
            drawContentBounds.left += f;
            drawContentBounds.top += f;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((int) drawContentBounds.width()) + 10, ((int) drawContentBounds.height()) + 10, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.translate(-drawContentBounds.left, -drawContentBounds.top);
            canvas.drawColor(PUtil.getColor(this.context, R.color.color_f5));
            for (Graph graph : this.graphList) {
                if (graph instanceof TextGraph) {
                    ((TextGraph) graph).onPictureDraw(this.context, canvas, drawContentBounds);
                } else {
                    graph.onDraw(this.context, canvas, this.paint);
                }
            }
            Intrinsics.checkNotNull(bitmapCreateBitmap);
            return bitmapCreateBitmap;
        }
        BoardStyle boardStyle = this.boardGraph.getBoardStyle();
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(boardStyle.getDrawBoardWidth(), boardStyle.getDrawBoardHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
        canvas2.drawColor(PUtil.getColor(this.context, R.color.white));
        Iterator<T> it = this.graphList.iterator();
        while (it.hasNext()) {
            ((Graph) it.next()).onPrintingDraw(this.context, canvas2, this.paint);
        }
        Intrinsics.checkNotNull(bitmapCreateBitmap2);
        return bitmapCreateBitmap2;
    }

    public final void saveBackwardGraphState() {
        ArrayList<Graph> arrayList = this.graphList;
        if (arrayList.size() > 1) {
            CollectionsKt.sortWith(arrayList, new Comparator() { // from class: com.ask.printersdk.graph.common.GraphManger$saveBackwardGraphState$$inlined$sortBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((Graph) t).getOrderBy()), Integer.valueOf(((Graph) t2).getOrderBy()));
                }
            });
        }
        StateNode stateNode = new StateNode();
        stateNode.setPictureEditing(this.isPictureEditing);
        for (Graph graph : this.graphList) {
            int type = getType(graph);
            GraphState graphState = new GraphState();
            graphState.setType(type);
            graphState.setState(graph.saveState());
            stateNode.getGraphList().add(graphState);
        }
        Graph graph2 = this.curSelectGraph;
        if (graph2 != null) {
            Intrinsics.checkNotNull(graph2);
            stateNode.setSelectId(graph2.getId());
        }
        this.stateManger.pushBackwardState(stateNode);
        this.stateManger.cleanForwardState();
        GraphOpCallback graphOpCallback = this.graphOpCallback;
        if (graphOpCallback != null) {
            graphOpCallback.opStateChange(this.stateManger.getForwardStepCount(), this.stateManger.getBackwardStepCount());
        }
        if (this.isPictureEditing) {
            syncBoardBottom();
        }
        LogUtil.d("====== save " + JSON.toJSONString(stateNode));
    }

    private final int getType(Graph graph) {
        if (graph instanceof ShapeGraph) {
            return 10;
        }
        if (graph instanceof EdgingGraph) {
            return 9;
        }
        if (graph instanceof TimeGraph) {
            return 7;
        }
        if (graph instanceof QRCodeGraph) {
            return 5;
        }
        if (graph instanceof BarCodeGraph) {
            return 4;
        }
        if (graph instanceof MaterialGraph) {
            return 2;
        }
        return (!(graph instanceof ImageGraph) && (graph instanceof TextGraph)) ? 1 : 0;
    }

    public final void popBackwardGraphState() {
        StateNode stateNodePopBackwardState = this.stateManger.popBackwardState();
        if (stateNodePopBackwardState != null) {
            this.stateManger.pushForwardState(stateNodePopBackwardState);
        }
        StateNode stateNodePeekBackwardState = this.stateManger.peekBackwardState();
        handleStateNode(stateNodePeekBackwardState);
        GraphOpCallback graphOpCallback = this.graphOpCallback;
        if (graphOpCallback != null) {
            graphOpCallback.opStateChange(this.stateManger.getForwardStepCount(), this.stateManger.getBackwardStepCount());
        }
        LogUtil.e("====== restore " + JSON.toJSONString(stateNodePeekBackwardState));
    }

    public final void popForwardGraphState() {
        StateNode stateNodePopForwardState = this.stateManger.popForwardState();
        if (stateNodePopForwardState != null) {
            this.stateManger.pushBackwardState(stateNodePopForwardState);
            handleStateNode(stateNodePopForwardState);
        }
        GraphOpCallback graphOpCallback = this.graphOpCallback;
        if (graphOpCallback != null) {
            graphOpCallback.opStateChange(this.stateManger.getForwardStepCount(), this.stateManger.getBackwardStepCount());
        }
    }

    private final void handleStateNode(final StateNode node) {
        if (node == null) {
            cleanAllGraph();
            return;
        }
        this.graphList.clear();
        this.curSelectGraph = null;
        for (final GraphState graphState : node.getGraphList()) {
            int type = graphState.getType();
            if (type == 0) {
                final ImageStyle imageStyle = (ImageStyle) JSON.parseObject(graphState.getState(), ImageStyle.class);
                Bitmap image = this.imageCache.getImage(imageStyle.getImagePath());
                if (image == null && imageStyle.getImageUrl().length() > 0) {
                    try {
                        Intrinsics.checkNotNull(Glide.with(this.context).asBitmap().load(imageStyle.getImageUrl()).into(new CustomTarget<Bitmap>() { // from class: com.ask.printersdk.graph.common.GraphManger$handleStateNode$1$1
                            @Override // com.bumptech.glide.request.target.Target
                            public void onLoadCleared(Drawable placeholder) {
                            }

                            @Override // com.bumptech.glide.request.target.Target
                            public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                                onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                            }

                            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                                Intrinsics.checkNotNullParameter(resource, "resource");
                                ImageGraph imageGraph = new ImageGraph(this.this$0.getContext(), imageStyle.getImagePath());
                                imageGraph.setBitmap(resource);
                                imageGraph.setDrawBoardInfo(this.this$0.getBoardGraph().getBoardStyle());
                                imageGraph.restoreState(graphState.getState());
                                this.this$0.getGraphList().add(imageGraph);
                                if (imageStyle.getId() == node.getSelectId()) {
                                    this.this$0.setCurSelectGraph(imageGraph);
                                }
                            }
                        }));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (image != null) {
                    ImageGraph imageGraph = new ImageGraph(this.context, imageStyle.getImagePath());
                    imageGraph.setBitmap(image);
                    imageGraph.setDrawBoardInfo(this.boardGraph.getBoardStyle());
                    imageGraph.restoreState(graphState.getState());
                    this.graphList.add(imageGraph);
                    if (imageStyle.getId() == node.getSelectId()) {
                        this.curSelectGraph = imageGraph;
                    }
                }
            } else if (type == 1) {
                TextStyle textStyle = (TextStyle) JSON.parseObject(graphState.getState(), TextStyle.class);
                TextGraph textGraph = new TextGraph(this.context, textStyle.getText());
                textGraph.setDrawBoardInfo(this.boardGraph.getBoardStyle());
                textGraph.restoreState(graphState.getState());
                this.graphList.add(textGraph);
                if (textStyle.getId() == node.getSelectId()) {
                    this.curSelectGraph = textGraph;
                }
            } else if (type == 2) {
                MaterialStyle materialStyle = (MaterialStyle) JSON.parseObject(graphState.getState(), MaterialStyle.class);
                MaterialGraph materialGraph = new MaterialGraph(this.context);
                materialGraph.updateResName(materialStyle.getResName());
                materialGraph.setDrawBoardInfo(this.boardGraph.getBoardStyle());
                materialGraph.restoreState(graphState.getState());
                this.graphList.add(materialGraph);
                if (materialStyle.getId() == node.getSelectId()) {
                    this.curSelectGraph = materialGraph;
                }
            } else if (type == 4) {
                BarCodeGraph barCodeGraph = new BarCodeGraph(this.context);
                barCodeGraph.setDrawBoardInfo(this.boardGraph.getBoardStyle());
                barCodeGraph.restoreState(graphState.getState());
                this.graphList.add(barCodeGraph);
                if (barCodeGraph.getStyle().getId() == node.getSelectId()) {
                    this.curSelectGraph = barCodeGraph;
                }
            } else if (type == 5) {
                QRCodeGraph qRCodeGraph = new QRCodeGraph(this.context);
                qRCodeGraph.setDrawBoardInfo(this.boardGraph.getBoardStyle());
                qRCodeGraph.restoreState(graphState.getState());
                this.graphList.add(qRCodeGraph);
                if (qRCodeGraph.getStyle().getId() == node.getSelectId()) {
                    this.curSelectGraph = qRCodeGraph;
                }
            } else if (type == 7) {
                TimeStyle timeStyle = (TimeStyle) JSON.parseObject(graphState.getState(), TimeStyle.class);
                TimeGraph timeGraph = new TimeGraph(this.context, timeStyle.getText());
                timeGraph.setDrawBoardInfo(this.boardGraph.getBoardStyle());
                timeGraph.restoreState(graphState.getState());
                this.graphList.add(timeGraph);
                if (timeStyle.getId() == node.getSelectId()) {
                    this.curSelectGraph = timeGraph;
                }
            } else if (type == 9) {
                EdgingStyle edgingStyle = (EdgingStyle) JSON.parseObject(graphState.getState(), EdgingStyle.class);
                EdgingGraph edgingGraph = new EdgingGraph(this.context);
                edgingGraph.updateResName(edgingStyle.getResName());
                edgingGraph.setDrawBoardInfo(this.boardGraph.getBoardStyle());
                edgingGraph.restoreState(graphState.getState());
                this.graphList.add(edgingGraph);
                if (edgingStyle.getId() == node.getSelectId()) {
                    this.curSelectGraph = edgingGraph;
                }
            } else if (type == 10) {
                ShapeStyle shapeStyle = (ShapeStyle) JSON.parseObject(graphState.getState(), ShapeStyle.class);
                ShapeGraph shapeGraph = new ShapeGraph(this.context);
                shapeGraph.setDrawBoardInfo(this.boardGraph.getBoardStyle());
                shapeGraph.restoreState(graphState.getState());
                this.graphList.add(shapeGraph);
                if (shapeStyle.getId() == node.getSelectId()) {
                    this.curSelectGraph = shapeGraph;
                }
            }
        }
        ArrayList<Graph> arrayList = this.graphList;
        if (arrayList.size() > 1) {
            CollectionsKt.sortWith(arrayList, new Comparator() { // from class: com.ask.printersdk.graph.common.GraphManger$handleStateNode$$inlined$sortBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((Graph) t).getOrderBy()), Integer.valueOf(((Graph) t2).getOrderBy()));
                }
            });
        }
        GraphOpCallback graphOpCallback = this.graphOpCallback;
        if (graphOpCallback != null) {
            graphOpCallback.onSelected(this.curSelectGraph);
        }
    }

    private final void saveStateToJson(long draftId, StateNode node) {
        if (node != null) {
            int size = node.getGraphList().size();
            for (int i = 0; i < size; i++) {
                GraphState graphState = node.getGraphList().get(i);
                Intrinsics.checkNotNullExpressionValue(graphState, "get(...)");
                GraphState graphState2 = graphState;
                if (graphState2.getType() == 0) {
                    ImageStyle imageStyle = (ImageStyle) JSON.parseObject(graphState2.getState(), ImageStyle.class);
                    imageStyle.setImagePath("");
                    imageStyle.setImageUrl("https://img.lailaixiong.com.cn/labeldraft/00ec5a444a62a0161ff31e2e699747ce.jpg");
                    String jSONString = JSON.toJSONString(imageStyle);
                    Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(...)");
                    graphState2.setState(jSONString);
                }
            }
            String jSONString2 = JSON.toJSONString(node);
            String str = PUtil.getExternalStoragePath(this.context) + "/Json/" + draftId + ".json";
            LogUtil.d("GraphManger", "saveStateToJson: " + jSONString2 + " /n JsonFilePath:" + str);
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), Charsets.UTF_8);
            BufferedWriter bufferedWriter = outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
            try {
                bufferedWriter.write(jSONString2);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(bufferedWriter, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(bufferedWriter, th);
                    throw th2;
                }
            }
        }
    }

    public final StateNode getStateNode(long draftId) {
        String str = PUtil.getExternalStoragePath(this.context) + "/Json/" + draftId + ".json";
        LogUtil.d("GraphManger", "getStateNode: JsonFilePath:" + str);
        File file = new File(str);
        if (file.exists()) {
            return (StateNode) JSON.parseObject(FilesKt.readText$default(file, null, 1, null), StateNode.class);
        }
        return null;
    }

    private final String saveStateScreenshot(long draftId, Bitmap bitmap) {
        String str = PUtil.getExternalStoragePath(this.context) + "/Screenshot/" + draftId + ".jpg";
        PUtil.saveBitmapToFile(bitmap, str, Bitmap.CompressFormat.JPEG);
        LogUtil.d("GraphManger", "ScreenshotFilePath:" + str);
        return str;
    }

    public final Bitmap getStateScreenshot(long draftId) {
        return BitmapFactory.decodeFile(PUtil.getExternalStoragePath(this.context) + "/Screenshot/" + draftId + ".jpg");
    }

    private final void addDraftId(long draftId) {
        long[] jArrLoadLongArray = SharedPreferUtil.loadLongArray(this.context, "DraftIds");
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNull(jArrLoadLongArray);
        if (!(jArrLoadLongArray.length == 0)) {
            arrayList = ArraysKt.toMutableList(jArrLoadLongArray);
        }
        arrayList.add(Long.valueOf(draftId));
        SharedPreferUtil.saveLongArray(this.context, "DraftIds", CollectionsKt.toLongArray(arrayList));
    }

    public final long[] getDraftIds() {
        long[] jArrLoadLongArray = SharedPreferUtil.loadLongArray(this.context, "DraftIds");
        Intrinsics.checkNotNullExpressionValue(jArrLoadLongArray, "loadLongArray(...)");
        return jArrLoadLongArray;
    }

    public final void deleteDraftId(long draftId) {
        long[] jArrLoadLongArray = SharedPreferUtil.loadLongArray(this.context, "DraftIds");
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNull(jArrLoadLongArray);
        if (!(jArrLoadLongArray.length == 0)) {
            arrayList = ArraysKt.toMutableList(jArrLoadLongArray);
        }
        arrayList.remove(Long.valueOf(draftId));
        SharedPreferUtil.saveLongArray(this.context, "DraftIds", CollectionsKt.toLongArray(arrayList));
        String externalStoragePath = PUtil.getExternalStoragePath(this.context);
        File file = new File(externalStoragePath + "/Json/" + draftId + ".json");
        if (file.exists()) {
            file.delete();
        }
        File file2 = new File(externalStoragePath + "/Screenshot/" + draftId + ".jpg");
        if (file2.exists()) {
            file2.delete();
        }
    }

    private final RectF getDrawContentBounds() {
        RectF rectF = new RectF();
        Iterator<T> it = this.graphList.iterator();
        while (it.hasNext()) {
            rectF.union(((Graph) it.next()).getBound());
        }
        return rectF;
    }

    private final void syncBoardBottom() {
        if (this.graphList.size() > 0) {
            this.boardGraph.getBoardStyle().setDrawBoardBottom((int) getBoardContentBounds().bottom);
        }
    }

    private final RectF getBoardContentBounds() {
        RectF rectF = new RectF();
        Iterator<T> it = this.graphList.iterator();
        while (it.hasNext()) {
            rectF.union(((Graph) it.next()).getBound2Board());
        }
        return rectF;
    }
}
