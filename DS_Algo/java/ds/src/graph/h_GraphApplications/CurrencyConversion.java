package graph.h_GraphApplications;


import java.util.*;

// Asked in Zeta
// we have an n-array tree s.t. USD is at root and other currencies are its children
// edges have conversion rate as weight
// for any query Q, you hv to calculate the converted amount
//      Q: getConverted("INR", "GBP", 10);
public class CurrencyConversion {

    // This n-array tree will make a special graph s.t. there
    // will be only 1 path from 1 currency to another
    public static void main(String[] args) {

    }

    static Map<String, List<Edge>> map = new HashMap<>();
    static class Edge {
        String from;
        String to;
        double rate;
        public Edge(String from, String to, double rate) {
            this.from = from;
            this.to = to;
            this.rate = rate;
        }
    }
    static void prepare() {
        List<Edge> usdEdges = new LinkedList<>();
        Edge usdToJyp = new Edge("USD", "JPY", 110);
        usdEdges.add(usdToJyp);
        Edge usdToAud = new Edge("USD", "AUD", 1.45);
        usdEdges.add(usdToAud);
        map.put("USD", usdEdges);

        List<Edge> jpyEdges = new LinkedList<>();
        Edge jpyToUsd = new Edge("JPY", "USD", 1/110);
        usdEdges.add(jpyToUsd);
        Edge jpyToGbp = new Edge("JPY", "GBP", 0.007);
        usdEdges.add(jpyToGbp);
        map.put("JPY", jpyEdges);

        List<Edge> audEdges = new LinkedList<>();
        Edge audToUsd = new Edge("AUD", "USD", 1/1.45);
        usdEdges.add(audToUsd);
        map.put("AUD", audEdges);

        List<Edge> gbpEdges = new LinkedList<>();
        Edge gbpToJpy = new Edge("GBP", "JPY", 1/0.007);
        usdEdges.add(gbpToJpy);
        map.put("GBP", gbpEdges);

    }

    //find the target currency by BFS
    static double convert(String cur1, String cur2, double amount) {
        Queue<String> q = new LinkedList<>();
        Queue<Double> val = new LinkedList<>();
        q.offer(cur1);
        val.offer(amount);
        Set<String> visited = new HashSet<>();
        while(!q.isEmpty()) {
            String curr = q.poll();
            double v = val.poll();
            if(visited.contains(curr))
                continue;
            visited.add(curr);
            List<Edge> edges = map.get(curr);
            for(Edge e: edges) {
                if(!visited.contains(e.to)) {
                    q.offer(e.to);
                    if(cur2.equalsIgnoreCase(e.to))
                        return v * e.rate;
                    val.offer(v * e.rate);
                }
            }
        }
        return -1;
    }
}
