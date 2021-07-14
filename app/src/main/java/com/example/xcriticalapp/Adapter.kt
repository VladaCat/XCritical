package com.example.xcriticalapp
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


public class Adapter(private val exampleList:List<ExampleItem>) : RecyclerView.Adapter<Adapter.ExampleViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycle_view_card,
            parent, false)
        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = exampleList[position]
        holder.imageView.setImageResource(currentItem.imageResource)
        holder.imageView2.setImageResource(currentItem.imageResource)
        holder.textView.text = currentItem.text1
        holder.textView2.text = currentItem.text2
        holder.textView3.text = currentItem.text3
        holder.textView4.text = currentItem.text4
        holder.textView5.text = currentItem.text5
        holder.textView6.text = currentItem.text6
    }

    override fun getItemCount(): Int = exampleList.size

    class ExampleViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val imageView:ImageView = itemView.findViewById(R.id.imageView)
        val imageView2:ImageView = itemView.findViewById(R.id.imageView2)
        val textView:TextView = itemView.findViewById(R.id.textView)
        val textView2:TextView = itemView.findViewById(R.id.textView2)
        val textView3:TextView = itemView.findViewById(R.id.textView3)
        val textView4:TextView = itemView.findViewById(R.id.textView4)
        val textView5:TextView = itemView.findViewById(R.id.textView5)
        val textView6:TextView = itemView.findViewById(R.id.textView6)
    }

}