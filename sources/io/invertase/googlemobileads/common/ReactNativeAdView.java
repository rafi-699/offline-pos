package io.invertase.googlemobileads.common;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ReactNativeAdView extends FrameLayout {
    private float adWidth;
    private boolean isFluid;
    private boolean manualImpressionsEnabled;
    private float maxAdHeight;
    private final Runnable measureAndLayout;
    private boolean propsChanged;
    private AdRequest request;
    private List<AdSize> sizes;
    private String unitId;

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        post(this.measureAndLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        int iMakeMeasureSpec;
        if (this.isFluid) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824);
        }
        measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), iMakeMeasureSpec);
        layout(getLeft(), getTop(), getRight(), getTop() + getHeight());
    }

    public ReactNativeAdView(Context context) {
        super(context);
        this.measureAndLayout = new Runnable() { // from class: io.invertase.googlemobileads.common.ReactNativeAdView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0();
            }
        };
        setSaveFromParentEnabled(false);
    }

    public void setRequest(AdRequest adRequest) {
        this.request = adRequest;
    }

    public AdRequest getRequest() {
        return this.request;
    }

    public void setSizes(List<AdSize> list) {
        this.sizes = list;
    }

    public List<AdSize> getSizes() {
        return this.sizes;
    }

    public void setMaxAdHeight(float f) {
        this.maxAdHeight = f;
    }

    public float getMaxAdHeight() {
        return this.maxAdHeight;
    }

    public void setAdWidth(float f) {
        this.adWidth = f;
    }

    public float getAdWidth() {
        return this.adWidth;
    }

    public void setUnitId(String str) {
        this.unitId = str;
    }

    public String getUnitId() {
        return this.unitId;
    }

    public void setManualImpressionsEnabled(boolean z) {
        this.manualImpressionsEnabled = z;
    }

    public boolean getManualImpressionsEnabled() {
        return this.manualImpressionsEnabled;
    }

    public void setPropsChanged(boolean z) {
        this.propsChanged = z;
    }

    public boolean getPropsChanged() {
        return this.propsChanged;
    }

    public void setIsFluid(boolean z) {
        this.isFluid = z;
    }

    public boolean getIsFluid() {
        return this.isFluid;
    }
}
