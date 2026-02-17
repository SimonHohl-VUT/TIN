package cv2.Boardgame;
import java.util.HashSet;
import java.util.Set;
import java.io.IOException;

public class Game {
    public static void main(String[] args) {
        Board myBoard = new Board();
        
        // The Set to store history
        Set<Board> history = new HashSet<>();
        
        // Add starting state
        history.add(new Board(myBoard));

        System.out.println("=== HashSet Puzzle Game ===");
        System.out.println("Use W/A/S/D (no Enter needed).");
        System.out.println("Press 'q' to quit.\n");

        // Enable raw mode for immediate input
        RawConsole.enableRawMode();
        
        try {
            while (true) {
                myBoard.print();
                
                // Show off the HashSet capability
                System.out.println("Unique states visited: " + history.size());

                if (myBoard.isSolved()) {
                    System.out.println("SOLVED!");
                    break;
                }

                System.out.print("Move: ");
                int charInput = System.in.read();
                char input = (char) charInput;

                if (input == 'q' || input == 'Q') break;

                if (input == 'w' || input == 'W' || 
                    input == 'a' || input == 'A' || 
                    input == 's' || input == 'S' || 
                    input == 'd' || input == 'D') {
                    System.out.println(input);
                    myBoard.moveZero(String.valueOf(input));
                    
                    // Save the new state to history
                    // We must create a NEW COPY, otherwise we just save a reference to the changing board
                    history.add(new Board(myBoard));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Always restore normal mode
            RawConsole.disableRawMode();
            System.out.println("\nGame ended.");
        }
    }
}