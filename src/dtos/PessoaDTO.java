package src.dtos;

import java.time.LocalDate;

public class PessoaDTO {

    private Long cod_pessoa;
    private String nome;
    private LocalDate dt_nasc;
    private String celular;
    private String email;
    private Long cod_contato;

    public PessoaDTO(final Long cod_pessoa, final String nome, final LocalDate dt_nasc, final String celular,
        final String email, final Long cod_contato) {
        this.cod_pessoa = cod_pessoa;
        this.nome = nome;
        this.dt_nasc = dt_nasc;
        this.celular = celular;
        this.email = email;
        this.cod_contato = cod_contato;
    }
}
