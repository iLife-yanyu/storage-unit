package com.yanyu.javalibs.storageunit;

import java.io.File;

abstract class AbstractStorage implements IByteConvert, IStorageParamsGetter {

    protected final long lUnit;
    protected final StorageName storageName;
    private volatile IByteConvert IByteConvert;

    AbstractStorage(StorageName storageName, long lUnit) {
        this.storageName = storageName;
        this.lUnit = lUnit;
    }

    private IByteConvert createByteConvert() {
        if (IByteConvert == null) {
            synchronized (this) {
                if (IByteConvert == null) {
                    IByteConvert = ConvertFactory.createByteConvert(this.storageName, iGetUnitByte());
                }
            }
        }
        return IByteConvert;
    }

    public String wrapSize(File file) {
        return wrapSize(file.length());
    }

    public String wrapSize(long length) {
        return Util.wrapSize(this, length, iGetUnitByte());
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