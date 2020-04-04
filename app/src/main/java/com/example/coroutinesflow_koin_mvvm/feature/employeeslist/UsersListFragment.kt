package com.example.coroutinesflow_koin_mvvm.feature.employeeslist

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coroutinesflow_koin_mvvm.R
import com.example.coroutinesflow_koin_mvvm.feature.base.BaseFragment
import kotlinx.android.synthetic.main.user_list_fragment.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@FlowPreview
@ExperimentalCoroutinesApi
class UsersListFragment constructor(
    private val viewModel: UsersListViewModel
) : BaseFragment() {

    private var userAdapter: UserAdapter? = null

    override val layoutRes = R.layout.user_list_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoading()
        setupRecyclerView()

        viewModel.viewModelScope.launch {
            observeUsers()
        }
    }

    private suspend fun observeUsers() {
        viewModel.observeUsers().collect {
            userAdapter?.updateItems(it)
            hideLoading()
            observeItemClicks()
        }
    }

    private suspend fun observeItemClicks() {
        userAdapter?.itemClicks()?.collect {
            Toast.makeText(context, "${it.name}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupRecyclerView() {
        val color = ContextCompat.getColor(requireContext(), R.color.colorGreyLight)
        val height = resources.getDimensionPixelOffset(R.dimen.divider_height)
        userAdapter = UserAdapter()
        usersRecyclerView.layoutManager = LinearLayoutManager(context)
        usersRecyclerView.adapter = userAdapter
        usersRecyclerView.addItemDecoration(UserDividerItemDecoration(color, height))
    }

    private fun showLoading() {
        progressBar?.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        progressBar?.visibility = View.GONE
    }

}
