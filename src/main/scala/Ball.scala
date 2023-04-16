import java.awt.{Color, Graphics}
import javax.swing.JPanel

case class Ball(a:Int , b:Int , c:Color) extends JPanel{
  private val  rad = 50
  Info.x = a
  Info.y = b
  def draw(g:Graphics): Unit = {
    g.setColor(c)
    g.fillOval(Info.x, Info.y, rad, rad)
  }

  //Balls Location
  object Info {
    var x = 200
    var y = 200
    var r = true
    var d = true
  }

}

