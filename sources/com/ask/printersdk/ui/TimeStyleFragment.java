package com.ask.printersdk.ui;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.ask.printersdk.R;
import com.ask.printersdk.databinding.FragmentTimeStyleBinding;
import com.ask.printersdk.graph.Graph;
import com.ask.printersdk.graph.TextStyle;
import com.ask.printersdk.graph.TimeGraph;
import com.ask.printersdk.graph.TimeStyle;
import com.ask.printersdk.graph.common.DrawingSurfaceView;
import com.ask.printersdk.graph.common.GraphManger;
import com.ask.printersdk.ui.dialog.FloatMenuDialog;
import com.ask.printersdk.ui.dialog.ModifyDateDialog;
import com.ask.printersdk.ui.dialog.ModifyTimeDialog;
import com.ask.printersdk.utils.DateUtil;
import com.ask.printersdk.utils.PUtil;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: TimeStyleFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020 J\u0010\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020,H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u0015\u0010\u001b\u001a\u00060\u001cR\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006."}, d2 = {"Lcom/ask/printersdk/ui/TimeStyleFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "viewModel", "Lcom/ask/printersdk/ui/PrintEditViewModel;", "getViewModel", "()Lcom/ask/printersdk/ui/PrintEditViewModel;", "setViewModel", "(Lcom/ask/printersdk/ui/PrintEditViewModel;)V", "binding", "Lcom/ask/printersdk/databinding/FragmentTimeStyleBinding;", "getBinding", "()Lcom/ask/printersdk/databinding/FragmentTimeStyleBinding;", "setBinding", "(Lcom/ask/printersdk/databinding/FragmentTimeStyleBinding;)V", "timeStyle", "Ljava/lang/ref/WeakReference;", "Lcom/ask/printersdk/graph/TimeStyle;", "getTimeStyle", "()Ljava/lang/ref/WeakReference;", "setTimeStyle", "(Ljava/lang/ref/WeakReference;)V", "graphManger", "Lcom/ask/printersdk/graph/common/GraphManger;", "getGraphManger", "setGraphManger", "data", "Lcom/ask/printersdk/ui/TimeStyleFragment$Data;", "getData", "()Lcom/ask/printersdk/ui/TimeStyleFragment$Data;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initView", "", "rootView", "modifyPrefix", "prefix", "", "Data", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TimeStyleFragment extends Fragment {
    public FragmentTimeStyleBinding binding;
    private final Data data = new Data();
    private WeakReference<GraphManger> graphManger;
    private WeakReference<TimeStyle> timeStyle;
    private PrintEditViewModel viewModel;

    protected final PrintEditViewModel getViewModel() {
        return this.viewModel;
    }

    protected final void setViewModel(PrintEditViewModel printEditViewModel) {
        this.viewModel = printEditViewModel;
    }

    public final FragmentTimeStyleBinding getBinding() {
        FragmentTimeStyleBinding fragmentTimeStyleBinding = this.binding;
        if (fragmentTimeStyleBinding != null) {
            return fragmentTimeStyleBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(FragmentTimeStyleBinding fragmentTimeStyleBinding) {
        Intrinsics.checkNotNullParameter(fragmentTimeStyleBinding, "<set-?>");
        this.binding = fragmentTimeStyleBinding;
    }

    public final WeakReference<TimeStyle> getTimeStyle() {
        return this.timeStyle;
    }

    public final void setTimeStyle(WeakReference<TimeStyle> weakReference) {
        this.timeStyle = weakReference;
    }

    public final WeakReference<GraphManger> getGraphManger() {
        return this.graphManger;
    }

    public final void setGraphManger(WeakReference<GraphManger> weakReference) {
        this.graphManger = weakReference;
    }

    public final Data getData() {
        return this.data;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.fragment_time_style, container, false);
        Intrinsics.checkNotNull(viewInflate);
        initView(viewInflate);
        return viewInflate;
    }

    public final void initView(View rootView) {
        DrawingSurfaceView drawingSurfaceView;
        DrawingSurfaceView drawingSurfaceView2;
        GraphManger graphManger;
        Graph curSelectGraph;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        ViewModelProvider.AndroidViewModelFactory.Companion companion = ViewModelProvider.AndroidViewModelFactory.INSTANCE;
        FragmentActivity activity2 = getActivity();
        Intrinsics.checkNotNull(activity2);
        Application application = activity2.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        this.viewModel = (PrintEditViewModel) new ViewModelProvider(activity, companion.getInstance(application)).get(PrintEditViewModel.class);
        FragmentTimeStyleBinding fragmentTimeStyleBinding = (FragmentTimeStyleBinding) DataBindingUtil.bind(rootView);
        if (fragmentTimeStyleBinding == null) {
            return;
        }
        setBinding(fragmentTimeStyleBinding);
        PrintEditViewModel printEditViewModel = this.viewModel;
        GraphManger graphManger2 = null;
        if (printEditViewModel != null && (drawingSurfaceView2 = printEditViewModel.drawingSurfaceView) != null && (graphManger = drawingSurfaceView2.getGraphManger()) != null && (curSelectGraph = graphManger.getCurSelectGraph()) != null) {
            TimeGraph timeGraph = curSelectGraph instanceof TimeGraph ? (TimeGraph) curSelectGraph : null;
            if (timeGraph != null) {
                TextStyle style = timeGraph.getStyle();
                Intrinsics.checkNotNull(style, "null cannot be cast to non-null type com.ask.printersdk.graph.TimeStyle");
                TimeStyle timeStyle = (TimeStyle) style;
                this.timeStyle = new WeakReference<>(timeStyle);
                getBinding().timeSwitch.setChecked(timeStyle.getIsRealTime());
                getBinding().prefixTv.setText(Intrinsics.areEqual(timeStyle.getPrefixText(), "") ? getString(R.string.no_prefix) : timeStyle.getPrefixText());
                getBinding().dateTv.setText(DateUtil.INSTANCE.formatDate(timeStyle.getCurrentDate(), timeStyle.getDateStyle()));
                getBinding().timeTv.setText(DateUtil.INSTANCE.formatDate(timeStyle.getCurrentDate(), timeStyle.getTimeStyle()));
            }
        }
        PrintEditViewModel printEditViewModel2 = this.viewModel;
        if (printEditViewModel2 != null && (drawingSurfaceView = printEditViewModel2.drawingSurfaceView) != null) {
            graphManger2 = drawingSurfaceView.getGraphManger();
        }
        this.graphManger = new WeakReference<>(graphManger2);
        getBinding().timeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.ask.printersdk.ui.TimeStyleFragment$$ExternalSyntheticLambda4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                TimeStyleFragment.initView$lambda$2(this.f$0, compoundButton, z);
            }
        });
        getBinding().prefixTv.setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.ui.TimeStyleFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TimeStyleFragment.initView$lambda$6(this.f$0, view);
            }
        });
        getBinding().dateTv.setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.ui.TimeStyleFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TimeStyleFragment.initView$lambda$10(this.f$0, view);
            }
        });
        getBinding().timeTv.setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.ui.TimeStyleFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TimeStyleFragment.initView$lambda$14(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(TimeStyleFragment timeStyleFragment, CompoundButton compoundButton, boolean z) {
        GraphManger graphManger;
        TimeStyle timeStyle;
        WeakReference<TimeStyle> weakReference = timeStyleFragment.timeStyle;
        if (weakReference != null && (timeStyle = weakReference.get()) != null) {
            timeStyle.setRealTime(z);
        }
        WeakReference<GraphManger> weakReference2 = timeStyleFragment.graphManger;
        if (weakReference2 == null || (graphManger = weakReference2.get()) == null) {
            return;
        }
        graphManger.updateTimeGraph();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r9v7, types: [T, java.util.List] */
    public static final void initView$lambda$6(final TimeStyleFragment timeStyleFragment, View view) {
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) view;
        String string = textView.getText().toString();
        int[] iArr = new int[2];
        textView.getLocationOnScreen(iArr);
        int i = iArr[1];
        FloatMenuDialog floatMenuDialog = new FloatMenuDialog();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = CollectionsKt.mutableListOf(timeStyleFragment.getString(R.string.no_prefix), timeStyleFragment.getString(R.string.production_date), timeStyleFragment.getString(R.string.shelf_date), timeStyleFragment.getString(R.string.made_on));
        if (!((List) objectRef.element).contains(string)) {
            ((List) objectRef.element).add(string);
        } else {
            List list = (List) objectRef.element;
            String string2 = timeStyleFragment.getString(R.string.customize);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            list.add(string2);
        }
        floatMenuDialog.setDataSource((List) objectRef.element);
        floatMenuDialog.setSelectText(string);
        floatMenuDialog.setViewSize(new Size(PUtil.dip2px(timeStyleFragment.getContext(), 150.0f), PUtil.dip2px(timeStyleFragment.getContext(), 130.0f)));
        floatMenuDialog.setViewMargin(new Rect(PUtil.dip2px(timeStyleFragment.getContext(), 20.0f), (i - PUtil.dip2px(timeStyleFragment.getContext(), 10.0f)) - floatMenuDialog.getViewSize().getHeight(), 0, 0));
        FragmentManager childFragmentManager = timeStyleFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        floatMenuDialog.show(childFragmentManager, "FloatMenuDialog");
        floatMenuDialog.setCallback(new Function1() { // from class: com.ask.printersdk.ui.TimeStyleFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TimeStyleFragment.initView$lambda$6$lambda$5(objectRef, timeStyleFragment, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$6$lambda$5(Ref.ObjectRef objectRef, final TimeStyleFragment timeStyleFragment, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (Intrinsics.areEqual(it, CollectionsKt.last((List) objectRef.element))) {
            Context context = timeStyleFragment.getContext();
            Intrinsics.checkNotNull(context);
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage(timeStyleFragment.getString(R.string.customize));
            final EditText editText = new EditText(timeStyleFragment.getContext());
            editText.setHint(timeStyleFragment.getString(R.string.input_prefix));
            editText.setTextSize(14.0f);
            builder.setView(editText);
            builder.setPositiveButton(timeStyleFragment.getString(R.string.ok), new DialogInterface.OnClickListener() { // from class: com.ask.printersdk.ui.TimeStyleFragment$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    TimeStyleFragment.initView$lambda$6$lambda$5$lambda$3(editText, timeStyleFragment, dialogInterface, i);
                }
            });
            builder.setNegativeButton(timeStyleFragment.getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.ask.printersdk.ui.TimeStyleFragment$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            AlertDialog alertDialogCreate = builder.create();
            Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
            alertDialogCreate.show();
        } else {
            timeStyleFragment.modifyPrefix(it);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6$lambda$5$lambda$3(EditText editText, TimeStyleFragment timeStyleFragment, DialogInterface dialogInterface, int i) {
        String string = editText.getText().toString();
        if (string.length() > 0) {
            timeStyleFragment.modifyPrefix(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$10(final TimeStyleFragment timeStyleFragment, View view) {
        TimeStyle timeStyle;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[1];
        int i2 = iArr[0];
        ModifyDateDialog modifyDateDialog = new ModifyDateDialog();
        WeakReference<TimeStyle> weakReference = timeStyleFragment.timeStyle;
        if (weakReference != null && (timeStyle = weakReference.get()) != null) {
            modifyDateDialog.setRealDate(timeStyle.getIsRealTime());
            modifyDateDialog.setShowDate(timeStyle.getIsShowDate());
            modifyDateDialog.setCurrentFormat(timeStyle.getDateStyle());
            modifyDateDialog.setCurrentDate(timeStyle.getCurrentDate());
        }
        modifyDateDialog.setViewSize(new Size(PUtil.dip2px(timeStyleFragment.getContext(), 220.0f), PUtil.dip2px(timeStyleFragment.getContext(), 180.0f)));
        modifyDateDialog.setViewMargin(new Rect(i2, (i - PUtil.dip2px(timeStyleFragment.getContext(), 10.0f)) - modifyDateDialog.getViewSize().getHeight(), 0, 0));
        modifyDateDialog.setCallback(new Function3() { // from class: com.ask.printersdk.ui.TimeStyleFragment$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return TimeStyleFragment.initView$lambda$10$lambda$9(this.f$0, (Date) obj, (String) obj2, ((Boolean) obj3).booleanValue());
            }
        });
        FragmentManager childFragmentManager = timeStyleFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        modifyDateDialog.show(childFragmentManager, "FloatMenuDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$10$lambda$9(TimeStyleFragment timeStyleFragment, Date currentDate, String currentFormat, boolean z) {
        GraphManger graphManger;
        TimeStyle timeStyle;
        Intrinsics.checkNotNullParameter(currentDate, "currentDate");
        Intrinsics.checkNotNullParameter(currentFormat, "currentFormat");
        WeakReference<TimeStyle> weakReference = timeStyleFragment.timeStyle;
        if (weakReference != null && (timeStyle = weakReference.get()) != null) {
            timeStyle.setShowDate(z);
            timeStyle.setDateStyle(currentFormat);
            timeStyle.setCurrentDate(currentDate);
        }
        WeakReference<GraphManger> weakReference2 = timeStyleFragment.graphManger;
        if (weakReference2 != null && (graphManger = weakReference2.get()) != null) {
            graphManger.updateTimeGraph();
        }
        if (z) {
            timeStyleFragment.getBinding().dateTv.setText(DateUtil.INSTANCE.formatDate(currentDate, currentFormat));
        } else {
            timeStyleFragment.getBinding().dateTv.setText(timeStyleFragment.getString(R.string.no_date));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$14(final TimeStyleFragment timeStyleFragment, View view) {
        TimeStyle timeStyle;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[1];
        ModifyTimeDialog modifyTimeDialog = new ModifyTimeDialog();
        WeakReference<TimeStyle> weakReference = timeStyleFragment.timeStyle;
        if (weakReference != null && (timeStyle = weakReference.get()) != null) {
            modifyTimeDialog.setRealTime(timeStyle.getIsRealTime());
            modifyTimeDialog.setShowTime(timeStyle.getIsShowTime());
            modifyTimeDialog.setCurrentFormat(timeStyle.getTimeStyle());
            modifyTimeDialog.setCurrentTime(timeStyle.getCurrentDate());
            modifyTimeDialog.set24Hour(timeStyle.getIs24Hour());
        }
        modifyTimeDialog.setViewSize(new Size(PUtil.dip2px(timeStyleFragment.getContext(), 220.0f), PUtil.dip2px(timeStyleFragment.getContext(), 190.0f)));
        modifyTimeDialog.setViewMargin(new Rect(0, (i - PUtil.dip2px(timeStyleFragment.getContext(), 10.0f)) - modifyTimeDialog.getViewSize().getHeight(), PUtil.dip2px(timeStyleFragment.getContext(), 25.0f), 0));
        modifyTimeDialog.setCallback(new Function4() { // from class: com.ask.printersdk.ui.TimeStyleFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return TimeStyleFragment.initView$lambda$14$lambda$13(this.f$0, (Date) obj, (String) obj2, ((Boolean) obj3).booleanValue(), ((Boolean) obj4).booleanValue());
            }
        });
        FragmentManager childFragmentManager = timeStyleFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        modifyTimeDialog.show(childFragmentManager, "FloatMenuDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$14$lambda$13(TimeStyleFragment timeStyleFragment, Date currentDate, String currentFormat, boolean z, boolean z2) {
        GraphManger graphManger;
        TimeStyle timeStyle;
        Intrinsics.checkNotNullParameter(currentDate, "currentDate");
        Intrinsics.checkNotNullParameter(currentFormat, "currentFormat");
        WeakReference<TimeStyle> weakReference = timeStyleFragment.timeStyle;
        if (weakReference != null && (timeStyle = weakReference.get()) != null) {
            timeStyle.setShowTime(z);
            timeStyle.setTimeStyle(currentFormat);
            timeStyle.setCurrentDate(currentDate);
            timeStyle.set24Hour(z2);
        }
        WeakReference<GraphManger> weakReference2 = timeStyleFragment.graphManger;
        if (weakReference2 != null && (graphManger = weakReference2.get()) != null) {
            graphManger.updateTimeGraph();
        }
        if (z) {
            timeStyleFragment.getBinding().timeTv.setText(DateUtil.INSTANCE.formatDate(currentDate, currentFormat));
        } else {
            timeStyleFragment.getBinding().timeTv.setText(timeStyleFragment.getString(R.string.no_time));
        }
        return Unit.INSTANCE;
    }

    private final void modifyPrefix(String prefix) {
        TimeStyle timeStyle;
        GraphManger graphManger;
        getBinding().prefixTv.setText(prefix);
        WeakReference<TimeStyle> weakReference = this.timeStyle;
        if (weakReference == null || (timeStyle = weakReference.get()) == null) {
            return;
        }
        timeStyle.setPrefixText(prefix);
        WeakReference<GraphManger> weakReference2 = this.graphManger;
        if (weakReference2 == null || (graphManger = weakReference2.get()) == null) {
            return;
        }
        graphManger.updateTimeGraph();
    }

    /* JADX INFO: compiled from: TimeStyleFragment.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ask/printersdk/ui/TimeStyleFragment$Data;", "Landroidx/databinding/BaseObservable;", "<init>", "(Lcom/ask/printersdk/ui/TimeStyleFragment;)V", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class Data extends BaseObservable {
        public Data() {
        }
    }
}
