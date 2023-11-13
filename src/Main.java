import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import dao.PessoaDAO;
import dto.EnderecoDTO;
import dto.PessoaDTO;
import modelo.PessoaModelo;

public class Main {

    public static void main(String[] args) {
//        mainConsulta();
        mainCadastro();
//        mainDelete();
    }

    private static void mainConsulta() {
        final PessoaDAO pessoaDAO = new PessoaDAO();

        pessoaDAO.deletar(7L);

        System.out.println();
    }

    private static void mainCadastro() {
        final PessoaModelo pessoaModelo = new PessoaModelo();

        // Cria Pessoa DTO
        final PessoaDTO pessoa = new PessoaDTO();
        pessoa.setNome("Teste 3");
        pessoa.setCelular("5199999-9999");
        pessoa.setId_origem(2L);
        pessoa.setOcupacao("Desenvolvedor Front-End");
        pessoa.setEmail("fulandddo@example.com");
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

        final boolean pessoaInserida = pessoaModelo.cadastrar(pessoa);

        System.out.println(pessoaInserida);
    }

    private static void mainDelete() {
      final PessoaDAO pessoaDAO = new PessoaDAO();

      pessoaDAO.deletar(8L);
    }

}
