package com.imeepwni.android.criminalintent.view.main

import android.app.*
import android.os.*
import android.text.*
import android.view.*
import android.widget.*
import com.imeepwni.android.criminalintent.*
import com.imeepwni.android.criminalintent.model.repository.*

class CrimeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_crime, container, false)
        view.run {
            findViewById<EditText>(R.id.crime_title).addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {}

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    CrimeRepository.crime.title = p0.toString()
                }
            })
            findViewById<Button>(R.id.crime_date).run {
                this.text = CrimeRepository.crime.date.toString()
                isEnabled = false
            }
            findViewById<CheckBox>(R.id.crime_solved).setOnCheckedChangeListener { _, isChecked ->
                CrimeRepository.crime.isSolved = isChecked
            }
        }
        return view
    }

    companion object {
        fun newInstance(): CrimeFragment {
            val fragment = CrimeFragment()
            return fragment
        }
    }
}
