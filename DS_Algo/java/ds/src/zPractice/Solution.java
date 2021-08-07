package zPractice;


import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /*Node x = new Node(1);
        x.next = new Node(2);
        x.next.next = new Node(3);
        x.next.next.next = new Node(4);
        x.next.next.next.next = new Node(5);
        x.next.next.next.next.next = new Node(6);*/


        int [] arr = {5, 1, 4, 2, 3};

        sol();
    }

    static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int _from, int _to, int _weight) {
            this.from = _from;
            this.to = _to;
            this.weight = _weight;
        }

        @Override
        public String toString() {
            return "-->"+to+"";
        }
    }

    static Map<Integer, List<Edge>> graph;

    static void sol() {
        int v = 6;
        graph = new HashMap<>();
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
        graph.get(4).add(new Edge(4, 5, 6));

        boolean[] visited = new boolean[v];
        /*for(int i=0; i<v; i++) {
            if(!visited[i])
                dfs(graph, i, visited);
        }*/

        //dfsIterative(graph, 0);

        bfs(graph, 0);
    }

    static int[] topSort(int n, int[][] c) {
        
    }


}
