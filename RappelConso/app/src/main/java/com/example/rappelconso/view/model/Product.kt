package com.example.rappelconso.view.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class Product (
    @SerializedName("id")
    var id: String,

    @SerializedName("datetime")
    var date: LocalDateTime,

    @SerializedName("family_lvl1")
    var familyLvl1: String,

    @SerializedName("family_lvl2")
    var familyLvl2: String,

    @SerializedName("brand_name")
    var brandName: String,

    @SerializedName("reference_name")
    var referenceName: String,

    @SerializedName("reference_id")
    var referenceId: Int,

    @SerializedName("recall_reason")
    var recallReason: String,

    @SerializedName("recall_criticality")
    var recallCriticality: Int,

    @SerializedName("risks")
    var risks: String,

    @SerializedName("sanity_recommandation")
    var sanityRecommendation: String,

    @SerializedName("behavior_recommandation")
    var behaviorRecommendation: String,

    @SerializedName("phone_number")
    var phoneNumber: String,

    @SerializedName("image_url")
    var imageUrl: String
)