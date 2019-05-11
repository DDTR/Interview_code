import java.util.*;
/**
 * 将搜索二叉树转换成双向链表
 */
public class BinaryTree2DoubleList{
    class Node{
        public int val;
        public Node left;
        public Node right;
        public DoubleNode(int val){
            this.val = val;
        }
    }
    //借助queue,时间复杂度O(N), 空间复杂度O(N)
    public Node convert1(Node head){
        if(head==null){
            return head;
        }
        Queue<Node> queue = new LinkedList<>();
        inorder(head, queue);
        head = queue.poll();
        head.left = null;
        Node pre = head;
        Node cur = null;
        while(!queue.isEmpty()){
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;//最后一个节点的right指向null
        return head;
    }
    public void inorder(Node head, Queue<Node> queue){
        if(head==null){
            return;
        }
        inorder(head.left, queue);
        queue.offer(head);
        inorder(head.right, queue);
    }
    //不借助queue，时间复杂度O(N),空间复杂度O(h),h为二叉树的高度
    public Node convert2(Node head){
        if(head==null){
            return head;
        }
        end = process(head);
        head = end.right;
        head.left = null;
        end.right = null;
        return head;
    }
    public Node process(Node head){
        if(head==null){
            return null;
        }
        Node leftEnd = process(head.left);
        Node rightEnd = process(head.right);
        Node leftStart = leftEnd==null?null:leftEnd.right;
        Node rightStart = rightEnd==null?null:rightEnd.right;
        if(leftEnd!=null&&rightEnd!=null){
            leftEnd.right = head;
            head.left = leftEnd;
            leftStart.left = null;
            rightStart.left = head;
            head.right = rightStart;
            rightEnd.right = leftStart;
            return rightEnd;
        }else if(leftEnd==null&&rightEnd!=null){
            head.left = null;
            rightStart.left = head;
            head.right = rightStart;
            rightEnd.right = head;
            return rightEnd;
        }else if(leftEnd!=null&&rightEnd==null){
            leftEnd.right = head;
            head.left = leftEnd;
            head.right = leftStart;
            return head;
        }else{
            head.left = null;
            head.right = head;
            return head;
        }
    }
}