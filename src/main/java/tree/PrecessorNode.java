package tree;

public class PrecessorNode {

    //中序遍历顺序 左 中 右
    //找前驱节点 当一个节点有左子树的时候，找其左子树中最右的节点
    //当一个节点没有左子树的时候 找这个节点的父节点，一直到这个节点是某个节点的右孩子

    public static class Node{
        private int value;
        private Node left;
        private Node right;
        private Node parent;

        Node(int value){
            this.value = value;
        }
    }

    public static Node getPrecessor(Node node){
        if (node == null){
            return null;
        }
        if (node.left != null){
            return getRightMost(node.left);
        }
        Node parent = node.parent;
        while (parent != null && parent.right != node){
            node = parent;
            parent = node.parent;
        }
        return parent;
    }

    public static Node getRightMost(Node node){
        while (node.right != null){
            node = node.right;
        }
        return node;
    }



    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;

        Node test = head.left.left;
        System.out.println(test.value + " next: " + getPrecessor(test));
        test = head.left.left.right;
        System.out.println(test.value + " next: " + getPrecessor(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + getPrecessor(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + getPrecessor(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + getPrecessor(test).value);
        test = head;
        System.out.println(test.value + " next: " + getPrecessor(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + getPrecessor(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + getPrecessor(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + getPrecessor(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + getPrecessor(test).value);
    }

    //二叉树序列化 反序列化


}
