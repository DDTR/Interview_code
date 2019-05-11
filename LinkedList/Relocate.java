import java.util.*;
/**
 * 按左右半区方式重新组合单链表
 */
public class Relocate{
    class Node{
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
        }
    }
    public void relocate(Node head){
        if(head==null||head.next==null){
            return;
        }
        Node slow = head;
        Node fast = head.next;//小技巧
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node right = slow.next;
        slow.next = null;
        merge(head, right);
    }
    public void merge(Node left, Node right){
        Node next = null;
        while(left!=null){
            next = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = next;
        }
        left.next = right;
    }
}