package view;

import app.Disciplina;
import cadastros.CadastroDisciplinas;
import javax.swing.*;

public class MenuDisciplina {

    public static Disciplina dadosNovaDisciplina(CadastroDisciplinas cadDisciplinas) {
        String codigo = lerCodigo();
        if (codigo == null || codigo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Código não pode ser vazio.");
            return null;
        }

        if (cadDisciplinas.pesquisarDisciplina(codigo) != null) {
            JOptionPane.showMessageDialog(null, "Código já existente. Tente um código diferente.");
            return null;
        }

        String nome = lerNome();
        if (nome == null || nome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome não pode ser vazio.");
            return null;
        }

        return new Disciplina(nome, codigo);
    }

    public static String lerNome() {
        return JOptionPane.showInputDialog("Informe o nome da Disciplina: ");
    }

    public static String lerCodigo() {
        return JOptionPane.showInputDialog("Informe o código da Disciplina: ");
    }

    public static void menuDisciplinas(CadastroDisciplinas cadDisciplinas) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar Disciplina\n"
                + "2 - Pesquisar Disciplina\n"
                + "3 - Atualizar Disciplina\n"
                + "4 - Remover Disciplina\n"
                + "0 - Voltar para menu anterior";

        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            if (strOpcao == null) {
                continue;
            }

            try {
                opcao = Integer.parseInt(strOpcao);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                continue;
            }

            switch (opcao) {
                case 1:
                    Disciplina novaDisciplina = dadosNovaDisciplina(cadDisciplinas);
                    if (novaDisciplina != null) {
                        cadDisciplinas.cadastrarDisciplina(novaDisciplina);
                    }else{
                        throw new RuntimeException("CampoEmBrancoException");
                    }
                    break;

                case 2:
                    String codigo = lerCodigo();
                    if (codigo != null && !codigo.trim().isEmpty()) {
                        Disciplina d = cadDisciplinas.pesquisarDisciplina(codigo);
                        if (d != null) {
                            JOptionPane.showMessageDialog(null, d.toString());
                        } else {
                            JOptionPane.showMessageDialog(null, "Disciplina não encontrada.");
                        }
                    }
                    break;

                case 3:
                    codigo = lerCodigo();
                    if (codigo != null && !codigo.trim().isEmpty()) {
                        Disciplina novoCadastro = dadosNovaDisciplina(cadDisciplinas);
                        if (novoCadastro != null) {
                            boolean atualizado = cadDisciplinas.atualizarDisciplina(codigo, novoCadastro);
                            if (atualizado) {
                                JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
                            } else {
                                JOptionPane.showMessageDialog(null, "Disciplina com o código fornecido não encontrada.");
                            }
                        }
                    }
                    break;

                case 4:
                    codigo = lerCodigo();
                    if (codigo != null && !codigo.trim().isEmpty()) {
                        Disciplina remover = cadDisciplinas.pesquisarDisciplina(codigo);
                        if (remover != null) {
                            boolean removido = cadDisciplinas.removerDisciplina(remover);
                            if (removido) {
                                JOptionPane.showMessageDialog(null, "Disciplina removida do cadastro.");
                            } else {
                                JOptionPane.showMessageDialog(null, "Falha ao remover a disciplina.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Disciplina não encontrada.");
                        }
                    }
                    break;

                case 0:

                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }
}
