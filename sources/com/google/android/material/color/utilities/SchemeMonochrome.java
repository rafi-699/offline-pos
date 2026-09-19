package com.google.android.material.color.utilities;

import com.brentvatne.exoplayer.ReactExoplayerView;

/* JADX INFO: loaded from: classes4.dex */
public class SchemeMonochrome extends DynamicScheme {
    public SchemeMonochrome(Hct hct, boolean z, double d) {
        super(hct, Variant.MONOCHROME, z, d, TonalPalette.fromHueAndChroma(hct.getHue(), ReactExoplayerView.DEFAULT_MIN_BUFFER_MEMORY_RESERVE), TonalPalette.fromHueAndChroma(hct.getHue(), ReactExoplayerView.DEFAULT_MIN_BUFFER_MEMORY_RESERVE), TonalPalette.fromHueAndChroma(hct.getHue(), ReactExoplayerView.DEFAULT_MIN_BUFFER_MEMORY_RESERVE), TonalPalette.fromHueAndChroma(hct.getHue(), ReactExoplayerView.DEFAULT_MIN_BUFFER_MEMORY_RESERVE), TonalPalette.fromHueAndChroma(hct.getHue(), ReactExoplayerView.DEFAULT_MIN_BUFFER_MEMORY_RESERVE));
    }
}
