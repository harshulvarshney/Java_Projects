package graph.b_Sort;

import graph.Graph;

import java.util.Stack;

/**
 * This is sorting algo for Directed Acyclic Graph.
 * it doesn't need edge weights, its only a sorting algo.
 *
 * This algo DFS with an extra stack. So time complexity is the same as DFS which is: O(V+E)
 *
 * it uses a stack
 * node with outdegree 0 are pushed to stack
 * then we backtrack and check the previous node for outdegree
 */
public class TopSort {

    public static void main(String[] args) {
        int v = 6;
        Graph graph = new Graph(v);

        graph.add(0, 1, 0);
        graph.add(0, 2, 0);

        graph.add(1, 3, 0);
        graph.add(1, 2, 0);

        graph.add(2, 3, 0);
        graph.add(2, 4, 0);

        graph.add(3, 5, 0);

        graph.add(4, 5, 0);

        graph.print();

        sort(graph, 0);

    }

    /**
     * <img src="./WeightedDAG.PNG">
     */
    public static int[] sort(Graph graph, int s) {
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[graph.vertices()];
        dfs(graph, s, vis, stack);
        int[] sorted = new int[graph.vertices()];
        int i=0;
        while(!stack.isEmpty()) {
            int v = stack.pop();
            System.out.print(v + ", ");
            sorted[i++] = v;
        }
        return sorted;
    }

    private static void dfs(Graph graph, int s, boolean[] visited, Stack<Integer> stack) {
        for(Graph.Edge e: graph.getNeighboursForVertex(s)) {
            if(!visited[e.to]) {
                visited[e.to] = true;
                dfs(graph, e.to, visited, stack);
            }
        }
        stack.push(s);
    }
}
