package com.imeepwni.android.criminalintent.view.main

import android.os.*
import android.support.v4.app.*
import android.text.*
import android.view.*
import com.imeepwni.android.criminalintent.*
import com.imeepwni.android.criminalintent.model.repository.*
import kotlinx.android.synthetic.main.fragment_crime.*

class CrimeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_crime, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        crime_title.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                CrimeRepository.crime.title = p0.toString()
            }
        })
        crime_date.run {
            text = CrimeRepository.crime.date.toString()
            isEnabled = false
        }
        crime_solved.setOnCheckedChangeListener { _, isChecked ->
            CrimeRepository.crime.isSolved = isChecked
        }
    }

    companion object {
        fun newInstance(): CrimeFragment {
            val fragment = CrimeFragment()
            return fragment
        }
    }
}
