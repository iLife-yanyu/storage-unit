package com.yanyu.javalibs.storageunit;

class ConvertFactory {

    static IByteConvert createByteConvert(StorageName storageName, long unitByte) {
        switch (storageName) {
            case B:
                return new ByteConvert(unitByte);
            case KB:
                return new KiloByteConvert(unitByte);
            case MB:
                return new MegaByteConvert(unitByte);
            case GB:
                return new GigaByteConvert(unitByte);
            case TB:
                return new TrillionByteConvert(unitByte);
            default:
                throw new IllegalArgumentException("storageName is not support");
        }
    }

    abstract static class AbstractByteConvert implements IByteConvert {
        final long lUnit;

        public AbstractByteConvert(long lUnit) {
            this.lUnit = lUnit;
        }
    }

    static class ByteConvert extends AbstractByteConvert {


        public ByteConvert(long unitByte) {
            super(unitByte);
        }

        @Override
        public String toByte(long length) {
            return Util.wrapSize(length, StorageName.B.sUnit);
        }

        @Override
        public String toKiloByte(long length) {
            return Util.wrapSize(length * 1F / lUnit, StorageName.KB.sUnit);
        }

        @Override
        public String toMegaByte(long length) {
            return Util.wrapSize(length * 1F / lUnit / lUnit, StorageName.MB.sUnit);
        }

        @Override
        public String toGigaByte(long length) {
            return Util.wrapSize(length * 1F / lUnit / lUnit / lUnit, StorageName.GB.sUnit);
        }

        @Override
        public String toTrillionByte(long length) {
            return Util.wrapSize(length * 1F / lUnit / lUnit / lUnit / lUnit, StorageName.TB.sUnit);
        }
    }

    static class KiloByteConvert extends AbstractByteConvert {

        public KiloByteConvert(long lUnit) {
            super(lUnit);
        }

        @Override
        public String toByte(long length) {
            return Util.wrapSize(length * lUnit, StorageName.B.sUnit);
        }

        @Override
        public String toKiloByte(long length) {
            return Util.wrapSize(length, StorageName.KB.sUnit);
        }

        @Override
        public String toMegaByte(long length) {
            return Util.wrapSize(length * 1F / lUnit, StorageName.MB.sUnit);
        }

        @Override
        public String toGigaByte(long length) {
            return Util.wrapSize(length * 1F / lUnit / lUnit, StorageName.GB.sUnit);
        }

        @Override
        public String toTrillionByte(long length) {
            return Util.wrapSize(length * 1F / lUnit / lUnit / lUnit, StorageName.TB.sUnit);
        }
    }

    static class MegaByteConvert extends AbstractByteConvert {

        public MegaByteConvert(long lUnit) {
            super(lUnit);
        }

        @Override
        public String toByte(long length) {
            return Util.wrapSize(length * lUnit * lUnit, StorageName.B.sUnit);
        }

        @Override
        public String toKiloByte(long length) {
            return Util.wrapSize(length * lUnit, StorageName.KB.sUnit);
        }

        @Override
        public String toMegaByte(long length) {
            return Util.wrapSize(length, StorageName.MB.sUnit);
        }

        @Override
        public String toGigaByte(long length) {
            return Util.wrapSize(length * 1F / lUnit, StorageName.GB.sUnit);
        }

        @Override
        public String toTrillionByte(long length) {
            return Util.wrapSize(length * 1F / lUnit / lUnit, StorageName.TB.sUnit);
        }

    }

    static class GigaByteConvert extends AbstractByteConvert {

        public GigaByteConvert(long lUnit) {
            super(lUnit);
        }

        @Override
        public String toByte(long length) {
            return Util.wrapSize(length * lUnit * lUnit * lUnit, StorageName.B.sUnit);
        }

        @Override
        public String toKiloByte(long length) {
            return Util.wrapSize(length * lUnit * lUnit, StorageName.KB.sUnit);
        }

        @Override
        public String toMegaByte(long length) {
            return Util.wrapSize(length * lUnit, StorageName.MB.sUnit);
        }

        @Override
        public String toGigaByte(long length) {
            return Util.wrapSize(length, StorageName.GB.sUnit);
        }

        @Override
        public String toTrillionByte(long length) {
            return Util.wrapSize(length * 1F / lUnit, StorageName.TB.sUnit);
        }
    }

    static class TrillionByteConvert extends AbstractByteConvert {

        public TrillionByteConvert(long lUnit) {
            super(lUnit);
        }

        @Override
        public String toByte(long length) {
            return Util.wrapSize(length * lUnit * lUnit * lUnit * lUnit, StorageName.B.sUnit);
        }

        @Override
        public String toKiloByte(long length) {
            return Util.wrapSize(length * lUnit * lUnit * lUnit, StorageName.KB.sUnit);
        }

        @Override
        public String toMegaByte(long length) {
            return Util.wrapSize(length * lUnit * lUnit, StorageName.MB.sUnit);
        }

        @Override
        public String toGigaByte(long length) {
            return Util.wrapSize(length * lUnit, StorageName.GB.sUnit);
        }

        @Override
        public String toTrillionByte(long length) {
            return Util.wrapSize(length, StorageName.TB.sUnit);
        }
    }
}
