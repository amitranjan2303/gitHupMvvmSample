package com.amit.sampleapp.views.activities

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.amit.sampleapp.R
import com.amit.sampleapp.databinding.ActivityMainBinding
import com.amit.sampleapp.views.fragments.CommentsFragment
import com.amit.sampleapp.views.fragments.IssuesFragments
import kotlinx.android.synthetic.main.app_tool_bar_view.view.*


class MainActivity : BaseActivity() {

    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(mBinding?.includeToolbar.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        if (savedInstanceState == null) {
            goToIssues()
        }

    }

    fun setUpToolBar(title: String, isEnable: Boolean) {
        mBinding.includeToolbar.toolbar.tool_title.text = title

    }

    fun goToIssues() {
        val fragment: Fragment = IssuesFragments()
        supportFragmentManager?.beginTransaction()
            .add(R.id.container, fragment, "IssuesFragments")
            .commit()
    }

    fun goToComments(userId: Int?) {
        val fragment: Fragment = CommentsFragment()
        val bundle = Bundle()
        bundle.putInt("userId", userId!!)
        fragment.setArguments(bundle)
        supportFragmentManager?.beginTransaction()
            .add(R.id.container, fragment, "CommentsFragment").addToBackStack(null).commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (mBinding.includeToolbar.toolTitle.text.toString().equals("Issues", true)) {
            setUpToolBar("Comments", false)
        } else {
            setUpToolBar("Issues", false)
        }
    }
}
