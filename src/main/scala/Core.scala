import com.sun.xml.internal.bind.v2.TODO

import java.awt.event.{MouseEvent, MouseListener, MouseMotionListener}
import java.awt.{Color, Font, Graphics}
import javax.swing.JPanel
import scala.collection.mutable.ArrayBuffer

case class Core() extends JPanel {
  //Ball classのList
  private final val balls = ArrayBuffer[Ball]()
  //Enemy classのList
  private final val enemy =  ArrayBuffer[Enemy]()
  //StartTime
  private final val startTime = System.currentTimeMillis()
  val rad = 25
  private var mx = 300 ;private var my = 300 // マウスの座標
  private final val sleepSpeed = 2
  this.setFocusable(true)
  this.setBackground(Color.black)
  this.addMouseListener(new ML())
  this.addMouseMotionListener(new MML())

  balls += Ball(mx, my , Color.white)
  enemy += Enemy()

  override def paintComponent(g: Graphics): Unit = {
    super.paintComponent(g)
    draw(g)
    val nowTime = System.currentTimeMillis()
    g.setColor(Color.yellow)
    g.setFont(new Font("Serif", Font.BOLD, 20))
    g.drawString((nowTime - startTime) + "ms", 10, 20)


  }

  private def draw(g: Graphics): Unit = {

    g.setColor(Color.white)
    balls(0).B.x = mx
    balls(0).B.y = my

    enemy(0).draw(g)

    //draw all balls
    for (ball <- balls) {
      ball.draw(g)
    }
    sleep()
  }

  private def sleep(): Unit = {
    Thread.sleep(sleepSpeed)
    repaint()
  }

  //Mouse MotionListener class
  private class MML extends  MouseMotionListener {
    override def mouseDragged(e: MouseEvent): Unit = {
      mx = e.getX - rad
      my = e.getY - rad
    }
    override def mouseMoved(e: MouseEvent): Unit = {
      mx = e.getX - rad
      my = e.getY - rad
    }
  }

  //Mouse Listener class
  private class ML() extends MouseListener{
    override def mouseClicked(e: MouseEvent): Unit = {
      println("clicked")
      balls += Ball(e.getX - rad, e.getY - rad, Color.ORANGE)
    }
    override def mousePressed(e: MouseEvent): Unit = {}
    override def mouseReleased(e: MouseEvent): Unit = {}
    override def mouseEntered(e: MouseEvent): Unit = {}
    override def mouseExited(e: MouseEvent): Unit = {}
  }
}
