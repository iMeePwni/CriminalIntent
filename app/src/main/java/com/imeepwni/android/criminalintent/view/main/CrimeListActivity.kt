package com.imeepwni.android.criminalintent.view.main

import android.support.v4.app.*
import com.imeepwni.android.criminalintent.app.*

class CrimeListActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment = CrimeListFragment.newInstance()
}
