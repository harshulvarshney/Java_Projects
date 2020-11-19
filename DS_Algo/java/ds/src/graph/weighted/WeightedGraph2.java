package graph.weighted;

import java.util.LinkedList;

public class WeightedGraph2 {

    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        LinkedList<Edge> [] adjacencylist;//NOTE: this is a list of edges

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];
            //initialize adjacency lists for all the vertices
            for (int i = 0; i <vertices ; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }

        public void addEgde(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            adjacencylist[source].addFirst(edge); //for directed graph
        }

        public void printGraph() {
            for (int i = 0; i <vertices ; i++) {
                LinkedList<Edge> list = adjacencylist[i];
                for (int j = 0; j <list.size() ; j++) {
                    System.out.println(i + " --(" + list.get(j).weight + ")--> " + list.get(j).destination);
                }
            }
        }

    }

    public static void main(String[] args) {

        getDAG().printGraph();
    }

    /**
     * <img src="./WeightedDAG.PNG">
     */
    public static Graph getDAG() {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEgde(0, 1, 4);
        graph.addEgde(0, 2, 3);
        graph.addEgde(1, 2, 1);
        graph.addEgde(1, 3, 3);
        graph.addEgde(2, 3, 1);
        graph.addEgde(2, 4, 3);
        graph.addEgde(4, 5, 6);
        graph.addEgde(3, 5, 2);
        return graph;
    }

}
