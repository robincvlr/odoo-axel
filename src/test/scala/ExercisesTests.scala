import org.junit.Test
import org.junit.Assert._
import Exercises._

class ExercisesTests {

  @Test
  def printIntegersTest(): Unit = {
    println(
      s"""
         |
         | EXERCICE 1: PRINT NUMBERS
         |
         |""".stripMargin
    )
    printIntegers()
  }

  @Test
  def guessNumberTest(): Unit = {
    println(
      s"""
         |
         | EXERCICE 2: GUESS NUMBER
         |
         |""".stripMargin
    )
    assertEquals(464, guessNumber(464))
    assertEquals(667, guessNumber(667))
  }

  @Test
  def sumListOfElementsTest(): Unit = {

    println(
      s"""
         |
         | EXERCICE 3: SUM NUMBERS
         |
         |""".stripMargin
    )

    val l1 = List("test", "1", "3", "04", "anti")
    assertEquals(8, sumListOfElements(l1))

    val l2 = List("test")
    assertEquals(0, sumListOfElements(l2))

    val l3 = List()
    assertEquals(0, sumListOfElements(l3))

  }

  @Test
  def sumListOfElementsWithRecursionTest(): Unit = {

    println(
      s"""
         |
         | EXERCICE 4: SUM NUMBERS WITH RECURSION
         |
         |""".stripMargin
    )

    val l1 = List("test", "1", "3", "04", "anti")
    assertEquals(8, sumListOfElementsWithRecursion(0, l1))

    val l2 = List("test")
    assertEquals(0, sumListOfElementsWithRecursion(0, l2))

    val l3 = List()
    assertEquals(0, sumListOfElementsWithRecursion(0, l3))

  }

  @Test
  def matchRegexTest(): Unit = {

    println(
      s"""
         |
         | EXERCICE 8: REGEX
         |
         |""".stripMargin
    )

    val res1 = matchRegex("Odoo is my new #rules without limit")
    println(s"Assertion 1: $res1")
    assertEquals(true, res1)

    val res2 = matchRegex("Bidou is my new #rules without limit")
    println(s"Assertion 2: $res2")
    assertEquals(false, res2)

    val res3 = matchRegex("#rules is my new Odoo without limit")
    println(s"Assertion 3: $res3")
    assertEquals(true, res3)

  }

}
