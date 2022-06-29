package tree;

public class TrieTree {
    public static class TrieNode{
        private int end;
        private int path;
        private TrieNode[] nexts;

        //初始化TrieNode，提前初始化好下一个节点的26个可能性
        public TrieNode(){
            end = 0;
            path = 0;
            nexts = new TrieNode[26];
        }
    }

    public static class Trie{
        private TrieNode root;

        public Trie(){
            root = new TrieNode();
        }

        public void insert(String str){
            if (str == null){
                return;
            }
            TrieNode node = root;
            char[] words = str.toCharArray();
            for (char word : words){
                int index = word - 'a';
                if (node.nexts[index] != null){
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.path++;
            }
            node.end++;
        }

        public int search(String str){
            if (str == null){
                return 0;
            }
            TrieNode node = root;
            char[] words = str.toCharArray();
            for (char word : words){
                int index = word - 'a';
                if (node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        public int preNum(String pre){
            if (pre == null){
                return 0;
            }
            TrieNode node = root;
            char[] words = pre.toCharArray();
            for (char word : words){
                int index = word - 'a';
                if (node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.path;
        }

        public void delete(String str){
            if (str == null){
                return;
            }
            char[] words = str.toCharArray();
            TrieNode node = root;
            for (char word : words){
                int index = word - 'a';
                if (--node.nexts[index].path == 0){
                    node.nexts[index] = null;
                    return;
                }
                node = node.nexts[index];
            }
            node.end--;
        }
    }
}
