package br.edu.ifpr.irati.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="TB_ALUNO")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_aluno")
    @SequenceGenerator(name="seq_aluno", sequenceName = "aluno_seq", allocationSize = 1, initialValue = 1)
    private Integer id;

    @Column(name="nome", nullable = false, length = 100)
    private String nome;

    @Column(name="email", nullable = false, length = 100)
    private String email;

    @Column(name="senha", nullable = false, length = 150)
    private String senha;

    @ManyToMany
    @JoinTable(name = "TB_ALUNO_DISCIPLINA",
            joinColumns = {@JoinColumn(name="fk_id_aluno")},
            inverseJoinColumns = {@JoinColumn(name="fk_id_disciplina")}
    )
    private Set<Disciplina> disciplinas;

    @Transient
    private Set<Responsavel> responsaveis;

    @Transient
    private List<Tarefa> tarefas;

    public Aluno() {
        this.id = 1;
        this.nome = "";
        this.email = "";
        this.senha = "";
        disciplinas = new HashSet<>();
        responsaveis = new HashSet<>();
        tarefas = new ArrayList<>();
    }

    public void adicionarDisciplina(Disciplina disciplina){
        this.disciplinas.add(disciplina);
        disciplina.getAlunos().add(this);
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Set<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Set<Responsavel> getResponsaveis() {
        return responsaveis;
    }

    public void setResponsaveis(Set<Responsavel> responsaveis) {
        this.responsaveis = responsaveis;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
}
