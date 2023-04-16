import java.awt.{Color, Graphics}
import javax.swing.JPanel

case class Ball(a:Int , b:Int , c:Color) extends JPanel{
  private val  rad = 50
  B.x = a
  B.y = b
  def draw(g:Graphics): Unit = {
    g.setColor(c)
    g.fillOval(B.x, B.y, rad, rad)
  }

  def calc(x: Int, y: Int): Unit = {

  }

  def move(x: Int, y: Int): Unit ={
    calc(x,y)
  }

  //Balls Location
  object B {
    var x = 200
    var y = 200
    var r = true
    var d = true
  }

}

