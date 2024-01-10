package exemplo04.application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        String[] linhas = new String[]{"Bom dia", "Boa tarde", "Boa noite"};

        String caminho = "/Users/rafael/Documents/All/Estudo/Linguagem/Java/Java - Completo/Projetos/trabalhando-com-arquivos/out.rtf";

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(caminho))) {
            for (String linha : linhas) {
                bufferedWriter.write(linha);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
