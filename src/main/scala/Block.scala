import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JPanel
import java.awt.Color
import java.awt.Font
import java.awt.FontMetrics

case class Block(a:Int, b:Int , c:Int) extends JPanel{
   E.x += a
   E.x += b
   val colors = Array[Color](
      new Color(255, 0, 0),
      new Color(255 , 125 , 0),
      new Color(255 , 255 , 0),
      new Color(125 , 255 , 0),
      new Color(0 , 255 , 0),
      new Color(0 , 255 , 125),
      new Color(0 , 255 , 255),
      new Color(0 , 125 , 255),
      new Color(0 , 0 , 255),
      new Color(125 , 0 , 255),
      new Color(255 , 0 , 255),
      new Color(255 , 0 , 125)
   ) //12 colors
   def draw(g: Graphics): Unit = {
      g.setColor(Color.WHITE)
      g.drawRect(E.x, E.y, E.dx, E.dy)
      g.setColor(colors(c%12))
      g.fillRect(E.x, E.y, E.dx, E.dy)
   }
   def delete(): Unit = {

   }
   object E{
      val y = 0
      val dx = 50
      val dy = 50
      var x = 0
   }
}
