package graph.weighted.problems;

import graph.GraphAsMap;

import java.util.*;

/**
 * This algo is
 *      used to find shortest path from 1 vertex to every other vertex
 *      can NOT be used if graph has -ve weights
 *      uses a Priority Queue to store unvisited vertices by distance s from source
 *      it uses greedy method, always picks the next closest vertex from source
 *      graph must not have cycle.
 *
 * Time Complexity: O(E * log V)
 */
public class DijkstraSSSP {

    public static void main(String[] args) {
        DijkstraSSSP obj = new DijkstraSSSP();
        obj.findDistances(GraphAsMap.getWeightedDAG(), 0);
    }

    public void findDistances(Map<Integer, List<GraphAsMap.Edge>> graph, int s) {
        int[] dist = new int[graph.size()];
        for(int i=0; i< graph.size(); i++) dist[i] = -1;
        dist[s] = 0;

        int[] path = new int[graph.size()];

        Queue<Entry> pq = new PriorityQueue<>();
        pq.offer(new Entry(s, 0));

        boolean[] visited = new boolean[graph.size()];

        while(!pq.isEmpty()) {
            Entry entry = pq.poll();
            int v = entry.v;

            //Since we fetch the closest vertex from queue every time
            //we can mark this visited to avoid processing it again
            visited[v] = true;

            for(GraphAsMap.Edge edge: graph.get(v)) {
                if(visited[edge.to])
                    continue;
                int newDist = entry.distance + edge.weight;
                if(newDist < dist[edge.to] || dist[edge.to] == -1) {
                    path[edge.to] = edge.from;
                    dist[edge.to] = newDist;
                    pq.offer(new Entry(edge.to, newDist));
                }
            }
        }

        System.out.println("PATH: " + Arrays.toString(path));
        System.out.println("DIST: " + Arrays.toString(dist));
    }

    public class Entry implements Comparable<Entry> {
        int v;
        Integer distance;

        public Entry(int v, int distance) {
            this.v = v;
            this.distance = distance;
        }

        @Override
        public int compareTo(Entry o) {
            return this.distance.compareTo(o.distance);
        }

        @Override
        public String toString() {
            return "("+v+","+distance+")";
        }
    }
}
