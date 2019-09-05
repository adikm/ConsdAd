package net.flamingos.consdad

import io.vertx.core.Launcher

fun main() {
  Launcher.executeCommand("run", MainVerticle::class.java.name)
}
