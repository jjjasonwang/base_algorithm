package list;

import java.util.HashSet;
import java.util.Set;

public class LoopOrNot {
    public static class Node{
        private int value;
        private Node next;

        Node(int value){
            this.value = value;
        }
    }

    public static Node getLoopNodeWithSet(Node head){
        if (head == null || head.next == null || head.next.next == null){
            return null;
        }
        Set<Node> set = new HashSet<>();
        Node cur = head;
        while (cur != null){
            if (set.add(cur) == true){
                cur = cur.next;
            }else {
                return cur;
            }
        }
        return null;
    }

    public static Node getLoopNodeWithDoublePointer(Node head){
        if (head == null || head.next == null || head.next.next == null){
            return null;
        }
        Node n1 = head.next;
        Node n2 = head.next.next;

        while (n1 != n2){
            if (n2.next == null || n2.next.next == null){
                return null;
            }
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n1 = head;
        while(n1 != n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }


    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = head1.next;
        Node loopNode = getLoopNodeWithDoublePointer(head1);
        System.out.println("LoopNode value:"+loopNode.value);
    }







}
