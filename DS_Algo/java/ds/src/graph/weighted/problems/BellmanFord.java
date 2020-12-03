package graph.weighted.problems;

import graph.GraphAsMap;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Time Complexity: O((E+V)log V)
 */
public class BellmanFord {

    public static Double[] bellmanFord(Map<Integer, List<GraphAsMap.Edge>> graph, Integer s) {
        Double[] dist = new Double[graph.size()];
        Arrays.fill(dist, Double.POSITIVE_INFINITY);
        dist[s] = (double) 0;

        // Only in the worst case does it take V-1 iterations for the Bellman-Ford
        // algorithm to complete. Another stopping condition is when we're unable to
        // relax an edge, this means we have reached the optimal solution early.
        boolean relaxedAnEdge = true;
        List<GraphAsMap.Edge> edges = getEdges(graph);

        for(int i=0; i< graph.size()-1 && relaxedAnEdge; i++) {
            relaxedAnEdge = false;
            for(GraphAsMap.Edge edge: edges) {
                if(dist[edge.from] + edge.weight < dist[edge.to]) {
                    dist[edge.to] = dist[edge.from] + edge.weight;
                    relaxedAnEdge = true;
                }
            }

        }

        // Only in the worst case does it take V-1 iterations for the Bellman-Ford
        // algorithm to complete. Another stopping condition is when we're unable to
        // relax an edge, this means we have reached the optimal solution early.
        relaxedAnEdge = true;

        for(int i=0; i< graph.size()-1 && relaxedAnEdge; i++) {
            relaxedAnEdge = false;
            for(GraphAsMap.Edge edge: edges) {
                if(dist[edge.from] + edge.weight < dist[edge.to]) {
                    dist[edge.to] = Double.NEGATIVE_INFINITY;
                    relaxedAnEdge = true;
                }
            }

        }


        return dist;
    }

    private static List<GraphAsMap.Edge> getEdges(Map<Integer, List<GraphAsMap.Edge>> graph) {
        return graph.values().stream().flatMap(List::stream).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Double[] distArr = bellmanFord(GraphAsMap.getWeightedDAGWithNegativeEdge(), 0);
        System.out.println(Arrays.toString(distArr));
    }

}
