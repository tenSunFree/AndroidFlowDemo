package com.home.androidflowdemo.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.home.androidflowdemo.R
import com.home.androidflowdemo.model.bean.InvoicesBean
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_my_home_view_group_recycler_view_item.*

class InvoiceRecyclerViewAdapter(
    private val invoices: List<InvoicesBean.Invoice>,
    private val itemClickListener: ItemClickListener
) : RecyclerView.Adapter<InvoiceRecyclerViewAdapter.ViewHolder>() {

    interface ItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_my_home_view_group_recycler_view_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position, invoices[position], itemClickListener)
    }

    override fun getItemCount(): Int {
        return invoices.size
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        @SuppressLint("SetTextI18n")
        fun bind(
            position: Int,
            invoice: InvoicesBean.Invoice,
            itemClickListener: ItemClickListener
        ) {
            text_view_date.text = invoice.date
            text_view_name.text = invoice.name
            text_view_number.text = invoice.number
            text_view_money.text = "＄" + invoice.money
            text_view_virtual_points.text = invoice.virtualPoints
            constraint_layout_root.setOnClickListener {
                itemClickListener.onItemClick(position)
            }
        }
    }
}