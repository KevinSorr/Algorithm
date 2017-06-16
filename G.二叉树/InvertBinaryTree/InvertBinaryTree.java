/**
 * Created by ydm on 2017/6/16.
 */
public class InvertBinaryTree {

    public TreeNode InvertBinaryTree(TreeNode root){
        if(root == null){
            return root;
        }
        swap(root);
        InvertBinaryTree(root.left);
        InvertBinaryTree(root.right);
        return root;
    }
    public void swap(TreeNode node){
        TreeNode treeNode = node.right;
        node.left = node.right;
        node.right = treeNode;

    }

    public static void main(String[] args){

        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node1 = new TreeNode(1, node2, node3);
        System.out.println(new InvertBinaryTree().InvertBinaryTree(node1).left.value);
    }
}
