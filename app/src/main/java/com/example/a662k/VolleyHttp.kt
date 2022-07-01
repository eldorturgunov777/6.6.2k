package com.example.a662k

import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import org.json.JSONObject


/**
 * Created by Eldor Turgunov on 01.07.2022.
 * 6.6.2k
 * eldorturgunov777@gmail.com
 */
class VolleyHttp {

    companion object {
        val TAG = VolleyHttp::class.java.simpleName
        val IS_TESTER = true
        val SERVER_DEVELOPMENT = "https://dummy.restapiexample.com/api/v1/"
        val SERVER_PRODUCTION = "https://dummy.restapiexample.com/api/v1/"

        fun server(url: String): String {
            if (IS_TESTER)
                return SERVER_DEVELOPMENT + url
            return SERVER_PRODUCTION + url
        }

        fun headers(): HashMap<String, String> {
            val headers = HashMap<String, String>()
            headers["Content-type"] = "application/json; charset=UTF-8"
            return headers
        }

        fun get(api: String, params: HashMap<String, String>, volleyHandler: VolleyHandler) {
            val stringRequest = object : StringRequest(Method.GET, server(api),
                Response.Listener { response ->
                    Logger.d(TAG, response)
                    volleyHandler.onSuccess(response)
                },
                Response.ErrorListener { error ->
                    Logger.d(TAG, error.toString())
                    volleyHandler.onError(error.toString())
                }) {
                override fun getParams(): MutableMap<String, String> {
                    return params
                }
            }
            App.instance!!.addToRequestQueue(stringRequest)
        }

        fun post(api: String, body: HashMap<String, Any>, volleyHandler: VolleyHandler) {
            val stringRequest = object : StringRequest(Method.POST, server(api),
                Response.Listener { response ->
                    Logger.d(TAG, response)
                    volleyHandler.onSuccess(response)
                },
                Response.ErrorListener { error ->
                    Logger.d(TAG, error.toString())
                    volleyHandler.onError(error.toString())
                }) {
                override fun getHeaders(): MutableMap<String, String> {
                    return headers()
                }

                override fun getBody(): ByteArray {
                    return JSONObject(body as Map<*, *>).toString().toByteArray()
                }
            }
            App.instance!!.addToRequestQueue(stringRequest)
        }

        fun put(api: String, body: HashMap<String, Any>, volleyHandler: VolleyHandler) {
            val stringRequest = object : StringRequest(Method.PUT, server(api),
                Response.Listener { response ->
                    Logger.d(TAG, response)
                    volleyHandler.onSuccess(response)
                },
                Response.ErrorListener { error ->
                    Logger.d(TAG, error.toString())
                    volleyHandler.onError(error.toString())
                }) {
                override fun getHeaders(): MutableMap<String, String> {
                    return headers()
                }

                override fun getBody(): ByteArray {
                    return JSONObject(body as Map<*, *>).toString().toByteArray()
                }
            }
            App.instance!!.addToRequestQueue(stringRequest)
        }

        fun del(url: String, volleyHandler: VolleyHandler) {
            val stringRequest = object : StringRequest(Method.DELETE, server(url),
                Response.Listener { response ->
                    Logger.d(TAG, response)
                    volleyHandler.onSuccess(response)
                },
                Response.ErrorListener { error ->
                    Logger.d(TAG, error.toString())
                    volleyHandler.onError(error.toString())
                }) {
            }
            App.instance!!.addToRequestQueue(stringRequest)
        }

        var API_LIST_POST = "employees"
        var API_CREATE_POST = "create"
        var API_UPDATE_POST = "update/"
        var API_DELETE_POST = "delete/"

        fun paramsEmpty(): HashMap<String, String> {
            return HashMap<String, String>()
        }

        fun paramsCreate(poster: Poster): HashMap<String, Any> {
            val params = HashMap<String, Any>()
            params.put("employee_name", poster.employee_name!!)
            params.put("employee_salary", poster.employee_salary!!)
            params.put("employee_age", poster.employee_age)
            params.put("profile_image", poster.profile_image)
            return params
        }

        fun paramsUpdate(poster: Poster): HashMap<String, Any> {
            val params = HashMap<String, Any>()
            params.put("id", poster.id)
            params.put("employee_name", poster.employee_name!!)
            params.put("employee_salary", poster.employee_salary!!)
            params.put("employee_age", poster.employee_age)
            params.put("profile_image", poster.profile_image)
            return params

        }
    }
}