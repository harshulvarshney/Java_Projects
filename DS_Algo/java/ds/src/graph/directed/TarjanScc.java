package graph.directed;

import graph.GraphAsMap;

import java.util.*;

/**
 * This is Tarjan's Algo for finding Strongly Connected Components
 * it is based on DFS
 *
 * Time Complexity: O(E+V)
 */
public class TarjanScc {

    private static Map<Integer, List<GraphAsMap.Edge>> graph;
    private static Stack<Integer> stack;
    private static boolean[] onStack;
    private static boolean[] visited;

    private static int[] ids;
    private static int[] low;//low-link values

    private static int id;

    private static void findScc() {

        for(int i=0; i< graph.size(); i++) {
            if(visited[i]) {
                continue;
            }
            dfs(i);
        }
    }

    private static void dfs(int at) {
        if(visited[at])
            return;

        stack.push(at);
        onStack[at] = true;
        ids[at] = low[at] = id++;
        visited[at] = true;
        for(GraphAsMap.Edge edge: graph.get(at)) {
            if(!visited[edge.to])
                dfs(edge.to);

            if(onStack[edge.to]) {
                low[at] = Math.min(low[at], low[edge.to]);
            }

        }

        if(ids[at] == low[at]) {
            //remove vertex from stack untill id == low
            while (!stack.isEmpty()) {
                int nodeFromStack = stack.pop();
                System.out.print(nodeFromStack + ", ");
                onStack[nodeFromStack] = false;
                if(ids[nodeFromStack] == low[nodeFromStack])
                    break;

            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        graph = getGraph();
        stack = new Stack<>();
        onStack = new boolean[graph.size()];
        visited = new boolean[graph.size()];
        ids = new int[graph.size()];
        low = new int[graph.size()];

        id = 0;
        findScc();
    }

    /**
     * <img src="./SccGraph.png">
     */
    private static Map<Integer, List<GraphAsMap.Edge>> getGraph() {
        int v = 8;
        Map<Integer, List<GraphAsMap.Edge>> graph = new HashMap<>();

        for(int i=0; i<v; i++) graph.put(i, new ArrayList<>());

        graph.get(0).add(new GraphAsMap.Edge(0, 1, 0));
        graph.get(1).add(new GraphAsMap.Edge(1, 2, 0));
        graph.get(2).add(new GraphAsMap.Edge(2, 0, 0));

        graph.get(3).add(new GraphAsMap.Edge(3, 4, 0));
        graph.get(3).add(new GraphAsMap.Edge(3, 7, 0));

        graph.get(4).add(new GraphAsMap.Edge(4, 5, 0));

        graph.get(5).add(new GraphAsMap.Edge(5, 0, 0));
        graph.get(5).add(new GraphAsMap.Edge(5, 6, 0));

        graph.get(6).add(new GraphAsMap.Edge(6, 0, 0));
        graph.get(6).add(new GraphAsMap.Edge(6, 2, 0));
        graph.get(6).add(new GraphAsMap.Edge(6, 4, 0));

        graph.get(7).add(new GraphAsMap.Edge(7, 3, 0));
        graph.get(7).add(new GraphAsMap.Edge(7, 5, 0));

        GraphAsMap.print(graph);
        return graph;
    }
}
