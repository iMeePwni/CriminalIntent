package com.imeepwni.android.criminalintent.view.main

import android.support.v4.app.*
import com.imeepwni.android.criminalintent.app.*
import com.imeepwni.android.criminalintent.model.data.*
import java.util.*

class CrimeActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment
            = CrimeFragment.newInstance(intent.extras.getSerializable(Crime.ID) as UUID)
}
