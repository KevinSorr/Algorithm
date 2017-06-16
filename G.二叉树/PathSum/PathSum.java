/**
 * Created by ydm on 2017/6/16.
 * LeetCode 112 PathSum
 * 给出一个二叉树以及一个数字sm，判断在这棵二叉树上是否存在一条从
 * 根到叶子的路径
 * 其路径上的所有节点和为sum
 */
public class PathSum {

    public boolean PathSum(TreeNode treeNode,int sum){
        if(treeNode == null){
            return  false;
        }
        if(treeNode.left == null && treeNode.right == null){
            return sum == 0;
        }
        return PathSum(treeNode.left,sum  - treeNode.value) || PathSum(treeNode.right,sum  - treeNode.value)  ;
    }
    public static void main(String[] args){
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, node5, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node4, null);
        TreeNode node1 = new TreeNode(1, node2, node3);
        System.out.println(new PathSum().PathSum(node1,10));
    }
}
