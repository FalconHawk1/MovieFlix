package com.make.deve.mytestapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.make.deve.mytestapp.R
import com.make.deve.mytestapp.databinding.ActivityMainBinding
import com.make.deve.mytestapp.ui.util.toggleVisibility
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val vm: MainViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        vm.loading.observe(this) {
            binding.loadingLy.visibility = if (it) View.VISIBLE else View.GONE
        }
    }

    fun toggleTitle(showTitle: Boolean) {
        binding.topView.toggleVisibility(showTitle)
        //binding.topIv.toggleVisibility(showTitle)
    }
}