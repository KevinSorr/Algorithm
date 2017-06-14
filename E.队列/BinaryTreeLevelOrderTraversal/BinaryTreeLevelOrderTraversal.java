import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by ydm on 2017/6/14.
 * LeetCode 102 Binary Tree Level Order Traversal
 * 对一个二叉树进行层序遍历
 */
public class BinaryTreeLevelOrderTraversal {
    public void BinaryTreeLevelOrderTraversal(TreeNode2 node){
        if(node == null){
            return;
        }
        Queue<TreeNode2> nodeQueue = new LinkedBlockingQueue<>();
        nodeQueue.offer(node);
        while (!nodeQueue.isEmpty()){
            TreeNode2 first = nodeQueue.poll();
            System.out.println(first.value);

            if(first.left != null){
                nodeQueue.offer(first.left);
            }
            if(first.right != null){
                nodeQueue.offer(first.right);
            }

        }

    }
    public static void main(String[] args){
        TreeNode2 node5 = new TreeNode2(5, null, null);
        TreeNode2 node4 = new TreeNode2(4, null, null);
        TreeNode2 node3 = new TreeNode2(3, null, null);
        TreeNode2 node2 = new TreeNode2(2, node4, node5);
        TreeNode2 node1 = new TreeNode2(1, node2, node3);

        new BinaryTreeLevelOrderTraversal().BinaryTreeLevelOrderTraversal(node1);
    }
}
