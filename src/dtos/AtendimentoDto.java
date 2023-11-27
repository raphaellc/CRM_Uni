package dtos;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class AtendimentoDto {
    private int idAtendimento;
    private int idPessoa;
    private int idCategoria;
    private int idResponsavel;
    private int idProduto;
    private LocalDate dtAbertura;
    private LocalDate dtResolucao;
    private String descProblema;
    private int prioridadeCaso;
    private String statusAtualizacao;
    private LocalDate dtAtualizacao;
    private String descAtualizacao;


    //Construtor

    public AtendimentoDto() {
    }

    //Getters e Setters

    public int getIdAtendimento() {
        return idAtendimento;
    }
    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }
    public int getIdPessoa() {
        return idPessoa;
    }
    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }
    public int getIdCategoria() {
        return idCategoria;
    }
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    public int getIdResponsavel() {
        return idResponsavel;
    }
    public void setIdResponsavel(int idResponsavel) {
        this.idResponsavel = idResponsavel;
    }
    public int getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    public LocalDate getDtAbertura() {
        return dtAbertura;
    }
    public void setDtAbertura(LocalDate dtAbertura) {
        this.dtAbertura = dtAbertura;
    }
    public LocalDate getDtResolucao() {
        return dtResolucao;
    }
    public void setDtResolucao(LocalDate dtResolucao) {
        this.dtResolucao = dtResolucao;
    }
    public String getDescProblema() {
        return descProblema;
    }
    public void setDescProblema(String descProblema) {
        this.descProblema = descProblema;
    }
    public int getPrioridadeCaso() {
        return prioridadeCaso;
    }
    public String getStatusAtualizacao() {
        return statusAtualizacao;
    }
    public void setStatusAtualizacao(String statusAtualizacao) {
        this.statusAtualizacao = statusAtualizacao;
    }
    public LocalDate getDtAtualizacao() {
        return dtAtualizacao;
    }
    public void setDtAtualizacao(LocalDate dtAtualizacao) {
        this.dtAtualizacao = dtAtualizacao;
    }
    public String getDescAtualizacao() {
        return descAtualizacao;
    }
    public void setDescAtualizacao(String descAtualizacao) {
        this.descAtualizacao = descAtualizacao;
    }



    public String getPrioridadeCasoString() {
        switch (prioridadeCaso) {
            case 1:
                return "Alta";
            case 2:
                return "Média";
            case 3:
                return "Baixa";
            default:
                throw new IllegalArgumentException("Prioridade desconhecida: " + prioridadeCaso);
        }
    }

    // Mapeia prioridadeCaso para um valor inteiro
    public void setPrioridadeCaso(int prioridadeCaso) {
        this.prioridadeCaso = prioridadeCaso;
    }

    public String toString() {
        return "AtendimentoDto{" +
                "idAtendimento=" + idAtendimento +
                ", idResponsavel=" + idResponsavel +
                ", dtAbertura=" + dtAbertura +
                ", dtResolucao=" + dtResolucao +
                ", descProblema='" + descProblema + '\'' +
                ", idCategoria=" + idCategoria +
                ", prioridadeCaso=" + prioridadeCaso +
                ", statusAtualizacao='" + statusAtualizacao + '\'' +
                ", dtAtualizacao=" + dtAtualizacao +
                ", descAtualizacao='" + descAtualizacao + '\'' +
                '}'
                ;
    }

}