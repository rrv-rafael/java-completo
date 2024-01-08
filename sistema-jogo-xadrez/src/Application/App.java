package Application;

import CamadaXadrez.PartidaXadrez;
import CamadaXadrez.PecaXadrez;
import CamadaXadrez.PosicaoXadrez;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        PartidaXadrez partidaXadrez = new PartidaXadrez();

        while (true) {
            InterfaceUsuario.imprimirTabuleiro(partidaXadrez.getPecas());
            System.out.println();
            System.out.print("Origem: ");
            PosicaoXadrez origem = InterfaceUsuario.lerPosicaoXadrez(scan);

            System.out.print("Destino: ");
            PosicaoXadrez destino = InterfaceUsuario.lerPosicaoXadrez(scan);

            PecaXadrez pecaCapturada = partidaXadrez.executarMovimentoXadrez(origem, destino);
        }

    }
}
