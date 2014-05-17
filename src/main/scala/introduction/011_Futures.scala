package introduction

import concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Try, Failure, Success, Random}

object Main011 extends App {
  def randomFuture = Future {
    if (Random.nextBoolean()) Random.nextInt(100)
    else throw new IllegalStateException("Le Tired")
  }

  def fSeq(
    maxTries: Int, fillSize: Int, idx: Int=0
  ): Future[(Seq[Int], Int)] =
    Future.sequence {
      Seq.fill(fillSize)(randomFuture)
    }.map { seq => (seq, idx) }.recoverWith {
      case ex: IllegalStateException if idx < maxTries =>
        fSeq(maxTries, fillSize, idx + 1)
    }

  fSeq(10000, args(0).toInt).onComplete {
    case Success((values, idx)) =>
      println(s"Succeeded on try $idx with $values")
    case Failure(ex) =>
      println(s"Failed with $ex")
  }
}