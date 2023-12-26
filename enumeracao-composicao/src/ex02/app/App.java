package ex02.app;

import ex02.entidades.Comentario;
import ex02.entidades.Post;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scan = new Scanner(System.in);

        List<Post> posts = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            System.out.print("Informe a data do post: ");

            String dataInformada = scan.nextLine();
            System.out.print("Informe o título do post: ");
            String tituloPost = scan.nextLine();
            System.out.print("Informe o conteúdo do post: ");
            String conteudoPost = scan.nextLine();
            System.out.print("Informe a quantidade de curtidas: ");
            int qtdCurtidas = scan.nextInt();
            scan.nextLine();

            LocalDateTime dataPost = LocalDateTime.parse(dataInformada, Post.FORMATTER);

            Post post = new Post(dataPost, tituloPost, conteudoPost, qtdCurtidas);

            for (int j = 0; j < 2; j++) {
                System.out.print("Adicione um comentário: ");
                String comentario = scan.nextLine();
                post.addComentario(new Comentario(comentario));
            }

            posts.add(post);
        }

        for (Post p : posts) {
            System.out.println(p);
        }

        scan.close();
    }
}
