package introduction

trait Speaker {
  def name: String
  // You can also define it as a stable value.
//  val name: String

  def say(s: String): Unit
  def defaultSay(s: String): Unit = {
    println(s"$name is speaking: $s")
  }
}

class Dog extends Speaker {
  def name = "Barky"
  def say(s: String) = println(s"Woof woof: $s")
}

class Cat extends Speaker {
  val name = "Meowy"
  def say(s: String) = {
    print(s"MEOW MEOW. ")
    defaultSay(s)
  }
}

object Main005 extends App {
  // Check out the inferred return type!
  val speakers = Seq(new Dog, new Cat)
  speakers.foreach(_.say("Hello, folks!"))
}