package graph.unweighted.problems;

import graph.unweighted.Graph;
import graph.unweighted.GraphNode;

import java.util.Arrays;
import java.util.Stack;

/**
 * this is also a DFS based solution, instead of {@link GraphNode} {@link Graph} is used here
 */
public class TopSortWithGraph {

    Stack<Integer> stack;
    boolean[] visited;
    /**
     * input graph must be acyclic
     */
    public int[] sort(Graph g, int node) {
        visited = new boolean[g.vertices];
        sortUtil(g, node);
        int[] sorted  = new int[g.vertices];
        int i = 0;
        while(!stack.isEmpty()) {
            sorted[i++] = stack.pop();
        }
        return sorted;
    }

    private void sortUtil(Graph g, int n) {
        visited[n] = true;
        for(int i: g.adjListArray[n]) {
            if(!visited[i]) {
                sortUtil(g, i);
            }
        }
        stack.push(n);
    }

    public static void main(String[] args) {
        Graph g = Graph.getDAG();
        TopSortWithGraph obj = new TopSortWithGraph();
        obj.stack = new Stack<>();

        System.out.println(Arrays.toString(obj.sort(g, 4)));

    }


}
