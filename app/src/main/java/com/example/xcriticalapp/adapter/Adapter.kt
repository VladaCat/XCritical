package com.example.xcriticalapp.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.xcriticalapp.R


class Adapter(private val exampleList:List<ExampleItem>,
                     private val clickListener: (Int) -> Unit) : RecyclerView.Adapter<Adapter.ExampleViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.recycle_view_card,
            parent, false)
        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = exampleList[position]
        holder.bind(exampleList[position],clickListener)
    }

    override fun getItemCount(): Int = exampleList.size

    class ExampleViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(exampleItem: ExampleItem,clickListener: (Int) -> Unit){
        val textView:TextView = itemView.findViewById(R.id.textView)
        val textView2:TextView = itemView.findViewById(R.id.textView2)
        val textView3:TextView = itemView.findViewById(R.id.textView3)
        val textView4:TextView = itemView.findViewById(R.id.textView4)
        val textView5:TextView = itemView.findViewById(R.id.textView5)
        val textView6:TextView = itemView.findViewById(R.id.textView6)
            itemView.setOnClickListener{clickListener(exampleItem.id)}
        }

    }

}