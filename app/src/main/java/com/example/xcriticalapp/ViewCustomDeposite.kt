package com.example.xcriticalapp

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout

class ViewCustomDeposite(context: Context, attrs: AttributeSet?):ConstraintLayout(context,attrs)  {
   init {
       inflate(context, R.layout.view_custom_deposite, this)
   }
}