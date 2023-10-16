package dao.conexao;

import static java.util.Objects.isNull;

import java.util.List;

public class ConexaoContext {

    private List<ConexaoStrategy> conexoes;

    public ConexaoContext() {
        conexoes = List.of(new ConexaoMySQL());
    }

    public ConexaoStrategy escolher(final String nomeBanco) {
        if (isNull(nomeBanco) || nomeBanco.isBlank()) {
            return new ConexaoMySQL();
        }

        return conexoes.stream()
            .filter(conexao -> conexao.getNomeBanco().equals(nomeBanco))
            .findFirst()
            .orElse(new ConexaoMySQL());
    }
}
