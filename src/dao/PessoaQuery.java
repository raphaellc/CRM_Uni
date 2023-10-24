package dao;

public interface PessoaQuery {

    String CONSULTAR_TODAS_PESSOAS = "SELECT P.*, "
        + "S.descricao as 'setor', "
        + "C.descricao as 'cargo', "
        + "E.id_endereco, "
        + "E.logradouro, "
        + "E.numero, "
        + "E.complemento, "
        + "E.bairro, "
        + "E.cidade, "
        + "E.estado, "
        + "E.cep "
        + "FROM Pessoa P "
        + "LEFT JOIN Setor_Pessoa S ON P.id_setor= S.id_setor_pessoa "
        + "LEFT JOIN Cargo_Pessoa C on P.id_cargo = C.id_cargo_pessoa "
        + "LEFT JOIN Endereco E on P.id_pessoa = E.id_pessoa";


    String CRIAR_PESSOA = "INSERT INTO Pessoa(nome, data_nascimento, email, ocupacao, data_hora_origem, celular, id_origem) "
        + "VALUES (?, ?, ?, ?, ?, ?, ?)";

    String CRIAR_ENDERECO = "INSERT INTO Endereco(logradouro, numero, complemento, bairro, cidade, estado, cep, id_pessoa) "
        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

    String DELETAR_PESSOA_ID = "DELETE FROM Pessoa WHERE id_pessoa = ?";
}
