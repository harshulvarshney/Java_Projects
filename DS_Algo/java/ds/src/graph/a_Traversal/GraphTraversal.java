package graph.a_Traversal;

import graph.Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * dfs and bfs works same for both Directed & Undirected graphs
 */
public class GraphTraversal {

    public static void main(String[] args) {
        int v = 6;
        Graph graph = new Graph(v);

        graph.add(0, 1, 0);
        graph.add(0, 5, 0);

        graph.add(1, 2, 0);

        graph.add(2, 3, 0);
        graph.add(2, 5, 0);

        graph.add(3, 4, 0);

        graph.add(4, 5, 0);

        graph.print();

        boolean[] visited = new boolean[v];

        /* DFS */
        for(int i= 0; i< graph.vertices(); i++) {
            if(!visited[i]) {
                System.out.println("DFS :: ");
                dfs(graph, i, visited);
                System.out.println();
                System.out.println("BSF :: ");
                bfs(graph, i);
                System.out.println();
            }
        }


        int[][] matrix = {{1,1,0}, {1,1,0}, {0,0,1}};
        System.out.println("find num of connected components");
        traversalOnMatrix(matrix);
    }

    private static void dfs(Graph graph, int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + ", ");
        for(Graph.Edge e: graph.getNeighboursForVertex(s)) {
            if(!visited[e.to]) {
                dfs(graph, e.to, visited);
            }
        }
    }


    public static void bfs(Graph graph, int s) {

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.vertices()];
        q.offer(s);
        visited[s] = true;

        while(!q.isEmpty()) {
            int t = q.poll();

            System.out.print(t + ", ");
            for(Graph.Edge edge: graph.getNeighboursForVertex(t)) {
                if(!visited[edge.to]) {
                    visited[edge.to] = true;
                    q.offer(edge.to);
                }
            }
        }

    }

    static void traversalOnMatrix(int[][] g) {
        int n = g.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                q.offer(i);
                while(!q.isEmpty()) {
                    Integer t = q.poll();
                    visited[t] = true;
                    for(int j=0; j<g[0].length; j++) {
                        if(g[i][j] == 1 && !visited[j]) {
                            q.offer(j);
                        }
                    }
                }
                count++;
            }
        }
        System.out.println(count);
    }

}
