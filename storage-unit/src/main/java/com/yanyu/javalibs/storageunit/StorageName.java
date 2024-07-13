package com.yanyu.javalibs.storageunit;

enum StorageName {

    B("B"),  // B
    KB("KB"),  // KB
    MB("MB"),  // MB
    GB("GB"),  // GB
    TB("TB"); // TB

    final String sUnit;

    StorageName(String sUnit) {
        this.sUnit = sUnit;
    }
}
