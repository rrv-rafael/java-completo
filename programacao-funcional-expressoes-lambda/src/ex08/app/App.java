package ex08.app;

import ex08.entidades.Produto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o caminho completo do arquivo: ");
        String caminho = scanner.next();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(caminho))) {
            String linha;
            String[] conteudoArquivo;
            List<Produto> produtos = new ArrayList<>();

            while ((linha = bufferedReader.readLine()) != null) {
                conteudoArquivo = linha.split(",");
                String nome = conteudoArquivo[0];
                double preco = Double.parseDouble(conteudoArquivo[1]);

                produtos.add(new Produto(nome, preco));
            }

//            int soma = produtos.stream().map(e -> e);
        } catch (Exception e) {
            System.out.println("Erro ao abrir o arquivo.");
        }

        scanner.close();
    }
}
