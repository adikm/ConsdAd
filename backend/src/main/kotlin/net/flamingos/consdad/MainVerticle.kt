package net.flamingos.consdad

import io.vertx.core.*
import io.vertx.core.http.HttpMethod
import io.vertx.core.json.*
import io.vertx.ext.web.*
import io.vertx.ext.web.handler.BodyHandler
import java.util.stream.Collectors
import io.vertx.core.AbstractVerticle
import io.vertx.core.Promise
import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.CorsHandler
import io.vertx.ext.web.handler.StaticHandler
import java.util.HashSet


class MainVerticle : AbstractVerticle() {

  override fun start(startPromise: Promise<Void>) {
    val mongoConnector = MongoConnector(vertx);
    val router = Router.router(vertx)

    router.route().handler(CorsHandler.create("*")
      .allowedMethod(HttpMethod.GET)
      .allowedMethod(HttpMethod.POST)
      .allowedMethod(HttpMethod.PUT)
      .allowedHeader("Content-Type"));

    router.get("/advertisements")
      .handler { routingContext ->
        val adId = routingContext.queryParams().get("id")
        when {
          adId != null -> mongoConnector.get(adId, getOneCallback(routingContext))
          else -> mongoConnector.getAll(getAllCallback(routingContext))
        }
      }

    router.post("/advertisements").handler(BodyHandler.create()).handler { routingContext ->
      val advertisement = jsonObjectToAdvertisement(routingContext.bodyAsJson)
      mongoConnector.save(advertisement, saveCallback(routingContext));
    }

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

  fun getAllCallback(routingContext: RoutingContext): (event: AsyncResult<MutableList<JsonObject>>) -> Unit =
    {
      val ads = it.result().stream().map { jsonObjectToAdvertisement(it) }.collect(Collectors.toList());
      routingContext.response()
        .putHeader("content-type", "application/json; charset=utf-8")
        .end(Json.encodePrettily(ads))
    }

  fun getOneCallback(routingContext: RoutingContext): (event: AsyncResult<JsonObject>) -> Unit =
    {
      routingContext.response()
        .putHeader("content-type", "application/json; charset=utf-8")
        .end(Json.encodePrettily(it.result()))
    }


  fun saveCallback(routingContext: RoutingContext): (event: AsyncResult<String>) -> Unit =
    {
      routingContext.response()
        .putHeader("content-type", "application/json; charset=utf-8")
        .end(it.result())
    }


  private fun jsonObjectToAdvertisement(jsonObject: JsonObject): Advertisement {
    val tags = mutableListOf<String>()
    jsonObject.getJsonArray("tags")?.forEach { tag ->
      tags.add(tag.toString())
    }
    return Advertisement(jsonObject.getJsonObject("_id").getString("\$oid"), jsonObject.getString("title"), "",
      jsonObject.getString("content"), tags)
  }
}
