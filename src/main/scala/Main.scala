import items._
import board._

object Main extends App {

  val pot1 = new HealthPotion(207, 250)
  val pot2 = new HealthPotion(107, 250)

  val origin = new Tile(0,0,0)
  val step1 = origin.upright
  val step2 = step1.up
  val step3 = step2.upright
  

  val mb = new RegHex(5)
  println(" x1z1: " + mb.get("x1z1").onXaxis + " " + mb.get("x1z1").onYaxis + " " + mb.get("x1z1").onZaxis)
  println(" x1z1: coords._1, " + mb.get("x1z1").coords._1 + ", coords._2: " + mb.get("x1z1").coords._2)

  println(" x-2z0: " + mb.get("x-2z0").onXaxis + " " + mb.get("x-2z0").onYaxis + " " + mb.get("x-2z0").onZaxis)
  println(" x-2z0: coords._1, " + mb.get("x-2z0").coords._1 + ", coords._2: " + mb.get("x-2z0").coords._2)

  println(" x-4z0: " + mb.get("x-4z0").onXaxis + " " + mb.get("x-4z0").onYaxis + " " + mb.get("x-4z0").onZaxis)
  println(" x-4z0: coords._1, " + mb.get("x-4z0").coords._1 + ", coords._2: " + mb.get("x-4z0").coords._2)
}
