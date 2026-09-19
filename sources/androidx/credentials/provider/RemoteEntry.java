package androidx.credentials.provider;

import android.app.PendingIntent;
import android.app.slice.Slice;
import android.app.slice.SliceItem;
import android.app.slice.SliceSpec;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RemoteEntry.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0003\u0012\u0013\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0006\u001a\u00020\u00078\u0007@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Landroidx/credentials/provider/RemoteEntry;", "", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "<init>", "(Landroid/app/PendingIntent;)V", "isAutoSelect", "", "(Landroid/app/PendingIntent;Z)V", "getPendingIntent", "()Landroid/app/PendingIntent;", "()Z", "setAutoSelect", "(Z)V", "equals", "other", "hashCode", "", "Builder", "Api34Impl", "Companion", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RemoteEntry {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_REMOTE_ENTRY_PENDING_INTENT = "androidx.credentials.provider.extra.REMOTE_ENTRY_PENDING_INTENT";
    private static final int REVISION_ID = 1;
    private static final String SLICE_HINT_IS_AUTO_SELECT = "androidx.credentials.provider.remoteEntry.SLICE_HINT_IS_AUTO_SELECT";
    private static final String SLICE_HINT_PENDING_INTENT = "androidx.credentials.provider.remoteEntry.SLICE_HINT_PENDING_INTENT";
    private static final String SLICE_SPEC_TYPE = "RemoteEntry";
    private static final String TAG = "RemoteEntry";
    private boolean isAutoSelect;
    private final PendingIntent pendingIntent;

    @JvmStatic
    public static final RemoteEntry fromRemoteEntry(android.service.credentials.RemoteEntry remoteEntry) {
        return INSTANCE.fromRemoteEntry(remoteEntry);
    }

    @JvmStatic
    public static final RemoteEntry fromSlice(Slice slice) {
        return INSTANCE.fromSlice(slice);
    }

    @JvmStatic
    public static final Slice toSlice(RemoteEntry remoteEntry) {
        return INSTANCE.toSlice(remoteEntry);
    }

    public RemoteEntry(PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
        this.pendingIntent = pendingIntent;
    }

    public final PendingIntent getPendingIntent() {
        return this.pendingIntent;
    }

    /* JADX INFO: renamed from: isAutoSelect, reason: from getter */
    public final boolean getIsAutoSelect() {
        return this.isAutoSelect;
    }

    public final void setAutoSelect(boolean z) {
        this.isAutoSelect = z;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RemoteEntry(PendingIntent pendingIntent, boolean z) {
        this(pendingIntent);
        Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
        this.isAutoSelect = z;
    }

    /* JADX INFO: compiled from: RemoteEntry.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/credentials/provider/RemoteEntry$Builder;", "", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "<init>", "(Landroid/app/PendingIntent;)V", InAppPurchaseConstants.METHOD_BUILD, "Landroidx/credentials/provider/RemoteEntry;", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder {
        private final PendingIntent pendingIntent;

        public Builder(PendingIntent pendingIntent) {
            Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
            this.pendingIntent = pendingIntent;
        }

        public final RemoteEntry build() {
            return new RemoteEntry(this.pendingIntent);
        }
    }

    /* JADX INFO: compiled from: RemoteEntry.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Landroidx/credentials/provider/RemoteEntry$Api34Impl;", "", "<init>", "()V", "fromRemoteEntry", "Landroidx/credentials/provider/RemoteEntry;", "remoteEntry", "Landroid/service/credentials/RemoteEntry;", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Api34Impl {
        public static final Api34Impl INSTANCE = new Api34Impl();

        private Api34Impl() {
        }

        @JvmStatic
        public static final RemoteEntry fromRemoteEntry(android.service.credentials.RemoteEntry remoteEntry) {
            Intrinsics.checkNotNullParameter(remoteEntry, "remoteEntry");
            Slice slice = remoteEntry.getSlice();
            Intrinsics.checkNotNullExpressionValue(slice, "getSlice(...)");
            return RemoteEntry.INSTANCE.fromSlice(slice);
        }
    }

    /* JADX INFO: compiled from: RemoteEntry.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\fH\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u0012H\u0007J\u0019\u0010\u0014\u001a\u00020\u0015*\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\u0018J\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u000e*\u00020\u0017H\u0000¢\u0006\u0002\b\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/credentials/provider/RemoteEntry$Companion;", "", "<init>", "()V", "TAG", "", "SLICE_HINT_PENDING_INTENT", "SLICE_HINT_IS_AUTO_SELECT", "SLICE_SPEC_TYPE", "REVISION_ID", "", "toSlice", "Landroid/app/slice/Slice;", "remoteEntry", "Landroidx/credentials/provider/RemoteEntry;", "fromSlice", "slice", "fromRemoteEntry", "Landroid/service/credentials/RemoteEntry;", "EXTRA_REMOTE_ENTRY_PENDING_INTENT", "marshall", "", "bundle", "Landroid/os/Bundle;", "marshall$credentials", "unmarshallRemoteEntry", "unmarshallRemoteEntry$credentials", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Slice toSlice(RemoteEntry remoteEntry) {
            Intrinsics.checkNotNullParameter(remoteEntry, "remoteEntry");
            PendingIntent pendingIntent = remoteEntry.getPendingIntent();
            Slice.Builder builder = new Slice.Builder(Uri.EMPTY, new SliceSpec("RemoteEntry", 1));
            builder.addAction(pendingIntent, new Slice.Builder(builder).addHints(Collections.singletonList(RemoteEntry.SLICE_HINT_PENDING_INTENT)).build(), null);
            if (remoteEntry.getIsAutoSelect()) {
                builder.addInt(1, null, CollectionsKt.listOf(RemoteEntry.SLICE_HINT_IS_AUTO_SELECT));
            }
            Slice sliceBuild = builder.build();
            Intrinsics.checkNotNullExpressionValue(sliceBuild, "build(...)");
            return sliceBuild;
        }

        @JvmStatic
        public final RemoteEntry fromSlice(Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "slice");
            List<SliceItem> items = slice.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "getItems(...)");
            boolean z = false;
            PendingIntent action = null;
            for (SliceItem sliceItem : items) {
                if (sliceItem.hasHint(RemoteEntry.SLICE_HINT_PENDING_INTENT)) {
                    action = sliceItem.getAction();
                } else if (sliceItem.hasHint(RemoteEntry.SLICE_HINT_IS_AUTO_SELECT)) {
                    z = true;
                }
            }
            try {
                Intrinsics.checkNotNull(action);
                return new RemoteEntry(action, z);
            } catch (Exception e) {
                Log.i("RemoteEntry", "fromSlice failed with: " + e.getMessage());
                return null;
            }
        }

        @JvmStatic
        public final RemoteEntry fromRemoteEntry(android.service.credentials.RemoteEntry remoteEntry) {
            Intrinsics.checkNotNullParameter(remoteEntry, "remoteEntry");
            if (Build.VERSION.SDK_INT >= 34) {
                return Api34Impl.fromRemoteEntry(remoteEntry);
            }
            return null;
        }

        public final void marshall$credentials(RemoteEntry remoteEntry, Bundle bundle) {
            Intrinsics.checkNotNullParameter(remoteEntry, "<this>");
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.putParcelable(RemoteEntry.EXTRA_REMOTE_ENTRY_PENDING_INTENT, remoteEntry.getPendingIntent());
        }

        public final RemoteEntry unmarshallRemoteEntry$credentials(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "<this>");
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable(RemoteEntry.EXTRA_REMOTE_ENTRY_PENDING_INTENT);
            if (pendingIntent == null) {
                return null;
            }
            return new RemoteEntry(pendingIntent);
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof RemoteEntry) {
            return Intrinsics.areEqual(this.pendingIntent, ((RemoteEntry) other).pendingIntent);
        }
        return false;
    }

    public int hashCode() {
        return this.pendingIntent.hashCode();
    }
}
