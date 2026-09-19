package com.ask.printersdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ask.printersdk.R;

/* JADX INFO: loaded from: classes2.dex */
public final class CopyrightDialogBinding implements ViewBinding {
    public final TextView copyright;
    public final TextView link;
    public final Button okButton;
    private final LinearLayout rootView;
    public final TextView title;

    private CopyrightDialogBinding(LinearLayout linearLayout, TextView textView, TextView textView2, Button button, TextView textView3) {
        this.rootView = linearLayout;
        this.copyright = textView;
        this.link = textView2;
        this.okButton = button;
        this.title = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CopyrightDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CopyrightDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.copyright_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CopyrightDialogBinding bind(View view) {
        int i = R.id.copyright;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.link;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.ok_button;
                Button button = (Button) ViewBindings.findChildViewById(view, i);
                if (button != null) {
                    i = R.id.title;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        return new CopyrightDialogBinding((LinearLayout) view, textView, textView2, button, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
