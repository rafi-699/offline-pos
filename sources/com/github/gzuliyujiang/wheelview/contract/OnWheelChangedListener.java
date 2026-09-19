package com.github.gzuliyujiang.wheelview.contract;

import com.github.gzuliyujiang.wheelview.widget.WheelView;

/* JADX INFO: loaded from: classes3.dex */
public interface OnWheelChangedListener {
    void onWheelLoopFinished(WheelView view);

    void onWheelScrollStateChanged(WheelView view, int state);

    void onWheelScrolled(WheelView view, int offset);

    void onWheelSelected(WheelView view, int position);
}
