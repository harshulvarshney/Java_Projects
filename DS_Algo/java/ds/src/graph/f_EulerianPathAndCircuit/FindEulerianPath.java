package graph.f_EulerianPathAndCircuit;

import graph.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Time Complexity: O(E)
 */
public class FindEulerianPath {

    public static void main(String[] args) {
        Graph graph = getGraph();
        System.out.println(Arrays.toString(findPath(graph)));
    }

    static int[] in;
    static int[] out;
    static LinkedList<Integer> q;
    private static Integer[] findPath(Graph graph) {

        if(!isPathExist(graph))
            return null;

        q = new LinkedList<>();
        dfs(getStart(graph), graph);
        return q.toArray(Integer[]::new);
    }

    /**
     * modified dfs to find Eulerian Path
     */
    private static void dfs(int start, Graph graph) {
        while(out[start] != 0) {
            int next = graph.getNeighboursForVertex(start).get(--out[start]).to;
            dfs(next, graph);
        }
        q.addFirst(start);
    }

    /**
     * Circuit exist in Directed graph iff:
     *      All the nodes have equal in and out degree
     *
     * Circuit exist in un-Directed graph iff:
     *      All the nodes have even degree
     */
    private static boolean isCircuitExist(Graph graph) {

        return false;
    }

    /**
     * Path exist in Directed Graph iff:
     *      At most 1 most s.t. inDegree-outDegree=1 && At most 1 node s.t. outDegree-inDegree=1
     *      and all other nodes have same in and outDegree
     *
     * Path exist in un-Directed graph iff:
     *      Either all nodes have even degree or
     *      Exactly 2 nodes have odd degree and all other nodes with even degree
     */
    private static boolean isPathExist(Graph graph) {
        in = new int[graph.vertices()];
        out = new int[graph.vertices()];

        List<Graph.Edge> edges = graph.getAllEdges();
        for(Graph.Edge edge: edges) {
            in[edge.to] = ++in[edge.to];
            out[edge.from] = ++out[edge.from];
        }

        int startNodes = 0;
        int endNodes = 0;
        for(int i=0; i< graph.vertices(); i++) {
            if((in[i] - out[i] > 1) || (out[i] - in[i] > 1))
                return false;
            else if(in[i] - out[i] == 1)
                endNodes++;
            else if(out[i] - in[i] == 1)
                startNodes++;
        }

        return (startNodes == 0 && endNodes == 0) || (startNodes == 1 && endNodes == 1);
    }

    /**
     * To find Eulerial path we have to identify a node s.t.
     *      outDegree-inDegree = 1 OR
     *      outDegree > 0
     *
     * NOTE :: If we run dfs on incorrect start node then we will not be able to find the path.
     */
    private static int getStart(Graph graph) {
        int start = -1;
        for(int i=0; i< graph.vertices(); i++) {
            if(out[i] - in[i] == 1)
                return i;
            if(out[i] == in[i] && out[i]>0)
                start = i;
        }
        return start;
    }

    /**
     * <img src="./EulerianPathProblem.PNG">
     */
    private static Graph getGraph() {
        int v = 7;
        Graph graph = new Graph(v);

        graph.add(1, 2, 0);
        graph.add(1, 3, 0);

        graph.add(2, 2, 0);
        graph.add(2, 4, 0);
        graph.add(2, 4, 0);

        graph.add(3, 1, 0);
        graph.add(3, 2, 0);
        graph.add(3, 5, 0);

        graph.add(4, 3, 0);
        graph.add(4, 6, 0);

        graph.add(5, 6, 0);

        graph.add(6, 3, 0);

        graph.print();

        return graph;
    }
}
