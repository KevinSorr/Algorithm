import java.util.ArrayList;
import java.util.List;

/**
 * Created by ydm on 2017/6/16.
 * LeetCode 257 Binary Tree Paths
 * 给定一个二叉树 返回所有表示从根节点到叶子节点路径的字符串
 */
public class BinaryTreePaths {

    public List<String>  BinaryTreePaths(TreeNode treeNode){
        List<String> res = new ArrayList<>();
        if(treeNode == null){
            return res;
        }

        if(treeNode.left == null && treeNode.left == null){
            res.add(treeNode.value+"");
            return res;
        }
        List<String> left = BinaryTreePaths(treeNode.left);

        for(String s : left ){
            res.add(treeNode.value+"->" + s);

        }

        List<String> right = BinaryTreePaths(treeNode.right);
        for(String s : right ){
            res.add(treeNode.value+"->" + s);
        }
        return res;
    }

    public static void main(String[] args){
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, node5, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node4, null);
        TreeNode node1 = new TreeNode(1, node2, node3);
        List<String> strings = new BinaryTreePaths().BinaryTreePaths(node1);
        for(String s : strings){
            System.out.println(s);
        }
    }
}
