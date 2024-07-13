package com.yanyu.javalibs.storageunit;

import java.util.Locale;

class Util {

    static <T extends IStorageParamsGetter> String interfaceStaticWrapSize(T[] storages, long length, long unitByte) {
        for (T value : storages) {
            if (length < value.iGetLongUnit()) {
                return interfaceStaticWrapSize(value, length, unitByte);
            }
        }
        return length + "B";
    }

    static <T extends IStorageParamsGetter> String interfaceStaticWrapSize(T storage, long length, long unitByte) {
        float data = length * unitByte * 1F / storage.iGetLongUnit();
        return interfaceStaticWrapSize(data, storage.iGetStringUnit());
    }

    static String interfaceStaticWrapSize(float length, String sUnit) {
        String format = String.format(Locale.getDefault(), "%.2f", length);
        if (format.endsWith(".00")) {
            return format.substring(0, format.length() - 3) + sUnit;
        }
        else {
            return format + sUnit;
        }
    }
}
