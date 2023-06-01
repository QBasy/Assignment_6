# Assignment 5
### Made with :heart: by Sayat Adilkhanov


---


# Main 🚀 [Link](Main.java)

```java
    public static void main(String[] args) 
    {
        BST<Integer, String> tree = new BST<>();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) 
        {
            System.out.println("Enter your choice:");
            System.out.println("1. Put (key, value)\n2. Get value by key\n3. Remove by key\n4. Check if value exists\n5. Get key by value\n6. Get size of Tree\n7. Get All keys\n8. Print all Tree");
            System.out.println("9. Exit");

            int n = scanner.nextInt();
                switch (n) 
                {
                case 1:
                    System.out.println("Enter key:");
                    int key = scanner.nextInt();
                    System.out.println("Enter value:");
                    String value = scanner.next();
                    tree.put(key, value);
                    System.out.println("Value inserted.");
                    break;
                case 2:
                    System.out.println("Enter key:");
                    key = scanner.nextInt();
                    String result = tree.get(key);
                    if (result != null) {
                        System.out.println("Value: " + result);
                    } else {
                        System.out.println("Key not found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter key:");
                    key = scanner.nextInt();
                    tree.delete(key);
                    String removedValue = tree.get(key);
                    if (removedValue != null) {
                        System.out.println("Press F to value: " + removedValue);
                    } else {
                        System.out.println("Key not found.");
                    }
                    break;
                case 4:
                    System.out.println("Enter value:");
                    value = scanner.next();
                    boolean contains = tree.containsValue(value);
                    System.out.println("Value exists: " + contains);
                    break;
                case 5:
                    System.out.println("Enter value:");
                    value = scanner.next();
                    Integer foundKey = tree.getKey(value);
                    if (foundKey != null) {
                        System.out.println("Key: " + foundKey);
                    } else {
                        System.out.println("No such value.");
                    }
                    break;
                case 6:
                    int size = tree.size();
                    System.out.println("Size equals to: " + size);
                case 7:
                    tree.forEachKey();
                    break;
                case 8:
                    tree.printTree();
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Don't be a 🤡");
            }
            System.out.println();
        }
        System.out.println("BYE BYE!");
    }
```

---

# Class  🚀 [Link](WeightedGraph.java)

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
