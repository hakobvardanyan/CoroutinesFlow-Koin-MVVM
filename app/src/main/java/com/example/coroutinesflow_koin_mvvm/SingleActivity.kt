package com.example.coroutinesflow_koin_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.domain.employee.LoadEmployeeUseCase
import com.example.domain.repository.EmployeeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get

class SingleActivity : AppCompatActivity() {

    val useCase = get<LoadEmployeeUseCase>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)

        GlobalScope.launch(Dispatchers.Main) {
            useCase.execute().collect {
                Toast.makeText(this@SingleActivity, it.toString(), Toast.LENGTH_LONG).show()
            }
        }

    }
}
