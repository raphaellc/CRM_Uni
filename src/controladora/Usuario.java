package src.controladora;

public class Usuario {
        private String nome;
        private List<ProdutoC> comprasUsuario;

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

        public List<Produto> getComprasUsuario() {
            return comprasUsuario;
        }

        public void adicionarProduto(Produto produto) {
            this.comprasUsuario.add(produto);
        }

        public double calcularTotalCompra() {
            double total = 0;
            for (Produto produto : comprasUsuario) {
                total += produto.getValor();
            }
            return total;
        }
}
