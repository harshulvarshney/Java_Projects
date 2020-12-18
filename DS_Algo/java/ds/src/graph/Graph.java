package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author harshul.varshney
 */
public class Graph {

    private final Map<Integer, List<Edge>> map;

    public static class Edge {
        public int from;
        public int to;
        public int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public String toString() {
            return from + "->" + to + " | " + weight;
        }

    }

    public Graph(int vertices) {
        map = new HashMap<>(vertices);
        for(int i=0; i<vertices; i++) map.put(i, new LinkedList<>());
    }

    public void add(int from, int to, int weight) {
        this.map.get(from).add(new Edge(from, to, weight));
    }

    public List<Edge> getNeighboursForVertex(int s) {
        return map.get(s);
    }

    public int vertices() {
        return map.size();
    }

    public List<Edge> getAllEdges() {
        return this.map.values().stream().flatMap(List::stream).collect(Collectors.toList());
    }

    public void print() {
        for(Map.Entry<Integer, List<Edge>> e: map.entrySet()) {
            System.out.print(e.getKey() + " | ");
            e.getValue().forEach(edge -> System.out.print("(" + edge.to + "," + edge.weight + ")"));
            System.out.println();
        }
    }

}
