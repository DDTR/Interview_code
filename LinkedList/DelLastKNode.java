import java.util.*;
/*
删除单链表和双链表的倒数第K个节点，如果不存在返回源链表
*/
public class DelLastKNode{
    //single linkedlist node
    class SingleNode{
        public int val;
        public SingleNode next;
        public SingleNode(int val){
            this.val = val;
        }
    }
    //double linekdlist node
    class DoubleNode{
        public int val;
        public DoubleNode pre;
        public DoubleNode next;
        public DoubleNode(int val){
            this.val = val;
        }
    }
    //del single linkedlist last k node
    public SingleNode delSingleLastKNode(SingleNode head, int K){
        if(head==null||K<1) return head; //倒数第K个节点不存在
        SingleNode cur = head;
        while(cur!=null){
            cur = cur.next;
            K--;
        }
        if(K==0){
            head = head.next;
        }
        if(K<0){
            cur = head;
            while(K!=0){
                cur = cur.next;
                K++;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
    //del double linkedlist last k node
    public DoubleNode delDoubleLastKNode(DoubleNode head, int K){
        if(head==null||K<1) return head;
        DoubleNode cur = head;
        while(cur!=null){
            cur = cur.next;
            K--;
        }
        if(K==0){
            head = head.next;
            head.pre = null;
        }
        if(K<0){
            cur = head;
            while(K!=0){
                cur = cur.next;
                K++;
            }
            DoubleNode newNext = cur.next.next;
            cur.next = newNext;
            if(nextNext!=null){
                newNext.pre = cur; //需要判断newNext是否为null
            }
        }
        return head;
    }
}