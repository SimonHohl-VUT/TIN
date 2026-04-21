package cv6;
import java.util.*;

public class GraphRouter {

    public record Node(String id) {
        public Node {
            if (id == null || id.isEmpty()) throw new IllegalArgumentException("Node id must be non-empty");
        }
        @Override
        public String toString() {
            return id;
        }
    }

    public record Edge(Node from, Node to, double cost) {
        public Edge {
            if (from == null || to == null) throw new NullPointerException("Edge endpoints must not be null");
            if (cost < 0) throw new IllegalArgumentException("Edge cost must be >= 0");
        }
        @Override
        public String toString() {
            return String.format("%s -> %s (%.0f)", from.id(), to.id(), cost);
        }
    }

    private final Map<String, Node> nodes = new LinkedHashMap<>();
    private final Map<String, Map<String, Edge>> adjacency = new HashMap<>();

    public Node addNode(String id) {
        if (id == null || id.isEmpty()) throw new IllegalArgumentException("id");
        return nodes.computeIfAbsent(id, key -> {
            Node n = new Node(key);
            adjacency.put(key, new LinkedHashMap<>());
            return n;
        });
    }

    public void addEdge(String fromId, String toId, double cost) {
        addEdge(fromId, toId, cost, true);
    }

    public void addEdge(String fromId, String toId, double cost, boolean bidirectional) {
        Node u = addNode(fromId);
        Node v = addNode(toId);
        Edge edge = new Edge(u, v, cost);
        adjacency.get(u.id()).put(v.id(), edge);
        
        if (bidirectional) {
            adjacency.get(v.id()).put(u.id(), new Edge(v, u, cost));
        }
    }

    public record Path(List<Node> nodes, List<Edge> edges, double totalCost) {
        public Path {
            nodes = List.copyOf(nodes);
            edges = List.copyOf(edges);
        }
        @Override
        public String toString() {
            String nodeSeq = String.join(" -> ", nodes.stream().map(Node::id).toArray(String[]::new));
            return String.format("Cesta: [%s] | Celková cena: %.2f", nodeSeq, totalCost);
        }
    }

    public Path calculateManualPath(String... pathNodes) {
        if (pathNodes == null || pathNodes.length < 2) {
            throw new IllegalArgumentException("Cesta musí obsahovat alespoň dva uzly.");
        }

        List<Node> routeNodes = new ArrayList<>();
        List<Edge> routeEdges = new ArrayList<>();
        double totalCost = 0.0;

        String currentId = pathNodes[0];
        Node currentNode = nodes.get(currentId);
        if (currentNode == null) {
            throw new IllegalArgumentException("Startovací uzel '" + currentId + "' neexistuje v grafu.");
        }
        routeNodes.add(currentNode);

        for (int i = 1; i < pathNodes.length; i++) {
            String nextId = pathNodes[i];
            Node nextNode = nodes.get(nextId);
            
            if (nextNode == null) {
                throw new IllegalArgumentException("Uzel '" + nextId + "' neexistuje v grafu.");
            }

            Map<String, Edge> neighbors = adjacency.getOrDefault(currentId, Collections.emptyMap());
            Edge connectingEdge = neighbors.get(nextId);

            if (connectingEdge == null) {
                throw new IllegalArgumentException("Neexistuje přímé spojení mezi '" + currentId + "' a '" + nextId + "'.");
            }

            routeEdges.add(connectingEdge);
            routeNodes.add(nextNode);
            totalCost += connectingEdge.cost();

            currentId = nextId;
            currentNode = nextNode;
        }

        return new Path(routeNodes, routeEdges, totalCost);
    }


    public List<Edge> calculateKruskal() {
        List<Edge> allEdges = new ArrayList<>();
        Set<String> seenEdges = new HashSet<>();

        for (Map<String, Edge> neighbors : adjacency.values()) {
            for (Edge edge : neighbors.values()) {
                String edgeId1 = edge.from().id() + "-" + edge.to().id();
                String edgeId2 = edge.to().id() + "-" + edge.from().id();
                
                if (!seenEdges.contains(edgeId1) && !seenEdges.contains(edgeId2)) {
                    allEdges.add(edge);
                    seenEdges.add(edgeId1);
                }
            }
        }

        allEdges.sort(Comparator.comparingDouble(Edge::cost));

        DisjointSet ds = new DisjointSet();
        for (Node node : nodes.values()) {
            ds.makeSet(node.id());
        }

        List<Edge> mst = new ArrayList<>();
        
        for (Edge edge : allEdges) {
            String root1 = ds.find(edge.from().id());
            String root2 = ds.find(edge.to().id());

            if (!root1.equals(root2)) {
                mst.add(edge);
                ds.union(root1, root2);
            }
        }

        return mst;
    }

    private static class DisjointSet {
        private final Map<String, String> parent = new HashMap<>();

        public void makeSet(String node) {
            parent.put(node, node);
        }

        public String find(String node) {
            if (!parent.get(node).equals(node)) {
                parent.put(node, find(parent.get(node))); // Path compression
            }
            return parent.get(node);
        }

        public void union(String node1, String node2) {
            String root1 = find(node1);
            String root2 = find(node2);
            if (!root1.equals(root2)) {
                parent.put(root1, root2);
            }
        }
    }

    public Collection<Node> getNodes() {
        return Collections.unmodifiableCollection(nodes.values());
    }

    public Collection<Edge> getEdges(String nodeId) {
        return Collections.unmodifiableCollection(adjacency.getOrDefault(nodeId, Collections.emptyMap()).values());
    }
}