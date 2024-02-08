package ex04.app;

import ex04.entidades.Funcionario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        Funcionario funcionario;
        List<Funcionario> funcionarios = new ArrayList<>();
        String caminho = "/Users/rafael/funcionarios.csv";
        String[] funcionarioArquivo;
        String nome;
        double salario;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(caminho))) {
            String linha = bufferedReader.readLine();

            while (linha != null) {
                funcionarioArquivo = linha.split(",");
                nome = funcionarioArquivo[0];
                salario = Double.parseDouble(funcionarioArquivo[1]);

                funcionario = new Funcionario(nome, salario);

                funcionarios.add(funcionario);
                linha = bufferedReader.readLine();
            }

            Comparator<Funcionario> compararNome = Comparator.comparing(Funcionario::getNome);

            funcionarios.sort(compararNome);

            System.out.println("Nomes:");

            for (Funcionario f : funcionarios) {
                System.out.println(f.getNome() + ", " +  f.getSalario());
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao abrir o arquivo." + e);
        }
    }
}
