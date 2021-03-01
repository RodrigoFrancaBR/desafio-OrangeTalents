CREATE SCHEMA IF NOT EXISTS `DB_CAV` DEFAULT CHARACTER SET utf8 ;
USE `DB_CAV` ;
-- -----------------------------------------------------
-- Table `DB_CAV`.`TB_PESSOA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_CAV`.`TB_PESSOA` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `dt_nascimento` DATE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_TB_PESSOA_CPF` (`cpf` ASC),
  UNIQUE INDEX `UK_TB_PESSOA_EMAIL` (`email` ASC))
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `DB_CAV`.`TB_VACINA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_CAV`.`TB_VACINA` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(30) NOT NULL,
  `forma_aplicar` VARCHAR(255) NULL COMMENT 'Como e aplicada a vacina oral/injecao',
  `indicacao` VARCHAR(255) NULL COMMENT 'Quem deve tomar',
  `quando_tomar` VARCHAR(255) NULL COMMENT 'Quando preciso tomar ',
  `beneficios` VARCHAR(255) NULL COMMENT 'Quais os benefícios da vacina',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_NOME` (`nome` ASC))
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `DB_CAV`.`TB_VACINACAO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_CAV`.`TB_VACINACAO` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `vacina_id` BIGINT NOT NULL,
  `pessoa_id` BIGINT NOT NULL,
  `dt_vacinacao` DATE NOT NULL,
  `dose` INT NULL DEFAULT 1 COMMENT 'toda vacina inicia no mínimo com a 1ª dose',
  INDEX `IDX_TB_VACINACAO_PESSOA_ID_TB_PESSOA_ID` (`pessoa_id` ASC),
  INDEX `IDX_TB_VACINACAO_VACINA_ID_TB_VACINA_ID` (`vacina_id` ASC),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_TB_VACINACAO_VACINA_ID_DOSE_PESSOA_ID` (`vacina_id` ASC, `pessoa_id` ASC, `dose` ASC)  COMMENT 'vacina A na dose 1 para pessoa X\nvacina A na dose 2  para pessoa X',
  CONSTRAINT `FK_TB_VACINACAO_VACINA_ID_TB_VACINA_ID`
    FOREIGN KEY (`vacina_id`)
    REFERENCES `DB_CAV`.`TB_VACINA` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_TB_VACINACAO_PESSOA_ID_TB_PESSOA_ID`
    FOREIGN KEY (`pessoa_id`)
    REFERENCES `DB_CAV`.`TB_PESSOA` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
