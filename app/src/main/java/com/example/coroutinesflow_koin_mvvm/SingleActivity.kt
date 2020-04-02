package com.example.coroutinesflow_koin_mvvm

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.domain.employee.LoadEmployeeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel

class SingleActivity : AppCompatActivity() {

    val model by viewModel<EmployeesListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)

        GlobalScope.launch(Dispatchers.Main) {
            model.observeEmployers().collect {
                Toast.makeText(this@SingleActivity, it.toString(), Toast.LENGTH_LONG).show()
            }
        }

    }
}
