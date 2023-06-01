# Assignment 5
### Made with :heart: by Sayat Adilkhanov


---


# Main 🚀 [Link](Main.java)

```java
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
```

---

# Class WeightedGraph 🚀 [Link](WeightedGraph.java)

```java
import java.util.*;

public class WeightedGraph<Vertex> {
    private Map<Vertex, List<Edge<Vertex>>> map = new HashMap<>();
    /*
    Methods
    */
}
```

## Method addVertex()

```java
    public void addVertex(Vertex vertex) {
        if (!map.containsKey(vertex)) {
            map.put(vertex, new ArrayList<>());
        }
    }
```

## Method getVertices()

```java
    public Set<Vertex> getVertices() {
        return map.keySet();
    }
```

## Method addEdge()

```java
    public void addEdge(Vertex source, Vertex destination, double weight) {
        Edge<Vertex> edge = new Edge<>(source, destination, weight);
        map.get(source).add(edge);
        if (!map.containsKey(destination)) {
            map.put(destination, new ArrayList<>());
        }
        map.get(destination).add(edge);
    }
```

## Method getEdges()

```java
    public List<Edge<Vertex>> getEdges(Vertex vertex) {
        return map.getOrDefault(vertex, new ArrayList<>());
    }
```

## Method printGraph()

```java
    public void printGraph() {
        for (Map.Entry<Vertex, List<Edge<Vertex>>> entry : map.entrySet()) {
            Vertex vertex = entry.getKey();
            List<Edge<Vertex>> edges = entry.getValue();
            System.out.print("Vertex: " + vertex + " Edges: ");
            for (Edge<Vertex> edge : edges) {
                System.out.print(edge + " ");
            }
            System.out.println();
        }
    }
```

## Method removeVertex()

```java
    public void removeVertex(Vertex vertex) {
        if (map.containsKey(vertex)) {
            map.remove(vertex);
        }
        for (List<Edge<Vertex>> edges : map.values()) {
            edges.removeIf(edge -> edge.getDes().equals(vertex));
        }
    }
```

## Method removeEdge()

```java
    public void removeEdge(Vertex source, Vertex destination) {
        List<Edge<Vertex>> edges = map.get(source);
        edges.removeIf(edge -> edge.getDes().equals(destination));
    }
```



---



# Class BreadthFirstSearch<V> [Link](BreadthFirstSearch.java)

```java 
public class BreadthFirstSearch<V> implements Search<V> {
    private List<V> visit;
    /*
    Methods
    */
}    
```


## Method traverse()

```java
    @Override
    public List<V> traverse(WeightedGraph<V> graph, V start) {
        visit = new ArrayList<>();
        Queue<V> queue = new LinkedList<>();
        queue.offer(start);
        visit.add(start);

        bfs(graph, queue);

        return visit;
    }    
```


## Method bfs()

```java
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
```

## Interface Search<E>

```java
import java.util.List;
  
public interface Search<V> {
    List<V> traverse(WeightedGraph<V> graph, V start);
}
```
  
  
## Method name()
```java
    
```

  
---
  
  
# Class DijkstraSearch<V> [Link](DijkstraSearch.java)  

```java  
public class DijkstraSearch<V> implements Search<V> {
    private WeightedGraph<V> graph;
    private Map<V, Double> distance;
    private Map<V, V> parentMap;
    private Set<V> visited;
    /*
    Methods
    */
}  
```
  
## Method traverse()
  
```java
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
```  
  
## Method dijkstra()

```java
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
```  

## Method getPath()                                                        
                                                        
```java
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
```
                                                        
## Method getMinVertexDistance()
                                                        
```java
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
```                                                        
