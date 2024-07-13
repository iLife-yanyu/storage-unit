package com.yanyu.demoapp

import com.yanyu.javalibs.storageunit.Storage1000Impl
import com.yanyu.javalibs.storageunit.Storage1024Impl

class ResultBean(data1000: String, data1024: String) {

    val data1000: String = "1000: $data1000"
    val data1024: String = "1024: $data1024"

    companion object {

        fun withByte(storage1000Impl: Storage1000Impl, storage1024Impl: Storage1024Impl, len: Long): ResultBean {
            return ResultBean(storage1000Impl.toByte(len), storage1024Impl.toByte(len))
        }

        fun withKiloByte(storage1000Impl: Storage1000Impl, storage1024Impl: Storage1024Impl, len: Long): ResultBean {
            return ResultBean(storage1000Impl.toKiloByte(len), storage1024Impl.toKiloByte(len))
        }

        fun withMegaByte(storage1000Impl: Storage1000Impl, storage1024Impl: Storage1024Impl, len: Long): ResultBean {
            return ResultBean(storage1000Impl.toMegaByte(len), storage1024Impl.toMegaByte(len))
        }

        fun withGigaByte(storage1000Impl: Storage1000Impl, storage1024Impl: Storage1024Impl, len: Long): ResultBean {
            return ResultBean(storage1000Impl.toGigaByte(len), storage1024Impl.toGigaByte(len))
        }

        fun withTrillionByte(storage1000Impl: Storage1000Impl, storage1024Impl: Storage1024Impl, len: Long): ResultBean {
            return ResultBean(storage1000Impl.toTrillionByte(len), storage1024Impl.toTrillionByte(len))
        }
    }

}