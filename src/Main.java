import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.swing.JFrame;

import controladora.PessoaControladora;
import dao.PessoaDAO;
import dto.EnderecoDTO;
import dto.PessoaDTO;
import visao.TelaCadastroContato;
import visao.TelaListagemContato;

// TODO: Excluir classe depois da integração com a Main

public class Main {

    public static void main(final String[] args) {
        final PessoaControladora controladora = new PessoaControladora();
        final JFrame tela = new TelaCadastroContato("CRMUni", controladora);
        tela.setVisible(true);
    }

    private static void mainConsulta() {
        final PessoaDAO pessoaDAO = new PessoaDAO();

        final List<PessoaDTO> pessoas = pessoaDAO.consultarTodos();

        System.out.println(pessoas);
    }

    private static void mainCadastro() {
        final PessoaDAO pessoaDAO = new PessoaDAO();

        // Cria Pessoa DTO
        final PessoaDTO pessoa = new PessoaDTO();
        pessoa.setNome("Teste 3");
        pessoa.setCelular("5199999-9999");
        pessoa.setId_origem(2L);
        pessoa.setOcupacao("Desenvolvedor Front-End");
        pessoa.setEmail("fulano@example.com");
        pessoa.setDt_nasc(LocalDate.of(2001, 5, 5));
        pessoa.setDt_hr_origem(LocalDateTime.now());

        final EnderecoDTO endereco = new EnderecoDTO();
        endereco.setLogradouro("Rua 24 Agosto");
        endereco.setNumero("1234");
        endereco.setComplemento("Casa");
        endereco.setBairro("Liberdade");
        endereco.setCidade("Esteio");
        endereco.setEstado("RS");
        endereco.setCep("99999999");

        pessoa.setEndereco(endereco);

        final PessoaDTO pessoaInserida = pessoaDAO.criarContato(pessoa);

        System.out.println("ID da pessoa inserida: " + pessoaInserida);
    }

    private static void mainDelete() {
        final PessoaDAO pessoaDAO = new PessoaDAO();

        pessoaDAO.deletar(8L);
    }

}
