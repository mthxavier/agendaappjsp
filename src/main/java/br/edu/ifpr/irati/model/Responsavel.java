package br.edu.ifpr.irati.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="TB_RESPONSAVEL")
public class Responsavel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_responsavel")
    @SequenceGenerator(name="seq_responsavel", sequenceName = "responsavel_seq", allocationSize = 1, initialValue = 1)
    private Integer id;

    @Column(name="nome", nullable = false, length = 100)
    private String nome;

    @Column(name="email", nullable = false, length = 100)
    private String email;

    @Column(name="senha", nullable = false, length = 150)
    private String senha;

    @Column(name="telefone", nullable = false, length = 20)
    private String telefone;

    @Transient
    private Set<Aluno> alunos;

    public Responsavel(){
        id = 0;
        nome = "";
        email = "";
        telefone = "";
        alunos = new HashSet<>();
    }

    public Responsavel(Integer id, String nome, String email, String telefone, Set<Aluno> alunos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.alunos = alunos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }
}
