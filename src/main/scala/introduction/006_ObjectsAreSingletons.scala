package introduction

trait NumberGiver {
  def gimme: Int
}

object RandomGiver extends NumberGiver {
  def gimme = util.Random.nextInt(100)
}

object StableGiver extends NumberGiver {
  val gimme = 1
}

object Main006 {
  def printGiven(giver: NumberGiver) = println(giver.gimme)

  printGiven(RandomGiver)
  printGiven(StableGiver)

  def printRandom(giver: RandomGiver.type) = println(giver.gimme)
  printRandom(RandomGiver)
// NOPE:
//  printRandom(StableGiver)

  val givers = Seq(RandomGiver, StableGiver)
  givers.foreach(giver => println(giver.gimme))
}