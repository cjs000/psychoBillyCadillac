package board

import scala.collection.mutable

class Field(xdim: Int, ydim: Int, zdim: Int) {

  val allDirections = Seq("upright", "upleft", "downright", "downleft", "up", "down")

  def makeLine(
    init: Tile,
    dir: String,
    length: Int,
    line: mutable.Map[String, Tile] = mutable.Map.empty[String, Tile]): mutable.Map[String, Tile] = {

    println(line.values)

    if (length <= 0) line
    else {
      val toAdd = dir match {
        case "upright" => Some(init.upright)
        case "upleft" => Some(init.upleft)
        case "downright" => Some(init.downright)
        case "downleft" => Some(init.downleft)
        case "up" => Some(init.up)
        case "down" => Some(init.down)
        case _ => None
      }
      
      if (toAdd.isEmpty) line
      else makeLine(toAdd.get, dir, length - 1, line += (toAdd.get.name -> toAdd.get))
    }
  }
    
  val origin = new Tile(0,0,0)
  
  var boardBag = new mutable.Map(origin.name -> origin)

  for ( var direction <- allDirections ){


  
}
