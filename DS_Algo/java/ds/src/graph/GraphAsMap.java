package graph;

import graph.weighted.WeightedGraph;

import java.util.*;
import java.util.stream.Collectors;

public class GraphAsMap {

    public static class Edge {
        public int from, to , weight;
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    /**
     * 	<img src="./unweighted/DAG.png">
     */
    public static Map<Integer, List<Edge>> getUnweightedDAG() {
        int vertices = 7;
        TreeMap<Integer, List<Edge>> graph = new TreeMap<>();

        graph.put(0, new LinkedList<>());
        graph.get(0).add(new Edge(0, 2, 0));

        graph.put(1, new LinkedList<>());
        graph.get(1).add(new Edge(1, 0, 0));
        graph.get(1).add(new Edge(1, 2, 0));
        graph.get(1).add(new Edge(1, 4, 0));
        graph.get(1).add(new Edge(1, 5, 0));

        graph.put(2, new LinkedList<>());
        graph.get(2).add(new Edge(2, 5, 0));

        graph.put(3, new LinkedList<>());
        graph.get(3).add(new Edge(3, 0, 0));
        graph.get(3).add(new Edge(3, 1, 0));

        graph.put(4, new LinkedList<>());
        graph.get(4).add(new Edge(4, 6, 0));

        graph.put(5, new LinkedList<>());
        graph.get(5).add(new Edge(5, 6, 0));

        graph.put(6, new LinkedList<>());

        print(graph);
        return graph;
    }

    public static Map<Integer, List<Edge>> getWeightedDAG() {
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

    public static void print(Map<Integer, List<Edge>> graph) {
        for(Map.Entry<Integer, List<Edge>> e: graph.entrySet()) {
            System.out.println(e.getKey() + ":" +
                    e.getValue().stream()
                            .map(edge -> edge.to)
                            .collect(Collectors.toList()));
        }
    }

    public static void dfs(Map<Integer, List<Edge>> graph, int s, boolean[] visited) {
        if(visited[s])
            return;

        visited[s] = true;
        System.out.print(s+", ");
        for(Edge edge: graph.get(s)) {
            if(!visited[edge.to]) {
                dfs(graph, edge.to, visited);
            }
        }
    }

    public static void bfs(Map<Integer, List<Edge>> graph, int s) {
        Queue<Integer> q = new  LinkedList();
        q.offer(s);
        boolean[] visited = new boolean[graph.size()];
        visited[s] = true;

        while(!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node+", ");
            for(Edge t: graph.get(node)) {
                if(!visited[t.to]) {
                    visited[t.to] = true;
                    q.offer(t.to);
                }
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Edge>> graph = getUnweightedDAG();
        GraphAsMap.print(getWeightedDAG());

        boolean[] visited = new boolean[graph.size()];
        bfs(graph, 3);
    }
}
