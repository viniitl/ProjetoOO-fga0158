package view;

import app.Professor;

import cadastros.CadastroProfessores;

import javax.swing.*;

public class MenuProfessor {
    public static Professor dadosNovoProfessor(){
            String nome = lerNome();
            if(nome.isEmpty()){
                throw new RuntimeException("CampoEmBrancoException");
            }
            String cpf = lerCPF();
            if(cpf.isEmpty()){
                throw new RuntimeException("CampoEmBrancoException");
            }
            String email = lerEmail();
            if(email.isEmpty()){
                throw new RuntimeException("CampoEmBrancoException");
            }
            String areaFormacao = lerAreaFormacao();
            if(areaFormacao.isEmpty()){
                throw new RuntimeException("CampoEmBrancoException");
            }
            String matriculaFub = lerMatriculaFUB();
            if(matriculaFub.isEmpty()){
                throw new RuntimeException("CampoEmBrancoException");
            }
            return new Professor(nome, cpf, email, areaFormacao, matriculaFub);
    }

    private static String lerNome() {
        return JOptionPane.showInputDialog("Informe o nome do professor: ");
    }
    private static String lerCPF() {
        return JOptionPane.showInputDialog("Informe o CPF do professor: ");
    }
    static String lerEmail() {
        return JOptionPane.showInputDialog("Informe o email do professor: ");
    }
    static String lerAreaFormacao(){
        return JOptionPane.showInputDialog("Informe a área de formação do professor: ");

    }
    static String lerMatriculaFUB(){
        return JOptionPane.showInputDialog("Informe a MatriculaFUB do professor: ");
    }
    public static void menuProfessor(CadastroProfessores cadProfessor) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar Professor\n"
                + "2 - Pesquisar Professor\n"
                + "3 - Atualizar Professor\n"
                + "4 - Remover Professor\n"
                + "0 - Voltar para menu anterior";

        int opcao=-1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    Professor novoProfessor = dadosNovoProfessor() ;
                    cadProfessor.cadastrarProfessor(novoProfessor);
                    break;

                case 2:
                    String matriculaFub = lerMatriculaFUB();
                    Professor p = cadProfessor.pesquisarProfessor(matriculaFub);
                    if (p != null)
                        JOptionPane.showMessageDialog(null, p.toString());
                    break;

                case 3:
                    matriculaFub = lerMatriculaFUB();
                    Professor novoCadastro = dadosNovoProfessor();
                    boolean atualizado = cadProfessor.atualizarProfessor(matriculaFub, novoCadastro);
                    if (atualizado) {
                        JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
                    }
                    break;

                case 4:
                    matriculaFub = lerMatriculaFUB();
                    Professor remover = cadProfessor.pesquisarProfessor(matriculaFub);
                    boolean removido = cadProfessor.removerProfessor(matriculaFub);
                    if (removido) {
                        JOptionPane.showMessageDialog(null, "Professor removido do cadastro");
                        System.gc();
                    }

                default:
                    break;
            }
        } while (opcao != 0);
        return;
    }
}
