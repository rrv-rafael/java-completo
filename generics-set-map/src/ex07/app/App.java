package ex07.app;

import java.util.Map;
import java.util.TreeMap;

public class App {
    public static void main(String[] args) {
        Map<String, String> cookies = new TreeMap<>();

        cookies.put("username", "Maria");
        cookies.put("email", "maria@email.com");
        cookies.put("telefone", "99999999");

        cookies.remove("email");
        cookies.put("telefone", "99000998");

        System.out.println("Contém 'telefone' chave: " + cookies.containsKey("telefone"));
        System.out.println("Número do telefone: " + cookies.get("telefone"));
        System.out.println("Email: " + cookies.get("email"));
        System.out.println("Tamanho: " + cookies.size());

        System.out.println("Todos os cookies:");

        for (String key : cookies.keySet()) {
            System.out.printf("%s: %s\n", key, cookies.get(key));
        }
    }
}
