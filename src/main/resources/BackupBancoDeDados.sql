-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.7.13-log - MySQL Community Server (GPL)
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Copiando estrutura do banco de dados para hub_services
CREATE DATABASE IF NOT EXISTS `hub_services` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hub_services`;


-- Copiando estrutura para tabela hub_services.conta
CREATE TABLE IF NOT EXISTS `conta` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_criacao` date DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `saldo` decimal(19,2) NOT NULL,
  `id_conta_matriz` bigint(20) DEFAULT NULL,
  `id_pessoa` bigint(20) DEFAULT NULL,
  `id_status_conta` int(11) NOT NULL,
  `id_tipo_conta` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ContaContaMatriz` (`id_conta_matriz`),
  KEY `ContaPessoa` (`id_pessoa`),
  KEY `ContaStatusConta` (`id_status_conta`),
  KEY `ContaTipoConta` (`id_tipo_conta`),
  CONSTRAINT `ContaContaMatriz` FOREIGN KEY (`id_conta_matriz`) REFERENCES `conta` (`id`),
  CONSTRAINT `ContaPessoa` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id`),
  CONSTRAINT `ContaStatusConta` FOREIGN KEY (`id_status_conta`) REFERENCES `status_conta` (`id`),
  CONSTRAINT `ContaTipoConta` FOREIGN KEY (`id_tipo_conta`) REFERENCES `tipo_conta` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela hub_services.conta: ~4 rows (aproximadamente)
DELETE FROM `conta`;
/*!40000 ALTER TABLE `conta` DISABLE KEYS */;
INSERT INTO `conta` (`id`, `data_criacao`, `nome`, `saldo`, `id_conta_matriz`, `id_pessoa`, `id_status_conta`, `id_tipo_conta`) VALUES
	(1, '2017-07-31', 'CONTA MATRIZ 1', 29985000.00, NULL, 6, 1, 1),
	(2, '2017-07-30', 'CONTA FILIAL 1', 30000000.00, 1, 1, 2, 2),
	(3, '2017-12-30', 'CONTA FILIAL 2', 500000.00, 4, 6, 1, 2),
	(4, '2017-07-31', 'CONTA MATRIZ 2', 29995000.00, NULL, 1, 1, 1);
/*!40000 ALTER TABLE `conta` ENABLE KEYS */;


-- Copiando estrutura para tabela hub_services.pessoa
CREATE TABLE IF NOT EXISTS `pessoa` (
  `tipo_pessoa` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cpfcnpj` varchar(19) NOT NULL,
  `nome_nome_fantasia` varchar(255) NOT NULL,
  `data_de_nascimento` date DEFAULT NULL,
  `nome_razao_social` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela hub_services.pessoa: ~4 rows (aproximadamente)
DELETE FROM `pessoa`;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` (`tipo_pessoa`, `id`, `cpfcnpj`, `nome_nome_fantasia`, `data_de_nascimento`, `nome_razao_social`) VALUES
	('J', 1, '98.408.715/0001-82', 'ERUDIO', NULL, 'ERUDIO Corporation LTDA'),
	('F', 2, '175.165.418-05', 'Leandro da Costa Gonçalves', '1984-12-02', NULL),
	('F', 3, '702.623.662-82', 'Flávio da Costa Gonçalves', '1988-12-05', NULL),
	('J', 6, '61.872.686/0001-03', 'ACME', NULL, 'ACME Company');
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;


-- Copiando estrutura para tabela hub_services.status_conta
CREATE TABLE IF NOT EXISTS `status_conta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(35) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela hub_services.status_conta: ~3 rows (aproximadamente)
DELETE FROM `status_conta`;
/*!40000 ALTER TABLE `status_conta` DISABLE KEYS */;
INSERT INTO `status_conta` (`id`, `descricao`) VALUES
	(1, 'ATIVA'),
	(2, 'BLOQUEADA'),
	(3, 'CANCELADA');
/*!40000 ALTER TABLE `status_conta` ENABLE KEYS */;


-- Copiando estrutura para tabela hub_services.tipo_conta
CREATE TABLE IF NOT EXISTS `tipo_conta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(35) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela hub_services.tipo_conta: ~2 rows (aproximadamente)
DELETE FROM `tipo_conta`;
/*!40000 ALTER TABLE `tipo_conta` DISABLE KEYS */;
INSERT INTO `tipo_conta` (`id`, `descricao`) VALUES
	(1, 'CONTA MATRIZ'),
	(2, 'CONTA FILIAL');
/*!40000 ALTER TABLE `tipo_conta` ENABLE KEYS */;


-- Copiando estrutura para tabela hub_services.tipo_transacao
CREATE TABLE IF NOT EXISTS `tipo_transacao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(35) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela hub_services.tipo_transacao: ~3 rows (aproximadamente)
DELETE FROM `tipo_transacao`;
/*!40000 ALTER TABLE `tipo_transacao` DISABLE KEYS */;
INSERT INTO `tipo_transacao` (`id`, `descricao`) VALUES
	(1, 'TRANSFERÊNCIA'),
	(2, 'CARGA'),
	(3, 'APORTE');
/*!40000 ALTER TABLE `tipo_transacao` ENABLE KEYS */;


-- Copiando estrutura para tabela hub_services.transacao
CREATE TABLE IF NOT EXISTS `transacao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(255) DEFAULT NULL,
  `data_transacao` date DEFAULT NULL,
  `valor` decimal(19,2) NOT NULL,
  `id_conta_destino` bigint(20) NOT NULL,
  `id_conta_origem` bigint(20) NOT NULL,
  `id_tipo_transacao` int(11) NOT NULL,
  `estornada` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `DestinoTransacao` (`id_conta_destino`),
  KEY `OrigemTransacao` (`id_conta_origem`),
  KEY `TipoTransacaoTransacao` (`id_tipo_transacao`),
  CONSTRAINT `DestinoTransacao` FOREIGN KEY (`id_conta_destino`) REFERENCES `conta` (`id`),
  CONSTRAINT `OrigemTransacao` FOREIGN KEY (`id_conta_origem`) REFERENCES `conta` (`id`),
  CONSTRAINT `TipoTransacaoTransacao` FOREIGN KEY (`id_tipo_transacao`) REFERENCES `tipo_transacao` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela hub_services.transacao: ~1 rows (aproximadamente)
DELETE FROM `transacao`;
/*!40000 ALTER TABLE `transacao` DISABLE KEYS */;
INSERT INTO `transacao` (`id`, `codigo`, `data_transacao`, `valor`, `id_conta_destino`, `id_conta_origem`, `id_tipo_transacao`, `estornada`) VALUES
	(1, 'E0FD540A', '2017-08-28', 500.00, 2, 1, 1, b'1'),
	(2, '03027223', '2017-08-29', 500.00, 2, 1, 1, b'1'),
	(3, '4A69A58D', '2017-08-29', 500.00, 2, 1, 1, b'1'),
	(4, '2FFB9FA2', '2017-08-29', 500.00, 3, 4, 1, b'1'),
	(5, 'F7AB4A31', '2017-08-29', 5000.00, 4, 1, 3, b'1'),
	(6, '641863E3', '2017-08-29', 5000.00, 4, 1, 3, b'0');
/*!40000 ALTER TABLE `transacao` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
