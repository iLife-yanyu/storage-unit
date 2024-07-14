package com.yanyu.javalibs.storageunit;

import java.io.File;

abstract class AbstractStorage implements IByteConvert, IStorageParamsGetter {

    protected final long lUnit;
    protected final StorageName storageName;
    private volatile IByteConvert iByteConvert;

    AbstractStorage(StorageName storageName, long lUnit) {
        this.storageName = storageName;
        this.lUnit = lUnit;
    }

    private IByteConvert createByteConvert() {
        if (iByteConvert == null) {
            synchronized (this) {
                if (iByteConvert == null) {
                    iByteConvert = ConvertFactory.createByteConvert(this.storageName, iGetUnitByte());
                }
            }
        }
        return iByteConvert;
    }

    public String wrapSize(File file) {
        return wrapSize(file.length());
    }

    public String wrapSize(long length) {
        return Util.wrapSize(this, length);
    }

    @Override
    public String toByte(long length) {
        return createByteConvert().toByte(length);
    }

    @Override
    public String toKiloByte(long length) {
        return createByteConvert().toKiloByte(length);
    }

    @Override
    public String toMegaByte(long length) {
        return createByteConvert().toMegaByte(length);
    }

    @Override
    public String toGigaByte(long length) {
        return createByteConvert().toGigaByte(length);
    }

    @Override
    public String toTrillionByte(long length) {
        return createByteConvert().toTrillionByte(length);
    }

    @Override
    public String iGetStringUnit() {
        return storageName.sUnit;
    }

    @Override
    public long iGetLongUnit() {
        return lUnit;
    }
}