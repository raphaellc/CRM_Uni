package src.controladora;

import src.modelo.ProdutoModelo;

public class Usuario {
        private String nome;
        private List<ProdutoModelo> comprasUsuario;

        public Usuario(String nome) {
            this.nome = nome;
            this.comprasUsuario = new ArrayList<>();
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public List<ProdutoModelo> getComprasUsuario() {
            return comprasUsuario;
        }

        public void adicionarProduto(ProdutoModelo produto) {
            this.comprasUsuario.add(produto);
        }

        public double calcularTotalCompra() {
            double total = 0;
            for (ProdutoModelo produto : comprasUsuario) {
                total += produto.getValor();
            }
            return total;
        }
}
