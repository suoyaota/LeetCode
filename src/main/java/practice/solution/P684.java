package practice.solution;

/**
 * @Author William Wang
 */
public class P684 {

    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;
        UF uf = new UF(N + 1);//如果没有冗余顶点比边多1
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (uf.connected(u, v)) {
                return edge;
            }
            uf.union(u, v);
        }
        return new int[]{-1, -1};
    }

    private class UF {
        private final int[] id;

        public UF(int N) {
            id = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = i;
            }
        }

        public int find(int p) {
            //quick find
            return id[p];
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) {
                return;
            }

            for (int i = 0; i < id.length; i++) {
                if (id[i] == pRoot) {
                    id[i] = qRoot;
                }
            }
        }
    }
}
