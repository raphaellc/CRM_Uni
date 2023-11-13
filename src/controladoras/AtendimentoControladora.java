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

    public void adicionarAtendimento(AtendimentoDto atendimento) {
        ;
    }

    public void alterarAtendimento(AtendimentoDto atendimento){
        ;
    }
    public void removerAtendimento(AtendimentoDto atendimento) {
        ;
    }

    public List<AtendimentoDto> listarAtendimento(){
        return atendimentos;
    }
}
