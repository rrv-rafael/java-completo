package exemplo01.Application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        File file = new File("/Users/rafael/in.rtf");

        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
