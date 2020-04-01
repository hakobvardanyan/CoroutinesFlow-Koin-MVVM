package com.example.coroutinesflow_koin_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.data.repository.EmployeeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.get

class SingleActivity : AppCompatActivity() {

    val repo = get<EmployeeRepository>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)

        GlobalScope.launch(Dispatchers.Main) {
            repo.getEmployees().collect {
                Toast.makeText(this@SingleActivity, it.toString(), Toast.LENGTH_LONG).show()
            }
        }

    }
}
