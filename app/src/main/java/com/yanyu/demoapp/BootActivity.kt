package com.yanyu.demoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yanyu.demoapp.databinding.ActivityBootBinding
import com.yanyu.javalibs.storageunit.StorageUnit

class BootActivity : AppCompatActivity() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) { ActivityBootBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val wrapSize = StorageUnit.wrapSize(1024 * 1024)
        binding.tvTip.text = wrapSize
    }
}