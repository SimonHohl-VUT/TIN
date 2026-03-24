package cv2.Boardgame;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Game {
    public static void main(String[] args) {
        Board myBoard = new Board();

        System.out.println("=== ZÁVOD ALGORITMŮ: BFS vs Dijkstra vs BestFS vs A* ===");
        System.out.println("Počáteční stav pro všechny algoritmy:");
        myBoard.print();
        System.out.println("\nPočkejte prosím, algoritmy počítají...\n");

        solveBFS(myBoard);
        solveDijkstra(myBoard);
        solveBestFS(myBoard);
        solveAStar(myBoard);
    }

    private static void solveBFS(Board startBoard) {
        long startTime = System.currentTimeMillis();
        Queue<Board> fronta = new LinkedList<>();
        Set<Board> visited = new HashSet<>();
        fronta.add(startBoard);
        visited.add(startBoard);
        int pocetProzkoumanychStavu = 0;

        while (!fronta.isEmpty()) {
            Board aktualni = fronta.poll();
            pocetProzkoumanychStavu++;

            if (aktualni.isSolved()) {
                long endTime = System.currentTimeMillis();
                vypisVysledek("BFS (Obyčejná fronta)", pocetProzkoumanychStavu, aktualni.getCesta(), endTime - startTime);
                return;
            }

            for (Board potomek : aktualni.getNeighbors()) {
                if (!visited.contains(potomek)) {
                    visited.add(potomek);
                    fronta.add(potomek);
                }
            }
        }
        System.out.println("BFS: Hlavolam nemá řešení.");
    }

    private static void solveDijkstra(Board startBoard) {
        long startTime = System.currentTimeMillis();
        Queue<Board> fronta = new PriorityQueue<>(Comparator.comparingInt(Board::getG));
        Set<Board> visited = new HashSet<>();
        fronta.add(startBoard);
        visited.add(startBoard);
        int pocetProzkoumanychStavu = 0;

        while (!fronta.isEmpty()) {
            Board aktualni = fronta.poll();
            pocetProzkoumanychStavu++;

            if (aktualni.isSolved()) {
                long endTime = System.currentTimeMillis();
                vypisVysledek("Dijkstra (F = g)", pocetProzkoumanychStavu, aktualni.getCesta(), endTime - startTime);
                return;
            }

            for (Board potomek : aktualni.getNeighbors()) {
                if (!visited.contains(potomek)) {
                    visited.add(potomek);
                    fronta.add(potomek);
                }
            }
        }
        System.out.println("Dijkstra: Hlavolam nemá řešení.");
    }

    private static void solveBestFS(Board startBoard) {
        long startTime = System.currentTimeMillis();
        Queue<Board> fronta = new PriorityQueue<>(Comparator.comparingInt(Board::getH));
        Set<Board> visited = new HashSet<>();
        fronta.add(startBoard);
        visited.add(startBoard);
        int pocetProzkoumanychStavu = 0;

        while (!fronta.isEmpty()) {
            Board aktualni = fronta.poll();
            pocetProzkoumanychStavu++;

            if (aktualni.isSolved()) {
                long endTime = System.currentTimeMillis();
                vypisVysledek("BestFS (F = h)", pocetProzkoumanychStavu, aktualni.getCesta(), endTime - startTime);
                return;
            }

            for (Board potomek : aktualni.getNeighbors()) {
                if (!visited.contains(potomek)) {
                    visited.add(potomek);
                    fronta.add(potomek);
                }
            }
        }
        System.out.println("BestFS: Hlavolam nemá řešení.");
    }

    private static void solveAStar(Board startBoard) {
        long startTime = System.currentTimeMillis();
        Queue<Board> fronta = new PriorityQueue<>(Comparator.comparingInt(Board::getF));
        Set<Board> visited = new HashSet<>();
        fronta.add(startBoard);
        visited.add(startBoard);
        int pocetProzkoumanychStavu = 0;

        while (!fronta.isEmpty()) {
            Board aktualni = fronta.poll();
            pocetProzkoumanychStavu++;

            if (aktualni.isSolved()) {
                long endTime = System.currentTimeMillis();
                vypisVysledek("A* (F = g + h)", pocetProzkoumanychStavu, aktualni.getCesta(), endTime - startTime);
                return;
            }

            for (Board potomek : aktualni.getNeighbors()) {
                if (!visited.contains(potomek)) {
                    visited.add(potomek);
                    fronta.add(potomek);
                }
            }
        }
        System.out.println("A*: Hlavolam nemá řešení.");
    }

    private static void vypisVysledek(String nazevAlgoritmu, int prozkoumano, String cesta, long casMs) {
        cesta = cesta.trim();
        int pocetKroku = cesta.isEmpty() ? 0 : cesta.split(" ").length;
        
        System.out.println("--- VÝSLEDEK: " + nazevAlgoritmu + " ---");
        System.out.println("Prozkoumáno stavů: " + prozkoumano);
        System.out.println("Čas výpočtu:       " + casMs + " ms");
        System.out.println("Délka cesty:       " + pocetKroku + " tahů");
        if (pocetKroku > 0 && pocetKroku <= 30) {
            System.out.println("Samotná cesta:     " + cesta);
        } else if (pocetKroku > 30) {
            System.out.println("Samotná cesta:     (Příliš dlouhá pro výpis, obsahuje " + pocetKroku + " kroků)");
        }
        System.out.println();
    }
}