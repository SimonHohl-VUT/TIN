package cv2.Boardgame;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Board myBoard = new Board();

        System.out.println("=== 3x3 Sliding Puzzle ===");
        System.out.println("Instructions: Enter w/a/s/d to move the Empty Spot (0).");
        System.out.println("Goal: 0 in top-left, then 1-8 in order.");

        boolean playing = true;
        while (playing) {
            myBoard.print();

            if (myBoard.isSolved()) {
                System.out.println("Congratulations! You solved it!");
                playing = false;
                break;
            }

            System.out.print("Move (w/a/s/d): ");
            String input = scanner.nextLine();

            if (input.length() > 0) {
                myBoard.moveZero(input);
            }
        }
        scanner.close();
    }
}
