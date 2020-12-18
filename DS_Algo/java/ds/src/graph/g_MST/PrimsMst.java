package graph.g_MST;

import graph.Graph;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * It's a greedy MST algo because it works by always selecting next edge with smallest weight
 * works well on dense graphs
 *
 * Time Complexity : O(E*log(E))
 *
 * Algo:
 *      put all the edges in a min PQ
 *      start with a vertex S, mark it visited and put all adjacent edges in PQ
 *      while PQ is not empty:
 *          deque the next cheapest edge
 *          if edge.to is visited, continue
 *          else mark edge.to visited and add it to MST
 *
 */
public class PrimsMst {

    public static void main(String[] args) {
        Graph graph = KruskalsMst.getGraph();
        findMst(graph);
    }

    private static void findMst(Graph graph) {
        Comparator<Graph.Edge> comp = (o1, o2) -> Integer.compare(o1.weight, o2.weight);

        PriorityQueue<Graph.Edge> pq = new PriorityQueue<>(comp);

        boolean[] visited = new boolean[graph.vertices()];
        addEdges(graph, 0, visited, pq);

        List<Graph.Edge> mst = new LinkedList<>();
        while(!pq.isEmpty() && mst.size() != graph.vertices()) {
            Graph.Edge edge = pq.poll();

            if(visited[edge.to]) continue;

            mst.add(edge);
            addEdges(graph, edge.to, visited, pq);
        }

        System.out.println("MST :: " + mst);
    }

    private static void addEdges(Graph graph, int start, boolean[] visited, PriorityQueue<Graph.Edge> pq) {
        visited[start] = true;
        for(Graph.Edge e: graph.getNeighboursForVertex(start)) {
            if(!visited[e.to]) {
                pq.offer(e);
            }
        }
    }
}
