package com.imeepwni.android.criminalintent.model.adapter

import android.content.*
import android.support.design.widget.*
import android.support.v7.widget.*
import android.view.*
import android.widget.*
import com.imeepwni.android.criminalintent.*
import com.imeepwni.android.criminalintent.model.data.*
import com.imeepwni.android.criminalintent.model.repository.*

/**
 * Create by guofeng on 2017/7/1.
 */
class CrimeAdapter(val context: Context)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(),
        View.OnClickListener {

    val VIEW_TYPE_COMMON = 1
    val VIEW_TYPE_DANGEROUS = 2

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        when (holder) {
            is CrimeViewHolder -> holder.bind(CrimeRepository.crimes[position])
        }
    }

    override fun getItemCount(): Int = CrimeRepository.crimes.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {

        fun createView(resId: Int) = LayoutInflater.from(context).inflate(resId, parent, false)

        return when (viewType) {
            VIEW_TYPE_COMMON -> CrimeViewHolder(createView(R.layout.list_item_crime))
            VIEW_TYPE_DANGEROUS -> DangerousCrimeViewHolder(createView(R.layout.list_item_dangerous_crime))
            else -> CrimeViewHolder(createView(R.layout.list_item_crime))
        }
    }

    override fun getItemViewType(position: Int) = if (position % 2==0) VIEW_TYPE_COMMON else VIEW_TYPE_DANGEROUS

    override fun onClick(view: View) {
        if (view.id==R.id.call_police_button)
            Snackbar.make(view, "${((view.parent as View).tag as Crime).title} 我已经报警了！！！", Snackbar.LENGTH_SHORT).show()
        else
            Snackbar.make(view, "${(view.tag as Crime).title} clicked", Snackbar.LENGTH_SHORT).show()
    }

    open inner class CrimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var crimeTitle: TextView
        lateinit var crimeDate: TextView

        init {
            itemView.run {
                crimeTitle = findViewById(R.id.crime_title)
                crimeDate = itemView.findViewById(R.id.crime_date)
                setOnClickListener(this@CrimeAdapter)
            }
        }

        open fun bind(crime: Crime) {
            itemView.tag = crime
            crimeTitle.text = crime.title
            crimeDate.text = crime.date.toString()
        }
    }

    private inner class DangerousCrimeViewHolder(itemView: View) : CrimeViewHolder(itemView = itemView) {
        var callPolice: Button = itemView.findViewById(R.id.call_police_button)

        override fun bind(crime: Crime) {
            super.bind(crime)
            callPolice.setOnClickListener(this@CrimeAdapter)
        }
    }

}

