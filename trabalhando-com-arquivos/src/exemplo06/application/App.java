package exemplo06.application;

import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Entre com o caminho do arquivo: ");
        String strCaminho = scan.nextLine();

        File caminho = new File(strCaminho);

        System.out.println("getName: " + caminho.getName());
        System.out.println("getParent: " + caminho.getParent());
        System.out.println("getPath: " + caminho.getPath());

        scan.close();
    }
}
