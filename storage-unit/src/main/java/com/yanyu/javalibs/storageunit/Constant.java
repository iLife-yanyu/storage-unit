package com.yanyu.javalibs.storageunit;

class Constant {
    public static final int UNIT_B_1024 = 1024;
    public static final int UNIT_B_1000 = 1000;

    public static long iGetUnitByte(boolean size1024) {
        if (size1024) {
            return UNIT_B_1024;
        }
        else {
            return UNIT_B_1000;
        }
    }
}
