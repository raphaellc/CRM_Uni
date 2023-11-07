package modelos;

import java.util.ArrayList;
import java.util.List;
import daos.VendasDao;
import dtos.VendasDto;



public class VendasModelo {
	
	private List<VendasDto> vendas;
    private VendasDao vendas_dao;
    
    public VendasModelo() {
  
        vendas = new ArrayList<VendasDto>();
        vendas_dao = new VendasDao();     }
    
    public boolean adicionarVenda(VendasDto contato) {
        vendas.add(contato);
        return vendas_dao.adicionarVendas(contato);
   
    }
}
