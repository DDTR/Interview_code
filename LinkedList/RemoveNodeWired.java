import java.util.*;
/**
 * 给定一个链表中的节点node,不给定头节点，删除node
 */
public class RemoveNodeWired{
    class Node{
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
        }
    }
    public removeNodeWired(Node node){
        if(node==null){
            return null;
        }
        Node next = node.next;
        if(next==null){
            throw new RuntimeException("can not remove last node.");
        }
        node.val = next.val;
        node.next = next.next;
    }
}