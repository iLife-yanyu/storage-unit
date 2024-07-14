package com.yanyu.javalibs.storageunit;

import java.io.File;

public class Storage1024Impl extends AbstractStorage {

    public static Storage1024Impl B = new Storage1024Impl(StorageName.B, Constant.UNIT_BYTE);  // KB
    public static Storage1024Impl KB = new Storage1024Impl(StorageName.KB, B.lUnit * Constant.UNIT_BYTE);  // MB
    public static Storage1024Impl MB = new Storage1024Impl(StorageName.MB, KB.lUnit * Constant.UNIT_BYTE);  // GB
    public static Storage1024Impl GB = new Storage1024Impl(StorageName.GB, MB.lUnit * Constant.UNIT_BYTE);  // TB
    public static Storage1024Impl TB = new Storage1024Impl(StorageName.TB, GB.lUnit * Constant.UNIT_BYTE); // PB

    Storage1024Impl(StorageName storageName, long lUnit) {
        super(storageName, lUnit);
    }

    private static Storage1024Impl[] values() {
        return new Storage1024Impl[]{B, KB, MB, GB, TB};
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
        public static final int UNIT_BYTE = 1024;
    }
}