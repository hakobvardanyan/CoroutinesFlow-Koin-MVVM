package com.example.coroutinesflow_koin_mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.fragment.android.setupKoinFragmentFactory

class SingleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setupKoinFragmentFactory()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)
    }
}
