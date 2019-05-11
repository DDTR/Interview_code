import java.awt.HeadlessException;
import java.util.*;
/**
 * 给定一个无序单链表的头节点head,实现单链表的选择排序
 */
public class SelectionSort{
    class Node{
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
        }
    }
    public Node selectionSort(Node head){
        if(head==null){
            return head;
        }
        Node smallPre = null; //最小节点的前驱
        Node cur = head;//当前节点
        Node small = null;//最小节点
        Node tail = null;//排序部分尾部
        while(cur!=null){
            small = cur;
            smallPre = getSmallPre(cur);
            if(smallPre!=null){
                small = smallPre.next;
                smallPre.next = small.next;
            }
            cur = cur==small?cur.next:cur;
            if(tail==null){
                head = small;
            }else{
                tail.next = small;
            }
            tail = small;
        }
        return head;
    }
    public Node getSmallPre(Node head){
        // if(head==null) return null;
        Node smallPre = null;
        Node small = head;
        Node cur = head.next;
        Node pre = head;
        while(cur!=null){
            if(cur.val<small.val){
                small = cur;
                smallPre = pre;
            }
            pre = cur;
            cur = cur.next;
        }
        return smallPre;
    }
}