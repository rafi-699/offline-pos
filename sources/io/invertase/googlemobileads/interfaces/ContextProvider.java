package io.invertase.googlemobileads.interfaces;

import android.app.Activity;
import android.content.Context;
import com.facebook.react.bridge.ReactContext;

/* JADX INFO: loaded from: classes4.dex */
public interface ContextProvider {
    Activity getActivity();

    Context getApplicationContext();

    ReactContext getContext();
}
