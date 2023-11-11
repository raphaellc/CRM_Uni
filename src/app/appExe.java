package app;

import java.awt.EventQueue;

import controladoras.VendasControladora;
import modelos.VendasModelo;
import visoes.BuscaClientesVisao;
import visoes.BuscaProdutoVisao;
import visoes.BuscaVendedorVisao;
import visoes.VendasVisao;

public class appExe {

	public static void main(String[] args) {
		
		VendasModelo vendasModelo = new VendasModelo();
		
		VendasControladora vendasControladora = new VendasControladora(vendasModelo);
		
		VendasVisao vendasVisao = new VendasVisao(vendasControladora);
		
		BuscaVendedorVisao buscaVendedorVisao = new BuscaVendedorVisao(vendasControladora);
		
		BuscaClientesVisao buscaClientesVisao = new BuscaClientesVisao(vendasControladora);
		
		BuscaProdutoVisao buscaProdutoVisao = new BuscaProdutoVisao(vendasControladora);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vendasVisao.getFrame().setVisible(true);
					buscaVendedorVisao.getFrame();
					buscaClientesVisao.getFrame();
					buscaProdutoVisao.getFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
