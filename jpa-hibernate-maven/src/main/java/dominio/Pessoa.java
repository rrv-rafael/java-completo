package dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;

@Entity
public class Pessoa implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codPessoa;
    private String nome;
    private String email;

    public Pessoa() {
    }

    public Pessoa(Integer codPessoa, String nome, String email) {
        this.codPessoa = codPessoa;
        this.nome = nome;
        this.email = email;
    }

    public Integer getCodPessoa() {
        return codPessoa;
    }

    public void setCodPessoa(Integer codPessoa) {
        this.codPessoa = codPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "codPessoa=" + codPessoa +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
