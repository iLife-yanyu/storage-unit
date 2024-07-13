package com.yanyu.demoapp

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.yanyu.demoapp.databinding.ActivityBootBinding

class BootActivity : AppCompatActivity() {

    private var editData: Long = 0L
    private val binding by lazy(LazyThreadSafetyMode.NONE) { ActivityBootBinding.inflate(layoutInflater) }
    private val unitList = StorageName.entries.toTypedArray()
    private val resultAdapter: ResultAdapter by lazy(LazyThreadSafetyMode.NONE) { ResultAdapter(arrayListOf()) }
    private var storageName: StorageName = StorageName.MB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initData()
        initListeners()
        initViews()
    }

    private fun initData() {
        editData = 10240L
        binding.etLength.setText(editData.toString())
        initByteAdapter()
    }

    private fun initListeners() {
        binding.etLength.addTextChangedListener {
            try {
                val toString = it.toString()
                editData = if (toString.isEmpty()) {
                    0L
                }
                else {
                    toString.toLong()
                }
                updateResultAdapter()
            }
            catch (e: Exception) {
                Toast.makeText(this, "输入错误 ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initViews() {
        binding.rvResult.adapter = resultAdapter
        binding.btnUnit.setSelection(unitList.indexOf(storageName))
    }

    private fun initByteAdapter() {
        binding.btnUnit.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, unitList)
        binding.btnUnit.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                storageName = unitList[position]
                updateResultAdapter()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    private fun updateResultAdapter() {
        if (editData == 0L) {
            return
        }
        val storage1000Impl = StorageUtil.get1000Impl(storageName.sUnit)
        val storage1024Impl = StorageUtil.get1024Impl(storageName.sUnit)
        val arrayList = ArrayList<ResultBean>(unitList.size)
        arrayList.add(ResultBean.withByte(storage1000Impl, storage1024Impl, editData))
        arrayList.add(ResultBean.withKiloByte(storage1000Impl, storage1024Impl, editData))
        arrayList.add(ResultBean.withMegaByte(storage1000Impl, storage1024Impl, editData))
        arrayList.add(ResultBean.withGigaByte(storage1000Impl, storage1024Impl, editData))
        arrayList.add(ResultBean.withTrillionByte(storage1000Impl, storage1024Impl, editData))
        resultAdapter.updateData(arrayList)
    }
}