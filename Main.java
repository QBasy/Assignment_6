import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        WeightedGraph<Vertex<Integer>> graph = new WeightedGraph<>();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit)
        {
            System.out.println("Enter your choice:");
            System.out.println("1. Add vertex\n2. Add edge\n3. Print graph\n4. Breadth-First Search\n5. Dijkstra's Algorithm");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            switch (choice)
            {
                case 1 -> {
                    System.out.println("Enter vertex value:");
                    int vertexValue = scanner.nextInt();
                    Vertex<Integer> vertex = new Vertex<>(vertexValue);
                    graph.addVertex(vertex);
                    System.out.println("Vertex added.");
                }
                case 2 -> {
                    System.out.println("Enter source vertex value:");
                    int sourceValue = scanner.nextInt();
                    System.out.println("Enter destination vertex value:");
                    int desValue = scanner.nextInt();
                    System.out.println("Enter edge weight:");
                    double weight = scanner.nextDouble();
                    Vertex<Integer> source = new Vertex<>(sourceValue);
                    Vertex<Integer> destination = new Vertex<>(desValue);
                    graph.addEdge(source, destination, weight);
                    System.out.println("Edge added.");
                }
                case 3 -> {
                    System.out.println("Graph:");
                    graph.printGraph();
                }
                case 4 -> {
                    System.out.println("Enter starting vertex value for BreadthFirstSearch:");
                    int startBFSValue = scanner.nextInt();
                    Vertex<Integer> startBFS = new Vertex<>(startBFSValue);
                    BreadthFirstSearch<Vertex<Integer>> bfs = new BreadthFirstSearch<>();
                    System.out.println("Breadth-First Search traversal:");
                    System.out.println(bfs.traverse(graph, startBFS));
                }
                case 5 -> {
                    System.out.println("Enter starting vertex value for DijkstraSearch:");
                    int startDijkstraValue = scanner.nextInt();
                    Vertex<Integer> startDijkstra = new Vertex<>(startDijkstraValue);
                    DijkstraSearch<Vertex<Integer>> dijkstra = new DijkstraSearch<>();
                    System.out.println("DijkstraSearch Algorithm traversal:");
                    System.out.println(dijkstra.traverse(graph, startDijkstra));
                }
                case 6 -> exit = true;
                default -> System.out.println("Why can't you not be a 🤡");
            }
            System.out.println();
        }

        System.out.println("BYE BYE!");
    }
}
