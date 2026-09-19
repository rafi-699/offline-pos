package com.ask.printersdk.ui;

import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.RecyclerView;
import com.ask.printersdk.R;
import com.ask.printersdk.base.BaseExtendsKt;
import com.ask.printersdk.base.KBaseAdapter;
import com.ask.printersdk.databinding.FragmentTextFontBinding;
import com.ask.printersdk.databinding.ItemFontTextBinding;
import com.ask.printersdk.graph.Graph;
import com.ask.printersdk.graph.TextGraph;
import com.ask.printersdk.graph.common.DrawingSurfaceView;
import com.ask.printersdk.graph.common.GraphManger;
import com.bumptech.glide.Glide;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: compiled from: TextFontFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020&J&\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u00105J\u0018\u00106\u001a\u00020.2\u0006\u00107\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u0018H\u0003J\u0010\u00108\u001a\u00020!2\u0006\u00104\u001a\u00020\u0018H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\"\"\u0004\b#\u0010$¨\u00069"}, d2 = {"Lcom/ask/printersdk/ui/TextFontFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "viewModel", "Lcom/ask/printersdk/ui/PrintEditViewModel;", "getViewModel", "()Lcom/ask/printersdk/ui/PrintEditViewModel;", "setViewModel", "(Lcom/ask/printersdk/ui/PrintEditViewModel;)V", "fontsList", "", "Lcom/ask/printersdk/ui/FontData;", "getFontsList", "()Ljava/util/List;", "setFontsList", "(Ljava/util/List;)V", "adapter", "Lcom/ask/printersdk/base/KBaseAdapter;", "getAdapter", "()Lcom/ask/printersdk/base/KBaseAdapter;", "setAdapter", "(Lcom/ask/printersdk/base/KBaseAdapter;)V", "selectedFont", "", "getSelectedFont", "()Ljava/lang/String;", "setSelectedFont", "(Ljava/lang/String;)V", "selectedFontName", "getSelectedFontName", "setSelectedFontName", "isLocal", "", "()Z", "setLocal", "(Z)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initView", "", "rootView", "downloadFontFile", "Ljava/io/File;", "typeface", "url", "fontName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showCopyrightDialog", "copyright", "isFontExists", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextFontFragment extends Fragment {
    public KBaseAdapter<FontData> adapter;
    private PrintEditViewModel viewModel;
    private List<FontData> fontsList = CollectionsKt.emptyList();
    private String selectedFont = "";
    private String selectedFontName = "";
    private boolean isLocal = true;

    /* JADX INFO: renamed from: com.ask.printersdk.ui.TextFontFragment$downloadFontFile$1, reason: invalid class name */
    /* JADX INFO: compiled from: TextFontFragment.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ask.printersdk.ui.TextFontFragment", f = "TextFontFragment.kt", i = {0, 0, 0, 1}, l = {140, 168}, m = "downloadFontFile", n = {"fontName", "fileName", "file", "file"}, s = {"L$0", "L$1", "L$2", "L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TextFontFragment.this.downloadFontFile(null, null, null, this);
        }
    }

    protected final PrintEditViewModel getViewModel() {
        return this.viewModel;
    }

    protected final void setViewModel(PrintEditViewModel printEditViewModel) {
        this.viewModel = printEditViewModel;
    }

    public final List<FontData> getFontsList() {
        return this.fontsList;
    }

    public final void setFontsList(List<FontData> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.fontsList = list;
    }

    public final KBaseAdapter<FontData> getAdapter() {
        KBaseAdapter<FontData> kBaseAdapter = this.adapter;
        if (kBaseAdapter != null) {
            return kBaseAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        return null;
    }

    public final void setAdapter(KBaseAdapter<FontData> kBaseAdapter) {
        Intrinsics.checkNotNullParameter(kBaseAdapter, "<set-?>");
        this.adapter = kBaseAdapter;
    }

    public final String getSelectedFont() {
        return this.selectedFont;
    }

    public final void setSelectedFont(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.selectedFont = str;
    }

    public final String getSelectedFontName() {
        return this.selectedFontName;
    }

    public final void setSelectedFontName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.selectedFontName = str;
    }

    /* JADX INFO: renamed from: isLocal, reason: from getter */
    public final boolean getIsLocal() {
        return this.isLocal;
    }

    public final void setLocal(boolean z) {
        this.isLocal = z;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.fragment_text_font, container, false);
        Intrinsics.checkNotNull(viewInflate);
        initView(viewInflate);
        return viewInflate;
    }

    public final void initView(View rootView) {
        DrawingSurfaceView drawingSurfaceView;
        GraphManger graphManger;
        Graph curSelectGraph;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        ViewModelProvider.AndroidViewModelFactory.Companion companion = ViewModelProvider.AndroidViewModelFactory.INSTANCE;
        Application application = requireActivity().getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        this.viewModel = (PrintEditViewModel) new ViewModelProvider(fragmentActivityRequireActivity, companion.getInstance(application)).get(PrintEditViewModel.class);
        FragmentTextFontBinding fragmentTextFontBinding = (FragmentTextFontBinding) DataBindingUtil.bind(rootView);
        if (fragmentTextFontBinding == null) {
            return;
        }
        PrintEditViewModel printEditViewModel = this.viewModel;
        if (printEditViewModel != null && (drawingSurfaceView = printEditViewModel.drawingSurfaceView) != null && (graphManger = drawingSurfaceView.getGraphManger()) != null && (curSelectGraph = graphManger.getCurSelectGraph()) != null) {
            TextGraph textGraph = (TextGraph) curSelectGraph;
            this.selectedFont = textGraph.getStyle().getFontTypeface();
            this.selectedFontName = textGraph.getStyle().getFontIdentifier();
        }
        RecyclerView recyclerView = fragmentTextFontBinding.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        setAdapter(new KBaseAdapter.Builder(recyclerView).setData(this.fontsList).setLayoutId(R.layout.item_font_text).addBindView(new Function3() { // from class: com.ask.printersdk.ui.TextFontFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return TextFontFragment.initView$lambda$5(this.f$0, (View) obj, (FontData) obj2, ((Integer) obj3).intValue());
            }
        }).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$5(final TextFontFragment textFontFragment, View itemView, final FontData itemData, int i) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        final ItemFontTextBinding itemFontTextBinding = (ItemFontTextBinding) DataBindingUtil.bind(itemView);
        if (itemFontTextBinding == null) {
            return Unit.INSTANCE;
        }
        if (StringsKt.endsWith$default(itemData.getImageName(), ".png", false, 2, (Object) null)) {
            String string = textFontFragment.getString(R.string.img_domain);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Intrinsics.checkNotNull(Glide.with(textFontFragment).load(string + itemData.getImageName()).into(itemFontTextBinding.nameImage));
        } else {
            Resources resources = textFontFragment.getResources();
            String imageName = itemData.getImageName();
            Context context = textFontFragment.getContext();
            int identifier = resources.getIdentifier(imageName, "drawable", context != null ? context.getPackageName() : null);
            if (identifier != 0) {
                itemFontTextBinding.nameImage.setImageResource(identifier);
            }
        }
        if (Intrinsics.areEqual(itemData.getText(), textFontFragment.selectedFontName)) {
            itemFontTextBinding.imageSel.setVisibility(0);
        } else {
            itemFontTextBinding.imageSel.setVisibility(4);
        }
        if (itemData.getCopyright().length() > 0) {
            itemFontTextBinding.imageCopyright.setVisibility(0);
            ImageView imageCopyright = itemFontTextBinding.imageCopyright;
            Intrinsics.checkNotNullExpressionValue(imageCopyright, "imageCopyright");
            BaseExtendsKt.click(imageCopyright, (Function1<? super View, Unit>) new Function1() { // from class: com.ask.printersdk.ui.TextFontFragment$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TextFontFragment.initView$lambda$5$lambda$2(this.f$0, itemData, (View) obj);
                }
            });
        } else {
            itemFontTextBinding.imageCopyright.setVisibility(8);
        }
        if (textFontFragment.isFontExists(itemData.getTypeface())) {
            itemFontTextBinding.imageDownload.setVisibility(8);
        } else {
            itemFontTextBinding.imageDownload.setVisibility(0);
            ImageView imageDownload = itemFontTextBinding.imageDownload;
            Intrinsics.checkNotNullExpressionValue(imageDownload, "imageDownload");
            BaseExtendsKt.click(imageDownload, (Function1<? super View, Unit>) new Function1() { // from class: com.ask.printersdk.ui.TextFontFragment$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TextFontFragment.initView$lambda$5$lambda$3(itemFontTextBinding, textFontFragment, itemData, (View) obj);
                }
            });
        }
        View root = itemFontTextBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        BaseExtendsKt.click(root, (Function1<? super View, Unit>) new Function1() { // from class: com.ask.printersdk.ui.TextFontFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFontFragment.initView$lambda$5$lambda$4(this.f$0, itemData, (View) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$5$lambda$2(TextFontFragment textFontFragment, FontData fontData, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        textFontFragment.showCopyrightDialog(fontData.getCopyright(), fontData.getText());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$5$lambda$3(ItemFontTextBinding itemFontTextBinding, TextFontFragment textFontFragment, FontData fontData, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        itemFontTextBinding.imageDownload.setVisibility(8);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new TextFontFragment$initView$2$2$1(textFontFragment, fontData, textFontFragment.getString(R.string.font_domain) + fontData.getUrl(), null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$5$lambda$4(TextFontFragment textFontFragment, FontData fontData, View it) {
        GraphManger graphManger;
        Intrinsics.checkNotNullParameter(it, "it");
        textFontFragment.selectedFont = fontData.getTypeface();
        textFontFragment.selectedFontName = fontData.getText();
        if (textFontFragment.isFontExists(fontData.getTypeface())) {
            textFontFragment.getAdapter().notifyDataSetChanged();
            PrintEditViewModel printEditViewModel = textFontFragment.viewModel;
            if (printEditViewModel != null && (graphManger = printEditViewModel.getGraphManger()) != null) {
                graphManger.updateTextTypeface(textFontFragment.selectedFont, textFontFragment.selectedFontName);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object downloadFontFile(String str, String str2, String str3, Continuation<? super File> continuation) {
        AnonymousClass1 anonymousClass1;
        String str4;
        File file;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objWithContext = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWithContext);
            Context context = getContext();
            File file2 = new File(context != null ? context.getFilesDir() : null, "fonts");
            file2.mkdirs();
            File file3 = new File(file2, str);
            CoroutineDispatcher io2 = Dispatchers.getIO();
            TextFontFragment$downloadFontFile$isDownloaded$1 textFontFragment$downloadFontFile$isDownloaded$1 = new TextFontFragment$downloadFontFile$isDownloaded$1(str2, file3, null);
            anonymousClass1.L$0 = str3;
            anonymousClass1.L$1 = str;
            anonymousClass1.L$2 = file3;
            anonymousClass1.label = 1;
            objWithContext = BuildersKt.withContext(io2, textFontFragment$downloadFontFile$isDownloaded$1, anonymousClass1);
            if (objWithContext != coroutine_suspended) {
                str4 = str;
                file = file3;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            File file4 = (File) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objWithContext);
            return file4;
        }
        file = (File) anonymousClass1.L$2;
        str4 = (String) anonymousClass1.L$1;
        str3 = (String) anonymousClass1.L$0;
        ResultKt.throwOnFailure(objWithContext);
        if (((Boolean) objWithContext).booleanValue()) {
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(str3, str4, null);
            anonymousClass1.L$0 = file;
            anonymousClass1.L$1 = null;
            anonymousClass1.L$2 = null;
            anonymousClass1.label = 2;
            if (BuildersKt.withContext(main, anonymousClass2, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return file;
    }

    /* JADX INFO: renamed from: com.ask.printersdk.ui.TextFontFragment$downloadFontFile$2, reason: invalid class name */
    /* JADX INFO: compiled from: TextFontFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ask.printersdk.ui.TextFontFragment$downloadFontFile$2", f = "TextFontFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $fileName;
        final /* synthetic */ String $fontName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, String str2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$fontName = str;
            this.$fileName = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TextFontFragment.this.new AnonymousClass2(this.$fontName, this.$fileName, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            GraphManger graphManger;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            TextFontFragment.this.setSelectedFontName(this.$fontName);
            TextFontFragment.this.setSelectedFont(this.$fileName);
            TextFontFragment.this.getAdapter().notifyDataSetChanged();
            PrintEditViewModel viewModel = TextFontFragment.this.getViewModel();
            if (viewModel == null || (graphManger = viewModel.getGraphManger()) == null) {
                return null;
            }
            graphManger.updateTextTypeface(this.$fileName, TextFontFragment.this.getSelectedFontName());
            return Unit.INSTANCE;
        }
    }

    private final void showCopyrightDialog(String copyright, String fontName) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.copyright_dialog, (ViewGroup) null);
        builder.setView(viewInflate);
        ((TextView) viewInflate.findViewById(R.id.title)).setText(fontName);
        ((TextView) viewInflate.findViewById(R.id.copyright)).setText("Copyright@" + copyright);
        TextView textView = (TextView) viewInflate.findViewById(R.id.link);
        textView.setText("View \"SIL OPEN Font License (OFL)\"");
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.ui.TextFontFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextFontFragment.showCopyrightDialog$lambda$6(this.f$0, view);
            }
        });
        final AlertDialog alertDialogCreate = builder.create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        ((Button) viewInflate.findViewById(R.id.ok_button)).setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.ui.TextFontFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                alertDialogCreate.dismiss();
            }
        });
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCopyrightDialog$lambda$6(TextFontFragment textFontFragment, View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://openfontlicense.org"));
        Context context = textFontFragment.getContext();
        if (context != null) {
            context.startActivity(intent);
        }
    }

    private final boolean isFontExists(String fontName) {
        Context context = getContext();
        return new File(new File(context != null ? context.getFilesDir() : null, "fonts/" + fontName).getAbsolutePath()).exists();
    }
}
