package com.home.androidflowdemo.view.viewgroup

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.home.androidflowdemo.model.bean.InvoicesBean
import com.home.androidflowdemo.model.key.HomeKey
import com.home.androidflowdemo.model.key.InvoiceKey
import com.home.androidflowdemo.view.adapter.InvoiceRecyclerViewAdapter
import flow.Flow
import kotlinx.android.synthetic.main.activity_my_invoice_view_group.view.*
import org.jetbrains.anko.toast

class InvoiceViewGroup(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {

    /**
     * 在當前View被附到一個Window上時被調用
     */
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        val key = Flow.getKey<InvoiceKey>(this)
        val invoices = key!!.invoicesBean!!.invoices
        initializeView(invoices)
    }

    private fun initializeView(invoices: List<InvoicesBean.Invoice>) {
        recycler_view.adapter = InvoiceRecyclerViewAdapter(invoices, object :
            InvoiceRecyclerViewAdapter.ItemClickListener {
            override fun onItemClick(position: Int) {
                context.toast(position.toString())
            }
        })
        image_view_previous.setOnClickListener { Flow.get(it).set(HomeKey()) }
    }
}