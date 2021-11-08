package board

import scala.collection.mutable

class RegHex(dim: Int) {

  val allDirections = Seq("upright", "upleft", "downright", "downleft", "up", "down")

  def makeLine(
    init: Tile,
    dir: String,
    length: Int,
    line: mutable.Map[String, Tile] = mutable.Map.empty[String, Tile]): mutable.Map[String, Tile] = {

    //if (init.onAnyAxis && length == dim) println("making a line: " + dir + ", length: " + length + ", from: " + init)
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
      else { //println(" ADDED: " + toAdd.get.toString)
        makeLine(toAdd.get, dir, length - 1, line += (toAdd.get.toString -> toAdd.get))
      }
    }
  }

  val origin = new Tile(0,0,0)
  var boardBag = mutable.Map(origin.toString -> origin)
  
  def get(k: String): Tile = boardBag.get(k).getOrElse(origin)

  //Make a skeleton for our Regular board
  for ( direction <- allDirections ){
    boardBag.addAll(makeLine(origin, direction, dim))
  }

  boardBag.values.foreach ( (bone: Tile) => {
      /*println(bone.toString ) 
      println(": X" ) 
      println(bone.onXaxis ) 
      println(bone.coords._1 < 0 ) 
      println((bone.onXaxis && bone.coords._1 < 0))
      println( " " ) 
      println(bone.toString )
      println(": Y" )
      println(bone.onYaxis )
      println(bone.coords._1 > 0 )
      println(bone.onYaxis && bone.coords._1 > 0)*/
    if (bone.onXaxis && bone.coords._1 < 0) {
      boardBag.addAll(makeLine(bone, "down", dim))
      boardBag.addAll(makeLine(bone, "upright", dim))
    }
    else if (bone.onYaxis && bone.coords._1 > 0) {
      boardBag.addAll(makeLine(bone, "down", dim))
    }
  })

  //println(" " + boardBag.values)
  println(" " + boardBag.size)

  println(" ")
  //val oneone = new Tile(-2, 0)
  val oneone = boardBag.get("x-2z0").getOrElse(new Tile(99,98))
  println(oneone)
  println(oneone.onXaxis)
  println(oneone.coords._1)
  println(oneone.coords._1 < 0)
  println(oneone.onXaxis && oneone.coords._1 < 0)
  println(" ")
  
}
