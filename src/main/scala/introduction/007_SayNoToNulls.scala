package introduction

object Main007 extends App {
  case class Foo(a: Int, b: String)

  val seq = Seq(Foo(1, "one"), Foo(2, "two"), Foo(3, "three"))

  seq.find { case Foo(int, string) => int == 4 }.
    fold(println("Not found :("))(f => println("Yay! " + f))

  val potentiallyNull: String = null
  Option(potentiallyNull).map(_ + "!")
}