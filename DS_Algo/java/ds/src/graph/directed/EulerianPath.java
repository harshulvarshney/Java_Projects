package graph.directed;

import graph.GraphAsMap;

import java.util.*;
import java.util.stream.Collectors;

/**
 * For a directed graph to have Eulerian path:
 *      At most 1 vertex s.t. out-degree - in-degree = 1
 *      At most 1 vertex s.t. in-degree - out-degree = 1
 *      all other vertices must have same in and out degree
 *
 *
 * Time Complexity: O(E+V)
 */
public class EulerianPath {

    static int[] inDegree = null;
    static int[] outDegree = null;
    static Map<Integer, List<GraphAsMap.Edge>> graph;
    static LinkedList<Integer> path;
    static List<GraphAsMap.Edge> edges;

    public static void findEulerianPath() {
        findDegree();

        if(!eulerianPathExist()) {
            System.out.println("Eulerian Path does not exist");
            return;
        }

        dfs(findStartNode());

        if(path.size() > 0 && path.size() == edges.size()+1)
            System.out.println("Eulerian Path: " + Arrays.toString(path.toArray()));
    }

    private static void dfs(int s) {

        while(outDegree[s] != 0) {
            GraphAsMap.Edge nextEdge = graph.get(s).get(--outDegree[s]);
            dfs(nextEdge.to);
        }

        path.addFirst(s);
    }

    /**
     * if there exist a vertex s.t. out-degree - in-degree = 1 --. this will be starting point else
     * just return any vertex with an out going edge i.e. out-degree > 0
     */
    private static int findStartNode() {
        int start = 0;
        for(int i=0; i< graph.size(); i++) {
            if(outDegree[i] - inDegree[i] == 1)
                return i;
            if(outDegree[i] > 0)
                start = i;
        }
        return start;
    }

    private static boolean eulerianPathExist() {
        int startNode = 0;
        int endNode = 0;
        for(int i=0; i< graph.size(); i++) {
            if(inDegree[i] - outDegree[i] == 1)
                endNode++;
            else if(outDegree[i] - inDegree[i] == 1)
                startNode++;
            else if(inDegree[i] != outDegree[i])
                return false;
        }

        return (startNode == 1 && endNode == 1) || (endNode == 0 && startNode == 0);
    }

    private static void findDegree() {
        outDegree = new int[graph.size()];
        inDegree = new int[graph.size()];

        for(GraphAsMap.Edge edge : edges) {
            inDegree[edge.to] = inDegree[edge.to] + 1;
            outDegree[edge.from] = outDegree[edge.from] + 1;
        }

        System.out.println("outDegree: " + Arrays.toString(outDegree));
        System.out.println("inDegree : " + Arrays.toString(inDegree));
    }

    public static void main(String[] args) {
        graph = getGraph();
        inDegree = null;
        outDegree = null;
        path = new LinkedList<>();
        edges = graph.values().stream().flatMap(List::stream).collect(Collectors.toList());
        findEulerianPath();
    }

    /**
     * <img src="./EulerianPathProblem.png">
     *
     * This graph does not hv Eulerian Circuit because in and out degree is not same for all vertices.
     */
    private static Map<Integer, List<GraphAsMap.Edge>> getGraph() {
        int v = 7;
        Map<Integer, List<GraphAsMap.Edge>> graph = new HashMap<>();

        for(int i=0; i<v; i++) graph.put(i, new ArrayList<>());

        graph.get(1).add(new GraphAsMap.Edge(1, 2, 0));
        graph.get(1).add(new GraphAsMap.Edge(1, 3, 0));

        graph.get(2).add(new GraphAsMap.Edge(2, 2, 0));
        graph.get(2).add(new GraphAsMap.Edge(2, 4, 0));
        graph.get(2).add(new GraphAsMap.Edge(2, 4, 0));

        graph.get(3).add(new GraphAsMap.Edge(3, 1, 0));
        graph.get(3).add(new GraphAsMap.Edge(3, 2, 0));
        graph.get(3).add(new GraphAsMap.Edge(3, 5, 0));

        graph.get(4).add(new GraphAsMap.Edge(4, 3, 0));
        graph.get(4).add(new GraphAsMap.Edge(4, 6, 0));

        graph.get(5).add(new GraphAsMap.Edge(5, 6, 0));

        graph.get(6).add(new GraphAsMap.Edge(6, 3, 0));

        GraphAsMap.print(graph);
        return graph;
    }
}
