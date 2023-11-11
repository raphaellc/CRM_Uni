package src.visao;

public class VendaView {
    public void mostrarDetalhesVenda(String nomeCliente, double valor) {
        System.out.println("Detalhes da Venda:");
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Valor Total: R$" + valor);
    }
}
