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
import com.amit.sampleapp.R
import com.amit.sampleapp.adapters.CommentsAdapter
import com.amit.sampleapp.adapters.IssuesAdapter
import com.amit.sampleapp.databinding.FragmentCommentsBinding
import com.amit.sampleapp.viewmodels.CommentsViewModel
import com.amit.sampleapp.views.activities.MainActivity


class CommentsFragment : Fragment() {

    private lateinit var mBinding: FragmentCommentsBinding
    private lateinit var mViewModel: CommentsViewModel
    private lateinit var mItemList: ArrayList<Any>
    private lateinit var mAdapter: CommentsAdapter
    private var mUserId: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(this).get(CommentsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_comments,
            container,
            false
        )
        mBinding.viewModel = mViewModel
        mUserId = arguments?.get("userId") as Int

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as MainActivity).setUpToolBar("Comments", true)
        mViewModel.getAllComments(mUserId)
        mItemList = ArrayList()
        mAdapter = CommentsAdapter(mItemList)
        // mBinding.rvIssues.setHasFixedSize(true)
        mBinding.rvComments.layoutManager = LinearLayoutManager(context)
        mBinding.rvComments.adapter = mAdapter
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
}