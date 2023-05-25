import java.util.*;

public class WeightedGraph<Vertex> {
    private Map<Vertex, List<Edge<Vertex>>> map = new HashMap<>();

    public void addVertex(Vertex vertex) {
        if (!map.containsKey(vertex)) {
            map.put(vertex, new ArrayList<>());
        }
    }

    public void getVertices(Vertex vertex)
    {
        
    }

    public void addEdge(Vertex source, Vertex destination, double weight) {
        Edge<Vertex> edge = new Edge<>(source, destination, weight);
        map.get(source).add(edge);
    }

    public List<Edge<Vertex>> getEdges(Vertex vertex) {
        return map.getOrDefault(vertex, new ArrayList<>());
    }
}
