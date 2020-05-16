class Solution102_0 {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return listOf()
        }

        val result = mutableListOf<List<Int>>()

        val queue = mutableListOf<TreeNode>()
        val endFlag = TreeNode(0) //哨兵，表示一层遍历结束
        queue.add(root)
        queue.add(endFlag)

        var floorList = mutableListOf<Int>() //当前这一层的节点list
        //这里必须是大于1，因为里面如果只有一个哨兵了，就不必要遍历了
        while (queue.size > 1) {
            val head = queue.removeAt(0)
            if (head == endFlag) {
                queue.add(head) //说明本层遍历结束了，现在队列里全是本层的子节点，哨兵加到最后作为下一层结束的标记
                result.add(floorList)
                floorList = mutableListOf()
            } else {
                floorList.add(head.`val`)
                if (head.left != null) {
                    queue.add(head.left!!)
                }
                if (head.right != null) {
                    queue.add(head.right!!)
                }
            }
        }

        result.add(floorList)

        return result
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = Solution102_0().levelOrder(TreeNode(3).apply {
                left = TreeNode(9)
                right = TreeNode(20).apply {
                    left = TreeNode(5)
                    right = TreeNode(7)
                }
            })
            println(result)
        }
    }
}