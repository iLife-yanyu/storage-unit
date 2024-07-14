package com.yanyu.javalibs.storageunit;

import java.util.Locale;

class Util {

    static <T extends IStorageParamsGetter> String wrapSize(T[] storages, long length) {
        for (T value : storages) {
            if (length < value.iGetLongUnit()) {
                return wrapSize(value, length);
            }
        }
        return length + "B";
    }

    static <T extends IStorageParamsGetter> String wrapSize(T storage, long length) {
        float data = length * storage.iGetUnitByte() * 1F / storage.iGetLongUnit();
        return wrapSize(data, storage.iGetStringUnit());
    }

    static String wrapSize(float length, String sUnit) {
        String format = String.format(Locale.getDefault(), "%.2f", length);
        if (format.endsWith(".00")) {
            return format.substring(0, format.length() - 3) + sUnit;
        }
        else {
            return format + sUnit;
        }
    }
}
