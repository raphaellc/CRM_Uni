package src.modelo;

import src.dto.AnaliseAtendimentoDto;
import java.util.List;

public class DesempenhoVendedorModelo {

    private List<AnaliseAtendimentoDto> lista_de_vendas;

    private AnaliseAtendimentoDto duracao_atendimento;
    public AnaliseAtendimentoDto tempoMedioDeAtendimento(AnaliseAtendimentoDto duracao_atendimento) {
        return duracao_atendimento;
    }
    /**
    public AnaliseAtendimentoDto taxaDeConversao(List<AnaliseAtendimentoDto> lista_de_vendas) {
        if(lista_de_vendas.isVenda_fechada())
        return lista_de_vendas;
    }
     **/
}
