package graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphNodeTraversal {
	
	static void bfs(GraphNode root, int v) {
		boolean[] visited = new boolean[v];
		Queue<GraphNode> q = new LinkedList<>();
		q.offer(root);
		visited[root.val] = true;
		System.out.print(root.val + " | ");
		while(!q.isEmpty()) {
			GraphNode n = q.poll();
			for(GraphNode i : n.neighbours) {
				if(!visited[i.val]) {
					System.out.print(i.val + " | ");
					visited[i.val] = true;
					q.offer(i);
				}
			}
		}
	}
	
	static void dfs(GraphNode root, int v) {
		boolean[] visited = new boolean[v];
		dfsUtil(root, visited);
	}
	static void dfsUtil(GraphNode n, boolean[] visited) {
		if(!visited[n.val]) {
			System.out.print(n.val + " | ");
			visited[n.val] = true;
			for(GraphNode t : n.neighbours) {
				if(!visited[t.val])
					dfsUtil(t, visited);
			}
		}
	}
	
	public static void main(String[] args) {
        dfs(GraphNode.getCyclicGraph(), 7);
	}

}
