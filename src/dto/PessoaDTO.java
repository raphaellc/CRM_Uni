package dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PessoaDTO {

    private Long id_pessoa;
    private String nome;
    private EnderecoDTO endereco;
    private LocalDate dt_nasc;
    private String celular;
    private String email;
    private String setor;
    private String ocupacao;
    private String origem;
    private LocalDateTime dt_hr_origem;
    private String tipo_pessoa;


    public Long getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(final Long id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(final EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public LocalDate getDt_nasc() {
        return dt_nasc;
    }

    public void setDt_nasc(final LocalDate dt_nasc) {
        this.dt_nasc = dt_nasc;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(final String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(final String setor) {
        this.setor = setor;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(final String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(final String origem) {
        this.origem = origem;
    }

    public LocalDateTime getDt_hr_origem() {
        return dt_hr_origem;
    }

    public void setDt_hr_origem(final LocalDateTime dt_hr_origem) {
        this.dt_hr_origem = dt_hr_origem;
    }

    public String getTipo_pessoa() {
        return tipo_pessoa;
    }

    public void setTipo_pessoa(final String tipo_pessoa) {
        this.tipo_pessoa = tipo_pessoa;
    }

    @Override
    public String toString() {
        return "PessoaDTO {" +
            "id_pessoa=" + id_pessoa +
            ", nome='" + nome + '\'' +
            ", endereco=" + endereco +
            ", dt_nasc=" + dt_nasc +
            ", celular='" + celular + '\'' +
            ", email='" + email + '\'' +
            ", setor='" + setor + '\'' +
            ", ocupacao='" + ocupacao + '\'' +
            ", origem='" + origem + '\'' +
            ", dt_hr_origem=" + dt_hr_origem +
            ", tipo_pessoa='" + tipo_pessoa + '\'' +
            '}';
    }
}
