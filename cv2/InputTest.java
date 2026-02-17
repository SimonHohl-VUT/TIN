package cv2;
import java.io.IOException;

public class InputTest {
    public static void main(String[] args) {
        try {
            // 1. MAGIC: Switch terminal to "Raw Mode"
            // This tells Linux: "Don't wait for Enter, send keys immediately"
            String[] cmdRaw = {"/bin/sh", "-c", "stty -icanon min 1 < /dev/tty"};
            Runtime.getRuntime().exec(cmdRaw).waitFor();

            System.out.println("--- INSTANT INPUT TEST ---");
            System.out.println("Press any key (it will print immediately).");
            System.out.println("Press 'q' to quit.");

            while (true) {
                // Read one byte (character) directly
                int input = System.in.read();
                char key = (char) input;

                System.out.println("You pressed: " + key + " (Code: " + input + ")");

                if (key == 'q') {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 2. CRITICAL: Restore terminal to normal
            // If we don't do this, your terminal will look broken after the program ends
            try {
                String[] cmdCooked = {"/bin/sh", "-c", "stty icanon < /dev/tty"};
                Runtime.getRuntime().exec(cmdCooked).waitFor();
                System.out.println("--- Exited safely ---");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}