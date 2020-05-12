class Solution1436_0 {
    //旅行终点站
    fun destCity(paths: List<List<String>>): String {
        val hasDest = HashSet<String>()
        val noDest = HashSet<String>()
        for(path in paths){
            val dest = path[1]
            val src = path[0]
            if (dest == src){
                continue
            }
            if (!hasDest.contains(dest)){
                noDest.add(dest)
            }
            hasDest.add(src)
            noDest.remove(src)
        }
        return if(noDest.isEmpty()) "" else noDest.first()
    }
}