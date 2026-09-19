package com.github.gzuliyujiang.wheelpicker.impl;

import androidx.exifinterface.media.ExifInterface;
import com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class CarPlateProvider implements LinkageProvider {
    private static final String[] ABBREVIATIONS = {"京", "津", "冀", "晋", "蒙", "辽", "吉", "黑", "沪", "苏", "浙", "皖", "闽", "赣", "鲁", "豫", "鄂", "湘", "粤", "桂", "琼", "渝", "川", "贵", "云", "藏", "陕", "甘", "青", "宁", "新"};

    @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
    public int findThirdIndex(int firstIndex, int secondIndex, Object thirdValue) {
        return 0;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
    public boolean firstLevelVisible() {
        return true;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
    public boolean thirdLevelVisible() {
        return false;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
    public List<String> provideFirstData() {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, ABBREVIATIONS);
        return arrayList;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
    public List<String> linkageSecondData(int firstIndex) {
        ArrayList arrayList = new ArrayList();
        byte b = 0;
        int i = firstIndex;
        if (i == -1) {
            i = 0;
        }
        String str = provideFirstData().get(i);
        str.hashCode();
        switch (str.hashCode()) {
            case 20113:
                if (!str.equals("云")) {
                    b = -1;
                }
                break;
            case 20140:
                b = !str.equals("京") ? (byte) -1 : (byte) 1;
                break;
            case 20864:
                b = !str.equals("冀") ? (byte) -1 : (byte) 2;
                break;
            case 21513:
                b = !str.equals("吉") ? (byte) -1 : (byte) 3;
                break;
            case 23425:
                b = !str.equals("宁") ? (byte) -1 : (byte) 4;
                break;
            case 24029:
                b = !str.equals("川") ? (byte) -1 : (byte) 5;
                break;
            case 26032:
                b = !str.equals("新") ? (byte) -1 : (byte) 6;
                break;
            case 26187:
                b = !str.equals("晋") ? (byte) -1 : (byte) 7;
                break;
            case 26690:
                b = !str.equals("桂") ? (byte) -1 : (byte) 8;
                break;
            case 27818:
                b = !str.equals("沪") ? (byte) -1 : (byte) 9;
                break;
            case 27941:
                b = !str.equals("津") ? (byte) -1 : (byte) 10;
                break;
            case 27993:
                b = !str.equals("浙") ? (byte) -1 : Ascii.VT;
                break;
            case 28189:
                b = !str.equals("渝") ? (byte) -1 : Ascii.FF;
                break;
            case 28248:
                b = !str.equals("湘") ? (byte) -1 : Ascii.CR;
                break;
            case 29756:
                b = !str.equals("琼") ? (byte) -1 : Ascii.SO;
                break;
            case 29976:
                b = !str.equals("甘") ? (byte) -1 : Ascii.SI;
                break;
            case 30358:
                b = !str.equals("皖") ? (byte) -1 : Ascii.DLE;
                break;
            case 31908:
                b = !str.equals("粤") ? (byte) -1 : (byte) 17;
                break;
            case 33487:
                b = !str.equals("苏") ? (byte) -1 : Ascii.DC2;
                break;
            case 33945:
                b = !str.equals("蒙") ? (byte) -1 : (byte) 19;
                break;
            case 34255:
                b = !str.equals("藏") ? (byte) -1 : Ascii.DC4;
                break;
            case 35947:
                b = !str.equals("豫") ? (byte) -1 : Ascii.NAK;
                break;
            case 36149:
                b = !str.equals("贵") ? (byte) -1 : Ascii.SYN;
                break;
            case 36195:
                b = !str.equals("赣") ? (byte) -1 : Ascii.ETB;
                break;
            case 36797:
                b = !str.equals("辽") ? (byte) -1 : Ascii.CAN;
                break;
            case 37122:
                b = !str.equals("鄂") ? (byte) -1 : Ascii.EM;
                break;
            case 38397:
                b = !str.equals("闽") ? (byte) -1 : Ascii.SUB;
                break;
            case 38485:
                b = !str.equals("陕") ? (byte) -1 : Ascii.ESC;
                break;
            case 38738:
                b = !str.equals("青") ? (byte) -1 : Ascii.FS;
                break;
            case 40065:
                b = !str.equals("鲁") ? (byte) -1 : Ascii.GS;
                break;
            case 40657:
                b = !str.equals("黑") ? (byte) -1 : Ascii.RS;
                break;
            default:
                b = -1;
                break;
        }
        char c = 'A';
        switch (b) {
            case 0:
                arrayList.add("A-V");
                while (c <= 'S') {
                    arrayList.add(String.valueOf(c));
                    c = (char) (c + 1);
                }
                arrayList.remove("B");
                arrayList.remove("I");
                arrayList.remove("O");
                break;
            case 1:
                while (c <= 'M') {
                    arrayList.add(String.valueOf(c));
                    c = (char) (c + 1);
                }
                arrayList.remove("I");
                arrayList.add("Y");
                break;
            case 2:
                while (c <= 'H') {
                    arrayList.add(String.valueOf(c));
                    c = (char) (c + 1);
                }
                arrayList.add("J");
                arrayList.add("R");
                arrayList.add(ExifInterface.LATITUDE_SOUTH);
                arrayList.add("T");
                break;
            case 3:
            case 26:
                while (c <= 'K') {
                    arrayList.add(String.valueOf(c));
                    c = (char) (c + 1);
                }
                arrayList.remove("I");
                break;
            case 4:
            case 14:
                while (c <= 'E') {
                    arrayList.add(String.valueOf(c));
                    c = (char) (c + 1);
                }
                break;
            case 5:
                while (c <= 'Z') {
                    arrayList.add(String.valueOf(c));
                    c = (char) (c + 1);
                }
                arrayList.remove(RequestConfiguration.MAX_AD_CONTENT_RATING_G);
                arrayList.remove("I");
                arrayList.remove("O");
                break;
            case 6:
            case 30:
                while (c <= 'R') {
                    arrayList.add(String.valueOf(c));
                    c = (char) (c + 1);
                }
                arrayList.remove("I");
                arrayList.remove("O");
                break;
            case 7:
                while (c <= 'M') {
                    arrayList.add(String.valueOf(c));
                    c = (char) (c + 1);
                }
                arrayList.remove(RequestConfiguration.MAX_AD_CONTENT_RATING_G);
                arrayList.remove("I");
                break;
            case 8:
                while (c <= 'P') {
                    arrayList.add(String.valueOf(c));
                    c = (char) (c + 1);
                }
                arrayList.remove("I");
                arrayList.remove("O");
                arrayList.add("R");
                break;
            case 9:
                while (c <= 'D') {
                    arrayList.add(String.valueOf(c));
                    c = (char) (c + 1);
                }
                arrayList.add("R");
                break;
            case 10:
            case 28:
                while (c <= 'H') {
                    arrayList.add(String.valueOf(c));
                    c = (char) (c + 1);
                }
                break;
            case 11:
                while (c <= 'L') {
                    arrayList.add(String.valueOf(c));
                    c = (char) (c + 1);
                }
                arrayList.remove("I");
                break;
            case 12:
                while (c <= 'D') {
                    arrayList.add(String.valueOf(c));
                    c = (char) (c + 1);
                }
                arrayList.remove("D");
                arrayList.remove(ExifInterface.LONGITUDE_EAST);
                break;
            case 13:
                while (c <= 'N') {
                    arrayList.add(String.valueOf(c));
                    c = (char) (c + 1);
                }
                arrayList.remove("I");
                arrayList.remove("O");
                arrayList.add("U");
                break;
            case 15:
            case 24:
                while (c <= 'P') {
                    arrayList.add(String.valueOf(c));
                    c = (char) (c + 1);
                }
                arrayList.remove("I");
                arrayList.remove("O");
                break;
            case 16:
            case 25:
                while (c <= 'S') {
                    arrayList.add(String.valueOf(c));
                    c = (char) (c + 1);
                }
                arrayList.remove("I");
                arrayList.remove("O");
                break;
            case 17:
                while (c <= 'Z') {
                    arrayList.add(String.valueOf(c));
                    c = (char) (c + 1);
                }
                arrayList.remove("I");
                arrayList.remove("O");
                break;
            case 18:
                while (c <= 'N') {
                    arrayList.add(String.valueOf(c));
                    c = (char) (c + 1);
                }
                arrayList.remove("I");
                break;
            case 19:
            case 23:
                while (c <= 'M') {
                    arrayList.add(String.valueOf(c));
                    c = (char) (c + 1);
                }
                arrayList.remove("I");
                break;
            case 20:
            case 22:
                while (c <= 'J') {
                    arrayList.add(String.valueOf(c));
                    c = (char) (c + 1);
                }
                arrayList.remove("I");
                break;
            case 21:
                while (c <= 'U') {
                    arrayList.add(String.valueOf(c));
                    c = (char) (c + 1);
                }
                arrayList.remove("I");
                arrayList.remove("O");
                break;
            case 27:
                while (c <= 'K') {
                    arrayList.add(String.valueOf(c));
                    c = (char) (c + 1);
                }
                arrayList.remove("I");
                arrayList.add(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
                break;
            case 29:
                while (c <= 'V') {
                    arrayList.add(String.valueOf(c));
                    c = (char) (c + 1);
                }
                arrayList.remove("I");
                arrayList.remove("O");
                arrayList.add("Y");
                break;
        }
        return arrayList;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
    public List<?> linkageThirdData(int firstIndex, int secondIndex) {
        return new ArrayList();
    }

    @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
    public int findFirstIndex(Object firstValue) {
        if (firstValue == null) {
            return -1;
        }
        int length = ABBREVIATIONS.length;
        for (int i = 0; i < length; i++) {
            if (ABBREVIATIONS[i].equals(firstValue.toString())) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
    public int findSecondIndex(int firstIndex, Object secondValue) {
        if (secondValue == null) {
            return -1;
        }
        List<String> listLinkageSecondData = linkageSecondData(firstIndex);
        int size = listLinkageSecondData.size();
        for (int i = 0; i < size; i++) {
            if (listLinkageSecondData.get(i).equals(secondValue.toString())) {
                return i;
            }
        }
        return -1;
    }
}
