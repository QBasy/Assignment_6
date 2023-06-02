public class Edge<V> {
    private V source;
    private V destination;
    private Double weight;

    public Edge(V source, V destination, Double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public V getSource() {
        return source;
    }

    public V getDes() {
        return destination;
    }

    public Double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "(" + source + " -> " + destination + ", weight: " + weight + ")";
    }
}