package com.home.androidflowdemo.view.viewgroup

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.home.androidflowdemo.model.bean.InvoicesBean
import com.home.androidflowdemo.model.key.InvoiceKey
import flow.Flow
import kotlinx.android.synthetic.main.activity_my_home_view_group.view.*

class HomeViewGroup(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {

    /**
     * 代表自定義控件中的子控件映射完成了, 然後可以進行一些初始化控件的操作
     */
    override fun onFinishInflate() {
        super.onFinishInflate()
        val invoicesBean = generateInvoicesBean()
        initializeView(invoicesBean)
    }

    private fun generateInvoicesBean(): InvoicesBean {
        val mutableList: MutableList<InvoicesBean.Invoice> = mutableListOf()
        mutableList.add(
            InvoicesBean.Invoice(
                "飲品", "10/08", "40", "10", "WZ22541156"
            )
        )
        mutableList.add(
            InvoicesBean.Invoice(
                "飲品", "10/22", "40", "10", "WZ21214156"
            )
        )
        mutableList.add(
            InvoicesBean.Invoice(
                "泡菜燒肉", "11/03", "143", "10", "WZ29041156"
            )
        )
        mutableList.add(
            InvoicesBean.Invoice(
                "椒麻雞腿", "11/16", "118", "10", "WY90451156"
            )
        )
        mutableList.add(
            InvoicesBean.Invoice(
                "一口餃", "11/25", "61", "10", "WY92541156"
            )
        )
        return InvoicesBean(mutableList)
    }

    private fun initializeView(invoicesBean: InvoicesBean) {
        view_invoice.setOnClickListener { Flow.get(it).set(InvoiceKey(invoicesBean)) }
    }
}