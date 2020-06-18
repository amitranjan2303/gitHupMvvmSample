package com.amit.sampleapp.viewholders

import android.os.Build
import android.text.Html
import android.view.View
import com.amit.sampleapp.callback.Navigator
import com.amit.sampleapp.databinding.ItemIssuesViewBinding
import com.amit.sampleapp.model.DataItemModel

open class IssuesViewHolder(var itemViewBinding: ItemIssuesViewBinding,var navigatorCallBack: Navigator) :
    BaseViewHolder(itemViewBinding.root) {

    override fun onBind(item: Any) {

        if (item is DataItemModel) {
            itemViewBinding?.title?.text = item.title
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                itemViewBinding.createdAt.text = Html.fromHtml(
                    "<b>Created At : </b>" + item.createdAt,
                    Html.FROM_HTML_MODE_COMPACT
                )
            } else {
                itemViewBinding.createdAt.text =
                    Html.fromHtml("<b>Created At : </b>" + item.createdAt)
            }
            itemViewBinding.comment.text = "" + item.comments
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                itemViewBinding.subTitle.text =
                    Html.fromHtml(item.body, Html.FROM_HTML_MODE_COMPACT)
            } else {
                itemViewBinding.subTitle.text = Html.fromHtml(item.body)
            }
            itemViewBinding.comment.setOnClickListener(object :View.OnClickListener{
                override fun onClick(v: View?) {
                    navigatorCallBack?.goToComments(item.number!!)
                }
            })
        }
    }
}