package graph;

public class AdjacencyListPrinter {
	
	public static void print(Graph g) {
		int n = g.V;
		
		for(int i = 0; i < n; i++) {
			System.out.print(i);
			for(int j : g.adjListArray[i]) {
				System.out.print(" -- " + j);
			}
			System.out.println();
		}
	}

}
