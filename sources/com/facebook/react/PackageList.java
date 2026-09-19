package com.facebook.react;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import com.BV.LinearGradient.LinearGradientPackage;
import com.RNAppleAuthentication.AppleAuthenticationAndroidPackage;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilPackage;
import com.bleplx.BlePlxPackage;
import com.brentvatne.react.ReactVideoPackage;
import com.facebook.react.shell.MainPackageConfig;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.reactnative.androidsdk.FBSDKPackage;
import com.horcrux.svg.SvgPackage;
import com.imagepicker.ImagePickerPackage;
import com.johnsonsu.rnsoundplayer.RNSoundPlayerPackage;
import com.learnium.RNDeviceInfo.RNDeviceInfo;
import com.margelo.nitro.NitroModulesPackage;
import com.pdftoimage.PdfToImagePackage;
import com.reactnative.ivpusic.imagepicker.PickerPackage;
import com.reactnativecommunity.asyncstorage.AsyncStoragePackage;
import com.reactnativecommunity.cameraroll.CameraRollPackage;
import com.reactnativecommunity.clipboard.ClipboardPackage;
import com.reactnativecommunity.geolocation.GeolocationPackage;
import com.reactnativecommunity.picker.RNCPickerPackage;
import com.reactnativecommunity.slider.ReactSliderPackage;
import com.reactnativecommunity.webview.RNCWebViewPackage;
import com.reactnativedocumentpicker.RNDocumentPickerPackage;
import com.reactnativegooglesignin.RNGoogleSigninPackage;
import com.reactnativevectoricons.fontawesome.VectorIconsFontAwesomePackage;
import com.rnfs.RNFSPackage;
import com.shopify.reactnative.skia.RNSkiaPackage;
import com.swmansion.gesturehandler.RNGestureHandlerPackage;
import com.swmansion.reanimated.ReanimatedPackage;
import com.swmansion.rnscreens.RNScreensPackage;
import com.swmansion.worklets.WorkletsPackage;
import com.th3rdwave.safeareacontext.SafeAreaContextPackage;
import com.zoontek.rnlocalize.RNLocalizePackage;
import com.zoontek.rnpermissions.RNPermissionsPackage;
import fr.greweb.reactnativeviewshot.RNViewShotPackage;
import io.invertase.firebase.analytics.ReactNativeFirebaseAnalyticsPackage;
import io.invertase.firebase.app.ReactNativeFirebaseAppPackage;
import io.invertase.googlemobileads.ReactNativeGoogleMobileAdsPackage;
import java.util.ArrayList;
import java.util.Arrays;
import org.wonday.pdf.RNPDFPackage;

/* JADX INFO: loaded from: classes2.dex */
public class PackageList {
    private Application application;
    private MainPackageConfig mConfig;
    private ReactNativeHost reactNativeHost;

    public PackageList(ReactNativeHost reactNativeHost) {
        this(reactNativeHost, (MainPackageConfig) null);
    }

    public PackageList(Application application) {
        this(application, (MainPackageConfig) null);
    }

    public PackageList(ReactNativeHost reactNativeHost, MainPackageConfig mainPackageConfig) {
        this.reactNativeHost = reactNativeHost;
        this.mConfig = mainPackageConfig;
    }

    public PackageList(Application application, MainPackageConfig mainPackageConfig) {
        this.reactNativeHost = null;
        this.application = application;
        this.mConfig = mainPackageConfig;
    }

    private ReactNativeHost getReactNativeHost() {
        return this.reactNativeHost;
    }

    private Resources getResources() {
        return getApplication().getResources();
    }

    private Application getApplication() {
        ReactNativeHost reactNativeHost = this.reactNativeHost;
        return reactNativeHost == null ? this.application : reactNativeHost.getApplication();
    }

    private Context getApplicationContext() {
        return getApplication().getApplicationContext();
    }

    public ArrayList<ReactPackage> getPackages() {
        return new ArrayList<>(Arrays.asList(new MainReactPackage(this.mConfig), new AppleAuthenticationAndroidPackage(), new AsyncStoragePackage(), new CameraRollPackage(), new ClipboardPackage(), new GeolocationPackage(), new ReactSliderPackage(), new RNDocumentPickerPackage(), new ReactNativeFirebaseAnalyticsPackage(), new ReactNativeFirebaseAppPackage(), new RNGoogleSigninPackage(), new RNCPickerPackage(), new VectorIconsFontAwesomePackage(), new RNSkiaPackage(), new BlePlxPackage(), new ReactNativeBlobUtilPackage(), new RNDeviceInfo(), new FBSDKPackage(), new RNFSPackage(), new RNGestureHandlerPackage(), new ReactNativeGoogleMobileAdsPackage(), new PickerPackage(), new ImagePickerPackage(), new LinearGradientPackage(), new RNLocalizePackage(), new NitroModulesPackage(), new RNPDFPackage(), new PdfToImagePackage(), new RNPermissionsPackage(), new ReanimatedPackage(), new SafeAreaContextPackage(), new RNScreensPackage(), new RNSoundPlayerPackage(), new SvgPackage(), new ReactVideoPackage(), new RNViewShotPackage(), new RNCWebViewPackage(), new WorkletsPackage()));
    }
}
