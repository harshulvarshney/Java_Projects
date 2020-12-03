package graph.unweighted.problems;

import graph.GraphAsMap;

import java.util.List;
import java.util.Map;
import java.util.Stack;


/**
 * This is sorting algo for Directed Acyclic Graph.
 */
public class TopSort {

    private static Stack<Integer> stack;

    private static void sort(Map<Integer, List<GraphAsMap.Edge>> graph, boolean[] visited, int s) {
        visited[s] = true;
        for(GraphAsMap.Edge e: graph.get(s)) {
            if(!visited[e.to]) {
                sort(graph, visited, e.to);
            }
        }
        stack.push(s);
    }

    public int[] getSortedVertices(Map<Integer, List<GraphAsMap.Edge>> graph, int s) {
        stack = new Stack<>();
        boolean[] visited = new boolean[graph.size()];
        sort(graph, visited, s);

        int[] resp = new int[graph.size()];
        int i=0;
        while(!stack.isEmpty()) resp[i++] = stack.pop();

        return resp;
    }

    public static void main(String[] args) {
        Map<Integer, List<GraphAsMap.Edge>> graph = GraphAsMap.getUnweightedDAG();
        GraphAsMap.print(graph);

        stack = new Stack<>();
        boolean[] visited = new boolean[graph.size()];
        sort(graph, visited, 3);

        while(!stack.isEmpty()) {
            System.out.print(stack.pop()+", ");
        }
    }
}
