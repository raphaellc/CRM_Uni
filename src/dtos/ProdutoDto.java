package dtos;

public class ProdutoDto {
	
	private int id_produto;
	private int qtd_produto;
	private double valor_unitario;
	private String descricao_produto;
	
	
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
	
	public String getDescricao_produto() {
		return descricao_produto;
	}
	public void setDescricao_produto(String descricao_produto) {
		this.descricao_produto = descricao_produto;
	}
	
	public ProdutoDto() {
		
	}
	
	
	public ProdutoDto(int id_produto, int qtd_produto, double valor_unitario, String descricao_produto) {
		super();
		this.id_produto = id_produto;
		this.qtd_produto = qtd_produto;
		this.valor_unitario = valor_unitario;
		this.descricao_produto = descricao_produto;
	}
	
	
	

}
