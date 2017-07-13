package com.imeepwni.android.criminalintent.model.repository

import com.imeepwni.android.criminalintent.model.data.*
import java.util.*

/**
 * Create by guofeng on 2017/6/30.
 */
object CrimeRepository {

    val crimes = arrayListOf<Crime>()
    var currentCrimeId = 0

    fun getCrime(id: UUID) = crimes.filter { it.id==id }.first()
}