import java.util.*;
/**
 * 给定一个链表的头节点head和一个整数,实现将值为num的节点都删除掉
 */
public class RemoveValue{
    class Node{
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
        }
    }
    //借助栈,时间复杂度O(N),空间复杂度O(N)
    public Node removeValue1(Node head, int num){
        Stack<Node> stack = new Stack<>();
        while(head!=null){
            if(head.val!=num){
                stack.push(head);
                head = head.next;
            }
        }
        while(!stack.isEmpty){
            stack.peek().next = head;
            head = stack.pop();
        }
        return head;
    }
    //不借助栈,时间复杂度O(N), 空间复杂度O(1)
    public Node removeValue2(Node head, int num){
        //先找头节点
        Node newHead = head;
        while(newHead!=null){
            if(newHead.val==num){
                break;
            }
            newHead = newHead.next;
        }
        if(newHead==null){
            return head;
        }
        Node pre = newHead;
        Node cur = pre.next;
        while(cur!=null){
            if(cur.val==num){
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        return newHead;
    }
}