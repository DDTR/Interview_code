import java.util.*;
/*
1.反转单链表
2.反转双向链表
要求：时间复杂度O(N)，空间复杂度O(1)
*/
public class ReverseList{
    class SingleNode{
        public int val;
        public SingleNode next;
        public SingleNode(int val){
            this.val = val;
        }
    }
    class DoubleNode{
        public int val;
        public DoubleNode pre;
        public DoubleNode next;
        public DoubleNode(int val){
            this.val = val;
        }
    }
    //reverse single linkedlist
    public SingleNode reverseSingleList(SingleNode head){
        //if(head==null||head.next==null) return head;
        SingleNode preNode = null;
        SingleNode nextNode = null;
        while(head!=null){
            nextNode = head.next;
            head.next = preNode;
            preNode = head;
            head = nextNode;
        }
        return preNode;
    }
    public DoubleNode reverseDoubleNode(DoubleNode head){
        DoubleNode preNode = null;
        DoubleNode nextNode = null;
        while(head!=null){
            nextNode = head.next;
            head.next = preNode;
            head.pre = nextNode;
            preNode = head;
            head = nextNode;
        }
        return head;
    }
}
