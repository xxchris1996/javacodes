package zjtd;

import java.util.LinkedList;
import java.util.List;

public class linkedlist {



    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode cur = root;
        cur.next = new ListNode(8);
        cur = cur.next;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(6);
        cur = cur.next;
        cur.next = new ListNode(5);
        cur = cur.next;
        cur.next = new ListNode(4);
        cur = cur.next;
        cur.next = new ListNode(7);
        cur = cur.next;
        cur.next = new ListNode(2);
        cur = root;
        show(cur);
        ListNode ret = solution(root);
        show(ret);

    }
    static ListNode solution(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode node1 = head;
        ListNode node2 = head.next;
        ListNode p1 = node1;
        ListNode p2 = node2;
        while (p1 != null){
            p1.next = p2.next;
            p1 = p1.next;
            p2.next = p1 == null ? null : p1.next;
            p2 = p2.next;
        }
        show(node1);
        show(node2);
        ListNode p2_r = reverse(node2);
        show(p2_r);
        ListNode ret = merge(node1, p2_r);
        return ret;

    }
    static ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
    static ListNode merge(ListNode node1, ListNode node2){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(node1 != null && node2 != null){
            if(node1.val > node2.val){
                cur.next = node2;
                node2 = node2.next;
                cur = cur.next;
            } else {
                cur.next = node1;
                node1 = node1.next;
                cur = cur.next;
            }
        }
        cur.next = node1 == null ? node2 : node1;
        return dummy.next;
    }
    static void show(ListNode ret){
        while (ret != null){
            System.out.print(ret.val + " ");
            ret = ret.next;
        }
        System.out.println();
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}