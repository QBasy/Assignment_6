import java.util.*;

public class WeightedGraph<V> {
    private Map<V, List<Edge<V>>> map = new HashMap<>();

    public void addVertex(V vertex) {
        if (!map.containsKey(vertex)) {
            map.put(vertex, new ArrayList<>());
        }
    }

    public Set<V> getVertices() {
        return map.keySet();
    }

    public void addEdge(V source, V destination, double weight) {
        Edge<V> edge = new Edge<>(source, destination, weight);
        map.get(source).add(edge);
    }

    public List<Edge<V>> getEdges(V vertex) {
        return map.getOrDefault(vertex, new ArrayList<>());
    }

    public void printGraph() {
        for (Map.Entry<V, List<Edge<V>>> entry : map.entrySet()) {
            V vertex = entry.getKey();
            List<Edge<V>> edges = entry.getValue();
            System.out.print("Vertex: " + vertex + " Edges: ");
            for (Edge<V> edge : edges) {
                System.out.print(edge + " ");
            }
            System.out.println();
        }
    }
}