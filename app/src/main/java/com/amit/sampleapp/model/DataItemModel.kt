package com.amit.sampleapp.model

import com.google.gson.annotations.SerializedName

data class DataItemModel (

    @SerializedName("url")
    var url: String? = null,

    @SerializedName("repository_url")
    var repositoryUrl: String? = null,

    @SerializedName("labels_url")
    var labelsUrl: String? = null,

    @SerializedName("comments_url")
    var commentsUrl: String? = null,

    @SerializedName("events_url")
    var eventsUrl: String? = null,

    @SerializedName("html_url")
    var htmlUrl: String? = null,

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("node_id")
    var nodeId: String? = null,

    @SerializedName("number")
    var number: Int? = null,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("user")
    var user: User? = null,

    @SerializedName("labels")
    var labels: ArrayList<Label>? = null,

    @SerializedName("state")
    var state: String? = null,

    @SerializedName("locked")
    var locked: Boolean? = null,

    @SerializedName("assignee")
    var assignee: Any? = null,

    @SerializedName("assignees")
    var assignees: ArrayList<Any>? = null,

    @SerializedName("milestone")
    var milestone: Any? = null,

    @SerializedName("comments")
    var comments: Int? = null,

    @SerializedName("created_at")
    var createdAt: String? = null,

    @SerializedName("updated_at")
    var updatedAt: String? = null,

    @SerializedName("closed_at")
    var closedAt: Any? = null,

    @SerializedName("author_association")
    var authorAssociation: String? = null,

    @SerializedName("active_lock_reason")
    var activeLockReason: Any? = null,

    @SerializedName("body")
    var body: String? = null
) : BaseModel(){


//    @JsonIgnore
//     var additionalProperties: Map<String, Any> =
//        HashMap()

}