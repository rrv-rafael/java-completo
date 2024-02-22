package ex05.app;

import ex05.entidades.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        String caminho = "C:\\All\\log.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(caminho))) {
            String linha;
            String[] conteudoArquivo;

            Set<Log> set = new HashSet<>();

            while ((linha = bufferedReader.readLine()) != null) {
                conteudoArquivo = linha.split(" ");
                String nomeUsuario = conteudoArquivo[0];
                LocalDateTime instanteAcesso = LocalDateTime.parse(conteudoArquivo[1]);

                set.add(new Log(nomeUsuario, instanteAcesso));
            }

            for (Log log : set) {
                System.out.println(log);
            }
        } catch (Exception e) {
            System.out.println("Não foi possível ler o aruqivo.");
        }
    }
}
