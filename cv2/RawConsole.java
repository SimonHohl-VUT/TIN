package cv2;
import java.io.IOException;

public class RawConsole {

    public static void enableRawMode() {
        try {
            String[] cmd = {"/bin/sh", "-c", "stty -icanon min 1 < /dev/tty"};
            Runtime.getRuntime().exec(cmd).waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void disableRawMode() {
        try {
            String[] cmd = {"/bin/sh", "-c", "stty icanon < /dev/tty"};
            Runtime.getRuntime().exec(cmd).waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static char readChar() throws IOException {
        int input = System.in.read();
        return (char) input;
    }
}