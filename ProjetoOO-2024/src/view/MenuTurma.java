package view;

import app.Aluno;
import app.Disciplina;
import app.Professor;
import app.Turma;
import cadastros.CadastroAluno;
import cadastros.CadastroDisciplinas;
import cadastros.CadastroProfessores;
import cadastros.CadastroTurmas;

import javax.swing.*;

public class MenuTurma {
    public static Turma dadosNovaTurma(CadastroDisciplinas cadDisciplinas, CadastroProfessores cadProfessor, CadastroAluno cadAlunos) {
        String nome = lerNome();
        String codigo = lerCodigo();

        if (codigo.isEmpty()) {
            throw new RuntimeException("CampoEmBrancoException");
        }

        String codigoDisciplina = lerDisciplina();
        Disciplina disciplina = cadDisciplinas.pesquisarDisciplina(codigoDisciplina);
        if (disciplina == null) {
            throw new RuntimeException("Disciplina não encontrada!");
        }

        String matriculaProfessor = lerProfessor();
        Professor professor = cadProfessor.pesquisarProfessor(matriculaProfessor);
        if (professor == null) {
            throw new RuntimeException("ProfessorNaoAtribuidoException!");
        }

        Turma turma = new Turma(codigo, disciplina, professor, nome);

        while (true) {
            String matriculaAluno = lerAlunos();
            if (matriculaAluno.equalsIgnoreCase("nao")) {
                break;
            }
            Aluno aluno = cadAlunos.pesquisarAluno(matriculaAluno);
            if (aluno != null) {
                turma.matricularAluno(aluno);
            } else {
                JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
            }
        }

        return turma;
    }

    private static String lerNome() {
        return JOptionPane.showInputDialog("Informe o nome da Turma:");
    }

    private static String lerCodigo() {
        return JOptionPane.showInputDialog("Informe o código da Turma:");
    }

    private static String lerDisciplina() {
        return JOptionPane.showInputDialog("Informe o código da Disciplina:");
    }

    private static String lerProfessor() {
        return JOptionPane.showInputDialog("Informe a matrícula do Professor:");
    }

    private static String lerAlunos() {
        return JOptionPane.showInputDialog("Informe a matrícula dos Alunos (digite 'nao' para finalizar):");
    }

    public static void menuTurmas(CadastroTurmas cadTurma, CadastroDisciplinas cadDiscpiplinas, CadastroProfessores cadProfessor, CadastroAluno cadAlunos) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar Turma\n"
                + "2 - Pesquisar Turma\n"
                + "3 - Atualizar Turma\n"
                + "4 - Remover Turma\n"
                + "0 - Voltar para menu anterior";

        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    Turma novaTurma = dadosNovaTurma(cadDiscpiplinas, cadProfessor, cadAlunos);
                    if (novaTurma != null) {
                        cadTurma.cadastrarTurma(novaTurma);
                    }
                    break;

                case 2:
                    String codigoT = lerCodigo();
                    Turma turma = cadTurma.pesquisarTurmas(codigoT);
                    if (turma != null) {
                        turma.imprimirListaPresenca();
                    } else {
                        JOptionPane.showMessageDialog(null, "Turma não encontrada.");
                    }
                    break;

                case 3:
                    codigoT = lerCodigo();
                    Turma novoCadastro = dadosNovaTurma(cadDiscpiplinas, cadProfessor, cadAlunos);
                    if (novoCadastro != null) {
                        boolean atualizado = cadTurma.atualizarTurma(codigoT, novoCadastro);
                        if (atualizado) {
                            JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
                        }
                    }
                    break;

                case 4:
                    codigoT = lerCodigo();
                    Turma remover = cadTurma.pesquisarTurmas(codigoT);
                    if (remover != null) {
                        boolean removido = cadTurma.removerTurma(remover);
                        if (removido) {
                            JOptionPane.showMessageDialog(null, "Turma removida do cadastro");
                        }
                    }
                    break;

                default:
                    break;
            }
        } while (opcao != 0);
    }
}