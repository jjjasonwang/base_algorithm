package list;

import java.util.Stack;

public class IsPalindromeList {
    public static class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }


    //需要使用栈，空间复杂度O(n)
    public static boolean isPalindromeStack(Node head){
        Stack<Integer> stack = new Stack<>();
        Node head2 = head;
        while (head != null){
            stack.push(head.value);
            head = head.next;
        }
        while (head2 != null){
            int pop = stack.pop();
            if (pop != head2.value){
                return false;
            }
            head2 = head2.next;
        }
        return true;
    }


    //使用栈+快慢指针，只入一半栈，空间复杂度O(n/2)
    //难点在于当链表中个数为奇数时，让慢指针停在中点后的第一个点
    //当链表中个数为偶数时，让慢指针停在分隔处后第一个点
    public static boolean isPalindromeHalfStack(Node head){
        if (head == null || head.next == null){
            return true;
        }
        Node fastPointer = head;
        Node slowPointer = head.next;

        while (fastPointer.next != null && fastPointer.next.next != null){
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }

        Stack<Integer> stack = new Stack<>();
        while (slowPointer != null){
            stack.push(slowPointer.value);
            slowPointer = slowPointer.next;
        }
        while (!stack.isEmpty()){
            if (head.value != stack.pop()){
                return false;
            }
            head = head.next;
        }
        return true;
    }


    //快慢指针+反转链表，空间复杂度O(1)
    public static boolean isPalindromeReverse(Node head){
        if (head == null || head.next == null){
            return true;
        }
        Node n1 = head;
        Node n2 = head;

        while (n2.next != null && n2.next.next != null){
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = n1.next;
        Node n3 = null;
        n1.next = null;
        while (n2 != null){
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n2 = head;
        n3 = n1;
        boolean res = true;
        while(n1 != null && n2 != null){
            if (n1.value != n2.value){
                res = false;
                return res;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        n2 = n3.next;
        n3.next = null;
        while (n2 != null){
            n1 = n2.next;
            n2.next = n3;
            n3 = n2;
            n2 = n1;
        }
        return res;
    }




    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(2);
        head1.next.next.next = new Node(2);
        head1.next.next.next.next = new Node(1);

        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(1);

        System.out.println(isPalindromeReverse(head1));
        System.out.println(isPalindromeReverse(head2));
    }

}
