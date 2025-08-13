package br.edu.ifpr.irati.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="TB_TAREFA")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Tarefa extends Atividade{

    @Column(name = "status")
    private Integer status;

    @Column(name="data_hora_conclusao")
    private LocalDateTime dataHoraConclusao;

    @Transient
    private Aluno aluno;

    public Tarefa(){
        super();
        status = 0;
        aluno = new Aluno();
    }

    public Tarefa(Integer id, String descricao, LocalDateTime dataHora, Disciplina disciplina, Integer status, LocalDateTime dataHoraConclusao, Aluno aluno) {
        super(id, descricao, dataHora, disciplina);
        this.status = status;
        this.dataHoraConclusao = dataHoraConclusao;
        this.aluno = aluno;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getDataHoraConclusao() {
        return dataHoraConclusao;
    }

    public void setDataHoraConclusao(LocalDateTime dataHoraConclusao) {
        this.dataHoraConclusao = dataHoraConclusao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
