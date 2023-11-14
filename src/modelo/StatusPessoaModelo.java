import dao.StatusPessoaDAO;
import dao.Conexao; // Certifique-se de ajustar o import para a sua classe de conexão
import dto.StatusPessoaDTO;

import java.util.ArrayList;
import java.util.List;

public class StatusPessoaModelo {
    private List<StatusPessoaDTO> statusPessoa;
    private StatusPessoaDAO statusPessoaDAO;
    private Conexao conexao;

    public StatusPessoaModelo() {
        conexao = new Conexao(); // Certifique-se de ajustar para a sua classe de conexão
        statusPessoaDAO = new StatusPessoaDAO(conexao.getConnection()); // Ajuste conforme necessário
        statusPessoa = new ArrayList<>();
    }

    public List<StatusPessoaDTO> listarStatusPessoa() {
        return statusPessoaDAO.listarStatusPessoa();
    }

    // Outros métodos relacionados a setores de pessoa podem ser adicionados conforme necessário.
}
