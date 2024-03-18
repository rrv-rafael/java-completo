package ex08.app;

import ex08.entidades.Produto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

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

            double media = produtos.stream()
                    .map(Produto::getPreco)
                    .reduce(0.0, Double::sum) / produtos.size();

            System.out.printf("Média dos preços: %.2f\n", media);

            Comparator<String> comparator = Comparator.comparing(String::toUpperCase);

            List<String> nomes = produtos.stream()
                    .filter(p -> p.getPreco() < media)
                    .map(Produto::getNome)
                    .sorted(comparator.reversed())
                    .toList();

            nomes.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Erro ao abrir o arquivo.");
        }

        scanner.close();
    }
}
