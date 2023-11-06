import java.util.ArrayList;
import java.util.List;

public class EquipeVendasC {

    private List<VendaC> vendas = new ArrayList<>();

    public void adicionarVenda(VendaC venda) {
        vendas.add(venda);
    }

    public List<VendaC> getVendas() {
        return vendas;
    }
}