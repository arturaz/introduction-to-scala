package introduction

/* [qualifier] */ class SoQualified /* [qualifier] */ (
  // Closure based parameter. Compiled into local constructor parameter
  // unless you use it in other methods.
  closured: Int,
  // Public value.
  val publicVal: Int,
  // Public variable.
  var publicVar: Int,
  // Protected value. Accessible from subclasses.
  protected val protectedVal: Int,
  // Private value. Accessible from other instances of SoQualified.
  private val privateVal: Int,
  // Very private value. Accessible from this instance only.
  private[this] val veryPrivateVal: Int,
  // Package private value. Accessible to all classes from given package.
  private[introduction] val packagePrivateVal: Int,
  // The same as above.
  protected[introduction] val packageProtectedVal: Int
) {
  /* [qualifier] */ def print(q: SoQualified): Unit = {
    println(q.privateVal)
//  NOPE:
//    println(q.f)
  }
}

class ExtraQualified(
  // You can shadow values, but it's more likely to reference them accidentally.
  _a: Int, _b: Int, _c: Int, _d: Int, _e: Int, _f: Int, _g: Int, _j: Int
) extends SoQualified(_a, _b, _c, _d, _e, _f, _g, _j) {
  println(protectedVal)

//  NOPE:
//  println(e)
}

object Main004 extends App {
  val q = new SoQualified(1, 2, 3, 4, 5, 6, 7, 8)

//  NOPE:
//  println(q.closured)
  println(q.publicVal)
// Nope:
//  q.publicVal = 100
  println(q.publicVar)
  q.publicVar = 1000
//  NOPE:
//  println(q.protectedVal)
//  println(q.privateVal)
//  println(q.veryPrivateVal)
  println(q.packagePrivateVal)
  println(q.packageProtectedVal)
}