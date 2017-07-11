package com.imeepwni.android.criminalintent.view.main

import android.os.*
import android.support.v4.app.*
import android.support.v7.app.*
import com.imeepwni.android.criminalintent.*
import com.imeepwni.android.criminalintent.model.repository.*
import kotlinx.android.synthetic.main.activity_crime_pager.*

class CrimePagerActivity : AppCompatActivity() {

    val crimes by lazy {
        CrimeRepository.crimes
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crime_pager)

        activity_crime_pager_view_pager.adapter = object : FragmentStatePagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                return CrimeFragment.newInstance(crimes[position].id)
            }

            override fun getCount() = crimes.size
        }

        activity_crime_pager_view_pager.currentItem = CrimeRepository.currentCrimeId

        jump_to_first_button.setOnClickListener {
            activity_crime_pager_view_pager.currentItem = 0
        }
        jump_to_last_button.setOnClickListener {
            activity_crime_pager_view_pager.currentItem = crimes.size
        }
    }

}
