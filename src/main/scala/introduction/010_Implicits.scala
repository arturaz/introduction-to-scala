package introduction

import scala.concurrent.Future

object Main010 {
  implicit class StringExts(val str: String)
  extends AnyVal {
    def times(i: Int) = str * i
  }
  println("foo".times(10))


  import language.implicitConversions
  case class Point1(x: Int, y: Int)
  case class Point2(x: Int, y: Int)
  implicit def p2toP1(p2: Point2) = Point1(p2.x, p2.y)
  def needPoint1(p: Point1) = println(p)
  needPoint1(Point2(10, 20))


  // If you want Scala to be more like PHP
  //  implicit def strToInt(s: String) =
  //    Try(s.toInt).getOrElse(0)


  case class Config(so: Int, much: Int, values: Int)

  implicit val config = Config(1, 2, 3)
  def doWithConfig(i: Int)(implicit config: Config) =
    config.much * i + config.so - config.values
  (1 to 10).map(doWithConfig).foreach(println)


  // Used extensively in Scala STDLIB.

  //  def map[S](f: (T) => S)(
  //    implicit executor: ExecutionContext
  //  ): Future[S]
  import concurrent.ExecutionContext.Implicits.global
  Future { 3 }.map(_ * 3).map(_ - 5)
}