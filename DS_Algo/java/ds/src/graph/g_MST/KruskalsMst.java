package graph.g_MST;

import disjoint_set.DisjointSets;
import graph.Graph;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Kruskal's algo is used to find Minimum Spanning Tree (MST) in weighted graph
 * It is based on union-find algo
 *
 * It has 3 main steps:
 *      1- sort all the edges in increasing edge weight
 *      2- pick an edge and unify them like below:
 *          if both vertex r part of 2 separate groups, combine the groups
 *          if any of the 2 vertex is part of a group, add second vertex to same group
 *          else create a group and add both vertices to it
 *
 *      3- continue untill all the edges or vertices are visited
 *
 * At the end, there will be only one group remaining, containing all the edges forming a MST
 */
public class KruskalsMst {

    public static void main(String[] args) {
        Graph graph = getGraph();
        findMst(graph);
    }

    private static void findMst(Graph graph) {
        List<Graph.Edge> edges = graph.getAllEdges();
        Comparator<Graph.Edge> comp = (o1, o2) -> {
          return ((Integer)o1.weight).compareTo(o2.weight);
        };

        edges.sort(comp);

        DisjointSets ds = new DisjointSets();
        for(int i=0; i< getGraph().vertices(); i++) ds.make(i);

        List<Graph.Edge> mst = new LinkedList<>();
        for(Graph.Edge edge: edges) {
            if(ds.union(edge.from, edge.to)) {
                mst.add(edge);
            }
            if(mst.size() == graph.vertices()-1)
                break;
        }

        System.out.println("MST :: " + mst);
    }

    /**
     * <img src="./MstExample.PNG">
     */
    public static Graph getGraph() {
        int v = 6;
        Graph graph = new Graph(v);

        graph.add(0, 1, 2);
        graph.add(0, 2, 5);
        graph.add(0, 3, 2);
        graph.add(0, 4, 3);

        graph.add(1, 0, 2);
        graph.add(1, 3, 0);

        graph.add(2, 0, 5);
        graph.add(2, 3, 1);
        graph.add(2, 4, 6);

        graph.add(3, 1, 0);
        graph.add(3, 0, 2);
        graph.add(3, 2, 1);
        graph.add(3, 4, 4);
        graph.add(3, 5, 8);

        graph.add(4, 0, 3);
        graph.add(4, 2, 6);
        graph.add(4, 3, 4);

        graph.add(5, 3, 8);

        graph.print();
        return graph;
    }
}
