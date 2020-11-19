package graph.weighted;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph {

    public static class Edge {
        public int from, to, weight;

        public Edge(int f, int t, int w) {
            from = f;
            to = t;
            weight = w;
        }
    }

    /**
     * <img src="./WeightedDAG.PNG">
     */
    public static Map<Integer, List<Edge>> getDAG() {
        // Graph setup
        final int N = 6;
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) graph.put(i, new ArrayList<>());
        graph.get(0).add(new Edge(0, 1, 4));
        graph.get(0).add(new Edge(0, 2, 3));

        graph.get(1).add(new Edge(1, 3, 3));
        graph.get(1).add(new Edge(1, 2, 1));

        graph.get(2).add(new Edge(2, 3, 1));
        graph.get(2).add(new Edge(2, 4, 3));

        graph.get(3).add(new Edge(3, 5, 2));

        graph.get(4).add(new Edge(4, 5, 6));

        return graph;
    }

}
