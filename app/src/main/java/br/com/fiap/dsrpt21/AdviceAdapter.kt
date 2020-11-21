package br.com.fiap.dsrpt21

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdviceAdapter(private val advices: List<String>): RecyclerView.Adapter<AdviceViewHolder>() {

    private val items = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdviceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return AdviceViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdviceViewHolder, position: Int) {
        val advice = advices[position]
        holder.bind(advice)
    }

    override fun getItemCount(): Int {
        return advices.size
    }

}