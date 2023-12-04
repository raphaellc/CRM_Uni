package src.controladora;

import java.util.List;
import src.dto.AnaliseVendasDto;

public class AnaliseVendasC {

    private List<AnaliseVendasDto> vendas;
    private AnaliseVendasDto venda;
    private AnaliseVendasDto produto_mais_vendido;

    public AnaliseVendasC() {}


    public List<AnaliseVendasDto> listarVendas() {
        return this.listarVendas();
    }

    public AnaliseVendasDto identificaProdutoMaisVendido (AnaliseVendasDto produto_mais_vendido){
        return this.produto_mais_vendido;
                
    }
}
