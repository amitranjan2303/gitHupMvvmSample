package com.amit.sampleapp.model

import com.google.gson.annotations.SerializedName

data class Label(

    @SerializedName("id")
     var id: Int? = 0,

    @SerializedName("node_id")
     var nodeId: String? = null,

    @SerializedName("url")
     var url: String? = null,

    @SerializedName("name")
     var name: String? = null,

    @SerializedName("color")
     var color: String? = null,

    @SerializedName("default")
     var _default: Boolean? = null,

    @SerializedName("description")
     var description: String? = null
): BaseModel(){
}