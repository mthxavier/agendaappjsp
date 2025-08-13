package br.edu.ifpr.irati.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="TB_DISCIPLINA")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_disciplina")
    @SequenceGenerator(name="seq_disciplina", sequenceName = "disciplina_seq", allocationSize = 1, initialValue = 1)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "chave", nullable = false, length = 8)
    private String chave;

    @ManyToMany
    @JoinTable(name = "TB_PROFESSOR_DISCIPLINA",
            joinColumns = {@JoinColumn(name="fk_id_disciplina")},
            inverseJoinColumns = {@JoinColumn(name="fk_id_professor")}
    )
    private Set<Professor> professores;

    @ManyToMany(mappedBy = "disciplinas")
    private Set<Aluno> alunos;
    @Transient
    private Set<Atividade> atividades;

    public Disciplina(){
        id = 0;
        nome = "";
        chave = "";
        professores = new HashSet<>();
        alunos = new HashSet<>();
        atividades = new HashSet<>();
    }

    public Disciplina(Professor professor){
        id = 0;
        nome = "";
        chave = "";
        professores = new HashSet<>();
        professores.add(professor);
        alunos = new HashSet<>();
        atividades = new HashSet<>();
    }

    public Disciplina(Integer id, String nome, String chave, Set<Professor> professores, Set<Aluno> alunos, Set<Atividade> atividades) {
        this.id = id;
        this.nome = nome;
        this.chave = chave;
        this.professores = professores;
        this.alunos = alunos;
        this.atividades = atividades;
    }

    public void adicionarProfessor(Professor professor){
        this.professores.add(professor);
    }

    public void removerProfessor(Professor professor){
        this.professores.remove(professor);
    }

    public void adicionarAluno(Aluno aluno){ this.alunos.add(aluno); }

    public void removerAluno(Aluno aluno){ this.alunos.remove(aluno); }

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

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public Set<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(Set<Professor> professores) {
        this.professores = professores;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Set<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(Set<Atividade> atividades) {
        this.atividades = atividades;
    }
}
