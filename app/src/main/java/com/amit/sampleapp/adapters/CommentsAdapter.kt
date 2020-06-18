package com.amit.sampleapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.amit.sampleapp.R
import com.amit.sampleapp.databinding.ItemCommentBinding
import com.amit.sampleapp.viewholders.BaseViewHolder
import com.amit.sampleapp.viewholders.CommentsViewHolder

open class CommentsAdapter(var itemList: ArrayList<Any>?) :

    RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        var viewBinding: ItemCommentBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), viewType, parent, false)
        var viewHolder: BaseViewHolder = CommentsViewHolder(viewBinding)
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
        if (holder is CommentsViewHolder) {
            holder.onBind(itemList?.get(position)!!)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_comment
    }

    fun updateList(list:ArrayList<Any>?){
        itemList=list
        this.notifyDataSetChanged()
    }

}
