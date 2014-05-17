package introduction

import scala.util.Random

object Main012 extends App {
  def rSeq(size: Int) = Seq.fill(size)(Random.nextInt(10))

  val out =
    rSeq(10).flatMap(rSeq).filter(_ < 5).flatMap { i =>
      (rSeq(i) ++ rSeq(i)).map { i2 =>
        i2 * Random.nextInt(3)
      }.filter { _ < 100 }
    }.map(_ + 3)

  val out2 = for {
    a <- for {
      i <- rSeq (10) if i < 5
      i2 <- rSeq(i) ++ rSeq(i)
    } yield i2 * Random.nextInt(3) if a < 100
  } yield a + 3

  println(out)
  println(out2)
}