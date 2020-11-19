package graph.unweighted;

import java.util.LinkedList;
import java.util.Queue;


public class GraphTraversal {
	
	public static void printBFS(Graph g, int s) {
		
		boolean[] visited = new boolean[g.adjListArray.length];
		
		Queue<Integer> q = new LinkedList<>();
		visited[s] = true;
		q.offer(s);
		
		while(!q.isEmpty()) {
			s = q.poll();
			System.out.print(s + " ");
			
			// Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
			for(int i: g.adjListArray[s]) {
				if(!visited[i]) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}
	}


	private static void printDFS(Graph g, int s, boolean[] visited) {
		if(visited[s])
			return;

		visited[s] = true;
		System.out.print(s + " | ");
		for(int i: g.adjListArray[s]) {
			printDFS(g, i, visited);
		}
		
	}
	
	public static void main(String[] args) {
		Graph g = Graph.getGraph();
		printBFS(g, 0);
		boolean[] visited = new boolean[g.vertices];
		//printDFS(g, 1, visited);
	}

}
