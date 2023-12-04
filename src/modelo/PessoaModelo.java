package modelo;

import static java.util.Objects.nonNull;
import static util.ValorUtil.isEmptyString;

import java.util.List;

import dao.PessoaDAO;
import dao.conexao.ConexaoStrategy;
import dao.conexao.ConexaoUtil;
import dto.EnderecoDTO;
import dto.PessoaDTO;

public class PessoaModelo {

    private final PessoaDAO pessoaDAO;

    public PessoaModelo(final String tipoBanco) {
        final ConexaoStrategy conexao = ConexaoUtil.escolherNome(tipoBanco);
        pessoaDAO = new PessoaDAO(conexao);
    }

    public PessoaModelo() {
        pessoaDAO = new PessoaDAO();
    }

    public boolean cadastrar(final PessoaDTO dados) {

        if (nonNull(dados.getEndereco())) {
            final EnderecoDTO endereco = dados.getEndereco();

            if (isEmptyString(endereco.getEstado())) {
                return false;
            }

            if (isEmptyString(endereco.getCidade())) {
                return false;
            }
        }

        if (pessoaDAO.existeEmail(dados.getEmail())) {
            return false;
        }

        final PessoaDTO retornoConsultar = pessoaDAO.criarContato(dados);

        return nonNull(retornoConsultar);
    }

    public boolean atualizar(final PessoaDTO dados) {

        if (nonNull(dados.getEndereco())) {
            final EnderecoDTO endereco = dados.getEndereco();

            if (isEmptyString(endereco.getEstado())) {
                return false;
            }

            if (isEmptyString(endereco.getCidade())) {
                return false;
            }
        }

        final PessoaDTO retornoConsultar = pessoaDAO.atualizarContato(dados);

        return nonNull(retornoConsultar);
    }

    public List<PessoaDTO> consultarTodos() {
        return pessoaDAO.consultarTodos();
    }

    public PessoaDTO consultarID(final Long ID) {
        return pessoaDAO.consultarID(ID);
    }

    public void deletar(final Long ID) {
        pessoaDAO.deletar(ID);
    }
}
