package practice.solution;

import org.springframework.stereotype.Component;

/**
 * @Author William Wang
 */
@Component
public class P208 {
    class Trie {

        private final Node root = new Node();

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            //无参构造方法
        }

        private int indexForChar(char c) {
            //返回这个字母应在的节点数组下标，注意输入限定了a-z
            return c - 'a';
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            insert(word, root);
        }

        private void insert(String word, Node node) {
            if (word.length() == 0) {
                node.isLeaf = true;
                return;
            }
            int index = indexForChar(word.charAt(0));
            if (node.childs[index] == null) {
                node.childs[index] = new Node();
            }
            insert(word.substring(1), node.childs[index]);
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            return search(word, root);
        }

        private boolean search(String word, Node node) {
            if (node == null) {
                return false;
            }
            if (word.length() == 0) {
                return node.isLeaf;
            }
            int index = indexForChar(word.charAt(0));
            return search(word.substring(1), node.childs[index]);
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return startsWith(prefix, root);
        }

        private boolean startsWith(String prefix, Node node) {
            if (node == null) {
                return false;
            }
            if (prefix.length() == 0) {
                return true;
            }
            int index = indexForChar(prefix.charAt(0));
            return startsWith(prefix.substring(1), node.childs[index]);
        }

        private class Node {
            //每个字母下都可能延伸出26个字母
            Node[] childs = new Node[26];
            //isLeaf为true代表到此为止是一个单词。
            boolean isLeaf;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
