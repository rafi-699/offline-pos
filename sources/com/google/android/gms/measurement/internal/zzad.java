package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzpu;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@23.0.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzad extends zzos {
    private String zza;
    private Set zzb;
    private Map zzc;
    private Long zzd;
    private Long zze;

    zzad(zzpg zzpgVar) {
        super(zzpgVar);
    }

    private final zzy zzc(Integer num) {
        if (this.zzc.containsKey(num)) {
            return (zzy) this.zzc.get(num);
        }
        zzy zzyVar = new zzy(this, this.zza, null);
        this.zzc.put(num, zzyVar);
        return zzyVar;
    }

    private final boolean zzd(int i, int i2) {
        zzy zzyVar = (zzy) this.zzc.get(Integer.valueOf(i));
        if (zzyVar == null) {
            return false;
        }
        return zzyVar.zzc().get(i2);
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0276  */
    /* JADX WARN: Code duplicated, block: B:109:0x0285  */
    /* JADX WARN: Code duplicated, block: B:111:0x0290  */
    /* JADX WARN: Code duplicated, block: B:117:0x02c4 A[Catch: SQLiteException -> 0x02fd, all -> 0x042d, LOOP:11: B:117:0x02c4->B:124:0x02f4, LOOP_START, PHI: r8
  0x02c4: PHI (r8v20 int) = (r8v19 int), (r8v22 int) binds: [B:116:0x02c2, B:124:0x02f4] A[DONT_GENERATE, DONT_INLINE], TryCatch #7 {all -> 0x042d, blocks: (B:115:0x02be, B:117:0x02c4, B:119:0x02d4, B:120:0x02dc, B:125:0x02f6, B:137:0x0309), top: B:464:0x02ac }] */
    /* JADX WARN: Code duplicated, block: B:119:0x02d4 A[Catch: SQLiteException -> 0x02fd, all -> 0x042d, TryCatch #7 {all -> 0x042d, blocks: (B:115:0x02be, B:117:0x02c4, B:119:0x02d4, B:120:0x02dc, B:125:0x02f6, B:137:0x0309), top: B:464:0x02ac }] */
    /* JADX WARN: Code duplicated, block: B:123:0x02f0 A[PHI: r0 r2
  0x02f0: PHI (r0v57 java.util.Map) = (r0v43 java.util.Map), (r0v59 java.util.Map), (r0v37 java.util.Map) binds: [B:138:0x0320, B:126:0x02fa, B:122:0x02ee] A[DONT_GENERATE, DONT_INLINE]
  0x02f0: PHI (r2v43 android.database.Cursor) = (r2v41 android.database.Cursor), (r2v45 android.database.Cursor), (r2v45 android.database.Cursor) binds: [B:138:0x0320, B:126:0x02fa, B:122:0x02ee] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:124:0x02f4 A[LOOP:11: B:117:0x02c4->B:124:0x02f4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:125:0x02f6 A[Catch: SQLiteException -> 0x02fd, all -> 0x042d, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x042d, blocks: (B:115:0x02be, B:117:0x02c4, B:119:0x02d4, B:120:0x02dc, B:125:0x02f6, B:137:0x0309), top: B:464:0x02ac }] */
    /* JADX WARN: Code duplicated, block: B:143:0x0336  */
    /* JADX WARN: Code duplicated, block: B:146:0x0344  */
    /* JADX WARN: Code duplicated, block: B:148:0x0360  */
    /* JADX WARN: Code duplicated, block: B:176:0x0435  */
    /* JADX WARN: Code duplicated, block: B:180:0x0442  */
    /* JADX WARN: Code duplicated, block: B:182:0x0467  */
    /* JADX WARN: Code duplicated, block: B:188:0x047c  */
    /* JADX WARN: Code duplicated, block: B:192:0x0496  */
    /* JADX WARN: Code duplicated, block: B:193:0x049f  */
    /* JADX WARN: Code duplicated, block: B:197:0x04ab  */
    /* JADX WARN: Code duplicated, block: B:203:0x04c0  */
    /* JADX WARN: Code duplicated, block: B:210:0x04fa  */
    /* JADX WARN: Code duplicated, block: B:213:0x0503  */
    /* JADX WARN: Code duplicated, block: B:215:0x050d  */
    /* JADX WARN: Code duplicated, block: B:217:0x0533  */
    /* JADX WARN: Code duplicated, block: B:218:0x0537  */
    /* JADX WARN: Code duplicated, block: B:223:0x0554 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:247:0x05d8  */
    /* JADX WARN: Code duplicated, block: B:250:0x05ec  */
    /* JADX WARN: Code duplicated, block: B:256:0x0621  */
    /* JADX WARN: Code duplicated, block: B:266:0x066d  */
    /* JADX WARN: Code duplicated, block: B:272:0x0696  */
    /* JADX WARN: Code duplicated, block: B:274:0x06a1  */
    /* JADX WARN: Code duplicated, block: B:281:0x06c5  */
    /* JADX WARN: Code duplicated, block: B:283:0x06cb A[LOOP:8: B:495:0x0671->B:283:0x06cb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:286:0x06d3  */
    /* JADX WARN: Code duplicated, block: B:289:0x06dd  */
    /* JADX WARN: Code duplicated, block: B:315:0x0721  */
    /* JADX WARN: Code duplicated, block: B:319:0x072b  */
    /* JADX WARN: Code duplicated, block: B:321:0x072f  */
    /* JADX WARN: Code duplicated, block: B:325:0x0745  */
    /* JADX WARN: Code duplicated, block: B:331:0x077a  */
    /* JADX WARN: Code duplicated, block: B:333:0x07a5 A[LOOP:10: B:329:0x0774->B:333:0x07a5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:337:0x07c5  */
    /* JADX WARN: Code duplicated, block: B:341:0x07df  */
    /* JADX WARN: Code duplicated, block: B:344:0x07e7  */
    /* JADX WARN: Code duplicated, block: B:347:0x07f6  */
    /* JADX WARN: Code duplicated, block: B:349:0x0809  */
    /* JADX WARN: Code duplicated, block: B:353:0x084f A[Catch: all -> 0x08ba, SQLiteException -> 0x08bd, LOOP:3: B:353:0x084f->B:370:0x08a8, LOOP_START, PHI: r5 r14
  0x084f: PHI (r5v63 java.util.Iterator) = (r5v53 java.util.Iterator), (r5v65 java.util.Iterator) binds: [B:352:0x084d, B:370:0x08a8] A[DONT_GENERATE, DONT_INLINE]
  0x084f: PHI (r14v3 int) = (r14v2 int), (r14v5 int) binds: [B:352:0x084d, B:370:0x08a8] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #13 {all -> 0x08ba, blocks: (B:351:0x0849, B:353:0x084f, B:354:0x0853, B:356:0x0864, B:358:0x0874, B:360:0x087f, B:365:0x089b, B:362:0x0886, B:364:0x0894, B:372:0x08ae), top: B:470:0x0849 }] */
    /* JADX WARN: Code duplicated, block: B:358:0x0874 A[Catch: all -> 0x08ba, SQLiteException -> 0x08bd, TryCatch #13 {all -> 0x08ba, blocks: (B:351:0x0849, B:353:0x084f, B:354:0x0853, B:356:0x0864, B:358:0x0874, B:360:0x087f, B:365:0x089b, B:362:0x0886, B:364:0x0894, B:372:0x08ae), top: B:470:0x0849 }] */
    /* JADX WARN: Code duplicated, block: B:359:0x087d  */
    /* JADX WARN: Code duplicated, block: B:368:0x08a3  */
    /* JADX WARN: Code duplicated, block: B:370:0x08a8 A[LOOP:3: B:353:0x084f->B:370:0x08a8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:371:0x08ac  */
    /* JADX WARN: Code duplicated, block: B:374:0x08b4  */
    /* JADX WARN: Code duplicated, block: B:392:0x08ea  */
    /* JADX WARN: Code duplicated, block: B:394:0x08ee  */
    /* JADX WARN: Code duplicated, block: B:398:0x08fe  */
    /* JADX WARN: Code duplicated, block: B:401:0x0923  */
    /* JADX WARN: Code duplicated, block: B:404:0x0934  */
    /* JADX WARN: Code duplicated, block: B:406:0x094b  */
    /* JADX WARN: Code duplicated, block: B:408:0x095d  */
    /* JADX WARN: Code duplicated, block: B:409:0x0968  */
    /* JADX WARN: Code duplicated, block: B:411:0x0996  */
    /* JADX WARN: Code duplicated, block: B:414:0x09a0  */
    /* JADX WARN: Code duplicated, block: B:423:0x09f1  */
    /* JADX WARN: Code duplicated, block: B:424:0x09fa  */
    /* JADX WARN: Code duplicated, block: B:428:0x0a0b A[PHI: r17 r39
  0x0a0b: PHI (r17v12 java.lang.String) = (r17v13 java.lang.String), (r2v50 java.lang.String) binds: [B:427:0x0a09, B:425:0x09fb] A[DONT_GENERATE, DONT_INLINE]
  0x0a0b: PHI (r39v3 java.util.Map) = (r39v4 java.util.Map), (r0v135 java.util.Map) binds: [B:427:0x0a09, B:425:0x09fb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:434:0x0a38  */
    /* JADX WARN: Code duplicated, block: B:447:0x0ac4  */
    /* JADX WARN: Code duplicated, block: B:452:0x0ace  */
    /* JADX WARN: Code duplicated, block: B:48:0x016a A[PHI: r0 r5 r7 r40 r41
  0x016a: PHI (r0v191 java.util.Map) = (r0v193 java.util.Map), (r0v198 java.util.Map) binds: [B:60:0x0196, B:47:0x0168] A[DONT_GENERATE, DONT_INLINE]
  0x016a: PHI (r5v69 android.database.Cursor) = (r5v70 android.database.Cursor), (r5v72 android.database.Cursor) binds: [B:60:0x0196, B:47:0x0168] A[DONT_GENERATE, DONT_INLINE]
  0x016a: PHI (r7v45 java.lang.Object) = (r7v55 java.lang.Object), (r7v56 java.lang.Object) binds: [B:60:0x0196, B:47:0x0168] A[DONT_GENERATE, DONT_INLINE]
  0x016a: PHI (r40v6 ??) = (r40v16 ??), (r40v17 ??) binds: [B:60:0x0196, B:47:0x0168] A[DONT_GENERATE, DONT_INLINE]
  0x016a: PHI (r41v6 ??) = (r41v22 ??), (r41v23 ??) binds: [B:60:0x0196, B:47:0x0168] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:514:0x08a1 A[EDGE_INSN: B:514:0x08a1->B:367:0x08a1 BREAK  A[LOOP:3: B:353:0x084f->B:370:0x08a8], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:515:0x0914 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:517:0x0a14 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:519:0x0a05 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:520:0x09dd A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:523:0x0a96 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:525:0x0a32 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:529:0x05fa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:530:0x0613 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:532:0x05e6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:533:0x05e6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:535:0x06c3 A[EDGE_INSN: B:535:0x06c3->B:280:0x06c3 BREAK  A[LOOP:8: B:495:0x0671->B:283:0x06cb], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:537:0x0769 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:538:0x075b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:542:0x07bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:543:0x07b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:544:0x02ee A[EDGE_INSN: B:544:0x02ee->B:122:0x02ee BREAK  A[LOOP:11: B:117:0x02c4->B:124:0x02f4], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:547:0x041e A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:562:0x05b2 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:569:0x0488 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:571:0x0476 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:574:0x04cc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:577:0x04ba A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:587:0x023b A[EDGE_INSN: B:587:0x023b->B:87:0x023b BREAK  A[LOOP:20: B:76:0x01f4->B:90:0x0242], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x019b  */
    /* JADX WARN: Code duplicated, block: B:71:0x01dd A[Catch: SQLiteException -> 0x024d, all -> 0x0aca, TRY_LEAVE, TryCatch #27 {all -> 0x0aca, blocks: (B:69:0x01d7, B:71:0x01dd, B:75:0x01ed, B:76:0x01f4, B:77:0x01fd, B:78:0x020d, B:85:0x0235, B:80:0x021a, B:82:0x0228, B:84:0x022e, B:102:0x025d), top: B:488:0x01b9 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:75:0x01ed A[Catch: SQLiteException -> 0x024d, all -> 0x0aca, TRY_ENTER, TryCatch #27 {all -> 0x0aca, blocks: (B:69:0x01d7, B:71:0x01dd, B:75:0x01ed, B:76:0x01f4, B:77:0x01fd, B:78:0x020d, B:85:0x0235, B:80:0x021a, B:82:0x0228, B:84:0x022e, B:102:0x025d), top: B:488:0x01b9 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x023d  */
    /* JADX WARN: Code duplicated, block: B:90:0x0242 A[LOOP:20: B:76:0x01f4->B:90:0x0242, LOOP_END] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8, types: [int] */
    /* JADX WARN: Type inference failed for: r18v10 */
    /* JADX WARN: Type inference failed for: r18v11 */
    /* JADX WARN: Type inference failed for: r18v13 */
    /* JADX WARN: Type inference failed for: r18v14 */
    /* JADX WARN: Type inference failed for: r18v15 */
    /* JADX WARN: Type inference failed for: r18v16 */
    /* JADX WARN: Type inference failed for: r18v17 */
    /* JADX WARN: Type inference failed for: r18v18 */
    /* JADX WARN: Type inference failed for: r18v19, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r18v20 */
    /* JADX WARN: Type inference failed for: r18v21 */
    /* JADX WARN: Type inference failed for: r18v22 */
    /* JADX WARN: Type inference failed for: r18v23 */
    /* JADX WARN: Type inference failed for: r18v24 */
    /* JADX WARN: Type inference failed for: r18v25, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r18v26 */
    /* JADX WARN: Type inference failed for: r18v27 */
    /* JADX WARN: Type inference failed for: r18v28 */
    /* JADX WARN: Type inference failed for: r18v35 */
    /* JADX WARN: Type inference failed for: r18v36 */
    /* JADX WARN: Type inference failed for: r18v37 */
    /* JADX WARN: Type inference failed for: r18v38 */
    /* JADX WARN: Type inference failed for: r18v39 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v40 */
    /* JADX WARN: Type inference failed for: r18v41 */
    /* JADX WARN: Type inference failed for: r18v42 */
    /* JADX WARN: Type inference failed for: r18v43 */
    /* JADX WARN: Type inference failed for: r18v44 */
    /* JADX WARN: Type inference failed for: r18v45 */
    /* JADX WARN: Type inference failed for: r18v46 */
    /* JADX WARN: Type inference failed for: r18v47 */
    /* JADX WARN: Type inference failed for: r18v48 */
    /* JADX WARN: Type inference failed for: r18v49 */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* JADX WARN: Type inference failed for: r18v50 */
    /* JADX WARN: Type inference failed for: r18v51 */
    /* JADX WARN: Type inference failed for: r18v52 */
    /* JADX WARN: Type inference failed for: r18v53 */
    /* JADX WARN: Type inference failed for: r18v54 */
    /* JADX WARN: Type inference failed for: r18v6 */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r18v9 */
    /* JADX WARN: Type inference failed for: r40v0, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r40v1 */
    /* JADX WARN: Type inference failed for: r40v10 */
    /* JADX WARN: Type inference failed for: r40v11 */
    /* JADX WARN: Type inference failed for: r40v12 */
    /* JADX WARN: Type inference failed for: r40v13 */
    /* JADX WARN: Type inference failed for: r40v14 */
    /* JADX WARN: Type inference failed for: r40v15 */
    /* JADX WARN: Type inference failed for: r40v16 */
    /* JADX WARN: Type inference failed for: r40v17 */
    /* JADX WARN: Type inference failed for: r40v2 */
    /* JADX WARN: Type inference failed for: r40v3 */
    /* JADX WARN: Type inference failed for: r40v5 */
    /* JADX WARN: Type inference failed for: r40v6 */
    /* JADX WARN: Type inference failed for: r40v7 */
    /* JADX WARN: Type inference failed for: r40v8 */
    /* JADX WARN: Type inference failed for: r41v0, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r41v1 */
    /* JADX WARN: Type inference failed for: r41v10 */
    /* JADX WARN: Type inference failed for: r41v17 */
    /* JADX WARN: Type inference failed for: r41v18 */
    /* JADX WARN: Type inference failed for: r41v19 */
    /* JADX WARN: Type inference failed for: r41v2 */
    /* JADX WARN: Type inference failed for: r41v20 */
    /* JADX WARN: Type inference failed for: r41v21 */
    /* JADX WARN: Type inference failed for: r41v22 */
    /* JADX WARN: Type inference failed for: r41v23 */
    /* JADX WARN: Type inference failed for: r41v3 */
    /* JADX WARN: Type inference failed for: r41v5 */
    /* JADX WARN: Type inference failed for: r41v6 */
    /* JADX WARN: Type inference failed for: r41v7 */
    /* JADX WARN: Type inference failed for: r41v8 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v29, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v32, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v36, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v66 */
    /* JADX WARN: Type inference failed for: r5v68, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v76 */
    /* JADX WARN: Type inference failed for: r5v77 */
    /* JADX WARN: Type inference failed for: r5v78 */
    /* JADX WARN: Type inference failed for: r5v79 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v42, types: [int] */
    /* JADX WARN: Type inference failed for: r7v43, types: [android.database.Cursor] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    final List zzb(String str, List list, List list2, Long l, Long l2, boolean z) throws Throwable {
        boolean z2;
        ?? r11;
        boolean z3;
        ?? r41;
        ?? r40;
        Object obj;
        Map map;
        ?? r42;
        ?? r43;
        Object obj2;
        ?? r5;
        String str2;
        boolean z4;
        ?? Query;
        Map map2;
        boolean z5;
        ?? r18;
        Map map3;
        Iterator it;
        int iIntValue;
        com.google.android.gms.internal.measurement.zzii zziiVar;
        BitSet bitSet;
        BitSet bitSet2;
        ArrayMap arrayMap;
        com.google.android.gms.internal.measurement.zzii zziiVar2;
        List<com.google.android.gms.internal.measurement.zzff> list3;
        int i;
        boolean z6;
        Long lValueOf;
        zzav zzavVarZzj;
        String str3;
        Map arrayMap2;
        ?? r6;
        Cursor cursorRawQuery;
        ArrayMap arrayMap3;
        Iterator it2;
        com.google.android.gms.internal.measurement.zzii zziiVar3;
        List list4;
        Map map4;
        Iterator it3;
        int i2;
        Integer numValueOf;
        List arrayList;
        String str4;
        byte[] bArr;
        String str5;
        zzz zzzVar;
        ArrayMap arrayMap4;
        Iterator it4;
        com.google.android.gms.internal.measurement.zzhs zzhsVar;
        com.google.android.gms.internal.measurement.zzhs zzhsVarZza;
        zzpg zzpgVar;
        zzbc zzbcVarZzaf;
        long j;
        String strZzd;
        Map mapEmptyMap;
        Iterator it5;
        String str6;
        Iterator it6;
        int iIntValue2;
        Set set;
        Integer numValueOf2;
        Iterator it7;
        boolean zZzd;
        ?? r19;
        Map map5;
        long j2;
        zzaa zzaaVar;
        Long l3;
        String str7;
        ArrayMap arrayMap5;
        ?? r7;
        ?? r110;
        ?? r111;
        ?? Query2;
        ?? r112;
        ?? r113;
        int i3;
        ?? r114;
        Integer numValueOf3;
        List list5;
        ?? r115;
        List arrayList2;
        String str8;
        ArrayList arrayList3;
        Iterator it8;
        zzav zzavVarZzj2;
        String str9;
        ContentValues contentValues;
        ArrayMap arrayMap6;
        Iterator it9;
        String strZzc;
        Map mapEmptyMap2;
        Iterator it10;
        int iIntValue3;
        Set set2;
        Integer numValueOf4;
        Iterator it11;
        boolean zZzd2;
        com.google.android.gms.internal.measurement.zzfn zzfnVar;
        zzic zzicVar;
        Integer numValueOf5;
        zzac zzacVar;
        Integer numValueOf6;
        zzav zzavVarZzj3;
        String str10;
        ArrayMap arrayMap7;
        Cursor cursor;
        int i4;
        Cursor cursorQuery;
        Integer numValueOf7;
        List list6;
        List arrayList4;
        ArrayMap arrayMap8;
        ?? r12;
        boolean z7;
        int i5;
        Cursor cursorQuery2;
        ?? r44;
        ?? r45;
        Object obj3;
        boolean z8;
        List arrayList5;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        this.zza = str;
        this.zzb = new HashSet();
        this.zzc = new ArrayMap();
        this.zzd = l;
        this.zze = l2;
        Iterator it12 = list.iterator();
        while (true) {
            z2 = false;
            z2 = false;
            r11 = 1;
            r11 = 1;
            if (!it12.hasNext()) {
                z3 = false;
                break;
            }
            if ("_s".equals(((com.google.android.gms.internal.measurement.zzhs) it12.next()).zzd())) {
                z3 = true;
                break;
            }
        }
        zzpu.zza();
        zzic zzicVar2 = this.zzu;
        zzal zzalVarZzc = zzicVar2.zzc();
        String str11 = this.zza;
        zzfx zzfxVar = zzfy.zzaF;
        boolean zZzp = zzalVarZzc.zzp(str11, zzfxVar);
        zzpu.zza();
        boolean zZzp2 = zzicVar2.zzc().zzp(this.zza, zzfy.zzaE);
        ?? r8 = zzfxVar;
        if (z3) {
            zzav zzavVarZzj4 = this.zzg.zzj();
            String str12 = this.zza;
            zzavVarZzj4.zzaw();
            zzavVarZzj4.zzg();
            Preconditions.checkNotEmpty(str12);
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("current_session_count", (Integer) 0);
            try {
                SQLiteDatabase sQLiteDatabaseZze = zzavVarZzj4.zze();
                sQLiteDatabaseZze.update("events", contentValues2, "app_id = ?", new String[]{str12});
                r8 = sQLiteDatabaseZze;
            } catch (SQLiteException e) {
                zzavVarZzj4.zzu.zzaV().zzb().zzc("Error resetting session-scoped event counts. appId", zzgu.zzl(str12), e);
                r8 = "Error resetting session-scoped event counts. appId";
            }
        }
        Map mapEmptyMap3 = Collections.emptyMap();
        String str13 = "audience_id";
        try {
            try {
                try {
                    if (zZzp2 && zZzp) {
                        zzav zzavVarZzj5 = this.zzg.zzj();
                        String str14 = this.zza;
                        Preconditions.checkNotEmpty(str14);
                        ArrayMap arrayMap9 = new ArrayMap();
                        try {
                            try {
                                str2 = "event_filters";
                                cursorQuery2 = zzavVarZzj5.zze().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str14}, null, null, null);
                                try {
                                    try {
                                        if (cursorQuery2.moveToFirst()) {
                                            while (true) {
                                                byte[] blob = cursorQuery2.getBlob(r11 == true ? 1 : 0);
                                                l = r11 == true ? 1 : 0;
                                                try {
                                                    try {
                                                        com.google.android.gms.internal.measurement.zzff zzffVar = (com.google.android.gms.internal.measurement.zzff) ((com.google.android.gms.internal.measurement.zzfe) zzpk.zzw(com.google.android.gms.internal.measurement.zzff.zzn(), blob)).zzbc();
                                                        if (zzffVar.zzg()) {
                                                            Integer numValueOf8 = Integer.valueOf(cursorQuery2.getInt(z2 ? 1 : 0));
                                                            List list7 = (List) arrayMap9.get(numValueOf8);
                                                            if (list7 == null) {
                                                                arrayList5 = new ArrayList();
                                                                arrayMap9.put(numValueOf8, arrayList5);
                                                            } else {
                                                                arrayList5 = list7;
                                                            }
                                                            arrayList5.add(zzffVar);
                                                            z8 = z2;
                                                        } else {
                                                            z8 = z2 ? 1 : 0;
                                                        }
                                                    } catch (SQLiteException e2) {
                                                        e = e2;
                                                        l2 = z2 ? 1 : 0;
                                                        zzgs zzgsVarZzb = zzavVarZzj5.zzu.zzaV().zzb();
                                                        Object objZzl = zzgu.zzl(str14);
                                                        zzgsVarZzb.zzc("Database error querying filters. appId", objZzl, e);
                                                        mapEmptyMap3 = Collections.emptyMap();
                                                        obj = objZzl;
                                                        r40 = l;
                                                        r41 = l2;
                                                        obj3 = objZzl;
                                                        r45 = l;
                                                        r44 = l2;
                                                        if (cursorQuery2 != null) {
                                                            cursorQuery2.close();
                                                            obj = obj3;
                                                            r40 = r45;
                                                            r41 = r44;
                                                        }
                                                        map = mapEmptyMap3;
                                                        obj2 = obj;
                                                        r43 = r40;
                                                        r42 = r41;
                                                    }
                                                } catch (IOException e3) {
                                                    z8 = z2 ? 1 : 0;
                                                    zzavVarZzj5.zzu.zzaV().zzb().zzc("Failed to merge filter. appId", zzgu.zzl(str14), e3);
                                                }
                                                if (!cursorQuery2.moveToNext()) {
                                                    break;
                                                }
                                                r11 = l;
                                                z2 = z8;
                                            }
                                            if (cursorQuery2 != null) {
                                                cursorQuery2.close();
                                            }
                                            map = arrayMap9;
                                            obj2 = str14;
                                            r43 = l;
                                            r42 = z8;
                                        } else {
                                            mapEmptyMap3 = Collections.emptyMap();
                                            obj = str14;
                                            r40 = true;
                                            r41 = false;
                                            obj3 = str14;
                                            r45 = true;
                                            r44 = false;
                                            if (cursorQuery2 != null) {
                                                cursorQuery2.close();
                                                obj = obj3;
                                                r40 = r45;
                                                r41 = r44;
                                            }
                                        }
                                    } catch (SQLiteException e4) {
                                        e = e4;
                                    }
                                } catch (SQLiteException e5) {
                                    e = e5;
                                    l2 = z2;
                                    l = r11;
                                }
                            } catch (SQLiteException e6) {
                                e = e6;
                                l2 = 0;
                                l = 1;
                                cursorQuery2 = null;
                            } catch (Throwable th) {
                                th = th;
                                r8 = 0;
                                if (r8 != 0) {
                                    r8.close();
                                }
                                throw th;
                            }
                            zzav zzavVarZzj6 = this.zzg.zzj();
                            String str15 = this.zza;
                            zzavVarZzj6.zzaw();
                            zzavVarZzj6.zzg();
                            Preconditions.checkNotEmpty(str15);
                            SQLiteDatabase sQLiteDatabaseZze2 = zzavVarZzj6.zze();
                            str2 = "audience_filter_values";
                            String[] strArr = new String[2];
                            strArr[r42] = "audience_id";
                            strArr[r43] = "current_results";
                            String[] strArr2 = new String[r43];
                            strArr2[r42] = str15;
                            Query = sQLiteDatabaseZze2.query("audience_filter_values", strArr, "app_id=?", strArr2, null, null, null);
                            if (Query.moveToFirst()) {
                                arrayMap8 = new ArrayMap();
                                r12 = r42;
                                z7 = z3;
                                while (true) {
                                    i5 = Query.getInt(r12);
                                    try {
                                        arrayMap8.put(Integer.valueOf(i5), (com.google.android.gms.internal.measurement.zzii) ((com.google.android.gms.internal.measurement.zzih) zzpk.zzw(com.google.android.gms.internal.measurement.zzii.zzi(), Query.getBlob(1))).zzbc());
                                        z4 = z7;
                                    } catch (IOException e7) {
                                        z4 = z7;
                                        try {
                                            zzavVarZzj6.zzu.zzaV().zzb().zzd("Failed to merge filter results. appId, audienceId, error", zzgu.zzl(str15), Integer.valueOf(i5), e7);
                                            z4 = z4;
                                        } catch (SQLiteException e8) {
                                            e = e8;
                                            str13 = str13;
                                            zzavVarZzj6.zzu.zzaV().zzb().zzc("Database error querying filter results. appId", zzgu.zzl(str15), e);
                                            Map mapEmptyMap4 = Collections.emptyMap();
                                            if (Query != 0) {
                                                Query.close();
                                            }
                                            map2 = mapEmptyMap4;
                                            r18 = str2;
                                            z5 = z4;
                                            if (!map2.isEmpty()) {
                                                HashSet hashSet = new HashSet(map2.keySet());
                                                if (z5) {
                                                    String str16 = this.zza;
                                                    zzavVarZzj = this.zzg.zzj();
                                                    str3 = this.zza;
                                                    zzavVarZzj.zzaw();
                                                    zzavVarZzj.zzg();
                                                    Preconditions.checkNotEmpty(str3);
                                                    arrayMap2 = new ArrayMap();
                                                    try {
                                                        try {
                                                            i2 = 0;
                                                            cursorRawQuery = zzavVarZzj.zze().rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str3, str3});
                                                            try {
                                                                if (cursorRawQuery.moveToFirst()) {
                                                                    while (true) {
                                                                        numValueOf = Integer.valueOf(cursorRawQuery.getInt(i2));
                                                                        arrayList = (List) arrayMap2.get(numValueOf);
                                                                        if (arrayList == null) {
                                                                            arrayList = new ArrayList();
                                                                            arrayMap2.put(numValueOf, arrayList);
                                                                        }
                                                                        arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                                                                        if (!cursorRawQuery.moveToNext()) {
                                                                            break;
                                                                        }
                                                                        i2 = 0;
                                                                    }
                                                                    if (cursorRawQuery != null) {
                                                                        cursorRawQuery.close();
                                                                    }
                                                                } else {
                                                                    arrayMap2 = Collections.emptyMap();
                                                                    if (cursorRawQuery != null) {
                                                                        cursorRawQuery.close();
                                                                    }
                                                                }
                                                            } catch (SQLiteException e9) {
                                                                e = e9;
                                                                zzavVarZzj.zzu.zzaV().zzb().zzc("Database error querying scoped filters. appId", zzgu.zzl(str3), e);
                                                                arrayMap2 = Collections.emptyMap();
                                                                if (cursorRawQuery != null) {
                                                                }
                                                                Preconditions.checkNotEmpty(str16);
                                                                Preconditions.checkNotNull(map2);
                                                                arrayMap3 = new ArrayMap();
                                                                if (!map2.isEmpty()) {
                                                                    it2 = map2.keySet().iterator();
                                                                    while (it2.hasNext()) {
                                                                        int iIntValue4 = ((Integer) it2.next()).intValue();
                                                                        Integer numValueOf9 = Integer.valueOf(iIntValue4);
                                                                        zziiVar3 = (com.google.android.gms.internal.measurement.zzii) map2.get(numValueOf9);
                                                                        list4 = (List) arrayMap2.get(numValueOf9);
                                                                        if (list4 != null) {
                                                                        }
                                                                        map4 = arrayMap2;
                                                                        it3 = it2;
                                                                        arrayMap3.put(numValueOf9, zziiVar3);
                                                                        arrayMap2 = map4;
                                                                        it2 = it3;
                                                                    }
                                                                }
                                                                map3 = arrayMap3;
                                                                it = hashSet.iterator();
                                                                while (it.hasNext()) {
                                                                    iIntValue = ((Integer) it.next()).intValue();
                                                                    zziiVar = (com.google.android.gms.internal.measurement.zzii) map3.get(Integer.valueOf(iIntValue));
                                                                    bitSet = new BitSet();
                                                                    bitSet2 = new BitSet();
                                                                    arrayMap = new ArrayMap();
                                                                    if (zziiVar != null) {
                                                                        for (com.google.android.gms.internal.measurement.zzhq zzhqVar : zziiVar.zze()) {
                                                                            if (zzhqVar.zza()) {
                                                                                Integer numValueOf10 = Integer.valueOf(zzhqVar.zzb());
                                                                                if (zzhqVar.zzc()) {
                                                                                    lValueOf = Long.valueOf(zzhqVar.zzd());
                                                                                } else {
                                                                                    lValueOf = null;
                                                                                }
                                                                                arrayMap.put(numValueOf10, lValueOf);
                                                                            }
                                                                        }
                                                                    }
                                                                    ArrayMap arrayMap10 = new ArrayMap();
                                                                    if (zziiVar != null) {
                                                                        for (com.google.android.gms.internal.measurement.zzik zzikVar : zziiVar.zzg()) {
                                                                            if (!zzikVar.zza()) {
                                                                            }
                                                                        }
                                                                    }
                                                                    Map map6 = map3;
                                                                    zziiVar2 = zziiVar;
                                                                    if (zziiVar2 != null) {
                                                                        i = 0;
                                                                        while (i < zziiVar2.zzb() * 64) {
                                                                            if (zzpk.zzn(zziiVar2.zza(), i)) {
                                                                                z6 = zZzp;
                                                                                this.zzu.zzaV().zzk().zzc("Filter already evaluated. audience ID, filter ID", Integer.valueOf(iIntValue), Integer.valueOf(i));
                                                                                bitSet2.set(i);
                                                                                if (zzpk.zzn(zziiVar2.zzc(), i)) {
                                                                                    bitSet.set(i);
                                                                                }
                                                                                i++;
                                                                                zZzp = z6;
                                                                            } else {
                                                                                z6 = zZzp;
                                                                            }
                                                                            arrayMap.remove(Integer.valueOf(i));
                                                                            i++;
                                                                            zZzp = z6;
                                                                        }
                                                                    }
                                                                    boolean z9 = zZzp;
                                                                    Integer numValueOf11 = Integer.valueOf(iIntValue);
                                                                    com.google.android.gms.internal.measurement.zzii zziiVar4 = (com.google.android.gms.internal.measurement.zzii) map2.get(numValueOf11);
                                                                    if (!zZzp2) {
                                                                    }
                                                                    this.zzc.put(Integer.valueOf(iIntValue), new zzy(this, this.zza, zziiVar4, bitSet, bitSet2, arrayMap, arrayMap10, null));
                                                                    zZzp = z9;
                                                                    map3 = map6;
                                                                }
                                                                str4 = str13;
                                                                bArr = null;
                                                                str5 = "Skipping failed audience ID";
                                                                if (!list.isEmpty()) {
                                                                    zzzVar = new zzz(this, bArr);
                                                                    arrayMap4 = new ArrayMap();
                                                                    it4 = list.iterator();
                                                                    while (it4.hasNext()) {
                                                                        zzhsVar = (com.google.android.gms.internal.measurement.zzhs) it4.next();
                                                                        zzhsVarZza = zzzVar.zza(this.zza, zzhsVar);
                                                                        if (zzhsVarZza != null) {
                                                                            zzpgVar = this.zzg;
                                                                            zzbcVarZzaf = zzpgVar.zzj().zzaf(this.zza, zzhsVar, zzhsVarZza.zzd());
                                                                            zzpgVar.zzj().zzh(zzbcVarZzaf);
                                                                            if (z) {
                                                                                continue;
                                                                            } else {
                                                                                j = zzbcVarZzaf.zzc;
                                                                                strZzd = zzhsVarZza.zzd();
                                                                                mapEmptyMap = (Map) arrayMap4.get(strZzd);
                                                                                if (mapEmptyMap == null) {
                                                                                    zzav zzavVarZzj7 = zzpgVar.zzj();
                                                                                    str7 = this.zza;
                                                                                    zzavVarZzj7.zzaw();
                                                                                    zzavVarZzj7.zzg();
                                                                                    Preconditions.checkNotEmpty(str7);
                                                                                    Preconditions.checkNotEmpty(strZzd);
                                                                                    arrayMap5 = new ArrayMap();
                                                                                    SQLiteDatabase sQLiteDatabaseZze3 = zzavVarZzj7.zze();
                                                                                    try {
                                                                                        try {
                                                                                            String[] strArr3 = new String[2];
                                                                                            str6 = str4;
                                                                                            try {
                                                                                                strArr3[0] = str6;
                                                                                                it5 = it4;
                                                                                                try {
                                                                                                    strArr3[1] = "data";
                                                                                                    Query2 = sQLiteDatabaseZze3.query("event_filters", strArr3, "app_id=? AND event_name=?", new String[]{str7, strZzd}, null, null, null);
                                                                                                    try {
                                                                                                        try {
                                                                                                            if (Query2.moveToFirst()) {
                                                                                                                zzbcVarZzaf = zzbcVarZzaf;
                                                                                                                i3 = 1;
                                                                                                                Query2 = Query2;
                                                                                                                r112 = r18;
                                                                                                                while (true) {
                                                                                                                    try {
                                                                                                                        try {
                                                                                                                            com.google.android.gms.internal.measurement.zzff zzffVar2 = (com.google.android.gms.internal.measurement.zzff) ((com.google.android.gms.internal.measurement.zzfe) zzpk.zzw(com.google.android.gms.internal.measurement.zzff.zzn(), Query2.getBlob(i3))).zzbc();
                                                                                                                            numValueOf3 = Integer.valueOf(Query2.getInt(0));
                                                                                                                            list5 = (List) arrayMap5.get(numValueOf3);
                                                                                                                            if (list5 == null) {
                                                                                                                                r112 = Query2;
                                                                                                                                try {
                                                                                                                                    arrayList2 = new ArrayList();
                                                                                                                                    arrayMap5.put(numValueOf3, arrayList2);
                                                                                                                                    r115 = r112;
                                                                                                                                } catch (SQLiteException e10) {
                                                                                                                                    e = e10;
                                                                                                                                    r7 = r112;
                                                                                                                                    r110 = r112;
                                                                                                                                    try {
                                                                                                                                        zzavVarZzj7.zzu.zzaV().zzb().zzc("Database error querying filters. appId", zzgu.zzl(str7), e);
                                                                                                                                        mapEmptyMap = Collections.emptyMap();
                                                                                                                                        r111 = r110;
                                                                                                                                        if (r7 != 0) {
                                                                                                                                            r7.close();
                                                                                                                                            r111 = r110;
                                                                                                                                        }
                                                                                                                                    } catch (Throwable th2) {
                                                                                                                                        th = th2;
                                                                                                                                        if (r7 != 0) {
                                                                                                                                            r7.close();
                                                                                                                                        }
                                                                                                                                        throw th;
                                                                                                                                    }
                                                                                                                                } catch (Throwable th3) {
                                                                                                                                    th = th3;
                                                                                                                                    r7 = r112;
                                                                                                                                    if (r7 != 0) {
                                                                                                                                        r7.close();
                                                                                                                                    }
                                                                                                                                    throw th;
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                r115 = Query2;
                                                                                                                                arrayList2 = list5;
                                                                                                                            }
                                                                                                                            arrayList2.add(zzffVar2);
                                                                                                                            r114 = r115;
                                                                                                                        } catch (IOException e11) {
                                                                                                                            r114 = Query2;
                                                                                                                            zzavVarZzj7.zzu.zzaV().zzb().zzc("Failed to merge filter. appId", zzgu.zzl(str7), e11);
                                                                                                                        }
                                                                                                                        if (!r114.moveToNext()) {
                                                                                                                            break;
                                                                                                                        }
                                                                                                                        Query2 = r114;
                                                                                                                        i3 = 1;
                                                                                                                        r112 = r114;
                                                                                                                    } catch (SQLiteException e12) {
                                                                                                                        e = e12;
                                                                                                                        r112 = Query2;
                                                                                                                    }
                                                                                                                }
                                                                                                                if (r114 != 0) {
                                                                                                                    r114.close();
                                                                                                                }
                                                                                                                mapEmptyMap = arrayMap5;
                                                                                                                r111 = r114;
                                                                                                            } else {
                                                                                                                r113 = Query2;
                                                                                                                zzbcVarZzaf = zzbcVarZzaf;
                                                                                                                mapEmptyMap = Collections.emptyMap();
                                                                                                                r111 = r113;
                                                                                                                if (r113 != 0) {
                                                                                                                    r113.close();
                                                                                                                    r111 = r113;
                                                                                                                }
                                                                                                            }
                                                                                                        } catch (SQLiteException e13) {
                                                                                                            e = e13;
                                                                                                            r112 = Query2;
                                                                                                            zzbcVarZzaf = zzbcVarZzaf;
                                                                                                        }
                                                                                                        arrayMap4.put(strZzd, mapEmptyMap);
                                                                                                        r18 = r111;
                                                                                                    } catch (Throwable th4) {
                                                                                                        th = th4;
                                                                                                        r112 = Query2;
                                                                                                    }
                                                                                                } catch (SQLiteException e14) {
                                                                                                    e = e14;
                                                                                                    r7 = 0;
                                                                                                    r110 = r18;
                                                                                                    zzavVarZzj7.zzu.zzaV().zzb().zzc("Database error querying filters. appId", zzgu.zzl(str7), e);
                                                                                                    mapEmptyMap = Collections.emptyMap();
                                                                                                    r111 = r110;
                                                                                                    if (r7 != 0) {
                                                                                                        r7.close();
                                                                                                        r111 = r110;
                                                                                                    }
                                                                                                    arrayMap4.put(strZzd, mapEmptyMap);
                                                                                                    r18 = r111;
                                                                                                    it6 = mapEmptyMap.keySet().iterator();
                                                                                                    while (it6.hasNext()) {
                                                                                                        iIntValue2 = ((Integer) it6.next()).intValue();
                                                                                                        set = this.zzb;
                                                                                                        numValueOf2 = Integer.valueOf(iIntValue2);
                                                                                                        if (set.contains(numValueOf2)) {
                                                                                                            this.zzu.zzaV().zzk().zzb("Skipping failed audience ID", numValueOf2);
                                                                                                        } else {
                                                                                                            it7 = ((List) mapEmptyMap.get(numValueOf2)).iterator();
                                                                                                            zZzd = true;
                                                                                                            r19 = r18;
                                                                                                            while (true) {
                                                                                                                if (!it7.hasNext()) {
                                                                                                                    map5 = mapEmptyMap;
                                                                                                                    j2 = j;
                                                                                                                    r18 = r19;
                                                                                                                    break;
                                                                                                                }
                                                                                                                com.google.android.gms.internal.measurement.zzff zzffVar3 = (com.google.android.gms.internal.measurement.zzff) it7.next();
                                                                                                                zzaaVar = new zzaa(this, this.zza, iIntValue2, zzffVar3);
                                                                                                                map5 = mapEmptyMap;
                                                                                                                j2 = j;
                                                                                                                l3 = this.zzd;
                                                                                                                zZzd = zzaaVar.zzd(l3, this.zze, zzhsVarZza, j2, zzbcVarZzaf, zzd(iIntValue2, zzffVar3.zzb()));
                                                                                                                if (!zZzd) {
                                                                                                                    this.zzb.add(Integer.valueOf(iIntValue2));
                                                                                                                    r18 = l3;
                                                                                                                    break;
                                                                                                                }
                                                                                                                zzc(Integer.valueOf(iIntValue2)).zza(zzaaVar);
                                                                                                                j = j2;
                                                                                                                mapEmptyMap = map5;
                                                                                                                r19 = l3;
                                                                                                            }
                                                                                                            if (!zZzd) {
                                                                                                                this.zzb.add(Integer.valueOf(iIntValue2));
                                                                                                            }
                                                                                                            j = j2;
                                                                                                            mapEmptyMap = map5;
                                                                                                        }
                                                                                                    }
                                                                                                    it4 = it5;
                                                                                                    str4 = str6;
                                                                                                    zzzVar = zzzVar;
                                                                                                }
                                                                                            } catch (SQLiteException e15) {
                                                                                                e = e15;
                                                                                                it5 = it4;
                                                                                            }
                                                                                        } catch (SQLiteException e16) {
                                                                                            e = e16;
                                                                                            it5 = it4;
                                                                                            str6 = str4;
                                                                                        }
                                                                                    } catch (Throwable th5) {
                                                                                        th = th5;
                                                                                        r7 = 0;
                                                                                    }
                                                                                } else {
                                                                                    it5 = it4;
                                                                                    zzbcVarZzaf = zzbcVarZzaf;
                                                                                    str6 = str4;
                                                                                    r18 = r18;
                                                                                }
                                                                                it6 = mapEmptyMap.keySet().iterator();
                                                                                while (it6.hasNext()) {
                                                                                    iIntValue2 = ((Integer) it6.next()).intValue();
                                                                                    set = this.zzb;
                                                                                    numValueOf2 = Integer.valueOf(iIntValue2);
                                                                                    if (set.contains(numValueOf2)) {
                                                                                        this.zzu.zzaV().zzk().zzb("Skipping failed audience ID", numValueOf2);
                                                                                    } else {
                                                                                        it7 = ((List) mapEmptyMap.get(numValueOf2)).iterator();
                                                                                        zZzd = true;
                                                                                        r19 = r18;
                                                                                        while (true) {
                                                                                            if (!it7.hasNext()) {
                                                                                                map5 = mapEmptyMap;
                                                                                                j2 = j;
                                                                                                r18 = r19;
                                                                                                break;
                                                                                            }
                                                                                            com.google.android.gms.internal.measurement.zzff zzffVar4 = (com.google.android.gms.internal.measurement.zzff) it7.next();
                                                                                            zzaaVar = new zzaa(this, this.zza, iIntValue2, zzffVar4);
                                                                                            map5 = mapEmptyMap;
                                                                                            j2 = j;
                                                                                            l3 = this.zzd;
                                                                                            zZzd = zzaaVar.zzd(l3, this.zze, zzhsVarZza, j2, zzbcVarZzaf, zzd(iIntValue2, zzffVar4.zzb()));
                                                                                            if (!zZzd) {
                                                                                                this.zzb.add(Integer.valueOf(iIntValue2));
                                                                                                r18 = l3;
                                                                                                break;
                                                                                            }
                                                                                            zzc(Integer.valueOf(iIntValue2)).zza(zzaaVar);
                                                                                            j = j2;
                                                                                            mapEmptyMap = map5;
                                                                                            r19 = l3;
                                                                                        }
                                                                                        if (!zZzd) {
                                                                                            this.zzb.add(Integer.valueOf(iIntValue2));
                                                                                        }
                                                                                        j = j2;
                                                                                        mapEmptyMap = map5;
                                                                                    }
                                                                                }
                                                                                it4 = it5;
                                                                                str4 = str6;
                                                                                zzzVar = zzzVar;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                str8 = str4;
                                                                if (!z) {
                                                                    return new ArrayList();
                                                                }
                                                                if (!list2.isEmpty()) {
                                                                    arrayMap6 = new ArrayMap();
                                                                    it9 = list2.iterator();
                                                                    while (it9.hasNext()) {
                                                                        com.google.android.gms.internal.measurement.zziu zziuVar = (com.google.android.gms.internal.measurement.zziu) it9.next();
                                                                        strZzc = zziuVar.zzc();
                                                                        mapEmptyMap2 = (Map) arrayMap6.get(strZzc);
                                                                        if (mapEmptyMap2 == null) {
                                                                            zzavVarZzj3 = this.zzg.zzj();
                                                                            str10 = this.zza;
                                                                            zzavVarZzj3.zzaw();
                                                                            zzavVarZzj3.zzg();
                                                                            Preconditions.checkNotEmpty(str10);
                                                                            Preconditions.checkNotEmpty(strZzc);
                                                                            arrayMap7 = new ArrayMap();
                                                                            try {
                                                                                i4 = 1;
                                                                                cursorQuery = zzavVarZzj3.zze().query("property_filters", new String[]{str8, "data"}, "app_id=? AND property_name=?", new String[]{str10, strZzc}, null, null, null);
                                                                                try {
                                                                                    try {
                                                                                        if (cursorQuery.moveToFirst()) {
                                                                                            while (true) {
                                                                                                try {
                                                                                                    com.google.android.gms.internal.measurement.zzfn zzfnVar2 = (com.google.android.gms.internal.measurement.zzfn) ((com.google.android.gms.internal.measurement.zzfm) zzpk.zzw(com.google.android.gms.internal.measurement.zzfn.zzi(), cursorQuery.getBlob(i4))).zzbc();
                                                                                                    numValueOf7 = Integer.valueOf(cursorQuery.getInt(0));
                                                                                                    list6 = (List) arrayMap7.get(numValueOf7);
                                                                                                    if (list6 == null) {
                                                                                                        arrayList4 = new ArrayList();
                                                                                                        arrayMap7.put(numValueOf7, arrayList4);
                                                                                                    } else {
                                                                                                        arrayList4 = list6;
                                                                                                    }
                                                                                                    arrayList4.add(zzfnVar2);
                                                                                                } catch (IOException e17) {
                                                                                                    zzavVarZzj3.zzu.zzaV().zzb().zzc("Failed to merge filter", zzgu.zzl(str10), e17);
                                                                                                }
                                                                                                try {
                                                                                                    if (!cursorQuery.moveToNext()) {
                                                                                                        break;
                                                                                                    }
                                                                                                    it9 = it9;
                                                                                                    i4 = 1;
                                                                                                } catch (SQLiteException e18) {
                                                                                                    e = e18;
                                                                                                    cursor = cursorQuery;
                                                                                                    try {
                                                                                                        zzavVarZzj3.zzu.zzaV().zzb().zzc("Database error querying filters. appId", zzgu.zzl(str10), e);
                                                                                                        mapEmptyMap2 = Collections.emptyMap();
                                                                                                        if (cursor != null) {
                                                                                                            cursor.close();
                                                                                                        }
                                                                                                    } catch (Throwable th6) {
                                                                                                        th = th6;
                                                                                                        if (cursor != null) {
                                                                                                            cursor.close();
                                                                                                        }
                                                                                                        throw th;
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            if (cursorQuery != null) {
                                                                                                cursorQuery.close();
                                                                                            }
                                                                                            mapEmptyMap2 = arrayMap7;
                                                                                        } else {
                                                                                            it9 = it9;
                                                                                            mapEmptyMap2 = Collections.emptyMap();
                                                                                            if (cursorQuery != null) {
                                                                                                cursorQuery.close();
                                                                                            }
                                                                                        }
                                                                                    } catch (SQLiteException e19) {
                                                                                        e = e19;
                                                                                        it9 = it9;
                                                                                    }
                                                                                    arrayMap6.put(strZzc, mapEmptyMap2);
                                                                                } catch (Throwable th7) {
                                                                                    th = th7;
                                                                                    cursor = cursorQuery;
                                                                                    if (cursor != null) {
                                                                                        cursor.close();
                                                                                    }
                                                                                    throw th;
                                                                                }
                                                                            } catch (SQLiteException e20) {
                                                                                e = e20;
                                                                                it9 = it9;
                                                                                cursor = null;
                                                                            } catch (Throwable th8) {
                                                                                th = th8;
                                                                                cursor = null;
                                                                            }
                                                                        } else {
                                                                            it9 = it9;
                                                                        }
                                                                        it10 = mapEmptyMap2.keySet().iterator();
                                                                        while (it10.hasNext()) {
                                                                            iIntValue3 = ((Integer) it10.next()).intValue();
                                                                            set2 = this.zzb;
                                                                            numValueOf4 = Integer.valueOf(iIntValue3);
                                                                            if (set2.contains(numValueOf4)) {
                                                                                this.zzu.zzaV().zzk().zzb(str5, numValueOf4);
                                                                                break;
                                                                            }
                                                                            it11 = ((List) mapEmptyMap2.get(numValueOf4)).iterator();
                                                                            zZzd2 = true;
                                                                            while (true) {
                                                                                if (it11.hasNext()) {
                                                                                    zzfnVar = (com.google.android.gms.internal.measurement.zzfn) it11.next();
                                                                                    zzicVar = this.zzu;
                                                                                    if (Log.isLoggable(zzicVar.zzaV().zzn(), 2)) {
                                                                                        zzgs zzgsVarZzk = zzicVar.zzaV().zzk();
                                                                                        Integer numValueOf12 = Integer.valueOf(iIntValue3);
                                                                                        if (zzfnVar.zza()) {
                                                                                            numValueOf6 = Integer.valueOf(zzfnVar.zzb());
                                                                                        } else {
                                                                                            numValueOf6 = null;
                                                                                        }
                                                                                        zzgsVarZzk.zzd("Evaluating filter. audience, filter, property", numValueOf12, numValueOf6, zzicVar.zzl().zzc(zzfnVar.zzc()));
                                                                                        zzicVar.zzaV().zzk().zzb("Filter definition", this.zzg.zzp().zzk(zzfnVar));
                                                                                    }
                                                                                    if (zzfnVar.zza()) {
                                                                                    }
                                                                                    zzgs zzgsVarZze = zzicVar.zzaV().zze();
                                                                                    Object objZzl2 = zzgu.zzl(this.zza);
                                                                                    if (zzfnVar.zza()) {
                                                                                        numValueOf5 = Integer.valueOf(zzfnVar.zzb());
                                                                                    } else {
                                                                                        numValueOf5 = null;
                                                                                    }
                                                                                    zzgsVarZze.zzc("Invalid property filter ID. appId, id", objZzl2, String.valueOf(numValueOf5));
                                                                                    this.zzb.add(Integer.valueOf(iIntValue3));
                                                                                    mapEmptyMap2 = mapEmptyMap2;
                                                                                    str5 = str5;
                                                                                } else {
                                                                                    mapEmptyMap2 = mapEmptyMap2;
                                                                                    str5 = str5;
                                                                                }
                                                                                if (!zZzd2) {
                                                                                    this.zzb.add(Integer.valueOf(iIntValue3));
                                                                                }
                                                                                mapEmptyMap2 = mapEmptyMap2;
                                                                                str5 = str5;
                                                                                zzc(Integer.valueOf(iIntValue3)).zza(zzacVar);
                                                                                mapEmptyMap2 = mapEmptyMap2;
                                                                                str5 = str5;
                                                                            }
                                                                        }
                                                                        it9 = it9;
                                                                    }
                                                                }
                                                                arrayList3 = new ArrayList();
                                                                Set setKeySet = this.zzc.keySet();
                                                                setKeySet.removeAll(this.zzb);
                                                                it8 = setKeySet.iterator();
                                                                while (it8.hasNext()) {
                                                                    int iIntValue5 = ((Integer) it8.next()).intValue();
                                                                    Map map7 = this.zzc;
                                                                    Integer numValueOf13 = Integer.valueOf(iIntValue5);
                                                                    zzy zzyVar = (zzy) map7.get(numValueOf13);
                                                                    Preconditions.checkNotNull(zzyVar);
                                                                    com.google.android.gms.internal.measurement.zzhg zzhgVarZzb = zzyVar.zzb(iIntValue5);
                                                                    arrayList3.add(zzhgVarZzb);
                                                                    zzavVarZzj2 = this.zzg.zzj();
                                                                    str9 = this.zza;
                                                                    com.google.android.gms.internal.measurement.zzii zziiVarZzc = zzhgVarZzb.zzc();
                                                                    zzavVarZzj2.zzaw();
                                                                    zzavVarZzj2.zzg();
                                                                    Preconditions.checkNotEmpty(str9);
                                                                    Preconditions.checkNotNull(zziiVarZzc);
                                                                    byte[] bArrZzcc = zziiVarZzc.zzcc();
                                                                    contentValues = new ContentValues();
                                                                    contentValues.put("app_id", str9);
                                                                    contentValues.put(str8, numValueOf13);
                                                                    contentValues.put("current_results", bArrZzcc);
                                                                    try {
                                                                        try {
                                                                            if (zzavVarZzj2.zze().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                                                                                zzavVarZzj2.zzu.zzaV().zzb().zzb("Failed to insert filter results (got -1). appId", zzgu.zzl(str9));
                                                                            }
                                                                        } catch (SQLiteException e21) {
                                                                            e = e21;
                                                                            zzavVarZzj2.zzu.zzaV().zzb().zzc("Error storing filter results. appId", zzgu.zzl(str9), e);
                                                                        }
                                                                    } catch (SQLiteException e22) {
                                                                        e = e22;
                                                                    }
                                                                }
                                                                return arrayList3;
                                                            }
                                                        } catch (SQLiteException e23) {
                                                            e = e23;
                                                            cursorRawQuery = null;
                                                        } catch (Throwable th9) {
                                                            th = th9;
                                                            r6 = 0;
                                                            if (r6 != 0) {
                                                                r6.close();
                                                            }
                                                            throw th;
                                                        }
                                                        Preconditions.checkNotEmpty(str16);
                                                        Preconditions.checkNotNull(map2);
                                                        arrayMap3 = new ArrayMap();
                                                        if (!map2.isEmpty()) {
                                                            it2 = map2.keySet().iterator();
                                                            while (it2.hasNext()) {
                                                                int iIntValue6 = ((Integer) it2.next()).intValue();
                                                                Integer numValueOf14 = Integer.valueOf(iIntValue6);
                                                                zziiVar3 = (com.google.android.gms.internal.measurement.zzii) map2.get(numValueOf14);
                                                                list4 = (List) arrayMap2.get(numValueOf14);
                                                                if (list4 != null) {
                                                                }
                                                                map4 = arrayMap2;
                                                                it3 = it2;
                                                                arrayMap3.put(numValueOf14, zziiVar3);
                                                                arrayMap2 = map4;
                                                                it2 = it3;
                                                            }
                                                        }
                                                        map3 = arrayMap3;
                                                    } catch (Throwable th10) {
                                                        th = th10;
                                                        r6 = hashSet;
                                                    }
                                                } else {
                                                    map3 = map2;
                                                }
                                                it = hashSet.iterator();
                                                while (it.hasNext()) {
                                                    iIntValue = ((Integer) it.next()).intValue();
                                                    zziiVar = (com.google.android.gms.internal.measurement.zzii) map3.get(Integer.valueOf(iIntValue));
                                                    bitSet = new BitSet();
                                                    bitSet2 = new BitSet();
                                                    arrayMap = new ArrayMap();
                                                    if (zziiVar != null) {
                                                        while (r3.hasNext()) {
                                                            if (zzhqVar.zza()) {
                                                                Integer numValueOf15 = Integer.valueOf(zzhqVar.zzb());
                                                                if (zzhqVar.zzc()) {
                                                                    lValueOf = Long.valueOf(zzhqVar.zzd());
                                                                } else {
                                                                    lValueOf = null;
                                                                }
                                                                arrayMap.put(numValueOf15, lValueOf);
                                                            }
                                                        }
                                                    }
                                                    ArrayMap arrayMap11 = new ArrayMap();
                                                    if (zziiVar != null) {
                                                        while (r3.hasNext()) {
                                                            if (!zzikVar.zza()) {
                                                            }
                                                        }
                                                    }
                                                    Map map8 = map3;
                                                    zziiVar2 = zziiVar;
                                                    if (zziiVar2 != null) {
                                                        i = 0;
                                                        while (i < zziiVar2.zzb() * 64) {
                                                            if (zzpk.zzn(zziiVar2.zza(), i)) {
                                                                z6 = zZzp;
                                                                this.zzu.zzaV().zzk().zzc("Filter already evaluated. audience ID, filter ID", Integer.valueOf(iIntValue), Integer.valueOf(i));
                                                                bitSet2.set(i);
                                                                if (zzpk.zzn(zziiVar2.zzc(), i)) {
                                                                    bitSet.set(i);
                                                                }
                                                                i++;
                                                                zZzp = z6;
                                                            } else {
                                                                z6 = zZzp;
                                                            }
                                                            arrayMap.remove(Integer.valueOf(i));
                                                            i++;
                                                            zZzp = z6;
                                                        }
                                                    }
                                                    boolean z10 = zZzp;
                                                    Integer numValueOf16 = Integer.valueOf(iIntValue);
                                                    com.google.android.gms.internal.measurement.zzii zziiVar5 = (com.google.android.gms.internal.measurement.zzii) map2.get(numValueOf16);
                                                    if (!zZzp2) {
                                                    }
                                                    this.zzc.put(Integer.valueOf(iIntValue), new zzy(this, this.zza, zziiVar5, bitSet, bitSet2, arrayMap, arrayMap11, null));
                                                    zZzp = z10;
                                                    map3 = map8;
                                                }
                                            }
                                            str4 = str13;
                                            bArr = null;
                                            str5 = "Skipping failed audience ID";
                                            if (!list.isEmpty()) {
                                                zzzVar = new zzz(this, bArr);
                                                arrayMap4 = new ArrayMap();
                                                it4 = list.iterator();
                                                while (it4.hasNext()) {
                                                    zzhsVar = (com.google.android.gms.internal.measurement.zzhs) it4.next();
                                                    zzhsVarZza = zzzVar.zza(this.zza, zzhsVar);
                                                    if (zzhsVarZza != null) {
                                                        zzpgVar = this.zzg;
                                                        zzbcVarZzaf = zzpgVar.zzj().zzaf(this.zza, zzhsVar, zzhsVarZza.zzd());
                                                        zzpgVar.zzj().zzh(zzbcVarZzaf);
                                                        if (z) {
                                                            j = zzbcVarZzaf.zzc;
                                                            strZzd = zzhsVarZza.zzd();
                                                            mapEmptyMap = (Map) arrayMap4.get(strZzd);
                                                            if (mapEmptyMap == null) {
                                                                zzav zzavVarZzj8 = zzpgVar.zzj();
                                                                str7 = this.zza;
                                                                zzavVarZzj8.zzaw();
                                                                zzavVarZzj8.zzg();
                                                                Preconditions.checkNotEmpty(str7);
                                                                Preconditions.checkNotEmpty(strZzd);
                                                                arrayMap5 = new ArrayMap();
                                                                SQLiteDatabase sQLiteDatabaseZze4 = zzavVarZzj8.zze();
                                                                String[] strArr4 = new String[2];
                                                                str6 = str4;
                                                                strArr4[0] = str6;
                                                                it5 = it4;
                                                                strArr4[1] = "data";
                                                                Query2 = sQLiteDatabaseZze4.query("event_filters", strArr4, "app_id=? AND event_name=?", new String[]{str7, strZzd}, null, null, null);
                                                                if (Query2.moveToFirst()) {
                                                                    zzbcVarZzaf = zzbcVarZzaf;
                                                                    i3 = 1;
                                                                    Query2 = Query2;
                                                                    r112 = r18;
                                                                    while (true) {
                                                                        com.google.android.gms.internal.measurement.zzff zzffVar5 = (com.google.android.gms.internal.measurement.zzff) ((com.google.android.gms.internal.measurement.zzfe) zzpk.zzw(com.google.android.gms.internal.measurement.zzff.zzn(), Query2.getBlob(i3))).zzbc();
                                                                        numValueOf3 = Integer.valueOf(Query2.getInt(0));
                                                                        list5 = (List) arrayMap5.get(numValueOf3);
                                                                        if (list5 == null) {
                                                                            r112 = Query2;
                                                                            arrayList2 = new ArrayList();
                                                                            arrayMap5.put(numValueOf3, arrayList2);
                                                                            r115 = r112;
                                                                        } else {
                                                                            r115 = Query2;
                                                                            arrayList2 = list5;
                                                                        }
                                                                        arrayList2.add(zzffVar5);
                                                                        r114 = r115;
                                                                        if (!r114.moveToNext()) {
                                                                            break;
                                                                            break;
                                                                        }
                                                                        Query2 = r114;
                                                                        i3 = 1;
                                                                        r112 = r114;
                                                                    }
                                                                    if (r114 != 0) {
                                                                        r114.close();
                                                                    }
                                                                    mapEmptyMap = arrayMap5;
                                                                    r111 = r114;
                                                                } else {
                                                                    r113 = Query2;
                                                                    zzbcVarZzaf = zzbcVarZzaf;
                                                                    mapEmptyMap = Collections.emptyMap();
                                                                    r111 = r113;
                                                                    if (r113 != 0) {
                                                                        r113.close();
                                                                        r111 = r113;
                                                                    }
                                                                }
                                                                arrayMap4.put(strZzd, mapEmptyMap);
                                                                r18 = r111;
                                                            } else {
                                                                it5 = it4;
                                                                zzbcVarZzaf = zzbcVarZzaf;
                                                                str6 = str4;
                                                                r18 = r18;
                                                            }
                                                            it6 = mapEmptyMap.keySet().iterator();
                                                            while (it6.hasNext()) {
                                                                iIntValue2 = ((Integer) it6.next()).intValue();
                                                                set = this.zzb;
                                                                numValueOf2 = Integer.valueOf(iIntValue2);
                                                                if (set.contains(numValueOf2)) {
                                                                    this.zzu.zzaV().zzk().zzb("Skipping failed audience ID", numValueOf2);
                                                                } else {
                                                                    it7 = ((List) mapEmptyMap.get(numValueOf2)).iterator();
                                                                    zZzd = true;
                                                                    r19 = r18;
                                                                    while (true) {
                                                                        if (!it7.hasNext()) {
                                                                            map5 = mapEmptyMap;
                                                                            j2 = j;
                                                                            r18 = r19;
                                                                            break;
                                                                        }
                                                                        com.google.android.gms.internal.measurement.zzff zzffVar6 = (com.google.android.gms.internal.measurement.zzff) it7.next();
                                                                        zzaaVar = new zzaa(this, this.zza, iIntValue2, zzffVar6);
                                                                        map5 = mapEmptyMap;
                                                                        j2 = j;
                                                                        l3 = this.zzd;
                                                                        zZzd = zzaaVar.zzd(l3, this.zze, zzhsVarZza, j2, zzbcVarZzaf, zzd(iIntValue2, zzffVar6.zzb()));
                                                                        if (!zZzd) {
                                                                            this.zzb.add(Integer.valueOf(iIntValue2));
                                                                            r18 = l3;
                                                                            break;
                                                                        }
                                                                        zzc(Integer.valueOf(iIntValue2)).zza(zzaaVar);
                                                                        j = j2;
                                                                        mapEmptyMap = map5;
                                                                        r19 = l3;
                                                                    }
                                                                    if (!zZzd) {
                                                                        this.zzb.add(Integer.valueOf(iIntValue2));
                                                                    }
                                                                    j = j2;
                                                                    mapEmptyMap = map5;
                                                                }
                                                            }
                                                            it4 = it5;
                                                            str4 = str6;
                                                            zzzVar = zzzVar;
                                                        } else {
                                                            continue;
                                                        }
                                                    }
                                                }
                                            }
                                            str8 = str4;
                                            if (!z) {
                                                return new ArrayList();
                                            }
                                            if (!list2.isEmpty()) {
                                                arrayMap6 = new ArrayMap();
                                                it9 = list2.iterator();
                                                while (it9.hasNext()) {
                                                    com.google.android.gms.internal.measurement.zziu zziuVar2 = (com.google.android.gms.internal.measurement.zziu) it9.next();
                                                    strZzc = zziuVar2.zzc();
                                                    mapEmptyMap2 = (Map) arrayMap6.get(strZzc);
                                                    if (mapEmptyMap2 == null) {
                                                        zzavVarZzj3 = this.zzg.zzj();
                                                        str10 = this.zza;
                                                        zzavVarZzj3.zzaw();
                                                        zzavVarZzj3.zzg();
                                                        Preconditions.checkNotEmpty(str10);
                                                        Preconditions.checkNotEmpty(strZzc);
                                                        arrayMap7 = new ArrayMap();
                                                        i4 = 1;
                                                        cursorQuery = zzavVarZzj3.zze().query("property_filters", new String[]{str8, "data"}, "app_id=? AND property_name=?", new String[]{str10, strZzc}, null, null, null);
                                                        if (cursorQuery.moveToFirst()) {
                                                            while (true) {
                                                                com.google.android.gms.internal.measurement.zzfn zzfnVar3 = (com.google.android.gms.internal.measurement.zzfn) ((com.google.android.gms.internal.measurement.zzfm) zzpk.zzw(com.google.android.gms.internal.measurement.zzfn.zzi(), cursorQuery.getBlob(i4))).zzbc();
                                                                numValueOf7 = Integer.valueOf(cursorQuery.getInt(0));
                                                                list6 = (List) arrayMap7.get(numValueOf7);
                                                                if (list6 == null) {
                                                                    arrayList4 = new ArrayList();
                                                                    arrayMap7.put(numValueOf7, arrayList4);
                                                                } else {
                                                                    arrayList4 = list6;
                                                                }
                                                                arrayList4.add(zzfnVar3);
                                                                if (!cursorQuery.moveToNext()) {
                                                                    break;
                                                                    break;
                                                                }
                                                                it9 = it9;
                                                                i4 = 1;
                                                            }
                                                            if (cursorQuery != null) {
                                                                cursorQuery.close();
                                                            }
                                                            mapEmptyMap2 = arrayMap7;
                                                        } else {
                                                            it9 = it9;
                                                            mapEmptyMap2 = Collections.emptyMap();
                                                            if (cursorQuery != null) {
                                                                cursorQuery.close();
                                                            }
                                                        }
                                                        arrayMap6.put(strZzc, mapEmptyMap2);
                                                    } else {
                                                        it9 = it9;
                                                    }
                                                    it10 = mapEmptyMap2.keySet().iterator();
                                                    while (it10.hasNext()) {
                                                        iIntValue3 = ((Integer) it10.next()).intValue();
                                                        set2 = this.zzb;
                                                        numValueOf4 = Integer.valueOf(iIntValue3);
                                                        if (set2.contains(numValueOf4)) {
                                                            this.zzu.zzaV().zzk().zzb(str5, numValueOf4);
                                                            break;
                                                            break;
                                                        }
                                                        it11 = ((List) mapEmptyMap2.get(numValueOf4)).iterator();
                                                        zZzd2 = true;
                                                        while (true) {
                                                            if (it11.hasNext()) {
                                                                zzfnVar = (com.google.android.gms.internal.measurement.zzfn) it11.next();
                                                                zzicVar = this.zzu;
                                                                if (Log.isLoggable(zzicVar.zzaV().zzn(), 2)) {
                                                                    zzgs zzgsVarZzk2 = zzicVar.zzaV().zzk();
                                                                    Integer numValueOf17 = Integer.valueOf(iIntValue3);
                                                                    if (zzfnVar.zza()) {
                                                                        numValueOf6 = Integer.valueOf(zzfnVar.zzb());
                                                                    } else {
                                                                        numValueOf6 = null;
                                                                    }
                                                                    zzgsVarZzk2.zzd("Evaluating filter. audience, filter, property", numValueOf17, numValueOf6, zzicVar.zzl().zzc(zzfnVar.zzc()));
                                                                    zzicVar.zzaV().zzk().zzb("Filter definition", this.zzg.zzp().zzk(zzfnVar));
                                                                }
                                                                if (zzfnVar.zza()) {
                                                                }
                                                                zzgs zzgsVarZze2 = zzicVar.zzaV().zze();
                                                                Object objZzl3 = zzgu.zzl(this.zza);
                                                                if (zzfnVar.zza()) {
                                                                    numValueOf5 = Integer.valueOf(zzfnVar.zzb());
                                                                } else {
                                                                    numValueOf5 = null;
                                                                }
                                                                zzgsVarZze2.zzc("Invalid property filter ID. appId, id", objZzl3, String.valueOf(numValueOf5));
                                                                this.zzb.add(Integer.valueOf(iIntValue3));
                                                                mapEmptyMap2 = mapEmptyMap2;
                                                                str5 = str5;
                                                            } else {
                                                                mapEmptyMap2 = mapEmptyMap2;
                                                                str5 = str5;
                                                            }
                                                            if (!zZzd2) {
                                                                this.zzb.add(Integer.valueOf(iIntValue3));
                                                            }
                                                            mapEmptyMap2 = mapEmptyMap2;
                                                            str5 = str5;
                                                            zzc(Integer.valueOf(iIntValue3)).zza(zzacVar);
                                                            mapEmptyMap2 = mapEmptyMap2;
                                                            str5 = str5;
                                                        }
                                                    }
                                                    it9 = it9;
                                                }
                                            }
                                            arrayList3 = new ArrayList();
                                            Set setKeySet2 = this.zzc.keySet();
                                            setKeySet2.removeAll(this.zzb);
                                            it8 = setKeySet2.iterator();
                                            while (it8.hasNext()) {
                                                int iIntValue7 = ((Integer) it8.next()).intValue();
                                                Map map9 = this.zzc;
                                                Integer numValueOf18 = Integer.valueOf(iIntValue7);
                                                zzy zzyVar2 = (zzy) map9.get(numValueOf18);
                                                Preconditions.checkNotNull(zzyVar2);
                                                com.google.android.gms.internal.measurement.zzhg zzhgVarZzb2 = zzyVar2.zzb(iIntValue7);
                                                arrayList3.add(zzhgVarZzb2);
                                                zzavVarZzj2 = this.zzg.zzj();
                                                str9 = this.zza;
                                                com.google.android.gms.internal.measurement.zzii zziiVarZzc2 = zzhgVarZzb2.zzc();
                                                zzavVarZzj2.zzaw();
                                                zzavVarZzj2.zzg();
                                                Preconditions.checkNotEmpty(str9);
                                                Preconditions.checkNotNull(zziiVarZzc2);
                                                byte[] bArrZzcc2 = zziiVarZzc2.zzcc();
                                                contentValues = new ContentValues();
                                                contentValues.put("app_id", str9);
                                                contentValues.put(str8, numValueOf18);
                                                contentValues.put("current_results", bArrZzcc2);
                                                if (zzavVarZzj2.zze().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                                                    zzavVarZzj2.zzu.zzaV().zzb().zzb("Failed to insert filter results (got -1). appId", zzgu.zzl(str9));
                                                }
                                            }
                                            return arrayList3;
                                        }
                                    }
                                    try {
                                        if (!Query.moveToNext()) {
                                            break;
                                        }
                                        z7 = z4 ? 1 : 0;
                                        str13 = str13;
                                        r12 = 0;
                                    } catch (SQLiteException e24) {
                                        e = e24;
                                        zzavVarZzj6.zzu.zzaV().zzb().zzc("Database error querying filter results. appId", zzgu.zzl(str15), e);
                                        Map mapEmptyMap5 = Collections.emptyMap();
                                        if (Query != 0) {
                                            Query.close();
                                        }
                                        map2 = mapEmptyMap5;
                                        r18 = str2;
                                        z5 = z4;
                                    }
                                }
                                if (Query != 0) {
                                    Query.close();
                                }
                                map2 = arrayMap8;
                                r18 = "audience_filter_values";
                                z5 = z4;
                            } else {
                                Map mapEmptyMap6 = Collections.emptyMap();
                                if (Query != 0) {
                                    Query.close();
                                }
                                map2 = mapEmptyMap6;
                                z5 = z3 ? 1 : 0;
                                str13 = "audience_id";
                                r18 = "audience_filter_values";
                            }
                            if (!map2.isEmpty()) {
                                HashSet hashSet2 = new HashSet(map2.keySet());
                                if (z5) {
                                    String str17 = this.zza;
                                    zzavVarZzj = this.zzg.zzj();
                                    str3 = this.zza;
                                    zzavVarZzj.zzaw();
                                    zzavVarZzj.zzg();
                                    Preconditions.checkNotEmpty(str3);
                                    arrayMap2 = new ArrayMap();
                                    i2 = 0;
                                    cursorRawQuery = zzavVarZzj.zze().rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str3, str3});
                                    if (cursorRawQuery.moveToFirst()) {
                                        while (true) {
                                            numValueOf = Integer.valueOf(cursorRawQuery.getInt(i2));
                                            arrayList = (List) arrayMap2.get(numValueOf);
                                            if (arrayList == null) {
                                                arrayList = new ArrayList();
                                                arrayMap2.put(numValueOf, arrayList);
                                            }
                                            arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                                            if (!cursorRawQuery.moveToNext()) {
                                                break;
                                                break;
                                            }
                                            i2 = 0;
                                        }
                                        if (cursorRawQuery != null) {
                                            cursorRawQuery.close();
                                        }
                                    } else {
                                        arrayMap2 = Collections.emptyMap();
                                        if (cursorRawQuery != null) {
                                            cursorRawQuery.close();
                                        }
                                    }
                                    Preconditions.checkNotEmpty(str17);
                                    Preconditions.checkNotNull(map2);
                                    arrayMap3 = new ArrayMap();
                                    if (!map2.isEmpty()) {
                                        it2 = map2.keySet().iterator();
                                        while (it2.hasNext()) {
                                            int iIntValue8 = ((Integer) it2.next()).intValue();
                                            Integer numValueOf19 = Integer.valueOf(iIntValue8);
                                            zziiVar3 = (com.google.android.gms.internal.measurement.zzii) map2.get(numValueOf19);
                                            list4 = (List) arrayMap2.get(numValueOf19);
                                            if (list4 != null || list4.isEmpty()) {
                                                map4 = arrayMap2;
                                                it3 = it2;
                                                arrayMap3.put(numValueOf19, zziiVar3);
                                                arrayMap2 = map4;
                                                it2 = it3;
                                            } else {
                                                zzpg zzpgVar2 = this.zzg;
                                                map4 = arrayMap2;
                                                List listZzq = zzpgVar2.zzp().zzq(zziiVar3.zzc(), list4);
                                                if (listZzq.isEmpty()) {
                                                    arrayMap2 = map4;
                                                } else {
                                                    com.google.android.gms.internal.measurement.zzih zzihVar = (com.google.android.gms.internal.measurement.zzih) zziiVar3.zzcl();
                                                    zzihVar.zzd();
                                                    zzihVar.zzc(listZzq);
                                                    List listZzq2 = zzpgVar2.zzp().zzq(zziiVar3.zza(), list4);
                                                    zzihVar.zzb();
                                                    zzihVar.zza(listZzq2);
                                                    ArrayList arrayList6 = new ArrayList();
                                                    for (com.google.android.gms.internal.measurement.zzhq zzhqVar2 : zziiVar3.zze()) {
                                                        Iterator it13 = it2;
                                                        int i6 = iIntValue8;
                                                        if (!list4.contains(Integer.valueOf(zzhqVar2.zzb()))) {
                                                            arrayList6.add(zzhqVar2);
                                                        }
                                                        it2 = it13;
                                                        iIntValue8 = i6;
                                                    }
                                                    it3 = it2;
                                                    int i7 = iIntValue8;
                                                    zzihVar.zzf();
                                                    zzihVar.zze(arrayList6);
                                                    ArrayList arrayList7 = new ArrayList();
                                                    for (com.google.android.gms.internal.measurement.zzik zzikVar2 : zziiVar3.zzg()) {
                                                        if (!list4.contains(Integer.valueOf(zzikVar2.zzb()))) {
                                                            arrayList7.add(zzikVar2);
                                                        }
                                                    }
                                                    zzihVar.zzh();
                                                    zzihVar.zzg(arrayList7);
                                                    arrayMap3.put(Integer.valueOf(i7), (com.google.android.gms.internal.measurement.zzii) zzihVar.zzbc());
                                                    arrayMap2 = map4;
                                                    it2 = it3;
                                                }
                                            }
                                        }
                                    }
                                    map3 = arrayMap3;
                                } else {
                                    map3 = map2;
                                }
                                it = hashSet2.iterator();
                                while (it.hasNext()) {
                                    iIntValue = ((Integer) it.next()).intValue();
                                    zziiVar = (com.google.android.gms.internal.measurement.zzii) map3.get(Integer.valueOf(iIntValue));
                                    bitSet = new BitSet();
                                    bitSet2 = new BitSet();
                                    arrayMap = new ArrayMap();
                                    if (zziiVar != null && zziiVar.zzf() != 0) {
                                        while (r3.hasNext()) {
                                            if (zzhqVar.zza()) {
                                                Integer numValueOf110 = Integer.valueOf(zzhqVar.zzb());
                                                if (zzhqVar.zzc()) {
                                                    lValueOf = Long.valueOf(zzhqVar.zzd());
                                                } else {
                                                    lValueOf = null;
                                                }
                                                arrayMap.put(numValueOf110, lValueOf);
                                            }
                                        }
                                    }
                                    ArrayMap arrayMap12 = new ArrayMap();
                                    if (zziiVar != null && zziiVar.zzh() != 0) {
                                        while (r3.hasNext()) {
                                            if (!zzikVar.zza() && zzikVar.zzd() > 0) {
                                                arrayMap12.put(Integer.valueOf(zzikVar.zzb()), Long.valueOf(zzikVar.zze(zzikVar.zzd() - 1)));
                                                map3 = map3;
                                                zziiVar = zziiVar;
                                            }
                                        }
                                    }
                                    Map map10 = map3;
                                    zziiVar2 = zziiVar;
                                    if (zziiVar2 != null) {
                                        i = 0;
                                        while (i < zziiVar2.zzb() * 64) {
                                            if (zzpk.zzn(zziiVar2.zza(), i)) {
                                                z6 = zZzp;
                                                this.zzu.zzaV().zzk().zzc("Filter already evaluated. audience ID, filter ID", Integer.valueOf(iIntValue), Integer.valueOf(i));
                                                bitSet2.set(i);
                                                if (zzpk.zzn(zziiVar2.zzc(), i)) {
                                                    bitSet.set(i);
                                                }
                                                i++;
                                                zZzp = z6;
                                            } else {
                                                z6 = zZzp;
                                            }
                                            arrayMap.remove(Integer.valueOf(i));
                                            i++;
                                            zZzp = z6;
                                        }
                                    }
                                    boolean z11 = zZzp;
                                    Integer numValueOf111 = Integer.valueOf(iIntValue);
                                    com.google.android.gms.internal.measurement.zzii zziiVar6 = (com.google.android.gms.internal.measurement.zzii) map2.get(numValueOf111);
                                    if (!zZzp2 && z11 && (list3 = (List) map.get(numValueOf111)) != null && this.zze != null && this.zzd != null) {
                                        for (com.google.android.gms.internal.measurement.zzff zzffVar7 : list3) {
                                            int iZzb = zzffVar7.zzb();
                                            long jLongValue = this.zze.longValue() / 1000;
                                            if (zzffVar7.zzj()) {
                                                jLongValue = this.zzd.longValue() / 1000;
                                            }
                                            Integer numValueOf20 = Integer.valueOf(iZzb);
                                            if (arrayMap.containsKey(numValueOf20)) {
                                                arrayMap.put(numValueOf20, Long.valueOf(jLongValue));
                                            }
                                            if (arrayMap12.containsKey(numValueOf20)) {
                                                arrayMap12.put(numValueOf20, Long.valueOf(jLongValue));
                                            }
                                        }
                                    }
                                    this.zzc.put(Integer.valueOf(iIntValue), new zzy(this, this.zza, zziiVar6, bitSet, bitSet2, arrayMap, arrayMap12, null));
                                    zZzp = z11;
                                    map3 = map10;
                                }
                            }
                            str4 = str13;
                            bArr = null;
                            str5 = "Skipping failed audience ID";
                            if (!list.isEmpty()) {
                                zzzVar = new zzz(this, bArr);
                                arrayMap4 = new ArrayMap();
                                it4 = list.iterator();
                                while (it4.hasNext()) {
                                    zzhsVar = (com.google.android.gms.internal.measurement.zzhs) it4.next();
                                    zzhsVarZza = zzzVar.zza(this.zza, zzhsVar);
                                    if (zzhsVarZza != null) {
                                        zzpgVar = this.zzg;
                                        zzbcVarZzaf = zzpgVar.zzj().zzaf(this.zza, zzhsVar, zzhsVarZza.zzd());
                                        zzpgVar.zzj().zzh(zzbcVarZzaf);
                                        if (z) {
                                            j = zzbcVarZzaf.zzc;
                                            strZzd = zzhsVarZza.zzd();
                                            mapEmptyMap = (Map) arrayMap4.get(strZzd);
                                            if (mapEmptyMap == null) {
                                                zzav zzavVarZzj9 = zzpgVar.zzj();
                                                str7 = this.zza;
                                                zzavVarZzj9.zzaw();
                                                zzavVarZzj9.zzg();
                                                Preconditions.checkNotEmpty(str7);
                                                Preconditions.checkNotEmpty(strZzd);
                                                arrayMap5 = new ArrayMap();
                                                SQLiteDatabase sQLiteDatabaseZze5 = zzavVarZzj9.zze();
                                                String[] strArr5 = new String[2];
                                                str6 = str4;
                                                strArr5[0] = str6;
                                                it5 = it4;
                                                strArr5[1] = "data";
                                                Query2 = sQLiteDatabaseZze5.query("event_filters", strArr5, "app_id=? AND event_name=?", new String[]{str7, strZzd}, null, null, null);
                                                if (Query2.moveToFirst()) {
                                                    zzbcVarZzaf = zzbcVarZzaf;
                                                    i3 = 1;
                                                    Query2 = Query2;
                                                    r112 = r18;
                                                    while (true) {
                                                        com.google.android.gms.internal.measurement.zzff zzffVar8 = (com.google.android.gms.internal.measurement.zzff) ((com.google.android.gms.internal.measurement.zzfe) zzpk.zzw(com.google.android.gms.internal.measurement.zzff.zzn(), Query2.getBlob(i3))).zzbc();
                                                        numValueOf3 = Integer.valueOf(Query2.getInt(0));
                                                        list5 = (List) arrayMap5.get(numValueOf3);
                                                        if (list5 == null) {
                                                            r112 = Query2;
                                                            arrayList2 = new ArrayList();
                                                            arrayMap5.put(numValueOf3, arrayList2);
                                                            r115 = r112;
                                                        } else {
                                                            r115 = Query2;
                                                            arrayList2 = list5;
                                                        }
                                                        arrayList2.add(zzffVar8);
                                                        r114 = r115;
                                                        if (!r114.moveToNext()) {
                                                            break;
                                                            break;
                                                        }
                                                        Query2 = r114;
                                                        i3 = 1;
                                                        r112 = r114;
                                                    }
                                                    if (r114 != 0) {
                                                        r114.close();
                                                    }
                                                    mapEmptyMap = arrayMap5;
                                                    r111 = r114;
                                                } else {
                                                    r113 = Query2;
                                                    zzbcVarZzaf = zzbcVarZzaf;
                                                    mapEmptyMap = Collections.emptyMap();
                                                    r111 = r113;
                                                    if (r113 != 0) {
                                                        r113.close();
                                                        r111 = r113;
                                                    }
                                                }
                                                arrayMap4.put(strZzd, mapEmptyMap);
                                                r18 = r111;
                                            } else {
                                                it5 = it4;
                                                zzbcVarZzaf = zzbcVarZzaf;
                                                str6 = str4;
                                                r18 = r18;
                                            }
                                            it6 = mapEmptyMap.keySet().iterator();
                                            while (it6.hasNext()) {
                                                iIntValue2 = ((Integer) it6.next()).intValue();
                                                set = this.zzb;
                                                numValueOf2 = Integer.valueOf(iIntValue2);
                                                if (set.contains(numValueOf2)) {
                                                    this.zzu.zzaV().zzk().zzb("Skipping failed audience ID", numValueOf2);
                                                } else {
                                                    it7 = ((List) mapEmptyMap.get(numValueOf2)).iterator();
                                                    zZzd = true;
                                                    r19 = r18;
                                                    while (true) {
                                                        if (!it7.hasNext()) {
                                                            map5 = mapEmptyMap;
                                                            j2 = j;
                                                            r18 = r19;
                                                            break;
                                                        }
                                                        com.google.android.gms.internal.measurement.zzff zzffVar9 = (com.google.android.gms.internal.measurement.zzff) it7.next();
                                                        zzaaVar = new zzaa(this, this.zza, iIntValue2, zzffVar9);
                                                        map5 = mapEmptyMap;
                                                        j2 = j;
                                                        l3 = this.zzd;
                                                        zZzd = zzaaVar.zzd(l3, this.zze, zzhsVarZza, j2, zzbcVarZzaf, zzd(iIntValue2, zzffVar9.zzb()));
                                                        if (!zZzd) {
                                                            this.zzb.add(Integer.valueOf(iIntValue2));
                                                            r18 = l3;
                                                            break;
                                                        }
                                                        zzc(Integer.valueOf(iIntValue2)).zza(zzaaVar);
                                                        j = j2;
                                                        mapEmptyMap = map5;
                                                        r19 = l3;
                                                    }
                                                    if (!zZzd) {
                                                        this.zzb.add(Integer.valueOf(iIntValue2));
                                                    }
                                                    j = j2;
                                                    mapEmptyMap = map5;
                                                }
                                            }
                                            it4 = it5;
                                            str4 = str6;
                                            zzzVar = zzzVar;
                                        } else {
                                            continue;
                                        }
                                    }
                                }
                            }
                            str8 = str4;
                            if (!z) {
                                return new ArrayList();
                            }
                            if (!list2.isEmpty()) {
                                arrayMap6 = new ArrayMap();
                                it9 = list2.iterator();
                                while (it9.hasNext()) {
                                    com.google.android.gms.internal.measurement.zziu zziuVar3 = (com.google.android.gms.internal.measurement.zziu) it9.next();
                                    strZzc = zziuVar3.zzc();
                                    mapEmptyMap2 = (Map) arrayMap6.get(strZzc);
                                    if (mapEmptyMap2 == null) {
                                        zzavVarZzj3 = this.zzg.zzj();
                                        str10 = this.zza;
                                        zzavVarZzj3.zzaw();
                                        zzavVarZzj3.zzg();
                                        Preconditions.checkNotEmpty(str10);
                                        Preconditions.checkNotEmpty(strZzc);
                                        arrayMap7 = new ArrayMap();
                                        i4 = 1;
                                        cursorQuery = zzavVarZzj3.zze().query("property_filters", new String[]{str8, "data"}, "app_id=? AND property_name=?", new String[]{str10, strZzc}, null, null, null);
                                        if (cursorQuery.moveToFirst()) {
                                            while (true) {
                                                com.google.android.gms.internal.measurement.zzfn zzfnVar4 = (com.google.android.gms.internal.measurement.zzfn) ((com.google.android.gms.internal.measurement.zzfm) zzpk.zzw(com.google.android.gms.internal.measurement.zzfn.zzi(), cursorQuery.getBlob(i4))).zzbc();
                                                numValueOf7 = Integer.valueOf(cursorQuery.getInt(0));
                                                list6 = (List) arrayMap7.get(numValueOf7);
                                                if (list6 == null) {
                                                    arrayList4 = new ArrayList();
                                                    arrayMap7.put(numValueOf7, arrayList4);
                                                } else {
                                                    arrayList4 = list6;
                                                }
                                                arrayList4.add(zzfnVar4);
                                                if (!cursorQuery.moveToNext()) {
                                                    break;
                                                    break;
                                                }
                                                it9 = it9;
                                                i4 = 1;
                                            }
                                            if (cursorQuery != null) {
                                                cursorQuery.close();
                                            }
                                            mapEmptyMap2 = arrayMap7;
                                        } else {
                                            it9 = it9;
                                            mapEmptyMap2 = Collections.emptyMap();
                                            if (cursorQuery != null) {
                                                cursorQuery.close();
                                            }
                                        }
                                        arrayMap6.put(strZzc, mapEmptyMap2);
                                    } else {
                                        it9 = it9;
                                    }
                                    it10 = mapEmptyMap2.keySet().iterator();
                                    while (it10.hasNext()) {
                                        iIntValue3 = ((Integer) it10.next()).intValue();
                                        set2 = this.zzb;
                                        numValueOf4 = Integer.valueOf(iIntValue3);
                                        if (set2.contains(numValueOf4)) {
                                            this.zzu.zzaV().zzk().zzb(str5, numValueOf4);
                                            break;
                                            break;
                                        }
                                        it11 = ((List) mapEmptyMap2.get(numValueOf4)).iterator();
                                        zZzd2 = true;
                                        while (true) {
                                            if (it11.hasNext()) {
                                                zzfnVar = (com.google.android.gms.internal.measurement.zzfn) it11.next();
                                                zzicVar = this.zzu;
                                                if (Log.isLoggable(zzicVar.zzaV().zzn(), 2)) {
                                                    zzgs zzgsVarZzk3 = zzicVar.zzaV().zzk();
                                                    Integer numValueOf112 = Integer.valueOf(iIntValue3);
                                                    if (zzfnVar.zza()) {
                                                        numValueOf6 = Integer.valueOf(zzfnVar.zzb());
                                                    } else {
                                                        numValueOf6 = null;
                                                    }
                                                    zzgsVarZzk3.zzd("Evaluating filter. audience, filter, property", numValueOf112, numValueOf6, zzicVar.zzl().zzc(zzfnVar.zzc()));
                                                    zzicVar.zzaV().zzk().zzb("Filter definition", this.zzg.zzp().zzk(zzfnVar));
                                                }
                                                if (zzfnVar.zza() || zzfnVar.zzb() > 256) {
                                                    zzgs zzgsVarZze3 = zzicVar.zzaV().zze();
                                                    Object objZzl4 = zzgu.zzl(this.zza);
                                                    if (zzfnVar.zza()) {
                                                        numValueOf5 = Integer.valueOf(zzfnVar.zzb());
                                                    } else {
                                                        numValueOf5 = null;
                                                    }
                                                    zzgsVarZze3.zzc("Invalid property filter ID. appId, id", objZzl4, String.valueOf(numValueOf5));
                                                    this.zzb.add(Integer.valueOf(iIntValue3));
                                                    mapEmptyMap2 = mapEmptyMap2;
                                                    str5 = str5;
                                                } else {
                                                    zzacVar = new zzac(this, this.zza, iIntValue3, zzfnVar);
                                                    zZzd2 = zzacVar.zzd(this.zzd, this.zze, zziuVar3, zzd(iIntValue3, zzfnVar.zzb()));
                                                    if (zZzd2) {
                                                        zzc(Integer.valueOf(iIntValue3)).zza(zzacVar);
                                                        mapEmptyMap2 = mapEmptyMap2;
                                                        str5 = str5;
                                                    } else {
                                                        this.zzb.add(Integer.valueOf(iIntValue3));
                                                    }
                                                }
                                            } else {
                                                mapEmptyMap2 = mapEmptyMap2;
                                                str5 = str5;
                                            }
                                            if (!zZzd2) {
                                                this.zzb.add(Integer.valueOf(iIntValue3));
                                            }
                                            mapEmptyMap2 = mapEmptyMap2;
                                            str5 = str5;
                                        }
                                    }
                                    it9 = it9;
                                }
                            }
                            arrayList3 = new ArrayList();
                            Set setKeySet3 = this.zzc.keySet();
                            setKeySet3.removeAll(this.zzb);
                            it8 = setKeySet3.iterator();
                            while (it8.hasNext()) {
                                int iIntValue9 = ((Integer) it8.next()).intValue();
                                Map map11 = this.zzc;
                                Integer numValueOf113 = Integer.valueOf(iIntValue9);
                                zzy zzyVar3 = (zzy) map11.get(numValueOf113);
                                Preconditions.checkNotNull(zzyVar3);
                                com.google.android.gms.internal.measurement.zzhg zzhgVarZzb3 = zzyVar3.zzb(iIntValue9);
                                arrayList3.add(zzhgVarZzb3);
                                zzavVarZzj2 = this.zzg.zzj();
                                str9 = this.zza;
                                com.google.android.gms.internal.measurement.zzii zziiVarZzc3 = zzhgVarZzb3.zzc();
                                zzavVarZzj2.zzaw();
                                zzavVarZzj2.zzg();
                                Preconditions.checkNotEmpty(str9);
                                Preconditions.checkNotNull(zziiVarZzc3);
                                byte[] bArrZzcc3 = zziiVarZzc3.zzcc();
                                contentValues = new ContentValues();
                                contentValues.put("app_id", str9);
                                contentValues.put(str8, numValueOf113);
                                contentValues.put("current_results", bArrZzcc3);
                                if (zzavVarZzj2.zze().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                                    zzavVarZzj2.zzu.zzaV().zzb().zzb("Failed to insert filter results (got -1). appId", zzgu.zzl(str9));
                                }
                            }
                            return arrayList3;
                        } catch (Throwable th11) {
                            th = th11;
                            if (r8 != 0) {
                                r8.close();
                            }
                            throw th;
                        }
                    }
                    r41 = 0;
                    r40 = 1;
                    obj = "app_id = ?";
                    if (Query.moveToFirst()) {
                        Map mapEmptyMap7 = Collections.emptyMap();
                        if (Query != 0) {
                            Query.close();
                        }
                        map2 = mapEmptyMap7;
                        z5 = z3 ? 1 : 0;
                        str13 = "audience_id";
                        r18 = "audience_filter_values";
                    } else {
                        arrayMap8 = new ArrayMap();
                        r12 = r42;
                        z7 = z3;
                        while (true) {
                            i5 = Query.getInt(r12);
                            arrayMap8.put(Integer.valueOf(i5), (com.google.android.gms.internal.measurement.zzii) ((com.google.android.gms.internal.measurement.zzih) zzpk.zzw(com.google.android.gms.internal.measurement.zzii.zzi(), Query.getBlob(1))).zzbc());
                            z4 = z7;
                            if (!Query.moveToNext()) {
                                break;
                                break;
                            }
                            z7 = z4 ? 1 : 0;
                            str13 = str13;
                            r12 = 0;
                        }
                        if (Query != 0) {
                            Query.close();
                        }
                        map2 = arrayMap8;
                        r18 = "audience_filter_values";
                        z5 = z4;
                    }
                } catch (SQLiteException e25) {
                    e = e25;
                    z4 = z3 ? 1 : 0;
                }
                str2 = "audience_filter_values";
                String[] strArr6 = new String[2];
                strArr6[r42] = "audience_id";
                strArr6[r43] = "current_results";
                String[] strArr7 = new String[r43];
                strArr7[r42] = str15;
                Query = sQLiteDatabaseZze2.query("audience_filter_values", strArr6, "app_id=?", strArr7, null, null, null);
            } catch (SQLiteException e26) {
                e = e26;
                z4 = z3 ? 1 : 0;
                str13 = "audience_id";
                Query = 0;
            } catch (Throwable th12) {
                th = th12;
                r5 = 0;
                if (r5 != 0) {
                    r5.close();
                }
                throw th;
            }
            if (!map2.isEmpty()) {
                HashSet hashSet3 = new HashSet(map2.keySet());
                if (z5) {
                    String str18 = this.zza;
                    zzavVarZzj = this.zzg.zzj();
                    str3 = this.zza;
                    zzavVarZzj.zzaw();
                    zzavVarZzj.zzg();
                    Preconditions.checkNotEmpty(str3);
                    arrayMap2 = new ArrayMap();
                    i2 = 0;
                    cursorRawQuery = zzavVarZzj.zze().rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str3, str3});
                    if (cursorRawQuery.moveToFirst()) {
                        while (true) {
                            numValueOf = Integer.valueOf(cursorRawQuery.getInt(i2));
                            arrayList = (List) arrayMap2.get(numValueOf);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                arrayMap2.put(numValueOf, arrayList);
                            }
                            arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                            if (!cursorRawQuery.moveToNext()) {
                                break;
                                break;
                            }
                            i2 = 0;
                        }
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                    } else {
                        arrayMap2 = Collections.emptyMap();
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                    }
                    Preconditions.checkNotEmpty(str18);
                    Preconditions.checkNotNull(map2);
                    arrayMap3 = new ArrayMap();
                    if (!map2.isEmpty()) {
                        it2 = map2.keySet().iterator();
                        while (it2.hasNext()) {
                            int iIntValue10 = ((Integer) it2.next()).intValue();
                            Integer numValueOf114 = Integer.valueOf(iIntValue10);
                            zziiVar3 = (com.google.android.gms.internal.measurement.zzii) map2.get(numValueOf114);
                            list4 = (List) arrayMap2.get(numValueOf114);
                            if (list4 != null) {
                            }
                            map4 = arrayMap2;
                            it3 = it2;
                            arrayMap3.put(numValueOf114, zziiVar3);
                            arrayMap2 = map4;
                            it2 = it3;
                        }
                    }
                    map3 = arrayMap3;
                } else {
                    map3 = map2;
                }
                it = hashSet3.iterator();
                while (it.hasNext()) {
                    iIntValue = ((Integer) it.next()).intValue();
                    zziiVar = (com.google.android.gms.internal.measurement.zzii) map3.get(Integer.valueOf(iIntValue));
                    bitSet = new BitSet();
                    bitSet2 = new BitSet();
                    arrayMap = new ArrayMap();
                    if (zziiVar != null) {
                        while (r3.hasNext()) {
                            if (zzhqVar.zza()) {
                                Integer numValueOf115 = Integer.valueOf(zzhqVar.zzb());
                                if (zzhqVar.zzc()) {
                                    lValueOf = Long.valueOf(zzhqVar.zzd());
                                } else {
                                    lValueOf = null;
                                }
                                arrayMap.put(numValueOf115, lValueOf);
                            }
                        }
                    }
                    ArrayMap arrayMap13 = new ArrayMap();
                    if (zziiVar != null) {
                        while (r3.hasNext()) {
                            if (!zzikVar.zza()) {
                            }
                        }
                    }
                    Map map12 = map3;
                    zziiVar2 = zziiVar;
                    if (zziiVar2 != null) {
                        i = 0;
                        while (i < zziiVar2.zzb() * 64) {
                            if (zzpk.zzn(zziiVar2.zza(), i)) {
                                z6 = zZzp;
                                this.zzu.zzaV().zzk().zzc("Filter already evaluated. audience ID, filter ID", Integer.valueOf(iIntValue), Integer.valueOf(i));
                                bitSet2.set(i);
                                if (zzpk.zzn(zziiVar2.zzc(), i)) {
                                    bitSet.set(i);
                                }
                                i++;
                                zZzp = z6;
                            } else {
                                z6 = zZzp;
                            }
                            arrayMap.remove(Integer.valueOf(i));
                            i++;
                            zZzp = z6;
                        }
                    }
                    boolean z12 = zZzp;
                    Integer numValueOf116 = Integer.valueOf(iIntValue);
                    com.google.android.gms.internal.measurement.zzii zziiVar7 = (com.google.android.gms.internal.measurement.zzii) map2.get(numValueOf116);
                    if (!zZzp2) {
                    }
                    this.zzc.put(Integer.valueOf(iIntValue), new zzy(this, this.zza, zziiVar7, bitSet, bitSet2, arrayMap, arrayMap13, null));
                    zZzp = z12;
                    map3 = map12;
                }
            }
            str4 = str13;
            bArr = null;
            str5 = "Skipping failed audience ID";
            if (!list.isEmpty()) {
                zzzVar = new zzz(this, bArr);
                arrayMap4 = new ArrayMap();
                it4 = list.iterator();
                while (it4.hasNext()) {
                    zzhsVar = (com.google.android.gms.internal.measurement.zzhs) it4.next();
                    zzhsVarZza = zzzVar.zza(this.zza, zzhsVar);
                    if (zzhsVarZza != null) {
                        zzpgVar = this.zzg;
                        zzbcVarZzaf = zzpgVar.zzj().zzaf(this.zza, zzhsVar, zzhsVarZza.zzd());
                        zzpgVar.zzj().zzh(zzbcVarZzaf);
                        if (z) {
                            j = zzbcVarZzaf.zzc;
                            strZzd = zzhsVarZza.zzd();
                            mapEmptyMap = (Map) arrayMap4.get(strZzd);
                            if (mapEmptyMap == null) {
                                zzav zzavVarZzj10 = zzpgVar.zzj();
                                str7 = this.zza;
                                zzavVarZzj10.zzaw();
                                zzavVarZzj10.zzg();
                                Preconditions.checkNotEmpty(str7);
                                Preconditions.checkNotEmpty(strZzd);
                                arrayMap5 = new ArrayMap();
                                SQLiteDatabase sQLiteDatabaseZze6 = zzavVarZzj10.zze();
                                String[] strArr8 = new String[2];
                                str6 = str4;
                                strArr8[0] = str6;
                                it5 = it4;
                                strArr8[1] = "data";
                                Query2 = sQLiteDatabaseZze6.query("event_filters", strArr8, "app_id=? AND event_name=?", new String[]{str7, strZzd}, null, null, null);
                                if (Query2.moveToFirst()) {
                                    zzbcVarZzaf = zzbcVarZzaf;
                                    i3 = 1;
                                    Query2 = Query2;
                                    r112 = r18;
                                    while (true) {
                                        com.google.android.gms.internal.measurement.zzff zzffVar10 = (com.google.android.gms.internal.measurement.zzff) ((com.google.android.gms.internal.measurement.zzfe) zzpk.zzw(com.google.android.gms.internal.measurement.zzff.zzn(), Query2.getBlob(i3))).zzbc();
                                        numValueOf3 = Integer.valueOf(Query2.getInt(0));
                                        list5 = (List) arrayMap5.get(numValueOf3);
                                        if (list5 == null) {
                                            r112 = Query2;
                                            arrayList2 = new ArrayList();
                                            arrayMap5.put(numValueOf3, arrayList2);
                                            r115 = r112;
                                        } else {
                                            r115 = Query2;
                                            arrayList2 = list5;
                                        }
                                        arrayList2.add(zzffVar10);
                                        r114 = r115;
                                        if (!r114.moveToNext()) {
                                            break;
                                            break;
                                        }
                                        Query2 = r114;
                                        i3 = 1;
                                        r112 = r114;
                                    }
                                    if (r114 != 0) {
                                        r114.close();
                                    }
                                    mapEmptyMap = arrayMap5;
                                    r111 = r114;
                                } else {
                                    r113 = Query2;
                                    zzbcVarZzaf = zzbcVarZzaf;
                                    mapEmptyMap = Collections.emptyMap();
                                    r111 = r113;
                                    if (r113 != 0) {
                                        r113.close();
                                        r111 = r113;
                                    }
                                }
                                arrayMap4.put(strZzd, mapEmptyMap);
                                r18 = r111;
                            } else {
                                it5 = it4;
                                zzbcVarZzaf = zzbcVarZzaf;
                                str6 = str4;
                                r18 = r18;
                            }
                            it6 = mapEmptyMap.keySet().iterator();
                            while (it6.hasNext()) {
                                iIntValue2 = ((Integer) it6.next()).intValue();
                                set = this.zzb;
                                numValueOf2 = Integer.valueOf(iIntValue2);
                                if (set.contains(numValueOf2)) {
                                    this.zzu.zzaV().zzk().zzb("Skipping failed audience ID", numValueOf2);
                                } else {
                                    it7 = ((List) mapEmptyMap.get(numValueOf2)).iterator();
                                    zZzd = true;
                                    r19 = r18;
                                    while (true) {
                                        if (!it7.hasNext()) {
                                            map5 = mapEmptyMap;
                                            j2 = j;
                                            r18 = r19;
                                            break;
                                        }
                                        com.google.android.gms.internal.measurement.zzff zzffVar11 = (com.google.android.gms.internal.measurement.zzff) it7.next();
                                        zzaaVar = new zzaa(this, this.zza, iIntValue2, zzffVar11);
                                        map5 = mapEmptyMap;
                                        j2 = j;
                                        l3 = this.zzd;
                                        zZzd = zzaaVar.zzd(l3, this.zze, zzhsVarZza, j2, zzbcVarZzaf, zzd(iIntValue2, zzffVar11.zzb()));
                                        if (!zZzd) {
                                            this.zzb.add(Integer.valueOf(iIntValue2));
                                            r18 = l3;
                                            break;
                                        }
                                        zzc(Integer.valueOf(iIntValue2)).zza(zzaaVar);
                                        j = j2;
                                        mapEmptyMap = map5;
                                        r19 = l3;
                                    }
                                    if (!zZzd) {
                                        this.zzb.add(Integer.valueOf(iIntValue2));
                                    }
                                    j = j2;
                                    mapEmptyMap = map5;
                                }
                            }
                            it4 = it5;
                            str4 = str6;
                            zzzVar = zzzVar;
                        } else {
                            continue;
                        }
                    }
                }
            }
            str8 = str4;
            if (!z) {
                return new ArrayList();
            }
            if (!list2.isEmpty()) {
                arrayMap6 = new ArrayMap();
                it9 = list2.iterator();
                while (it9.hasNext()) {
                    com.google.android.gms.internal.measurement.zziu zziuVar4 = (com.google.android.gms.internal.measurement.zziu) it9.next();
                    strZzc = zziuVar4.zzc();
                    mapEmptyMap2 = (Map) arrayMap6.get(strZzc);
                    if (mapEmptyMap2 == null) {
                        zzavVarZzj3 = this.zzg.zzj();
                        str10 = this.zza;
                        zzavVarZzj3.zzaw();
                        zzavVarZzj3.zzg();
                        Preconditions.checkNotEmpty(str10);
                        Preconditions.checkNotEmpty(strZzc);
                        arrayMap7 = new ArrayMap();
                        i4 = 1;
                        cursorQuery = zzavVarZzj3.zze().query("property_filters", new String[]{str8, "data"}, "app_id=? AND property_name=?", new String[]{str10, strZzc}, null, null, null);
                        if (cursorQuery.moveToFirst()) {
                            while (true) {
                                com.google.android.gms.internal.measurement.zzfn zzfnVar5 = (com.google.android.gms.internal.measurement.zzfn) ((com.google.android.gms.internal.measurement.zzfm) zzpk.zzw(com.google.android.gms.internal.measurement.zzfn.zzi(), cursorQuery.getBlob(i4))).zzbc();
                                numValueOf7 = Integer.valueOf(cursorQuery.getInt(0));
                                list6 = (List) arrayMap7.get(numValueOf7);
                                if (list6 == null) {
                                    arrayList4 = new ArrayList();
                                    arrayMap7.put(numValueOf7, arrayList4);
                                } else {
                                    arrayList4 = list6;
                                }
                                arrayList4.add(zzfnVar5);
                                if (!cursorQuery.moveToNext()) {
                                    break;
                                    break;
                                }
                                it9 = it9;
                                i4 = 1;
                            }
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            mapEmptyMap2 = arrayMap7;
                        } else {
                            it9 = it9;
                            mapEmptyMap2 = Collections.emptyMap();
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                        }
                        arrayMap6.put(strZzc, mapEmptyMap2);
                    } else {
                        it9 = it9;
                    }
                    it10 = mapEmptyMap2.keySet().iterator();
                    while (it10.hasNext()) {
                        iIntValue3 = ((Integer) it10.next()).intValue();
                        set2 = this.zzb;
                        numValueOf4 = Integer.valueOf(iIntValue3);
                        if (set2.contains(numValueOf4)) {
                            this.zzu.zzaV().zzk().zzb(str5, numValueOf4);
                            break;
                            break;
                        }
                        it11 = ((List) mapEmptyMap2.get(numValueOf4)).iterator();
                        zZzd2 = true;
                        while (true) {
                            if (it11.hasNext()) {
                                zzfnVar = (com.google.android.gms.internal.measurement.zzfn) it11.next();
                                zzicVar = this.zzu;
                                if (Log.isLoggable(zzicVar.zzaV().zzn(), 2)) {
                                    zzgs zzgsVarZzk4 = zzicVar.zzaV().zzk();
                                    Integer numValueOf117 = Integer.valueOf(iIntValue3);
                                    if (zzfnVar.zza()) {
                                        numValueOf6 = Integer.valueOf(zzfnVar.zzb());
                                    } else {
                                        numValueOf6 = null;
                                    }
                                    zzgsVarZzk4.zzd("Evaluating filter. audience, filter, property", numValueOf117, numValueOf6, zzicVar.zzl().zzc(zzfnVar.zzc()));
                                    zzicVar.zzaV().zzk().zzb("Filter definition", this.zzg.zzp().zzk(zzfnVar));
                                }
                                if (zzfnVar.zza()) {
                                }
                                zzgs zzgsVarZze4 = zzicVar.zzaV().zze();
                                Object objZzl5 = zzgu.zzl(this.zza);
                                if (zzfnVar.zza()) {
                                    numValueOf5 = Integer.valueOf(zzfnVar.zzb());
                                } else {
                                    numValueOf5 = null;
                                }
                                zzgsVarZze4.zzc("Invalid property filter ID. appId, id", objZzl5, String.valueOf(numValueOf5));
                                this.zzb.add(Integer.valueOf(iIntValue3));
                                mapEmptyMap2 = mapEmptyMap2;
                                str5 = str5;
                            } else {
                                mapEmptyMap2 = mapEmptyMap2;
                                str5 = str5;
                            }
                            if (!zZzd2) {
                                this.zzb.add(Integer.valueOf(iIntValue3));
                            }
                            mapEmptyMap2 = mapEmptyMap2;
                            str5 = str5;
                            zzc(Integer.valueOf(iIntValue3)).zza(zzacVar);
                            mapEmptyMap2 = mapEmptyMap2;
                            str5 = str5;
                        }
                    }
                    it9 = it9;
                }
            }
            arrayList3 = new ArrayList();
            Set setKeySet4 = this.zzc.keySet();
            setKeySet4.removeAll(this.zzb);
            it8 = setKeySet4.iterator();
            while (it8.hasNext()) {
                int iIntValue11 = ((Integer) it8.next()).intValue();
                Map map13 = this.zzc;
                Integer numValueOf118 = Integer.valueOf(iIntValue11);
                zzy zzyVar4 = (zzy) map13.get(numValueOf118);
                Preconditions.checkNotNull(zzyVar4);
                com.google.android.gms.internal.measurement.zzhg zzhgVarZzb4 = zzyVar4.zzb(iIntValue11);
                arrayList3.add(zzhgVarZzb4);
                zzavVarZzj2 = this.zzg.zzj();
                str9 = this.zza;
                com.google.android.gms.internal.measurement.zzii zziiVarZzc4 = zzhgVarZzb4.zzc();
                zzavVarZzj2.zzaw();
                zzavVarZzj2.zzg();
                Preconditions.checkNotEmpty(str9);
                Preconditions.checkNotNull(zziiVarZzc4);
                byte[] bArrZzcc4 = zziiVarZzc4.zzcc();
                contentValues = new ContentValues();
                contentValues.put("app_id", str9);
                contentValues.put(str8, numValueOf118);
                contentValues.put("current_results", bArrZzcc4);
                if (zzavVarZzj2.zze().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                    zzavVarZzj2.zzu.zzaV().zzb().zzb("Failed to insert filter results (got -1). appId", zzgu.zzl(str9));
                }
            }
            return arrayList3;
        } catch (Throwable th13) {
            th = th13;
            r5 = obj2;
            if (r5 != 0) {
                r5.close();
            }
            throw th;
        }
        map = mapEmptyMap3;
        obj2 = obj;
        r43 = r40;
        r42 = r41;
        zzav zzavVarZzj11 = this.zzg.zzj();
        String str19 = this.zza;
        zzavVarZzj11.zzaw();
        zzavVarZzj11.zzg();
        Preconditions.checkNotEmpty(str19);
        SQLiteDatabase sQLiteDatabaseZze7 = zzavVarZzj11.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzos
    protected final boolean zzbb() {
        return false;
    }
}
