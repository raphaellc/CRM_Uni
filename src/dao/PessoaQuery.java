package dao;

public interface PessoaQuery {

    String CONSULTAR_TODAS_PESSOAS = "SELECT P.*, "
        + "E.id as 'id_endereco', "
        + "E.uf, "
        + "E.cidade, "
        + "S.nome as 'setor' "
        + "FROM Pessoa P "
        + "LEFT JOIN Setor S ON P.id_setor= S.id "
        + "INNER JOIN Endereco E on P.id = E.id_pessoa";

    String CRIAR_PESSOA = "INSERT INTO Pessoa(nome, data_nascimento, email, ocupacao, data_hora_origem, celular, origem, tipo_pessoa) "
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    String CRIAR_ENDERECO = "INSERT INTO Endereco(uf, cidade, id_pessoa) "
        + "VALUES(?, ?, ?)";

    String DELETAR_PESSOA_ID = "DELETE FROM Pessoa WHERE id = ?";
}
