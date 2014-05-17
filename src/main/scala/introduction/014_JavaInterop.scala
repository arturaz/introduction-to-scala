package introduction

import scala.util.Random
import java.util

class JavaClass {
  def getStr() =
    if (Random.nextBoolean()) null
    else "a string!"

  def getStrList() = {
    val list = new util.ArrayList[String]()
    (1 to Random.nextInt(10)).foreach { _ =>
      list.add(getStr())
    }
    list
  }

  def fromList[A](list: util.List[A]) = {
    val iter = list.iterator()
    while (iter.hasNext) print(" " + iter.next())
    println()
  }
}

object Main014 extends App {
  val klass = new JavaClass
  println(
    Option(klass.getStr()).fold("No String :(")(identity)
  )

  import collection.JavaConverters._
  val mapped = klass.getStrList().asScala.flatMap { s =>
    Option.apply(s)
  }
  println(s"There were ${mapped.size} non null strings!")

  klass.fromList(Seq.fill(10)(Random.nextInt(100)).asJava)
}