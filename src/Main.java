import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import dao.PessoaDAO;
import dto.PessoaDTO;

public class Main {

    public static void main(String[] args) {
        final PessoaDAO pessoaDAO = new PessoaDAO();
        final PessoaDTO pessoa = new PessoaDTO();

        pessoa.setNome("Teste 2");
        pessoa.setCelular("(51) 99999-9999");
        pessoa.setOrigem("Campanha 1");
        pessoa.setOcupacao("Desenvolvedor Front-End");
        pessoa.setEmail("fulano@example.com");
        pessoa.setDt_nasc(LocalDate.of(2001, 5, 5));
        pessoa.setDt_hr_origem(LocalDateTime.now());
        pessoa.setTipo_pessoa("Contato");

        final PessoaDTO pessoaInserida = pessoaDAO.criar(pessoa);
        

        System.out.println("ID da pessoa inserida: " + pessoaInserida);
    }

}
