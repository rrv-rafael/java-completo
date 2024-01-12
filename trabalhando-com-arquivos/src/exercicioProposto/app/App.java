package exercicioProposto.app;

import exercicioProposto.entidades.Produto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scan = new Scanner(System.in);

        System.out.println("Preencha abaixo as informações do produto:");

        List<Produto> produtos = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            System.out.print("Nome: ");
            String nomeProduto = scan.nextLine();
            System.out.print("Preço unitário: ");
            double precoUnitario = scan.nextDouble();
            System.out.print("Quantidade: ");
            int quantidade = scan.nextInt();
            scan.nextLine();

            produtos.add(new Produto(nomeProduto, precoUnitario, quantidade));
        }

        // Caminho windows: C:\\temp\\int.txt
        // Caminho macOS:
        String caminho = "/Users/rafael/produtos.csv";
        File caminhoArquivo = new File(caminho);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (Produto p : produtos) {
                bufferedWriter.write(p.getNome() + ",");
                bufferedWriter.write(p.getPreco() + ",");
                bufferedWriter.write(p.getQuantidade() + "");
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ocorreu um erro ao escrever o arquivo.", e);
        }

        String[] produtoArquivo;
        List<Produto> produtosArquivo = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(caminho))) {
            String linha = bufferedReader.readLine();

            while (linha != null) {
                produtoArquivo = linha.split(",");
                String nome = produtoArquivo[0];
                double preco = Double.parseDouble(produtoArquivo[1]);
                int quantidade = Integer.parseInt(produtoArquivo[2]);

                produtosArquivo.add(new Produto(nome, preco, quantidade));
                linha = bufferedReader.readLine();
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ocorreu um erro ao ler o arquivo.", e);
        }

        File caminhoDiretorio = new File(caminhoArquivo.getParent() + "/saida");

        if (!caminhoDiretorio.exists()) {
            try {
               if (caminhoDiretorio.mkdir()) {
                   System.out.println("\nDiretório criado com sucesso.");
               }
            } catch (SecurityException e) {
                logger.log(Level.SEVERE, "Ocorreu um erro ao criar o diretório.", e);
                return;
            }
        }

        caminhoArquivo = new File(caminhoDiretorio + "/sumario.csv");

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (Produto p : produtosArquivo) {
                bufferedWriter.write(p.getNome() + "," + String.format("%.2f", p.calcularValorTotal()));
                bufferedWriter.newLine();
            }

            System.out.println("A operação ocorreu com sucesso.");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ocorreu um erro ao escrever o arquivo.", e);
        }

        scan.close();
    }
}
