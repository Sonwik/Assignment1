import java.util.*;

class Edge {
    char target;
    int weight;

    public Edge(char target, int weight) {
        this.target = target;
        this.weight = weight;
    }
}

class PQNode implements Comparable<PQNode> {
    char vertex;
    int distance;

    public PQNode(char vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    @Override
    public int compareTo(PQNode other) {
        return Integer.compare(this.distance, other.distance);
    }
}

class Graph {
    private final Map<Character, List<Edge>> adjList;

    public Graph() {
        this.adjList = new TreeMap<>();
    }

    public void addVertex(char v) {
        adjList.putIfAbsent(v, new ArrayList<>());
    }

    public void addEdge(char v, char w, int weight) {
        addVertex(v);
        addVertex(w);
        adjList.get(v).add(new Edge(w, weight));
        adjList.get(w).add(new Edge(v, weight));
    }

    public void printGraph() {
        System.out.println("Task 1: Graph Representation (Adjacency List)");
        for (Map.Entry<Character, List<Edge>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + " -> [");
            List<Edge> edges = entry.getValue();
            for (int i = 0; i < edges.size(); i++) {
                System.out.print("(" + edges.get(i).target + ", " + edges.get(i).weight + ")");
                if (i < edges.size() - 1) System.out.print(", ");
            }
            System.out.println("]");
        }
        System.out.println();
    }

    public void bfs(char startNode) {
        System.out.println(" Task 2: BFS Traversal (Starting from " + startNode + ")");
        if (!adjList.containsKey(startNode)) return;

        Queue<Character> queue = new LinkedList<>();
        Set<Character> visited = new HashSet<>();
        List<String> order = new ArrayList<>();

        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            char current = queue.poll();
            order.add(String.valueOf(current));

            List<Edge> neighbors = new ArrayList<>(adjList.get(current));
            neighbors.sort(Comparator.comparingInt(e -> e.target));

            for (Edge edge : neighbors) {
                if (!visited.contains(edge.target)) {
                    visited.add(edge.target);
                    queue.add(edge.target);
                }
            }
        }
        System.out.println(String.join(" -> ", order) + "\n");
    }

    public void dfs(char startNode) {
        System.out.println("Task 2: DFS Traversal (Starting from " + startNode + ") ");
        if (!adjList.containsKey(startNode)) return;

        Set<Character> visited = new HashSet<>();
        List<String> order = new ArrayList<>();

        dfsHelper(startNode, visited, order);

        System.out.println(String.join(" -> ", order) + "\n");
    }

    private void dfsHelper(char current, Set<Character> visited, List<String> order) {
        visited.add(current);
        order.add(String.valueOf(current));

        List<Edge> neighbors = new ArrayList<>(adjList.get(current));
        neighbors.sort(Comparator.comparingInt(e -> e.target));

        for (Edge edge : neighbors) {
            if (!visited.contains(edge.target)) {
                dfsHelper(edge.target, visited, order);
            }
        }
    }

    public void dijkstra(char source) {
        System.out.println("Task 3: Shortest Path (Dijkstra from " + source + ")");

        Map<Character, Integer> distances = new HashMap<>();
        Map<Character, Character> parentNodes = new HashMap<>();
        PriorityQueue<PQNode> minHeap = new PriorityQueue<>();

        for (char vertex : adjList.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(source, 0);
        minHeap.add(new PQNode(source, 0));

        while (!minHeap.isEmpty()) {
            PQNode curr = minHeap.poll();
            char u = curr.vertex;

            if (curr.distance > distances.get(u)) continue;

            for (Edge edge : adjList.get(u)) {
                char v = edge.target;
                int weight = edge.weight;
                int newDist = distances.get(u) + weight;

                if (newDist < distances.get(v)) {
                    distances.put(v, newDist);
                    parentNodes.put(v, u);
                    minHeap.add(new PQNode(v, newDist));
                }
            }
        }

        for (char vertex : adjList.keySet()) {
            System.out.print("To " + vertex + " : Distance = ");
            if (distances.get(vertex) == Integer.MAX_VALUE) {
                System.out.println("Unreachable");
            } else {
                System.out.print(distances.get(vertex) + ", Path: ");
                printPath(vertex, parentNodes);
                System.out.println();
            }
        }
    }

    private void printPath(char vertex, Map<Character, Character> parentNodes) {
        LinkedList<Character> path = new LinkedList<>();
        Character curr = vertex;
        while (curr != null) {
            path.addFirst(curr);
            curr = parentNodes.get(curr);
        }
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1) System.out.print(" -> ");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addEdge('B', 'A', 15);
        graph.addEdge('C', 'A', 5);
        graph.addEdge('D', 'B', 13);
        graph.addEdge('E', 'A', 8);
        graph.addEdge('E', 'B', 2);
        graph.addEdge('B', 'C', 4);


        graph.printGraph();
        graph.bfs('D');
        graph.dfs('D');
        graph.dijkstra('A');
    }
}