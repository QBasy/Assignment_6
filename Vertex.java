import java.util.Map;

public class Vertex<V>
{
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices;

    public V getData()
    {
        return data;
    }

    public void addAdjacentVertices (Vertex<V> destination, double weight)
    {
        adjacentVertices.put(destination, weight);
    }

    public Map<Vertex<V>, Double> getAdjacentVertices()
    {
        return adjacentVertices;
    }
}
