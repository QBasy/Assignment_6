import java.util.Scanner;

public class Test
{
    public static void main(String[] args) {
        WeightedGraph<Integer> graph = new WeightedGraph<>();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Enter your choice:");
            System.out.println("1. Add vertex\n2. Add edge\n3. Print graph\n4. Breadth-First Search\n5. Dijkstra's Algorithm");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter vertex value:");
                    int vertex = scanner.nextInt();
                    graph.addVertex(vertex);
                    System.out.println("Vertex added");
                    break;
                case 2:
                    System.out.println("Enter source vertex:");
                    int source = scanner.nextInt();
                    System.out.println("Enter destination vertex:");
                    int destination = scanner.nextInt();
                    System.out.println("Enter edge weight:");
                    double weight = scanner.nextDouble();
                    graph.addEdge(source, destination, weight);
                    System.out.println("Edge added");
                    break;
                case 3:
                    System.out.println("Graph:");
                    graph.printGraph();
                    break;
                case 4:
                    System.out.println("Enter start vertex for BreadthFirstSearch:");
                    int startBFS = scanner.nextInt();
                    BreadthFirstSearch<Integer> bfs = new BreadthFirstSearch<>();
                    System.out.println("Breadth-First Search traversal:");
                    System.out.println(bfs.traverse(graph, startBFS));
                    break;
                case 5:
                    System.out.println("Enter start vertex for DijkstraSearch:");
                    int startDijkstra = scanner.nextInt();
                    DijkstraSearch<Integer> dijkstra = new DijkstraSearch<>();
                    System.out.println("DijkstraSearch traversal:");
                    System.out.println(dijkstra.traverse(graph, startDijkstra));
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Don't be a 🤡");
            }
            System.out.println();
        }

        System.out.println("BYE BYE!");
    }
}
