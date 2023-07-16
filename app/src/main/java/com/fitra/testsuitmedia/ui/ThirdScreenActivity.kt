package com.fitra.testsuitmedia.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.fitra.testsuitmedia.R
import com.fitra.testsuitmedia.adapter.LoadingStateAdapter
import com.fitra.testsuitmedia.adapter.UserAdapter
import com.fitra.testsuitmedia.data.DataItem
import com.fitra.testsuitmedia.databinding.ActivityThirdScreenBinding
import com.fitra.testsuitmedia.viewmodel.ThirdScreenViewModel
import com.fitra.testsuitmedia.viewmodel.ViewModelFactory

class ThirdScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdScreenBinding
    private lateinit var viewModelFactory: ViewModelFactory
    private val thirdScreenViewModel: ThirdScreenViewModel by viewModels { viewModelFactory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModelFactory = ViewModelFactory.getInstance(binding.root.context)

        binding.icBack.setOnClickListener {
            onBackPressed()
        }

        showList()
    }

    private fun showList() {
        binding.rvUser.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        binding.rvUser.layoutManager = layoutManager

        val userAdapter = UserAdapter()
        binding.rvUser.adapter = userAdapter.withLoadStateFooter(
            footer = LoadingStateAdapter{userAdapter.retry()}
        )

        thirdScreenViewModel.getAllUser.observe(this){
            if (it != null){
                userAdapter.submitData(lifecycle, it)
            }else{
                Toast.makeText(this, "Data is Empty", Toast.LENGTH_SHORT).show()
            }

            userAdapter.addLoadStateListener { loadStates ->

                when (loadStates.refresh) {
                    is LoadState.Loading -> {
                        showLoading(true)
                    }
                    else -> {
                        showLoading(false)
                    }
                }
            }
        }

        binding.swipeRefresh.setOnRefreshListener {
            userAdapter.refresh()
            binding.swipeRefresh.isRefreshing = false
            binding.rvUser.visibility = View.GONE
        }

        userAdapter.addLoadStateListener {
            binding?.apply {
                rvUser.isVisible = it.source.refresh is LoadState.NotLoading

                rvUser.isVisible = !(it.source.refresh is LoadState.NotLoading &&
                        it.append.endOfPaginationReached &&
                        userAdapter.itemCount < 1)
            }
        }


        userAdapter.setOnItemClickCallback(object : UserAdapter.OnItemClickCallback{
            override fun onItemClicked(data: DataItem) {
                Intent(this@ThirdScreenActivity, SecondScreenActivity::class.java).also { intent ->
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                    intent.putExtra(SecondScreenActivity.USERNAME, data)
                    startActivity(intent)
                }
                finish()
            }
        })
    }

    private fun showLoading(isLoading: Boolean){
        if (isLoading){
            binding.progressBar.visibility = View.VISIBLE
        }else{
            binding.progressBar.visibility = View.GONE
        }
    }
}