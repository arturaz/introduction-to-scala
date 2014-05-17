package introduction

object Main013 extends App {
  val Debug = ! args.lift(0).exists(_ == "0")

  // call by name parameter
  def debug(msg: => String) =
    if (Debug) println(msg)

  def slowMsg(msg: String) = {
    Thread.sleep(1000)
    msg
  }

  lazy val verySlowMsg =
    slowMsg("1") + slowMsg("2") + slowMsg("3")

  println("Fast 1")
  debug(slowMsg("Slow 1"))
  println("Fast 2")
  debug(slowMsg("Slow 2"))
  println("Fast 3")
  debug(verySlowMsg)
  println("Fast 4")

  def doTimes(times: Int)(f: => Unit) {
    (0 until times).foreach(_ => f)
  }

  doTimes(3) { println("I'm ALIVE!") }
}
