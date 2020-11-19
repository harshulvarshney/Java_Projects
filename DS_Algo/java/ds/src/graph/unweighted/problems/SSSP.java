package graph.unweighted.problems;

import graph.GraphAsMap;

import java.util.*;

/**
 * In Single Source Shortest Path problem for un-weighted graph
 * we can assume that weight of each edge is 1
 *
 * remember>> for unweighted graph shortest path problem: user BFS
 */
public class SSSP {

    public void findSSSPUsingBFS(Map<Integer, List<GraphAsMap.Edge>> graph, int s) {

        Queue<Integer> q = new LinkedList();
        int[] distance = new int[graph.size()];
        int[] path = new int[graph.size()];
        for(int i=0; i< distance.length; i++) distance[i] = -1;
        distance[s] = 0;
        q.offer(s);

        while(!q.isEmpty()) {
            int temp = q.poll();
            for(GraphAsMap.Edge e: graph.get(temp)) {
                if(distance[e.to] == -1) {//each vertex is visited at most once
                    distance[e.to] = distance[temp] + 1;
                    path[e.to] = temp;
                    q.offer(e.to);
                }
            }
        }
        System.out.println("Dist Arr: " + Arrays.toString(distance));
        System.out.println("Path Arr: " + Arrays.toString(path));
    }

    public static void main(String[] args) {
        SSSP obj = new SSSP();
        obj.findSSSPUsingBFS(GraphAsMap.getUnweightedDAG(), 3);
    }
}
