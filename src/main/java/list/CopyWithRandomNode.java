package list;

import java.util.HashMap;
import java.util.Map;

public class CopyWithRandomNode {
    public static class Node {
        private int value;
        private Node next;
        private Node rand;

        Node(int value) {
            this.value = value;
        }
    }

    //使用hashMap记录每个节点内存地址
    public static Node copyListUseHashMap(Node head){
        Map<Node,Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null){
            map.put(cur,new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static Node copyListUseCopyAndSplit(Node head){
        if (head == null){
            return null;
        }
        Node cur = head;
        Node next = null;
        //每个节点后复制节点
        while (cur != null){
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        //复制出的节点找自己的random
        cur = head;
        Node curCopy = null;
        while (cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand == null ? null : cur.rand.next;
            cur = next;
        }
        //拆分有复制节点的链表
        cur = head;
        Node res = head.next;
        while (cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next == null ? null : next.next;
            cur = next;
        }
        return res;
    }

    public static void PrintNodeAndRand(Node head){
        Node cur = head;
        while (cur != null){
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        while (cur != null){
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Node head = null;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        PrintNodeAndRand(head);

        Node newHead = copyListUseCopyAndSplit(head);
        PrintNodeAndRand(newHead);


    }

}
