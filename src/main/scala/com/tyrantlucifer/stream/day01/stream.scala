package com.tyrantlucifer.stream

import akka.actor.ActorSystem

package object day01 {
  implicit val system = ActorSystem("akka-stream")
  implicit val dispatcher = system.dispatcher
}
