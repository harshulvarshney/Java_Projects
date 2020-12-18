package graph.c_ShortestLongestPath;

import graph.Graph;

import java.util.Arrays;
import java.util.List;

/**
 * Time Complexity: O(EV)
 * Time complexity of Dijkstra's Algo is better
 *
 * https://www.udemy.com/course/graph-theory-algorithms/learn/lecture/10794146#notes
 *
 * but this algo is useful in finding if a graph has a -ve cycle.
 * NOTE: if a node has best cost of -ve infinity, then all the other nodes reachable by this node
 *       will also have best code of -ve infinity.
 *
 *
 * Algo:
 *      1- create a Dist array and fill it with +infinity
 *      2- set dist[source] = 0
 *      3- relax each edge v-1 time (get list of edges and process them one by one)
 *      we run the loops 2 times,
 *          on first time we update dist[] array with min values
 *          on second time if we find any better value then present in dist[] array, we update the dist with -ve infinity
 */
public class DirectedGrapgSSSP_BellmanFord {

    public static void main(String[] args) {
        Graph graph = getGrapgWithNegativeCycle();
        Double[] dist = getSssp(graph, 0);
        System.out.println(Arrays.toString(dist));
    }

    private static Double[] getSssp(Graph graph, int source) {
        Double[] dist = new Double[graph.vertices()];
        for(int i=0; i< graph.vertices(); i++) dist[i] = Double.POSITIVE_INFINITY;

        dist[source] = 0d;

        // Only in the worst case does it take V-1 iterations for the Bellman-Ford
        // algorithm to complete. Another stopping condition is when we're unable to
        // relax an edge, this means we have reached the optimal solution early.
        boolean relaxedAnEdge = true;
        List<Graph.Edge> edges = graph.getAllEdges();
        for(int i=0; i< graph.vertices()-1 && relaxedAnEdge; i++) {
            relaxedAnEdge = false;
            for(Graph.Edge edge: edges) {
                Double newDist = dist[edge.from] + edge.weight;
                if(newDist < dist[edge.to]) {
                    dist[edge.to] = newDist;
                    relaxedAnEdge = true;
                }
            }
        }

        // Only in the worst case does it take V-1 iterations for the Bellman-Ford
        // algorithm to complete. Another stopping condition is when we're unable to
        // relax an edge, this means we have reached the optimal solution early.
        relaxedAnEdge = true;

        for(int i=0; i< graph.vertices()-1 && relaxedAnEdge; i++) {
            relaxedAnEdge = false;
            for(Graph.Edge edge: edges) {
                Double newDist = dist[edge.from] + edge.weight;
                if(newDist < dist[edge.to]) {
                    dist[edge.to] = Double.NEGATIVE_INFINITY;
                    relaxedAnEdge = true;
                }
            }
        }

        return dist;
    }

    /**
     * <img src="./BF_NegativeCycle.PNG">
     */
    private static Graph getGrapgWithNegativeCycle() {
        int v = 7;
        Graph graph = new Graph(v);

        graph.add(0, 1, 1);
        graph.add(0, 2, 1);

        graph.add(1, 3, 4);

        graph.add(2, 1, 1);

        graph.add(3, 2, -6);
        graph.add(3, 4, 1);
        graph.add(3, 5, 1);

        graph.add(4, 6, 1);
        graph.add(4, 5, 1);

        graph.add(5, 6, 1);

        graph.print();
        return graph;
    }

}
