import java.awt.{Color, Graphics}
import javax.swing.JPanel

case class Base(a:Int, b:Int, c:Int) {
   //Ball Diameter
   private final val width = 100
   private final val height = 30
   //Ball Speed
   private val speed = 2
   B.x += a
   B.y += b
   var SCREEN_WIDTH = 0
   var SCREEN_HEIGHT= 0

   def draw(g:Graphics): Unit = {
      g.setColor(Color.BLUE)
      if(c > 0){
         g.setColor(Color.RED)
         val dy = 200 + c

         g.drawString(B.x + "," + B.y, 300, dy)
      }
      g.fillRect(B.x, B.y, width, height)
      checkCollisionY(SCREEN_HEIGHT)
      checkCollisionX(SCREEN_WIDTH)

   }
   //I want to refer to screenSCREEN_WIDTH in Core.class
   def checkCollisionY(SCREEN_HEIGHT :Int): Unit = {
      if(B.y + height >= SCREEN_HEIGHT) B.moveToDown = false
      if(B.y <= 0) B.moveToDown = true

      if(B.moveToDown) B.y += speed
      else B.y -= speed
   }

   def checkCollisionX(SCREEN_WIDTH :Int): Unit = {
      if(B.x + width >= SCREEN_WIDTH) B.moveToRight = false
      if(B.x <= 0) B.moveToRight = true
      if(B.moveToRight) B.x += speed
      else B.x -= speed
   }

   //Balls Location and Direction
   object B {
      var x = 0
      var y = 0
      var moveToRight = true
      var moveToDown = true
   }
}
