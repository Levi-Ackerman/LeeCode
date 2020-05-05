
class Solution98_0 {
    /**
     * 中序遍历到的当前值
     * 如果后续遍历到的值小于这个值，就说明中序遍历并不升序，不是BST
     */
    var mCurValue: Int = Int.MIN_VALUE

    /**
     * 标记位用于记录mCurValue的值是否已经初始化，防止首个值刚好就是Int.MIN_VALUE的时候判断不准
     */
    var mIsCurValueInited = false

    //BST（二叉搜索树）满足两个条件
    //1. 中序遍历是一个升序排列
    //2. 任一子树也是BST
    fun isValidBST(node: TreeNode?): Boolean {
        if (node == null) {
            return true
        }

        //左子树
        if (!isValidBST(node.left)) {
            return false
        }

        //根
        if (!mIsCurValueInited){
            mIsCurValueInited = true
            mCurValue = node.`val`
        }else if (node.`val` > mCurValue) {
            //满足升序
            mCurValue = node.`val`
        } else {
            return false
        }

        //右子树
        if (!isValidBST(node.right)) {
            return false
        }


        return true
    }

    fun test():Boolean{
        val root = TreeNode(2)
        root.left = TreeNode(1)
        root.right = TreeNode(3)
        return isValidBST(root)
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
