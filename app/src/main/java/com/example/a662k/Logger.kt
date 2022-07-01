package com.example.a662k

import android.util.Log


/**
 * Created by Eldor Turgunov on 01.07.2022.
 * 6.6.2k
 * eldorturgunov777@gmail.com
 */
class Logger {
    companion object {
        fun d(tag: String, msg: String) {
            if (VolleyHttp.IS_TESTER) Log.d(tag, msg)
        }

        fun i(tag: String, msg: String) {
            if (VolleyHttp.IS_TESTER) Log.i(tag, msg)
        }

        fun v(tag: String, msg: String) {
            if (VolleyHttp.IS_TESTER) Log.v(tag, msg)
        }

        fun e(tag: String, msg: String) {
            if (VolleyHttp.IS_TESTER) Log.e(tag, msg)
        }
    }
}