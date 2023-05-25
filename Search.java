import java.util.List;

public interface Search<V>
{
    List<V> traverse(WeightedGraph<V> graph, V start);
}
