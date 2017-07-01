package com.imeepwni.android.criminalintent.model.adapter

import android.content.*
import android.support.design.widget.*
import android.support.v7.widget.*
import android.view.*
import com.imeepwni.android.criminalintent.*
import com.imeepwni.android.criminalintent.model.data.*
import com.imeepwni.android.criminalintent.model.repository.*
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

    override fun onClick(view: View) = Snackbar.make(view, "${(view.tag as Crime).title} clicked", Snackbar.LENGTH_SHORT).show()

    inner class CrimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(crime: Crime) {
            itemView.run {
                tag = crime
                crime_title.text = crime.title
                crime_date.text = crime.date.toString()
                is_solved_image_view.visibility = if (crime.isSolved) View.VISIBLE else View.INVISIBLE
                setOnClickListener(this@CrimeAdapter)
            }
        }
    }
}

