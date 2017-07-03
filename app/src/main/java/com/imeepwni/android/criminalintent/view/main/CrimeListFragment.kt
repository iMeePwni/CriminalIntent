package com.imeepwni.android.criminalintent.view.main

import android.os.*
import android.support.v4.app.*
import android.support.v7.widget.*
import android.view.*
import com.imeepwni.android.criminalintent.*
import com.imeepwni.android.criminalintent.model.adapter.*
import kotlinx.android.synthetic.main.fragment_crime_list.*

class CrimeListFragment : Fragment() {

    companion object {
        fun newInstance(): CrimeListFragment {
            val fragment = CrimeListFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_crime_list, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        crime_recycler_view.run {
            layoutManager = LinearLayoutManager(activity)
            adapter = CrimeAdapter(activity)
        }
    }

    override fun onResume() {
        super.onResume()
        crime_recycler_view.adapter.notifyDataSetChanged()
    }
}
