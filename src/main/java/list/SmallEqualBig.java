package list;

public class SmallEqualBig {
    public static class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public static Node listPartitionArray(Node head, int pivot){
        if (head == null){
            return null;
        }
        int i = 0;
        Node cur = head;
        while (cur != null){
            i++;
            cur = cur.next;
        }
        Node[] nodeArray = new Node[i];
        cur = head;
        for (int j = 0; j < nodeArray.length; j++){
            nodeArray[j] = cur;
            cur = cur.next;
        }
        arrayPartition(nodeArray,pivot);
        for (int k = 1; k < nodeArray.length; k++){
            if (k == nodeArray.length - 1){
                nodeArray[k].next = null;
            }
            nodeArray[k-1].next = nodeArray[k];
        }
        return nodeArray[0];
    }

    public static void arrayPartition(Node[] nodeArray, int pivot){
        int small = -1;
        int big = nodeArray.length;
        int index = 0;
        while (index != big){
            if (nodeArray[index].value < pivot){
                swap(nodeArray,++small,index++);
            }else if (nodeArray[index].value > pivot){
                swap(nodeArray,--big,index);
            }else {
                index++;
            }
        }
    }

    public static void swap(Node[] nodeArray, int a, int b){
        Node tmp = nodeArray[a];
        nodeArray[a] = nodeArray[b];
        nodeArray[b] = tmp;
    }


    //用六个指针储存三个区域
    public static Node listPartition2(Node head, int pivot){
        if (head == null){
            return null;
        }

        Node smallStart = null;
        Node smallEnd = null;
        Node equalStart = null;
        Node equalEnd = null;
        Node bigStart = null;
        Node bigEnd = null;
        Node next = null;

        //只使用常数项空间，不另外new节点,将所有节点存储在三个区域内
        while (head != null){
            next = head.next;
            head.next = null;
            if (head.value < pivot){
                if (smallStart == null){
                    smallStart = head;
                    smallEnd = head;
                }else {
                    smallEnd.next = head;
                    smallEnd = head;
                }
            }else if (head.value == pivot){
                if (equalStart == null){
                    equalStart = head;
                    equalEnd = head;
                }else {
                    equalEnd.next = head;
                    equalEnd = head;
                }
            }else {
                if (bigStart == null){
                    bigStart = head;
                    bigEnd = head;
                }else {
                    bigEnd.next = head;
                    bigEnd = head;
                }
            }
            head = next;
        }
        //重连所有节点
        //先连接小于区域和等于区域
        if (smallEnd != null){
            smallEnd.next = equalStart;
            equalEnd = equalEnd == null ? smallEnd : equalEnd;
        }

        if (equalEnd != null){
            equalEnd.next = bigStart;
        }

        return smallStart != null ? smallStart : equalStart != null ? equalStart : bigStart;
    }





    public static void printLinkedList(Node head){
        while (head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }



    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        // head1 = listPartition1(head1, 4)4
        head1 = listPartition2(head1, 5);
        printLinkedList(head1);

    }
}
