import items._
import board._

object Main extends App {

  val pot1 = new HealthPotion(207, 250)
  val pot2 = new HealthPotion(107, 250)

  val origin = new Tile(0,0,0)
  val step1 = origin.upright
  val step2 = step1.up
  val step3 = step2.upright

  val myBoard = new Field(15, 15, 15)
  myBoard.makeLine(origin, "up", 5)

}
