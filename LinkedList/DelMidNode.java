import java.util.*;
/*
1. 删除链表中间节点
2. 删除链表a/b处节点
*/
public class DelMidNode{
    class Node{
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
        }
    }
    //remove mid node
    public Node removeMidNode(Node head){
        if(head==null||head.next==null) return head;
        if(head.next.next==null) return head.next;
        Node preNode = head;
        Node curNode = head.next.next;
        while(curNode.next!=null&&curNode.next.next!=null){
            preNode = preNode.next;
            curNode = curNode.next.next;
        }
        preNode.next = preNode.next.next;
        return head;
    }
    //remove a/b ratio node
    public Node removeRatioNode(Node head, int a, int b){
        if(a<1||a>b) return head;
        int len = 0;
        Node curNode = head;
        while(curNode!=null){
            len++;
            curNode = curNode.next;
        }
        int delIndex = (int)Math.ceil((double)(len*a)/(double)b);//计算删除节点的index
        if(delIndex==1) return head.next;
        if(delIndex>1){//解决head为null的异常
            curNode = head;
            while(delIndex!=1){
                curNode = curNode.next;
                delIndex--;
            }
            curNode.next = curNode.next.next;
        }
        return head;
    }
}