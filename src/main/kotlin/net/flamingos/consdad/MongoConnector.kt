package net.flamingos.consdad;

import io.vertx.core.AbstractVerticle
import io.vertx.core.json.JsonObject
import io.vertx.ext.mongo.MongoClient


object MongoConnector : AbstractVerticle() {

  val mongoconfig = JsonObject()
    .put("connection_string", "mongodb+srv://corkdata:Haslo12345@cluster0-w9o8m.mongodb.net/test?retryWrites=true&w=majority")
    .put("db_name", "corkdata")

  val mongoClient = MongoClient.createShared(vertx, mongoconfig)

}
