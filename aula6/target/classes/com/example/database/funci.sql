CREATE DATABASE GestaoFuncionarios;
USE GestaoFuncionarios;

CREATE TABLE `gestaofuncionarios`.`dadospessoais` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome_completo` VARCHAR(45) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `sexo` CHAR(1) NOT NULL,
  `estado_civil` VARCHAR(15) NOT NULL,
  `conjuge` VARCHAR(45) NULL,
  `dependentes` VARCHAR(150) NULL,
  `nacionalidade` VARCHAR(45) NOT NULL,
  `naturalidade` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(15) NOT NULL,
  `rg` VARCHAR(15) NOT NULL,
  `endereco` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(20) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `filiacao` VARCHAR(150) NOT NULL,
  `tipo_sanguineo` VARCHAR(3) NOT NULL,
  `contato_emergencia` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nome_completo_UNIQUE` (`id` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  UNIQUE INDEX `telefone_UNIQUE` (`telefone` ASC),
  UNIQUE INDEX `rg_UNIQUE` (`rg` ASC),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC));

CREATE TABLE `gestaofuncionarios`.`dadosprofissionais` (
  `idprof` INT NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE,
  `cargo` VARCHAR(30) NOT NULL,
  `departamento` VARCHAR(45) NOT NULL,
  `funcao` VARCHAR(150) NOT NULL,
  `maquina_opera` VARCHAR(45) NOT NULL,
  `admissao` DATE NOT NULL,
  `salario` VARCHAR(45) NOT NULL,
  `dados_bancarios` VARCHAR(45) NOT NULL,
  `beneficios` VARCHAR(45) NULL,
  `escolaridade` VARCHAR(45) NOT NULL,
  `ctps` VARCHAR(45) NOT NULL,
  `pis_pasesp` VARCHAR(45) NOT NULL,
  `contrato` VARCHAR(45) NOT NULL,
  `horario_trabalho` VARCHAR(45) NOT NULL,
  `acidentes` VARCHAR(200) NULL,
  `advertencias` VARCHAR(200) NULL,
  `dados_pessoais` INT,
  
  FOREIGN KEY (dados_pessoais) REFERENCES dadospessoais(id),
  UNIQUE INDEX `ctps_UNIQUE` (`ctps` ASC),
  UNIQUE INDEX `pis_pasesp_UNIQUE` (`pis_pasesp` ASC),
  UNIQUE INDEX `dados_bancarios_UNIQUE` (`dados_bancarios` ASC));

SELECT * FROM dadospessoais INNER JOIN dadosprofissionais ON  dados_pessoais = id;