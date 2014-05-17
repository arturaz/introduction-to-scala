package introduction

object Main015 extends App {
  val seq = Seq.tabulate(3)(identity)

  println(seq.map(_ * 3))
  println(seq.map(i => Seq(i, i * 2, i * 3)))
  println(seq.map(i => Seq(i, i * 2, i * 3)).flatten)
  println(seq.flatMap(i => Seq(i, i * 2, i * 3)))

  println(seq.reduce(_ + _))
  println(seq.reduce(_ - _))
  println(seq.reduceLeft(_ - _))
  println(seq.reduceRight(_ - _))

  println(seq.fold(-100)(_ + _))
  println(seq.foldLeft(-100)(_ + _))
  println(seq.foldLeft(Map.empty[Int, String]) {
    case (map, int) => map updated (int, int.toString)
  })

  seq.zip(seq.reverse).foreach(println)
  seq.reverse.zipWithIndex.foreach(println)
  seq.sliding(2).foreach(println)
  seq.zipAll(Seq(1, 2, 3), -1, -1).foreach(println)

  seq.grouped(3).foreach(println)
  seq.groupBy(_ % 2 == 0).foreach(println)

  seq.permutations.foreach(println)
  seq.combinations(2).foreach(println)
}