package cadastros;

import app.Disciplina;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CadastroDisciplinas {

    private List<Disciplina> disciplinas;

    public CadastroDisciplinas() {
        disciplinas = new ArrayList<>();
    }
    public boolean cadastrarDisciplina(Disciplina d) {
        if (d == null) {
            throw new IllegalArgumentException("Disciplina não pode ser nula");
        }

        // Verificar se já existe uma disciplina com o mesmo código
        Disciplina existente = pesquisarDisciplina(d.getCodigo());
        if (existente != null) {
            JOptionPane.showMessageDialog(null, "Disciplina com o código " + d.getCodigo() + " já cadastrada.");
            return false;
        }

        // Adicionar a nova disciplina à lista
        disciplinas.add(d);
        JOptionPane.showMessageDialog(null, "Disciplina cadastrada com sucesso!");
        return true;
    }

    public Disciplina pesquisarDisciplina(String codigo) {
        for (Disciplina d : disciplinas) {
            if (d.getCodigo().equals(codigo)) {
                return d;
            }
        }
        return null;
    }

    public boolean removerDisciplina(Disciplina d) {
        if (d == null) {
            throw new IllegalArgumentException("Disciplina não pode ser nula");
        }
        return disciplinas.remove(d);
    }

    public boolean atualizarDisciplina(String codigo, Disciplina d) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("Código não pode ser nulo ou vazio");
        }
        if (d == null) {
            throw new IllegalArgumentException("Disciplina não pode ser nula");
        }

        Disciplina existente = pesquisarDisciplina(codigo);
        if (existente != null) {
            disciplinas.remove(existente);
            disciplinas.add(d);
            return true;
        }
        return false;
    }
}
