/*
 Navicat Premium Data Transfer

 Source Server         : Localhost
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : olharjoaopessoa_db

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 06/10/2023 17:28:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for flyway_schema_history
-- ----------------------------
DROP TABLE IF EXISTS `flyway_schema_history`;
CREATE TABLE `flyway_schema_history`  (
  `installed_rank` int NOT NULL,
  `version` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `script` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `checksum` int NULL DEFAULT NULL,
  `installed_by` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `installed_on` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `execution_time` int NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`) USING BTREE,
  INDEX `flyway_schema_history_s_idx`(`success`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_acompanhamento
-- ----------------------------
DROP TABLE IF EXISTS `tb_acompanhamento`;
CREATE TABLE `tb_acompanhamento`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ano` int NULL DEFAULT NULL,
  `avaliacao_id` bigint NOT NULL,
  `pedido_id` bigint NULL DEFAULT NULL,
  `turma_id` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKeawwuralxwnkp24x83f55l887`(`avaliacao_id`) USING BTREE,
  INDEX `FKi0ngqppl47emyljhlnce0ulto`(`pedido_id`) USING BTREE,
  INDEX `FKpf5cd2nugm92gyxl86ym0bnnf`(`turma_id`) USING BTREE,
  CONSTRAINT `FKeawwuralxwnkp24x83f55l887` FOREIGN KEY (`avaliacao_id`) REFERENCES `tb_avaliacao` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKi0ngqppl47emyljhlnce0ulto` FOREIGN KEY (`pedido_id`) REFERENCES `tb_pedido` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKpf5cd2nugm92gyxl86ym0bnnf` FOREIGN KEY (`turma_id`) REFERENCES `tb_turma` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_agendamento
-- ----------------------------
DROP TABLE IF EXISTS `tb_agendamento`;
CREATE TABLE `tb_agendamento`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data_agendamento` datetime(6) NULL DEFAULT NULL,
  `observacao` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status_agendamento` enum('ABERTO','AGUARDANDO_RETORNO','CANCELADO','CONCLUIDO') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `aluno_id` bigint NULL DEFAULT NULL,
  `clinica_id` bigint NOT NULL,
  `disponibilidade_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKijei64h2ty061keu3fibhaiaw`(`aluno_id`) USING BTREE,
  INDEX `FKopmrg2vp17lc8ipsd1had9y7r`(`clinica_id`) USING BTREE,
  INDEX `FKcojgl65sxsyr8nqegeiyxbauo`(`disponibilidade_id`) USING BTREE,
  CONSTRAINT `FKcojgl65sxsyr8nqegeiyxbauo` FOREIGN KEY (`disponibilidade_id`) REFERENCES `tb_disponibilidade` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKijei64h2ty061keu3fibhaiaw` FOREIGN KEY (`aluno_id`) REFERENCES `tb_aluno` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKopmrg2vp17lc8ipsd1had9y7r` FOREIGN KEY (`clinica_id`) REFERENCES `tb_clinica` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_aluno
-- ----------------------------
DROP TABLE IF EXISTS `tb_aluno`;
CREATE TABLE `tb_aluno`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cartaosus` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cpf` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `data_cadastro` datetime(6) NULL DEFAULT NULL,
  `data_nasc` date NULL DEFAULT NULL,
  `data_ultima_modificacao` datetime(6) NULL DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `nome` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `perfil_acesso` enum('ADMIN','ALUNO','CLINICA','ESPECTADOR','OTICA','PROFISSIONAL_EDUCACAO','PROFISSIONAL_SAUDE') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `endereco_id` bigint NOT NULL,
  `facilitador_id` bigint NOT NULL,
  `representante_id` bigint NOT NULL,
  `turma_id` bigint NOT NULL,
  `unidade_ensino_id` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKpvtf9wys9yxfb4ywleaarewmn`(`endereco_id`) USING BTREE,
  INDEX `FKrnc51j394ahbd9w77bhp6cn7q`(`facilitador_id`) USING BTREE,
  INDEX `FKrcpaqpjqbtvg8d6g1qdigb5h1`(`representante_id`) USING BTREE,
  INDEX `FKscdq304mic4a5tbvsyto6ha7t`(`turma_id`) USING BTREE,
  INDEX `FKom2214c6g1ldlk0qm0qylvtea`(`unidade_ensino_id`) USING BTREE,
  CONSTRAINT `FKom2214c6g1ldlk0qm0qylvtea` FOREIGN KEY (`unidade_ensino_id`) REFERENCES `tb_unidade_ensino` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKpvtf9wys9yxfb4ywleaarewmn` FOREIGN KEY (`endereco_id`) REFERENCES `tb_endereco` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKrcpaqpjqbtvg8d6g1qdigb5h1` FOREIGN KEY (`representante_id`) REFERENCES `tb_representante` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKrnc51j394ahbd9w77bhp6cn7q` FOREIGN KEY (`facilitador_id`) REFERENCES `tb_facilitador` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKscdq304mic4a5tbvsyto6ha7t` FOREIGN KEY (`turma_id`) REFERENCES `tb_turma` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_avaliacao
-- ----------------------------
DROP TABLE IF EXISTS `tb_avaliacao`;
CREATE TABLE `tb_avaliacao`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `data_cadastro` datetime(6) NULL DEFAULT NULL,
  `data_ultima_modificacao` datetime(6) NULL DEFAULT NULL,
  `status_avaliacao` enum('AGENDAMENTO_RETORNO','AGUARDANDO_RETORNO','AUTORIZADO','CONCLUIDO','CONSULTA_AGENDADA','CONSULTA_CONCLUIDA','NÃO_AUTORIZADO','OCULOS_APROVADO','OCULOS_REPROVADO') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `aluno_id` bigint NOT NULL,
  `facilitador_id` bigint NOT NULL,
  `oftalmologista_id` bigint NULL DEFAULT NULL,
  `receita_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_3rcto74svj4981fpg5hcrw2ql`(`receita_id`) USING BTREE,
  INDEX `FKodcn55938dhrhkud4vt0cb21r`(`aluno_id`) USING BTREE,
  INDEX `FKan786r0h588syinsylxu6c26a`(`facilitador_id`) USING BTREE,
  INDEX `FKnux6qj4ca1ccjloli3n8wj93m`(`oftalmologista_id`) USING BTREE,
  CONSTRAINT `FKan786r0h588syinsylxu6c26a` FOREIGN KEY (`facilitador_id`) REFERENCES `tb_facilitador` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKnux6qj4ca1ccjloli3n8wj93m` FOREIGN KEY (`oftalmologista_id`) REFERENCES `tb_oftalmologista` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKodcn55938dhrhkud4vt0cb21r` FOREIGN KEY (`aluno_id`) REFERENCES `tb_aluno` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKr44rt00yawejybfqckcc3glpy` FOREIGN KEY (`receita_id`) REFERENCES `tb_receita` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_cidade
-- ----------------------------
DROP TABLE IF EXISTS `tb_cidade`;
CREATE TABLE `tb_cidade`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `uf` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_clinica
-- ----------------------------
DROP TABLE IF EXISTS `tb_clinica`;
CREATE TABLE `tb_clinica`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cnpj` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `data_cadastro` datetime(6) NULL DEFAULT NULL,
  `data_ultima_modificacao` datetime(6) NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `nome_fantasia` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `perfil_acesso` enum('ADMIN','ALUNO','CLINICA','ESPECTADOR','OTICA','PROFISSIONAL_EDUCACAO','PROFISSIONAL_SAUDE') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `razao_social` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `endereco_id` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK5499ribp7dkxjkervm1pi4597`(`endereco_id`) USING BTREE,
  CONSTRAINT `FK5499ribp7dkxjkervm1pi4597` FOREIGN KEY (`endereco_id`) REFERENCES `tb_endereco` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_disponibilidade
-- ----------------------------
DROP TABLE IF EXISTS `tb_disponibilidade`;
CREATE TABLE `tb_disponibilidade`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data_agendamento` datetime(6) NULL DEFAULT NULL,
  `disponivel` bit(1) NOT NULL,
  `clinica_id` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKp6ggf53nwpqxqhji4rl72ifhl`(`clinica_id`) USING BTREE,
  CONSTRAINT `FKp6ggf53nwpqxqhji4rl72ifhl` FOREIGN KEY (`clinica_id`) REFERENCES `tb_clinica` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_endereco
-- ----------------------------
DROP TABLE IF EXISTS `tb_endereco`;
CREATE TABLE `tb_endereco`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `bairro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cep` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `complemento` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `numero` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `rua` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cidade_id` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKotpdj815kf867dbkfbctglsjj`(`cidade_id`) USING BTREE,
  CONSTRAINT `FKotpdj815kf867dbkfbctglsjj` FOREIGN KEY (`cidade_id`) REFERENCES `tb_cidade` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_facilitador
-- ----------------------------
DROP TABLE IF EXISTS `tb_facilitador`;
CREATE TABLE `tb_facilitador`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `data_cadastro` datetime(6) NULL DEFAULT NULL,
  `data_de_nascimento` date NULL DEFAULT NULL,
  `data_ultima_modificacao` datetime(6) NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `nome` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `unidade_ensino_id` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKy0t2v83kp4y99unemf2fn8vk`(`unidade_ensino_id`) USING BTREE,
  CONSTRAINT `FKy0t2v83kp4y99unemf2fn8vk` FOREIGN KEY (`unidade_ensino_id`) REFERENCES `tb_unidade_ensino` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_oculos
-- ----------------------------
DROP TABLE IF EXISTS `tb_oculos`;
CREATE TABLE `tb_oculos`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `data_cadastro` datetime(6) NULL DEFAULT NULL,
  `data_ultima_modificacao` datetime(6) NULL DEFAULT NULL,
  `modelo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `aluno_id` bigint NULL DEFAULT NULL,
  `pedido_id` bigint NOT NULL,
  `receita_id` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_qv6ampaglw1w8deie4syu7nkv`(`pedido_id`) USING BTREE,
  UNIQUE INDEX `UK_8n01gkggiguhco9qqhwxqwdy3`(`receita_id`) USING BTREE,
  INDEX `FKb2wt78shfcr44ygkknwm7p8jw`(`aluno_id`) USING BTREE,
  CONSTRAINT `FK1ebxc6fkrnlqvk64esfcq09hy` FOREIGN KEY (`pedido_id`) REFERENCES `tb_pedido` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK84v0t8j9t3nc5t7m4naqr51hn` FOREIGN KEY (`receita_id`) REFERENCES `tb_receita` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKb2wt78shfcr44ygkknwm7p8jw` FOREIGN KEY (`aluno_id`) REFERENCES `tb_aluno` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_oftalmologista
-- ----------------------------
DROP TABLE IF EXISTS `tb_oftalmologista`;
CREATE TABLE `tb_oftalmologista`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `crm` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `data_cadastro` datetime(6) NULL DEFAULT NULL,
  `data_ultima_modificacao` datetime(6) NULL DEFAULT NULL,
  `nome` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `perfil_acesso` enum('ADMIN','ALUNO','CLINICA','ESPECTADOR','OTICA','PROFISSIONAL_EDUCACAO','PROFISSIONAL_SAUDE') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `clinica_id` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK8qag6hnln14tnj25ivigyjln3`(`clinica_id`) USING BTREE,
  CONSTRAINT `FK8qag6hnln14tnj25ivigyjln3` FOREIGN KEY (`clinica_id`) REFERENCES `tb_clinica` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_otica
-- ----------------------------
DROP TABLE IF EXISTS `tb_otica`;
CREATE TABLE `tb_otica`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cnpj` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `data_cadastro` datetime(6) NULL DEFAULT NULL,
  `data_ultima_modificacao` datetime(6) NULL DEFAULT NULL,
  `nome_fantasia` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `perfil_acesso` enum('ADMIN','ALUNO','CLINICA','ESPECTADOR','OTICA','PROFISSIONAL_EDUCACAO','PROFISSIONAL_SAUDE') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `razao_social` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `endereco_id` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKivvb0buuqhjn8mh2mt32rli8r`(`endereco_id`) USING BTREE,
  CONSTRAINT `FKivvb0buuqhjn8mh2mt32rli8r` FOREIGN KEY (`endereco_id`) REFERENCES `tb_endereco` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_pedido
-- ----------------------------
DROP TABLE IF EXISTS `tb_pedido`;
CREATE TABLE `tb_pedido`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data_cadastro` datetime(6) NULL DEFAULT NULL,
  `data_ultima_modificacao` datetime(6) NULL DEFAULT NULL,
  `status_pedido` enum('OCULOS_APROVADO','OCULOS_CONCLUIDO','OCULOS_EM_FABRICACAO','OCULOS_PEDIDO','OCULOS_RECEBIDO','OCULOS_REPROVADO') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `avaliacao_id` bigint NOT NULL,
  `oculos_id` bigint NULL DEFAULT NULL,
  `otica_id` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_p3glvbin03unq99jadk1ji7et`(`oculos_id`) USING BTREE,
  INDEX `FKrw41y01ie3or2j3i5xqdnjhi`(`avaliacao_id`) USING BTREE,
  INDEX `FKgs9yxtph08qii1x1e3unjn3k9`(`otica_id`) USING BTREE,
  CONSTRAINT `FKdp39uyke6h90f6stsi0p67qgr` FOREIGN KEY (`oculos_id`) REFERENCES `tb_oculos` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKgs9yxtph08qii1x1e3unjn3k9` FOREIGN KEY (`otica_id`) REFERENCES `tb_otica` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKrw41y01ie3or2j3i5xqdnjhi` FOREIGN KEY (`avaliacao_id`) REFERENCES `tb_avaliacao` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_receita
-- ----------------------------
DROP TABLE IF EXISTS `tb_receita`;
CREATE TABLE `tb_receita`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data_cadastro` datetime(6) NULL DEFAULT NULL,
  `data_ultima_modificacao` datetime(6) NULL DEFAULT NULL,
  `od_cilindrico_longe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `od_cilindrico_perto` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `oddplonge` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `oddpperto` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `od_eixo_longe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `od_eixo_perto` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `od_esferico_longe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `od_esferico_perto` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `oe_cilindrico_longe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `oe_cilindrico_perto` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `oedplonge` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `oedpperto` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `oe_eixo_longe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `oe_esferico_longe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `oe_esferico_perto` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `oes_eixo_perto` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `observacao` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_representante
-- ----------------------------
DROP TABLE IF EXISTS `tb_representante`;
CREATE TABLE `tb_representante`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `data_cadastro` datetime(6) NULL DEFAULT NULL,
  `data_ultima_modificacao` datetime(6) NULL DEFAULT NULL,
  `nome` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_turma
-- ----------------------------
DROP TABLE IF EXISTS `tb_turma`;
CREATE TABLE `tb_turma`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data_cadastro` datetime(6) NULL DEFAULT NULL,
  `data_ultima_modificacao` datetime(6) NULL DEFAULT NULL,
  `serie` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `turma` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `unidade_ensino_id` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKhaoys4y0ar9p0ei4xg4wu814r`(`unidade_ensino_id`) USING BTREE,
  CONSTRAINT `FKhaoys4y0ar9p0ei4xg4wu814r` FOREIGN KEY (`unidade_ensino_id`) REFERENCES `tb_unidade_ensino` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_unidade_ensino
-- ----------------------------
DROP TABLE IF EXISTS `tb_unidade_ensino`;
CREATE TABLE `tb_unidade_ensino`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `endereco_id` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKpiii9xbu92uytch8u3e1gvdtw`(`endereco_id`) USING BTREE,
  CONSTRAINT `FKpiii9xbu92uytch8u3e1gvdtw` FOREIGN KEY (`endereco_id`) REFERENCES `tb_endereco` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_usuario_espectador
-- ----------------------------
DROP TABLE IF EXISTS `tb_usuario_espectador`;
CREATE TABLE `tb_usuario_espectador`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `data_cadastro` datetime(6) NULL DEFAULT NULL,
  `data_ultima_modificacao` datetime(6) NULL DEFAULT NULL,
  `nome` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `perfil_acesso` enum('ADMIN','ALUNO','CLINICA','ESPECTADOR','OTICA','PROFISSIONAL_EDUCACAO','PROFISSIONAL_SAUDE') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
