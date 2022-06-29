package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndReconstructTree {
    public static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value){
            this.value = value;
        }
    }

    public static String serializeByPre(Node head){
        if (head == null){
            return "#!";
        }
        String res = head.value + "!";
        res += serializeByPre(head.left);
        res += serializeByPre(head.right);
        return res;
    }

    public static String serializeByMid(Node head){
        if (head == null){
            return "#!";
        }
        String str = serializeByMid(head.left);
        str += head.value + "!";
        str +=serializeByMid(head.right);
        return str;
    }

    public static Node reconTreeByMid(String str){
        Queue<String> queue = new LinkedList<String>();
        String[] strings = str.split("!");
        for (int i = 0; i != strings.length; i++){
            queue.offer(strings[i]);
        }
        return reconTreeRecur(queue);
    }

    public static Node reconTreeRecur(Queue<String> queue){
        String value = queue.poll();
        if (value.equals("#")){
            return null;
        }
        Node node = new Node(Integer.valueOf(value));
        node.left = reconTreeRecur(queue);
        node.right = reconTreeRecur(queue);
        return node;
    }


    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

//        String str = serializeByPre(head);
//
//        System.out.println(str);
//
//        Node reconHead = reconTreeByPre(str);
//        printTree(reconHead);

        String string = serializeByMid(head);
        System.out.println(string);

    }

}
