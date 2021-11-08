package board

class Tile(x: Int, z: Int, y: Int = 0) {
  
  val coords = (x+y, z+y)
  val onXaxis = (coords._2 == 0)
  val onYaxis = (coords._1 == coords._2)
  val onZaxis = (coords._1 == 0)
  val onAnyAxis = (onXaxis || onYaxis || onZaxis)
  private val name = ("x"+coords._1+"z"+coords._2)
  override def toString = this.name

  lazy val upright = new Tile(x + 1, z + 1)
  lazy val downright = new Tile(x + 1, z)
  lazy val upleft = new Tile(x - 1, z)
  lazy val downleft = new Tile(x - 1, z - 1)
  lazy val up = new Tile(x, z + 1)
  lazy val down = new Tile(x, z - 1)

  val passable: Boolean = true
}
