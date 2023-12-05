package modelos;

import java.util.ArrayList;
import java.util.List;

import daos.ProdutoDao;
import dtos.ProdutoDto;

public class ProdutoModelo {
	
	private List<ProdutoDto> produtos;
    private ProdutoDao produto_dao;

    public ProdutoModelo() {
  
        produtos = new ArrayList<ProdutoDto>();
        produto_dao = new ProdutoDao();     }
    
    
    public boolean adicionarProduto(ProdutoDto produto) {
    	produtos.add(produto);
        return produto_dao.adicionarProduto(produto);
    }
    
    
    public ProdutoDto buscarProduto(int id_produto) {
    	List<ProdutoDto> listaProdutos = produto_dao.listarProdutos();
    	for (ProdutoDto produto : listaProdutos) {	
	    		if (id_produto != produto.getId_produto()) {
	    			return null;	  
	    		}
    		}
    	return produto_dao.buscarProduto(id_produto);
    }
    
    
    public boolean atualizarProduto(double valor_unitario, int id_produto) {
    	List<ProdutoDto> listaProdutos = produto_dao.listarProdutos();
    	for (ProdutoDto produto : listaProdutos) {	
	    		if (id_produto != produto.getId_produto()) {
	    			return false;	  
	    		}
    		}
    	return produto_dao.atualizarProduto(valor_unitario, id_produto);
    }
    
    public boolean deletarProduto(int id_produto) {
    	List<ProdutoDto> listaProdutos = produto_dao.listarProdutos();
    	for (ProdutoDto produto : listaProdutos) {	
	    		if (id_produto != produto.getId_produto()) {
	    			return false;	  
	    		}
    		}
    	return produto_dao.deletarProduto(id_produto);
    }
    
    public List<ProdutoDto> listarVendas() {
    	return produto_dao.listarProdutos();
    }

}
