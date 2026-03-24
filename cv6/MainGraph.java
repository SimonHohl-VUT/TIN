package cv6;

public class MainGraph {
    public static void main(String[] args) {
        GraphRouter graph = new GraphRouter();

        graph.addEdge("A", "B", 5);    
        graph.addEdge("A", "C", 2);    
        graph.addEdge("C", "B", 1);    
        graph.addEdge("B", "D", 2);    
        graph.addEdge("C", "D", 9);    
        graph.addEdge("D", "E", 1);    

        System.out.println("--- Testování ručně zadané cesty ---");
        
        try {
            GraphRouter.Path manualPath = graph.calculateManualPath("A", "C", "D", "B");
            
            System.out.println(manualPath);
            System.out.println("Použité hrany:");
            manualPath.edges().forEach(edge -> System.out.println("  " + edge));
            
        } catch (IllegalArgumentException e) {
            System.err.println("Chyba v zadané cestě: " + e.getMessage());
        }
        
        System.out.println("\n Test chybné cesty (A -> E napřímo)");
        try {
            GraphRouter.Path manualPath = graph.calculateManualPath("A", "E");
            System.out.println(manualPath);
            System.out.println("Použité hrany:");
            manualPath.edges().forEach(edge -> System.out.println("  " + edge));
        } catch (IllegalArgumentException e) {
            System.err.println("Očekávaná chyba: " + e.getMessage());
        }
    }
}