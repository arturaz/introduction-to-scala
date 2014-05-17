package introduction

// Singleton object. Can treat as a static class.
object FullHelloWorld {
  // public void main(String[] args) {
  //
  // Deprecated:
  //   def main(args: Array[String]) {
  //
  // Unit is a type! It has one instance: ().
  // It is compiled to void though.
  def main(args: Array[String]): Unit = {
    println(s"Hello World! You passed: $args")
  }
}