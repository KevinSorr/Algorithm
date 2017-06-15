import java.util.*;

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
    //前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.add(p.value);  // Add before going to children
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                p = node.right;
            }
        }
        return result;
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
    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                result.add(node.value);  // Add after all left children
                p = node.right;
            }
        }
        return result;
    }
    //后遍历 145
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.addFirst(p.value);  // Reverse the process of preorder
                p = p.right;             // Reverse the process of preorder
            } else {
                TreeNode node = stack.pop();
                p = node.left;           // Reverse the process of preorder
            }
        }
        return result;
    }
    //后遍历 145
    public List<Integer> BinaryTreeNextorderTraversal(TreeNode node) {

            List<Integer> result = new ArrayList<>();
            if (node == null) {
                return result;
            }
            Stack<TreeNodeVisited> stack = new Stack<>();
            TreeNodeVisited nodeTop = new TreeNodeVisited(false, node);
            stack.add(nodeTop);
            while (!stack.empty()) {
                TreeNodeVisited top = stack.peek();

                if (top.node.right != null && !top.isVistited) {
                    stack.push(new TreeNodeVisited(false, top.node.right));
                }
                if (top.node.left != null && !top.isVistited) {
                    stack.push(new TreeNodeVisited(false, top.node.left));
                }
                if(top.isVistited){
                    TreeNodeVisited out = stack.pop();
                    result.add(out.node.value);
                }
                top.isVistited = true;


            }
            return result;


    }

    //前序遍历 递归实现
    public void preTreeNode(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.value);
        if(root.left != null){
            preTreeNode(root.left);
        }
        if(root.right != null){
            preTreeNode(root.right);
        }


    }
    //中序遍历 递归实现
    public void inTreeNode(TreeNode root){
        if(root == null){
            return;
        }

        if(root.left != null){
            inTreeNode(root.left);
        }
        System.out.println(root.value);
        if(root.right != null){
            inTreeNode(root.right);
        }


    }
    //后序遍历 递归实现
    public void nextTreeNode(TreeNode root){
        if(root == null){
            return;
        }

        if(root.left != null){
            nextTreeNode(root.left);
        }
        if(root.right != null){
            nextTreeNode(root.right);
        }
        System.out.println(root.value);


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

        new BinaryTreePreorderTraversal().nextTreeNode(node1);

    }
}
