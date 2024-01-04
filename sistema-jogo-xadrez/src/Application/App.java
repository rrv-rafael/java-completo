package Application;

import CamadaXadrez.PartidaXadrez;

public class App {
    public static void main(String[] args) {
        PartidaXadrez partidaXadrez = new PartidaXadrez();

        InterfaceUsuario.imprimirTabuleiro(partidaXadrez.getPecas());
    }
}
