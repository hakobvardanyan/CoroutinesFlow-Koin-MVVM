package com.example.coroutinesflow_koin_mvvm

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.androidx.viewmodel.ext.android.viewModel


class EmployeesListFragment : Fragment() {

    companion object {
        fun newInstance() = EmployeesListFragment()
    }

    private val viewModel by viewModel<EmployeesListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.employees_list_fragment, container, false)
    }

}
