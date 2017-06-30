package com.imeepwni.android.criminalintent.model.data

import java.util.*
import java.util.UUID.*


/**
 * Create by guofeng on 2017/6/30.
 */
data class Crime(
        var title: String,
        var isSolved: Boolean
) {
    val id: UUID = randomUUID()
    val date: Date = Calendar.getInstance().time
}