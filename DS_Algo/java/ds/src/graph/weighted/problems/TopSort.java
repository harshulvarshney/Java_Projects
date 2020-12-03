package graph.weighted.problems;

import graph.weighted.WeightedGraph;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
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

    Stack<Integer> stack = new Stack<>();

    private void sort(Map<Integer, List<WeightedGraph.Edge>> g, boolean[] visited, int n) {
        visited[n] = true;
        for(WeightedGraph.Edge e: g.get(n)) {
            if(!visited[e.to]) {
                sort(g, visited, e.to);
            }
        }
        stack.push(n);
    }

    public int[] getSortedArray(Map<Integer, List<WeightedGraph.Edge>> graph) {
        boolean[] visited = new boolean[graph.size()];
        sort(graph, visited, 0);

        int[] resp = new int[graph.size()];
        int i=0;
        while(!stack.isEmpty()) {
            resp[i++] = stack.pop();
        }

        return resp;
    }

    public static void main(String[] args) {
        TopSort topSort = new TopSort();
        Map<Integer, List<WeightedGraph.Edge>> graph = WeightedGraph.getDAG();
        boolean[] visited = new boolean[graph.size()];
        topSort.sort(graph, visited, 0);
        while(!topSort.stack.isEmpty()) {
            System.out.print(topSort.stack.pop());
        }
    }

}
