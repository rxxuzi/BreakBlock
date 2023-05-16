import scala.language.postfixOps
import scala.math._
import scala.sys.process._
import java.io.File
object Hello {
   def main(args: Array[String]): Unit = {
      ("echo " + "\"" + "Hello" + "\"") #>> new File("text.txt") !
   }
}

