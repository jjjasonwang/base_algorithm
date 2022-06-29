package hash;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class UnionFind {
    private static class Node{
        //任意定义
    }

    //child - father
    private HashMap<Node,Node> fatherMap;

    private HashMap<Node,Integer> sizeMap;

    public UnionFind(List<Node> nodes){
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
        for (Node node : nodes){
            fatherMap.put(node,node);
            sizeMap.put(node,1);
        }
    }

    //每次查找头节点，将参数节点到头节点的链上的所有节点直连头节点
    private Node findHead(Node node){
        Node father = fatherMap.get(node);
        if (father != node){
            father = findHead(father);
        }
        fatherMap.put(node,father);
        return father;
    }

    public Node NoRecurFindHead(Node node){
        Stack<Node> stack = new Stack<>();
        Node cur = node;
        Node father = fatherMap.get(cur);
        while (cur != father){
            stack.push(cur);
            cur = father;
            father = fatherMap.get(cur);
        }
        while (!stack.isEmpty()){
            fatherMap.put(stack.pop(),cur);
        }
        return cur;
    }

    public boolean isSameSet(Node a, Node b){
        return findHead(a) == findHead(b);
    }

    public void union(Node a, Node b){
        if (a == b || a == null || b == null){
            return;
        }
        Node AHead = findHead(a);
        Node BHead = findHead(b);
        if (AHead == BHead){
            return;
        }
        int ASize = sizeMap.get(a);
        int BSize = sizeMap.get(b);
        if (ASize >= BSize){
            fatherMap.put(BHead,AHead);
            sizeMap.put(AHead,ASize + BSize);
        }else {
            fatherMap.put(AHead,BHead);
            sizeMap.put(AHead,ASize + BSize);
        }
    }
}
