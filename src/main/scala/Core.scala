import com.sun.xml.internal.bind.v2.TODO

import java.awt.event.{MouseEvent, MouseListener, MouseMotionListener}
import java.awt.{Color, Font, Graphics}
import javax.swing.JPanel
import scala.collection.mutable.ArrayBuffer

class Core() extends JPanel {
  //Ball classのList
  final val balls = ArrayBuffer[Ball]()
  //Enemy classのList
  final val enemys =  ArrayBuffer[Enemy]()
  //StartTime
  private final val startTime = System.currentTimeMillis()
  //Ballの半径
  private final val rad = 25
  //clickCount
  private final var clickCount = 1

  private var mx = 300 ;private var my = 300 // マウスの座標
  //SleepTime
  private final val sleepSpeed = 2

  this.setFocusable(true)
  this.setBackground(Color.black)
  this.addMouseListener(new ML())
  this.addMouseMotionListener(new MML())

  balls += Ball(mx, my , 0)
  enemys += Enemy()



  override def paintComponent(g: Graphics): Unit = {
    super.paintComponent(g)
    draw(g)
    val nowTime = System.currentTimeMillis()
    g.setColor(Color.yellow)
    g.setFont(new Font("Serif", Font.BOLD, 20))
    g.drawString((nowTime - startTime) + "ms", 10, 20)
    g.drawString(getWidth + ", " + getHeight, 10, 40)
    g.drawString("Balls :" + (balls.size - 1), 10, 60)


  }

  private def draw(g: Graphics): Unit = {

    g.setColor(Color.white)
    balls(0).B.x = mx
    balls(0).B.y = my

    for (ball <- balls) {
      ball.draw(g)
      ball.width = getWidth
      ball.height = getHeight
    }

    for(enemy <- enemys){
      enemy.draw(g)
    }
    if(clickCount > 2) enemys -= Enemy()
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
      balls += Ball(e.getX - rad, e.getY - rad, clickCount)
      clickCount += e.getClickCount
    }
    override def mousePressed(e: MouseEvent): Unit = {}
    override def mouseReleased(e: MouseEvent): Unit = {}
    override def mouseEntered(e: MouseEvent): Unit = {}
    override def mouseExited(e: MouseEvent): Unit = {}
  }
}
