package exemplo05.application;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o caminho da pasta: ");
        String strCaminho = scan.nextLine();

        File caminho = new File(strCaminho);

        File[] pastas = caminho.listFiles(File::isDirectory);

        System.out.println("Pastas:");

        for (File pasta : Objects.requireNonNull(pastas)) {
            System.out.println(pasta);
        }

        File[] files = caminho.listFiles(File::isFile);

        System.out.println("Files:");

        for (File file : Objects.requireNonNull(files)) {
            System.out.println(file);
        }

        boolean sucesso = new File(strCaminho + "subdir").mkdir();
        System.out.println("Diretório criado com sucesso: " + sucesso);

        scan.close();
    }
}
