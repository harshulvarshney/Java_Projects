package tree.lca;

import graph.Graph;

import java.util.Arrays;

/**

 * RMQ method can answer LCA question in O(1) time but it need O(n log n) time in preprocessing
 * because it uses sparse table data structure
 *
 *
 * precondition:
 *      tree must be rooted
 *      all nodes must be indexed
 *
 * This works for n-array tree
 *
 * Time Complexity : O(1)
 * Space Complexity: O(n log n)
 * pre-processing  : O(n log n)
 *
 * Algo:
 *      1- initialize nodes and depth arrays of size 2n-1
 *      2- run dfs and fill the arrays
 *      3- prepare sparse table for depth array
 *
 */
public class LCA_RMQ {

    public static void main(String[] args) {
        int n = 7;
        Graph graph = new Graph(7);

        graph.add(0, 1, 0);
        graph.add(0, 2, 0);

        graph.add(1, 3, 0);

        graph.add(2, 4, 0);
        graph.add(2, 5, 0);

        graph.add(4, 6, 0);

        graph.print();

        preprocess(graph);

        int lca = findLca(4, 5);
        System.out.println("LCA :: " + lca);
    }

    private static int findLca(int a, int b) {
        int last1 = last[a];
        int last2 = last[b];
        int l = Math.min(last1, last2);
        int r = Math.max(last1, last2);

        int p = (int)(Math.log(depth.length)/Math.log(2));
        int k = 1 << p;
        int indexOfMin = -1;
        if(dp[p-1][l] <= dp[p-1][r-k+1])
            indexOfMin = l;
        else
            indexOfMin = r;

        return nodes[indexOfMin];
    }

    static int[] nodes;//stores each node's index as we traverse the tree
    static int[] depth;//stores each node's depth as we traverse the tree
    static int[] last; //saving last index when a node was visited
    static int index = 0;
    private static void preprocess(Graph graph) {
        nodes = new int[2* graph.vertices()-1];
        depth = new int[2* graph.vertices()-1];
        last = new int[graph.vertices()];

        dfs(graph, 0, 0);

        System.out.println("nodes: " + Arrays.toString(nodes));
        System.out.println("depth: " + Arrays.toString(depth));
        System.out.println("last : " + Arrays.toString(last));

        //prepare sparse table for depth array
        sparseTable();
        System.out.println("DP :: " + Arrays.deepToString(dp));
    }

    static int[][] dp;
    private static void sparseTable() {
        int p = (int)(Math.log(depth.length)/Math.log(2));
        dp = new int[p+1][depth.length];

        for(int i=0 ; i<dp[0].length; i++) dp[0][i] = depth[i];

        for(int i=1; i<=p; i++) {
            for(int j=0; j+(1 << i)<= depth.length; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j + (1 << (i-1))]);
            }
        }
    }

    private static void dfs(Graph graph, int at, int depth) {

        visit(at, depth);
        for(Graph.Edge edge: graph.getNeighboursForVertex(at)) {
            dfs(graph, edge.to, depth+1);
            visit(at, depth);
        }

    }

    private static void visit(int at, int depth) {
        nodes[index] = at;
        LCA_RMQ.depth[index] = depth;
        last[at] = index;
        index++;
    }

}
