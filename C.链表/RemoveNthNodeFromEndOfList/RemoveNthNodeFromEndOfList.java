/**
 * Created by ydm on 2017/6/13.
 * LeetCode 19 给定一个链表 删除倒数第n个元素
 * 如：1-->2-->3-->4-->5-->null n = 2
 * 返回： 1-->2->3->5
 */
public class RemoveNthNodeFromEndOfList {
    //双指针移动
    public Node RemoveNthNodeFromEndOfList(Node head,int n){
        Node pre = new Node(0,head);

        Node pre1 = pre;
        Node pre2 = pre;
        for(int i = 0; i < n;i ++) {
            pre2 = pre2.next;
        }
        while (pre2.next != null){
            pre1 = pre1.next;
            pre2 = pre2.next;
        }
        pre1.next = pre1.next.next;
        return pre.next;
    }
    public static void main(String[] args){
        Node node1 = new Node(1,null);
        Node node2 = new Node(2,node1);
        Node node3 = new Node(3,node2);

        Node node = new RemoveNthNodeFromEndOfList().RemoveNthNodeFromEndOfList(node3,3);

        while (node != null) {

            System.out.println(node.value);
            node = node.next;
        }

    }
}
