import java.util.*;
/**
 * 给定无序单链表头节点head，删除其中出现重复的节点
 */
public class RemoveRep{
    class Node{
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
        }
    }
    //借助与HashMap，时间复杂度O(N),空间复杂度O(N)
    public void removeRep1(Node head){
        if(head==null){
            return;
        }
        Node pre = head;
        Node cur = head.next;
        HashSet<Integer> set = new HashSet<>();
        set.add(head.val);
        while(cur!=null){
            if(set.contains(cur.val)){
                pre.next = cur.next;
            }else{
                set.add(cur.val);
                //pre.next = cur;
                pre = cur;
            }
            cur = cur.next;
        }
    }
}