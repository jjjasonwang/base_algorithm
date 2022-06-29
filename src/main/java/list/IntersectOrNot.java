package list;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class IntersectOrNot {
    public static class Node{
        private int value;
        private Node next;

        Node(int value){
            this.value = value;
        }
    }

    public static Node getIntersectNodeWithSet(Node head1, Node head2){
        if (head1 == null || head2 == null){
            return null;
        }
        Set<Node> set = new HashSet<>();
        Node cur1 = head1;
        Node cur2 = head2;
        while (cur1 != null || cur2 != null){
            if (set.add(cur1) == true && set.add(cur2) == true){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }else {
                if (set.add(cur1) == false){
                    return cur1;
                }
                if (set.add(cur2) == false){
                    return cur2;
                }
            }
        }
        return null;
    }

    /**
     * 用于找两个无环链表的第一个相交节点
     * @param head1
     * @param head2
     * @return
     */
    public static Node getIntersectNodeWithLength(Node head1, Node head2){
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1 != null){
            n++;
            cur1 = cur1.next;
        }
        while (cur2 != null){
            n--;
            cur2 = cur2.next;
        }
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;

        n = Math.abs(n);

        while (n != 0){
            n--;
            cur1 = cur1.next;
        }

        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    /**
     * 用于获取两个有环的单链表的相交节点
     * @param head1
     * @param loop1
     * @param head2
     * @param loop2
     * @return
     */
    public static Node getIntersectNodeInLoop(Node head1,Node loop1,Node head2,Node loop2){
        Node cur1 = null;
        Node cur2 = null;

        if (head1 == null || head2 == null){
            return null;
        }
        if (loop1 != loop2){
            cur1 = loop1.next;
            while (cur1 != loop1){
                if (cur1 == loop2){
                    return loop1;
                }
            }
            return null;
        }else {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                cur1 = cur1.next;
                n--;
            }
            while (cur1 != loop1) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }
    }



    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next; // 8->6
        Node intersectNode = getIntersectNodeWithLength(head1, head2);
        System.out.println(intersectNode.value);

        Node head3 = new Node(1);
        head3.next = new Node(2);
        head3.next.next = new Node(3);
        head3.next.next.next = new Node(4);
        head3.next.next.next.next = new Node(5);
        head3.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = head3.next.next.next;

        Node head4 = new Node(1);
        head4.next = new Node(2);
        head4.next.next = head3.next.next.next;

        Node intersectNodeInLoop = getIntersectNodeInLoop(head3, head3.next.next.next, head4, head3.next.next.next);
        System.out.println(intersectNodeInLoop.value);
    }

}
