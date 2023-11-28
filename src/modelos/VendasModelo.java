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
    
    
    public VendasDto buscarVenda(int id_venda) {
    	List<VendasDto> listaVendas = vendas_dao.listarVendas();
    	for (VendasDto venda : listaVendas) {	
	    		if (id_venda != venda.getId_venda()) {
	    			return null;	  
	    		}
    		}
    	return vendas_dao.buscarVenda(id_venda);
    }
    
    
    public boolean atualizarVendaStatus(String status, int id_venda) {
    	List<VendasDto> listaVendas = vendas_dao.listarVendas();
    	for (VendasDto venda : listaVendas) {	
	    		if (id_venda != venda.getId_venda()) {
	    			return false;	  
	    		}
    		}
    	return vendas_dao.atualizarVendaStatus(status, id_venda);
    }
    
    public boolean deletarVendas(int id_venda) {
    	List<VendasDto> listaVendas = vendas_dao.listarVendas();
    	for (VendasDto venda : listaVendas) {	
	    		if (id_venda != venda.getId_venda()) {
	    			return false;	  
	    		}
    		}
    	return vendas_dao.deletarVendas(id_venda);
    }
    
    public List<VendasDto> listarVendas() {
    	return vendas_dao.listarVendas();
    }
    
    
    
}
