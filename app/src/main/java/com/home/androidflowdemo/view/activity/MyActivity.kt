package com.home.androidflowdemo.view.activity

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.home.androidflowdemo.R
import com.home.androidflowdemo.model.key.HomeKey
import com.home.androidflowdemo.model.keyparceler.MyKeyParceler
import com.home.androidflowdemo.presenter.MyDispatcher
import flow.Flow

open class MyActivity : AppCompatActivity() {

    override fun attachBaseContext(baseContext: Context) {
        val flowContext = initializeFlowContext(baseContext)
        super.attachBaseContext(flowContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        blackFontMode()
        setContentView(R.layout.activity_my)
    }

    private fun initializeFlowContext(baseContext: Context): Context {
        return Flow.configure(baseContext, this) // 創建Installer對象
            .dispatcher(MyDispatcher(this))
            .defaultKey(HomeKey()) // 設置後堆棧開始的密鑰
            .keyParceler(MyKeyParceler())
            .install()
    }

    /**
     * 亮色狀態欄黑色字體模式
     */
    private fun blackFontMode() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }

    override fun onBackPressed() {
        if (!Flow.get(this).goBack()) super.onBackPressed()
    }
}
