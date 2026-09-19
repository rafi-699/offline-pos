package com.google.android.gms.internal.ads;

import android.media.AudioDescriptor;
import android.media.AudioDeviceInfo;
import android.media.AudioProfile;
import android.os.Build;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzub {
    private static final zzgwm zza = zzgwm.zzj(12);

    /* JADX WARN: Code duplicated, block: B:118:0x0183  */
    /* JADX WARN: Code duplicated, block: B:130:0x01a4 A[RETURN] */
    public static zzgwm zza(AudioDeviceInfo audioDeviceInfo) {
        int type;
        zzgwm zzgwmVarZzb;
        zzgwm zzgwmVarZzi;
        int speakerLayoutChannelMask;
        if (!zztu.zza(audioDeviceInfo.getType())) {
            if (audioDeviceInfo.getType() == 1) {
                return zzgwm.zzj(4);
            }
            if (audioDeviceInfo.getType() == 2) {
                if (Build.VERSION.SDK_INT >= 36 && (speakerLayoutChannelMask = audioDeviceInfo.getSpeakerLayoutChannelMask()) != 0 && speakerLayoutChannelMask != 1) {
                    return zzgwm.zzj(Integer.valueOf(speakerLayoutChannelMask));
                }
                zzeg.zzc("SpeakerLayoutUtil", "Built-in speaker's getSpeakerLayoutChannelMask not usable, defaulting to stereo.");
                return zza;
            }
            if (Build.VERSION.SDK_INT >= 31 && audioDeviceInfo.getType() == 10) {
                zzgwm zzgwmVarZzb2 = zzb(audioDeviceInfo);
                if (!zzgwmVarZzb2.isEmpty()) {
                    return zzgwmVarZzb2;
                }
                zzgwm zzgwmVarZza = zzqq.zza(audioDeviceInfo.getAudioDescriptors());
                if (!zzgwmVarZza.isEmpty()) {
                    return zzgwmVarZza;
                }
            } else if (Build.VERSION.SDK_INT >= 31) {
                int type2 = audioDeviceInfo.getType();
                if (Build.VERSION.SDK_INT >= 31 && type2 == 29) {
                    zzgwm zzgwmVarZzb3 = zzb(audioDeviceInfo);
                    if (!zzgwmVarZzb3.isEmpty()) {
                        return zzgwmVarZzb3;
                    }
                    List<AudioDescriptor> audioDescriptors = audioDeviceInfo.getAudioDescriptors();
                    if (Build.VERSION.SDK_INT >= 34) {
                        if (Build.VERSION.SDK_INT < 34 || audioDescriptors == null) {
                            zzgwmVarZzi = zzgwm.zzi();
                        } else {
                            ArrayList arrayList = new ArrayList();
                            for (AudioDescriptor audioDescriptor : audioDescriptors) {
                                if (audioDescriptor.getStandard() == 2) {
                                    byte[] descriptor = audioDescriptor.getDescriptor();
                                    int length = descriptor.length;
                                    if (length != 3) {
                                        StringBuilder sb = new StringBuilder(String.valueOf(length).length() + 21);
                                        sb.append("Invalid SADB length: ");
                                        sb.append(length);
                                        zzeg.zzc("AudioDescriptorUtil", sb.toString());
                                    } else {
                                        int i = 0;
                                        if (Build.VERSION.SDK_INT >= 34) {
                                            byte b = descriptor[0];
                                            i = 1 == (b & 1) ? 12 : 0;
                                            if ((b & 2) != 0) {
                                                i |= 32;
                                            }
                                            if ((b & 4) != 0) {
                                                i |= 16;
                                            }
                                            if ((b & 8) != 0) {
                                                i |= 192;
                                            }
                                            if ((b & Ascii.DLE) != 0) {
                                                i |= 1024;
                                            }
                                            if ((b & 32) != 0) {
                                                i |= 768;
                                            }
                                            if ((b & 128) != 0) {
                                                i |= 201326592;
                                            }
                                            byte b2 = descriptor[1];
                                            if ((b2 & 1) != 0) {
                                                i |= 81920;
                                            }
                                            if ((b2 & 2) != 0) {
                                                i |= 8192;
                                            }
                                            if ((b2 & 4) != 0) {
                                                i |= 32768;
                                            }
                                            if ((b2 & 8) != 0) {
                                                i |= 6144;
                                            }
                                            if ((b2 & Ascii.DLE) != 0) {
                                                i |= 33554432;
                                            }
                                            if ((b2 & 32) != 0) {
                                                i |= 262144;
                                            }
                                            if ((b2 & SignedBytes.MAX_POWER_OF_TWO) != 0) {
                                                i |= 6144;
                                            }
                                            if ((b2 & 128) != 0) {
                                                i |= 3145728;
                                            }
                                            byte b3 = descriptor[2];
                                            if ((b3 & 1) != 0) {
                                                i |= 655360;
                                            }
                                            if ((b3 & 2) != 0) {
                                                i = 8388608 | i;
                                            }
                                            if ((b3 & 4) != 0) {
                                                i |= 20971520;
                                            }
                                        }
                                        arrayList.add(Integer.valueOf(i));
                                    }
                                }
                            }
                            arrayList.sort(zzqo.zza);
                            zzgwmVarZzi = zzgwm.zzq(arrayList);
                        }
                        if (!zzgwmVarZzi.isEmpty()) {
                            return zzgwmVarZzi;
                        }
                    }
                    zzgwm zzgwmVarZza2 = zzqq.zza(audioDescriptors);
                    if (!zzgwmVarZza2.isEmpty()) {
                        return zzgwmVarZza2;
                    }
                } else if (Build.VERSION.SDK_INT >= 31 && ((type = audioDeviceInfo.getType()) == 11 || type == 12 || (Build.VERSION.SDK_INT >= 31 && type == 22))) {
                    zzgwmVarZzb = zzb(audioDeviceInfo);
                    if (!zzgwmVarZzb.isEmpty()) {
                        return zzgwmVarZzb;
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 31) {
                zzgwmVarZzb = zzb(audioDeviceInfo);
                if (!zzgwmVarZzb.isEmpty()) {
                    return zzgwmVarZzb;
                }
            }
        }
        return zza;
    }

    private static zzgwm zzb(AudioDeviceInfo audioDeviceInfo) {
        List<AudioProfile> audioProfiles = audioDeviceInfo.getAudioProfiles();
        TreeSet treeSet = new TreeSet(Comparator.comparing(zzua.zza).reversed());
        for (AudioProfile audioProfile : audioProfiles) {
            if (audioProfile.getEncapsulationType() != 1 && zzfl.zzD(audioProfile.getFormat())) {
                for (int i : audioProfile.getChannelMasks()) {
                    treeSet.add(Integer.valueOf(i));
                }
            }
        }
        return zzgwm.zzq(treeSet);
    }
}
