package com.imeepwni.android.criminalintent.model.data

import java.util.*
import java.util.UUID.*


/**
 * Create by guofeng on 2017/6/30.
 */
data class Crime(
        var title: String = "",
        var isSolved: Boolean = false,
        var date: Date = Calendar.getInstance().time
) {
    val id: UUID = randomUUID()

    companion object {
        val ID = "id"
        val TITLE = "title"
        val IS_SOLVED = "isSolved"
        val DATE = "date"
    }

}