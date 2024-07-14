package com.yanyu.javalibs.storageunit;

interface IStorageParamsGetter {

    /**
     * @return 计算长度的单位，比如B、KB、MB、GB、TB
     */
    String iGetUnitName();

    /**
     * @return 返回当前计算长度的byte大小，比如
     * Byte返回1024或者1000，
     * KiloByte返回1024^2或者1000^2，
     * 以此类推
     */
    long iGetConversionRatioUnit();

    /**
     * @return 计算长度的基本单位，只能是1000或者1024
     */
    long iGetConversionRatio();
}
