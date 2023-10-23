# CRM_Uni
Aplicação desenvolvida para a Atividade Acadêmica de Implementação de Software - 2023/2
# Gerência de Configuração de Software
## Documentação do Projeto
### Modelos
https://drive.google.com/file/d/1Mj9ORK-28S2fFJ-rjff1-8mJHN2TSv2Y/view
### Requisitos
https://www.moodle.unisinos.br/mod/resource/view.php?id=1694905
Moodle
### Repositório de Referência
https://github.com/raphaellc/CRM_EM.git
## Ferramentas
- Oracle Java OpenJDK version 20.0.2
- MySQL 8.0.34
- MySQL Server 8.0 2
- IntelliJ IDEA 2021.3.3 (Ultimate Edition)
- Build #IU-213.7172.25, built on March 15, 2022
## Ambientes e Infraestrutura
- MySQL 8.0
```
  CREATE SCHEMA `crmuni` DEFAULT CHARACTER SET utf8 ;
```
- MySQL 8.0
```
  CREATE TABLE `pessoas` (
  `id_pessoas` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_la_0900_ai_ci NOT NULL,
  `dt_nasc` date DEFAULT NULL,
  `celular` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_la_0900_ai_ci DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_la_0900_ai_ci DEFAULT NULL,
  `id_setor` int NOT NULL,
  `ocupacao` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_la_0900_ai_ci DEFAULT NULL,
  `id_origem` int DEFAULT NULL,
  `dt_hr_origem` datetime DEFAULT NULL,
  `id_tipo_pessoa` int NOT NULL,
  PRIMARY KEY (`id_pessoas`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_la_0900_ai_ci
```
# Identificação da configuração
## Métodos de Identificação 
## Baselines do Projeto
## Estrutura do Repositório
- \CRM_Uni
  - \src
      - \controladoras
      - \daos
      - \dtos
      - \modelos
      - \visoes
## Modelo de Colaboração
    
