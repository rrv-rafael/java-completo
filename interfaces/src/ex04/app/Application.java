package ex04.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        String caminho = "/Users/rafael/nomes.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(caminho))) {
            String linha = bufferedReader.readLine();

            while (linha != null) {
                nomes.add(linha);
                linha = bufferedReader.readLine();
            }

            Collections.sort(nomes);

            System.out.println("Nomes:");

            for (String nome : nomes) {
                System.out.println(nome);
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao abrir o arquivo." + e);
        }
    }
}
