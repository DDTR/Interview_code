import java.util.*;
/**
 * 复制含有随机指针的链表
 */
public class CopyListWithRand{
    class Node{
        public int val;
        public Node next;
        public Node rand;
        public Node(int val){
            this.val = val;
        }
    }
    //借助于HashMap,时间复杂度O(N),空间复杂度O(N)
    public Node copyListWithRand1(Node head){
        if(head==null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node curNode = head;
        while(curNode!=null){
            map.put(curNode, new Node(curNode.val));
            curNode = curNode.next;
        }
        curNode = head;
        //设置next和rand
        while(curNode!=null){
            map.get(curNode).next = map.get(curNode.next);
            map.get(curNode).rand = curNode.rand==null?null:map.get(curNode.rand);
            curNode = curNode.next;
        }
        return map.get(head);
    }
    //在链表上操作，时间复杂度O(N), 空间复杂度O(1)
    public Node copyListWithRand2(Node head){
        if(head==null) return head;
        Node curNode = head;
        Node nextNode = null;
        //复制Node
        while(curNode!=null){
            next = curNode.next;
            curNode.next = new Node(curNode.val);
            curNOde.next.next = next;
            curNode = next;
        }
        curNode = head;
        Node copyNode = null;
        while(curNode!=null){
            next = curNode.next.next;
            copyNode = curNode.next;
            copyNode.rand = curNode.rand==null?null:curNode.rand.next;
            curNode = next;
        }
        //拆分链表
        curNode = head;
        //next = head.next;
        Node res = head.next;
        while(curNode!=null){
            next = curNode.next.next;
            copyNode = curNode.next;
            curNode.next = next;
            curNode = curNode.next;
            copyNode.next = curNode!=null?curNode:null;
        }
        return res;
    }
}