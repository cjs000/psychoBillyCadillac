package board

class Tile(x: Int, y: Int, z: Int) {
  
  val name = ("x"+(x+y)+"z"+(z+y))
  
  override def toString = this.name

  lazy val upright = new Tile(x, y + 1, z)
  lazy val downright = new Tile(x + 1, y, z)
  lazy val upleft = new Tile(x - 1, y, z)
  lazy val downleft = new Tile(x, y - 1, z)
  lazy val up = new Tile(x, y, z + 1)
  lazy val down = new Tile(x, y, z - 1)

  val passable: Boolean = true
}
