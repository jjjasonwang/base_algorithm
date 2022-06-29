package tree;

public class SuccessorNode {

    //当一个节点有右子树，其后继节点为右子树中最左的节点，因为中序遍历打印顺序是 左 中 右
    //当一个节点没有右子树 找到哪个节点，作为其所在树的那个节点的左子树的最后一个节点
    //当一个节点没有右子树，找这个节点的父节点，一直到这个节点是其某个父节点的左孩子

    public static class Node{
        private int value;
        private Node left;
        private Node right;
        private Node parent;

        Node(int value){
            this.value = value;
        }
    }

    public static Node getSuccessorNode(Node node){
        if (node == null){
            return null;
        }
        if (node.right != null){
            return getLeftMost(node.right);
        }

        Node parent = node.parent;
        //parent为空的情况下，跳出循环，返回null
        while (parent != null && parent.left != node){
            node = parent;
            parent = node.parent;
        }
        return parent;
    }

    public static Node getLeftMost(Node node){
        while (node.left != null){
            node = node.left;
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
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + getSuccessorNode(test));
    }

}
