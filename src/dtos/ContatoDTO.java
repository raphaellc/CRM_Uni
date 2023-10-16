package src.dtos;

import java.time.LocalDate;

public class ContatoDTO extends PessoaDTO {

    private Long cod_contato;
    private String ocupacao;

    public ContatoDTO(final Long cod_pessoa, final String nome, final LocalDate dt_nasc, final String celular,
        final String email, final Long cod_contato, final Long cod_contato1, final String ocupacao) {
        super(cod_pessoa, nome, dt_nasc, celular, email, cod_contato);
        this.cod_contato = cod_contato1;
        this.ocupacao = ocupacao;
    }
}
