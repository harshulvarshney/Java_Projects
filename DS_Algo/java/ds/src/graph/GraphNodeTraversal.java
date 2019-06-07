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
		GraphNode n1 = new GraphNode(0);
        GraphNode n2 = new GraphNode(1);
        GraphNode n3 = new GraphNode(2);
        GraphNode n4 = new GraphNode(3);
        GraphNode n5 = new GraphNode(4);
        GraphNode n6 = new GraphNode(5);
        GraphNode n7 = new GraphNode(6);

        n1.neighbours = new GraphNode[] {n2, n4, n5};
        n2.neighbours = new GraphNode[] {n1, n3, n4};
        n3.neighbours = new GraphNode[] {n2, n4, n7};
        n4.neighbours = new GraphNode[] {n1, n2, n3, n5, n6, n7};
        n5.neighbours = new GraphNode[] {n1, n4, n6};
        n6.neighbours = new GraphNode[] {n4, n5, n7};
        n7.neighbours = new GraphNode[] {n3, n4, n6};
        
        dfs(n3, 7);
	}

}
