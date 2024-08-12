package app;

public class Professor extends PessoaFisica{

	String areaFormacao,
	       matriculaFUB;


	public Professor(String nome, String cpf, String email, String areaFormacao, String matriculaFUB) {
		super(nome, cpf, email);
		this.areaFormacao = areaFormacao;
		this.matriculaFUB = matriculaFUB;
	}

	public String getAreaFormacao() {
		return areaFormacao;
	}

	public String getMatriculaFUB() {
		return matriculaFUB;
	}

	protected void finalize() throws Throwable {
		System.out.println("Destruindo objeto: " + this);
	}
	@Override
	public String toString() {
		String resposta = super.toString();
		resposta += "ÁREA DE FORMAÇÃO: " + areaFormacao + '\n';
		resposta += "MATRÍCULA FUB: " + matriculaFUB + '\n';
		return resposta;
	}
}
