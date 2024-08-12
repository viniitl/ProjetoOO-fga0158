package app;

public class Disciplina{
    private String nome;
    private String codigo;

    public Disciplina(String nome, String codigo) {
        if (nome == null || nome.trim().isEmpty() || codigo == null || codigo.trim().isEmpty()) {
            throw new RuntimeException("CampoEmBrancoException");
        }
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "nome='" + nome + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}