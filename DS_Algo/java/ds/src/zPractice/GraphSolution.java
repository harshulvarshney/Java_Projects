package zPractice;


import java.util.*;

public class GraphSolution {

    public static void main(String[] args) {
        int v = 6;
        /*graph = new HashMap<>();
        for(int i=0; i<v; i++) {
            graph.put(i, new LinkedList<>());
        }

        graph.get(0).add(new Edge(0, 1, 4));
        graph.get(0).add(new Edge(0, 2, 3));

        graph.get(1).add(new Edge(1, 3, 3));
        graph.get(1).add(new Edge(1, 2, 1));

        graph.get(2).add(new Edge(2, 3, 1));
        graph.get(2).add(new Edge(2, 4, 3));

        graph.get(3).add(new Edge(3, 5, 2));
        graph.get(4).add(new Edge(4, 5, 6));*/

        int[][] graph = {{3,4,5}, {3,2,6}, {2,2,1}};

        int[][] g = new int[][] {{0,1,1}, {1,2,1}, {0,2,5}, {2,3,1}};
        int src = 0;
        int dst = 3;
        System.out.println(findCheapestPrice(3, g, src, dst, 1));
    }

    static Map<Integer, List<Edge>> graph;
    static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int _from, int _to, int _weight) {
            this.from = _from;
            this.to = _to;
            this.weight = _weight;
        }
        public Edge(int _from, int _to) {
            this.from = _from;
            this.to = _to;
            this.weight = 0;
        }


        @Override
        public String toString() {
            return "-->"+to+"";
        }
    }

    static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        graph = new HashMap<>();
        for(int i=0; i<n; i++) {
            graph.put(i, new LinkedList<>());
        }

        for(int[] p: flights) {
            graph.get(p[0]).add(new Edge(p[0], p[1], p[2]));
        }

        boolean[] visited = new boolean[n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {src, 0});
        visited[src] = true;
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty() && k>=0) {
            int[] polled = q.poll();
            k--;
            int v = polled[0];
            int costTillhere = polled[1];

            for(Edge e: graph.get(v)) {
//                if(!visited[e.to]) {
//                    visited[e.to] = true;
                    q.offer(new int[] {e.to, e.weight+costTillhere});
//                }
                if(e.to == dst) {
                    min = Math.min(e.weight+costTillhere, min);
                }
            }
        }

        return min;
    }


}
