package exemplo02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        metodo1();

        System.out.println("Fim do programa.");
    }

    public static void metodo1() {
        System.out.println("***Ínicio do método1***");
        metodo2();
        System.out.println("***Fim do método1***");
    }

    public static void metodo2() {
        System.out.println("***Ínicio do método2***");
        Scanner scan = new Scanner(System.in);

        try {
            String[] vetor = scan.nextLine().split(" ");
            int posicao = scan.nextInt();
            System.out.println(vetor[posicao]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Posição inválida.");
            e.printStackTrace();
            scan.next();
        } catch (InputMismatchException e) {
            System.out.println("Digite apenas números.");
        }

        scan.close();

        System.out.println("***Fim do método2***");
    }
}
