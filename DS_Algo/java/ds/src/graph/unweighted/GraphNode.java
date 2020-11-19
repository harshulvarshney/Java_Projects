package graph.unweighted;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This is another graph representation similar to adjacency list
 * instead of using array of linked-list, we are using array of GraphNode here
 * 
 * ref:
 * https://www.thepolyglotdeveloper.com/2015/04/various-graph-search-algorithms-using-java/
 *
 */
public class GraphNode {
	
	public List<GraphNode> neighbours;
	public boolean visited;//this flag is part of GraphNode itself
	public int val;
	
	public GraphNode(int value) {
		this.val = value;
		this.visited = false;
		this.neighbours = new LinkedList<>();
	}

	public void addNeighbours(GraphNode... n) {
		this.neighbours.addAll(Arrays.stream(n).collect(Collectors.toList()));
	}
	
	public static void BFS(GraphNode root) {
		if(root == null)
			return;
		Queue<GraphNode> q = new LinkedList<>();
		System.out.println(root.val);
		root.visited = true;
		q.offer(root);
		while(!q.isEmpty()) {
			GraphNode temp = q.poll();
			for(GraphNode g : temp.neighbours) {
				if(!g.visited) {
					g.visited = true;
					System.out.println(g.val);
					q.offer(g);
				}
			}
		}
	}
	
	public static void DFS(GraphNode root) {
		if(root == null)
			return;
		Stack<GraphNode> s = new Stack<>();
		s.push(root);
		while(!s.isEmpty()) {
			GraphNode temp = s.pop();
			if(!temp.visited) {
				System.out.println(temp.val);//value is printed here for root node.
				temp.visited = true;
				for(GraphNode n : temp.neighbours) {
					s.push(n);
				}
			}
		}
	}
	
	public static void DFS_Recursive(GraphNode root) {
		if(root == null)
			return;
		root.visited = true;
		System.out.println(root.val);
		for(GraphNode n : root.neighbours) {
			if(!n.visited)
				DFS_Recursive(n);
		}
		
	}
	
	public static void main(String[] args) {
        BFS(getCyclicGraph());
	}

	public static GraphNode getCyclicGraph() {
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		GraphNode n4 = new GraphNode(4);
		GraphNode n5 = new GraphNode(5);
		GraphNode n6 = new GraphNode(6);
		GraphNode n7 = new GraphNode(7);

		n1.addNeighbours(n2, n4, n5);
		n2.addNeighbours(n1, n3, n4);
		n3.addNeighbours(n2, n4, n7);
		n4.addNeighbours(n1, n2, n3, n5, n6, n7);
		n5.addNeighbours(n1, n4, n6);
		n6.addNeighbours(n4, n5, n7);
		n7.addNeighbours(n3, n4, n6);

		return n1;
	}

	/**
	 * 	<img src="./DAG.png">
	 */
	public static GraphNode getDAG() {
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		GraphNode n4 = new GraphNode(4);
		GraphNode n5 = new GraphNode(5);
		GraphNode n6 = new GraphNode(6);
		GraphNode n7 = new GraphNode(7);

		n1.addNeighbours(n3);
		n2.addNeighbours(n1, n3, n5, n6);
		n3.addNeighbours(n6);
		n4.addNeighbours(n1, n2);
		n5.addNeighbours(n7);
		n6.addNeighbours(n7);

		return n4;
	}

	@Override
	public String toString() {
		return val+"";
	}

}
