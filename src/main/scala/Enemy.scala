import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JPanel
import java.awt.Color
import java.awt.Font
import java.awt.FontMetrics

case class Enemy() extends JPanel{

  def draw(g: Graphics): Unit = {
    g.setColor(Color.CYAN)
    g.drawRect(100, 100, 100, 100)
  }
  def draw(g: Graphics2D): Unit = {
    g.draw3DRect(100, 100, 10, 10, true)
  }
}
