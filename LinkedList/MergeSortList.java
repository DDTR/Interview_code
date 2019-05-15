import java.util.*;
/**
 * 合并两个有序单链表，返回合并链表的头节点
 */
public class MergeSortList{
    class Node{
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
        }
    }
    public mergeSortList(Node head1, Node head2){
        if(head1==null||head2==null){
            return head1!=null?head1:head2;
        }
        Node head = head1.val<head2.val?head1:head2;
        Node cur1 = head==head1?head1:head2;//开始节点小
        Node cur2 = head==head1?head2:head1;//开始节点大
        Node pre = null;
        Node next = null;
        while(cur1!=null&&cur2!=null){
            if(cur1.val<=cur2.val){
                pre = cur1;
                cur1 = cur1.next;
            }else{
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = next;
            }
        }
        pre.next = cur1==null?cur2:cur1;
        return head;
    }
}