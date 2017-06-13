/**
 * Created by ydm on 2017/6/13.
 * LeetCode 203 Remove Linked List Elements
 * 在链表中删除值为val的所有节点
 * 如：1-->2-->6-->3-->4-->5-->6-->null,要求删除值为6的节点
 * 返回 11-->2-->3-->4-->5-->null
 */
public class RemoveLinkedListElements {

    //虚拟头节点
    public Node RemoveLinkedListElements2(Node head,int value){
        Node virtualHead = new Node(-1,head);
        Node cur = virtualHead;
        while (cur.next != null){
            if (cur.next.value == value) {
                Node delNode = cur.next;
                cur.next = delNode.next;
            }else {
                cur = cur.next;
            }
        }

        return virtualHead.next;
    }

    //头节点单独处理
    public Node RemoveLinkedListElements(Node head,int value){
        while (head != null && head.value == value){
            head = head.next;
        }
        if(head == null){
            return null;
        }
        Node cur = head;
        while (cur.next != null){
            if (cur.next.value == value) {
                Node delNode = cur.next;
                cur.next = delNode.next;
            }else {
                cur = cur.next;
            }
        }

        return head;
    }


    public static void main(String[] args){
        Node node1 = new Node(1,null);
        Node node2 = new Node(2,node1);
        Node node3 = new Node(3,node2);

        Node node = new RemoveLinkedListElements().RemoveLinkedListElements2(node3,3);

        while (node != null) {

            System.out.println(node.value);
            node = node.next;
        }

    }
}
