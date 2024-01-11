package exemplo03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        // Caminho no windows:
        //File file = new File("C:\\temp\\int.txt");
        // Caminho no mac:
        File file = new File("");
        Scanner scan = null;

        try {
            scan = new Scanner(file);
            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao abrir o arquivo: " + e.getMessage());
        } finally {
            if (scan != null) {
                scan.close();
            }
            System.out.println("Bloco Finally executado.");
        }
    }
}
