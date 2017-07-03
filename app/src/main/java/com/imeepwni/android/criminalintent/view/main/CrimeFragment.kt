package com.imeepwni.android.criminalintent.view.main

import android.os.*
import android.support.v4.app.*
import android.text.*
import android.view.*
import com.imeepwni.android.criminalintent.*
import com.imeepwni.android.criminalintent.model.data.*
import com.imeepwni.android.criminalintent.model.repository.*
import kotlinx.android.synthetic.main.fragment_crime.*
import java.util.*

class CrimeFragment : Fragment() {

    companion object {
        fun newInstance(crimeId: UUID): CrimeFragment {
            val fragment = CrimeFragment()
            val bundle = Bundle()
            bundle.putSerializable(Crime.CRIME_ID, crimeId)
            fragment.arguments = bundle
            return fragment
        }
    }

    val crime by lazy {
        CrimeRepository.getCrime((arguments.getSerializable(Crime.CRIME_ID) as UUID))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_crime, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        crime_title.setText(crime.title)
        crime_title.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                crime.title = p0.toString()
            }
        })
        crime_date.run {
            text = crime.date.toString()
            isEnabled = false
        }
        crime_solved.isChecked = crime.isSolved
        crime_solved.setOnCheckedChangeListener { _, isChecked ->
            crime.isSolved = isChecked
        }
    }

}
