package introduction

object Main008 {
  def matcher(subject: Either[Option[Seq[String]], Either[Int, Float]]) = {
    subject match {
      case Left(Some(Seq(str))) => println(s"Left one str $str")
      case Left(Some(Seq(str1, str2))) => println(s"Left 2 strs $str1 $str2")
      case Left(Some(strs)) => println(s"Left many strs! $strs")
      case Left(None) => println("No strs on left")
      case Right(Left(int)) if int > 5000 => println(s"right BIG int $int")
      case Right(Left(int)) => println(s"right small int $int")
      case Right(Right(float)) => println(s"right float $float")
    }
  }

  object isEven {
    def unapply(i: Int) = if (i % 2 == 0) Some(i) else None
  }
  case class isBig(whatIsBig: Int) {
    def unapply(i: Int) = if (i > whatIsBig) Some(i) else None
  }

  val over9000 = isBig(9000)
  3 match {
    case isEven(over9000(i)) => println(s"OVER 9000 and EVEN! $i")
    case isEven(i) => println(s"Even $i")
    case other => println(s"What is this? $other")
  }
}