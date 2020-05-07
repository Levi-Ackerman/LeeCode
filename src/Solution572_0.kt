import java.util.*

class Solution572_0 {
    /**
     * 572. 求t是否是s的一个子树
     * 子树：子树包含父树的某一个节点及所有的子孙
     */
    fun isSubtree(s: TreeNode?, t: TreeNode?): Boolean {
        return if (s == null && t == null) {
            true
        } else if (s != null && t != null) {
            //遍历节点，看t是否与s的某颗子树相等
            val queue = LinkedList<TreeNode>()
            queue.add(s)
            while (queue.size > 0) {
                val node = queue.removeFirst()
                if (isTreeEqual(node, t)) {
                    return true
                } else {
                    node.apply {
                        left?.let {
                            queue.add(left!!)
                        }
                        right?.let {
                            queue.add(right!!)
                        }
                    }
                }
            }
            false
        } else {
            false
        }
    }

    /**
     * 两颗树是否相等
     */
    fun isTreeEqual(s: TreeNode?, t: TreeNode?): Boolean {
        return if (s == null && t == null) {
            true
        } else if (s != null && t != null) {
            //跟节点值相等，且左右子树相等
            s.`val` == t.`val` && isTreeEqual(s.left, t.left) && isTreeEqual(s.right, t.right)
        } else {
            false
        }
    }

    fun test() {
        val t = TreeNode(4).apply {
            left = TreeNode(1)
            right = TreeNode(2)
        }

        val s = TreeNode(3).apply {
            left = TreeNode(4).apply {
                left = TreeNode(1)
                right = TreeNode(2)
            }
            right = TreeNode(5)
        }

        System.out.println(isSubtree(s, t))
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}