package com.yanyu.javalibs.storageunit;

import java.io.File;

public final class Storage1000Impl extends AbstractStorage {

    public static final Storage1000Impl B = new Storage1000Impl(StorageName.B, Constant.UNIT_BYTE);  // B
    public static final Storage1000Impl KB = new Storage1000Impl(StorageName.KB, B.conversionRatioUnit * Constant.UNIT_BYTE);  // KB
    public static final Storage1000Impl MB = new Storage1000Impl(StorageName.MB, KB.conversionRatioUnit * Constant.UNIT_BYTE);  // MB
    public static final Storage1000Impl GB = new Storage1000Impl(StorageName.GB, MB.conversionRatioUnit * Constant.UNIT_BYTE);  // GB
    public static final Storage1000Impl TB = new Storage1000Impl(StorageName.TB, GB.conversionRatioUnit * Constant.UNIT_BYTE); // TB

    Storage1000Impl(StorageName storageName, long conversionRatioUnit) {
        super(storageName, conversionRatioUnit);
    }

    private static Storage1000Impl[] values() {
        return new Storage1000Impl[]{B, KB, MB, GB, TB};
    }

    public static String sWrapSize(File file) {
        return sWrapSize(file.length());
    }

    /**
     * 计算单位是计算机系统中的基本单位字节
     *
     * @param length 长度
     * @return 带有存储单位的字符串，example：10.24GB
     */
    public static String sWrapSize(long length) {
        return Util.wrapSize(values(), length);
    }

    /**
     * @return 计算长度的基本单位，只能是1000或者1024
     */
    @Override
    public long iGetConversionRatio() {
        return Constant.UNIT_BYTE;
    }

    private static class Constant {
        public static final int UNIT_BYTE = 1000;
    }
}