package com.imeepwni.android.criminalintent.view.main


import android.os.*
import android.support.v4.app.*
import android.view.*
import com.imeepwni.android.criminalintent.*

class CrimeListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_crime_list, container, false)
    }

    companion object {

        fun newInstance(): CrimeListFragment {
            val fragment = CrimeListFragment()
            return fragment
        }
    }

}
