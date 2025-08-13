package br.edu.ifpr.irati.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="TB_ATIVIDADE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_atividade")
    @SequenceGenerator(name="seq_atividade", sequenceName = "atividade_seq", allocationSize = 1, initialValue = 1)
    protected Integer id;

    @Column(name="descricao", nullable = false, length = 500)
    protected String descricao;

    @Column(name="data_hora")
    protected LocalDateTime dataHora;

    @Transient
    protected Disciplina disciplina;

    public Atividade(){
        id = 0;
        descricao = "";
        dataHora = LocalDateTime.now();
    }

    public Atividade(Integer id, String descricao, LocalDateTime dataHora, Disciplina disciplina) {
        this.id = id;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.disciplina = disciplina;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
