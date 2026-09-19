package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.webkit.ProxyConfig;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzpr;
import com.google.android.gms.internal.measurement.zzqp;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@23.0.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzav extends zzos {
    private final zzau zzm;
    private final zzog zzn;
    private static final String[] zzb = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    static final String[] zza = {"associated_row_id", "ALTER TABLE upload_queue ADD COLUMN associated_row_id INTEGER;", "last_upload_timestamp", "ALTER TABLE upload_queue ADD COLUMN last_upload_timestamp INTEGER;"};
    private static final String[] zzc = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzd = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;", "daily_registered_triggers_count", "ALTER TABLE apps ADD COLUMN daily_registered_triggers_count INTEGER;", "client_upload_eligibility", "ALTER TABLE apps ADD COLUMN client_upload_eligibility INTEGER;", "gmp_version_for_remote_config", "ALTER TABLE apps ADD COLUMN gmp_version_for_remote_config INTEGER;"};
    private static final String[] zze = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zzf = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzh = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzi = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzj = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private static final String[] zzk = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};
    private static final String[] zzl = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};

    zzav(zzpg zzpgVar) {
        super(zzpgVar);
        this.zzn = new zzog(this.zzu.zzaZ());
        this.zzu.zzc();
        this.zzm = new zzau(this, this.zzu.zzaY(), "google_app_measurement.db");
    }

    private final String zzaA(String str, String[] strArr, String str2) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = zze().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    String string = cursorRawQuery.getString(0);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return string;
                }
                if (cursorRawQuery == null) {
                    return "";
                }
                cursorRawQuery.close();
                return "";
            } catch (SQLiteException e) {
                this.zzu.zzaV().zzb().zzc("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    private final void zzaB(String str, String str2, ContentValues contentValues) {
        try {
            SQLiteDatabase sQLiteDatabaseZze = zze();
            String asString = contentValues.getAsString("app_id");
            if (asString == null) {
                this.zzu.zzaV().zzd().zzb("Value of the primary key is not set.", zzgu.zzl("app_id"));
                return;
            }
            StringBuilder sb = new StringBuilder(10);
            sb.append("app_id = ?");
            if (sQLiteDatabaseZze.update("consent_settings", contentValues, sb.toString(), new String[]{asString}) == 0 && sQLiteDatabaseZze.insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                this.zzu.zzaV().zzb().zzc("Failed to insert/update table (got -1). key", zzgu.zzl("consent_settings"), zzgu.zzl("app_id"));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzd("Error storing into table. key", zzgu.zzl("consent_settings"), zzgu.zzl("app_id"), e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:63:0x016a  */
    /* JADX WARN: Code duplicated, block: B:68:0x0173  */
    private final zzbc zzaC(String str, String str2, String str3) throws Throwable {
        String str4;
        Cursor cursorQuery;
        Cursor cursor;
        Boolean boolValueOf;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        zzg();
        zzaw();
        Cursor cursor2 = null;
        try {
            cursorQuery = zze().query(str, (String[]) new ArrayList(Arrays.asList("lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling", "current_session_count")).toArray(new String[0]), "app_id=? and name=?", new String[]{str2, str3}, null, null, null);
            try {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                    long j = cursorQuery.getLong(0);
                    long j2 = cursorQuery.getLong(1);
                    long j3 = cursorQuery.getLong(2);
                    long j4 = cursorQuery.isNull(3) ? 0L : cursorQuery.getLong(3);
                    Long lValueOf = cursorQuery.isNull(4) ? null : Long.valueOf(cursorQuery.getLong(4));
                    Long lValueOf2 = cursorQuery.isNull(5) ? null : Long.valueOf(cursorQuery.getLong(5));
                    Long lValueOf3 = cursorQuery.isNull(6) ? null : Long.valueOf(cursorQuery.getLong(6));
                    if (cursorQuery.isNull(7)) {
                        boolValueOf = null;
                    } else {
                        boolValueOf = Boolean.valueOf(cursorQuery.getLong(7) == 1);
                    }
                    try {
                        cursor = cursorQuery;
                        Long l = lValueOf2;
                        str4 = str3;
                        try {
                            zzbc zzbcVar = new zzbc(str2, str4, j, j2, cursorQuery.isNull(8) ? 0L : cursorQuery.getLong(8), j3, j4, lValueOf, l, lValueOf3, boolValueOf);
                            if (cursor.moveToNext()) {
                                this.zzu.zzaV().zzb().zzb("Got multiple records for event aggregates, expected one. appId", zzgu.zzl(str2));
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            return zzbcVar;
                        } catch (SQLiteException e) {
                            e = e;
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursor;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            throw th;
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        str4 = str3;
                        cursor = cursorQuery;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = cursorQuery;
                    }
                    zzic zzicVar = this.zzu;
                    zzicVar.zzaV().zzb().zzd("Error querying events. appId", zzgu.zzl(str2), zzicVar.zzl().zza(str4), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    cursor2 = cursorQuery;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e3) {
                e = e3;
                str4 = str3;
                cursor = cursorQuery;
            } catch (Throwable th4) {
                th = th4;
                cursor = cursorQuery;
            }
            cursorQuery = cursor;
        } catch (SQLiteException e4) {
            e = e4;
            str4 = str3;
            cursorQuery = null;
        } catch (Throwable th5) {
            th = th5;
        }
    }

    private final void zzaD(String str, zzbc zzbcVar) {
        Preconditions.checkNotNull(zzbcVar);
        zzg();
        zzaw();
        ContentValues contentValues = new ContentValues();
        String str2 = zzbcVar.zza;
        contentValues.put("app_id", str2);
        contentValues.put("name", zzbcVar.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzbcVar.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzbcVar.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzbcVar.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzbcVar.zzg));
        contentValues.put("last_bundled_day", zzbcVar.zzh);
        contentValues.put("last_sampled_complex_event_id", zzbcVar.zzi);
        contentValues.put("last_sampling_rate", zzbcVar.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzbcVar.zze));
        Boolean bool = zzbcVar.zzk;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (zze().insertWithOnConflict(str, null, contentValues, 5) == -1) {
                this.zzu.zzaV().zzb().zzb("Failed to insert/update event aggregates (got -1). appId", zzgu.zzl(str2));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzc("Error storing event aggregates. appId", zzgu.zzl(zzbcVar.zza), e);
        }
    }

    private final void zzaE(String str, String str2) {
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzaw();
        try {
            zze().delete(str, "app_id=?", new String[]{str2});
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzc("Error deleting snapshot. appId", zzgu.zzl(str2), e);
        }
    }

    private final zzpj zzaF(String str, long j, byte[] bArr, String str2, String str3, int i, int i2, long j2, long j3, long j4) {
        if (TextUtils.isEmpty(str2)) {
            this.zzu.zzaV().zzj().zza("Upload uri is null or empty. Destination is unknown. Dropping batch. ");
            return null;
        }
        try {
            com.google.android.gms.internal.measurement.zzhz zzhzVar = (com.google.android.gms.internal.measurement.zzhz) zzpk.zzw(com.google.android.gms.internal.measurement.zzib.zzh(), bArr);
            zzls zzlsVarZzb = zzls.zzb(i);
            if (zzlsVarZzb != zzls.GOOGLE_SIGNAL && zzlsVarZzb != zzls.GOOGLE_SIGNAL_PENDING && i2 > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator it = zzhzVar.zza().iterator();
                while (it.hasNext()) {
                    com.google.android.gms.internal.measurement.zzic zzicVar = (com.google.android.gms.internal.measurement.zzic) ((com.google.android.gms.internal.measurement.zzid) it.next()).zzcl();
                    zzicVar.zzao(i2);
                    arrayList.add((com.google.android.gms.internal.measurement.zzid) zzicVar.zzbc());
                }
                zzhzVar.zzg();
                zzhzVar.zzf(arrayList);
            }
            HashMap map = new HashMap();
            if (str3 != null) {
                for (String str4 : str3.split("\r\n")) {
                    if (str4.isEmpty()) {
                        break;
                    }
                    String[] strArrSplit = str4.split("=", 2);
                    if (strArrSplit.length != 2) {
                        this.zzu.zzaV().zzb().zzb("Invalid upload header: ", str4);
                        break;
                    }
                    map.put(strArrSplit[0], strArrSplit[1]);
                }
            }
            zzpi zzpiVar = new zzpi();
            zzpiVar.zzb(j);
            zzpiVar.zzc((com.google.android.gms.internal.measurement.zzib) zzhzVar.zzbc());
            zzpiVar.zzd(str2);
            zzpiVar.zze(map);
            zzpiVar.zzf(zzlsVarZzb);
            zzpiVar.zzg(j2);
            zzpiVar.zzh(j3);
            zzpiVar.zzi(j4);
            zzpiVar.zzj(i2);
            return zzpiVar.zza();
        } catch (IOException e) {
            this.zzu.zzaV().zzb().zzc("Failed to queued MeasurementBatch from upload_queue. appId", str, e);
            return null;
        }
    }

    private final String zzaG() {
        zzic zzicVar = this.zzu;
        long jCurrentTimeMillis = zzicVar.zzaZ().currentTimeMillis();
        Locale locale = Locale.US;
        zzls zzlsVar = zzls.GOOGLE_SIGNAL;
        Integer numValueOf = Integer.valueOf(zzlsVar.zza());
        Long lValueOf = Long.valueOf(jCurrentTimeMillis);
        zzicVar.zzc();
        String str = String.format(locale, "(upload_type = %d AND ABS(creation_timestamp - %d) > %d)", numValueOf, lValueOf, Long.valueOf(((Long) zzfy.zzS.zzb(null)).longValue()));
        Locale locale2 = Locale.US;
        Integer numValueOf2 = Integer.valueOf(zzlsVar.zza());
        zzicVar.zzc();
        String str2 = String.format(locale2, "(upload_type != %d AND ABS(creation_timestamp - %d) > %d)", numValueOf2, lValueOf, Long.valueOf(zzal.zzI()));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 5 + String.valueOf(str2).length() + 1);
        sb.append("(");
        sb.append(str);
        sb.append(" OR ");
        sb.append(str2);
        sb.append(")");
        return sb.toString();
    }

    private static final String zzaH(List list) {
        return list.isEmpty() ? "" : String.format(" AND (upload_type IN (%s))", TextUtils.join(", ", list));
    }

    static final void zzau(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty("value");
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            contentValues.put("value", (Double) obj);
        }
    }

    private final long zzay(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = zze().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j = cursorRawQuery.getLong(0);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return j;
            } catch (SQLiteException e) {
                this.zzu.zzaV().zzb().zzc("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long zzaz(String str, String[] strArr, long j) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = zze().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    j = cursorRawQuery.getLong(0);
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return j;
            } catch (SQLiteException e) {
                this.zzu.zzaV().zzb().zzc("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public final long zzA(String str, com.google.android.gms.internal.measurement.zzib zzibVar, String str2, Map map, zzls zzlsVar, Long l) {
        int iDelete;
        zzg();
        zzaw();
        Preconditions.checkNotNull(zzibVar);
        Preconditions.checkNotEmpty(str);
        zzg();
        zzaw();
        if (zzag()) {
            zzpg zzpgVar = this.zzg;
            long jZza = zzpgVar.zzq().zzb.zza();
            zzic zzicVar = this.zzu;
            long jElapsedRealtime = zzicVar.zzaZ().elapsedRealtime();
            long jAbs = Math.abs(jElapsedRealtime - jZza);
            zzicVar.zzc();
            if (jAbs > zzal.zzJ()) {
                zzpgVar.zzq().zzb.zzb(jElapsedRealtime);
                zzg();
                zzaw();
                if (zzag() && (iDelete = zze().delete("upload_queue", zzaG(), new String[0])) > 0) {
                    zzicVar.zzaV().zzk().zzb("Deleted stale MeasurementBatch rows from upload_queue. rowsDeleted", Integer.valueOf(iDelete));
                }
                Preconditions.checkNotEmpty(str);
                zzg();
                zzaw();
                try {
                    int iZzm = zzicVar.zzc().zzm(str, zzfy.zzz);
                    if (iZzm > 0) {
                        zze().delete("upload_queue", "rowid in (SELECT rowid FROM upload_queue WHERE app_id=? ORDER BY rowid DESC LIMIT -1 OFFSET ?)", new String[]{str, String.valueOf(iZzm)});
                    }
                } catch (SQLiteException e) {
                    this.zzu.zzaV().zzb().zzc("Error deleting over the limit queued batches. appId", zzgu.zzl(str), e);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            String str3 = (String) entry.getKey();
            String str4 = (String) entry.getValue();
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 1 + String.valueOf(str4).length());
            sb.append(str3);
            sb.append("=");
            sb.append(str4);
            arrayList.add(sb.toString());
        }
        byte[] bArrZzcc = zzibVar.zzcc();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("measurement_batch", bArrZzcc);
        contentValues.put("upload_uri", str2);
        contentValues.put("upload_headers", UByte$$ExternalSyntheticBackport0.m((CharSequence) "\r\n", (Iterable) arrayList));
        contentValues.put("upload_type", Integer.valueOf(zzlsVar.zza()));
        zzic zzicVar2 = this.zzu;
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzicVar2.zzaZ().currentTimeMillis()));
        contentValues.put("retry_count", (Integer) 0);
        if (l != null) {
            contentValues.put("associated_row_id", l);
        }
        try {
            long jInsert = zze().insert("upload_queue", null, contentValues);
            if (jInsert != -1) {
                return jInsert;
            }
            zzicVar2.zzaV().zzb().zzb("Failed to insert MeasurementBatch (got -1) to upload_queue. appId", str);
            return -1L;
        } catch (SQLiteException e2) {
            this.zzu.zzaV().zzb().zzc("Error storing MeasurementBatch to upload_queue. appId", str, e2);
            return -1L;
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00da  */
    /* JADX WARN: Code duplicated, block: B:34:0x00e1  */
    /* JADX WARN: Multi-variable type inference failed */
    public final zzpj zzB(long j) throws Throwable {
        zzpj zzpjVar;
        Cursor cursorQuery;
        Cursor cursor;
        zzg();
        zzaw();
        try {
            zzpjVar = null;
            try {
                cursorQuery = zze().query("upload_queue", new String[]{"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "associated_row_id", "last_upload_timestamp"}, "rowId=?", new String[]{String.valueOf(j)}, null, null, null, "1");
                try {
                    if (cursorQuery.moveToFirst()) {
                        zzpj zzpjVarZzaF = zzaF((String) Preconditions.checkNotNull(cursorQuery.getString(1)), j, cursorQuery.getBlob(2), cursorQuery.getString(3), cursorQuery.getString(4), cursorQuery.getInt(5), cursorQuery.getInt(6), cursorQuery.getLong(7), cursorQuery.getLong(8), cursorQuery.getLong(9));
                        if (cursorQuery != 0) {
                            cursorQuery.close();
                        }
                        return zzpjVarZzaF;
                    }
                } catch (SQLiteException e) {
                    e = e;
                    try {
                        this.zzu.zzaV().zzb().zzc("Error to querying MeasurementBatch from upload_queue. rowId", Long.valueOf(j), e);
                        cursor = cursorQuery;
                    } catch (Throwable th) {
                        th = th;
                        if (cursorQuery != 0) {
                            cursorQuery.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursorQuery != 0) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursorQuery = zzpjVar;
                this.zzu.zzaV().zzb().zzc("Error to querying MeasurementBatch from upload_queue. rowId", Long.valueOf(j), e);
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor = cursorQuery;
                    cursor.close();
                }
                cursor = cursorQuery;
                return zzpjVar;
            } catch (Throwable th3) {
                th = th3;
                cursorQuery = zzpjVar;
                if (cursorQuery != 0) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            zzpjVar = null;
        } catch (Throwable th4) {
            th = th4;
            zzpjVar = null;
        }
        if (cursor != null) {
            cursor = cursorQuery;
            cursor.close();
        }
        cursor = cursorQuery;
        return zzpjVar;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0147  */
    /* JADX WARN: Code duplicated, block: B:40:0x0150  */
    public final List zzC(String str, zzoo zzooVar, int i) {
        Cursor cursor;
        String str2;
        Cursor cursor2;
        List listEmptyList;
        Cursor cursorQuery;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzaw();
        try {
            SQLiteDatabase sQLiteDatabaseZze = zze();
            int i2 = 0;
            int i3 = 2;
            int i4 = 3;
            String[] strArr = {"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "associated_row_id", "last_upload_timestamp"};
            String strZzaH = zzaH(zzooVar.zza);
            String strZzaG = zzaG();
            StringBuilder sb = new StringBuilder(String.valueOf(strZzaH).length() + 17 + strZzaG.length());
            sb.append("app_id=?");
            sb.append(strZzaH);
            sb.append(" AND NOT ");
            sb.append(strZzaG);
            int i5 = 7;
            int i6 = 8;
            int i7 = 6;
            int i8 = 5;
            cursorQuery = sQLiteDatabaseZze.query("upload_queue", strArr, sb.toString(), new String[]{str}, null, null, "creation_timestamp ASC", i > 0 ? String.valueOf(i) : null);
            try {
                listEmptyList = new ArrayList();
                while (cursorQuery.moveToNext()) {
                    long j = cursorQuery.getLong(i2);
                    byte[] blob = cursorQuery.getBlob(i3);
                    String string = cursorQuery.getString(i4);
                    String string2 = cursorQuery.getString(4);
                    int i9 = cursorQuery.getInt(i8);
                    int i10 = cursorQuery.getInt(i7);
                    long j2 = cursorQuery.getLong(i5);
                    int i11 = i2;
                    int i12 = i3;
                    long j3 = cursorQuery.getLong(i6);
                    int i13 = i4;
                    int i14 = i8;
                    int i15 = i5;
                    cursor2 = cursorQuery;
                    int i16 = i7;
                    str2 = str;
                    List list = listEmptyList;
                    try {
                        zzpj zzpjVarZzaF = zzaF(str2, j, blob, string, string2, i9, i10, j2, j3, cursorQuery.getLong(9));
                        if (zzpjVarZzaF != null) {
                            list.add(zzpjVarZzaF);
                        }
                        listEmptyList = list;
                        cursorQuery = cursor2;
                        i5 = i15;
                        i7 = i16;
                        i8 = i14;
                        i4 = i13;
                        i3 = i12;
                        i2 = i11;
                        i6 = 8;
                    } catch (SQLiteException e) {
                        e = e;
                        try {
                            this.zzu.zzaV().zzb().zzc("Error to querying MeasurementBatch from upload_queue. appId", str2, e);
                            listEmptyList = Collections.emptyList();
                            cursorQuery = cursor2;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return listEmptyList;
                        } catch (Throwable th) {
                            th = th;
                            cursor = cursor2;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = cursor2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            } catch (SQLiteException e2) {
                e = e2;
                str2 = str;
                cursor2 = cursorQuery;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursorQuery;
            }
        } catch (SQLiteException e3) {
            e = e3;
            str2 = str;
            cursor2 = null;
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return listEmptyList;
    }

    public final boolean zzD(String str) {
        zzls[] zzlsVarArr = {zzls.GOOGLE_SIGNAL};
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Integer.valueOf(zzlsVarArr[0].zza()));
        String strZzaH = zzaH(arrayList);
        String strZzaG = zzaG();
        StringBuilder sb = new StringBuilder(String.valueOf(strZzaH).length() + 61 + strZzaG.length());
        sb.append("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=?");
        sb.append(strZzaH);
        sb.append(" AND NOT ");
        sb.append(strZzaG);
        return zzay(sb.toString(), new String[]{str}) != 0;
    }

    public final void zzE(Long l) {
        zzg();
        zzaw();
        Preconditions.checkNotNull(l);
        try {
            if (zze().delete("upload_queue", "rowid=?", new String[]{l.toString()}) != 1) {
                this.zzu.zzaV().zze().zza("Deleted fewer rows from upload_queue than expected");
            }
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzb("Failed to delete a MeasurementBatch in a upload_queue table", e);
            throw e;
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x003e  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final String zzF() throws Throwable {
        SQLiteException e;
        Cursor cursorRawQuery;
        SQLiteDatabase sQLiteDatabaseZze = zze();
        ?? r1 = 0;
        try {
            try {
                cursorRawQuery = sQLiteDatabaseZze.rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        String string = cursorRawQuery.getString(0);
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        return string;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    this.zzu.zzaV().zzb().zzb("Database error getting next bundle app id", e);
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursorRawQuery = null;
            } catch (Throwable th) {
                th = th;
                if (r1 != 0) {
                    r1.close();
                }
                throw th;
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return null;
        } catch (Throwable th2) {
            r1 = sQLiteDatabaseZze;
            th = th2;
            if (r1 != 0) {
                r1.close();
            }
            throw th;
        }
    }

    public final boolean zzG() {
        return zzay("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    public final void zzH(long j) {
        zzg();
        zzaw();
        try {
            if (zze().delete("queue", "rowid=?", new String[]{String.valueOf(j)}) == 1) {
            } else {
                throw new SQLiteException("Deleted fewer rows from queue than expected");
            }
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzb("Failed to delete a bundle in a queue table", e);
            throw e;
        }
    }

    final void zzI() {
        zzg();
        zzaw();
        if (zzag()) {
            zzpg zzpgVar = this.zzg;
            long jZza = zzpgVar.zzq().zza.zza();
            zzic zzicVar = this.zzu;
            long jElapsedRealtime = zzicVar.zzaZ().elapsedRealtime();
            long jAbs = Math.abs(jElapsedRealtime - jZza);
            zzicVar.zzc();
            if (jAbs > zzal.zzJ()) {
                zzpgVar.zzq().zza.zzb(jElapsedRealtime);
                zzg();
                zzaw();
                if (zzag()) {
                    SQLiteDatabase sQLiteDatabaseZze = zze();
                    zzicVar.zzc();
                    int iDelete = sQLiteDatabaseZze.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzicVar.zzaZ().currentTimeMillis()), String.valueOf(zzal.zzI())});
                    if (iDelete > 0) {
                        zzicVar.zzaV().zzk().zzb("Deleted stale rows. rowsDeleted", Integer.valueOf(iDelete));
                    }
                }
            }
        }
    }

    final void zzJ(List list) {
        zzg();
        zzaw();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzag()) {
            String strJoin = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(strJoin).length() + 2);
            sb.append("(");
            sb.append(strJoin);
            sb.append(")");
            String string = sb.toString();
            StringBuilder sb2 = new StringBuilder(string.length() + 80);
            sb2.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb2.append(string);
            sb2.append(" AND retry_count =  2147483647 LIMIT 1");
            if (zzay(sb2.toString(), null) > 0) {
                this.zzu.zzaV().zze().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase sQLiteDatabaseZze = zze();
                StringBuilder sb3 = new StringBuilder(string.length() + 127);
                sb3.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb3.append(string);
                sb3.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                sQLiteDatabaseZze.execSQL(sb3.toString());
            } catch (SQLiteException e) {
                this.zzu.zzaV().zzb().zzb("Error incrementing retry count. error", e);
            }
        }
    }

    final void zzK(Long l) {
        zzg();
        zzaw();
        Preconditions.checkNotNull(l);
        if (zzag()) {
            StringBuilder sb = new StringBuilder(l.toString().length() + 86);
            sb.append("SELECT COUNT(1) FROM upload_queue WHERE rowid = ");
            sb.append(l);
            sb.append(" AND retry_count =  2147483647 LIMIT 1");
            if (zzay(sb.toString(), null) > 0) {
                this.zzu.zzaV().zze().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase sQLiteDatabaseZze = zze();
                long jCurrentTimeMillis = this.zzu.zzaZ().currentTimeMillis();
                StringBuilder sb2 = new StringBuilder(String.valueOf(jCurrentTimeMillis).length() + 60);
                sb2.append(" SET retry_count = retry_count + 1, last_upload_timestamp = ");
                sb2.append(jCurrentTimeMillis);
                String string = sb2.toString();
                StringBuilder sb3 = new StringBuilder(string.length() + 34 + l.toString().length() + 29);
                sb3.append("UPDATE upload_queue");
                sb3.append(string);
                sb3.append(" WHERE rowid = ");
                sb3.append(l);
                sb3.append(" AND retry_count < 2147483647");
                sQLiteDatabaseZze.execSQL(sb3.toString());
            } catch (SQLiteException e) {
                this.zzu.zzaV().zzb().zzb("Error incrementing retry count. error", e);
            }
        }
    }

    final Object zzL(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            this.zzu.zzaV().zzb().zza("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i));
        }
        if (type == 3) {
            return cursor.getString(i);
        }
        if (type != 4) {
            this.zzu.zzaV().zzb().zzb("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
            return null;
        }
        this.zzu.zzaV().zzb().zza("Loaded invalid blob type value, ignoring it");
        return null;
    }

    public final long zzM() {
        return zzaz("select max(bundle_end_timestamp) from queue", null, 0L);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x008f A[Catch: SQLiteException -> 0x00a8, all -> 0x00ab, TryCatch #0 {SQLiteException -> 0x00a8, blocks: (B:11:0x006e, B:13:0x008f, B:14:0x00a3), top: B:28:0x006e }] */
    /* JADX WARN: Code duplicated, block: B:14:0x00a3 A[Catch: SQLiteException -> 0x00a8, all -> 0x00ab, TRY_LEAVE, TryCatch #0 {SQLiteException -> 0x00a8, blocks: (B:11:0x006e, B:13:0x008f, B:14:0x00a3), top: B:28:0x006e }] */
    protected final long zzN(String str, String str2) {
        long j;
        ContentValues contentValues;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty("first_open_count");
        zzg();
        zzaw();
        SQLiteDatabase sQLiteDatabaseZze = zze();
        sQLiteDatabaseZze.beginTransaction();
        long j2 = 0;
        try {
            try {
                StringBuilder sb = new StringBuilder(48);
                sb.append("select first_open_count from app2 where app_id=?");
                j = -1;
                long jZzaz = zzaz(sb.toString(), new String[]{str}, -1L);
                if (jZzaz == -1) {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("app_id", str);
                    contentValues2.put("first_open_count", (Integer) 0);
                    contentValues2.put("previous_install_count", (Integer) 0);
                    if (sQLiteDatabaseZze.insertWithOnConflict("app2", null, contentValues2, 5) == -1) {
                        this.zzu.zzaV().zzb().zzc("Failed to insert column (got -1). appId", zzgu.zzl(str), "first_open_count");
                    } else {
                        jZzaz = 0;
                        try {
                            contentValues = new ContentValues();
                            contentValues.put("app_id", str);
                            contentValues.put("first_open_count", Long.valueOf(1 + jZzaz));
                            if (sQLiteDatabaseZze.update("app2", contentValues, "app_id = ?", new String[]{str}) == 0) {
                                this.zzu.zzaV().zzb().zzc("Failed to update column (got 0). appId", zzgu.zzl(str), "first_open_count");
                            } else {
                                sQLiteDatabaseZze.setTransactionSuccessful();
                                j = jZzaz;
                            }
                        } catch (SQLiteException e) {
                            e = e;
                            j2 = jZzaz;
                            this.zzu.zzaV().zzb().zzd("Error inserting column. appId", zzgu.zzl(str), "first_open_count", e);
                            j = j2;
                        }
                    }
                } else {
                    contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("first_open_count", Long.valueOf(1 + jZzaz));
                    if (sQLiteDatabaseZze.update("app2", contentValues, "app_id = ?", new String[]{str}) == 0) {
                        this.zzu.zzaV().zzb().zzc("Failed to update column (got 0). appId", zzgu.zzl(str), "first_open_count");
                    } else {
                        sQLiteDatabaseZze.setTransactionSuccessful();
                        j = jZzaz;
                    }
                }
            } catch (SQLiteException e2) {
                e = e2;
            }
            return j;
        } finally {
            sQLiteDatabaseZze.endTransaction();
        }
    }

    public final long zzO() {
        return zzaz("select max(timestamp) from raw_events", null, 0L);
    }

    public final boolean zzP() {
        return zzay("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean zzQ(String str, String str2) {
        return zzay("select count(1) from raw_events where app_id = ? and name = ?", new String[]{str, str2}) > 0;
    }

    public final boolean zzR() {
        return zzay("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    public final long zzS(String str) {
        Preconditions.checkNotEmpty(str);
        return zzaz("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    public final boolean zzT(String str, Long l, long j, com.google.android.gms.internal.measurement.zzhs zzhsVar) {
        zzg();
        zzaw();
        Preconditions.checkNotNull(zzhsVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        zzic zzicVar = this.zzu;
        byte[] bArrZzcc = zzhsVar.zzcc();
        zzicVar.zzaV().zzk().zzc("Saving complex main event, appId, data size", zzicVar.zzl().zza(str), Integer.valueOf(bArrZzcc.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", bArrZzcc);
        try {
            if (zze().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzicVar.zzaV().zzb().zzb("Failed to insert complex main event (got -1). appId", zzgu.zzl(str));
            return false;
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzc("Error storing complex main event. appId", zzgu.zzl(str), e);
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0088  */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0085: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:27:0x0085 */
    public final Bundle zzU(String str) throws Throwable {
        Cursor cursorRawQuery;
        Cursor cursor;
        zzg();
        zzaw();
        Cursor cursor2 = null;
        try {
            try {
                cursorRawQuery = zze().rawQuery("select parameters from default_event_params where app_id=?", new String[]{str});
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        try {
                            com.google.android.gms.internal.measurement.zzhs zzhsVar = (com.google.android.gms.internal.measurement.zzhs) ((com.google.android.gms.internal.measurement.zzhr) zzpk.zzw(com.google.android.gms.internal.measurement.zzhs.zzk(), cursorRawQuery.getBlob(0))).zzbc();
                            this.zzg.zzp();
                            Bundle bundleZzE = zzpk.zzE(zzhsVar.zza());
                            if (cursorRawQuery != null) {
                                cursorRawQuery.close();
                            }
                            return bundleZzE;
                        } catch (IOException e) {
                            this.zzu.zzaV().zzb().zzc("Failed to retrieve default event parameters. appId", zzgu.zzl(str), e);
                        }
                    } else {
                        this.zzu.zzaV().zzk().zza("Default event parameters not found");
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    this.zzu.zzaV().zzb().zzb("Error selecting default event parameters", e);
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursorRawQuery = null;
            } catch (Throwable th) {
                th = th;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor2 = cursor;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    final boolean zzV(String str, long j) {
        try {
            return zzaz("select count(*) from raw_events where app_id=? and timestamp >= ? and name not like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j)}, 0L) <= 0 && zzaz("select count(*) from raw_events where app_id=? and timestamp >= ? and name like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j)}, 0L) > 0;
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzb("Error checking backfill conditions", e);
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0089  */
    public final void zzW(String str, Long l, String str2, Bundle bundle) {
        zzic zzicVar;
        Bundle bundle2;
        zzbb zzbbVar;
        long j;
        String str3;
        ContentValues contentValues;
        zzpk zzpkVar;
        com.google.android.gms.internal.measurement.zzid zzidVar;
        String str4 = str;
        Preconditions.checkNotNull(bundle);
        zzg();
        zzaw();
        zzat zzatVar = l != null ? new zzat(this, str4, l.longValue()) : new zzat(this, str4);
        List<zzas> listZza = zzatVar.zza();
        while (!listZza.isEmpty()) {
            for (zzas zzasVar : listZza) {
                try {
                    if (!TextUtils.isEmpty(str2)) {
                        Cursor cursor = null;
                        zzidVar = null;
                        zzidVar = null;
                        com.google.android.gms.internal.measurement.zzid zzidVar2 = null;
                        Cursor cursor2 = null;
                        try {
                            try {
                                Cursor cursorQuery = zze().query("raw_events_metadata", new String[]{TtmlNode.TAG_METADATA}, "app_id = ? and metadata_fingerprint = ?", new String[]{str4, Long.toString(zzasVar.zzb)}, null, null, "rowid", ExifInterface.GPS_MEASUREMENT_2D);
                                try {
                                    try {
                                        if (cursorQuery.moveToFirst()) {
                                            try {
                                                zzidVar = (com.google.android.gms.internal.measurement.zzid) ((com.google.android.gms.internal.measurement.zzic) zzpk.zzw(com.google.android.gms.internal.measurement.zzid.zzaE(), cursorQuery.getBlob(0))).zzbc();
                                                try {
                                                    if (cursorQuery.moveToNext()) {
                                                        this.zzu.zzaV().zze().zzb("Get multiple raw event metadata records, expected one. appId", zzgu.zzl(str4));
                                                    }
                                                    cursorQuery.close();
                                                    if (cursorQuery != null) {
                                                        cursorQuery.close();
                                                    }
                                                } catch (SQLiteException e) {
                                                    e = e;
                                                    cursor2 = cursorQuery;
                                                    this.zzu.zzaV().zzb().zzc("Data loss. Error selecting raw event. appId", zzgu.zzl(str4), e);
                                                    if (cursor2 != null) {
                                                        cursor2.close();
                                                    }
                                                }
                                                zzidVar2 = zzidVar;
                                            } catch (IOException e2) {
                                                this.zzu.zzaV().zzb().zzc("Data loss. Failed to merge raw event metadata. appId", zzgu.zzl(str4), e2);
                                                if (cursorQuery != null) {
                                                    cursorQuery.close();
                                                }
                                            }
                                        } else {
                                            this.zzu.zzaV().zzb().zzb("Raw event metadata record is missing. appId", zzgu.zzl(str4));
                                            if (cursorQuery != null) {
                                                cursorQuery.close();
                                            }
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        cursor = cursorQuery;
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        throw th;
                                    }
                                } catch (SQLiteException e3) {
                                    e = e3;
                                    zzidVar = null;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (SQLiteException e4) {
                            e = e4;
                            zzidVar = null;
                        }
                        if (zzidVar2 != null) {
                            Iterator it = zzidVar2.zzf().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (((com.google.android.gms.internal.measurement.zziu) it.next()).zzc().equals(str2)) {
                                    }
                                }
                            }
                        }
                    }
                    long jUpdate = zze().update("raw_events", contentValues, "rowid = ?", new String[]{String.valueOf(j)});
                    if (jUpdate != 1) {
                        zzicVar.zzaV().zzb().zzc("Failed to update raw event. appId, updatedRows", zzgu.zzl(str3), Long.valueOf(jUpdate));
                    }
                } catch (SQLiteException e5) {
                    this.zzu.zzaV().zzb().zzc("Error updating raw event. appId", zzgu.zzl(zzbbVar.zza), e5);
                }
                zzpg zzpgVar = this.zzg;
                zzpk zzpkVarZzp = zzpgVar.zzp();
                com.google.android.gms.internal.measurement.zzhs zzhsVar = zzasVar.zzd;
                Bundle bundle3 = new Bundle();
                for (com.google.android.gms.internal.measurement.zzhw zzhwVar : zzhsVar.zza()) {
                    if (zzhwVar.zzi()) {
                        zzpkVar = zzpkVarZzp;
                        bundle3.putDouble(zzhwVar.zzb(), zzhwVar.zzj());
                    } else {
                        zzpkVar = zzpkVarZzp;
                        if (zzhwVar.zzg()) {
                            bundle3.putFloat(zzhwVar.zzb(), zzhwVar.zzh());
                        } else if (zzhwVar.zze()) {
                            bundle3.putLong(zzhwVar.zzb(), zzhwVar.zzf());
                        } else if (zzhwVar.zzc()) {
                            bundle3.putString(zzhwVar.zzb(), zzhwVar.zzd());
                        } else if (zzhwVar.zzk().isEmpty()) {
                            zzpkVar.zzu.zzaV().zzb().zzb("Unexpected parameter type for parameter", zzhwVar);
                        } else {
                            bundle3.putParcelableArray(zzhwVar.zzb(), zzpk.zzy(zzhwVar.zzk()));
                        }
                    }
                    zzpkVarZzp = zzpkVar;
                }
                String string = bundle3.getString("_o");
                bundle3.remove("_o");
                String strZzd = zzhsVar.zzd();
                if (string == null) {
                    string = "";
                }
                zzgv zzgvVar = new zzgv(strZzd, string, bundle3, zzhsVar.zzf());
                zzicVar = this.zzu;
                Bundle bundle4 = zzgvVar.zzd;
                String str5 = zzgvVar.zza;
                zzpp zzppVarZzk = zzicVar.zzk();
                if (str5.equals("_cmp")) {
                    bundle2 = new Bundle(bundle);
                    for (String str6 : bundle.keySet()) {
                        zzpg zzpgVar2 = zzpgVar;
                        if (str6.startsWith("gad_")) {
                            bundle2.remove(str6);
                        }
                        zzpgVar = zzpgVar2;
                    }
                } else {
                    bundle2 = bundle;
                }
                zzpg zzpgVar3 = zzpgVar;
                zzppVarZzk.zzI(bundle4, bundle2);
                zzbbVar = new zzbb(this.zzu, zzgvVar.zzb, str4, zzhsVar.zzd(), zzhsVar.zzf(), zzhsVar.zzh(), bundle4);
                j = zzasVar.zza;
                long j2 = zzasVar.zzb;
                boolean z = zzasVar.zzc;
                zzg();
                zzaw();
                Preconditions.checkNotNull(zzbbVar);
                str3 = zzbbVar.zza;
                Preconditions.checkNotEmpty(str3);
                byte[] bArrZzcc = zzpgVar3.zzp().zzh(zzbbVar).zzcc();
                contentValues = new ContentValues();
                contentValues.put("app_id", str3);
                contentValues.put("name", zzbbVar.zzb);
                contentValues.put(SDKConstants.PARAM_DEBUG_MESSAGE_TIMESTAMP, Long.valueOf(zzbbVar.zzd));
                contentValues.put("metadata_fingerprint", Long.valueOf(j2));
                contentValues.put("data", bArrZzcc);
                contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
                str4 = str;
            }
            listZza = zzatVar.zza();
            str4 = str;
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0062  */
    /* JADX WARN: Code duplicated, block: B:25:0x0065 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x006a  */
    /* JADX WARN: Code duplicated, block: B:33:0x005d A[ExcSplitCross -> B:21:0x005d, PHI: r3
  0x005d: PHI (r3v8 com.google.android.gms.measurement.internal.zzjl) = (r3v7 com.google.android.gms.measurement.internal.zzjl), (r3v11 com.google.android.gms.measurement.internal.zzjl) binds: [B:10:0x003e, B:7:0x002f] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v8, types: [com.google.android.gms.measurement.internal.zzjl] */
    public final zzjl zzX(String str) {
        Throwable th;
        SQLiteException e;
        Cursor cursorRawQuery;
        Preconditions.checkNotNull(str);
        zzg();
        zzaw();
        String[] strArr = {str};
        zzjl zzjlVar = "select consent_state, consent_source from consent_settings where app_id=? limit 1;";
        ?? r3 = 0;
        zzjlVarZzf = null;
        zzjlVarZzf = null;
        zzjlVarZzf = null;
        zzjl zzjlVarZzf = null;
        try {
            try {
                cursorRawQuery = zze().rawQuery("select consent_state, consent_source from consent_settings where app_id=? limit 1;", strArr);
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        zzjlVarZzf = zzjl.zzf(cursorRawQuery.getString(0), cursorRawQuery.getInt(1));
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                    } else {
                        this.zzu.zzaV().zzk().zza("No data found");
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    this.zzu.zzaV().zzb().zzb("Error querying database.", e);
                    if (cursorRawQuery != null) {
                    }
                    zzjlVar = zzjlVarZzf;
                    if (zzjlVarZzf == null) {
                        return zzjl.zza;
                    }
                    return zzjlVarZzf;
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursorRawQuery = null;
            } catch (Throwable th2) {
                th = th2;
                if (r3 != 0) {
                    r3.close();
                }
                throw th;
            }
            zzjlVar = zzjlVarZzf;
            if (zzjlVarZzf == null) {
                return zzjl.zza;
            }
            return zzjlVarZzf;
        } catch (Throwable th3) {
            th = th3;
            r3 = zzjlVar;
            if (r3 != 0) {
                r3.close();
            }
            throw th;
        }
    }

    public final boolean zzY(String str, zzoh zzohVar) {
        zzg();
        zzaw();
        Preconditions.checkNotNull(zzohVar);
        Preconditions.checkNotEmpty(str);
        zzic zzicVar = this.zzu;
        long jCurrentTimeMillis = zzicVar.zzaZ().currentTimeMillis();
        zzfx zzfxVar = zzfy.zzav;
        long jLongValue = jCurrentTimeMillis - ((Long) zzfxVar.zzb(null)).longValue();
        long j = zzohVar.zzb;
        if (j < jLongValue || j > ((Long) zzfxVar.zzb(null)).longValue() + jCurrentTimeMillis) {
            zzicVar.zzaV().zze().zzd("Storing trigger URI outside of the max retention time span. appId, now, timestamp", zzgu.zzl(str), Long.valueOf(jCurrentTimeMillis), Long.valueOf(j));
        }
        zzicVar.zzaV().zzk().zza("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", zzohVar.zza);
        contentValues.put("source", Integer.valueOf(zzohVar.zzc));
        contentValues.put("timestamp_millis", Long.valueOf(j));
        try {
            if (zze().insert("trigger_uris", null, contentValues) != -1) {
                return true;
            }
            zzicVar.zzaV().zzb().zzb("Failed to insert trigger URI (got -1). appId", zzgu.zzl(str));
            return false;
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzc("Error storing trigger URI. appId", zzgu.zzl(str), e);
            return false;
        }
    }

    public final void zzZ(String str, zzjl zzjlVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzjlVar);
        zzg();
        zzaw();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzjlVar.zzl());
        contentValues.put("consent_source", Integer.valueOf(zzjlVar.zzb()));
        zzaB("consent_settings", "app_id", contentValues);
    }

    public final zzaz zzaa(String str) {
        Preconditions.checkNotNull(str);
        zzg();
        zzaw();
        return zzaz.zzg(zzaA("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    public final void zzab(String str, zzaz zzazVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzazVar);
        zzg();
        zzaw();
        zzjl zzjlVarZzX = zzX(str);
        zzjl zzjlVar = zzjl.zza;
        if (zzjlVarZzX == zzjlVar) {
            zzZ(str, zzjlVar);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("dma_consent_settings", zzazVar.zze());
        zzaB("consent_settings", "app_id", contentValues);
    }

    public final void zzac(String str, zzjl zzjlVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzjlVar);
        zzg();
        zzaw();
        zzZ(str, zzX(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("storage_consent_at_bundling", zzjlVar.zzl());
        zzaB("consent_settings", "app_id", contentValues);
    }

    public final zzjl zzad(String str) {
        Preconditions.checkNotNull(str);
        zzg();
        zzaw();
        return zzjl.zzf(zzaA("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}, ""), 100);
    }

    final void zzae(String str, List list) {
        SQLiteDatabase sQLiteDatabase;
        boolean z;
        Preconditions.checkNotNull(list);
        for (int i = 0; i < list.size(); i++) {
            com.google.android.gms.internal.measurement.zzfc zzfcVar = (com.google.android.gms.internal.measurement.zzfc) ((com.google.android.gms.internal.measurement.zzfd) list.get(i)).zzcl();
            if (zzfcVar.zzd() != 0) {
                for (int i2 = 0; i2 < zzfcVar.zzd(); i2++) {
                    com.google.android.gms.internal.measurement.zzfe zzfeVar = (com.google.android.gms.internal.measurement.zzfe) zzfcVar.zze(i2).zzcl();
                    com.google.android.gms.internal.measurement.zzfe zzfeVar2 = (com.google.android.gms.internal.measurement.zzfe) zzfeVar.clone();
                    String strZzb = zzjm.zzb(zzfeVar.zza());
                    if (strZzb != null) {
                        zzfeVar2.zzb(strZzb);
                        z = true;
                    } else {
                        z = false;
                    }
                    int i3 = 0;
                    while (i3 < zzfeVar.zzc()) {
                        com.google.android.gms.internal.measurement.zzfh zzfhVarZzd = zzfeVar.zzd(i3);
                        com.google.android.gms.internal.measurement.zzfe zzfeVar3 = zzfeVar;
                        String strZzc = zzlt.zzc(zzfhVarZzd.zzh(), zzjn.zza, zzjn.zzb);
                        if (strZzc != null) {
                            com.google.android.gms.internal.measurement.zzfg zzfgVar = (com.google.android.gms.internal.measurement.zzfg) zzfhVarZzd.zzcl();
                            zzfgVar.zza(strZzc);
                            zzfeVar2.zze(i3, (com.google.android.gms.internal.measurement.zzfh) zzfgVar.zzbc());
                            z = true;
                        }
                        i3++;
                        zzfeVar = zzfeVar3;
                    }
                    if (z) {
                        zzfcVar.zzf(i2, zzfeVar2);
                        list.set(i, (com.google.android.gms.internal.measurement.zzfd) zzfcVar.zzbc());
                    }
                }
            }
            if (zzfcVar.zza() != 0) {
                for (int i4 = 0; i4 < zzfcVar.zza(); i4++) {
                    com.google.android.gms.internal.measurement.zzfn zzfnVarZzb = zzfcVar.zzb(i4);
                    String strZzc2 = zzlt.zzc(zzfnVarZzb.zzc(), zzjo.zza, zzjo.zzb);
                    if (strZzc2 != null) {
                        com.google.android.gms.internal.measurement.zzfm zzfmVar = (com.google.android.gms.internal.measurement.zzfm) zzfnVarZzb.zzcl();
                        zzfmVar.zza(strZzc2);
                        zzfcVar.zzc(i4, zzfmVar);
                        list.set(i, (com.google.android.gms.internal.measurement.zzfd) zzfcVar.zzbc());
                    }
                }
            }
        }
        zzaw();
        zzg();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        SQLiteDatabase sQLiteDatabaseZze = zze();
        sQLiteDatabaseZze.beginTransaction();
        try {
            zzaw();
            zzg();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase sQLiteDatabaseZze2 = zze();
            sQLiteDatabaseZze2.delete("property_filters", "app_id=?", new String[]{str});
            sQLiteDatabaseZze2.delete("event_filters", "app_id=?", new String[]{str});
            Iterator it = list.iterator();
            while (it.hasNext()) {
                com.google.android.gms.internal.measurement.zzfd zzfdVar = (com.google.android.gms.internal.measurement.zzfd) it.next();
                zzaw();
                zzg();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzfdVar);
                if (zzfdVar.zza()) {
                    int iZzb = zzfdVar.zzb();
                    Iterator it2 = zzfdVar.zzf().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (!((com.google.android.gms.internal.measurement.zzff) it2.next()).zza()) {
                                this.zzu.zzaV().zze().zzc("Event filter with no ID. Audience definition ignored. appId, audienceId", zzgu.zzl(str), Integer.valueOf(iZzb));
                                break;
                            }
                        } else {
                            Iterator it3 = zzfdVar.zzc().iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    Iterator it4 = zzfdVar.zzf().iterator();
                                    while (true) {
                                        com.google.android.gms.internal.measurement.zzfd zzfdVar2 = zzfdVar;
                                        String str2 = "app_id";
                                        try {
                                            if (!it4.hasNext()) {
                                                sQLiteDatabase = sQLiteDatabaseZze;
                                                Iterator it5 = zzfdVar2.zzc().iterator();
                                                while (true) {
                                                    if (it5.hasNext()) {
                                                        com.google.android.gms.internal.measurement.zzfn zzfnVar = (com.google.android.gms.internal.measurement.zzfn) it5.next();
                                                        zzaw();
                                                        zzg();
                                                        Preconditions.checkNotEmpty(str);
                                                        Preconditions.checkNotNull(zzfnVar);
                                                        if (zzfnVar.zzc().isEmpty()) {
                                                            this.zzu.zzaV().zze().zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzgu.zzl(str), Integer.valueOf(iZzb), String.valueOf(zzfnVar.zza() ? Integer.valueOf(zzfnVar.zzb()) : null));
                                                        } else {
                                                            byte[] bArrZzcc = zzfnVar.zzcc();
                                                            ContentValues contentValues = new ContentValues();
                                                            contentValues.put(str2, str);
                                                            String str3 = str2;
                                                            contentValues.put("audience_id", Integer.valueOf(iZzb));
                                                            contentValues.put("filter_id", zzfnVar.zza() ? Integer.valueOf(zzfnVar.zzb()) : null);
                                                            Iterator it6 = it5;
                                                            contentValues.put("property_name", zzfnVar.zzc());
                                                            contentValues.put("session_scoped", zzfnVar.zzg() ? Boolean.valueOf(zzfnVar.zzh()) : null);
                                                            contentValues.put("data", bArrZzcc);
                                                            try {
                                                                if (zze().insertWithOnConflict("property_filters", null, contentValues, 5) == -1) {
                                                                    this.zzu.zzaV().zzb().zzb("Failed to insert property filter (got -1). appId", zzgu.zzl(str));
                                                                } else {
                                                                    str2 = str3;
                                                                    it5 = it6;
                                                                }
                                                            } catch (SQLiteException e) {
                                                                this.zzu.zzaV().zzb().zzc("Error storing property filter. appId", zzgu.zzl(str), e);
                                                            }
                                                        }
                                                    }
                                                    sQLiteDatabaseZze = sQLiteDatabase;
                                                    break;
                                                }
                                            }
                                            com.google.android.gms.internal.measurement.zzff zzffVar = (com.google.android.gms.internal.measurement.zzff) it4.next();
                                            zzaw();
                                            zzg();
                                            Preconditions.checkNotEmpty(str);
                                            Preconditions.checkNotNull(zzffVar);
                                            if (!zzffVar.zzc().isEmpty()) {
                                                byte[] bArrZzcc2 = zzffVar.zzcc();
                                                sQLiteDatabase = sQLiteDatabaseZze;
                                                ContentValues contentValues2 = new ContentValues();
                                                contentValues2.put("app_id", str);
                                                contentValues2.put("audience_id", Integer.valueOf(iZzb));
                                                contentValues2.put("filter_id", zzffVar.zza() ? Integer.valueOf(zzffVar.zzb()) : null);
                                                contentValues2.put("event_name", zzffVar.zzc());
                                                contentValues2.put("session_scoped", zzffVar.zzk() ? Boolean.valueOf(zzffVar.zzm()) : null);
                                                contentValues2.put("data", bArrZzcc2);
                                                try {
                                                    if (zze().insertWithOnConflict("event_filters", null, contentValues2, 5) == -1) {
                                                        this.zzu.zzaV().zzb().zzb("Failed to insert event filter (got -1). appId", zzgu.zzl(str));
                                                    }
                                                    zzfdVar = zzfdVar2;
                                                    sQLiteDatabaseZze = sQLiteDatabase;
                                                } catch (SQLiteException e2) {
                                                    this.zzu.zzaV().zzb().zzc("Error storing event filter. appId", zzgu.zzl(str), e2);
                                                    zzaw();
                                                    zzg();
                                                    Preconditions.checkNotEmpty(str);
                                                    SQLiteDatabase sQLiteDatabaseZze3 = zze();
                                                    sQLiteDatabaseZze3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iZzb)});
                                                    sQLiteDatabaseZze3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iZzb)});
                                                    sQLiteDatabaseZze = sQLiteDatabase;
                                                    break;
                                                }
                                            } else {
                                                this.zzu.zzaV().zze().zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzgu.zzl(str), Integer.valueOf(iZzb), String.valueOf(zzffVar.zza() ? Integer.valueOf(zzffVar.zzb()) : null));
                                                sQLiteDatabase = sQLiteDatabaseZze;
                                            }
                                            zzaw();
                                            zzg();
                                            Preconditions.checkNotEmpty(str);
                                            SQLiteDatabase sQLiteDatabaseZze4 = zze();
                                            sQLiteDatabaseZze4.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iZzb)});
                                            sQLiteDatabaseZze4.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iZzb)});
                                            sQLiteDatabaseZze = sQLiteDatabase;
                                            break;
                                            break;
                                        } catch (Throwable th) {
                                            th = th;
                                            sQLiteDatabase.endTransaction();
                                            throw th;
                                        }
                                    }
                                }
                                if (!((com.google.android.gms.internal.measurement.zzfn) it3.next()).zza()) {
                                    this.zzu.zzaV().zze().zzc("Property filter with no ID. Audience definition ignored. appId, audienceId", zzgu.zzl(str), Integer.valueOf(iZzb));
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    this.zzu.zzaV().zze().zzb("Audience with no ID. appId", zzgu.zzl(str));
                }
            }
            sQLiteDatabase = sQLiteDatabaseZze;
            ArrayList arrayList = new ArrayList();
            Iterator it7 = list.iterator();
            while (it7.hasNext()) {
                com.google.android.gms.internal.measurement.zzfd zzfdVar3 = (com.google.android.gms.internal.measurement.zzfd) it7.next();
                arrayList.add(zzfdVar3.zza() ? Integer.valueOf(zzfdVar3.zzb()) : null);
            }
            Preconditions.checkNotEmpty(str);
            zzaw();
            zzg();
            SQLiteDatabase sQLiteDatabaseZze5 = zze();
            try {
                long jZzay = zzay("select count(1) from audience_filter_values where app_id=?", new String[]{str});
                int iMax = Math.max(0, Math.min(2000, this.zzu.zzc().zzm(str, zzfy.zzU)));
                if (jZzay > iMax) {
                    ArrayList arrayList2 = new ArrayList();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= arrayList.size()) {
                            String strJoin = TextUtils.join(",", arrayList2);
                            StringBuilder sb = new StringBuilder(String.valueOf(strJoin).length() + 2);
                            sb.append("(");
                            sb.append(strJoin);
                            sb.append(")");
                            String string = sb.toString();
                            StringBuilder sb2 = new StringBuilder(string.length() + 140);
                            sb2.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
                            sb2.append(string);
                            sb2.append(" order by rowid desc limit -1 offset ?)");
                            sQLiteDatabaseZze5.delete("audience_filter_values", sb2.toString(), new String[]{str, Integer.toString(iMax)});
                            break;
                        }
                        Integer num = (Integer) arrayList.get(i5);
                        if (num == null) {
                            break;
                        }
                        arrayList2.add(Integer.toString(num.intValue()));
                        i5++;
                    }
                }
            } catch (SQLiteException e3) {
                this.zzu.zzaV().zzb().zzc("Database error querying filters. appId", zzgu.zzl(str), e3);
            }
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = sQLiteDatabaseZze;
        }
    }

    final zzbc zzaf(String str, com.google.android.gms.internal.measurement.zzhs zzhsVar, String str2) throws Throwable {
        zzbc zzbcVarZzaC = zzaC("events", str, zzhsVar.zzd());
        if (zzbcVarZzaC == null) {
            zzic zzicVar = this.zzu;
            zzicVar.zzaV().zze().zzc("Event aggregate wasn't created during raw event logging. appId, event", zzgu.zzl(str), zzicVar.zzl().zza(str2));
            return new zzbc(str, zzhsVar.zzd(), 1L, 1L, 1L, zzhsVar.zzf(), 0L, null, null, null, null);
        }
        long j = zzbcVarZzaC.zze + 1;
        long j2 = zzbcVarZzaC.zzd + 1;
        return new zzbc(zzbcVarZzaC.zza, zzbcVarZzaC.zzb, zzbcVarZzaC.zzc + 1, j2, j, zzbcVarZzaC.zzf, zzbcVarZzaC.zzg, zzbcVarZzaC.zzh, zzbcVarZzaC.zzi, zzbcVarZzaC.zzj, zzbcVarZzaC.zzk);
    }

    protected final boolean zzag() {
        zzic zzicVar = this.zzu;
        Context contextZzaY = zzicVar.zzaY();
        zzicVar.zzc();
        return contextZzaY.getDatabasePath("google_app_measurement.db").exists();
    }

    final /* synthetic */ long zzah(String str, String[] strArr, long j) {
        return zzaz("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", strArr, -1L);
    }

    final /* synthetic */ zzog zzas() {
        return this.zzn;
    }

    /* JADX WARN: Code duplicated, block: B:117:0x0296  */
    /* JADX WARN: Code duplicated, block: B:120:0x029c  */
    /* JADX WARN: Code duplicated, block: B:135:0x022c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:136:0x020e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x00ee A[Catch: all -> 0x025b, SQLiteException -> 0x025e, TryCatch #11 {SQLiteException -> 0x025e, all -> 0x025b, blocks: (B:36:0x00e8, B:38:0x00ee, B:39:0x0104, B:40:0x0108, B:41:0x0118, B:43:0x011e, B:44:0x0131, B:47:0x014c, B:58:0x017e, B:61:0x0186, B:52:0x016b, B:64:0x019e, B:65:0x01ab), top: B:134:0x00e8 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0104 A[Catch: all -> 0x025b, SQLiteException -> 0x025e, TRY_LEAVE, TryCatch #11 {SQLiteException -> 0x025e, all -> 0x025b, blocks: (B:36:0x00e8, B:38:0x00ee, B:39:0x0104, B:40:0x0108, B:41:0x0118, B:43:0x011e, B:44:0x0131, B:47:0x014c, B:58:0x017e, B:61:0x0186, B:52:0x016b, B:64:0x019e, B:65:0x01ab), top: B:134:0x00e8 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x011e A[Catch: all -> 0x025b, SQLiteException -> 0x025e, TryCatch #11 {SQLiteException -> 0x025e, all -> 0x025b, blocks: (B:36:0x00e8, B:38:0x00ee, B:39:0x0104, B:40:0x0108, B:41:0x0118, B:43:0x011e, B:44:0x0131, B:47:0x014c, B:58:0x017e, B:61:0x0186, B:52:0x016b, B:64:0x019e, B:65:0x01ab), top: B:134:0x00e8 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x014c A[Catch: all -> 0x025b, SQLiteException -> 0x025e, TRY_ENTER, TryCatch #11 {SQLiteException -> 0x025e, all -> 0x025b, blocks: (B:36:0x00e8, B:38:0x00ee, B:39:0x0104, B:40:0x0108, B:41:0x0118, B:43:0x011e, B:44:0x0131, B:47:0x014c, B:58:0x017e, B:61:0x0186, B:52:0x016b, B:64:0x019e, B:65:0x01ab), top: B:134:0x00e8 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x0162  */
    /* JADX WARN: Code duplicated, block: B:51:0x0166  */
    /* JADX WARN: Code duplicated, block: B:52:0x016b A[Catch: all -> 0x025b, SQLiteException -> 0x025e, TryCatch #11 {SQLiteException -> 0x025e, all -> 0x025b, blocks: (B:36:0x00e8, B:38:0x00ee, B:39:0x0104, B:40:0x0108, B:41:0x0118, B:43:0x011e, B:44:0x0131, B:47:0x014c, B:58:0x017e, B:61:0x0186, B:52:0x016b, B:64:0x019e, B:65:0x01ab), top: B:134:0x00e8 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x0172  */
    /* JADX WARN: Code duplicated, block: B:59:0x0183 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x0185  */
    /* JADX WARN: Code duplicated, block: B:62:0x0194  */
    /* JADX WARN: Code duplicated, block: B:64:0x019e A[Catch: all -> 0x025b, SQLiteException -> 0x025e, TryCatch #11 {SQLiteException -> 0x025e, all -> 0x025b, blocks: (B:36:0x00e8, B:38:0x00ee, B:39:0x0104, B:40:0x0108, B:41:0x0118, B:43:0x011e, B:44:0x0131, B:47:0x014c, B:58:0x017e, B:61:0x0186, B:52:0x016b, B:64:0x019e, B:65:0x01ab), top: B:134:0x00e8 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x01ab A[Catch: all -> 0x025b, SQLiteException -> 0x025e, TRY_LEAVE, TryCatch #11 {SQLiteException -> 0x025e, all -> 0x025b, blocks: (B:36:0x00e8, B:38:0x00ee, B:39:0x0104, B:40:0x0108, B:41:0x0118, B:43:0x011e, B:44:0x0131, B:47:0x014c, B:58:0x017e, B:61:0x0186, B:52:0x016b, B:64:0x019e, B:65:0x01ab), top: B:134:0x00e8 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x01de  */
    /* JADX WARN: Code duplicated, block: B:81:0x0226 A[Catch: all -> 0x0243, SQLiteException -> 0x027d, PHI: r9
  0x0226: PHI (r9v13 int) = (r9v12 int), (r9v15 int) binds: [B:80:0x0211, B:77:0x020c] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {all -> 0x0243, blocks: (B:3:0x0016, B:8:0x002b, B:12:0x0046, B:70:0x01d8, B:73:0x01e0, B:74:0x01e8, B:76:0x01f4, B:81:0x0226, B:80:0x0211, B:85:0x0231, B:114:0x0280, B:9:0x003a, B:23:0x007d, B:27:0x0090, B:24:0x0088), top: B:123:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x022e A[LOOP:0: B:73:0x01e0->B:84:0x022e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:85:0x0231 A[Catch: all -> 0x0243, SQLiteException -> 0x027d, TRY_LEAVE, TryCatch #2 {all -> 0x0243, blocks: (B:3:0x0016, B:8:0x002b, B:12:0x0046, B:70:0x01d8, B:73:0x01e0, B:74:0x01e8, B:76:0x01f4, B:81:0x0226, B:80:0x0211, B:85:0x0231, B:114:0x0280, B:9:0x003a, B:23:0x007d, B:27:0x0090, B:24:0x0088), top: B:123:0x0016 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r23v1 */
    /* JADX WARN: Type inference failed for: r23v2 */
    /* JADX WARN: Type inference failed for: r23v3 */
    /* JADX WARN: Type inference failed for: r23v4 */
    /* JADX WARN: Type inference failed for: r23v5 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v31, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    public final void zzat(String str, long j, long j2, zzpc zzpcVar) throws Throwable {
        String string;
        ?? r6;
        ?? r3;
        String str2;
        Cursor cursorRawQuery;
        String string2;
        ?? r4;
        ?? r23;
        Cursor cursorQuery;
        zzic zzicVar;
        int i;
        int i2;
        String[] strArr;
        String[] strArr2;
        Cursor cursorQuery2;
        int i3;
        long j3;
        int i4;
        com.google.android.gms.internal.measurement.zzhr zzhrVar;
        long jZzaz;
        long j4;
        long j5;
        Preconditions.checkNotNull(zzpcVar);
        zzg();
        zzaw();
        ?? RawQuery = "select metadata_fingerprint from raw_events where app_id = ?";
        ?? r7 = 0;
        ?? r8 = 0;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseZze = zze();
                try {
                    try {
                        if (TextUtils.isEmpty(str)) {
                            String[] strArr3 = j2 != -1 ? new String[]{String.valueOf(j2), String.valueOf(j)} : new String[]{String.valueOf(j)};
                            str2 = j2 != -1 ? "rowid <= ? and " : "";
                            StringBuilder sb = new StringBuilder(str2.length() + 148);
                            sb.append("select app_id, metadata_fingerprint from raw_events where ");
                            sb.append(str2);
                            sb.append("app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;");
                            RawQuery = sQLiteDatabaseZze.rawQuery(sb.toString(), strArr3);
                            if (RawQuery.moveToFirst()) {
                                string = RawQuery.getString(0);
                                try {
                                    string2 = RawQuery.getString(1);
                                    RawQuery.close();
                                    r4 = RawQuery;
                                    try {
                                        r23 = r4;
                                        str = string;
                                        try {
                                            cursorQuery = sQLiteDatabaseZze.query("raw_events_metadata", new String[]{TtmlNode.TAG_METADATA}, "app_id = ? and metadata_fingerprint = ?", new String[]{string, string2}, null, null, "rowid", ExifInterface.GPS_MEASUREMENT_2D);
                                            try {
                                                if (cursorQuery.moveToFirst()) {
                                                    try {
                                                        com.google.android.gms.internal.measurement.zzid zzidVar = (com.google.android.gms.internal.measurement.zzid) ((com.google.android.gms.internal.measurement.zzic) zzpk.zzw(com.google.android.gms.internal.measurement.zzid.zzaE(), cursorQuery.getBlob(0))).zzbc();
                                                        if (cursorQuery.moveToNext()) {
                                                            this.zzu.zzaV().zze().zzb("Get multiple raw event metadata records, expected one. appId", zzgu.zzl(str));
                                                        }
                                                        cursorQuery.close();
                                                        Preconditions.checkNotNull(zzidVar);
                                                        zzpcVar.zza = zzidVar;
                                                        zzicVar = this.zzu;
                                                        String str3 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
                                                        if (zzicVar.zzc().zzp(null, zzfy.zzbk)) {
                                                            i = 1;
                                                            i2 = 0;
                                                            jZzaz = zzaz("select (rowid - 1) as max_rowid from raw_events where app_id = ? and metadata_fingerprint != ? order by rowid limit 1;", new String[]{str, string2}, -1L);
                                                            if (j2 == -1) {
                                                                j4 = -1;
                                                                j5 = j2;
                                                            } else if (jZzaz != -1) {
                                                                j5 = -1;
                                                                j4 = -1;
                                                            } else {
                                                                strArr = new String[]{str, string2};
                                                            }
                                                            if (j5 == j4 && jZzaz != j4) {
                                                                jZzaz = Math.min(j5, jZzaz);
                                                            } else if (j5 != j4) {
                                                                jZzaz = j5;
                                                            }
                                                            strArr2 = new String[]{str, string2, String.valueOf(jZzaz)};
                                                            String[] strArr4 = new String[4];
                                                            strArr4[i2] = "rowid";
                                                            strArr4[i] = "name";
                                                            strArr4[2] = SDKConstants.PARAM_DEBUG_MESSAGE_TIMESTAMP;
                                                            strArr4[3] = "data";
                                                            cursorQuery2 = sQLiteDatabaseZze.query("raw_events", strArr4, str3, strArr2, null, null, "rowid", null);
                                                            if (cursorQuery2.moveToFirst()) {
                                                                i3 = i2;
                                                                while (true) {
                                                                    j3 = cursorQuery2.getLong(i3);
                                                                    try {
                                                                        zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzpk.zzw(com.google.android.gms.internal.measurement.zzhs.zzk(), cursorQuery2.getBlob(3));
                                                                        i4 = i;
                                                                        zzhrVar.zzl(cursorQuery2.getString(i4));
                                                                        zzhrVar.zzo(cursorQuery2.getLong(2));
                                                                        if (!zzpcVar.zza(j3, (com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbc())) {
                                                                            r6 = cursorQuery2;
                                                                            break;
                                                                        } else {
                                                                            if (!cursorQuery2.moveToNext()) {
                                                                                r6 = cursorQuery2;
                                                                                break;
                                                                            }
                                                                            i = i4;
                                                                        }
                                                                    } catch (IOException e) {
                                                                        i4 = i;
                                                                        this.zzu.zzaV().zzb().zzc("Data loss. Failed to merge raw event. appId", zzgu.zzl(str), e);
                                                                    }
                                                                }
                                                            } else {
                                                                zzicVar.zzaV().zze().zzb("Raw event data disappeared while in transaction. appId", zzgu.zzl(str));
                                                                r6 = cursorQuery2;
                                                            }
                                                            r3 = r6;
                                                        } else {
                                                            i = 1;
                                                            i2 = 0;
                                                            if (j2 != -1) {
                                                                strArr = new String[]{str, string2, String.valueOf(j2)};
                                                            } else {
                                                                strArr = new String[]{str, string2};
                                                            }
                                                            strArr2 = strArr;
                                                            String[] strArr5 = new String[4];
                                                            strArr5[i2] = "rowid";
                                                            strArr5[i] = "name";
                                                            strArr5[2] = SDKConstants.PARAM_DEBUG_MESSAGE_TIMESTAMP;
                                                            strArr5[3] = "data";
                                                            cursorQuery2 = sQLiteDatabaseZze.query("raw_events", strArr5, str3, strArr2, null, null, "rowid", null);
                                                            if (cursorQuery2.moveToFirst()) {
                                                                i3 = i2;
                                                                while (true) {
                                                                    j3 = cursorQuery2.getLong(i3);
                                                                    zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzpk.zzw(com.google.android.gms.internal.measurement.zzhs.zzk(), cursorQuery2.getBlob(3));
                                                                    i4 = i;
                                                                    zzhrVar.zzl(cursorQuery2.getString(i4));
                                                                    zzhrVar.zzo(cursorQuery2.getLong(2));
                                                                    if (!zzpcVar.zza(j3, (com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbc())) {
                                                                        r6 = cursorQuery2;
                                                                        break;
                                                                    } else {
                                                                        if (!cursorQuery2.moveToNext()) {
                                                                            r6 = cursorQuery2;
                                                                            break;
                                                                        }
                                                                        i = i4;
                                                                    }
                                                                }
                                                            } else {
                                                                zzicVar.zzaV().zze().zzb("Raw event data disappeared while in transaction. appId", zzgu.zzl(str));
                                                                r6 = cursorQuery2;
                                                            }
                                                            r3 = r6;
                                                        }
                                                        str3 = "app_id = ? and metadata_fingerprint = ?";
                                                        strArr2 = strArr;
                                                        String[] strArr6 = new String[4];
                                                        strArr6[i2] = "rowid";
                                                        strArr6[i] = "name";
                                                        strArr6[2] = SDKConstants.PARAM_DEBUG_MESSAGE_TIMESTAMP;
                                                        strArr6[3] = "data";
                                                        cursorQuery2 = sQLiteDatabaseZze.query("raw_events", strArr6, str3, strArr2, null, null, "rowid", null);
                                                        if (cursorQuery2.moveToFirst()) {
                                                            i3 = i2;
                                                            while (true) {
                                                                j3 = cursorQuery2.getLong(i3);
                                                                zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzpk.zzw(com.google.android.gms.internal.measurement.zzhs.zzk(), cursorQuery2.getBlob(3));
                                                                i4 = i;
                                                                zzhrVar.zzl(cursorQuery2.getString(i4));
                                                                zzhrVar.zzo(cursorQuery2.getLong(2));
                                                                if (!zzpcVar.zza(j3, (com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbc())) {
                                                                    r6 = cursorQuery2;
                                                                    break;
                                                                } else {
                                                                    if (!cursorQuery2.moveToNext()) {
                                                                        r6 = cursorQuery2;
                                                                        break;
                                                                    }
                                                                    i = i4;
                                                                }
                                                            }
                                                        } else {
                                                            zzicVar.zzaV().zze().zzb("Raw event data disappeared while in transaction. appId", zzgu.zzl(str));
                                                            r6 = cursorQuery2;
                                                        }
                                                        r3 = r6;
                                                    } catch (IOException e2) {
                                                        r3 = cursorQuery;
                                                        this.zzu.zzaV().zzb().zzc("Data loss. Failed to merge raw event metadata. appId", zzgu.zzl(str), e2);
                                                    }
                                                } else {
                                                    this.zzu.zzaV().zzb().zzb("Raw event metadata record is missing. appId", zzgu.zzl(str));
                                                    r3 = cursorQuery;
                                                }
                                            } catch (SQLiteException e3) {
                                                e = e3;
                                                RawQuery = cursorQuery;
                                                string = str;
                                                r7 = RawQuery;
                                                this.zzu.zzaV().zzb().zzc("Data loss. Error selecting raw event. appId", zzgu.zzl(string), e);
                                                r6 = r7;
                                            } catch (Throwable th) {
                                                th = th;
                                                RawQuery = cursorQuery;
                                                r8 = RawQuery;
                                                if (r8 != 0) {
                                                    r8.close();
                                                }
                                                throw th;
                                            }
                                        } catch (SQLiteException e4) {
                                            e = e4;
                                            string = str;
                                            r7 = r23;
                                            this.zzu.zzaV().zzb().zzc("Data loss. Error selecting raw event. appId", zzgu.zzl(string), e);
                                            r6 = r7;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            r8 = r23;
                                            if (r8 != 0) {
                                                r8.close();
                                            }
                                            throw th;
                                        }
                                    } catch (SQLiteException e5) {
                                        e = e5;
                                        r23 = r4;
                                        str = string;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        r23 = r4;
                                    }
                                } catch (SQLiteException e6) {
                                    e = e6;
                                    r7 = RawQuery;
                                    this.zzu.zzaV().zzb().zzc("Data loss. Error selecting raw event. appId", zzgu.zzl(string), e);
                                    r6 = r7;
                                    r3 = r6;
                                    if (r3 != 0) {
                                        r3 = cursorRawQuery;
                                        r3 = RawQuery;
                                        return;
                                    } else {
                                        r3 = cursorRawQuery;
                                        r3 = RawQuery;
                                        r3.close();
                                    }
                                }
                            }
                        } else {
                            String[] strArr7 = j2 != -1 ? new String[]{str, String.valueOf(j2)} : new String[]{str};
                            str2 = j2 != -1 ? " and rowid <= ?" : "";
                            StringBuilder sb2 = new StringBuilder(str2.length() + 84);
                            sb2.append("select metadata_fingerprint from raw_events where app_id = ?");
                            sb2.append(str2);
                            sb2.append(" order by rowid limit 1;");
                            cursorRawQuery = sQLiteDatabaseZze.rawQuery(sb2.toString(), strArr7);
                            if (cursorRawQuery.moveToFirst()) {
                                string2 = cursorRawQuery.getString(0);
                                cursorRawQuery.close();
                                string = str;
                                r4 = cursorRawQuery;
                                r23 = r4;
                                str = string;
                                cursorQuery = sQLiteDatabaseZze.query("raw_events_metadata", new String[]{TtmlNode.TAG_METADATA}, "app_id = ? and metadata_fingerprint = ?", new String[]{string, string2}, null, null, "rowid", ExifInterface.GPS_MEASUREMENT_2D);
                                if (cursorQuery.moveToFirst()) {
                                    this.zzu.zzaV().zzb().zzb("Raw event metadata record is missing. appId", zzgu.zzl(str));
                                    r3 = cursorQuery;
                                } else {
                                    com.google.android.gms.internal.measurement.zzid zzidVar2 = (com.google.android.gms.internal.measurement.zzid) ((com.google.android.gms.internal.measurement.zzic) zzpk.zzw(com.google.android.gms.internal.measurement.zzid.zzaE(), cursorQuery.getBlob(0))).zzbc();
                                    if (cursorQuery.moveToNext()) {
                                        this.zzu.zzaV().zze().zzb("Get multiple raw event metadata records, expected one. appId", zzgu.zzl(str));
                                    }
                                    cursorQuery.close();
                                    Preconditions.checkNotNull(zzidVar2);
                                    zzpcVar.zza = zzidVar2;
                                    zzicVar = this.zzu;
                                    String str4 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
                                    if (zzicVar.zzc().zzp(null, zzfy.zzbk)) {
                                        i = 1;
                                        i2 = 0;
                                        jZzaz = zzaz("select (rowid - 1) as max_rowid from raw_events where app_id = ? and metadata_fingerprint != ? order by rowid limit 1;", new String[]{str, string2}, -1L);
                                        if (j2 == -1) {
                                            j4 = -1;
                                            j5 = j2;
                                        } else if (jZzaz != -1) {
                                            j5 = -1;
                                            j4 = -1;
                                        } else {
                                            strArr = new String[]{str, string2};
                                        }
                                        if (j5 == j4) {
                                            if (j5 != j4) {
                                                jZzaz = j5;
                                            }
                                        } else if (j5 != j4) {
                                            jZzaz = j5;
                                        }
                                        strArr2 = new String[]{str, string2, String.valueOf(jZzaz)};
                                        String[] strArr8 = new String[4];
                                        strArr8[i2] = "rowid";
                                        strArr8[i] = "name";
                                        strArr8[2] = SDKConstants.PARAM_DEBUG_MESSAGE_TIMESTAMP;
                                        strArr8[3] = "data";
                                        cursorQuery2 = sQLiteDatabaseZze.query("raw_events", strArr8, str4, strArr2, null, null, "rowid", null);
                                        if (cursorQuery2.moveToFirst()) {
                                            i3 = i2;
                                            while (true) {
                                                j3 = cursorQuery2.getLong(i3);
                                                zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzpk.zzw(com.google.android.gms.internal.measurement.zzhs.zzk(), cursorQuery2.getBlob(3));
                                                i4 = i;
                                                zzhrVar.zzl(cursorQuery2.getString(i4));
                                                zzhrVar.zzo(cursorQuery2.getLong(2));
                                                if (!zzpcVar.zza(j3, (com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbc())) {
                                                    r6 = cursorQuery2;
                                                    break;
                                                } else {
                                                    if (!cursorQuery2.moveToNext()) {
                                                        r6 = cursorQuery2;
                                                        break;
                                                    }
                                                    i = i4;
                                                }
                                            }
                                        } else {
                                            zzicVar.zzaV().zze().zzb("Raw event data disappeared while in transaction. appId", zzgu.zzl(str));
                                            r6 = cursorQuery2;
                                        }
                                        r3 = r6;
                                    } else {
                                        i = 1;
                                        i2 = 0;
                                        if (j2 != -1) {
                                            strArr = new String[]{str, string2, String.valueOf(j2)};
                                        } else {
                                            strArr = new String[]{str, string2};
                                        }
                                        strArr2 = strArr;
                                        String[] strArr9 = new String[4];
                                        strArr9[i2] = "rowid";
                                        strArr9[i] = "name";
                                        strArr9[2] = SDKConstants.PARAM_DEBUG_MESSAGE_TIMESTAMP;
                                        strArr9[3] = "data";
                                        cursorQuery2 = sQLiteDatabaseZze.query("raw_events", strArr9, str4, strArr2, null, null, "rowid", null);
                                        if (cursorQuery2.moveToFirst()) {
                                            i3 = i2;
                                            while (true) {
                                                j3 = cursorQuery2.getLong(i3);
                                                zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzpk.zzw(com.google.android.gms.internal.measurement.zzhs.zzk(), cursorQuery2.getBlob(3));
                                                i4 = i;
                                                zzhrVar.zzl(cursorQuery2.getString(i4));
                                                zzhrVar.zzo(cursorQuery2.getLong(2));
                                                if (!zzpcVar.zza(j3, (com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbc())) {
                                                    r6 = cursorQuery2;
                                                    break;
                                                } else {
                                                    if (!cursorQuery2.moveToNext()) {
                                                        r6 = cursorQuery2;
                                                        break;
                                                    }
                                                    i = i4;
                                                }
                                            }
                                        } else {
                                            zzicVar.zzaV().zze().zzb("Raw event data disappeared while in transaction. appId", zzgu.zzl(str));
                                            r6 = cursorQuery2;
                                        }
                                        r3 = r6;
                                    }
                                    str4 = "app_id = ? and metadata_fingerprint = ?";
                                    strArr2 = strArr;
                                    String[] strArr10 = new String[4];
                                    strArr10[i2] = "rowid";
                                    strArr10[i] = "name";
                                    strArr10[2] = SDKConstants.PARAM_DEBUG_MESSAGE_TIMESTAMP;
                                    strArr10[3] = "data";
                                    cursorQuery2 = sQLiteDatabaseZze.query("raw_events", strArr10, str4, strArr2, null, null, "rowid", null);
                                    if (cursorQuery2.moveToFirst()) {
                                        i3 = i2;
                                        while (true) {
                                            j3 = cursorQuery2.getLong(i3);
                                            zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzpk.zzw(com.google.android.gms.internal.measurement.zzhs.zzk(), cursorQuery2.getBlob(3));
                                            i4 = i;
                                            zzhrVar.zzl(cursorQuery2.getString(i4));
                                            zzhrVar.zzo(cursorQuery2.getLong(2));
                                            if (!zzpcVar.zza(j3, (com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbc())) {
                                                r6 = cursorQuery2;
                                                break;
                                            } else {
                                                if (!cursorQuery2.moveToNext()) {
                                                    r6 = cursorQuery2;
                                                    break;
                                                }
                                                i = i4;
                                            }
                                        }
                                    } else {
                                        zzicVar.zzaV().zze().zzb("Raw event data disappeared while in transaction. appId", zzgu.zzl(str));
                                        r6 = cursorQuery2;
                                    }
                                    r3 = r6;
                                }
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } catch (SQLiteException e7) {
                    e = e7;
                }
            } catch (SQLiteException e8) {
                e = e8;
                string = str;
            }
            if (r3 != 0) {
                r3 = cursorRawQuery;
                r3 = RawQuery;
                return;
            } else {
                r3 = cursorRawQuery;
                r3 = RawQuery;
                r3.close();
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public final void zzb() {
        zzaw();
        zze().beginTransaction();
    }

    @Override // com.google.android.gms.measurement.internal.zzos
    protected final boolean zzbb() {
        return false;
    }

    public final void zzc() {
        zzaw();
        zze().setTransactionSuccessful();
    }

    public final void zzd() {
        zzaw();
        zze().endTransaction();
    }

    final SQLiteDatabase zze() {
        zzg();
        try {
            return this.zzm.getWritableDatabase();
        } catch (SQLiteException e) {
            this.zzu.zzaV().zze().zzb("Error opening database", e);
            throw e;
        }
    }

    public final zzbc zzf(String str, String str2) {
        return zzaC("events", str, str2);
    }

    public final void zzh(zzbc zzbcVar) {
        zzaD("events", zzbcVar);
    }

    public final void zzi(String str) {
        zzbc zzbcVarZzaC;
        zzaE("events_snapshot", str);
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = zze().query("events", (String[]) Collections.singletonList("name").toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(0);
                        if (string != null && (zzbcVarZzaC = zzaC("events", str, string)) != null) {
                            zzaD("events_snapshot", zzbcVarZzaC);
                        }
                    } while (cursorQuery.moveToNext());
                }
            } catch (SQLiteException e) {
                this.zzu.zzaV().zzb().zzc("Error creating snapshot. appId", zzgu.zzl(str), e);
            }
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:51:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:56:0x00db A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x00dd A[ADDED_TO_REGION] */
    public final void zzj(String str) throws Throwable {
        boolean z;
        zzbc zzbcVarZzaC;
        boolean z2 = false;
        ArrayList arrayList = new ArrayList(Arrays.asList("name", "lifetime_count"));
        zzbc zzbcVarZzaC2 = zzaC("events", str, "_f");
        zzbc zzbcVarZzaC3 = zzaC("events", str, "_v");
        zzaE("events", str);
        Cursor cursorQuery = null;
        try {
            cursorQuery = zze().query("events_snapshot", (String[]) arrayList.toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
            if (cursorQuery.moveToFirst()) {
                boolean z3 = false;
                z = false;
                do {
                    try {
                        String string = cursorQuery.getString(0);
                        if (cursorQuery.getLong(1) >= 1) {
                            if ("_f".equals(string)) {
                                z3 = true;
                            } else if ("_v".equals(string)) {
                                z = true;
                            }
                        }
                        if (string != null && (zzbcVarZzaC = zzaC("events_snapshot", str, string)) != null) {
                            zzaD("events", zzbcVarZzaC);
                        }
                    } catch (SQLiteException e) {
                        e = e;
                        z2 = z3;
                        try {
                            this.zzu.zzaV().zzb().zzc("Error querying snapshot. appId", zzgu.zzl(str), e);
                            z3 = z2;
                        } catch (Throwable th) {
                            th = th;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            if (z2 && zzbcVarZzaC2 != null) {
                                zzaD("events", zzbcVarZzaC2);
                            } else if (!z && zzbcVarZzaC3 != null) {
                                zzaD("events", zzbcVarZzaC3);
                            }
                            zzaE("events_snapshot", str);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        z2 = z3;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        if (z2) {
                            if (!z) {
                                zzaD("events", zzbcVarZzaC3);
                            }
                        } else if (!z) {
                            zzaD("events", zzbcVarZzaC3);
                        }
                        zzaE("events_snapshot", str);
                        throw th;
                    }
                } while (cursorQuery.moveToNext());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (!z3 && zzbcVarZzaC2 != null) {
                    zzaD("events", zzbcVarZzaC2);
                } else if (!z && zzbcVarZzaC3 != null) {
                    zzaD("events", zzbcVarZzaC3);
                }
            } else {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (zzbcVarZzaC2 != null) {
                    zzaD("events", zzbcVarZzaC2);
                } else if (zzbcVarZzaC3 != null) {
                    zzaD("events", zzbcVarZzaC3);
                }
            }
        } catch (SQLiteException e2) {
            e = e2;
            z = false;
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
        zzaE("events_snapshot", str);
    }

    public final void zzk(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzaw();
        try {
            zze().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzic zzicVar = this.zzu;
            zzicVar.zzaV().zzb().zzd("Error deleting user property. appId", zzgu.zzl(str), zzicVar.zzl().zzc(str2), e);
        }
    }

    public final boolean zzl(zzpn zzpnVar) {
        Preconditions.checkNotNull(zzpnVar);
        zzg();
        zzaw();
        String str = zzpnVar.zza;
        String str2 = zzpnVar.zzc;
        if (zzm(str, str2) == null) {
            if (zzpp.zzh(str2)) {
                if (zzay("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{str}) >= this.zzu.zzc().zzn(str, zzfy.zzV, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(str2)) {
                long jZzay = zzay("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{str, zzpnVar.zzb});
                this.zzu.zzc();
                if (jZzay >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzpnVar.zzb);
        contentValues.put("name", str2);
        contentValues.put("set_timestamp", Long.valueOf(zzpnVar.zzd));
        zzau(contentValues, "value", zzpnVar.zze);
        try {
            if (zze().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                this.zzu.zzaV().zzb().zzb("Failed to insert/update user property (got -1). appId", zzgu.zzl(str));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzc("Error storing user property. appId", zzgu.zzl(zzpnVar.zza), e);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:42:? A[SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00a3: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:32:0x00a2 */
    public final zzpn zzm(String str, String str2) {
        Throwable th;
        String str3;
        String str4;
        SQLiteException sQLiteException;
        Cursor cursorQuery;
        Cursor cursor;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzaw();
        Cursor cursor2 = null;
        try {
            try {
                cursorQuery = zze().query("user_attributes", new String[]{"set_timestamp", "value", "origin"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (cursorQuery.moveToFirst()) {
                        long j = cursorQuery.getLong(0);
                        Object objZzL = zzL(cursorQuery, 1);
                        if (objZzL != null) {
                            str3 = str;
                            str4 = str2;
                            try {
                                zzpn zzpnVar = new zzpn(str3, cursorQuery.getString(2), str4, j, objZzL);
                                if (cursorQuery.moveToNext()) {
                                    this.zzu.zzaV().zzb().zzb("Got multiple records for user property, expected one. appId", zzgu.zzl(str3));
                                }
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                return zzpnVar;
                            } catch (SQLiteException e) {
                                e = e;
                            }
                        }
                        sQLiteException = e;
                        zzic zzicVar = this.zzu;
                        zzicVar.zzaV().zzb().zzd("Error querying user property. appId", zzgu.zzl(str3), zzicVar.zzl().zzc(str4), sQLiteException);
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    str3 = str;
                    str4 = str2;
                }
            } catch (SQLiteException e3) {
                str3 = str;
                str4 = str2;
                sQLiteException = e3;
                cursorQuery = null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor2 != null) {
                    throw th;
                }
                cursor2.close();
                throw th;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            cursor2 = cursor;
            if (cursor2 != null) {
                throw th;
            }
            cursor2.close();
            throw th;
        }
    }

    public final List zzn(String str) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzaw();
        List arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                zzic zzicVar = this.zzu;
                zzicVar.zzc();
                cursorQuery = zze().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(0);
                        String string2 = cursorQuery.getString(1);
                        if (string2 == null) {
                            string2 = "";
                        }
                        String str2 = string2;
                        long j = cursorQuery.getLong(2);
                        Object objZzL = zzL(cursorQuery, 3);
                        if (objZzL == null) {
                            zzicVar.zzaV().zzb().zzb("Read invalid user property value, ignoring it. appId", zzgu.zzl(str));
                        } else {
                            arrayList.add(new zzpn(str, str2, string, j, objZzL));
                        }
                    } while (cursorQuery.moveToNext());
                }
            } catch (SQLiteException e) {
                this.zzu.zzaV().zzb().zzc("Error querying user properties. appId", zzgu.zzl(str), e);
                arrayList = Collections.emptyList();
            }
            return arrayList;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0140  */
    /* JADX WARN: Code duplicated, block: B:51:0x0147  */
    public final List zzo(String str, String str2, String str3) throws Throwable {
        Cursor cursor;
        String str4;
        Cursor cursorQuery;
        String str5;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzaw();
        List arrayList = new ArrayList();
        try {
            try {
                ArrayList arrayList2 = new ArrayList(3);
                String str6 = str;
                arrayList2.add(str6);
                StringBuilder sb = new StringBuilder("app_id=?");
                if (TextUtils.isEmpty(str2)) {
                    str4 = str2;
                } else {
                    str4 = str2;
                    try {
                        arrayList2.add(str4);
                        sb.append(" and origin=?");
                    } catch (SQLiteException e) {
                        e = e;
                        cursor = null;
                        try {
                            this.zzu.zzaV().zzb().zzd("(2)Error querying user properties", zzgu.zzl(str), str4, e);
                            arrayList = Collections.emptyList();
                            cursorQuery = cursor;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return arrayList;
                        } catch (Throwable th) {
                            th = th;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 1);
                    sb2.append(str3);
                    sb2.append(ProxyConfig.MATCH_ALL_SCHEMES);
                    arrayList2.add(sb2.toString());
                    sb.append(" and name glob ?");
                }
                String[] strArr = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
                String string = sb.toString();
                zzic zzicVar = this.zzu;
                zzicVar.zzc();
                cursorQuery = zze().query("user_attributes", new String[]{"name", "set_timestamp", "value", "origin"}, string, strArr, null, null, "rowid", "1001");
                try {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            while (true) {
                                int size = arrayList.size();
                                zzicVar.zzc();
                                if (size >= 1000) {
                                    zzgs zzgsVarZzb = zzicVar.zzaV().zzb();
                                    zzicVar.zzc();
                                    zzgsVarZzb.zzb("Read more than the max allowed user properties, ignoring excess", 1000);
                                    break;
                                }
                                String string2 = cursorQuery.getString(0);
                                long j = cursorQuery.getLong(1);
                                Object objZzL = zzL(cursorQuery, 2);
                                String string3 = cursorQuery.getString(3);
                                if (objZzL == null) {
                                    try {
                                        zzicVar.zzaV().zzb().zzd("(2)Read invalid user property value, ignoring it", zzgu.zzl(str6), string3, str3);
                                        str5 = string3;
                                    } catch (SQLiteException e2) {
                                        e = e2;
                                        str5 = string3;
                                        cursor = cursorQuery;
                                        str4 = str5;
                                        this.zzu.zzaV().zzb().zzd("(2)Error querying user properties", zzgu.zzl(str), str4, e);
                                        arrayList = Collections.emptyList();
                                        cursorQuery = cursor;
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        return arrayList;
                                    }
                                } else {
                                    str5 = string3;
                                    arrayList.add(new zzpn(str6, str5, string2, j, objZzL));
                                }
                                try {
                                    if (!cursorQuery.moveToNext()) {
                                        break;
                                    }
                                    str6 = str;
                                    str4 = str5;
                                } catch (SQLiteException e3) {
                                    e = e3;
                                    cursor = cursorQuery;
                                    str4 = str5;
                                    this.zzu.zzaV().zzb().zzd("(2)Error querying user properties", zzgu.zzl(str), str4, e);
                                    arrayList = Collections.emptyList();
                                    cursorQuery = cursor;
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (SQLiteException e4) {
                    e = e4;
                    cursor = cursorQuery;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
        } catch (SQLiteException e5) {
            e = e5;
            str4 = str2;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return arrayList;
    }

    public final boolean zzp(zzah zzahVar) {
        Preconditions.checkNotNull(zzahVar);
        zzg();
        zzaw();
        String str = zzahVar.zza;
        Preconditions.checkNotNull(str);
        if (zzm(str, zzahVar.zzc.zzb) == null) {
            long jZzay = zzay("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            this.zzu.zzc();
            if (jZzay >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzahVar.zzb);
        contentValues.put("name", zzahVar.zzc.zzb);
        zzau(contentValues, "value", Preconditions.checkNotNull(zzahVar.zzc.zza()));
        contentValues.put("active", Boolean.valueOf(zzahVar.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzahVar.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzahVar.zzh));
        zzic zzicVar = this.zzu;
        contentValues.put("timed_out_event", zzicVar.zzk().zzae(zzahVar.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzahVar.zzd));
        contentValues.put("triggered_event", zzicVar.zzk().zzae(zzahVar.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzahVar.zzc.zzc));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzahVar.zzj));
        contentValues.put("expired_event", zzicVar.zzk().zzae(zzahVar.zzk));
        try {
            if (zze().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzicVar.zzaV().zzb().zzb("Failed to insert/update conditional user property (got -1)", zzgu.zzl(str));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzc("Error storing conditional user property", zzgu.zzl(str), e);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0152  */
    /* JADX WARN: Code duplicated, block: B:45:0x015a  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x0157: MOVE (r8 I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY]), block:B:43:0x0157 */
    /* JADX WARN: Type inference failed for: r33v0, types: [com.google.android.gms.measurement.internal.zzav, com.google.android.gms.measurement.internal.zzje, com.google.android.gms.measurement.internal.zzol, com.google.android.gms.measurement.internal.zzos] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    public final zzah zzq(String str, String str2) throws Throwable {
        zzah zzahVar;
        Object obj;
        ?? r8;
        ?? Query;
        ?? r9;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzaw();
        try {
            try {
                SQLiteDatabase sQLiteDatabaseZze = zze();
                String[] strArr = new String[11];
                strArr[0] = "origin";
                strArr[1] = "value";
                strArr[2] = "active";
                strArr[3] = AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME;
                strArr[4] = AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT;
                strArr[5] = "timed_out_event";
                strArr[6] = AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP;
                strArr[7] = "triggered_event";
                strArr[8] = AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP;
                strArr[9] = AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE;
                zzahVar = null;
                try {
                    strArr[10] = "expired_event";
                    Query = sQLiteDatabaseZze.query("conditional_properties", strArr, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                    try {
                        if (!Query.moveToFirst()) {
                            if (r9 != 0) {
                                r9 = Query;
                                r9.close();
                            }
                            r9 = Query;
                            return zzahVar;
                        }
                        String string = Query.getString(0);
                        if (string == null) {
                            string = "";
                        }
                        Object objZzL = zzL(Query, 1);
                        boolean z = Query.getInt(2) != 0;
                        String string2 = Query.getString(3);
                        long j = Query.getLong(4);
                        zzpg zzpgVar = this.zzg;
                        str2 = str2;
                        String str3 = string;
                        try {
                            zzah zzahVar2 = new zzah(str, str3, new zzpl(str2, Query.getLong(8), objZzL, str3), Query.getLong(6), z, string2, (zzbg) zzpgVar.zzp().zzl(Query.getBlob(5), zzbg.CREATOR), j, (zzbg) zzpgVar.zzp().zzl(Query.getBlob(7), zzbg.CREATOR), Query.getLong(9), (zzbg) zzpgVar.zzp().zzl(Query.getBlob(10), zzbg.CREATOR));
                            if (Query.moveToNext()) {
                                zzic zzicVar = this.zzu;
                                zzicVar.zzaV().zzb().zzc("Got multiple records for conditional property, expected one", zzgu.zzl(str), zzicVar.zzl().zzc(str2));
                            }
                            if (Query != 0) {
                                Query.close();
                            }
                            return zzahVar2;
                        } catch (SQLiteException e) {
                            e = e;
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        str2 = str2;
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                    Query = zzahVar;
                } catch (Throwable th) {
                    th = th;
                    r8 = zzahVar;
                    if (r8 != 0) {
                        r8.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e4) {
                e = e4;
                zzahVar = null;
            } catch (Throwable th2) {
                th = th2;
                zzahVar = null;
            }
            if (r9 != 0) {
                r9 = Query;
                r9.close();
            }
            r9 = Query;
            return zzahVar;
        } catch (Throwable th3) {
            th = th3;
            r8 = obj;
            if (r8 != 0) {
                r8.close();
            }
            throw th;
        }
        zzic zzicVar2 = this.zzu;
        zzicVar2.zzaV().zzb().zzd("Error querying conditional property", zzgu.zzl(str), zzicVar2.zzl().zzc(str2), e);
        r9 = Query;
    }

    public final int zzr(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzaw();
        try {
            return zze().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzic zzicVar = this.zzu;
            zzicVar.zzaV().zzb().zzd("Error deleting conditional property", zzgu.zzl(str), zzicVar.zzl().zzc(str2), e);
            return 0;
        }
    }

    public final List zzs(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzaw();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            String.valueOf(str3);
            arrayList.add(String.valueOf(str3).concat(ProxyConfig.MATCH_ALL_SCHEMES));
            sb.append(" and name glob ?");
        }
        return zzt(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code duplicated, block: B:32:0x016a  */
    /* JADX WARN: Multi-variable type inference failed */
    public final List zzt(String str, String[] strArr) throws Throwable {
        Cursor cursor;
        Cursor cursorQuery;
        zzg();
        zzaw();
        List arrayList = new ArrayList();
        try {
            SQLiteDatabase sQLiteDatabaseZze = zze();
            int i = 0;
            int i2 = 1;
            String[] strArr2 = {"app_id", "origin", "name", "value", "active", AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"};
            zzic zzicVar = this.zzu;
            zzicVar.zzc();
            cursorQuery = sQLiteDatabaseZze.query("conditional_properties", strArr2, str, strArr, null, null, "rowid", "1001");
            try {
                if (cursorQuery.moveToFirst()) {
                    while (true) {
                        int size = arrayList.size();
                        zzicVar.zzc();
                        if (size >= 1000) {
                            zzgs zzgsVarZzb = zzicVar.zzaV().zzb();
                            zzicVar.zzc();
                            zzgsVarZzb.zzb("Read more than the max allowed conditional properties, ignoring extra", 1000);
                            break;
                        }
                        String string = cursorQuery.getString(i);
                        String string2 = cursorQuery.getString(i2);
                        String string3 = cursorQuery.getString(2);
                        Object objZzL = zzL(cursorQuery, 3);
                        boolean z = cursorQuery.getInt(4) != 0 ? i2 : i;
                        String string4 = cursorQuery.getString(5);
                        long j = cursorQuery.getLong(6);
                        zzpg zzpgVar = this.zzg;
                        arrayList.add(new zzah(string, string2, new zzpl(string3, cursorQuery.getLong(10), objZzL, string2), cursorQuery.getLong(8), z, string4, (zzbg) zzpgVar.zzp().zzl(cursorQuery.getBlob(7), zzbg.CREATOR), j, (zzbg) zzpgVar.zzp().zzl(cursorQuery.getBlob(9), zzbg.CREATOR), cursorQuery.getLong(11), (zzbg) zzpgVar.zzp().zzl(cursorQuery.getBlob(12), zzbg.CREATOR)));
                        if (!cursorQuery.moveToNext()) {
                            break;
                        }
                        i = 0;
                        i2 = 1;
                    }
                }
            } catch (SQLiteException e) {
                e = e;
                cursor = cursorQuery;
                try {
                    this.zzu.zzaV().zzb().zzb("Error querying conditional user property value", e);
                    arrayList = Collections.emptyList();
                    cursorQuery = cursor;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:98:0x03bb  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    public final zzh zzu(String str) {
        zzh zzhVar;
        ?? r3;
        ?? Query;
        ?? r4;
        Boolean boolValueOf;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzaw();
        try {
            SQLiteDatabase sQLiteDatabaseZze = zze();
            String[] strArr = new String[45];
            strArr[0] = "app_instance_id";
            strArr[1] = "gmp_app_id";
            strArr[2] = "resettable_device_id_hash";
            strArr[3] = "last_bundle_index";
            strArr[4] = "last_bundle_start_timestamp";
            strArr[5] = "last_bundle_end_timestamp";
            strArr[6] = "app_version";
            strArr[7] = "app_store";
            strArr[8] = "gmp_version";
            strArr[9] = "dev_cert_hash";
            zzhVar = null;
            try {
                strArr[10] = "measurement_enabled";
                strArr[11] = "day";
                strArr[12] = "daily_public_events_count";
                strArr[13] = "daily_events_count";
                strArr[14] = "daily_conversions_count";
                strArr[15] = "config_fetched_time";
                strArr[16] = "failed_config_fetch_time";
                strArr[17] = "app_version_int";
                strArr[18] = "firebase_instance_id";
                strArr[19] = "daily_error_events_count";
                strArr[20] = "daily_realtime_events_count";
                strArr[21] = "health_monitor_sample";
                strArr[22] = "android_id";
                strArr[23] = "adid_reporting_enabled";
                strArr[24] = "admob_app_id";
                strArr[25] = "dynamite_version";
                strArr[26] = "safelisted_events";
                strArr[27] = "ga_app_id";
                strArr[28] = "session_stitching_token";
                strArr[29] = "sgtm_upload_enabled";
                strArr[30] = "target_os_version";
                strArr[31] = "session_stitching_token_hash";
                strArr[32] = "ad_services_version";
                strArr[33] = "unmatched_first_open_without_ad_id";
                strArr[34] = "npa_metadata_value";
                strArr[35] = "attribution_eligibility_status";
                strArr[36] = "sgtm_preview_key";
                strArr[37] = "dma_consent_state";
                strArr[38] = "daily_realtime_dcu_count";
                strArr[39] = "bundle_delivery_index";
                strArr[40] = "serialized_npa_metadata";
                strArr[41] = "unmatched_pfo";
                strArr[42] = "unmatched_uwa";
                strArr[43] = "ad_campaign_info";
                strArr[44] = "client_upload_eligibility";
                Query = sQLiteDatabaseZze.query("apps", strArr, "app_id=?", new String[]{str}, null, null, null);
                try {
                    try {
                        if (Query.moveToFirst()) {
                            zzpg zzpgVar = this.zzg;
                            zzh zzhVar2 = new zzh(zzpgVar.zzag(), str);
                            zzjl zzjlVarZzB = zzpgVar.zzB(str);
                            zzjk zzjkVar = zzjk.ANALYTICS_STORAGE;
                            if (zzjlVarZzB.zzo(zzjkVar)) {
                                zzhVar2.zze(Query.getString(0));
                            }
                            zzhVar2.zzg(Query.getString(1));
                            if (zzpgVar.zzB(str).zzo(zzjk.AD_STORAGE)) {
                                zzhVar2.zzk(Query.getString(2));
                            }
                            zzhVar2.zzF(Query.getLong(3));
                            zzhVar2.zzo(Query.getLong(4));
                            zzhVar2.zzq(Query.getLong(5));
                            zzhVar2.zzs(Query.getString(6));
                            zzhVar2.zzw(Query.getString(7));
                            zzhVar2.zzy(Query.getLong(8));
                            zzhVar2.zzA(Query.getLong(9));
                            zzhVar2.zzE(Query.isNull(10) || Query.getInt(10) != 0);
                            zzhVar2.zzO(Query.getLong(11));
                            zzhVar2.zzQ(Query.getLong(12));
                            zzhVar2.zzS(Query.getLong(13));
                            zzhVar2.zzU(Query.getLong(14));
                            zzhVar2.zzI(Query.getLong(15));
                            zzhVar2.zzK(Query.getLong(16));
                            zzhVar2.zzu(Query.isNull(17) ? -2147483648L : Query.getInt(17));
                            zzhVar2.zzm(Query.getString(18));
                            zzhVar2.zzY(Query.getLong(19));
                            zzhVar2.zzW(Query.getLong(20));
                            zzhVar2.zzab(Query.getString(21));
                            zzhVar2.zzad(Query.isNull(23) || Query.getInt(23) != 0);
                            zzhVar2.zzC(Query.isNull(25) ? 0L : Query.getLong(25));
                            if (!Query.isNull(26)) {
                                zzhVar2.zzah(Arrays.asList(Query.getString(26).split(",", -1)));
                            }
                            if (zzpgVar.zzB(str).zzo(zzjkVar)) {
                                zzhVar2.zzi(Query.getString(28));
                            }
                            zzhVar2.zzaj((Query.isNull(29) || Query.getInt(29) == 0) ? false : true);
                            zzhVar2.zzaE(Query.getLong(39));
                            zzhVar2.zzaz(Query.getString(36));
                            zzhVar2.zzal(Query.getLong(30));
                            zzhVar2.zzan(Query.getLong(31));
                            zzqp.zza();
                            zzic zzicVar = this.zzu;
                            if (zzicVar.zzc().zzp(str, zzfy.zzaP)) {
                                zzhVar2.zzap(Query.getInt(32));
                                zzhVar2.zzax(Query.getLong(35));
                            }
                            zzhVar2.zzar((Query.isNull(33) || Query.getInt(33) == 0) ? false : true);
                            if (Query.isNull(34)) {
                                boolValueOf = null;
                            } else {
                                boolValueOf = Boolean.valueOf(Query.getInt(34) != 0);
                            }
                            zzhVar2.zzaf(boolValueOf);
                            zzhVar2.zzaB(Query.getInt(37));
                            zzhVar2.zzaD(Query.getInt(38));
                            zzhVar2.zzaG(Query.isNull(40) ? "" : (String) Preconditions.checkNotNull(Query.getString(40)));
                            if (!Query.isNull(41)) {
                                zzhVar2.zzat(Long.valueOf(Query.getLong(41)));
                            }
                            if (!Query.isNull(42)) {
                                zzhVar2.zzav(Long.valueOf(Query.getLong(42)));
                            }
                            zzhVar2.zzaI(Query.getBlob(43));
                            if (!Query.isNull(44)) {
                                zzhVar2.zzaK(Query.getInt(44));
                            }
                            zzhVar2.zzb();
                            if (Query.moveToNext()) {
                                zzicVar.zzaV().zzb().zzb("Got multiple records for app, expected one. appId", zzgu.zzl(str));
                            }
                            if (Query != 0) {
                                Query.close();
                            }
                            return zzhVar2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        r3 = Query;
                        if (r3 != 0) {
                            r3.close();
                        }
                        throw th;
                    }
                } catch (SQLiteException e) {
                    e = e;
                    this.zzu.zzaV().zzb().zzc("Error querying app. appId", zzgu.zzl(str), e);
                    r4 = Query;
                }
            } catch (SQLiteException e2) {
                e = e2;
                Query = zzhVar;
                this.zzu.zzaV().zzb().zzc("Error querying app. appId", zzgu.zzl(str), e);
                r4 = Query;
                if (r4 != 0) {
                    r4 = Query;
                    r4.close();
                }
                r4 = Query;
                return zzhVar;
            } catch (Throwable th2) {
                th = th2;
                r3 = zzhVar;
                if (r3 != 0) {
                    r3.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            zzhVar = null;
        } catch (Throwable th3) {
            th = th3;
            zzhVar = null;
        }
        if (r4 != 0) {
            r4 = Query;
            r4.close();
        }
        r4 = Query;
        return zzhVar;
    }

    public final void zzv(zzh zzhVar, boolean z, boolean z2) {
        Preconditions.checkNotNull(zzhVar);
        zzg();
        zzaw();
        String strZzc = zzhVar.zzc();
        Preconditions.checkNotNull(strZzc);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", strZzc);
        if (z) {
            contentValues.put("app_instance_id", (String) null);
        } else if (this.zzg.zzB(strZzc).zzo(zzjk.ANALYTICS_STORAGE)) {
            contentValues.put("app_instance_id", zzhVar.zzd());
        }
        contentValues.put("gmp_app_id", zzhVar.zzf());
        zzpg zzpgVar = this.zzg;
        if (zzpgVar.zzB(strZzc).zzo(zzjk.AD_STORAGE)) {
            contentValues.put("resettable_device_id_hash", zzhVar.zzj());
        }
        contentValues.put("last_bundle_index", Long.valueOf(zzhVar.zzG()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzhVar.zzn()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzhVar.zzp()));
        contentValues.put("app_version", zzhVar.zzr());
        contentValues.put("app_store", zzhVar.zzv());
        contentValues.put("gmp_version", Long.valueOf(zzhVar.zzx()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzhVar.zzz()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzhVar.zzD()));
        contentValues.put("day", Long.valueOf(zzhVar.zzN()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzhVar.zzP()));
        contentValues.put("daily_events_count", Long.valueOf(zzhVar.zzR()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzhVar.zzT()));
        contentValues.put("config_fetched_time", Long.valueOf(zzhVar.zzH()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzhVar.zzJ()));
        contentValues.put("app_version_int", Long.valueOf(zzhVar.zzt()));
        contentValues.put("firebase_instance_id", zzhVar.zzl());
        contentValues.put("daily_error_events_count", Long.valueOf(zzhVar.zzX()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzhVar.zzV()));
        contentValues.put("health_monitor_sample", zzhVar.zzZ());
        contentValues.put("android_id", (Long) 0L);
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzhVar.zzac()));
        contentValues.put("dynamite_version", Long.valueOf(zzhVar.zzB()));
        if (zzpgVar.zzB(strZzc).zzo(zzjk.ANALYTICS_STORAGE)) {
            contentValues.put("session_stitching_token", zzhVar.zzh());
        }
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(zzhVar.zzai()));
        contentValues.put("target_os_version", Long.valueOf(zzhVar.zzak()));
        contentValues.put("session_stitching_token_hash", Long.valueOf(zzhVar.zzam()));
        zzqp.zza();
        zzic zzicVar = this.zzu;
        if (zzicVar.zzc().zzp(strZzc, zzfy.zzaP)) {
            contentValues.put("ad_services_version", Integer.valueOf(zzhVar.zzao()));
            contentValues.put("attribution_eligibility_status", Long.valueOf(zzhVar.zzaw()));
        }
        contentValues.put("unmatched_first_open_without_ad_id", Boolean.valueOf(zzhVar.zzaq()));
        contentValues.put("npa_metadata_value", zzhVar.zzae());
        contentValues.put("bundle_delivery_index", Long.valueOf(zzhVar.zzaF()));
        contentValues.put("sgtm_preview_key", zzhVar.zzay());
        contentValues.put("dma_consent_state", Integer.valueOf(zzhVar.zzaA()));
        contentValues.put("daily_realtime_dcu_count", Integer.valueOf(zzhVar.zzaC()));
        contentValues.put("serialized_npa_metadata", zzhVar.zzaH());
        contentValues.put("client_upload_eligibility", Integer.valueOf(zzhVar.zzaL()));
        List listZzag = zzhVar.zzag();
        if (listZzag != null) {
            if (listZzag.isEmpty()) {
                zzicVar.zzaV().zze().zzb("Safelisted events should not be an empty list. appId", strZzc);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", listZzag));
            }
        }
        zzpr.zza();
        if (zzicVar.zzc().zzp(null, zzfy.zzaK) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        contentValues.put("unmatched_pfo", zzhVar.zzas());
        contentValues.put("unmatched_uwa", zzhVar.zzau());
        contentValues.put("ad_campaign_info", zzhVar.zzaJ());
        try {
            SQLiteDatabase sQLiteDatabaseZze = zze();
            if (sQLiteDatabaseZze.update("apps", contentValues, "app_id = ?", new String[]{strZzc}) == 0 && sQLiteDatabaseZze.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzicVar.zzaV().zzb().zzb("Failed to insert/update app (got -1). appId", zzgu.zzl(strZzc));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzc("Error storing app. appId", zzgu.zzl(strZzc), e);
        }
    }

    public final zzar zzw(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        return zzx(j, str, 1L, false, false, z3, false, z5, z6, z7);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0164  */
    public final zzar zzx(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) throws Throwable {
        Cursor cursor;
        Cursor cursorQuery;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzaw();
        String[] strArr = {str};
        zzar zzarVar = new zzar();
        try {
            try {
                SQLiteDatabase sQLiteDatabaseZze = zze();
                cursorQuery = sQLiteDatabaseZze.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count", "daily_registered_triggers_count"}, "app_id=?", new String[]{str}, null, null, null);
                try {
                    if (cursorQuery.moveToFirst()) {
                        if (cursorQuery.getLong(0) == j) {
                            zzarVar.zzb = cursorQuery.getLong(1);
                            zzarVar.zza = cursorQuery.getLong(2);
                            zzarVar.zzc = cursorQuery.getLong(3);
                            zzarVar.zzd = cursorQuery.getLong(4);
                            zzarVar.zze = cursorQuery.getLong(5);
                            zzarVar.zzf = cursorQuery.getLong(6);
                            zzarVar.zzg = cursorQuery.getLong(7);
                        }
                        if (z) {
                            zzarVar.zzb += j2;
                        }
                        if (z2) {
                            zzarVar.zza += j2;
                        }
                        if (z3) {
                            zzarVar.zzc += j2;
                        }
                        if (z4) {
                            zzarVar.zzd += j2;
                        }
                        if (z5) {
                            zzarVar.zze += j2;
                        }
                        if (z6) {
                            zzarVar.zzf += j2;
                        }
                        if (z7) {
                            zzarVar.zzg += j2;
                        }
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("day", Long.valueOf(j));
                        contentValues.put("daily_public_events_count", Long.valueOf(zzarVar.zza));
                        contentValues.put("daily_events_count", Long.valueOf(zzarVar.zzb));
                        contentValues.put("daily_conversions_count", Long.valueOf(zzarVar.zzc));
                        contentValues.put("daily_error_events_count", Long.valueOf(zzarVar.zzd));
                        contentValues.put("daily_realtime_events_count", Long.valueOf(zzarVar.zze));
                        contentValues.put("daily_realtime_dcu_count", Long.valueOf(zzarVar.zzf));
                        contentValues.put("daily_registered_triggers_count", Long.valueOf(zzarVar.zzg));
                        sQLiteDatabaseZze.update("apps", contentValues, "app_id=?", strArr);
                    } else {
                        this.zzu.zzaV().zze().zzb("Not updating daily counts, app is not known. appId", zzgu.zzl(str));
                    }
                } catch (SQLiteException e) {
                    e = e;
                    this.zzu.zzaV().zzb().zzc("Error updating daily counts. appId", zzgu.zzl(str), e);
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursorQuery = null;
            } catch (Throwable th) {
                th = th;
                cursor = null;
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return zzarVar;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x008e  */
    /* JADX WARN: Code duplicated, block: B:36:? A[SYNTHETIC] */
    public final zzaq zzy(String str) {
        Throwable th;
        Cursor cursorQuery;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzaw();
        Cursor cursor = null;
        try {
            cursorQuery = zze().query("apps", new String[]{"remote_config", "config_last_modified_time", "e_tag"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                try {
                    if (cursorQuery.moveToFirst()) {
                        byte[] blob = cursorQuery.getBlob(0);
                        String string = cursorQuery.getString(1);
                        String string2 = cursorQuery.getString(2);
                        if (cursorQuery.moveToNext()) {
                            this.zzu.zzaV().zzb().zzb("Got multiple records for app config, expected one. appId", zzgu.zzl(str));
                        }
                        if (blob != null) {
                            zzaq zzaqVar = new zzaq(blob, string, string2);
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return zzaqVar;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        throw th;
                    }
                    cursor.close();
                    throw th;
                }
            } catch (SQLiteException e) {
                e = e;
                this.zzu.zzaV().zzb().zzc("Error querying remote config. appId", zzgu.zzl(str), e);
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                throw th;
            }
            cursor.close();
            throw th;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0045  */
    public final boolean zzz(com.google.android.gms.internal.measurement.zzid zzidVar, boolean z) {
        zzg();
        zzaw();
        Preconditions.checkNotNull(zzidVar);
        Preconditions.checkNotEmpty(zzidVar.zzA());
        Preconditions.checkState(zzidVar.zzn());
        zzI();
        zzic zzicVar = this.zzu;
        long jCurrentTimeMillis = zzicVar.zzaZ().currentTimeMillis();
        long jZzo = zzidVar.zzo();
        zzicVar.zzc();
        if (jZzo >= jCurrentTimeMillis - zzal.zzI()) {
            long jZzo2 = zzidVar.zzo();
            zzicVar.zzc();
            if (jZzo2 > zzal.zzI() + jCurrentTimeMillis) {
                zzicVar.zzaV().zze().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzgu.zzl(zzidVar.zzA()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzidVar.zzo()));
            }
        } else {
            zzicVar.zzaV().zze().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzgu.zzl(zzidVar.zzA()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzidVar.zzo()));
        }
        try {
            byte[] bArrZzv = this.zzg.zzp().zzv(zzidVar.zzcc());
            zzic zzicVar2 = this.zzu;
            zzicVar2.zzaV().zzk().zzb("Saving bundle, size", Integer.valueOf(bArrZzv.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzidVar.zzA());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzidVar.zzo()));
            contentValues.put("data", bArrZzv);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzidVar.zzaa()) {
                contentValues.put("retry_count", Integer.valueOf(zzidVar.zzab()));
            }
            try {
                if (zze().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                zzicVar2.zzaV().zzb().zzb("Failed to insert bundle (got -1). appId", zzgu.zzl(zzidVar.zzA()));
                return false;
            } catch (SQLiteException e) {
                this.zzu.zzaV().zzb().zzc("Error storing bundle. appId", zzgu.zzl(zzidVar.zzA()), e);
                return false;
            }
        } catch (IOException e2) {
            this.zzu.zzaV().zzb().zzc("Data loss. Failed to serialize bundle. appId", zzgu.zzl(zzidVar.zzA()), e2);
            return false;
        }
    }
}
