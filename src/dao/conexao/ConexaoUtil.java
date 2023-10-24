package dao.conexao;

public class ConexaoUtil {

    public static ConexaoStrategy escolherNome(final String nome){
        return new ConexaoContext().escolher(nome);
    }

}
