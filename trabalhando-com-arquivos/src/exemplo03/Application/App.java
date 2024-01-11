package exemplo03.Application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        String caminho = "/Users/rafael/in.rtf";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(caminho))) {
            String linha = bufferedReader.readLine();

            while (linha != null) {
                System.out.println(linha);
                linha = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());

        }
    }
}
