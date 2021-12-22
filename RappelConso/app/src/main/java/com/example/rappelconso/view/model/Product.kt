package com.example.rappelconso.view.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class Product (
    @SerializedName("id")
    var id: String,

    @SerializedName("date")
    var date: LocalDateTime,

    @SerializedName("family_lvl_1")
    var familyLvl1: String,

    @SerializedName("family_lvl_2")
    var familyLvl2: String,

    @SerializedName("brand_name")
    var brandName: String,

    @SerializedName("reference_name")
    var referenceName: String,

    @SerializedName("reference_id")
    var referenceId: Int,

    @SerializedName("recall_reason")
    var recallReason: String,

    @SerializedName("risks")
    var risks: String,

    @SerializedName("sanity_recommendation")
    var sanityRecommendation: String,

    @SerializedName("behavior_recommendation")
    var behaviorRecommendation: String,

    @SerializedName("phone_number")
    var phoneNumber: String,

    @SerializedName("image_url")
    var imageUrl: String
)