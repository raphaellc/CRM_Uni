package modelos;

import java.util.ArrayList;
import java.util.List;
import daos.VendasDao;
import dtos.VendasDto;



public class VendasModelo {
	
	private List<VendasDto> vendas;
    private VendasDao vendas_dao;
    
<<<<<<< HEAD
    
    
=======
>>>>>>> 9ef97759a8d2e8fd5b67398eee912583a4f29b28
    public VendasModelo() {
  
        vendas = new ArrayList<VendasDto>();
        vendas_dao = new VendasDao();     }
    
    
    public boolean adicionarVenda(VendasDto contato) {
        vendas.add(contato);
        return vendas_dao.adicionarVendas(contato);
<<<<<<< HEAD
        

        
        
        
        
=======
   
>>>>>>> 9ef97759a8d2e8fd5b67398eee912583a4f29b28
    }
}
