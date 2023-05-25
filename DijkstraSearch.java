import java.util.*;
public class DijkstraSearch<V> implements Search<V> {
    private WeightedGraph graph;

    @Override
    public List<V> traverse(WeightedGraph<V> graph, V start) {
        Map<V, Double> distance = new HashMap<>();
        Set<V> visit = new HashSet<>();
        List<V> path = new ArrayList<>();

        for (V vertex : graph.getVertices()) {
            if (vertex.equals(start)) {
                distance.put(vertex, 0.0);
            } else {
                distance.put(vertex, Double.POSITIVE_INFINITY);
            }
        }
    }
}
