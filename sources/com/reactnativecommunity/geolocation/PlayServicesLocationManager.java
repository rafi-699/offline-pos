package com.reactnativecommunity.geolocation;

import android.app.Activity;
import android.location.Location;
import android.location.LocationManager;
import android.os.Looper;
import android.util.Log;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.SystemClock;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: loaded from: classes4.dex */
public class PlayServicesLocationManager extends BaseLocationManager {
    private FusedLocationProviderClient mFusedLocationClient;
    private LocationCallback mLocationCallback;
    private SettingsClient mLocationServicesSettingsClient;
    private LocationCallback mSingleLocationCallback;

    protected PlayServicesLocationManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mFusedLocationClient = LocationServices.getFusedLocationProviderClient(reactApplicationContext);
        this.mLocationServicesSettingsClient = LocationServices.getSettingsClient(reactApplicationContext);
    }

    @Override // com.reactnativecommunity.geolocation.BaseLocationManager
    public void getCurrentLocationData(final ReadableMap readableMap, final Callback callback, final Callback callback2) {
        final BaseLocationManager.LocationOptions locationOptionsFromReactMap = BaseLocationManager.LocationOptions.fromReactMap(readableMap);
        Activity currentActivity = this.mReactContext.getCurrentActivity();
        if (currentActivity == null) {
            LocationCallback locationCallbackCreateSingleLocationCallback = createSingleLocationCallback(callback, callback2);
            this.mSingleLocationCallback = locationCallbackCreateSingleLocationCallback;
            checkLocationSettings(readableMap, locationCallbackCreateSingleLocationCallback, callback2);
            return;
        }
        this.mFusedLocationClient.getLastLocation().addOnSuccessListener(currentActivity, new OnSuccessListener() { // from class: com.reactnativecommunity.geolocation.PlayServicesLocationManager$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                this.f$0.lambda$getCurrentLocationData$0(locationOptionsFromReactMap, callback, callback2, readableMap, (Location) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getCurrentLocationData$0(BaseLocationManager.LocationOptions locationOptions, Callback callback, Callback callback2, ReadableMap readableMap, Location location) {
        if (location != null && SystemClock.currentTimeMillis() - location.getTime() < locationOptions.maximumAge) {
            callback.invoke(locationToMap(location));
            return;
        }
        LocationCallback locationCallbackCreateSingleLocationCallback = createSingleLocationCallback(callback, callback2);
        this.mSingleLocationCallback = locationCallbackCreateSingleLocationCallback;
        checkLocationSettings(readableMap, locationCallbackCreateSingleLocationCallback, callback2);
    }

    @Override // com.reactnativecommunity.geolocation.BaseLocationManager
    public void startObserving(ReadableMap readableMap) {
        LocationCallback locationCallback = new LocationCallback() { // from class: com.reactnativecommunity.geolocation.PlayServicesLocationManager.1
            @Override // com.google.android.gms.location.LocationCallback
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult == null) {
                    PlayServicesLocationManager.this.emitError(PositionError.POSITION_UNAVAILABLE, "No location provided (FusedLocationProvider/observer).");
                } else {
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) PlayServicesLocationManager.this.mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("geolocationDidChange", BaseLocationManager.locationToMap(locationResult.getLastLocation()));
                }
            }

            @Override // com.google.android.gms.location.LocationCallback
            public void onLocationAvailability(LocationAvailability locationAvailability) {
                if (locationAvailability.isLocationAvailable()) {
                    return;
                }
                PlayServicesLocationManager.this.emitError(PositionError.POSITION_UNAVAILABLE, "Location not available (FusedLocationProvider).");
            }
        };
        this.mLocationCallback = locationCallback;
        checkLocationSettings(readableMap, locationCallback, null);
    }

    @Override // com.reactnativecommunity.geolocation.BaseLocationManager
    public void stopObserving() {
        LocationCallback locationCallback = this.mLocationCallback;
        if (locationCallback == null) {
            return;
        }
        this.mFusedLocationClient.removeLocationUpdates(locationCallback);
    }

    private void checkLocationSettings(ReadableMap readableMap, final LocationCallback locationCallback, final Callback callback) {
        BaseLocationManager.LocationOptions locationOptionsFromReactMap = BaseLocationManager.LocationOptions.fromReactMap(readableMap);
        LocationRequest.Builder builder = new LocationRequest.Builder(locationOptionsFromReactMap.interval);
        builder.setPriority(locationOptionsFromReactMap.highAccuracy ? 100 : 104);
        builder.setMaxUpdateAgeMillis((long) locationOptionsFromReactMap.maximumAge);
        if (locationOptionsFromReactMap.fastestInterval >= 0) {
            builder.setMinUpdateIntervalMillis(locationOptionsFromReactMap.fastestInterval);
        }
        if (locationOptionsFromReactMap.distanceFilter >= 0.0f) {
            builder.setMinUpdateDistanceMeters(locationOptionsFromReactMap.distanceFilter);
        }
        final LocationRequest locationRequestBuild = builder.build();
        LocationSettingsRequest.Builder builder2 = new LocationSettingsRequest.Builder();
        builder2.addLocationRequest(locationRequestBuild);
        this.mLocationServicesSettingsClient.checkLocationSettings(builder2.build()).addOnSuccessListener(new OnSuccessListener() { // from class: com.reactnativecommunity.geolocation.PlayServicesLocationManager$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                this.f$0.lambda$checkLocationSettings$1(locationRequestBuild, locationCallback, (LocationSettingsResponse) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.reactnativecommunity.geolocation.PlayServicesLocationManager$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                this.f$0.lambda$checkLocationSettings$2(locationRequestBuild, locationCallback, callback, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkLocationSettings$1(LocationRequest locationRequest, LocationCallback locationCallback, LocationSettingsResponse locationSettingsResponse) {
        requestLocationUpdates(locationRequest, locationCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkLocationSettings$2(LocationRequest locationRequest, LocationCallback locationCallback, Callback callback, Exception exc) {
        if (isAnyProviderAvailable()) {
            requestLocationUpdates(locationRequest, locationCallback);
        } else if (callback == null) {
            emitError(PositionError.POSITION_UNAVAILABLE, "Location not available (FusedLocationProvider/settings).");
        } else {
            callback.invoke(PositionError.buildError(PositionError.POSITION_UNAVAILABLE, "Location not available (FusedLocationProvider/settings)."));
        }
    }

    private void requestLocationUpdates(LocationRequest locationRequest, LocationCallback locationCallback) {
        this.mFusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper());
    }

    private boolean isAnyProviderAvailable() {
        LocationManager locationManager;
        return (this.mReactContext == null || (locationManager = (LocationManager) this.mReactContext.getSystemService(FirebaseAnalytics.Param.LOCATION)) == null || (!locationManager.isProviderEnabled("gps") && !locationManager.isProviderEnabled("network"))) ? false : true;
    }

    private LocationCallback createSingleLocationCallback(Callback callback, Callback callback2) {
        final CallbackHolder callbackHolder = new CallbackHolder(callback, callback2);
        return new LocationCallback() { // from class: com.reactnativecommunity.geolocation.PlayServicesLocationManager.2
            @Override // com.google.android.gms.location.LocationCallback
            public void onLocationResult(LocationResult locationResult) {
                Location lastLocation = locationResult.getLastLocation();
                if (lastLocation == null) {
                    callbackHolder.error(PositionError.buildError(PositionError.POSITION_UNAVAILABLE, "No location provided (FusedLocationProvider/lastLocation)."));
                    return;
                }
                callbackHolder.success(lastLocation);
                PlayServicesLocationManager.this.mFusedLocationClient.removeLocationUpdates(PlayServicesLocationManager.this.mSingleLocationCallback);
                PlayServicesLocationManager.this.mSingleLocationCallback = null;
            }

            @Override // com.google.android.gms.location.LocationCallback
            public void onLocationAvailability(LocationAvailability locationAvailability) {
                if (locationAvailability.isLocationAvailable()) {
                    return;
                }
                callbackHolder.error(PositionError.buildError(PositionError.POSITION_UNAVAILABLE, "Location not available (FusedLocationProvider/lastLocation)."));
            }
        };
    }

    private static class CallbackHolder {
        Callback error;
        Callback success;

        public CallbackHolder(Callback callback, Callback callback2) {
            this.success = callback;
            this.error = callback2;
        }

        public void error(WritableMap writableMap) {
            Callback callback = this.error;
            if (callback == null) {
                Log.e(getClass().getSimpleName(), "tried to invoke null error callback -> " + writableMap.toString());
            } else {
                callback.invoke(writableMap);
                this.error = null;
            }
        }

        public void success(Location location) {
            Callback callback = this.success;
            if (callback == null) {
                Log.e(getClass().getSimpleName(), "tried to invoke null success callback");
            } else {
                callback.invoke(BaseLocationManager.locationToMap(location));
                this.success = null;
            }
        }
    }
}
