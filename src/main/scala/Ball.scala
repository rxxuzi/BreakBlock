
import java.awt.{Color, Graphics}
import javax.swing.JPanel

case class Ball(a:Int, b:Int, c:Int) {
  //ボールの大きさ(直径)
  private val diameter = new Core().radius * 2
  //ボールが動く速さ
  private val speed = 2
  B.x += a
  B.y += b
  var width = 0
  var height= 0

  def draw(g:Graphics): Unit = {
    g.setColor(Color.BLUE)
    if(c > 0){
      g.setColor(Color.RED)
      val dy = 200 + c

      g.drawString(B.x + "," + B.y, 300, dy)
    }
    g.fillOval(B.x, B.y, diameter, diameter)
    checkCollisionY(height)
    checkCollisionX(width)
//    checkTouching()
  }

  //I want to refer to screenWidth in Core.class
  def checkCollisionY(height :Int): Unit = {
    if(B.y + diameter >= height) {
      B.moveToDown = false
    }
    if(B.y <= 0) {
      B.moveToDown = true
    }
    if(B.moveToDown) B.y += speed
    else B.y -= speed
  }

  def checkCollisionX(width :Int): Unit = {
    if(B.x + diameter >= width) B.moveToRight = false
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
    var delete = false
  }
}

