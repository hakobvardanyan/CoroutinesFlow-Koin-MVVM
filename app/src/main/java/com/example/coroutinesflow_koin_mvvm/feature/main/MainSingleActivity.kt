package com.example.coroutinesflow_koin_mvvm.feature.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.coroutinesflow_koin_mvvm.R
import org.koin.androidx.fragment.android.setupKoinFragmentFactory

class MainSingleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setupKoinFragmentFactory()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_single)
    }
}
