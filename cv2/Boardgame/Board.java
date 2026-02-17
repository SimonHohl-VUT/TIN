package cv2.Boardgame;

import java.util.Random;
import java.util.Arrays;

public class Board {
    private int[][] pole;
    
    private int zeroRow;
    private int zeroCol;

    private final int[][] TARGET_STATE = {
        {0, 1, 2},
        {3, 4, 5},
        {6, 7, 8}
    };

    public Board() {
        pole = new int[3][3];
        initializeBoard();
        shuffleBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            System.arraycopy(TARGET_STATE[i], 0, pole[i], 0, 3);
        }
        zeroRow = 0;
        zeroCol = 0;
    }

    private void shuffleBoard() {
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int direction = rand.nextInt(4);
            switch(direction) {
                case 0: moveZero("w"); break;
                case 1: moveZero("s"); break;
                case 2: moveZero("a"); break;
                case 3: moveZero("d"); break;
            }
        }
    }

    public void moveZero(String direction) {
        int newRow = zeroRow;
        int newCol = zeroCol;

        switch (direction.toLowerCase()) {
            case "w": newRow--; break; 
            case "s": newRow++; break;
            case "a": newCol--; break;
            case "d": newCol++; break;
            default: return;
        }

        if (isValid(newRow, newCol)) {
            int temp = pole[newRow][newCol];
            pole[newRow][newCol] = 0;
            pole[zeroRow][zeroCol] = temp;

            zeroRow = newRow;
            zeroCol = newCol;
        }
    }

    private boolean isValid(int r, int c) {
        return r >= 0 && r < 3 && c >= 0 && c < 3;
    }

    public boolean isSolved() {
        return Arrays.deepEquals(pole, TARGET_STATE);
    }

    public void print() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                if (pole[i][j] == 0) {
                    System.out.print("  | ");
                } else {
                    System.out.print(pole[i][j] + " | ");
                }
            }
            System.out.println("\n-------------");
        }
    }
}