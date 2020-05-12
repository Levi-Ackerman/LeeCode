//二叉树两个节点找公共祖先

class Solution236_0{
    private lateinit var mResult:TreeNode

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        hasNode(root, p!!, q!!)
        return mResult
    }

    /**
     * 树root中是否包含了p或者q节点的至少一个
     */
    fun hasNode(root: TreeNode?, p: TreeNode, q: TreeNode):Boolean{
        if (root == null){
            return false
        }

        val rootOk = (root.`val` == p.`val` || root.`val` == q.`val`)
        val leftOk = hasNode(root.left, p, q)
        val rightOk = hasNode(root.right, p, q)

        if ((leftOk && rightOk) || (rootOk && (leftOk || rightOk))){
            //左右子节点都包括p或q，那就是一边一个，就是公共祖先了（且唯一）
            //或者根节点是p或q，另一个p或q在子节点中，那也是答案
            //这个就是答案，满足这个条件的节点，整棵树只有一个（假设一定有解）
            mResult = root
        }

        return rootOk || leftOk || rightOk
    }
}