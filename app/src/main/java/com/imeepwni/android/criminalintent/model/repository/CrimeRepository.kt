package com.imeepwni.android.criminalintent.model.repository

import com.imeepwni.android.criminalintent.model.data.*

/**
 * Create by guofeng on 2017/6/30.
 */
object CrimeRepository {

    val crimes = initCrimeLab()
    var currentCrime = crimes[0]

    fun initCrimeLab(): ArrayList<Crime> {
        val arrayList = arrayListOf<Crime>()
        (1..100).mapTo(arrayList) { Crime("Crime #$it", it % 2==0) }
        return arrayList
    }

    // TODO 获得特定Crime
}