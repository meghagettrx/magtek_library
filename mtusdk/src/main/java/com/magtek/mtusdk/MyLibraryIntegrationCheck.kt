package com.magtek.mtusdk

import com.magtek.mobile.android.mtusdk.*

class MyLibraryIntegrationCheck {
    private var mDevice: IDevice? = null

    fun getCoreApiVersion(): Int {
        return CoreAPI.getAPIVersion()
    }
}