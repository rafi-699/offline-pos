package cn.lailaixiong.funnyprint;

import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.PopupMenu;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import cn.lailaixiong.funnyprint.ReactNaitveModule.DolewaEventEmitter;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint;
import com.facebook.react.defaults.DefaultReactActivityDelegate;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.opencv.android.OpenCVLoader;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u000eH\u0014J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\u0012\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\tH\u0014J\u0012\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0014J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"H\u0002J\u0012\u0010$\u001a\u0004\u0018\u00010\t2\u0006\u0010%\u001a\u00020&H\u0002J\u001a\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010%\u001a\u00020&2\u0006\u0010(\u001a\u00020\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006)"}, d2 = {"Lcn/lailaixiong/funnyprint/MainActivity;", "Lcom/facebook/react/ReactActivity;", "<init>", "()V", "splashView", "Landroid/view/View;", "splashAttached", "", "appReadyAction", "", "appReadyReceiver", "cn/lailaixiong/funnyprint/MainActivity$appReadyReceiver$1", "Lcn/lailaixiong/funnyprint/MainActivity$appReadyReceiver$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "attachSplashOverlay", "removeSplashWithFade", "postSplashTimeoutFallback", "timeoutMs", "", "getMainComponentName", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "createReactActivityDelegate", "Lcom/facebook/react/ReactActivityDelegate;", "onNewIntent", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "handleSharedFile", "getFileName", "uri", "Landroid/net/Uri;", "copyFileToInternalStorage", "fileName", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MainActivity extends ReactActivity {
    private final String appReadyAction = "APP_READY";
    private final MainActivity$appReadyReceiver$1 appReadyReceiver = new BroadcastReceiver() { // from class: cn.lailaixiong.funnyprint.MainActivity$appReadyReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context ctx, Intent intent) {
            this.this$0.removeSplashWithFade();
        }
    };
    private volatile boolean splashAttached;
    private volatile View splashView;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onOptionsItemSelected$lambda$4$lambda$3(MenuItem menuItem) {
        return false;
    }

    @Override // com.facebook.react.ReactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(null);
        Intent intent = getIntent();
        if (intent != null && Intrinsics.areEqual(intent.getAction(), "android.intent.action.SEND") && intent.getType() != null) {
            handleSharedFile(intent);
        }
        LocalBroadcastManager.getInstance(this).registerReceiver(this.appReadyReceiver, new IntentFilter(this.appReadyAction));
        attachSplashOverlay();
        postSplashTimeoutFallback$default(this, 0L, 1, null);
        if (OpenCVLoader.initLocal()) {
            return;
        }
        Log.d("OpenCV", "OpenCV initLocal failed");
    }

    @Override // com.facebook.react.ReactActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.appReadyReceiver);
        super.onDestroy();
    }

    private final void attachSplashOverlay() {
        if (this.splashAttached) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
        View viewInflate = getLayoutInflater().inflate(R.layout.launch_screen, viewGroup, false);
        viewInflate.setAlpha(1.0f);
        viewGroup.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        this.splashView = viewInflate;
        this.splashAttached = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeSplashWithFade() {
        final View view = this.splashView;
        if (view == null) {
            return;
        }
        this.splashView = null;
        view.animate().alpha(0.0f).setDuration(250L).withEndAction(new Runnable() { // from class: cn.lailaixiong.funnyprint.MainActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.removeSplashWithFade$lambda$1(view, this);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeSplashWithFade$lambda$1(View view, MainActivity mainActivity) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        mainActivity.splashAttached = false;
    }

    static /* synthetic */ void postSplashTimeoutFallback$default(MainActivity mainActivity, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 3500;
        }
        mainActivity.postSplashTimeoutFallback(j);
    }

    private final void postSplashTimeoutFallback(long timeoutMs) {
        getWindow().getDecorView().postDelayed(new Runnable() { // from class: cn.lailaixiong.funnyprint.MainActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.postSplashTimeoutFallback$lambda$2(this.f$0);
            }
        }, timeoutMs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postSplashTimeoutFallback$lambda$2(MainActivity mainActivity) {
        if (mainActivity.splashAttached) {
            mainActivity.removeSplashWithFade();
        }
    }

    @Override // com.facebook.react.ReactActivity
    protected String getMainComponentName() {
        return "FunnyPrint";
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        PopupMenu popupMenu = new PopupMenu(this, findViewById(item.getItemId()));
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        MenuItem menuItemFindItem = popupMenu.getMenu().findItem(R.id.privacy_settings);
        if (menuItemFindItem != null) {
            menuItemFindItem.setVisible(false);
        }
        MenuItem menuItemFindItem2 = popupMenu.getMenu().findItem(R.id.ad_inspector);
        if (menuItemFindItem2 != null) {
            menuItemFindItem2.setVisible(false);
        }
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: cn.lailaixiong.funnyprint.MainActivity$$ExternalSyntheticLambda1
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return MainActivity.onOptionsItemSelected$lambda$4$lambda$3(menuItem);
            }
        });
        return super.onOptionsItemSelected(item);
    }

    @Override // com.facebook.react.ReactActivity
    protected ReactActivityDelegate createReactActivityDelegate() {
        return new DefaultReactActivityDelegate(this, getMainComponentName(), DefaultNewArchitectureEntryPoint.getFabricEnabled());
    }

    @Override // com.facebook.react.ReactActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        handleSharedFile(intent);
    }

    private final void handleSharedFile(Intent intent) {
        Uri uri;
        ClipData.Item itemAt;
        if (!Intrinsics.areEqual(intent.getAction(), "android.intent.action.SEND") || intent.getType() == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM", Uri.class);
        } else {
            uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
        }
        if (uri == null) {
            ClipData clipData = intent.getClipData();
            uri = null;
            if (clipData != null) {
                if (clipData.getItemCount() <= 0) {
                    clipData = null;
                }
                if (clipData != null && (itemAt = clipData.getItemAt(0)) != null) {
                    uri = itemAt.getUri();
                }
            }
        }
        if (uri == null) {
            Log.w("MainActivity", "No shared Uri found in EXTRA_STREAM or ClipData");
            return;
        }
        String fileName = getFileName(uri);
        if (fileName == null) {
            fileName = "sharedFile";
        }
        Uri uriCopyFileToInternalStorage = copyFileToInternalStorage(uri, fileName);
        if (uriCopyFileToInternalStorage != null) {
            DolewaEventEmitter.Companion companion = DolewaEventEmitter.INSTANCE;
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            companion.emitEvent(applicationContext, "FileOpened", MapsKt.mapOf(TuplesKt.to("url", uriCopyFileToInternalStorage.toString())));
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0034  */
    private final String getFileName(Uri uri) {
        Uri uri2;
        String string;
        if (Intrinsics.areEqual(uri.getScheme(), "content")) {
            uri2 = uri;
            Cursor cursorQuery = getContentResolver().query(uri2, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                    } else {
                        string = null;
                    }
                } catch (Throwable th) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            } else {
                string = null;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } else {
            uri2 = uri;
            string = null;
        }
        if (string != null) {
            return string;
        }
        String path = uri2.getPath();
        Integer numValueOf = path != null ? Integer.valueOf(StringsKt.lastIndexOf$default((CharSequence) path, '/', 0, false, 6, (Object) null)) : null;
        if (numValueOf == null || numValueOf.intValue() == -1) {
            return path;
        }
        if (path == null) {
            return null;
        }
        String strSubstring = path.substring(numValueOf.intValue() + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    private final Uri copyFileToInternalStorage(Uri uri, String fileName) {
        try {
            InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
            File file = new File(getFilesDir(), "docs");
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(file, fileName);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            if (inputStreamOpenInputStream != null) {
                ByteStreamsKt.copyTo$default(inputStreamOpenInputStream, fileOutputStream, 0, 2, null);
            }
            if (inputStreamOpenInputStream != null) {
                inputStreamOpenInputStream.close();
            }
            fileOutputStream.close();
            return Uri.fromFile(file2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
