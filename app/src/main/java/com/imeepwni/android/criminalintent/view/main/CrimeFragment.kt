package com.imeepwni.android.criminalintent.view.main

import android.app.*
import android.content.*
import android.os.*
import android.support.v4.app.Fragment
import android.text.*
import android.view.*
import com.imeepwni.android.criminalintent.*
import com.imeepwni.android.criminalintent.model.data.*
import com.imeepwni.android.criminalintent.model.repository.*
import kotlinx.android.synthetic.main.fragment_crime.*
import java.util.*

class CrimeFragment : Fragment() {

    companion object {
        val DIALOG_DATE = "DialogDate"
        val DIALOG_TIME = "DialogTime"
        val REQUEST_DATE = 0

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
        crime_title.run {
            setText(crime.title)
            addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {}

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    crime.title = p0.toString()
                    activity.setResult(Activity.RESULT_OK)
                }
            })
        }
        crime_date.run {
            updateDate(crime.date)
            setOnClickListener {
                val datePickerFragment = DatePickerFragment.newInstance(crime.date)
                datePickerFragment.setTargetFragment(this@CrimeFragment, REQUEST_DATE)
                datePickerFragment.show(fragmentManager, DIALOG_DATE)
            }
        }
        crime_time.run {
            setOnClickListener {
                val timePickerFragment = TimePickerFragment.newInstance(crime.date)
                timePickerFragment.setTargetFragment(this@CrimeFragment, REQUEST_DATE)
                timePickerFragment.show(fragmentManager, DIALOG_TIME)
            }
        }
        crime_solved.run {
            isChecked = crime.isSolved
            setOnCheckedChangeListener { _, isChecked ->
                crime.isSolved = isChecked
                activity.setResult(Activity.RESULT_OK)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (resultCode!=Activity.RESULT_OK)
            return
        when (requestCode) {
            REQUEST_DATE -> {
                val date = data.getSerializableExtra(DatePickerFragment.ARG_DATE) as Date
                crime.date = date
                updateDate(date)
                activity.setResult(Activity.RESULT_OK)
            }
        }
    }

    /**
     * 提取公用方法联系快捷键option + command + M
     */
    private fun updateDate(date: Date) {
        crime_date.text = date.toString()
    }
}
