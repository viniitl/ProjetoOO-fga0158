import javax.swing.JOptionPane;
import cadastros.CadastroTurmas;
import cadastros.CadastroAluno;
import cadastros.CadastroDisciplinas;
import cadastros.CadastroProfessores;
import view.*;

public class Principal {

	static CadastroAluno cadAluno;
	static CadastroProfessores cadProfessores;
	static CadastroDisciplinas cadDisciplinas;
	static CadastroTurmas cadTurmas;

	public static void main(String[] args) {
		cadAluno = new CadastroAluno();
		cadProfessores = new CadastroProfessores();
		cadDisciplinas = new CadastroDisciplinas();
		cadTurmas = new CadastroTurmas();
		int opcao = 0;

		do {
				opcao = MenuPrincipal.menuOpcoes();

				switch (opcao) {
					case 1:
						try {
							MenuAluno.menuAluno(cadAluno);
							break;
						}catch(RuntimeException e){
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
					case 2:
						try {
							MenuProfessor.menuProfessor(cadProfessores);
							break;
						}catch(RuntimeException e){
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
					case 3:
						try {
							MenuDisciplina.menuDisciplinas(cadDisciplinas);
						}catch(RuntimeException e){
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
						break;
					case 4:
						try {
							MenuTurma.menuTurmas(cadTurmas, cadDisciplinas, cadProfessores, cadAluno);
							break;
						}catch(RuntimeException e){
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
					case 0:
						JOptionPane.showMessageDialog(null, "Saindo do sistema...");
						break;
					default:
						JOptionPane.showMessageDialog(null, "Opção inválida");
						opcao = -1;
						break;
				}

		} while (opcao != 0);
	}
}

