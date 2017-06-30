package com.imeepwni.android.criminalintent.view.main

import android.os.*
import android.support.v7.app.*
import com.imeepwni.android.criminalintent.*

class CrimeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crime)

        fragmentManager.run {
            var fragment = findFragmentById(R.id.container)
            if (fragment == null) {
                fragment = CrimeFragment.newInstance()
                beginTransaction()
                        .add(R.id.container, fragment)
                        .commit()
            }
        }
    }
}
