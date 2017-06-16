/**
 * Created by ydm on 2017/6/16.
 *
 * LeetCode 104
 * 二叉树高度
 */
public class MaximumDepthOfBinaryTree {

    private int MaximumDepthOfBinaryTree(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = MaximumDepthOfBinaryTree(root.left) ;


        int right =  MaximumDepthOfBinaryTree(root.right) ;


        return Math.max(left,right) + 1;
    }


    public static void main(String[] args){
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, node5, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node4, null);
        TreeNode node1 = new TreeNode(1, node2, node3);
        System.out.println(new MaximumDepthOfBinaryTree().MaximumDepthOfBinaryTree(node1));

    }
}
