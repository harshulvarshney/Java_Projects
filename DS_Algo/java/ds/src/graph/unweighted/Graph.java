package graph.unweighted;

import java.util.Arrays;
import java.util.LinkedList;

/**
This is Adjacency List representation of graph.

A graph is an array of adjacency lists.
Size of array will be V (number of vertices in graph)

PROS:
 Queries like whether there is an edge from vertex u to vertex v can be done in O(log V).
 BFS and DFS is easy.

CONS:
 Adding an edge takes O(log V), as opposed to O(1) in vector implementation.
 Graphs containing parallel edge(s) cannot be implemented through this method.
 
*/
public class Graph {
	
	public int vertices;
    public LinkedList<Integer>[] adjListArray;
    
    public Graph(int V) {
    	this.vertices = V;
    	this.adjListArray = new LinkedList[V];
    	
    	for(int i = 0; i < V; i++) {
    		adjListArray[i] = new LinkedList<>();
    	}
    }

    /**
     * use this to create a undirected graph
     */
    public void addEdge(int src, int dest) {
    	adjListArray[src].addFirst(dest);
    	adjListArray[dest].addFirst(src);
    }

    /**
     * use this to create a directed grapg
     */
    public void addNeighbour(int node, Integer... neighbours) {
        this.adjListArray[node].addAll(Arrays.asList(neighbours));
    }
    
    public boolean searchEdge(int src, int dest) {
    	LinkedList<Integer> srcList = adjListArray[src];
    	return srcList.stream().anyMatch(v -> dest == v);
    }
    
    public void printGraph() {
    	for(int i = 0; i < this.vertices; i++) {
    		System.out.print(i + " : ");
    		for(int j : adjListArray[i]) {
    			System.out.print(" " + j);
    		}
    		System.out.println();
    	}
    }
    
    public static void main(String args[]) {
        getGraph().printGraph();
    }
    
    public static Graph getGraph() {
    	// create the graph given in above figure
        int V = 5;
        Graph graph = new Graph(V);
        graph.addEdge( 0, 1);
        graph.addEdge( 0, 4);
        graph.addEdge( 1, 2);
        graph.addEdge( 1, 3);
        graph.addEdge( 1, 4);
        graph.addEdge( 2, 3);
        graph.addEdge( 3, 4);
        
        return graph;
    }

    /**
     * <img src="./DAG.png">
     */
    public static Graph getDAG() {
        int V = 8;
        Graph g = new Graph(V);
        g.addNeighbour(4, 2, 1);
        g.addNeighbour(2, 1, 3, 6, 5);
        g.addNeighbour(5, 7);
        g.addNeighbour(6, 7);
        g.addNeighbour(3, 6);
        g.addNeighbour(1, 3);

        return g;

    }

}
