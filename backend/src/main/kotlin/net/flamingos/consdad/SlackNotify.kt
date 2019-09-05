package net.flamingos.consdad

import com.squareup.okhttp.MediaType
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import com.squareup.okhttp.RequestBody

class SlackNotify {
  private val client = OkHttpClient()
  private val mediaType = MediaType.parse("application/octet-stream")

  fun notifyNewPost(text: String) {
    client
      .newCall(prepareBody(text))
      .execute()
  }

  private fun prepareBody(text: String): Request {
    val preparedText = text.replace("\"", "\\\"")
    val body = RequestBody.create(mediaType, "{\"text\":\"$preparedText\"}")
    return Request.Builder()
      .url("https://hooks.slack.com/services/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")
      .post(body)
      .addHeader("content-type", "application/json")
      .addHeader("cache-control", "no-cache")
      .addHeader("postman-token", "87c09165-bc15-71b2-cb8a-6535b5d6269b")
      .build()
  }
}
