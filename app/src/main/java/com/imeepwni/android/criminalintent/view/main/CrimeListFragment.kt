package com.imeepwni.android.criminalintent.view.main

import android.app.*
import android.content.*
import android.os.*
import android.support.v4.app.Fragment
import android.support.v7.widget.*
import android.view.*
import com.imeepwni.android.criminalintent.*
import com.imeepwni.android.criminalintent.model.adapter.*
import com.imeepwni.android.criminalintent.model.data.*
import com.imeepwni.android.criminalintent.model.repository.*
import kotlinx.android.synthetic.main.fragment_crime_list.*

class CrimeListFragment : Fragment(),
        View.OnClickListener {

    companion object {
        fun newInstance(): CrimeListFragment {
            val fragment = CrimeListFragment()
            return fragment
        }
    }

    override fun onClick(view: View) {
        startActivityForResult(Intent(this.activity, CrimePagerActivity::class.java)
                .putExtra(Crime.CRIME_ID, (view.tag as Crime).id),
                1)
        CrimeRepository.currentCrimeId = crime_recycler_view.getChildAdapterPosition(view)
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
            adapter = CrimeAdapter(activity, this@CrimeListFragment)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode!=Activity.RESULT_OK)
            return
        when (requestCode) {
            1 -> {
                crime_recycler_view.adapter.notifyItemChanged(CrimeRepository.currentCrimeId)
            }
        }
    }
}
