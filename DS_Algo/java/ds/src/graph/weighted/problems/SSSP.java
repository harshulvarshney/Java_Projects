package graph.weighted.problems;

import graph.weighted.WeightedGraph;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * SSSP = Single Source Shortest Path
 * find the shortest path from a source to all the other nodes
 *
 * this solution is based on top sort.
 *
 */
public class SSSP {

    public Integer[] getPath(Map<Integer, List<WeightedGraph.Edge>> g, int source) {

        TopSort topSort = new TopSort();
        int[] sorted = topSort.getSortedArray(g);//get the graph nodes top sorted
        System.out.println(Arrays.toString(sorted));

        //initialize an array to keep track of min distances from source node
        Integer[] dist = new Integer[g.size()];
        dist[source] = 0;

        for(int i=0; i<g.size(); i++) {
            int node = sorted[i];
            List<WeightedGraph.Edge> neighbours = g.get(node);
            if(neighbours != null) {
                for (WeightedGraph.Edge neighbour : neighbours) {
                    int newDist = dist[node] + neighbour.weight;
                    if(dist[neighbour.to] == null)//equivalent to infinite
                        dist[neighbour.to] = newDist;
                    else if (newDist < dist[neighbour.to]) {
                        dist[neighbour.to] = newDist;
                    }
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        SSSP obj = new SSSP();
        System.out.println("below distance is in sequence 0 to 5, not as per sorted order");
        System.out.println(Arrays.toString(obj.getPath(WeightedGraph.getDAG(), 0)));
    }
}
