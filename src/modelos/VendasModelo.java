package modelos;

import java.util.Date;

public class VendasModelo {
	
	private int id_venda;
	private float valor_venda;
	private Date dt_venda;
	
	// -------------- Getters and Setters ---------------
	
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
	
	public Date getDt_venda() {
		return dt_venda;
	}
	
	public void setDt_venda(Date dt_venda) {
		this.dt_venda = dt_venda;
	}

	
	// --------------- Construtores -------------------
	
	public VendasModelo() {
	}
	
	public VendasModelo(int id_venda, float valor_venda, Date dt_venda) {
		super();
		this.id_venda = id_venda;
		this.valor_venda = valor_venda;
		this.dt_venda = dt_venda;
	}
	
	
	
	
	

}
