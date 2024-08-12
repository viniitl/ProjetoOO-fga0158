package app;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String codigo;
    private Disciplina disciplina;
    private Professor professor;
    private String nome;
    private List<Aluno> alunos;

    public Turma(String codigo, Disciplina disciplina, Professor professor, String nome) {
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.professor = professor;
        this.nome = nome;
        this.alunos = new ArrayList<>();
    }

    // Método para matricular aluno na turma
    public void matricularAluno(Aluno aluno) {
        if (aluno == null) {
            System.out.println("Aluno inválido.");
            return;
        }
        if (!alunos.contains(aluno)) {
            alunos.add(aluno);
            System.out.println("Aluno matriculado com sucesso: " + aluno.getNome());
        } else {
            System.out.println("Aluno já está matriculado.");
        }
    }

    public void imprimirListaPresenca() {
        if (this.disciplina == null) {
            System.out.println("Disciplina não está definida.");
            return;
        }

        JOptionPane.showMessageDialog(null, "Lista de Presença:");
        JOptionPane.showMessageDialog(null, "Disciplina: " + disciplina.getNome());
        JOptionPane.showMessageDialog(null, "Código: " + disciplina.getCodigo());

        if (alunos != null && !alunos.isEmpty()) {
            for (Aluno aluno : alunos) {
                JOptionPane.showMessageDialog(null, "Aluno: " + aluno.getNome() + " - Matrícula: " + aluno.getMatricula());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum aluno matriculado.");
        }
    }
    //get e setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}