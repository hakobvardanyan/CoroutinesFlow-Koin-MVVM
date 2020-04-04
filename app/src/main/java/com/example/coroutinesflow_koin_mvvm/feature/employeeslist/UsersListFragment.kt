package com.example.coroutinesflow_koin_mvvm.feature.employeeslist

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coroutinesflow_koin_mvvm.R
import com.example.coroutinesflow_koin_mvvm.extension.color
import com.example.coroutinesflow_koin_mvvm.extension.dimenInt
import com.example.coroutinesflow_koin_mvvm.feature.base.BaseFragment
import com.google.android.material.snackbar.Snackbar.LENGTH_SHORT
import com.google.android.material.snackbar.Snackbar.make
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
        try {
            viewModel.observeUsers()
                .collect {
                    userAdapter?.updateItems(it)
                    hideLoading()
                    observeItemClicks()
                }
        } catch (e: Exception) {
            hideLoading()
            showUnexpectedError()
        }
    }

    private suspend fun observeItemClicks() {
        userAdapter?.itemClicks()?.collect {
            Toast.makeText(context, "${it.name}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showUnexpectedError() {
        make(requireView(), getString(R.string.unexpected_error_text), LENGTH_SHORT).show()
    }

    private fun setupRecyclerView() {
        val color = requireContext().color(R.color.colorGreyLight)
        val height = requireContext().dimenInt(R.dimen.divider_height)
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
