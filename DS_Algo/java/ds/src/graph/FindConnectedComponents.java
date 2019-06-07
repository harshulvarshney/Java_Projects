package graph;

public class FindConnectedComponents {
	
	/**
	 * Print all the Connected Components in an Undirected Graph (Java)
	 * solved by using BFS.
	 */
	private void printConnected(Graph g) {
		boolean[] visited = new boolean[g.adjListArray.length];
		
		for(int i = 0; i < g.adjListArray.length; i++) {
			if(!visited[i]) {
				System.out.println();
				System.out.print(i);
				visited[i] = true;
				bfsUtil(g, i, visited);
			}
		}
	}
	
	private void bfsUtil(Graph g, int k, boolean[] visited) {
		for(int i : g.adjListArray[k]) {
			if(!visited[i]) {
				visited[i] = true;
				System.out.print(" " + i);
				bfsUtil(g, i, visited);
			}
		}
	}
	
	public static void main(String[] args) {
		FindConnectedComponents o = new FindConnectedComponents();
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		AdjacencyListPrinter.print(g);
		o.printConnected(g);
	}

}
