package br.com.fiap.dsrpt21

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdviceViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val textViewAdvice = view.findViewById<TextView>(R.id.textViewAdvice)

    fun bind(advice: String) {
        textViewAdvice.text = advice
    }
}