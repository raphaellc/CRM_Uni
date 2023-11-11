package controladoras;

import java.util.ArrayList;
import java.util.List;

import dtos.VendasDto;
import visoes.*;
import modelos.VendasModelo;


public class VendasControladora {
	
	private List<VendasDto> vendas;
    private VendasModelo vendas_modelo;
    private VendasModelo model;
    private VendasVisao viewer;
	
	// ---------------------- CONSTRUTORES --------------------------------
    
	
	public VendasControladora() {
		
        vendas = new ArrayList<>();
        vendas_modelo = new VendasModelo();

	}
	
	
	public VendasControladora(VendasModelo model) {
		super();
		this.model = model;
	}
	
	public VendasControladora(VendasVisao viewer) {
		super();
		this.viewer = viewer;
	}


	// -------------------- METODOS PARA CONTROLAR MODELO -------------------------------------

    public boolean adicionarVenda(VendasDto contato) {
    	if (contato != null) {
    		vendas.add(contato);  	
    		return vendas_modelo.adicionarVenda(contato);
    	}
    	return false;
    }
    
    public VendasDto buscarVenda(int id_venda) {
    	return vendas_modelo.buscarVenda(id_venda);
    }
    
    
    public boolean atualizarVendaStatus(String status, int id_venda) {
    	return vendas_modelo.atualizarVendaStatus(status, id_venda);
    }
    
    
    
    
    	
	// Objetos de visao
	
	
	
	

}
