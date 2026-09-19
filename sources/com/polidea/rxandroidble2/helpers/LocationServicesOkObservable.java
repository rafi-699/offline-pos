package com.polidea.rxandroidble2.helpers;

import android.content.Context;
import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;
import com.polidea.rxandroidble2.ClientComponent;
import com.polidea.rxandroidble2.DaggerClientComponent;
import io.reactivex.Observable;
import io.reactivex.Observer;

/* JADX INFO: loaded from: classes4.dex */
public class LocationServicesOkObservable extends Observable<Boolean> {
    private final Observable<Boolean> locationServicesOkObsImpl;

    public static LocationServicesOkObservable createInstance(Context context) {
        return DaggerClientComponent.builder().applicationContext(context.getApplicationContext()).build().locationServicesOkObservable();
    }

    @Inject
    LocationServicesOkObservable(@Named(ClientComponent.NamedBooleanObservables.LOCATION_SERVICES_OK) Observable<Boolean> observable) {
        this.locationServicesOkObsImpl = observable;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super Boolean> observer) {
        this.locationServicesOkObsImpl.subscribe(observer);
    }
}
