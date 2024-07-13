package com.yanyu.demoapp;

import org.jetbrains.annotations.NotNull;

/**
 * 这个和 storage-unit 库的 StorageName 枚举类一样，另外单独写一个是为了保持
 * storage-unit 库的 StorageName 类的封装性
 */
public enum StorageName {

    B("B"),  // B
    KB("KB"),  // KB
    MB("MB"),  // MB
    GB("GB"),  // GB
    TB("TB"); // TB

    final String sUnit;

    StorageName(String sUnit) {
        this.sUnit = sUnit;
    }

    @NotNull
    @Override
    public String toString() {
        return sUnit;
    }
}
