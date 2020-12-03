package graph.unweighted.problems;

import graph.GraphAsMap;

import java.util.*;

public class Sample {

    public static void main(String[] args) {
        Map<Integer, List<GraphAsMap.Edge>> graph = GraphAsMap.getUndirectedAndUnweightedGraph();
        boolean[] visited = new boolean[graph.size()];
    }
}
