package src.visao;

import javax.swing.*;

public class RelatorioView extends JFrame {

    public void Tela(){

        setTitle("Relatorio");
        setVisible(true);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }


    /**public void mostrarDetalhesVenda(String nomeCliente, double valor) {
        System.out.println("Detalhes da Venda:");
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Valor Total: R$" + valor);
    }**/
}
