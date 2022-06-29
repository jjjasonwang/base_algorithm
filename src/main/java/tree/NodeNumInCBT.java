package tree;

public class NodeNumInCBT {
    public static class Node{
        private Node left;
        private Node right;
        private int value;

        public Node(int value){
            this.value = value;
        }
    }

    //先找到整棵树的总深度，判断右子树的最左节点有没有到达最后一层
    //右子树的最左节点达到，左子树为满二叉树
    //右子树的最左节点未达到，右子树为满二叉树
    public static int nodeNum(Node head){
        if (head == null){
            return 0;
        }
        return bs(head,1,mostLeftDepth(head,1));
    }

    //第一个参数为当前节点，第二个参数为当前节点所在的层数，第三个参数为总层数，递归函数返回的是以当前节点为根的子树的节点个数
    public static int bs(Node head, int level, int h){
        if (level == h){
            return 1;
        }
        //右子树的最左节点达到最后一层,左子树一定是满二叉树，可以计算出节点数，再加上继续递归右子树的节点数
        if (mostLeftDepth(head.right,level + 1) == h){
            return bs(head.right,level + 1,h) + (1 << (h - level));
        //右子树的最左节点未达到最后一层,右子树一定是满二叉树
        } else {
            return bs(head.left,level + 1,h) + (1 << (h - level - 1));
        }
    }

    public static int mostLeftDepth(Node node, int level){
        while (node != null){
            level++;
            node = node.left;
        }
        return level - 1;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(nodeNum(head));
    }
}
