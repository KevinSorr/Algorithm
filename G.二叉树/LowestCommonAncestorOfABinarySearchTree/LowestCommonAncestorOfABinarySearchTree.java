/**
 * Created by ydm on 2017/6/16.
 * LeetCode 235 LowestCommonAncestorOfABinarySearchTree
 * 给定一棵二分搜索树和两个节点  寻找这两个节点的最近公共祖先
 */
public class LowestCommonAncestorOfABinarySearchTree {

    public TreeNode LowestCommonAncestorOfABinarySearchTree(TreeNode root,TreeNode value1,TreeNode value2){
        if(value1 == null || value2 == null || root == null){
            return null;
        }
        if(value1.value < root.value && value2.value < root.value){
            return LowestCommonAncestorOfABinarySearchTree(root.left,value1,value2);
        }
        if(value1.value > root.value && value2.value > root.value){
            return LowestCommonAncestorOfABinarySearchTree(root.right,value1,value2);
        }
        return root;
    }
    public static void main(String[] args){
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);
        System.out.println(new LowestCommonAncestorOfABinarySearchTree().LowestCommonAncestorOfABinarySearchTree(node1,node4,node3));
    }

}
