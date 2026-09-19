package io.reactivex;

/* JADX INFO: loaded from: classes2.dex */
public interface ObservableTransformer<Upstream, Downstream> {
    /* JADX INFO: renamed from: apply */
    ObservableSource<Downstream> apply2(Observable<Upstream> observable);
}
