/**
 * Created by ydm on 2017/6/13.
 * LeetCode 237 Delete Node In a Linked List
  * 给定链表中的一个节点  删除该节点
 *
 * 无法得到前一个链表
 * 将后面的值传到当前  然后删除后面的值
 */
public class DeleteNodeInALinkList {

    public void DeleteNodeInALinkList(Node delNode){
        if (delNode == null){
            return;
        }
        if(delNode.next == null){
            delNode = null;
            return;
        }

        delNode.value = delNode.next.value;
        delNode.next = delNode.next.next;
    }
    public static void main(String[] args){
        Node node1 = new Node(1,null);
        Node node2 = new Node(2,node1);
        Node node = new Node(3,node2);

        new DeleteNodeInALinkList().DeleteNodeInALinkList(node);

        while (node != null) {

            System.out.println(node.value);
            node = node.next;
        }

    }
}
