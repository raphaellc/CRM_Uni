package dtos;

public class ProdutoDto {
	
	private int id_produto;
	private int qtd_produto;
	private double valor_unitario;
	
	
	public int getId_produto() {
		return id_produto;
	}
	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}
	public int getQtd_produto() {
		return qtd_produto;
	}
	public void setQtd_produto(int qtd_produto) {
		this.qtd_produto = qtd_produto;
	}
	public double getValor_unitario() {
		return valor_unitario;
	}
	public void setValor_unitario(double valor_unitario) {
		this.valor_unitario = valor_unitario;
	}
	
	
	
	public ProdutoDto(int id_produto, int qtd_produto, double valor_unitario) {
		super();
		this.id_produto = id_produto;
		this.qtd_produto = qtd_produto;
		this.valor_unitario = valor_unitario;
	}
	
	
	

}
