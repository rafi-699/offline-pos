package com.ask.printersdk.ui;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.ask.printersdk.R;
import com.ask.printersdk.databinding.FragmentImageConvertBinding;
import com.ask.printersdk.graph.Graph;
import com.ask.printersdk.graph.ImageGraph;
import com.ask.printersdk.graph.common.DrawingSurfaceView;
import com.ask.printersdk.graph.common.GraphManger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageConvertFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0015\u0010\n\u001a\u00060\u000bR\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/ask/printersdk/ui/ImageConvertFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "viewModel", "Lcom/ask/printersdk/ui/PrintEditViewModel;", "getViewModel", "()Lcom/ask/printersdk/ui/PrintEditViewModel;", "setViewModel", "(Lcom/ask/printersdk/ui/PrintEditViewModel;)V", "data", "Lcom/ask/printersdk/ui/ImageConvertFragment$Data;", "getData", "()Lcom/ask/printersdk/ui/ImageConvertFragment$Data;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initView", "", "rootView", "Data", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageConvertFragment extends Fragment {
    private final Data data = new Data();
    private PrintEditViewModel viewModel;

    protected final PrintEditViewModel getViewModel() {
        return this.viewModel;
    }

    protected final void setViewModel(PrintEditViewModel printEditViewModel) {
        this.viewModel = printEditViewModel;
    }

    public final Data getData() {
        return this.data;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.fragment_image_convert, container, false);
        Intrinsics.checkNotNull(viewInflate);
        initView(viewInflate);
        return viewInflate;
    }

    public final void initView(View rootView) {
        DrawingSurfaceView drawingSurfaceView;
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
        FragmentImageConvertBinding fragmentImageConvertBinding = (FragmentImageConvertBinding) DataBindingUtil.bind(rootView);
        if (fragmentImageConvertBinding == null) {
            return;
        }
        PrintEditViewModel printEditViewModel = this.viewModel;
        if (printEditViewModel != null && (drawingSurfaceView = printEditViewModel.drawingSurfaceView) != null && (graphManger = drawingSurfaceView.getGraphManger()) != null && (curSelectGraph = graphManger.getCurSelectGraph()) != null) {
            ImageGraph imageGraph = (ImageGraph) curSelectGraph;
            this.data.setContrast(imageGraph.getStyle().getContrast());
            fragmentImageConvertBinding.scaleSwitch.setChecked(imageGraph.getStyle().getEqualRatioScale());
            fragmentImageConvertBinding.seekBar.setProgress(this.data.getContrast());
        }
        fragmentImageConvertBinding.scaleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.ask.printersdk.ui.ImageConvertFragment$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ImageConvertFragment.initView$lambda$2(this.f$0, compoundButton, z);
            }
        });
        fragmentImageConvertBinding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.ask.printersdk.ui.ImageConvertFragment.initView.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                DrawingSurfaceView drawingSurfaceView2;
                GraphManger graphManger2;
                Intrinsics.checkNotNullParameter(seekBar, "seekBar");
                if (fromUser) {
                    ImageConvertFragment.this.getData().setContrast(progress);
                    PrintEditViewModel viewModel = ImageConvertFragment.this.getViewModel();
                    if (viewModel == null || (drawingSurfaceView2 = viewModel.drawingSurfaceView) == null || (graphManger2 = drawingSurfaceView2.getGraphManger()) == null) {
                        return;
                    }
                    graphManger2.updateImageContrast(ImageConvertFragment.this.getData().getContrast());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                DrawingSurfaceView drawingSurfaceView2;
                GraphManger graphManger2;
                PrintEditViewModel viewModel = ImageConvertFragment.this.getViewModel();
                if (viewModel == null || (drawingSurfaceView2 = viewModel.drawingSurfaceView) == null || (graphManger2 = drawingSurfaceView2.getGraphManger()) == null) {
                    return;
                }
                graphManger2.saveBackwardGraphState();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(ImageConvertFragment imageConvertFragment, CompoundButton compoundButton, boolean z) {
        GraphManger graphManger;
        PrintEditViewModel printEditViewModel = imageConvertFragment.viewModel;
        if (printEditViewModel == null || (graphManger = printEditViewModel.getGraphManger()) == null) {
            return;
        }
        graphManger.setEqualScale(z);
    }

    /* JADX INFO: compiled from: ImageConvertFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ask/printersdk/ui/ImageConvertFragment$Data;", "Landroidx/databinding/BaseObservable;", "<init>", "(Lcom/ask/printersdk/ui/ImageConvertFragment;)V", "contrast", "", "getContrast", "()I", "setContrast", "(I)V", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class Data extends BaseObservable {
        private int contrast = 50;

        public Data() {
        }

        public final int getContrast() {
            return this.contrast;
        }

        public final void setContrast(int i) {
            this.contrast = i;
        }
    }
}
