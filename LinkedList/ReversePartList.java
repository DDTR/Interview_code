import java.util.*;
/*
给定单向链表，反转第from到第to个节点
不满足要求，原链表不做调整
*/
public class ReversePartList{
    class Node{
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
        }
    }
    public Node reversePartList(Node head, int from, int to){
        int len = 0;
        Node curNode = head;
        Node preFrom = null;
        Node nextTo = null;
        while(curNode!=null){
            len++;
            if(len==from-1) preFrom = curNode;
            if(len==to+1) nextTo = curNode;
            curNode = curNode.next;
        }
        if(from<1||to>len||from>to) return head;
        curNode = preFrom==null?head:preFrom.next;
        int diff = to - from + 1;
        Node nextNode = null;
        Node preNode = nextTo;
        while(diff>0){//curNode.next!=nextTo
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
            diff--;
        }
        if(preFrom==null){
            return preNode;
        }else{
            preFrom.next = preNode;
            return head;
        }
    }
}