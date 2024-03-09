package ex05.app;

import ex05.entidades.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Instant;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o caminho do arquivo: ");
        String caminho = scanner.next();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(caminho))) {
            String linha;
            String[] conteudoArquivo;

            Log log;

            Set<Log> set = new HashSet<>();

            while ((linha = bufferedReader.readLine()) != null) {
                conteudoArquivo = linha.split(" ");
                String nomeUsuario = conteudoArquivo[0];
                Instant instanteAcesso = Instant.parse(conteudoArquivo[1]);

                log = new Log(nomeUsuario, instanteAcesso);

                set.add(log);
            }

            System.out.printf("Total de usuários: %d", set.size());
        } catch (Exception e) {
            System.out.println("Não foi possível ler o arquivo.");
        }
    }
}
