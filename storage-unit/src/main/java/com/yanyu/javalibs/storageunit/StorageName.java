package com.yanyu.javalibs.storageunit;

public enum StorageName {

    B("B"),  // KB
    KB("KB"),  // MB
    MB("MB"),  // GB
    GB("GB"),  // TB
    TB("TB"); // PB

    final String sUnit;

    StorageName(String sUnit) {
        this.sUnit = sUnit;
    }

    @Override
    public String toString() {
        return sUnit;
    }
}
