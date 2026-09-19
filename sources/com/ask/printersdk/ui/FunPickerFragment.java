package com.ask.printersdk.ui;

import android.app.AlertDialog;
import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ask.printersdk.R;
import com.ask.printersdk.base.BaseExtendsKt;
import com.ask.printersdk.base.KBaseAdapter;
import com.ask.printersdk.databinding.ItemFunPickerBinding;
import com.ask.printersdk.graph.common.DrawingSurfaceView;
import com.ask.printersdk.graph.common.GraphManger;
import com.ask.printersdk.utils.LogUtil;
import com.ask.printersdk.utils.PUtil;
import com.ask.printersdk.utils.ToastUitl;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: FunPickerFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001eJ\u0006\u0010(\u001a\u00020&J\b\u0010)\u001a\u00020&H\u0002J\b\u0010*\u001a\u00020&H\u0002J\"\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0018\u00100\u001a\u00020&2\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u00020\u000fJ\b\u00104\u001a\u00020&H\u0002J+\u00105\u001a\u00020&2\u0006\u0010,\u001a\u00020\u00052\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000f072\u0006\u00108\u001a\u000209H\u0016¢\u0006\u0002\u0010:R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082.¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/ask/printersdk/ui/FunPickerFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "FILE_CHOOSER_RESULT_CODE", "", "REQUEST_CODE_TAKE_PHOTO", "REQUEST_EXTERNAL_STORAGE", "takePhotoImageUri", "Landroid/net/Uri;", "getTakePhotoImageUri", "()Landroid/net/Uri;", "setTakePhotoImageUri", "(Landroid/net/Uri;)V", "takePhotoPath", "", "getTakePhotoPath", "()Ljava/lang/String;", "setTakePhotoPath", "(Ljava/lang/String;)V", "viewModel", "Lcom/ask/printersdk/ui/PrintEditViewModel;", "getViewModel", "()Lcom/ask/printersdk/ui/PrintEditViewModel;", "setViewModel", "(Lcom/ask/printersdk/ui/PrintEditViewModel;)V", "tabs", "", "Lcom/ask/printersdk/ui/FunPickerFragment$Tab;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initView", "", "rootView", "showSelectedItemDialog", "openImageChooserActivity", "takePhoto", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "handleBitmap", "bitmap", "Landroid/graphics/Bitmap;", "mimeType", "checkAndRequestStoragePermission", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "Tab", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FunPickerFragment extends Fragment {
    private List<Tab> tabs;
    private Uri takePhotoImageUri;
    private PrintEditViewModel viewModel;
    private final int FILE_CHOOSER_RESULT_CODE = 10000;
    private final int REQUEST_CODE_TAKE_PHOTO = 10002;
    private final int REQUEST_EXTERNAL_STORAGE = Videoio.CAP_PROP_GIGA_FRAME_WIDTH_MAX;
    private String takePhotoPath = "";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSelectedItemDialog$lambda$4(DialogInterface dialogInterface) {
    }

    protected final Uri getTakePhotoImageUri() {
        return this.takePhotoImageUri;
    }

    protected final void setTakePhotoImageUri(Uri uri) {
        this.takePhotoImageUri = uri;
    }

    protected final String getTakePhotoPath() {
        return this.takePhotoPath;
    }

    protected final void setTakePhotoPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.takePhotoPath = str;
    }

    protected final PrintEditViewModel getViewModel() {
        return this.viewModel;
    }

    protected final void setViewModel(PrintEditViewModel printEditViewModel) {
        this.viewModel = printEditViewModel;
    }

    /* JADX INFO: compiled from: FunPickerFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ask/printersdk/ui/FunPickerFragment$Tab;", "", "txt", "", "id", "", "<init>", "(Ljava/lang/String;I)V", "getTxt", "()Ljava/lang/String;", "getId", "()I", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Tab {
        private final int id;
        private final String txt;

        public Tab(String txt, int i) {
            Intrinsics.checkNotNullParameter(txt, "txt");
            this.txt = txt;
            this.id = i;
        }

        public final int getId() {
            return this.id;
        }

        public final String getTxt() {
            return this.txt;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        String string = getString(R.string.image);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(R.string.text);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = getString(R.string.material);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = getString(R.string.barcode);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        String string5 = getString(R.string.qrcode);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        String string6 = getString(R.string.datetime);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        String string7 = getString(R.string.border);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        String string8 = getString(R.string.shape);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        this.tabs = CollectionsKt.listOf((Object[]) new Tab[]{new Tab(string, R.drawable.ic_sel_pic), new Tab(string2, R.drawable.ic_sel_txt), new Tab(string3, R.drawable.ic_sel_material), new Tab(string4, R.drawable.ic_sel_barcode), new Tab(string5, R.drawable.ic_sel_qrcode), new Tab(string6, R.drawable.ic_sel_time), new Tab(string7, R.drawable.ic_sel_frame), new Tab(string8, R.drawable.ic_sel_shape)});
        View viewInflate = inflater.inflate(R.layout.fragment_fun_picker, container, false);
        Intrinsics.checkNotNull(viewInflate);
        initView(viewInflate);
        return viewInflate;
    }

    public final void initView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        ViewModelProvider.AndroidViewModelFactory.Companion companion = ViewModelProvider.AndroidViewModelFactory.INSTANCE;
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        Application application = activity.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        this.viewModel = (PrintEditViewModel) new ViewModelProvider(fragmentActivityRequireActivity, companion.getInstance(application)).get(PrintEditViewModel.class);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
        Intrinsics.checkNotNull(recyclerView);
        KBaseAdapter.Builder builder = new KBaseAdapter.Builder(recyclerView);
        List<Tab> list = this.tabs;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabs");
            list = null;
        }
        builder.setData(list).setLayoutId(R.layout.item_fun_picker).addBindView(new Function3() { // from class: com.ask.printersdk.ui.FunPickerFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return FunPickerFragment.initView$lambda$1(this.f$0, (View) obj, (FunPickerFragment.Tab) obj2, ((Integer) obj3).intValue());
            }
        }).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$1(final FunPickerFragment funPickerFragment, View itemView, Tab itemData, final int i) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        ItemFunPickerBinding itemFunPickerBinding = (ItemFunPickerBinding) DataBindingUtil.bind(itemView);
        if (itemFunPickerBinding == null) {
            return Unit.INSTANCE;
        }
        TextView textView = itemFunPickerBinding.text;
        List<Tab> list = funPickerFragment.tabs;
        List<Tab> list2 = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabs");
            list = null;
        }
        textView.setText(String.valueOf(list.get(i).getTxt()));
        ImageView imageView = itemFunPickerBinding.image;
        List<Tab> list3 = funPickerFragment.tabs;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabs");
        } else {
            list2 = list3;
        }
        imageView.setImageResource(list2.get(i).getId());
        View root = itemFunPickerBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        BaseExtendsKt.click(root, (Function1<? super View, Unit>) new Function1() { // from class: com.ask.printersdk.ui.FunPickerFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FunPickerFragment.initView$lambda$1$lambda$0(i, funPickerFragment, (View) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$1$lambda$0(int i, FunPickerFragment funPickerFragment, View it) {
        GraphManger graphManger;
        GraphManger graphManger2;
        GraphManger graphManger3;
        GraphManger graphManger4;
        GraphManger graphManger5;
        GraphManger graphManger6;
        Intrinsics.checkNotNullParameter(it, "it");
        switch (i) {
            case 0:
                funPickerFragment.showSelectedItemDialog();
                break;
            case 1:
                PrintEditViewModel printEditViewModel = funPickerFragment.viewModel;
                if (printEditViewModel != null) {
                    printEditViewModel.addText("");
                }
                break;
            case 2:
                PrintEditViewModel printEditViewModel2 = funPickerFragment.viewModel;
                if (printEditViewModel2 != null && (graphManger = printEditViewModel2.getGraphManger()) != null) {
                    graphManger.selectMaterial();
                }
                break;
            case 3:
                PrintEditViewModel printEditViewModel3 = funPickerFragment.viewModel;
                if (printEditViewModel3 != null && (graphManger2 = printEditViewModel3.getGraphManger()) != null) {
                    graphManger2.addBarCodeGraph();
                }
                break;
            case 4:
                PrintEditViewModel printEditViewModel4 = funPickerFragment.viewModel;
                if (printEditViewModel4 != null && (graphManger3 = printEditViewModel4.getGraphManger()) != null) {
                    graphManger3.addQRCodeGraph();
                }
                break;
            case 5:
                PrintEditViewModel printEditViewModel5 = funPickerFragment.viewModel;
                if (printEditViewModel5 != null && (graphManger4 = printEditViewModel5.getGraphManger()) != null) {
                    graphManger4.addTimeGraph();
                }
                break;
            case 6:
                PrintEditViewModel printEditViewModel6 = funPickerFragment.viewModel;
                if (printEditViewModel6 != null && (graphManger5 = printEditViewModel6.getGraphManger()) != null) {
                    graphManger5.selectEdging();
                }
                break;
            case 7:
                PrintEditViewModel printEditViewModel7 = funPickerFragment.viewModel;
                if (printEditViewModel7 != null && (graphManger6 = printEditViewModel7.getGraphManger()) != null) {
                    graphManger6.addShapeGraph();
                }
                break;
        }
        return Unit.INSTANCE;
    }

    public final void showSelectedItemDialog() {
        if (getContext() == null) {
            return;
        }
        String[] strArr = {getString(R.string.take_photo), getString(R.string.choose_from_photos)};
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.ask.printersdk.ui.FunPickerFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                FunPickerFragment.showSelectedItemDialog$lambda$3(this.f$0, dialogInterface, i);
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ask.printersdk.ui.FunPickerFragment$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                FunPickerFragment.showSelectedItemDialog$lambda$4(dialogInterface);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSelectedItemDialog$lambda$3(final FunPickerFragment funPickerFragment, DialogInterface dialogInterface, int i) {
        if (funPickerFragment.getActivity() == null) {
            return;
        }
        if (i == 0) {
            if (ActivityCompat.checkSelfPermission(funPickerFragment.requireActivity(), "android.permission.CAMERA") == 0) {
                funPickerFragment.takePhoto();
                return;
            } else {
                if (Intrinsics.areEqual(funPickerFragment.getString(R.string.camera_permission_desc), "off")) {
                    return;
                }
                new AlertDialog.Builder(funPickerFragment.getActivity()).setTitle(funPickerFragment.getString(R.string.info)).setMessage(funPickerFragment.getString(R.string.camera_permission_desc)).setPositiveButton(funPickerFragment.getString(R.string.ok), new DialogInterface.OnClickListener() { // from class: com.ask.printersdk.ui.FunPickerFragment$$ExternalSyntheticLambda4
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface2, int i2) {
                        FunPickerFragment.showSelectedItemDialog$lambda$3$lambda$2(this.f$0, dialogInterface2, i2);
                    }
                }).show();
                return;
            }
        }
        funPickerFragment.checkAndRequestStoragePermission();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSelectedItemDialog$lambda$3$lambda$2(FunPickerFragment funPickerFragment, DialogInterface dialogInterface, int i) {
        funPickerFragment.requestPermissions(new String[]{"android.permission.CAMERA"}, funPickerFragment.REQUEST_CODE_TAKE_PHOTO);
    }

    private final void openImageChooserActivity() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Image Chooser"), this.FILE_CHOOSER_RESULT_CODE);
    }

    private final void takePhoto() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File file = new File(PUtil.getDiskCacheDir(getContext()) + DomExceptionUtils.SEPARATOR + SystemClock.currentThreadTimeMillis() + ".jpg");
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        this.takePhotoPath = absolutePath;
        Uri uriForFile = FileProvider.getUriForFile(requireContext(), requireActivity().getApplication().getPackageName() + ".android7.fileprovider", file);
        this.takePhotoImageUri = uriForFile;
        intent.putExtra("output", uriForFile);
        startActivityForResult(intent, this.REQUEST_CODE_TAKE_PHOTO);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String type;
        String type2;
        DrawingSurfaceView drawingSurfaceView;
        super.onActivityResult(requestCode, resultCode, data);
        String str = "image/jpeg";
        if (requestCode == this.FILE_CHOOSER_RESULT_CODE && resultCode == -1 && data != null) {
            PrintEditViewModel printEditViewModel = this.viewModel;
            if (printEditViewModel != null && (drawingSurfaceView = printEditViewModel.drawingSurfaceView) != null) {
                drawingSurfaceView.resetDrawingThread();
            }
            Uri data2 = data.getData();
            if (data2 != null && (type2 = requireActivity().getContentResolver().getType(data2)) != null) {
                str = type2;
            }
            handleBitmap(PUtil.getBitmapFromUri(getContext(), data2, ""), str);
            return;
        }
        if (requestCode == this.REQUEST_CODE_TAKE_PHOTO && resultCode == -1) {
            Bitmap bitmapFromUri = PUtil.getBitmapFromUri(getContext(), this.takePhotoImageUri, this.takePhotoPath);
            Uri uri = this.takePhotoImageUri;
            if (uri != null && (type = requireActivity().getContentResolver().getType(uri)) != null) {
                str = type;
            }
            handleBitmap(bitmapFromUri, str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v19, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v8, types: [T, java.lang.String] */
    public final void handleBitmap(Bitmap bitmap, String mimeType) {
        GraphManger graphManger;
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        if (bitmap == null) {
            return;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        if (Intrinsics.areEqual(mimeType, "image/png")) {
            objectRef.element = PUtil.getDiskCacheDir(getContext()) + DomExceptionUtils.SEPARATOR + SystemClock.currentThreadTimeMillis() + ".png";
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass1(bitmap, objectRef, null), 3, null);
        } else {
            objectRef.element = PUtil.getDiskCacheDir(getContext()) + DomExceptionUtils.SEPARATOR + SystemClock.currentThreadTimeMillis() + ".jpeg";
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass2(bitmap, objectRef, null), 3, null);
        }
        PrintEditViewModel printEditViewModel = this.viewModel;
        if (printEditViewModel == null || (graphManger = printEditViewModel.getGraphManger()) == null) {
            return;
        }
        graphManger.addBitmapGraph((String) objectRef.element, bitmap);
    }

    /* JADX INFO: renamed from: com.ask.printersdk.ui.FunPickerFragment$handleBitmap$1, reason: invalid class name */
    /* JADX INFO: compiled from: FunPickerFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ask.printersdk.ui.FunPickerFragment$handleBitmap$1", f = "FunPickerFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $bitmap;
        final /* synthetic */ Ref.ObjectRef<String> $path;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Bitmap bitmap, Ref.ObjectRef<String> objectRef, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$bitmap = bitmap;
            this.$path = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$bitmap, this.$path, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            PUtil.saveBitmapToFile(this.$bitmap, this.$path.element, Bitmap.CompressFormat.PNG);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.ask.printersdk.ui.FunPickerFragment$handleBitmap$2, reason: invalid class name */
    /* JADX INFO: compiled from: FunPickerFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ask.printersdk.ui.FunPickerFragment$handleBitmap$2", f = "FunPickerFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $bitmap;
        final /* synthetic */ Ref.ObjectRef<String> $path;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Bitmap bitmap, Ref.ObjectRef<String> objectRef, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$bitmap = bitmap;
            this.$path = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$bitmap, this.$path, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            PUtil.saveBitmapToFile(this.$bitmap, this.$path.element, Bitmap.CompressFormat.JPEG);
            return Unit.INSTANCE;
        }
    }

    private final void checkAndRequestStoragePermission() {
        openImageChooserActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == this.REQUEST_CODE_TAKE_PHOTO) {
            if (!(grantResults.length == 0) && grantResults[0] == 0) {
                takePhoto();
            } else {
                LogUtil.i("no camera permission");
                ToastUitl.showCenterToast(getContext(), "no camera permission");
            }
        }
    }
}
