package controladoras;

import java.util.ArrayList;
import java.util.List;
import dtos.AtendimentoDto;
import modelos.Atendimento;


public class AtendimentoControladora {
    private List<AtendimentoDto> atendimentos;
    private Atendimento atendimento;
    public AtendimentoControladora(){

        atendimentos = new ArrayList<>();
        atendimento = new Atendimento();

    }

    public boolean adicionarAtendimento(AtendimentoDto atendimento) {
        atendimentos.add(atendimento);
        if (atendimento != null){
            return this.atendimento.adicionarAtendimento(atendimento);
        }
        return false;
    }

    public void alterarAtendimento(AtendimentoDto atendimento){
        ; //Implementar alteração de atendimentos.
    }
    public boolean removerAtendimento(int id_atendimento) {
        atendimentos.removeIf(atendimento -> atendimento.getIdAtendimento() == id_atendimento);
        return this.atendimento.removerAtendimento(id_atendimento);
    }

    public List<AtendimentoDto> listarAtendimento(){
        return this.atendimento.listarAtendimentos();
    }
}
