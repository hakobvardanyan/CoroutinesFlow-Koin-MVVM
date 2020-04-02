package com.example.coroutinesflow_koin_mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class EmployeesListFragment constructor(
    private val viewModel: EmployeesListViewModel
) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.employees_list_fragment, container, false)
    }

    override fun onStart() {
        super.onStart()
        viewModel.viewModelScope.launch {
            viewModel.observeEmployers().collect {
                Toast.makeText(context, it.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }

}
