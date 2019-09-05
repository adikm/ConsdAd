package net.flamingos.consdad

import io.vertx.core.*

class MainVerticle : AbstractVerticle() {

  override fun start(startPromise: Promise<Void>) {
    vertx
      .createHttpServer()
      .requestHandler { req ->
        run {
          req.response()
            .putHeader("content-type", "text/plain")
            .end("Hello from Vert.x!")
        }
      }
      .listen(8888) { http ->
        if (http.succeeded()) {
          startPromise.complete()
          println("HTTP server started on port 8888")
        } else {
          startPromise.fail(http.cause())
        }
      }
  }
}
