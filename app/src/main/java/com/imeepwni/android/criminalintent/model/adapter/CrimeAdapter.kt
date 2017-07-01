package com.imeepwni.android.criminalintent.model.adapter

import android.content.*
import android.support.design.widget.*
import android.support.v7.widget.*
import android.text.format.*
import android.view.*
import com.imeepwni.android.criminalintent.*
import com.imeepwni.android.criminalintent.model.data.*
import com.imeepwni.android.criminalintent.model.repository.*
import com.imeepwni.android.criminalintent.view.main.*
import kotlinx.android.synthetic.main.list_item_crime.view.*

/**
 * Create by guofeng on 2017/7/1.
 */
class CrimeAdapter(val context: Context)
    : RecyclerView.Adapter<CrimeAdapter.CrimeViewHolder>(),
        View.OnClickListener {

    val VIEW_TYPE_COMMON = 1
    val VIEW_TYPE_DANGEROUS = 2

    override fun onBindViewHolder(holder: CrimeAdapter.CrimeViewHolder, position: Int)
            = holder.bind(CrimeRepository.crimes[position])

    override fun getItemCount(): Int = CrimeRepository.crimes.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int)
            = CrimeViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_crime, parent, false))

    override fun getItemViewType(position: Int) = if (position % 2==0) VIEW_TYPE_COMMON else VIEW_TYPE_DANGEROUS

    override fun onClick(view: View) {
        context.startActivity(Intent(context, CrimeActivity::class.java).putExtra("crimeId", (view.tag as Crime).id))
    }

    inner class CrimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(crime: Crime) {
            itemView.run {
                crime_title.text = crime.title
                crime_date.text = DateFormat.format("EEE, MMM d日, yyyy",crime.date)
                crime_solved.visibility = if (crime.isSolved) View.VISIBLE else View.INVISIBLE
                setOnClickListener(this@CrimeAdapter)
                tag = crime
            }
        }
    }
}

