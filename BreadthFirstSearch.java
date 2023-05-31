import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch<V> implements Search<V> {
    private List<V> visit;

    @Override
    public List<V> traverse(WeightedGraph<V> graph, V start) {
        visit = new ArrayList<>();
        Queue<V> queue = new LinkedList<>();
        queue.offer(start);
        visit.add(start);

        bfs(graph, queue);

        return visit;
    }

    private void bfs(WeightedGraph<V> graph, Queue<V> queue) {
        if (queue.isEmpty()) {
            return;
        }
        V current = queue.poll();
        List<Edge<V>> edges = graph.getEdges(current);
        for (Edge<V> edge : edges) {
            V des = edge.getDes();
            if (!visit.contains(des) && !queue.contains(des)) {
                queue.offer(des);
                visit.add(des);
            }
        }
        bfs(graph, queue);
    }
}