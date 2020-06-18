package com.amit.sampleapp.viewholders

import android.os.Build
import android.text.Html
import android.text.TextUtils
import com.amit.sampleapp.R
import com.amit.sampleapp.SampleApp
import com.amit.sampleapp.databinding.ItemCommentBinding
import com.amit.sampleapp.databinding.ItemIssuesViewBinding
import com.amit.sampleapp.model.DataItemModel
import com.amit.sampleapp.views.customviews.CircleTransform
import com.squareup.picasso.Picasso

class CommentsViewHolder(
    var itemViewBinding: ItemCommentBinding
) :
    BaseViewHolder(itemViewBinding.root) {

    override fun onBind(item: Any) {
        if (item is DataItemModel) {
            itemViewBinding?.txtName?.text = "" + item.id
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                itemViewBinding.comments.text =
                    Html.fromHtml(item.body, Html.FROM_HTML_MODE_COMPACT)
            } else {
                itemViewBinding.comments.text = Html.fromHtml(item.body)
            }

            if (!TextUtils.isEmpty(item.user?.avatarUrl)) {
                Picasso.get().load(item.user?.avatarUrl).transform(CircleTransform())
                    .placeholder(R.mipmap.ic_profile_pic)
                    .into(itemViewBinding.imgProfilePic)
            } else {
                Picasso.get().load(R.mipmap.ic_launcher).into(itemViewBinding.imgProfilePic)
            }


        }
    }
}