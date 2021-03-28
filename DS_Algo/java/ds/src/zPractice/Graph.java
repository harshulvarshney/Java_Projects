package zPractice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {

    private static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.weight = w;
        }
    }

    private final Map<Integer, List<Edge>> map;

    public Graph(int v) {
        map = new HashMap<>(v);
        for(int i=0; i<v; i++) {
            map.put(i, new LinkedList<>());
        }
    }

    public void add(int from, int to, int weight) {
        map.get(from).add(new Edge(from, to, weight));
    }

    public void add(int from, int to) {
        map.get(from).add(new Edge(from, to, 0));
    }

    public List<Edge> getNeighbours(int node) {
        return map.get(node);
    }

}
