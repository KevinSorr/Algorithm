import java.util.Stack;

/**
 * Created by ydm on 2017/6/14.
 *  LeetCode 144 Binary Tree Preorder Traversal
 * 前序遍历二叉树
 */
class TreeNodeVisited {
    boolean isVistited = false;
    TreeNode node;

    public TreeNodeVisited(boolean isVistited, TreeNode node) {
        this.isVistited = isVistited;
        this.node = node;
    }
}

public class BinaryTreePreorderTraversal {

    //前序遍历
    public void BinaryTreePreorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(node);
        while (!stack.empty()) {
            TreeNode top = stack.pop();
            System.out.println(top.value);
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }

    }

    //中序遍历
    public void BinaryTreeLeftorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNodeVisited> stack = new Stack<>();
        TreeNodeVisited nodeTop = new TreeNodeVisited(false, node);
        stack.add(nodeTop);
        while (!stack.empty()) {
            TreeNodeVisited top = stack.peek();

            if (top.node.right != null && !top.isVistited) {
                stack.pop();
                stack.push(new TreeNodeVisited(false, top.node.right));
                stack.push(new TreeNodeVisited(true, top.node));
            }
            if (top.node.left != null && !top.isVistited) {
                stack.push(new TreeNodeVisited(false, top.node.left));
            } else {
                System.out.println(top.node.value);
                stack.pop();
            }

        }

    }

    //后遍历 145
    public void BinaryTreeNextorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNodeVisited> stack = new Stack<>();
        TreeNodeVisited nodeTop = new TreeNodeVisited(false, node);
        stack.add(nodeTop);
        while (!stack.empty()) {
            TreeNodeVisited top = stack.peek();

            boolean isPop = false;
            if (top.node.right != null && !top.isVistited) {
                stack.push(new TreeNodeVisited(false, top.node.right));
            } else {
                System.out.println(top.node.value);
                stack.pop();
                isPop = true;
            }
            if (top.node.left != null && !top.isVistited) {
                stack.push(new TreeNodeVisited(false, top.node.left));
            } else {
                if (!isPop) {
                    System.out.println(top.node.value);
                    stack.pop();
                }
            }
            top.isVistited = true;


        }
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);

//        TreeNode node3 = new TreeNode(3,null,null);
//        TreeNode node2 = new TreeNode(2,null,null);
//        TreeNode node1 = new TreeNode(1,node2,node3);

        new BinaryTreePreorderTraversal().BinaryTreeNextorderTraversal(node1);

    }
}
