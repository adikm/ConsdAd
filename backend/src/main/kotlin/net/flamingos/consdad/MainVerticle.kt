package net.flamingos.consdad

import io.vertx.core.AbstractVerticle
import io.vertx.core.Promise
import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.StaticHandler

class MainVerticle : AbstractVerticle() {

  override fun start(startPromise: Promise<Void>) {

    val router = Router.router(vertx)
    router.route().handler(StaticHandler.create())

    vertx
      .createHttpServer()
      .requestHandler(router::accept)
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
