package com.github.gzuliyujiang.wheelpicker.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.github.gzuliyujiang.wheelpicker.R;
import com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider;
import com.github.gzuliyujiang.wheelpicker.contract.OnLinkageSelectedListener;
import com.github.gzuliyujiang.wheelview.contract.WheelFormatter;
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class LinkageWheelLayout extends BaseWheelLayout {
    private LinkageProvider dataProvider;
    private int firstIndex;
    private TextView firstLabelView;
    private Object firstValue;
    private WheelView firstWheelView;
    private ProgressBar loadingView;
    private OnLinkageSelectedListener onLinkageSelectedListener;
    private int secondIndex;
    private TextView secondLabelView;
    private Object secondValue;
    private WheelView secondWheelView;
    private int thirdIndex;
    private TextView thirdLabelView;
    private Object thirdValue;
    private WheelView thirdWheelView;

    public LinkageWheelLayout(Context context) {
        super(context);
    }

    public LinkageWheelLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LinkageWheelLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LinkageWheelLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected int provideLayoutRes() {
        return R.layout.wheel_picker_linkage;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected List<WheelView> provideWheelViews() {
        return Arrays.asList(this.firstWheelView, this.secondWheelView, this.thirdWheelView);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void onInit(Context context) {
        this.firstWheelView = (WheelView) findViewById(R.id.wheel_picker_linkage_first_wheel);
        this.secondWheelView = (WheelView) findViewById(R.id.wheel_picker_linkage_second_wheel);
        this.thirdWheelView = (WheelView) findViewById(R.id.wheel_picker_linkage_third_wheel);
        this.firstLabelView = (TextView) findViewById(R.id.wheel_picker_linkage_first_label);
        this.secondLabelView = (TextView) findViewById(R.id.wheel_picker_linkage_second_label);
        this.thirdLabelView = (TextView) findViewById(R.id.wheel_picker_linkage_third_label);
        this.loadingView = (ProgressBar) findViewById(R.id.wheel_picker_linkage_loading);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void onAttributeSet(Context context, AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.LinkageWheelLayout);
        setFirstVisible(typedArrayObtainStyledAttributes.getBoolean(R.styleable.LinkageWheelLayout_wheel_firstVisible, true));
        setThirdVisible(typedArrayObtainStyledAttributes.getBoolean(R.styleable.LinkageWheelLayout_wheel_thirdVisible, true));
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.LinkageWheelLayout_wheel_firstLabel);
        String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.LinkageWheelLayout_wheel_secondLabel);
        String string3 = typedArrayObtainStyledAttributes.getString(R.styleable.LinkageWheelLayout_wheel_thirdLabel);
        typedArrayObtainStyledAttributes.recycle();
        setLabel(string, string2, string3);
    }

    @Override // com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener
    public void onWheelSelected(WheelView view, int position) {
        int id = view.getId();
        if (id == R.id.wheel_picker_linkage_first_wheel) {
            this.firstIndex = position;
            this.secondIndex = 0;
            this.thirdIndex = 0;
            changeSecondData();
            changeThirdData();
            selectedCallback();
            return;
        }
        if (id == R.id.wheel_picker_linkage_second_wheel) {
            this.secondIndex = position;
            this.thirdIndex = 0;
            changeThirdData();
            selectedCallback();
            return;
        }
        if (id == R.id.wheel_picker_linkage_third_wheel) {
            this.thirdIndex = position;
            selectedCallback();
        }
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout, com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener
    public void onWheelScrollStateChanged(WheelView view, int state) {
        int id = view.getId();
        if (id == R.id.wheel_picker_linkage_first_wheel) {
            this.secondWheelView.setEnabled(state == 0);
            this.thirdWheelView.setEnabled(state == 0);
        } else if (id == R.id.wheel_picker_linkage_second_wheel) {
            this.firstWheelView.setEnabled(state == 0);
            this.thirdWheelView.setEnabled(state == 0);
        } else if (id == R.id.wheel_picker_linkage_third_wheel) {
            this.firstWheelView.setEnabled(state == 0);
            this.secondWheelView.setEnabled(state == 0);
        }
    }

    public void setData(LinkageProvider provider) {
        setFirstVisible(provider.firstLevelVisible());
        setThirdVisible(provider.thirdLevelVisible());
        Object obj = this.firstValue;
        if (obj != null) {
            this.firstIndex = provider.findFirstIndex(obj);
        }
        Object obj2 = this.secondValue;
        if (obj2 != null) {
            this.secondIndex = provider.findSecondIndex(this.firstIndex, obj2);
        }
        Object obj3 = this.thirdValue;
        if (obj3 != null) {
            this.thirdIndex = provider.findThirdIndex(this.firstIndex, this.secondIndex, obj3);
        }
        this.dataProvider = provider;
        changeFirstData();
        changeSecondData();
        changeThirdData();
    }

    public void setDefaultValue(Object first, Object second, Object third) {
        LinkageProvider linkageProvider = this.dataProvider;
        if (linkageProvider != null) {
            int iFindFirstIndex = linkageProvider.findFirstIndex(first);
            this.firstIndex = iFindFirstIndex;
            int iFindSecondIndex = this.dataProvider.findSecondIndex(iFindFirstIndex, second);
            this.secondIndex = iFindSecondIndex;
            this.thirdIndex = this.dataProvider.findThirdIndex(this.firstIndex, iFindSecondIndex, third);
            changeFirstData();
            changeSecondData();
            changeThirdData();
            return;
        }
        this.firstValue = first;
        this.secondValue = second;
        this.thirdValue = third;
    }

    public void setFormatter(WheelFormatter first, WheelFormatter second, WheelFormatter third) {
        this.firstWheelView.setFormatter(first);
        this.secondWheelView.setFormatter(second);
        this.thirdWheelView.setFormatter(third);
    }

    public void setLabel(CharSequence first, CharSequence second, CharSequence third) {
        this.firstLabelView.setText(first);
        this.secondLabelView.setText(second);
        this.thirdLabelView.setText(third);
    }

    public void showLoading() {
        this.loadingView.setVisibility(0);
    }

    public void hideLoading() {
        this.loadingView.setVisibility(8);
    }

    public void setOnLinkageSelectedListener(OnLinkageSelectedListener onLinkageSelectedListener) {
        this.onLinkageSelectedListener = onLinkageSelectedListener;
    }

    public void setFirstVisible(boolean visible) {
        if (visible) {
            this.firstWheelView.setVisibility(0);
            this.firstLabelView.setVisibility(0);
        } else {
            this.firstWheelView.setVisibility(8);
            this.firstLabelView.setVisibility(8);
        }
    }

    public void setThirdVisible(boolean visible) {
        if (visible) {
            this.thirdWheelView.setVisibility(0);
            this.thirdLabelView.setVisibility(0);
        } else {
            this.thirdWheelView.setVisibility(8);
            this.thirdLabelView.setVisibility(8);
        }
    }

    private void selectedCallback() {
        if (this.onLinkageSelectedListener == null) {
            return;
        }
        this.thirdWheelView.post(new Runnable() { // from class: com.github.gzuliyujiang.wheelpicker.widget.LinkageWheelLayout.1
            @Override // java.lang.Runnable
            public void run() {
                LinkageWheelLayout.this.onLinkageSelectedListener.onLinkageSelected(LinkageWheelLayout.this.firstWheelView.getCurrentItem(), LinkageWheelLayout.this.secondWheelView.getCurrentItem(), LinkageWheelLayout.this.thirdWheelView.getCurrentItem());
            }
        });
    }

    private void changeFirstData() {
        this.firstWheelView.setData(this.dataProvider.provideFirstData());
        this.firstWheelView.setDefaultPosition(this.firstIndex);
    }

    private void changeSecondData() {
        this.secondWheelView.setData(this.dataProvider.linkageSecondData(this.firstIndex));
        this.secondWheelView.setDefaultPosition(this.secondIndex);
    }

    private void changeThirdData() {
        if (this.dataProvider.thirdLevelVisible()) {
            this.thirdWheelView.setData(this.dataProvider.linkageThirdData(this.firstIndex, this.secondIndex));
            this.thirdWheelView.setDefaultPosition(this.thirdIndex);
        }
    }

    public final WheelView getFirstWheelView() {
        return this.firstWheelView;
    }

    public final WheelView getSecondWheelView() {
        return this.secondWheelView;
    }

    public final WheelView getThirdWheelView() {
        return this.thirdWheelView;
    }

    public final TextView getFirstLabelView() {
        return this.firstLabelView;
    }

    public final TextView getSecondLabelView() {
        return this.secondLabelView;
    }

    public final TextView getThirdLabelView() {
        return this.thirdLabelView;
    }

    public final ProgressBar getLoadingView() {
        return this.loadingView;
    }
}
