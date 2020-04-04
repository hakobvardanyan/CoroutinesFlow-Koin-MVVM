package com.example.coroutinesflow_koin_mvvm.feature.employeeslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coroutinesflow_koin_mvvm.R
import kotlinx.android.synthetic.main.user_list_fragment.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@FlowPreview
@ExperimentalCoroutinesApi
class UsersListFragment constructor(
    private val viewModel: UsersListViewModel
) : Fragment() {

    private var userAdapter: UserAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoading()
        setupRecyclerView()

        viewModel.viewModelScope.launch {

            viewModel.observeEmployers().collect {
                userAdapter?.updateItems(it)
                hideLoading()
            }

            userAdapter?.itemClicks()?.collect {
                Toast.makeText(context, "${it.name}", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onDestroyView() {
        userAdapter = null
        super.onDestroyView()
    }

    private fun setupRecyclerView() {
        userAdapter = UserAdapter()
        employeesRecyclerView.layoutManager = LinearLayoutManager(context)
        employeesRecyclerView.adapter = userAdapter
    }

    private fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        progressBar.visibility = View.GONE
    }

}
