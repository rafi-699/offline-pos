package com.polidea.rxandroidble2.internal.util;

import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;
import com.polidea.rxandroidble2.ClientComponent;
import com.polidea.rxandroidble2.RxBleAdapterStateObservable;
import com.polidea.rxandroidble2.RxBleClient;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class ClientStateObservable extends Observable<RxBleClient.State> {
    final Observable<RxBleAdapterStateObservable.BleAdapterState> bleAdapterStateObservable;
    final Observable<Boolean> locationServicesOkObservable;
    private final LocationServicesStatus locationServicesStatus;
    final RxBleAdapterWrapper rxBleAdapterWrapper;
    private final Scheduler timerScheduler;

    @Inject
    protected ClientStateObservable(RxBleAdapterWrapper rxBleAdapterWrapper, Observable<RxBleAdapterStateObservable.BleAdapterState> observable, @Named(ClientComponent.NamedBooleanObservables.LOCATION_SERVICES_OK) Observable<Boolean> observable2, LocationServicesStatus locationServicesStatus, @Named(ClientComponent.NamedSchedulers.TIMEOUT) Scheduler scheduler) {
        this.rxBleAdapterWrapper = rxBleAdapterWrapper;
        this.bleAdapterStateObservable = observable;
        this.locationServicesOkObservable = observable2;
        this.locationServicesStatus = locationServicesStatus;
        this.timerScheduler = scheduler;
    }

    private static Single<Boolean> checkPermissionUntilGranted(final LocationServicesStatus locationServicesStatus, Scheduler scheduler) {
        return Observable.interval(0L, 1L, TimeUnit.SECONDS, scheduler).takeWhile(new Predicate<Long>() { // from class: com.polidea.rxandroidble2.internal.util.ClientStateObservable.2
            @Override // io.reactivex.functions.Predicate
            public boolean test(Long l) {
                return !locationServicesStatus.isLocationPermissionOk();
            }
        }).count().map(new Function<Long, Boolean>() { // from class: com.polidea.rxandroidble2.internal.util.ClientStateObservable.1
            @Override // io.reactivex.functions.Function
            public Boolean apply(Long l) {
                return Boolean.valueOf(l.longValue() == 0);
            }
        });
    }

    static Observable<RxBleClient.State> checkAdapterAndServicesState(RxBleAdapterWrapper rxBleAdapterWrapper, Observable<RxBleAdapterStateObservable.BleAdapterState> observable, final Observable<Boolean> observable2) {
        RxBleAdapterStateObservable.BleAdapterState bleAdapterState;
        if (rxBleAdapterWrapper.isBluetoothEnabled()) {
            bleAdapterState = RxBleAdapterStateObservable.BleAdapterState.STATE_ON;
        } else {
            bleAdapterState = RxBleAdapterStateObservable.BleAdapterState.STATE_OFF;
        }
        return observable.startWith(bleAdapterState).switchMap(new Function<RxBleAdapterStateObservable.BleAdapterState, Observable<RxBleClient.State>>() { // from class: com.polidea.rxandroidble2.internal.util.ClientStateObservable.3
            @Override // io.reactivex.functions.Function
            public Observable<RxBleClient.State> apply(RxBleAdapterStateObservable.BleAdapterState bleAdapterState2) {
                if (bleAdapterState2 != RxBleAdapterStateObservable.BleAdapterState.STATE_ON) {
                    return Observable.just(RxBleClient.State.BLUETOOTH_NOT_ENABLED);
                }
                return observable2.map(new Function<Boolean, RxBleClient.State>() { // from class: com.polidea.rxandroidble2.internal.util.ClientStateObservable.3.1
                    @Override // io.reactivex.functions.Function
                    public RxBleClient.State apply(Boolean bool) {
                        return bool.booleanValue() ? RxBleClient.State.READY : RxBleClient.State.LOCATION_SERVICES_NOT_ENABLED;
                    }
                });
            }
        });
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super RxBleClient.State> observer) {
        if (!this.rxBleAdapterWrapper.hasBluetoothAdapter()) {
            observer.onSubscribe(Disposables.empty());
            observer.onComplete();
        } else {
            checkPermissionUntilGranted(this.locationServicesStatus, this.timerScheduler).flatMapObservable(new Function<Boolean, Observable<RxBleClient.State>>() { // from class: com.polidea.rxandroidble2.internal.util.ClientStateObservable.4
                @Override // io.reactivex.functions.Function
                public Observable<RxBleClient.State> apply(Boolean bool) {
                    Observable<RxBleClient.State> observableDistinctUntilChanged = ClientStateObservable.checkAdapterAndServicesState(ClientStateObservable.this.rxBleAdapterWrapper, ClientStateObservable.this.bleAdapterStateObservable, ClientStateObservable.this.locationServicesOkObservable).distinctUntilChanged();
                    return bool.booleanValue() ? observableDistinctUntilChanged.skip(1L) : observableDistinctUntilChanged;
                }
            }).subscribe(observer);
        }
    }
}
