package com.imagepicker;

import android.media.MediaMetadataRetriever;
import java.io.IOException;

/* JADX INFO: compiled from: VideoMetadata.java */
/* JADX INFO: loaded from: classes4.dex */
class CustomMediaMetadataRetriever extends MediaMetadataRetriever implements AutoCloseable {
    @Override // android.media.MediaMetadataRetriever, java.lang.AutoCloseable
    public void close() throws IOException {
        release();
    }
}
