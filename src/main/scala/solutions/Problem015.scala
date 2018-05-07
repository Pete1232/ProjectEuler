package solutions

object Problem015 extends App {

  // Let p_m_n be the total number of paths for a rectangle m long and n high. Then for all m,n>=0:
  // p_m_n = p_m-1_n + p_m_n-1
  // p_m_n = p_n_m
  // p_0,n = p_m,0 = 1

  var cache = scala.collection.mutable.Map.empty[String, Long]

  def paths(m: Long, n: Long): Long = {

    cache.getOrElse(s"$m,$n",
      {
        val res: Long = if (m > 0 && n > 0) {
          paths(m - 1, n) + paths(m, n - 1)
        } else {
          1
        }
        cache += ((s"$m,$n", res))
        res
      }
    )
  }

  def paths(n: Long): Long = paths(n, n)

  for (i <- 1 to 20) {
    // important to go from 1 up to build the cache
    println(paths(i))
    println(cache.size)
  }
}
