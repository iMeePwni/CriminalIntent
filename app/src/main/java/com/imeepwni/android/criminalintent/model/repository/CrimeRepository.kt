package com.imeepwni.android.criminalintent.model.repository

import com.imeepwni.android.criminalintent.model.data.*
import java.util.*

/**
 * Create by guofeng on 2017/6/30.
 */
object CrimeRepository {

    val crimes = initCrimeLab()

    fun initCrimeLab(): ArrayList<Crime> {
        val arrayList = arrayListOf<Crime>()
        (1..100).mapTo(arrayList) { Crime("Crime #$it", it % 2==0) }
        return arrayList
    }

    fun getCrime(id: UUID) = crimes.filter { it.id==id }.first()
}