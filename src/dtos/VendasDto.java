package dtos;



public class VendasDto {
	
	private int id_venda;
	private float valor_venda;
	private String dt_venda;
	private String status;

	
	
	
	// ---------------- Getters and Setters --------------
	
	public int getId_venda() {
		return id_venda;
	}
	
	public void setId_venda(int id_venda) {
		this.id_venda = id_venda;
	}
	
	public float getValor_venda() {
		return valor_venda;
	}
	
	public void setValor_venda(float valor_venda) {
		this.valor_venda = valor_venda;
	}
	
	public String getDt_venda() {
		return dt_venda;
	}
	
	public void setDt_venda(String string) {
		this.dt_venda = string;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	// ---------------- Construtores ----------------
	

	public VendasDto() {}
	
	
	public VendasDto(int id_venda, float valor_venda, String dt_venda, String status) {
		super();
		this.id_venda = id_venda;
		this.valor_venda = valor_venda;
		this.dt_venda = dt_venda;
		this.status = status;
	}
	
	
	
	
	
	
	
	
	
	

}