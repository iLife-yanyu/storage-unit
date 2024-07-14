package com.yanyu.javalibs.storageunit;

import java.io.File;

public class Storage1000Impl extends AbstractStorage {

    public static Storage1000Impl B = new Storage1000Impl(StorageName.B, Constant.UNIT_BYTE);  // KB
    public static Storage1000Impl KB = new Storage1000Impl(StorageName.KB, B.lUnit * Constant.UNIT_BYTE);  // MB
    public static Storage1000Impl MB = new Storage1000Impl(StorageName.MB, KB.lUnit * Constant.UNIT_BYTE);  // GB
    public static Storage1000Impl GB = new Storage1000Impl(StorageName.GB, MB.lUnit * Constant.UNIT_BYTE);  // TB
    public static Storage1000Impl TB = new Storage1000Impl(StorageName.TB, GB.lUnit * Constant.UNIT_BYTE); // PB

    Storage1000Impl(StorageName storageName, long lUnit) {
        super(storageName, lUnit);
    }

    private static Storage1000Impl[] values() {
        return new Storage1000Impl[]{B, KB, MB, GB, TB};
    }

    public static String sWrapSize(File file) {
        return sWrapSize(file.length());
    }

    public static String sWrapSize(long length) {
        return Util.wrapSize(values(), length);
    }

    @Override
    public long iGetUnitByte() {
        return Constant.UNIT_BYTE;
    }

    private static class Constant {
        public static final int UNIT_BYTE = 1000;
    }
}