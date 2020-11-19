package graph.unweighted;

import java.util.HashSet;
import java.util.Set;

/**
 * Instead of using LinkedList, we can use Set to store edge's information.
 * 
 * PROS:
 *   Queries like whether there is an edge from vertex u to vertex v can be done in O(1).
 *   Adding an edge takes O(1).
 *   
 * CONS:
 * 	Graphs containing parallel edge(s) cannot be implemented through this method.
 *  
 *  adjacency matrix representation is the most optimized for edge search, 
 *  but space requirements of adjacency matrix are comparatively high for big sparse graphs. 
 *  Moreover adjacency matrix has other disadvantages as well like BFS and DFS become costly 
 *  as we can’t quickly get all adjacent of a node.
 *
 */
public class GraphWithSet {
	
	int v;
	Set<Integer> adjSet[];
	
	public GraphWithSet(int v) {
		this.v = v;
		adjSet = new Set[v];
		for(int i = 0; i < v; i++) {
			adjSet[i] = new HashSet<>();
		}
	}
	
	public void addEdge(int src, int dest) {
		adjSet[src].add(dest);
		adjSet[dest].add(src);
	}
	
	public boolean search(int src, int dest) {
		return adjSet[src].stream().filter(v -> dest == v).findFirst().isPresent();
	}
	
	public void printGraph() {
		for(int i = 0; i < v; i++) {
			System.out.print(i + " : ");
			for(int j : adjSet[i]) {
				System.out.print( " " + j);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int V = 5;
		GraphWithSet graph = new GraphWithSet(V);
        graph.addEdge( 0, 1);
        graph.addEdge( 0, 4);
        graph.addEdge( 1, 2);
        graph.addEdge( 1, 3);
        graph.addEdge( 1, 4);
        graph.addEdge( 2, 3);
        graph.addEdge( 3, 4);
      
        // print the adjacency list representation of 
        // the above graph
        graph.printGraph();
	}

}
