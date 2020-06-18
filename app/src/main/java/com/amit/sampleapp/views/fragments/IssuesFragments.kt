package com.amit.sampleapp.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amit.sampleapp.R
import com.amit.sampleapp.SampleApp
import com.amit.sampleapp.adapters.IssuesAdapter
import com.amit.sampleapp.callback.Navigator
import com.amit.sampleapp.databinding.FragmentIssuesBinding
import com.amit.sampleapp.model.DataItemModel
import com.amit.sampleapp.viewmodels.IssuesViewModel
import com.amit.sampleapp.views.activities.MainActivity


class IssuesFragments : Fragment(), Navigator {

    private lateinit var mBinding: FragmentIssuesBinding
    private lateinit var mViewModel: IssuesViewModel
    private lateinit var mItemList: ArrayList<Any>
    private lateinit var mAdapter: IssuesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(this).get(IssuesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_issues,
            container,
            false
        )
        mBinding.viewModel = mViewModel
        (activity as MainActivity).setUpToolBar("Issues", false)
        return mBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setUpToolBar("Issues", false)
        mViewModel.getAllIssues()
        mItemList = ArrayList()
        mAdapter = IssuesAdapter(mItemList, this)
        // mBinding.rvIssues.setHasFixedSize(true)
        mBinding.rvIssues.layoutManager = LinearLayoutManager(context)
        mBinding.rvIssues.adapter = mAdapter
        getObserable()
    }

    private fun getObserable() {
        mViewModel.getItemData().observe(this, Observer {
            mAdapter.updateList(it as ArrayList<Any>)
        })

        mViewModel.getFailureLiveData().observe(this, Observer {
            if (it){
                activity?.finish()
            }
        })
    }

    override fun goToComments(userId: Int) {
        (activity as MainActivity).goToComments(userId)
    }

}