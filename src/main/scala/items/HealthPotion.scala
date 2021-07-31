package items

class HealthPotion(health: Int, maxHealth: Int) {
  
  var color = "violet"
  
  def effect(curr: Int, max: Int): Int = {
    val proposed = curr + 80
    if (proposed > max) max else proposed
  }

  println( " Your health is now: " + effect(health, maxHealth) )
}
