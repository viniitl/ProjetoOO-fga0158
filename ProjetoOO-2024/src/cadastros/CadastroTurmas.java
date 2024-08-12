package cadastros;

import app.Turma;

import java.util.ArrayList;
import java.util.List;

public class CadastroTurmas {
    int numTurmas;

    private List<Turma>turmas;

    public CadastroTurmas(){
        numTurmas = 0;
        turmas = new ArrayList<Turma>();
    }
    public int cadastrarTurma(Turma t) {
        boolean cadastrou = turmas.add(t);
        if (cadastrou) {
            numTurmas = turmas.size();
        }
        return numTurmas;
    }

    public Turma pesquisarTurmas(String codigo){
        for(Turma t : turmas){
            if(t.getCodigo().equals(codigo)){
                return t;
            }
        }
        return null;
    }
    public boolean removerTurma(Turma t) {
        boolean removeu = false;
        if (turmas.contains(t)) {
            removeu = turmas.remove(t);
        }
        return removeu;
    }
    public boolean atualizarTurma(String codigo, Turma t) {
        boolean resposta = false;
        Turma remover = pesquisarTurmas(codigo);
        if (remover != null) {
            turmas.remove(remover);
            resposta = turmas.add(t);
        }
        return resposta;
    }
}
