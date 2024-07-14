package com.yanyu.javalibs.storageunit;

import java.io.File;

abstract class AbstractStorage implements IByteConvert, IStorageParamsGetter {

    protected final long conversionRatioUnit;
    protected final StorageName storageName;
    private volatile IByteConvert iByteConvert;

    AbstractStorage(StorageName storageName, long conversionRatioUnit) {
        this.storageName = storageName;
        this.conversionRatioUnit = conversionRatioUnit;
    }

    private IByteConvert createByteConvert() {
        if (iByteConvert == null) {
            synchronized (this) {
                if (iByteConvert == null) {
                    iByteConvert = ConvertFactory.createByteConvert(this.storageName, iGetConversionRatio());
                }
            }
        }
        return iByteConvert;
    }

    public final String wrapSize(File file) {
        return wrapSize(file.length());
    }

    public final String wrapSize(long length) {
        return Util.wrapSize(this, length);
    }

    @Override
    public final String toByte(long length) {
        return createByteConvert().toByte(length);
    }

    @Override
    public final String toKiloByte(long length) {
        return createByteConvert().toKiloByte(length);
    }

    @Override
    public final String toMegaByte(long length) {
        return createByteConvert().toMegaByte(length);
    }

    @Override
    public final String toGigaByte(long length) {
        return createByteConvert().toGigaByte(length);
    }

    @Override
    public final String toTrillionByte(long length) {
        return createByteConvert().toTrillionByte(length);
    }

    /**
     * @return 计算长度的单位，比如B、KB、MB、GB、TB
     */
    @Override
    public final String iGetUnitName() {
        return storageName.sUnit;
    }

    /**
     * @return 返回当前计算长度的byte大小，比如
     * Byte返回1024或者1000，
     * KiloByte返回1024^2或者1000^2，
     * 以此类推
     */
    @Override
    public final long iGetConversionRatioUnit() {
        return conversionRatioUnit;
    }
}