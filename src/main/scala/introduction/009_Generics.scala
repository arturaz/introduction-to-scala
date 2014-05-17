package introduction

class Invariant[A]
class Covariant[+A]
class Contravariant[-A]

class Method[A] {
  def method[B](a: A)(f: A => B) = f(a)
  def restrictedMethod[B <: A](b: B) = b
  def restrictedMethod2[B >: A](b: B) = b

  def typeclassMethod[B : Numeric](b: B) = implicitly[Numeric[B]].times(b, b)
  def typeclassMethod2[B](b: B)(implicit n: Numeric[B]) = n.times(b, b)
  def typeclassMethod3[B](b: B)(implicit n: Numeric[B]) = {
    import n._
    b * b
  }

  def restrictedMethod(a: A)(implicit evidence: A =:= Int) = a * 3
  def restrictedMethod(a: A)(implicit evidence: A <:< Int) = a * 3
}

object Main009 {
  List(1, 2, 3).sum
  // List("1", "2", "3").sum <-- does not compile
}