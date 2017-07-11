package com.imeepwni.android.criminalintent.view.main

import android.app.*
import android.content.*
import android.os.*
import android.support.v4.app.DialogFragment
import android.util.*
import android.view.*
import com.imeepwni.android.criminalintent.*
import kotlinx.android.synthetic.main.dialog_date.view.*
import java.util.*

/**
 * Create by guofeng on 2017/7/11.
 */
class DatePickerFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val date = arguments.getSerializable(ARG_DATE) as Date

        val calendar = Calendar.getInstance()
        calendar.time = date

        val v = LayoutInflater.from(activity).inflate(R.layout.dialog_date, null)
        v.dialog_date_picker.init(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH),
                null)

        return AlertDialog.Builder(activity)
                .setTitle(getString(R.string.date_picker_title))
                .setView(v)
                .setPositiveButton(android.R.string.ok) { _, _ ->
                    val date = GregorianCalendar(v.dialog_date_picker.year,
                            v.dialog_date_picker.month,
                            v.dialog_date_picker.dayOfMonth).time
                    sendResult(Activity.RESULT_OK, date)
                }
                .create()
    }

    private fun sendResult(resultCode: Int, date: Date) {
        if (targetFragment==null)
            return
        val intent = Intent()
        intent.putExtra(ARG_DATE, date)
        targetFragment.onActivityResult(targetRequestCode, resultCode, intent)
    }

    companion object {
        val ARG_DATE = "date"

        fun newInstance(date: Date): DatePickerFragment {
            val bundle = Bundle()
            bundle.putSerializable(ARG_DATE, date)

            val datePickerFragment = DatePickerFragment()
            datePickerFragment.arguments = bundle
            return datePickerFragment
        }
    }
}