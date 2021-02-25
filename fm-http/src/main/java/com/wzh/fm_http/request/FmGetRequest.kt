package com.wzh.fm_http.request

import com.wzh.fm_http.FmHttpRequest
import okhttp3.Request
import java.net.URLEncoder

/**
 * @Description:    GET请求
 * @Author:         Wzh
 * @CreateDate:     2021/2/24 11:43
 */
class FmGetRequest(url: String) : FmHttpRequest<FmGetRequest>(url) {

    override fun createOkHttpRequest(builder: Request.Builder): Request {
        return builder.get().url(createGetUrl(url)).build()
    }

    private fun createGetUrl(url: String): String {
        val sb = StringBuilder()
        sb.append(url)
        if (url.lastIndexOf("?") < 0) {
            sb.append("?")
        } else {
            params.forEach { entry ->
                sb.append("${entry.key}=${URLEncoder.encode(entry.value.toString(), "UTF-8")}")
                    .append("&")
            }
        }
        sb.deleteCharAt(sb.length - 1)
        return sb.toString()
    }
}