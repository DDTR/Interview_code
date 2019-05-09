import java.util.*;
/**
 * 环形列表约瑟夫问题，输入环形列表头节点head和报数值m
 */
public class JosephuKill{
    class Node{
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
        }
    }
    //常规做法
    public Node josephuKillSolutions1(Node head, int m){
        if(head==null||head.next==head||m<1) return head;
        Node preNode = head;
        while(preNode.next!=head){
            preNode = preNode.next;//解决m=1的困扰,这个操作真的秀
        }
        int count = 0;
        while(preNode!=head){
            if(++count==m){
                preNode.next = head.next;
                count = 0;
            }
            else{
                preNode = preNode.next;
            }
            head = preNode.next; //head 节点始终指向preNode的下一个节点
        }
        return head;
    }
    //进阶做法，数学推导直接求出最后剩哪个节点
    public Node josephuKillSolutions2(Node head, int m){
        if(head==null||head.next==head||m<1) return head;
        Node curNode = head;
        int len = 0;
        while(curNode!=head){
            len++;
            curNode = curNode.next;
        }
        int index = getIndex(len, m);
        while(--index!=0){
            head = head.next;
        }
        head.next = head;
        return head;
    }
    public int getIndex(int len, int m){
        if(len==1)
            return 1;
        else
            return (getIndex(len-1, m)+m-1)%len+1; //关键在于推出来这个递推公式
    }
}