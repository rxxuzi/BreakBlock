import com.sun.xml.internal.bind.v2.TODO

import java.awt.event.{MouseEvent, MouseListener, MouseMotionListener}
import java.awt.{Color, Font, Graphics}
import javax.swing.JPanel
import scala.collection.mutable.ArrayBuffer

class Core() extends JPanel {
   //Ball classのList
   private final val balls = ArrayBuffer[Ball]()

   //Base classのList
   private final val Bases = ArrayBuffer[Base]()

   //Enemy classのList
   private final val blocks =  ArrayBuffer[Block]()

   //StartTime
   private final val startTime = System.currentTimeMillis()
   //Ballの半径
   final val radius = 25
   //SleepTime
   private final val sleepSpeed = 2
   var mx = 300
   var my = 300 // マウスの座標
   //clickCount
   private final var clickCount = 1

   private final val NumberOfEnemy = 10


   this.setFocusable(true)
   this.setBackground(Color.black)
   this.addMouseListener(new ML())
   this.addMouseMotionListener(new MML())

   Bases += Base(mx, my , 0)

   for(i <- 0 until  NumberOfEnemy){
      blocks += Block(i*50, 0 , i)
   }

   override def paintComponent(g: Graphics): Unit = {
      super.paintComponent(g)
      draw(g)
      val nowTime = System.currentTimeMillis()
      g.setColor(Color.yellow)
      g.setFont(new Font("Serif", Font.BOLD, 20))
      g.drawString((nowTime - startTime) + "ms", 10, 20)
      g.drawString(getWidth + ", " + getHeight, 10, 40)
      g.drawString("Balls :" + (balls.size ), 10, 60)
      g.drawString("Blocks :" + (blocks.size ), 10, 80)


   }

   private def draw(g: Graphics): Unit = {
      g.setColor(Color.white)
      Bases(0).B.x = mx
      Bases(0).B.y = my
      Bases(0).draw(g)
      for (ball <- balls) {
         ball.draw(g)
         ball.width = getWidth
         ball.height = getHeight
      }
      for (i <- balls.indices) {
         try {
            if (balls(i).B.delete) {
               balls.remove(i)
            }
         }
      }
      if (balls.nonEmpty) {
         deleteBlock()
      }
      ballBounds()
      //ブロックを表示
      for (enemy <- blocks) {
         enemy.draw(g)
      }
      if (clickCount > 2) blocks -= Block(0, 0, 0)
      sleep()
   }

   private def ballBounds(): Unit = {
      for (i <- balls.indices) {
         if (balls(i).B.moveToDown) {
            try {
               if (balls(i).B.y + radius*2 > my  && balls(i).B.y < my + Bases(0).height) {
                  if(balls(i).B.x + radius > mx && balls(i).B.x  < mx + Bases(0).width){
                     //                  balls(i).B.moveToDown = !balls(i).B.moveToDown
                     balls(i).B.moveToDown = false
                  }
               }
            }
         }
      }
   }

   private def deleteBlock(): Unit = {
      for (i <- blocks.indices) {
         for (j <- balls.indices) {
            try {
               if ((balls(j).B.y < (blocks(i).E.y + blocks(i).E.dy)) && (balls(j).B.y > blocks(i).E.y)) {
//                  try{
//                     blocks.remove(i)
//                  }finally{
//
//                  }
                  balls(j).B.moveToDown = true
               }
            }
         }
      }
//      if(balls.size >2){
//         for (i <- blocks.indices) {
//            try{
//               blocks.remove(i)
//            }
//            println(i)
//         }
//      }
      for (i <- blocks.indices) {
//         blocks.remove(i)
         println(i)
      }
   }

   private def sleep(): Unit = {
      Thread.sleep(sleepSpeed)
      repaint()
   }

   //Mouse MotionListener class
   private class MML extends MouseMotionListener {
      override def mouseDragged(e: MouseEvent): Unit = {
         mx = e.getX
         my = e.getY
      }

      override def mouseMoved(e: MouseEvent): Unit = {
         mx = e.getX
         my = e.getY
      }
   }

   //Mouse Listener class
   private class ML() extends MouseListener {
      override def mouseClicked(e: MouseEvent): Unit = {
         println("clicked")
         balls += Ball(e.getX - radius, e.getY - radius, clickCount)
         clickCount += e.getClickCount
      }

      override def mousePressed(e: MouseEvent): Unit = {}

      override def mouseReleased(e: MouseEvent): Unit = {}

      override def mouseEntered(e: MouseEvent): Unit = {}

      override def mouseExited(e: MouseEvent): Unit = {}
   }


}
