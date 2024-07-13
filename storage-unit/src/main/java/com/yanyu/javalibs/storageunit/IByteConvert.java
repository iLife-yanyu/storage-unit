package com.yanyu.javalibs.storageunit;

interface IByteConvert {

    String toByte(long length);

    String toKiloByte(long length);

    String toMegaByte(long length);

    String toGigaByte(long length);

    String toTrillionByte(long length);
}
