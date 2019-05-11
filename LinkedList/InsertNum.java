import java.util.*;
/**
 * 环形链表从head开始不降序，给定num,插入节点值为num的节点，且链表仍然有序
 */
public class InsertNum{
    class Node{
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
        }
    }
    public Node insertNum(Node head, int num){
        if(head==null){
            head = new Node(num);
            head.next = head;
            return head;
        }
        Node pre = head;
        Node cur = head.next;
        Node temp = new Node(num);
        while(cur!=head){
            if(pre.val<=num&&cur.val>=num){
                pre.next = temp;
                temp.next = cur;
                return head;
            }
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = temp;
        temp.next = head;
        return num<=head.val?temp:head;
    }
}