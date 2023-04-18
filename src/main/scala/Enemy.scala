import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JPanel
import java.awt.Color
import java.awt.Font
import java.awt.FontMetrics

case class Enemy() extends JPanel{

  def draw(g: Graphics): Unit = {
    g.setColor(Color.CYAN)
    g.fillRect(E.x, E.y, E.dx, E.dy)
  }
  object E{
    val x = 100
    val y = 100
    val dx = 100
    val dy = 100
  }
}
