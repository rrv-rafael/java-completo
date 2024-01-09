package exemplo02.Application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        String caminho = "/Users/rafael/Documents/All/Estudo/Linguagem/Java/Java - Completo/Projetos/trabalhando-com-arquivos/ina.rtf";
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(caminho);
            bufferedReader = new BufferedReader(fileReader);

            String linha = bufferedReader.readLine();

            while (linha != null) {
                System.out.println(linha);
                linha = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());

        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
