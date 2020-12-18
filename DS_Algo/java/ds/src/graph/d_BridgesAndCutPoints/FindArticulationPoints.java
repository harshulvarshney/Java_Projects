package graph.d_BridgesAndCutPoints;

import graph.Graph;

import java.util.HashSet;
import java.util.Set;

/**
 * The algo to find bridges is modifies to find articulation points
 *
 * A node is an articulation point if:
 *      1- its root of dfs and num-of-outgoing-edges > 1
 *      2- its not root of dfs and id of node <= loe-link value to any of the adjacent node i.e. id[at] <= low[to]
 *
 * Time Complexity: O(V+E)
 */
public class FindArticulationPoints {

    public static void main(String[] args) {
        Graph g = FindBridges.getUndirectedGraph();
        findCutPoints(g);
        System.out.println(cutPoints);
    }

    private static int[] ids;
    private static int[] low;
    private static int id;
    private static boolean[] visited;
    private static Set<Integer> cutPoints;
    private static int numOfOutgoingEdge;

    private static void findCutPoints(Graph graph) {

        ids = new int[graph.vertices()];
        low = new int[graph.vertices()];
        visited = new boolean[graph.vertices()];
        id = 0;
        cutPoints = new HashSet<>();

        for(int i=0; i< graph.vertices(); i++) {
            numOfOutgoingEdge = 0;
            if(!visited[i]) {
                dfs(i, i, -1, graph);
                if(numOfOutgoingEdge > 1) {
                    cutPoints.add(i);
                }
            }
        }
    }

    private static void dfs(int root, int at, int parent, Graph graph) {

        if(root == parent) numOfOutgoingEdge++;

        visited[at] = true;
        ids[at] = low[at] = id++;

        for(Graph.Edge edge: graph.getNeighboursForVertex(at)) {

            //This check is required to avoid visiting parent node again in undirected graph
            if(edge.to == parent) continue;

            if(!visited[edge.to]) {
                dfs(root, edge.to, at, graph);
                low[at] = Math.min(low[at], low[edge.to]);
                if(ids[at] <= low[edge.to]) {
                    cutPoints.add(at);
                }
            }
            else {
                low[at] = Math.min(low[at], ids[edge.to]);
            }
        }

    }
}
