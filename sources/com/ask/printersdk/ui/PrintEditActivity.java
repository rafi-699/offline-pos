package com.ask.printersdk.ui;

import android.app.Application;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.alibaba.fastjson.JSON;
import com.ask.printersdk.R;
import com.ask.printersdk.TagPrintingManger;
import com.ask.printersdk.base.BaseExtendsKt;
import com.ask.printersdk.base.dialog.CommPopDialog;
import com.ask.printersdk.databinding.ActivityPrintEditBinding;
import com.ask.printersdk.graph.BarCodeGraph;
import com.ask.printersdk.graph.EdgingGraph;
import com.ask.printersdk.graph.Graph;
import com.ask.printersdk.graph.ImageGraph;
import com.ask.printersdk.graph.MaterialGraph;
import com.ask.printersdk.graph.QRCodeGraph;
import com.ask.printersdk.graph.ShapeGraph;
import com.ask.printersdk.graph.TimeGraph;
import com.ask.printersdk.graph.common.GraphManger;
import com.ask.printersdk.graph.common.GraphOpCallback;
import com.ask.printersdk.graph.state.StateNode;
import com.ask.printersdk.ui.dialog.SettingPaperDialog;
import com.ask.printersdk.utils.PUtil;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.gyf.immersionbar.ImmersionBar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PrintEditActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0004J\b\u0010\u000e\u001a\u00020\rH\u0014J\u0012\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\rH\u0014J\b\u0010\u0013\u001a\u00020\rH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00060\tR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ask/printersdk/ui/PrintEditActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "viewModel", "Lcom/ask/printersdk/ui/PrintEditViewModel;", "binding", "Lcom/ask/printersdk/databinding/ActivityPrintEditBinding;", "data", "Lcom/ask/printersdk/ui/PrintEditActivity$Data;", "pickerFragment", "Lcom/ask/printersdk/ui/FunPickerFragment;", "setStatusAndNavBar", "", "onDestroy", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "Companion", "Data", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PrintEditActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static PrintEditActivity instance;
    private ActivityPrintEditBinding binding;
    private final Data data = new Data();
    private final FunPickerFragment pickerFragment = new FunPickerFragment();
    private PrintEditViewModel viewModel;

    /* JADX INFO: compiled from: PrintEditActivity.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ask/printersdk/ui/PrintEditActivity$Companion;", "", "<init>", "()V", "instance", "Lcom/ask/printersdk/ui/PrintEditActivity;", "getInstance", "()Lcom/ask/printersdk/ui/PrintEditActivity;", "setInstance", "(Lcom/ask/printersdk/ui/PrintEditActivity;)V", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PrintEditActivity getInstance() {
            return PrintEditActivity.instance;
        }

        public final void setInstance(PrintEditActivity printEditActivity) {
            PrintEditActivity.instance = printEditActivity;
        }
    }

    protected final void setStatusAndNavBar() {
        ImmersionBar.with(this).statusBarColor(R.color.white).fitsSystemWindows(true).navigationBarColor(R.color.white).statusBarDarkFont(true).navigationBarDarkIcon(true).init();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        instance = null;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        setStatusAndNavBar();
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        ActivityPrintEditBinding activityPrintEditBindingInflate = ActivityPrintEditBinding.inflate(LayoutInflater.from(this));
        this.binding = activityPrintEditBindingInflate;
        ActivityPrintEditBinding activityPrintEditBinding = null;
        if (activityPrintEditBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPrintEditBindingInflate = null;
        }
        setContentView(activityPrintEditBindingInflate.getRoot());
        ActivityPrintEditBinding activityPrintEditBinding2 = this.binding;
        if (activityPrintEditBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPrintEditBinding2 = null;
        }
        activityPrintEditBinding2.setData(this.data);
        ViewModelProvider.AndroidViewModelFactory.Companion companion = ViewModelProvider.AndroidViewModelFactory.INSTANCE;
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        PrintEditViewModel printEditViewModel = (PrintEditViewModel) new ViewModelProvider(this, companion.getInstance(application)).get(PrintEditViewModel.class);
        this.viewModel = printEditViewModel;
        if (printEditViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            printEditViewModel = null;
        }
        ActivityPrintEditBinding activityPrintEditBinding3 = this.binding;
        if (activityPrintEditBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPrintEditBinding3 = null;
        }
        printEditViewModel.drawingSurfaceView = activityPrintEditBinding3.drawingView;
        ActivityPrintEditBinding activityPrintEditBinding4 = this.binding;
        if (activityPrintEditBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPrintEditBinding4 = null;
        }
        ImageView imageBack = activityPrintEditBinding4.imageBack;
        Intrinsics.checkNotNullExpressionValue(imageBack, "imageBack");
        BaseExtendsKt.click(imageBack, (Function1<? super View, Unit>) new Function1() { // from class: com.ask.printersdk.ui.PrintEditActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PrintEditActivity.onCreate$lambda$0(this.f$0, (View) obj);
            }
        });
        PUtil.initializeWithFragment(getSupportFragmentManager(), R.id.layout_bottom_bar, this.pickerFragment);
        PrintEditViewModel printEditViewModel2 = this.viewModel;
        if (printEditViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            printEditViewModel2 = null;
        }
        printEditViewModel2.setGraphOpCallback(new GraphOpCallback() { // from class: com.ask.printersdk.ui.PrintEditActivity.onCreate.2
            @Override // com.ask.printersdk.graph.common.GraphOpCallback
            public void onDrawingBoardChanged() {
                PrintEditViewModel printEditViewModel3 = PrintEditActivity.this.viewModel;
                ActivityPrintEditBinding activityPrintEditBinding5 = null;
                if (printEditViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    printEditViewModel3 = null;
                }
                if (printEditViewModel3.getGraphManger().getIsPictureEditing()) {
                    return;
                }
                ActivityPrintEditBinding activityPrintEditBinding6 = PrintEditActivity.this.binding;
                if (activityPrintEditBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityPrintEditBinding6 = null;
                }
                if (activityPrintEditBinding6.btnBoardReset.getVisibility() != 0) {
                    ActivityPrintEditBinding activityPrintEditBinding7 = PrintEditActivity.this.binding;
                    if (activityPrintEditBinding7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityPrintEditBinding5 = activityPrintEditBinding7;
                    }
                    activityPrintEditBinding5.btnBoardReset.setVisibility(0);
                }
            }

            @Override // com.ask.printersdk.graph.common.GraphOpCallback
            public void opStateChange(int forwardSteps, int backwardSteps) {
                ActivityPrintEditBinding activityPrintEditBinding5 = null;
                if (forwardSteps == 0) {
                    ActivityPrintEditBinding activityPrintEditBinding6 = PrintEditActivity.this.binding;
                    if (activityPrintEditBinding6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityPrintEditBinding6 = null;
                    }
                    activityPrintEditBinding6.imageForward.setImageResource(R.drawable.ic_op_forward_dis);
                    ActivityPrintEditBinding activityPrintEditBinding7 = PrintEditActivity.this.binding;
                    if (activityPrintEditBinding7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityPrintEditBinding7 = null;
                    }
                    activityPrintEditBinding7.imageForward.setEnabled(false);
                } else {
                    ActivityPrintEditBinding activityPrintEditBinding8 = PrintEditActivity.this.binding;
                    if (activityPrintEditBinding8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityPrintEditBinding8 = null;
                    }
                    activityPrintEditBinding8.imageForward.setImageResource(R.drawable.ic_op_forward_step);
                    ActivityPrintEditBinding activityPrintEditBinding9 = PrintEditActivity.this.binding;
                    if (activityPrintEditBinding9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityPrintEditBinding9 = null;
                    }
                    activityPrintEditBinding9.imageForward.setEnabled(true);
                }
                if (backwardSteps == 0) {
                    ActivityPrintEditBinding activityPrintEditBinding10 = PrintEditActivity.this.binding;
                    if (activityPrintEditBinding10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityPrintEditBinding10 = null;
                    }
                    activityPrintEditBinding10.imageBackward.setImageResource(R.drawable.ic_op_backward_dis);
                    ActivityPrintEditBinding activityPrintEditBinding11 = PrintEditActivity.this.binding;
                    if (activityPrintEditBinding11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityPrintEditBinding5 = activityPrintEditBinding11;
                    }
                    activityPrintEditBinding5.imageBackward.setEnabled(false);
                    return;
                }
                ActivityPrintEditBinding activityPrintEditBinding12 = PrintEditActivity.this.binding;
                if (activityPrintEditBinding12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityPrintEditBinding12 = null;
                }
                activityPrintEditBinding12.imageBackward.setImageResource(R.drawable.ic_op_backward_step);
                ActivityPrintEditBinding activityPrintEditBinding13 = PrintEditActivity.this.binding;
                if (activityPrintEditBinding13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityPrintEditBinding5 = activityPrintEditBinding13;
                }
                activityPrintEditBinding5.imageBackward.setEnabled(true);
            }

            @Override // com.ask.printersdk.graph.common.GraphOpCallback
            public void onSelected(Graph graph) {
                if (graph == null) {
                    PUtil.replaceFragment(PrintEditActivity.this.getSupportFragmentManager(), R.id.layout_bottom_bar, PrintEditActivity.this.pickerFragment);
                    return;
                }
                if (graph instanceof EdgingGraph) {
                    PUtil.replaceFragment(PrintEditActivity.this.getSupportFragmentManager(), R.id.layout_bottom_bar, new EdgingOpFragment());
                    return;
                }
                if (graph instanceof TimeGraph) {
                    PUtil.replaceFragment(PrintEditActivity.this.getSupportFragmentManager(), R.id.layout_bottom_bar, new TimeOpFragment());
                    return;
                }
                if (graph instanceof ShapeGraph) {
                    PUtil.replaceFragment(PrintEditActivity.this.getSupportFragmentManager(), R.id.layout_bottom_bar, new ShapeOpFragment());
                    return;
                }
                if (graph instanceof MaterialGraph) {
                    PUtil.replaceFragment(PrintEditActivity.this.getSupportFragmentManager(), R.id.layout_bottom_bar, new MaterialOpFragment());
                    return;
                }
                if (graph instanceof QRCodeGraph) {
                    PUtil.replaceFragment(PrintEditActivity.this.getSupportFragmentManager(), R.id.layout_bottom_bar, new QRCodeOpFragment());
                    return;
                }
                if (graph instanceof BarCodeGraph) {
                    PUtil.replaceFragment(PrintEditActivity.this.getSupportFragmentManager(), R.id.layout_bottom_bar, new BarCodeOpFragment());
                } else if (graph instanceof ImageGraph) {
                    PUtil.replaceFragment(PrintEditActivity.this.getSupportFragmentManager(), R.id.layout_bottom_bar, new ImageOpFragment());
                } else {
                    PUtil.replaceFragment(PrintEditActivity.this.getSupportFragmentManager(), R.id.layout_bottom_bar, new TextOpFragment());
                }
            }
        });
        boolean booleanExtra = getIntent().getBooleanExtra("isPictureEditing", false);
        if (getIntent().hasExtra("StateNode")) {
            final StateNode stateNode = (StateNode) JSON.parseObject(getIntent().getStringExtra("StateNode"), StateNode.class);
            if (stateNode != null) {
                PrintEditViewModel printEditViewModel3 = this.viewModel;
                if (printEditViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    printEditViewModel3 = null;
                }
                printEditViewModel3.drawingSurfaceView.post(new Runnable() { // from class: com.ask.printersdk.ui.PrintEditActivity$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        PrintEditActivity.onCreate$lambda$1(this.f$0, stateNode);
                    }
                });
            }
        } else {
            PrintEditViewModel printEditViewModel4 = this.viewModel;
            if (printEditViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                printEditViewModel4 = null;
            }
            printEditViewModel4.drawingSurfaceView.getGraphManger().setPictureEditing(booleanExtra);
            int intExtra = getIntent().getIntExtra("tagWidth", 50);
            int intExtra2 = getIntent().getIntExtra("tagHeight", 30);
            PrintEditViewModel printEditViewModel5 = this.viewModel;
            if (printEditViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                printEditViewModel5 = null;
            }
            printEditViewModel5.drawingSurfaceView.getGraphManger().setDrawBoardSize(intExtra, intExtra2);
            if (booleanExtra) {
                this.pickerFragment.showSelectedItemDialog();
            }
        }
        if (booleanExtra) {
            ActivityPrintEditBinding activityPrintEditBinding5 = this.binding;
            if (activityPrintEditBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityPrintEditBinding5 = null;
            }
            activityPrintEditBinding5.imageSetting.setVisibility(8);
            ActivityPrintEditBinding activityPrintEditBinding6 = this.binding;
            if (activityPrintEditBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityPrintEditBinding6 = null;
            }
            activityPrintEditBinding6.tvSave.setVisibility(8);
        }
        String stringExtra = getIntent().getStringExtra("Title");
        String str = stringExtra;
        if (str == null || StringsKt.isBlank(str)) {
            stringExtra = "";
        }
        ActivityPrintEditBinding activityPrintEditBinding7 = this.binding;
        if (activityPrintEditBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityPrintEditBinding = activityPrintEditBinding7;
        }
        activityPrintEditBinding.textTitle.setText(stringExtra);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(PrintEditActivity printEditActivity, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        printEditActivity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(PrintEditActivity printEditActivity, StateNode stateNode) {
        PrintEditViewModel printEditViewModel = printEditActivity.viewModel;
        if (printEditViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            printEditViewModel = null;
        }
        printEditViewModel.drawingSurfaceView.openDraft(stateNode);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        PrintEditViewModel printEditViewModel = this.viewModel;
        if (printEditViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            printEditViewModel = null;
        }
        printEditViewModel.drawingSurfaceView.pauseDrawing();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        PrintEditViewModel printEditViewModel = this.viewModel;
        if (printEditViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            printEditViewModel = null;
        }
        printEditViewModel.drawingSurfaceView.resumeDrawing();
    }

    /* JADX INFO: compiled from: PrintEditActivity.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u000e"}, d2 = {"Lcom/ask/printersdk/ui/PrintEditActivity$Data;", "", "<init>", "(Lcom/ask/printersdk/ui/PrintEditActivity;)V", "onClearDrawing", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "onResetBoard", "onForwardStep", "onBackwardStep", "onSetting", "onSaveDraft", "onPrinting", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class Data {
        public Data() {
        }

        public final void onClearDrawing(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            PrintEditViewModel printEditViewModel = PrintEditActivity.this.viewModel;
            if (printEditViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                printEditViewModel = null;
            }
            GraphManger graphManger = printEditViewModel.drawingSurfaceView.getGraphManger();
            if (graphManger != null) {
                graphManger.onDeleteCurGraph();
            }
        }

        public final void onResetBoard(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            PrintEditViewModel printEditViewModel = PrintEditActivity.this.viewModel;
            if (printEditViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                printEditViewModel = null;
            }
            printEditViewModel.drawingSurfaceView.resetDrawingBoard();
            view.setVisibility(8);
        }

        public final void onForwardStep(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            PrintEditViewModel printEditViewModel = PrintEditActivity.this.viewModel;
            if (printEditViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                printEditViewModel = null;
            }
            printEditViewModel.drawingSurfaceView.getGraphManger().popForwardGraphState();
        }

        public final void onBackwardStep(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            PrintEditViewModel printEditViewModel = PrintEditActivity.this.viewModel;
            if (printEditViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                printEditViewModel = null;
            }
            printEditViewModel.drawingSurfaceView.getGraphManger().popBackwardGraphState();
        }

        public final void onSetting(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            new SettingPaperDialog().show(PrintEditActivity.this.getSupportFragmentManager(), "SettingPaperDialog");
        }

        public final void onSaveDraft(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            CommPopDialog commPopDialog = new CommPopDialog();
            String string = PrintEditActivity.this.getString(R.string.info);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CommPopDialog titleTxt = commPopDialog.setTitleTxt(string);
            String string2 = PrintEditActivity.this.getString(R.string.saved_to_drafts);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            titleTxt.setDescTxt(string2).show(PrintEditActivity.this.getSupportFragmentManager(), "CommPopDialog");
            PrintEditViewModel printEditViewModel = PrintEditActivity.this.viewModel;
            if (printEditViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                printEditViewModel = null;
            }
            StateNode stateNodeOnSaveDraft = printEditViewModel.drawingSurfaceView.onSaveDraft();
            TagPrintingManger.TagCallback tagCallback = TagPrintingManger.INSTANCE.getTagCallback();
            if (tagCallback != null) {
                Intrinsics.checkNotNull(stateNodeOnSaveDraft);
                tagCallback.onSaveDraft(stateNodeOnSaveDraft);
            }
        }

        public final void onPrinting(View view) {
            TagPrintingManger.TagCallback tagCallback;
            Intrinsics.checkNotNullParameter(view, "view");
            PrintEditViewModel printEditViewModel = PrintEditActivity.this.viewModel;
            if (printEditViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                printEditViewModel = null;
            }
            Bitmap bitmapOnPrinting = printEditViewModel.drawingSurfaceView.onPrinting();
            PrintEditViewModel printEditViewModel2 = PrintEditActivity.this.viewModel;
            if (printEditViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                printEditViewModel2 = null;
            }
            GraphManger graphManger = printEditViewModel2.getGraphManger();
            StateNode stateNodeSaveCurrentNode = graphManger != null ? graphManger.saveCurrentNode() : null;
            if (stateNodeSaveCurrentNode == null || (tagCallback = TagPrintingManger.INSTANCE.getTagCallback()) == null) {
                return;
            }
            Intrinsics.checkNotNull(bitmapOnPrinting);
            tagCallback.onPrinting(bitmapOnPrinting, stateNodeSaveCurrentNode);
        }
    }
}
