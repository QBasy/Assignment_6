public class Test
{
    public static void main(String[] args)
    {
        WeightedGraph<Vertex<Integer>> graph = new WeightedGraph<>();
        BreadthFirstSearch<Vertex<Integer>> bfs = new BreadthFirstSearch<>();
        DijkstraSearch<Vertex<Integer>> ds = new DijkstraSearch<>();
        Vertex<Integer> vertex1 = new Vertex<>(1);
        Vertex<Integer> vertex2 = new Vertex<>(2);
        Vertex<Integer> vertex3 = new Vertex<>(3);
        Vertex<Integer> vertex4 = new Vertex<>(4);
        Vertex<Integer> vertex5 = new Vertex<>(5);
        Vertex<Integer> vertex6 = new Vertex<>(6);

        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        graph.addVertex(vertex4);
        graph.addVertex(vertex5);
        graph.addVertex(vertex6);

        graph.addEdge(vertex1, vertex2, 2);
        graph.addEdge(vertex3, vertex4, 1);
        graph.addEdge(vertex5, vertex3, 3);
        graph.addEdge(vertex1, vertex5, 4);

        System.out.println(graph.getEdges(vertex1));
        graph.printGraph();

        System.out.println(bfs.traverse(graph, vertex1));
        System.out.println(ds.traverse(graph, vertex1));
    }
}
