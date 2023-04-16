class Vector(x: Double, y: Double, z: Double) {
  private var vx = 0d
  private var vy = 0d
  private var vz = 0d
  private val length = Math.sqrt(x * x + y * y + z * z)
  if(length > 0 ){
    vx = x / length
    vy = y / length
    vz = z / length
  }
  def crossProduct(v: Vector): Vector = {
    new Vector(vy * v.vz - vz * v.vy, vz * v.vx - vx * v.vz, vx * v.vy - vy * v.vx)
  }

  def dotProduct(v: Vector): Double = {
    vx * v.vx + vy * v.vy + vz * v.vz
  }

}

