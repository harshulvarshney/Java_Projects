package graph.c_ShortestLongestPath;

import graph.Graph;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * This algo can find SSSP on DAG with no -ve edge.
 *
 * Time Complexity: O((E+V)log V), and in general E > V, therefore Time Complexity = O(E logV)
 * Time complexity can be improved to O(E + VlogV) when using a Fibonacci heap
 */
public class DirectedGraphSSSP_Dijkstra {

    public static void main(String[] args) {
        Graph g = getDag();
        Integer[] d = findSssp(g, 0);
        System.out.println("SSSP :: " + Arrays.toString(d));
    }

    private static Integer[] findSssp(Graph graph, int source) {
        Queue<Entry> pq = new PriorityQueue<>();

        boolean[] visited = new boolean[graph.vertices()];
        Integer[] dist = new Integer[graph.vertices()];
        for(int i=0; i< graph.vertices(); i++) dist[i] = Integer.MAX_VALUE;
        dist[source] = 0;

        pq.offer(new Entry(0, 0));

        while(!pq.isEmpty()) {
            Entry e = pq.poll();
            if(visited[e.v])
                continue;

            dist[e.v] = e.w;

            visited[e.v] = true;

            for(Graph.Edge edge: graph.getNeighboursForVertex(e.v)) {
                if(!visited[edge.to]) {
                    pq.offer(new Entry(edge.to, edge.weight + e.w));
                }
            }
        }

        return dist;
    }

    private static class Entry implements Comparable {
        public int v;
        public Integer w;
        Entry(int v, Integer w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public String toString() {
            return "(" + v + "," + w + ")";
        }

        @Override
        public int compareTo(Object o) {
            return w.compareTo(((Entry)o).w);
        }

        @Override
        public boolean equals(Object o) {
            return w.equals(((Entry)o).w);
        }
    }

    private static Graph getDag() {
        int v = 5;
        Graph graph = new Graph(v);

        graph.add(0, 1, 4);
        graph.add(0, 2, 1);

        graph.add(1, 3, 1);

        graph.add(2, 1, 2);
        graph.add(2, 3, 5);

        graph.add(3, 4, 3);

        graph.print();
        return graph;
    }
}
