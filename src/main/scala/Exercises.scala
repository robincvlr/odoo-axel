import scala.annotation.tailrec
import scala.util.{Failure, Random, Success, Try}

object Exercises {

  /**
   * TEST 1:
   *
   * print integers from 1 to 99
   * output conditional
   */
  def printIntegers(): Unit = {
    for(num <- 1 to 99) {
      if (num %3 == 0) {
        if (num %7 == 0) {
          println(s"$num: OpenSource")
        } else {
          println(s"$num: Open")
        }
      } else if (num %7 == 0) {
        println(s"$num: Source")
      } else {
        println(s"$num: ")
      }
    }
  }

  /**
   * TEST 2:
   *
   * Verify function
   *
   * @param guess    Guessed number
   * @param response Response expected
   * @return         Indication code
   */
  def verify(guess: Int,
             response: Int
            ): Int = {
    if (guess == response) {
      0
    }
    else if (guess > response) {
      -1
    }
    else {
      1
    }
  }

  /**
   * TEST 2:
   *
   * Recursive function
   * Guess Number between bounds
   *
   * @param response   response expected
   * @param lowAnchor  low number
   * @param highAnchor high number
   * @param iteration  iteration limitation
   * @return           rand number matched
   */
  @tailrec
  def guessNumber(response: Int,
                  lowAnchor: Int = 1,
                  highAnchor: Int = 1000000,
                  iteration: Int = 50
                 ): Int = {

    if (lowAnchor == highAnchor) {

      lowAnchor

    } else {

      val rand: Int = Random.between(lowAnchor, highAnchor)

      println(s"iteration: $iteration - rand: $rand - bounds: $lowAnchor - $highAnchor")

      val verifyCheck = verify(rand, response)

      if (iteration > 0 || verifyCheck != 0) {
        verifyCheck match {
          case -1 => guessNumber(response, lowAnchor, rand - 1, iteration - 1)
          case 1 => guessNumber(response, rand + 1, highAnchor, iteration - 1)
          case 0 => rand
        }
      } else {
        rand
      }
    }

  }

  /**
   * TEST 3:
   *
   * sum List of element iterative method
   * with for loop
   *
   * Try to cast the element as Integer
   *
   * @param l list of elements
   * @return  sum of elements casted as int
   */
  def sumListOfElements(l: List[String]): Int = {
    var res = 0
    for(elm <- l) {
      Try {
        elm.toInt
      } match {
        case Success(value) => res += value
        case Failure(_) => println(s"$elm can't be casted as integer")
      }
    }
    res
  }

  /**
   * TEST 4:
   *
   * sum List of element iterative method
   * with for recursion
   *
   * Try to cast the element as Integer
   *
   * @param l   list of elements
   * @param res result as integer
   * @return  sum of elements casted as int
   */
  @tailrec
  def sumListOfElementsWithRecursion(res: Int = 0, l: List[String]): Int = {
    if (l.isEmpty) {
      res
    } else {
      Try {
        l.head.toInt
      } match {
        case Success(value) => sumListOfElementsWithRecursion(res + value, l.tail)
        case Failure(_) => sumListOfElementsWithRecursion(res, l.tail)
      }
    }
  }

  /**
   * TEST 8:
   *
   * Regular expressions
   * Write a regular expression to match strings containing both "Odoo" and "#rules" in any order
   */
  def matchRegex(str: String): Boolean = {
    val reg = "(?=.*Odoo)(?=.*#rules).*$".r
    reg.matches(str)
  }

}
