package src.modelo;

import src.dto.AnaliseAtendimentoDto;
import src.dto.AnaliseVendasDto;

import java.util.List;

public class DesempenhoVendedorModelo {

    /**

    private List<AnaliseVendasDto> lista_de_vendas;

    public AnaliseVendasDto buscarVendas(int id_venda){
        List<AnaliseVendasDto> listaVendas = vendas_dao.listarVendas();
        for (AnaliseVendasDto venda : listaVendas) {
            if (id_venda != venda.getId_venda()) {
                return null;
            }
        }
        return AnaliseVendasDto.buscarVenda(id_venda);
    }


    private AnaliseAtendimentoDto duracao_atendimento;
    public AnaliseAtendimentoDto tempoMedioDeAtendimento(AnaliseAtendimentoDto duracao_atendimento) {
        return duracao_atendimento;
    } **/


    /**
    public AnaliseAtendimentoDto taxaDeConversao(List<AnaliseAtendimentoDto> lista_de_vendas) {
        if(lista_de_vendas.isVenda_fechada())
        return lista_de_vendas;
    }
     **/
}
