import java.awt.{Color, Graphics}
import javax.swing.JPanel

case class Base(a:Int, b:Int, c:Int) {
   //Ball Diameter
   final val width = 100
   final val height = 30
   //Ball Speed
   private val speed = 2
   B.x += a
   B.y += b
   var SCREEN_WIDTH = 0
   var SCREEN_HEIGHT= 0

   def draw(g:Graphics): Unit = {
      g.setColor(Color.WHITE)
      g.fillRect(B.x, B.y, width, height)

   }

   //Balls Location and Direction
   object B {
      var x = 0
      var y = 0
      var moveToRight = true
      var moveToDown = true
   }
}
