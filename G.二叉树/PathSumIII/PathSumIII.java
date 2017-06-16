import java.util.ArrayList;
import java.util.List;

/**
 * Created by ydm on 2017/6/16.
 * LeetCode 437  Path Sum III
 * 给出一棵二叉树以及一个数字 sum
 * 判断这棵二叉树上存在多少条路径
 * 其路径上的所有节点和为sum
 * 其中路径不一定要起始于根节点；终止于子节点
 * 路径可以从任意节点开始  但只能是向下走的
 */
public class PathSumIII {


    public int PathSumIII(TreeNode node,int sum){

        if(node == null ){
            return 0;
        }
        int res = findPath(node,sum);

        res += PathSumIII(node.left,sum);
        res += PathSumIII(node.right,sum);

        return res;

    }
    //包含根节点
    public int findPath(TreeNode node,int sum){

        if(node == null ){
            return 0;
        }
        int res = 0;
        if(sum == node.value){
            res += 1;
        }


        res += findPath(node.left,sum - node.value);
        res += findPath(node.right,sum - node.value);

        return res;

    }

    public static void main(String[] args){
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(2, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);
        System.out.println(new PathSumIII().PathSumIII(node1,4));
    }
}
