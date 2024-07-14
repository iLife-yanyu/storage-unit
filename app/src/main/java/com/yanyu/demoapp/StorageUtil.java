package com.yanyu.demoapp;

import com.yanyu.javalibs.storageunit.Storage1000Impl;
import com.yanyu.javalibs.storageunit.Storage1024Impl;

import java.util.Objects;

public class StorageUtil {

    public static Storage1000Impl get1000Impl(String name) {
        Storage1000Impl[] values = new Storage1000Impl[]{
                // 1000
                Storage1000Impl.B, // B
                Storage1000Impl.KB, // KB
                Storage1000Impl.MB, // MB
                Storage1000Impl.GB, // GB
                Storage1000Impl.TB, // TB
        };
        for (Storage1000Impl value : values) {
            if (Objects.equals(value.iGetUnitName(), name)) {
                return value;
            }
        }
        throw new IllegalArgumentException("name is not found");
    }

    public static Storage1024Impl get1024Impl(String name) {
        Storage1024Impl[] values = new Storage1024Impl[]{
                // 1024
                Storage1024Impl.B, // B
                Storage1024Impl.KB, // KB
                Storage1024Impl.MB, // MB
                Storage1024Impl.GB, // GB
                Storage1024Impl.TB, // TB
        };
        for (Storage1024Impl value : values) {
            if (Objects.equals(value.iGetUnitName(), name)) {
                return value;
            }
        }
        throw new RuntimeException("not found");
    }

}
