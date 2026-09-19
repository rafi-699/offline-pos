package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzici;
import com.google.android.gms.internal.ads.zzicj;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzicj<MessageType extends zzicj<MessageType, BuilderType>, BuilderType extends zzici<MessageType, BuilderType>> implements zzifp {
    protected transient int zzq = 0;

    protected static void zzaV(zzida zzidaVar) throws IllegalArgumentException {
        if (!zzidaVar.zzi()) {
            throw new IllegalArgumentException("Byte string is not UTF-8.");
        }
    }

    protected static <T> void zzaW(Iterable<T> iterable, List<? super T> list) {
        zzici.zzaT(iterable, list);
    }

    private String zzdV(String str) {
        String name = getClass().getName();
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 18 + String.valueOf(str).length() + 44);
        sb.append("Serializing ");
        sb.append(name);
        sb.append(" to a ");
        sb.append(str);
        sb.append(" threw an IOException (should never happen).");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzifp
    public zzida zzaM() {
        try {
            int iZzbr = zzbr();
            zzida zzidaVar = zzida.zza;
            byte[] bArr = new byte[iZzbr];
            int i = zzidj.zzb;
            zzidg zzidgVar = new zzidg(bArr, 0, iZzbr);
            zzcX(zzidgVar);
            return zzicw.zza(zzidgVar, bArr);
        } catch (IOException e) {
            throw new RuntimeException(zzdV("ByteString"), e);
        }
    }

    public byte[] zzaN() {
        try {
            int iZzbr = zzbr();
            byte[] bArr = new byte[iZzbr];
            int i = zzidj.zzb;
            zzidg zzidgVar = new zzidg(bArr, 0, iZzbr);
            zzcX(zzidgVar);
            zzidgVar.zzI();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(zzdV("byte array"), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzifp
    public void zzaO(OutputStream outputStream) throws IOException {
        zzidi zzidiVar = new zzidi(outputStream, zzidj.zzE(zzbr()));
        zzcX(zzidiVar);
        zzidiVar.zzx();
    }

    public void zzaP(OutputStream outputStream) throws IOException {
        int iZzbr = zzbr();
        zzidi zzidiVar = new zzidi(outputStream, zzidj.zzE(zzidj.zzF(iZzbr) + iZzbr));
        zzidiVar.zzr(iZzbr);
        zzcX(zzidiVar);
        zzidiVar.zzx();
    }

    int zzaQ() {
        throw new UnsupportedOperationException();
    }

    void zzaR(int i) {
        throw new UnsupportedOperationException();
    }

    public zzifu zzaS() {
        throw new UnsupportedOperationException("mutableCopy() is not implemented.");
    }

    int zzaT(zzigh zzighVar) {
        return zzaQ();
    }

    zzigs zzaU() {
        return new zzigs(this);
    }
}
