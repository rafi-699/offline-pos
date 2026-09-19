package com.github.gzuliyujiang.dialog;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class DialogColor implements Serializable {
    private int contentBackgroundColor = -1;
    private int topLineColor = -2236963;
    private int titleTextColor = -10066330;
    private int cancelTextColor = -13421773;
    private int okTextColor = -13421773;
    private int cancelEllipseColor = -723724;
    private int okEllipseColor = -16743937;

    public DialogColor contentBackgroundColor(int color) {
        this.contentBackgroundColor = color;
        return this;
    }

    public int contentBackgroundColor() {
        return this.contentBackgroundColor;
    }

    public DialogColor topLineColor(int color) {
        this.topLineColor = color;
        return this;
    }

    public int topLineColor() {
        return this.topLineColor;
    }

    public DialogColor titleTextColor(int color) {
        this.titleTextColor = color;
        return this;
    }

    public int titleTextColor() {
        return this.titleTextColor;
    }

    public DialogColor cancelTextColor(int color) {
        this.cancelTextColor = color;
        return this;
    }

    public int cancelTextColor() {
        return this.cancelTextColor;
    }

    public DialogColor okTextColor(int color) {
        this.okTextColor = color;
        return this;
    }

    public int okTextColor() {
        return this.okTextColor;
    }

    public DialogColor cancelEllipseColor(int color) {
        this.cancelEllipseColor = color;
        return this;
    }

    public int cancelEllipseColor() {
        return this.cancelEllipseColor;
    }

    public DialogColor okEllipseColor(int color) {
        this.okEllipseColor = color;
        return this;
    }

    public int okEllipseColor() {
        return this.okEllipseColor;
    }
}
