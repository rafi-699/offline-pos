package com.github.gzuliyujiang.dialog;

/* JADX INFO: loaded from: classes3.dex */
public final class DialogConfig {
    private static DialogColor dialogColor = new DialogColor();
    private static int dialogStyle;

    private DialogConfig() {
    }

    public static void setDialogStyle(int style) {
        dialogStyle = style;
    }

    public static int getDialogStyle() {
        return dialogStyle;
    }

    public static void setDialogColor(DialogColor color) {
        dialogColor = color;
    }

    public static DialogColor getDialogColor() {
        if (dialogColor == null) {
            dialogColor = new DialogColor();
        }
        return dialogColor;
    }
}
