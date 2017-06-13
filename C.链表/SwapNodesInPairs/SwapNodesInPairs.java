/**
 * Created by ydm on 2017/6/13.
 *
 * LeetCode 24 Swap Nodes in Pairs
 * 给定一个链表  对于两个相邻的节点 交换其位置
 * 如：链表为1--->2--->3--->4--->null
 * 返回：2 --->1--->4--->3-->null
 * 只能对节点修改  不能修改节点的值
 */
public class SwapNodesInPairs {

    public Node SwapNodesInPairs(Node head){
        Node virtualNode = new Node(-1,head);

        Node pre = virtualNode;
        while (pre.next != null && pre.next.next != null){

            Node node1 = pre.next;
            Node node2 = node1.next;
            Node next = node2.next;

            node2.next = node1;
            node1.next = next;
            pre.next = node2;

            pre = node1;
        }

        return virtualNode.next;
    }

    public static void main(String[] args){
        Node node1 = new Node(1,null);
        Node node2 = new Node(2,node1);
        Node node3 = new Node(3,node2);
        Node node4 = new Node(4,node3);

        Node node = new SwapNodesInPairs().SwapNodesInPairs(node4);

        while (node != null) {

            System.out.println(node.value);
            node = node.next;
        }

    }
}
