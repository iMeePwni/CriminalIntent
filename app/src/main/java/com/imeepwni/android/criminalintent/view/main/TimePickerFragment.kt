package com.imeepwni.android.criminalintent.view.main

import android.app.*
import android.content.*
import android.os.*
import android.support.v4.app.DialogFragment
import android.util.*
import android.view.*
import com.imeepwni.android.criminalintent.*
import kotlinx.android.synthetic.main.dialog_time.view.*
import java.util.*

/**
 * Create by guofeng on 2017/7/11.
 */
class TimePickerFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val v = LayoutInflater.from(activity).inflate(R.layout.dialog_time, null)
        val date = arguments.getSerializable(ARG_TIME) as Date
        val calendar = Calendar.getInstance()
        calendar.time = date
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        v.dialog_time_picker.run {
            currentHour = hour
            currentMinute = minute
        }
        return AlertDialog.Builder(activity)
                .setTitle(getString(R.string.time_picker_title))
                .setView(v)
                .setPositiveButton(android.R.string.ok) { _, _ ->
                    val date = GregorianCalendar(calendar.get(Calendar.YEAR),
                            calendar.get(Calendar.MONTH),
                            calendar.get(Calendar.DAY_OF_MONTH),
                            v.dialog_time_picker.currentHour,
                            v.dialog_time_picker.currentMinute).time
                    Log.d(javaClass.simpleName, date.toString())
                    sendResult(Activity.RESULT_OK, date)
                }
                .create()
    }

    private fun sendResult(resultCode: Int, date: Date) {
        if (targetFragment==null)
            return
        val intent = Intent()
        intent.putExtra(DatePickerFragment.ARG_DATE, date)
        targetFragment.onActivityResult(targetRequestCode, resultCode, intent)
    }

    companion object {
        val ARG_TIME = "time"

        fun newInstance(date: Date): TimePickerFragment {
            val bundle = Bundle()
            bundle.putSerializable(ARG_TIME, date)
            val timePickerFragment = TimePickerFragment()
            timePickerFragment.arguments = bundle
            return timePickerFragment
        }
    }
}