package com.ask.printersdk.base.dialog;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.ask.printersdk.R;
import com.ask.printersdk.utils.PUtil;
import com.gyf.immersionbar.ImmersionBar;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CenterDialogFragment extends BaseDialogFragment {
    protected View rootView;
    FrameLayout wrapperLayout;
    int paddingTop = -1;
    int viewHeight = 0;

    @Override // com.ask.printersdk.base.dialog.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        initWindow();
        this.wrapperLayout.setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.base.dialog.CenterDialogFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CenterDialogFragment.this.canceledOnTouchOutside) {
                    CenterDialogFragment.this.dismissAllowingStateLoss();
                }
            }
        });
    }

    @Override // com.ask.printersdk.base.dialog.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.wrapperLayout = frameLayout;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        int horizontalMargin = getHorizontalMargin();
        layoutParams.setMargins(horizontalMargin, 0, horizontalMargin, 0);
        viewOnCreateView.setLayoutParams(layoutParams);
        this.wrapperLayout.addView(viewOnCreateView);
        viewOnCreateView.setClickable(true);
        this.rootView = viewOnCreateView;
        return this.wrapperLayout;
    }

    protected int getHorizontalMargin() {
        if (PUtil.isScreenOrientationPortrait(getContext())) {
            return PUtil.dip2px(getContext(), 30.0f);
        }
        return PUtil.dip2px(getContext(), 220.0f);
    }

    public void setFullScreen(Boolean bool) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.rootView.getLayoutParams();
        if (bool.booleanValue()) {
            this.viewHeight = layoutParams.height;
            layoutParams.height = -1;
            this.paddingTop = this.rootView.getPaddingTop();
            View view = this.rootView;
            view.setPadding(view.getPaddingLeft(), this.paddingTop + PUtil.dip2px(getContext(), 20.0f), this.rootView.getPaddingLeft(), this.rootView.getPaddingBottom());
        } else {
            layoutParams.height = this.viewHeight;
            if (this.paddingTop != -1) {
                View view2 = this.rootView;
                view2.setPadding(view2.getPaddingLeft(), this.paddingTop, this.rootView.getPaddingLeft(), this.rootView.getPaddingBottom());
            }
        }
        this.rootView.setLayoutParams(layoutParams);
    }

    protected void initWindow() {
        this.mWindow.setGravity(17);
        this.mWindow.setWindowAnimations(R.style.FadeAnimation);
        this.mWindow.setLayout(-1, -1);
        this.mWindow.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.transparent));
    }

    @Override // com.ask.printersdk.base.dialog.BaseDialogFragment
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with((DialogFragment) this).navigationBarColor(R.color.transparent).init();
    }

    @Override // com.ask.printersdk.base.dialog.BaseDialogFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mWindow.setLayout(-1, -1);
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag(str);
        if (fragmentFindFragmentByTag != null) {
            fragmentManager.beginTransaction().remove(fragmentFindFragmentByTag).commitAllowingStateLoss();
        }
        try {
            super.show(fragmentManager, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
