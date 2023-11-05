package daos;

import java.util.ArrayList;
import java.util.List;

import dtos.VendasDto;

public class teste {

	public static void main(String[] args) {
		

		VendasDao teste = new VendasDao();
	    List<VendasDto> listaVendas = teste.listarVendas();

	    // Itera sobre a lista e imprime os dados
	    for (VendasDto venda : listaVendas) {
	        System.out.println("ID Venda: " + venda.getId_venda());
	        System.out.println("Valor Venda: " + venda.getValor_venda());
	        System.out.println("Data Venda: " + venda.getDt_venda());
	        System.out.println("------------------------");
	    }
	}
		
		

	}


