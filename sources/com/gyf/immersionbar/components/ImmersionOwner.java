package com.gyf.immersionbar.components;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public interface ImmersionOwner {
    boolean immersionBarEnabled();

    void initImmersionBar();

    void onInvisible();

    void onLazyAfterView();

    void onLazyBeforeView();

    void onVisible();
}
