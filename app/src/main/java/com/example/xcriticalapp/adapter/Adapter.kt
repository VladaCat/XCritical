package com.example.xcriticalapp.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.xcriticalapp.R
import java.util.*
import kotlin.collections.ArrayList


class Adapter(private val cardList:ArrayList<CardItemWithImage>,
              private val clickListener: (Int) -> Unit) : RecyclerView.Adapter<Adapter.ExampleViewHolder>(), Filterable{

    var filterList = ArrayList<CardItemWithImage>()

    init {
        filterList = cardList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.recycle_view_card,
            parent, false)
        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = cardList[position]
       // holder.bind(cardList[position],clickListener)
        holder.itemView.setOnClickListener{clickListener(currentItem.id)}
        holder.companyTextView.text = currentItem.nameOfCompany
        holder.productTextView.text = currentItem.nameOfProduct
        holder.firstNumberTextView.text = currentItem.firstNumber
        holder.delimiterTextView.text = currentItem.delimiter
        holder.secondNumberTextView.text = currentItem.secondNumber
        holder.percentTextView.text = currentItem.percent
        holder.companyImage.setImageResource(currentItem.companyImage)
        holder.starImage.setImageResource(currentItem.starImage)
    }

    override fun getItemCount(): Int = cardList.size

    class ExampleViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val companyTextView:TextView = itemView.findViewById(R.id.companyText)
        val productTextView:TextView = itemView.findViewById(R.id.productText)
        val firstNumberTextView:TextView = itemView.findViewById(R.id.firstNumberText)
        val delimiterTextView:TextView = itemView.findViewById(R.id.delimiterText)
        val secondNumberTextView:TextView = itemView.findViewById(R.id.secondNumberText)
        val percentTextView:TextView = itemView.findViewById(R.id.percentText)
        val companyImage:ImageView=itemView.findViewById(R.id.company_imageView)
        val starImage:ImageView=itemView.findViewById(R.id.star_imageView)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    filterList = cardList
                } else {
                    val resultList = ArrayList<CardItemWithImage>()
                    for (row in cardList) {
                        if (row.nameOfCompany.lowercase(Locale.ROOT).contains(charSearch.lowercase(Locale.ROOT))) {
                            resultList.add(row)
                        }
                    }
                    filterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = filterList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filterList = results?.values as ArrayList<CardItemWithImage>
                notifyDataSetChanged()
            }

        }
    }
}