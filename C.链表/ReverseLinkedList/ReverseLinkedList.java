/**
 * Created by ydm on 2017/6/13.
 * LeetCode 206 Reverse Linked List
 * 反转一个链表
 */
public class ReverseLinkedList {

    public Node reverseNode(Node head){
        Node pre = null;
        Node cur = head;

        while (cur != null){
            Node next  = cur.next ;

            cur.next = pre;

            pre = cur;

            cur= next;

        }

        return pre;
    }


    public static void main(String[] args){
        Node node1 = new Node(1,null);
        Node node2 = new Node(2,node1);
        Node node3 = new Node(3,node2);

        Node node = new ReverseLinkedList().reverseNode(node3);

        while (node != null) {

            System.out.println(node.value);
            node = node.next;
        }

    }
}
