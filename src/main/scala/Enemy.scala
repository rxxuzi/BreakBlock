import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JPanel
import java.awt.Color
import java.awt.Font
import java.awt.FontMetrics

case class Enemy(a:Int , b:Int) extends JPanel{
  E.x += a
  E.x += b

  def draw(g: Graphics): Unit = {
    g.setColor(Color.WHITE)
    g.drawRect(E.x, E.y, E.dx, E.dy)
    g.setColor(Color.CYAN)
    g.fillRect(E.x, E.y, E.dx, E.dy)
  }
  private object E{
    var x = 0
    val y = 0
    val dx = 100
    val dy = 100
  }
}
