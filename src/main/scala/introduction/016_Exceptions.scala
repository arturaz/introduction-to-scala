package introduction

import scala.util.Try

object Main016 extends App {
  def badMethod: Int = throw new IllegalArgumentException(
    "What you lookin' at?"
  )

  val result: Int =
    try { badMethod }
    catch {
      case nf: NumberFormatException =>
        println(nf)
        -1 // Catch cases return a value too.
      case ia: IllegalArgumentException =>
        println(ia)
        -2
    }
    finally {
      println("Whew")
    }
  println(result)

  val result2: Try[Int] = Try { badMethod }
  println(result2)

  val result3 = result2.recover {
    case nf: NumberFormatException =>
      println(nf.getMessage)
      -1 // Catch cases return a value too.
    case ia: IllegalArgumentException =>
      println(ia.getMessage)
      -2
  }
  println(result3)
}