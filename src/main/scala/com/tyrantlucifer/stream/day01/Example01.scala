package com.tyrantlucifer.stream.day01

import akka.{Done, NotUsed}
import akka.actor.ActorSystem
import akka.stream.scaladsl.{Flow, RunnableGraph, Sink, Source}

import scala.concurrent.{ExecutionContextExecutor, Future}

/**
 * source：生产者
 * sink：消费者
 * flow：数据转换传递者
 * graph：一套完整的stream处理流程
 * source + sink = graph
 * source + flow + sink = graph
 */
object Example01 extends App {

  // 生成source
  val source: Source[Int, NotUsed] = Source(1 to 10)

  // 生成sink
  val sink: Sink[Any, Future[Done]] = Sink.foreach(println)

  // 生成flow
  val flow: Flow[Int, Int, NotUsed] = Flow[Int].map(_ + 1)

  val graph: RunnableGraph[NotUsed] = source.via(flow).to(sink)

  graph.run()

}
