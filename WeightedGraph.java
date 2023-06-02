import java.util.*;

public class WeightedGraph<Vertex> {
    private Map<Vertex, List<Edge<Vertex>>> map = new HashMap<>();

    public void addVertex(Vertex vertex) {
        if (!map.containsKey(vertex)) {
            map.put(vertex, new ArrayList<>());
        }
    }
    public Set<Vertex> getVertices() {
        return map.keySet();
    }

    public void addEdge(Vertex source, Vertex destination, double weight) {
        Edge<Vertex> edge = new Edge<>(source, destination, weight);
        map.get(source).add(edge);
        if (!map.containsKey(destination)) {
            map.put(destination, new ArrayList<>());
        }
        map.get(destination).add(edge);
    }

    public List<Edge<Vertex>> getEdges(Vertex vertex) {
        return map.getOrDefault(vertex, new ArrayList<>());
    }

    public void printGraph() {
        for (Map.Entry<Vertex, List<Edge<Vertex>>> entry : map.entrySet()) {
            Vertex vertex = entry.getKey();
            List<Edge<Vertex>> edges = entry.getValue();
            System.out.print("Vertex: " + vertex + " Edges: ");
            for (Edge<Vertex> edge : edges) {
                System.out.print(edge + " ");
            }
            System.out.println();
        }
    }

    public void removeVertex(Vertex vertex) {
        if (map.containsKey(vertex)) {
            map.remove(vertex);
        }
        for (List<Edge<Vertex>> edges : map.values()) {
            edges.removeIf(edge -> edge.getDes().equals(vertex));
        }
    }

    public void removeEdge(Vertex source, Vertex destination) {
        List<Edge<Vertex>> edges = map.get(source);
        edges.removeIf(edge -> edge.getDes().equals(destination));
    }
}