package net.flamingos.consdad;

import io.vertx.core.*
import io.vertx.core.json.*
import io.vertx.ext.mongo.MongoClient
import io.vertx.ext.web.RoutingContext
import java.util.stream.Collectors


class MongoConnector(vertx: Vertx) {

  val mongoconfig = JsonObject()
    .put("connection_string", "mongodb+srv://corkdata:Haslo12345@cluster0-w9o8m.mongodb.net/test?retryWrites=true&w=majority")
    .put("db_name", "corkdata")

  val mongoClient = MongoClient.createShared(vertx, mongoconfig)

  private val COLLECTION = "ads"

  fun getAll(callback: (event: AsyncResult<MutableList<JsonObject>>) -> Unit) {
    mongoClient.find(COLLECTION, JsonObject(), callback)
  }

  fun get(id: String, callback: (AsyncResult<JsonObject> ) -> Unit) {
    mongoClient.findOne(COLLECTION, JsonObject().put("_id", id), null, callback)
  }

  fun save(advertisement: Advertisement, callback: (event: AsyncResult<String>) -> Unit) {
    mongoClient.insert(COLLECTION, advertisementToJsonObject(advertisement), callback)
  }

  private fun advertisementToJsonObject(advertisement: Advertisement) = JsonObject()
    .put("content", advertisement.content)
    .put("title", advertisement.title)
    .put("tags", advertisement.tags)
}
