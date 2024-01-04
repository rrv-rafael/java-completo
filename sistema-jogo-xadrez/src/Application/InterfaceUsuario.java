package Application;

import CamadaXadrez.PecaXadrez;

public class InterfaceUsuario {
    public static void imprimirTabuleiro(PecaXadrez[][] pecasXadrez) {
        for (int i = 0; i < pecasXadrez.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pecasXadrez.length; j++) {
                imprimirPeca(pecasXadrez[i][j]);
            }
            System.out.println();
        }
        System.out.print("  a b c d e f g h");
    }

    private static void imprimirPeca(PecaXadrez peca) {
        if (peca == null) {
            System.out.print("-");
        } else {
            System.out.print(peca);
        }

        System.out.print(" ");
    }
}

//0 1 2 3 4 5 6 7
//1
//2
//3
//4
//5
//6
//7
