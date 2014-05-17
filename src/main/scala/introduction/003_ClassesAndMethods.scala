package introduction

//           those are primary constructor params.
//          /
//         \|
class Adder(base: Int) {
  // Secondary constructor. this() must be a first call.
  def this(base: Int, multiplier: Int) = this(base * multiplier)

  // Seq is a generic sequence type with no performance guarantees.
  def this(base: Int, multipliers: Seq[Int]) = this({
    // You can introduce scopes where ever you want.
    val multiplier = multipliers.product
    base * multiplier
  })

  // Everything that goes into class body is a class constructor.
  println(s"Initializing Adder of base $base.")

  // public int add(int num) { return base + num; }
  def add(num: Int) = base + num

  // public int $plus(int num) { return base + num; }
  def +(num: Int) = base + num
}

object Main003 extends App {
  val adder = new Adder(10)
  val adder2 = new Adder(10, 2)
  // Seq default implementation is List - an immutable singly linked list.
  val adder3 = new Adder(10, Seq(3, 1))

  println(adder.add(10))
  println(adder.+(10))

  // Methods can be called without . and ()
  // Which makes it very nice for DSLs.
  println(adder add 10)
  println(adder + 10)
}