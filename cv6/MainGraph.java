package cv6;

import java.util.List;

public class MainGraph {
    public static void main(String[] args) {
        GraphRouter graph = new GraphRouter();

        graph.addEdge("1", "2", 4);
        graph.addEdge("1", "6", 6);
        graph.addEdge("1", "7", 16);
        
        graph.addEdge("2", "3", 24);
        
        graph.addEdge("3", "6", 23);
        graph.addEdge("3", "4", 9);
        graph.addEdge("3", "5", 18);
        
        graph.addEdge("4", "5", 11);
        graph.addEdge("4", "8", 7);
        
        graph.addEdge("5", "6", 5);
        graph.addEdge("5", "7", 10);
        graph.addEdge("5", "8", 14);
        
        graph.addEdge("6", "7", 8);
        
        graph.addEdge("7", "8", 21);

        System.out.println("--- Testování Kruskalova algoritmu (Minimální kostra) ---");
        List<GraphRouter.Edge> mstEdges = graph.calculateKruskal();
        
        double mstTotalCost = 0;
        for (GraphRouter.Edge edge : mstEdges) {
            System.out.println(edge);
            mstTotalCost += edge.cost();
        }
        System.out.println("Celková cena minimální kostry: " + mstTotalCost);
        
        System.out.println("\n--- Testování ručně zadané cesty ---");
        /*try {
            GraphRouter.Path manualPath = graph.calculateManualPath("1", "6", "5", "4", "8");
            
            System.out.println(manualPath);
            System.out.println("Použité hrany:");
            manualPath.edges().forEach(edge -> System.out.println("  " + edge));
            
        } catch (IllegalArgumentException e) {
            System.err.println("Chyba v zadané cestě: " + e.getMessage());
        }
            */
    }
}