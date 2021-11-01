package com.tyrantlucifer.stream.day01

import akka.Done
import akka.stream.scaladsl.Source

import scala.concurrent.Future

/**
 * 在一个字符串集合中选取长度>=5的前两个值
 */
object Exercise01 extends App {
  private val list = List("tyrantlucifer", "tracy", "leo", "luna", "amy", "grace")
  private val future: Future[Done] = Source(list)
    .filter(_.length >= 5)
    .take(2)
    .runForeach(println)
  future.onComplete(_ => system.terminate())
}
