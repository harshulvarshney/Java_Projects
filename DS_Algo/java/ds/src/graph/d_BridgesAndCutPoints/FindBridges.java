package graph.d_BridgesAndCutPoints;

import graph.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Bridge:                 An edge whose removal will increase the connected components in graph
 * Articulation/Cut point: A vertex whose removal will increase the connected components in graph
 *
 * This problem is for both; directed and undirected graphs
 *
 * low-link: the low-link value of a node is defined as the smallest/lowest node id reachable from that node
 *           when doing a dfs.
 *
 * NOTE: low-link values depends on which node was the root node of dfs
 *       i.e. if we start dfs on a different node, low-link values will also change
 *
 * Condition of a bridge: if id[at] < low[to] ==> this edge is a bridge
 *
 * Time Complexity: O(V+E)
 *
 *
 * Use case:
 *      finding bottlenecks
 *
 */
public class FindBridges {

    public static void main(String[] args) {
        Graph graph = getUndirectedGraph();
        System.out.println("Bridges :: " + bridges(graph));
    }

    private static int[] ids;
    private static int[] low;
    private static int id;
    private static boolean[] visited;
    private static List<Integer> bridges(Graph graph) {
        List<Integer> bridges = new ArrayList<>();
        ids = new int[graph.vertices()];
        low = new int[graph.vertices()];
        id = 0;

        visited = new boolean[graph.vertices()];
        for(int i=0; i< graph.vertices(); i++) {
            if(!visited[i]) {
                dfs(i, -1, bridges, graph);
            }
        }

        return bridges;
    }

    private static void dfs(int at, int parent, List<Integer> bridges, Graph graph) {
        visited[at] = true;
        ids[at] = low[at] = id++;

        for(Graph.Edge edge: graph.getNeighboursForVertex(at)) {
            if(edge.to == parent) {
                //This check is required to avoid visiting parent node again
                //because in case of undirected graphs: if 0->1 is an edge then 1->0 will also be present
                //This check will make sure that at 1, we not visit 0 again
                continue;
            }
            if(!visited[edge.to]) {
                dfs(edge.to, at, bridges, graph);
                low[at] = Math.min(low[at], low[edge.to]);
                if(ids[at] < low[edge.to]) {
                    bridges.add(at);
                    bridges.add(edge.to);
                }
            }
            else {
                low[at] = Math.min(low[at], ids[edge.to]);
            }
        }
    }

    /**
     * <img src="./bridges.PNG">
     */
    public static Graph getUndirectedGraph() {
        int v = 5;
        Graph graph = new Graph(v);

        graph.add(0, 1, 0);
        graph.add(0, 2, 0);
        graph.add(0, 3, 0);

        graph.add(1, 0, 0);
        graph.add(1, 2, 0);

        graph.add(2, 1, 0);
        graph.add(2, 0, 0);

        graph.add(3, 0, 0);

        graph.add(3, 4, 0);

        graph.add(4, 3, 0);

        graph.print();

        return graph;
    }
}
