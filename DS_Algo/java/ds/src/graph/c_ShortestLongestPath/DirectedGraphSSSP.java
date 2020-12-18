package graph.c_ShortestLongestPath;

import graph.Graph;
import graph.b_Sort.TopSort;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * All SSSP algos works for only DAG
 *
 * https://www.udemy.com/course/graph-theory-algorithms/learn/lecture/10794140#overview
 * Algo:
 *      run top sort and prepare a sorted array of vertices
 *      create a dist array and fill it with MAX values
 *      update dist for starting vertex to 0
 *      from starting vertex, visit each neighbour and update dist array for smaller values
 *
 * Imp :: This Algo can work even when edge weights is -ve
 *
 * Time Complexity: O(E + V)
 *
 * NOTE: O(log n) is better then O(n)
 */
public class DirectedGraphSSSP {

    public static void main(String[] args) {
        Graph g = getDag();
        Integer[] dist = findSssp(g, 0);
        System.out.println("vertices :: " + g.getAllEdges().stream().map(e -> e.from).collect(Collectors.toSet()));
        System.out.println("Distances:: " + Arrays.toString(dist));
    }

    private static Integer[] findSssp(Graph g, int source){

        int[] sorted = TopSort.sort(g, source);
        //System.out.println("Sorted :: " + Arrays.toString(sorted));

        Integer[] dist = new Integer[g.vertices()];
        for(int i=0; i<g.vertices(); i++) dist[i] = Integer.MAX_VALUE;
        dist[source] = 0;

        for(int i=0; i<g.vertices(); i++) {
            int v = sorted[i];
            for(Graph.Edge e: g.getNeighboursForVertex(v)) {
                int newDist = dist[v] + e.weight;
                if(newDist < dist[e.to]) {
                    dist[e.to] = newDist;
                }
            }
        }
        return dist;
    }

    /**
     * <img src="./SSSP_DAG.PNG">
     */
    private static Graph getDag() {
        int v = 8;
        Graph graph = new Graph(v);

        graph.add(0, 1, 3);
        graph.add(0, 2, 6);

        graph.add(1, 2, 4);
        graph.add(1, 3, 4);
        graph.add(1, 4, 11);

        graph.add(2, 3, 6);
        graph.add(2, 6, 11);

        graph.add(3, 4, -4);
        graph.add(3, 5, 5);
        graph.add(3, 6, 2);

        graph.add(4, 7, 9);

        graph.add(5, 7, 1);

        graph.add(6, 7, 2);

        graph.print();
        return graph;
    }
}
