import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JPanel
import java.awt.Color
import java.awt.Font
import java.awt.FontMetrics

case class Enemy() extends JPanel{

  def draw(g: Graphics): Unit = {
    g.setColor(Color.CYAN)
    g.drawRect(E.x, E.y, E.d, E.d)
  }

//  //if the enemy is hit, remove it from the game
//  def delete(): Unit = {
//    new Core().enemys() -= this
//  }

  object E{
    val x = 100
    val y = 100
    val d = 100
  }
}
