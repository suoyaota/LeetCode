package practice.solution.P600;

/**
 * @Author William Wang
 */
public class P677 {
    /**
     * 注意基本类型的传值是其拷贝。
     */
    class MapSum {

        private final Node root = new Node();

        /**
         * Initialize your data structure here.
         */
        public MapSum() {

        }

        private int indexForChar(char c) {
            return c - 'a';
        }

        public void insert(String key, int val) {
            insert(key, val, root);
        }

        private void insert(String key, int val, Node node) {
            if (key.length() == 0) {
                // node.isLeaf = true;
                node.val = val;
                return;
            }
            int index = indexForChar(key.charAt(0));
            if (node.childs[index] == null) {
                node.childs[index] = new Node();
            }
            insert(key.substring(1), val, node.childs[index]);
        }

        public int sum(String prefix) {
            Node prefixRoot = getPrefixRoot(prefix, root);
            return sum(prefixRoot);
        }

        private Node getPrefixRoot(String prefix, Node node) {
            if (node == null) {
                return null;
            }
            if (prefix.length() == 0) {
                return node;
            }
            int index = indexForChar(prefix.charAt(0));
            return getPrefixRoot(prefix.substring(1), node.childs[index]);
        }

        private int sum(Node node) {
            if (node == null) {
                return 0;
            }
            int ans = node.val;
            for (int i = 0; i < 26; i++) {
                ans += sum(node.childs[i]);
            }
            return ans;
        }

        private class Node {
            Node[] childs = new Node[26];
            int val;
            // boolean isLeaf;
        }
    }

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
}
