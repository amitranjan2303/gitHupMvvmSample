package com.amit.sampleapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.amit.sampleapp.R
import com.amit.sampleapp.callback.Navigator
import com.amit.sampleapp.databinding.ItemIssuesViewBinding
import com.amit.sampleapp.viewholders.BaseViewHolder
import com.amit.sampleapp.viewholders.IssuesViewHolder

open class IssuesAdapter(var itemList: ArrayList<Any>?,var navigatorCallBack: Navigator) : RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        var viewBinding: ItemIssuesViewBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), viewType, parent, false)
        var viewHolder: BaseViewHolder = IssuesViewHolder(viewBinding,navigatorCallBack)
        return viewHolder
    }

    override fun getItemCount(): Int {
        var count: Int = 0
        if (!itemList.isNullOrEmpty()) {
            count = itemList?.size!!
        }
        return count
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        if (holder is IssuesViewHolder) {
            holder.onBind(itemList?.get(position)!!)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_issues_view
    }

    fun updateList(list:ArrayList<Any>?){
        itemList=list
        this.notifyDataSetChanged()
    }

}
