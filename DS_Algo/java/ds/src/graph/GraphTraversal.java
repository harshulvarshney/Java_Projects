package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;


public class GraphTraversal {
	
	public void printBFS(Graph g, int s) {
		
		boolean visited[] = new boolean[g.adjListArray.length];
		
		LinkedList<Integer> q = new LinkedList<>();
		visited[s] = true;
		q.offer(s);
		
		while(!q.isEmpty()) {
			s = q.poll();
			System.out.print(s + " ");
			
			// Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
			Iterator<Integer> i = g.adjListArray[s].iterator();
			while(i.hasNext()) {
				int n = i.next();
				if(!visited[n]) {
					visited[n] = true;
					q.offer(n);
				}
			}
		}
	}
	
	private void dfsUtil(Graph g, int s) {
		boolean[] visited = new boolean[g.adjListArray.length];
		for(int i = 0; i < g.adjListArray.length; i++) {
			if(!visited[i]) {
//				printDFS(g.adjListArray[], s, visited);
			}
		}
	}
	
	private void printDFS(Graph g, int s, boolean[] visited) {
		Stack<Integer> st = new Stack<Integer>();
		
		st.push(s);
		while(!st.isEmpty()) {
			int t = st.pop();
			if(!visited[t]) {
				System.out.print(t + " ");
				visited[t] = true;
			}
			for(Integer i : g.adjListArray[s]) {
				if(!visited[i]) {
					st.push(i);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Graph g = Graph.getGraph();
		GraphTraversal o = new GraphTraversal();
//		o.printDFS(g, 2);
	}

}
