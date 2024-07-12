package com.yanyu.javalibs.storageunit;


import java.io.File;
import java.util.Locale;

public enum StorageUnit {

    B("B", Constant.UNIT_B_1024, Constant.UNIT_B_1000),  // KB

    KB("KB", B.size1024 * Constant.UNIT_B_1024, B.size1000 * Constant.UNIT_B_1000),  // MB

    MB("MB", KB.size1024 * Constant.UNIT_B_1024, KB.size1000 * Constant.UNIT_B_1000),  // GB

    GB("GB", MB.size1024 * Constant.UNIT_B_1024, MB.size1000 * Constant.UNIT_B_1000),  // TB

    TB("TB", GB.size1024 * Constant.UNIT_B_1024, GB.size1000 * Constant.UNIT_B_1000); // PB

    private final String unit;
    private final long size1024;
    private final long size1000;

    StorageUnit(String unit, long size1024, long size1000) {
        this.unit = unit;
        this.size1024 = size1024;
        this.size1000 = size1000;
    }

    private long iGetSize(boolean size1024) {
        if (size1024) {
            return this.size1024;
        }
        else {
            return this.size1000;
        }
    }

    public String wrap(File file) {
        return wrap(file.length(), true);
    }

    public String wrap(File file, boolean size1024) {
        return wrap(file.length(), size1024);
    }

    public String wrap(long length) {
        return wrap(length, true);
    }

    public String wrap(long length, boolean size1024) {
        long size = iGetSize(size1024);
        float data = length * Constant.iGetUnitByte(size1024) * 1F / size;
        String format = String.format(Locale.getDefault(), "%.2f", data);
        if (format.endsWith(".00")) {
            return format.substring(0, format.length() - 3) + unit;
        }
        else {
            return format + unit;
        }
    }

    public static String wrapSize(File file) {
        return wrapSize(file.length(), true);
    }

    public static String wrapSize(File file, boolean size1024) {
        return wrapSize(file.length(), size1024);
    }

    public static String wrapSize(long length) {
        return wrapSize(length, true);
    }

    public static String wrapSize(long length, boolean size1024) {
        StorageUnit[] values = StorageUnit.values();
        for (StorageUnit value : values) {
            long size = value.iGetSize(size1024);
            if (length < size) {
                float data = length * Constant.iGetUnitByte(size1024) * 1F / size;
                String format = String.format(Locale.getDefault(), "%.2f", data);
                if (format.endsWith(".00")) {
                    return format.substring(0, format.length() - 3) + value.unit;
                }
                else {
                    return format + value.unit;
                }
            }
        }
        return length + "B";
    }
}