package ex02.app;

import ex02.model.entidades.Produto;
import ex02.model.services.CalculoService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        String caminho = "C:\\All\\produtos.csv";

        String[] produtoArquivo;
        String nome;
        double preco;

        List<Produto> produtos = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(caminho))) {
            String linha;

            while ((linha = bufferedReader.readLine()) != null) {
                produtoArquivo = linha.split(",");

                nome = produtoArquivo[0];
                preco = Double.parseDouble(produtoArquivo[1]);

                produtos.add(new Produto(nome, preco));
            }

            Comparator<Produto> comparadorPreco = Comparator.comparing(Produto::getPreco);

            Produto produtoMaisCaro = CalculoService.maior(produtos, comparadorPreco);

            System.out.println("Mais caro:");
            System.out.println(produtoMaisCaro);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
