import java.util.*;

public class DijkstraSearch<V> implements Search<V> {
    private WeightedGraph<V> graph;
    private Map<V, Double> distance;
    private Map<V, V> parentMap;
    private Set<V> visited;

    @Override
    public List<V> traverse(WeightedGraph<V> graph, V start) {
        this.graph = graph;
        distance = new HashMap<>();
        parentMap = new HashMap<>();
        visited = new HashSet<>();

        for (V vertex : graph.getVertices()) {
            if (vertex.equals(start)) {
                distance.put(vertex, 0.0);
            } else {
                distance.put(vertex, Double.POSITIVE_INFINITY);
            }
        }

        dijkstra(start);

        return getPath(start);
    }

    private void dijkstra(V current) {
        visited.add(current);

        List<Edge<V>> edges = graph.getEdges(current);
        for (Edge<V> edge : edges)
        {
            V destination = edge.getDes();
            double newDistance = distance.get(current) + edge.getWeight();
            if (newDistance < distance.get(destination)) {
                distance.put(destination, newDistance);
                parentMap.put(destination, current);
            }
        }

        V next = getMinVertexDistance();
        if (next != null) {
            dijkstra(next);
        }
    }

    private List<V> getPath(V start) {
        List<V> path = new ArrayList<>();
        V current = start;

        while (parentMap.containsKey(current)) {
            path.add(current);
            current = parentMap.get(current);
        }

        Collections.reverse(path);
        return path;
    }

    private V getMinVertexDistance() {
        double minDistance = Double.POSITIVE_INFINITY;
        V minVertex = null;
        for (Map.Entry<V, Double> entry : distance.entrySet()) {
            V vertex = entry.getKey();
            double dist = entry.getValue();
            if (!visited.contains(vertex) && dist < minDistance) {
                minDistance = dist;
                minVertex = vertex;
            }
        }
        return minVertex;
    }
}