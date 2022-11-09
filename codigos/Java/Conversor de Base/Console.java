import java.io.IOException;

public class Console {

    public static void limpar() {

        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
        Process process;
        try {
            process = pb.inheritIO().start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void pause() {

        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "pause");
        try {
            Process process = pb.inheritIO().start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
