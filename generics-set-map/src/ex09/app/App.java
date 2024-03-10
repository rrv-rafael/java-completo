package ex09.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o caminho completo do arquivo: ");
        String caminho = scanner.next();

        String[] conteudoArquivo;
        String linha;
        String nomeCandidato;
        int qtdVotos;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(caminho))) {
            Map<String, Integer> candidatos = new LinkedHashMap<>();

            while ((linha = bufferedReader.readLine()) != null ) {
                conteudoArquivo = linha.split(",");

                nomeCandidato = conteudoArquivo[0];
                qtdVotos = Integer.parseInt(conteudoArquivo[1]);

                if (candidatos.containsKey(nomeCandidato)) {
                    qtdVotos += candidatos.get(nomeCandidato);
                }

                candidatos.put(nomeCandidato, qtdVotos);
            }

            for (String chave : candidatos.keySet()) {
                System.out.printf("%s: %s\n", chave, candidatos.get(chave));
            }
        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo");
        }

        scanner.close();
    }
}
