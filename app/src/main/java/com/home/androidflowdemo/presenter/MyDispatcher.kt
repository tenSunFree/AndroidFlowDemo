package com.home.androidflowdemo.presenter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.home.androidflowdemo.R
import com.home.androidflowdemo.model.key.HomeKey
import com.home.androidflowdemo.model.key.InvoiceKey
import flow.Dispatcher
import flow.Flow
import flow.Traversal
import flow.TraversalCallback

class MyDispatcher(private val activity: Activity) : Dispatcher {

    override fun dispatch(traversal: Traversal, callback: TraversalCallback) {
        val topKey = traversal.destination.top<Any>()
        val rootViewGroup = activity.findViewById<View>(R.id.frame_layout) as ViewGroup
        // We're already showing something, clean it up.
        if (rootViewGroup.childCount > 0) {
            val currentView = rootViewGroup.getChildAt(0)
            // Save the outgoing view state.
            if (traversal.origin != null)
                traversal.getState(traversal.origin!!.top()).save(currentView)
            // Short circuit if we would just be showing the same view again.
            val currentKey = Flow.getKey<Any>(currentView)
            if (topKey == currentKey) {
                callback.onTraversalCompleted()
                return
            }
            rootViewGroup.removeAllViews()
        }
        @LayoutRes val layout: Int
        layout = when (topKey) {
            is HomeKey -> R.layout.activity_my_home_view_group
            is InvoiceKey -> R.layout.activity_my_invoice_view_group
            else -> throw AssertionError("Unrecognized screen $topKey")
        }
        val view = LayoutInflater.from(traversal.createContext(topKey, activity))
            .inflate(layout, rootViewGroup, false)
        rootViewGroup.addView(view)
        traversal.getState(topKey).restore(view)
        callback.onTraversalCompleted()
    }
}
