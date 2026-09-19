package io.reactivex;

/* JADX INFO: loaded from: classes2.dex */
public interface SingleTransformer<Upstream, Downstream> {
    /* JADX INFO: renamed from: apply */
    SingleSource<Downstream> apply2(Single<Upstream> single);
}
