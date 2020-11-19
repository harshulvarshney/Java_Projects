package graph.unweighted.problems;

import graph.unweighted.GraphNode;

import java.util.List;
import java.util.Stack;

/**
 * Topsort (Topological Sort) can be used only  when there is no cycle in graph i.e.
 * It is used for DAGs
 *
 * Topsort can produce multiple sorting orders for same graph
 *
 * example use case: maven dependency build
 * If we have a multi module project s.t. 1 project depends on 2nd & 2nd depends on 3rd and 4th
 * then top sort can give us correct order in which all the modules should be build in order
 * to satisfy dependencies
 *
 * below implementation is DFS based, it uses a stack to push nodes starting with 0 outgoing edges.
 * In below solution, it is important to pass the node with 0 incoming edges to get full solution.
 * for example, if n4 is passed as input, it will return all the nodes in answer (4,2,5,1,3,6,7)
 * but it n1 is passed as input, only the nodes reachable from 1 will be returned (1,3,6,7)
 */
public class TopSortWithGraphNode {

    Stack<GraphNode> stack = new Stack<>();
    public void topSort(GraphNode node) {

        node.visited = true;
        List<GraphNode> neighbours = node.neighbours;
        for(int i=0; i<neighbours.size(); i++) {
            GraphNode x = neighbours.get(i);
            if(x != null && !x.visited) {
                topSort(x);
            }
        }

        stack.push(node);
    }

    public static void main(String[] args) {
        GraphNode n = GraphNode.getDAG();
        TopSortWithGraphNode obj = new TopSortWithGraphNode();
        obj.topSort(n);
        while(!obj.stack.isEmpty()) {
            System.out.print(obj.stack.pop().val + ",");
        }
    }
}
