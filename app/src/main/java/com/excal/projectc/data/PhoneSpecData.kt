package com.excal.projectc.data

data class PhoneSpecData(
    val detailSpec: List<com.excal.projectc.data.DetailSpec>,
    val img: String,
    val name: String,
    val quickSpec: List<QuickSpec>
)