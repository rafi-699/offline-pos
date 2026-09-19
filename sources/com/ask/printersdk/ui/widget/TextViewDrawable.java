package com.ask.printersdk.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: classes2.dex */
public class TextViewDrawable extends AppCompatTextView {
    int lastLeftPadding;
    int lastTopPadding;

    public TextViewDrawable(Context context) {
        super(context);
        this.lastLeftPadding = 0;
        this.lastTopPadding = 0;
    }

    public TextViewDrawable(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lastLeftPadding = 0;
        this.lastTopPadding = 0;
    }

    public TextViewDrawable(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lastLeftPadding = 0;
        this.lastTopPadding = 0;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        char c;
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0) {
            Drawable drawable = compoundDrawables[0];
            if (drawable == null) {
                drawable = compoundDrawables[2];
                c = 2;
            } else {
                c = 0;
            }
            if (drawable == null) {
                c = 1;
                drawable = compoundDrawables[1];
            }
            if (drawable == null) {
                float fMeasureText = getPaint().measureText(getText().toString());
                int width = (int) (getWidth() - fMeasureText);
                if (width != this.lastLeftPadding) {
                    setPadding(0, 0, width, 0);
                    this.lastLeftPadding = width;
                }
                canvas.translate((getWidth() - fMeasureText) / 2.0f, 0.0f);
            } else if (c == 0 || c == 2) {
                float fMeasureText2 = getPaint().measureText(getText().toString()) + drawable.getIntrinsicWidth() + getCompoundDrawablePadding();
                int width2 = (int) (getWidth() - fMeasureText2);
                if (width2 != this.lastLeftPadding) {
                    setPadding(0, 0, width2, 0);
                    this.lastLeftPadding = width2;
                }
                float width3 = (getWidth() - fMeasureText2) / 2.0f;
                int gravity = getGravity() & 7;
                if (gravity == 3 || gravity == 8388611) {
                    canvas.translate(getPaddingLeft(), 0.0f);
                } else {
                    canvas.translate(width3, 0.0f);
                }
            } else {
                float lineHeight = (getLineHeight() * getLineCount()) + drawable.getIntrinsicHeight() + getCompoundDrawablePadding();
                int height = (int) (getHeight() - lineHeight);
                if (height != this.lastTopPadding) {
                    setPadding(0, 0, 0, height);
                    this.lastTopPadding = height;
                }
                canvas.translate(0.0f, (getHeight() - lineHeight) / 2.0f);
            }
            super.onDraw(canvas);
            return;
        }
        super.onDraw(canvas);
    }
}
