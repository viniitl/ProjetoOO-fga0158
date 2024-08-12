package cadastros;

import app.Professor;

import java.util.ArrayList;
import java.util.List;

public class CadastroProfessores {
    private List<Professor> professores;

    public CadastroProfessores() {
        professores = new ArrayList<>();
    }

    public boolean cadastrarProfessor(Professor p) {
        if (p == null || p.getMatriculaFUB() == null || p.getMatriculaFUB().trim().isEmpty()) {
            throw new RuntimeException("Professor inválido ou matrícula vazia.");
        }
        if (pesquisarProfessor(p.getMatriculaFUB()) != null) {
            throw new RuntimeException("Professor com a mesma matrícula já está cadastrado.");
        }
        return professores.add(p);
    }

    // metodo para pesquisar um professor
    public Professor pesquisarProfessor(String matricula) {
        if (matricula == null || matricula.trim().isEmpty()) {
            throw new RuntimeException("CampoEmBrancoException");
        }
        for (Professor p : professores) {
            if (p.getMatriculaFUB().equals(matricula)) {
                return p;
            }
        }
        return null;
    }

    // metodo para remover um professor
    public boolean removerProfessor(String matricula) {
        Professor professor = pesquisarProfessor(matricula);
        if (professor == null) {
            throw new RuntimeException("Professor não encontrado.");
        }
        return professores.remove(professor);
    }

    // metodo para atualizar os dados de um professor
    public boolean atualizarProfessor(String matricula, Professor p) {
        if (matricula == null || matricula.trim().isEmpty() || p == null || p.getMatriculaFUB().trim().isEmpty() || p.getNome().trim().isEmpty()) {
            throw new RuntimeException("Dados inválidos para atualização.");
        }
        Professor existente = pesquisarProfessor(matricula);
        if (existente != null) {
            professores.remove(existente);
            return professores.add(p);
        }
        return false;
    }
}


