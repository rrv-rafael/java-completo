package aplicacao;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program {
    public static void main(String[] args) {
        /*
        Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
        Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
        Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");
        */

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //Buscando dados no banco:
        Pessoa p = entityManager.find(Pessoa.class, 2);

        entityManager.getTransaction().begin();

        //Deletando registro no banco:
        entityManager.remove(p);

        entityManager.getTransaction().commit();

        System.out.println(p);

        /*
        Inserindo dados no banco:
        entityManager.getTransaction().begin();


        entityManager.persist(p1);
        entityManager.persist(p2);
        entityManager.persist(p3);

        entityManager.getTransaction().commit();
        */
        System.out.println("Pronto.");

        entityManager.close();
        entityManagerFactory.close();
    }
}
