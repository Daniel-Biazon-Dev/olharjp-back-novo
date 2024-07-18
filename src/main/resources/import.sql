INSERT INTO `tb_auth_user` VALUES (1, '$2a$12$9a8pHjbRPJOoXI8VRaEUiOzhHuIDbWw5PIBuA1QH.HuN7IApqs116', 'PROFISSIONAL_EDUCACAO', 1, 'rodolfo_fox');
INSERT INTO `tb_auth_user` VALUES (2, '$2a$12$9a8pHjbRPJOoXI8VRaEUiOzhHuIDbWw5PIBuA1QH.HuN7IApqs116', 'ALUNO', 1, 'dolfox_fox');
INSERT INTO `tb_auth_user` VALUES (3, '$2a$12$9a8pHjbRPJOoXI8VRaEUiOzhHuIDbWw5PIBuA1QH.HuN7IApqs116', 'CLINICA', 1, 'olhar_jampa');
INSERT INTO `tb_auth_user` VALUES (4, '$2a$12$9a8pHjbRPJOoXI8VRaEUiOzhHuIDbWw5PIBuA1QH.HuN7IApqs116', 'PROFISSIONAL_SAUDE', 1, 'joao_dolfox');
INSERT INTO `tb_auth_user` VALUES (5, '$2a$12$9a8pHjbRPJOoXI8VRaEUiOzhHuIDbWw5PIBuA1QH.HuN7IApqs116', 'OTICA', 1, 'joao_dolfox');

INSERT INTO `tb_cidade`(`id`, `nome`, `uf`) VALUES (1, 'João Pessoa', 'PB');

INSERT INTO `tb_endereco`(`id`, `bairro`, `cep`, `complemento`, `numero`, `rua`, `cidade_id`) VALUES (1, 'Cristo', '58000000', 'Casa', '1', '2 de fevereiro', 1);

INSERT INTO `tb_unidade_ensino`(`id`, `nome`, `endereco_id`) VALUES (1, 'EMEF Oscar de Castro', 1);

INSERT INTO `tb_turma`(`id`, `data_cadastro`, `data_ultima_modificacao`, `serie`, `turma`, `unidade_ensino_id`) VALUES (1, '2023-09-18 16:57:17.000000', '2023-09-18 16:57:21.000000', '1', 'A', 1);

INSERT INTO `tb_usuario_espectador`(`id`, `cpf`, `data_cadastro`, `data_ultima_modificacao`, `nome`, `perfil_acesso`) VALUES (1, '32132132121', '2023-09-18 16:55:52.000000', '2023-09-18 16:56:21.000000', 'Dolfox', 'ESPECTADOR');

INSERT INTO `tb_facilitador`(`id`, `password`,`username`, `perfil_acesso`,`cpf`, `data_de_cadastro`, `data_de_nascimento`, `data_de_ultima_modificacao`, `email`, `nome`, `auth_user_model_id`, `unidade_ensino_id`) VALUES (1, '$2a$12$9a8pHjbRPJOoXI8VRaEUiOzhHuIDbWw5PIBuA1QH.HuN7IApqs116', 'rodolfo_fox', 'PROFISSIONAL_EDUCACAO', '32132132132', '2023-09-18 17:07:56.000000', '1980-01-16', '2023-09-18 17:08:31.000000',  'rodolfofox@email.com', 'Rodolfo Fox', 1, 1);

INSERT INTO `tb_representante`(`id`, `cpf`, `data_de_cadastro`, `data_de_ultima_modificacao`, `nome`) VALUES (1, '32132132121', '2023-09-18 17:04:35.000000', '2023-09-18 17:04:38.000000', 'Roldolfox');

INSERT INTO `tb_aluno`(`id`, `password`,`username`, `perfil_acesso`, `cartaosus`, `cpf`, `data_de_cadastro`, `data_de_ultima_modificacao`, `data_de_nascimento`, `email`, `nome`, `endereco_id`, `representante_id`, `turma_id`, `auth_user_model_id`) VALUES (1, '$2a$12$9a8pHjbRPJOoXI8VRaEUiOzhHuIDbWw5PIBuA1QH.HuN7IApqs116', 'dolfox_fox', 'ALUNO',  '3216513546542', '32132165421', '2023-09-18 17:04:35.000000', '2023-09-18 17:04:38.000000','2010-01-06', 'Dolfox Aluno', 'Dolfoxzinho', 1, 1, 1, 2);

INSERT INTO `tb_clinica`(`id`, `password`,`username`, `perfil_acesso`, `cnpj`, `data_de_cadastro`, `data_de_ultima_modificacao`, `email`, `nome_fantasia`, `razao_social`, `endereco_id`, `auth_user_model_id`) VALUES (1, '$2a$12$9a8pHjbRPJOoXI8VRaEUiOzhHuIDbWw5PIBuA1QH.HuN7IApqs116', 'olhar_jampa', 'CLINICA', '32132132132123', '2023-09-18 17:05:24.000000', '2023-09-18 17:05:27.000000', 'olharjampa@mail.com', 'Olhar Jampa', 'Olhar Jampa LTMA', 1, 3);

INSERT INTO `tb_oftalmologista`(`id`, `password`,`username`, `perfil_acesso`, `crm`, `data_de_cadastro`, `data_de_ultima_modificacao`, `nome`, `clinica_id`, `auth_user_model_id`) VALUES (1, '$2a$12$9a8pHjbRPJOoXI8VRaEUiOzhHuIDbWw5PIBuA1QH.HuN7IApqs116', 'joao_dolfox', 'PROFISSIONAL_SAUDE', '321321321', '2023-09-18 17:06:43.000000', '2023-09-18 17:06:45.000000', 'Joao Dolfox', 1, 4);

INSERT INTO `tb_avaliacao`(`id`, `codigo`, `data_de_cadastro`, `data_de_ultima_modificacao`, `status_avaliacao`, `aluno_id`, `oftalmologista_id`, `receita_id`) VALUES (1,  NULL, '2023-09-18 17:13:56.000000', '2023-09-18 17:13:54.000000', 'AUTORIZADO', 1, 1, null);

INSERT INTO `tb_disponibilidade`(`id`, `data_agendamento`, `disponivel`, `clinica_id`, `quantidade`) VALUES (1, '2023-10-06 17:12:37.000000', b'1', 1, 1);

INSERT INTO `tb_agendamento`(`id`, `data_agendamento`, `observacao`, `status_agendamento`, `aluno_id`, `clinica_id`, `disponibilidade_id`) VALUES (1, '2023-09-18 17:17:07.000000', '1', 'AGUARDANDO_RETORNO', 1, 1, 1);

INSERT INTO `tb_otica`(`id`, `password`,`username`, `perfil_acesso`, `cnpj`, `data_de_cadastro`, `data_de_ultima_modificacao`, `nome_fantasia`, `razao_social`, `endereco_id`, `auth_user_model_id`) VALUES (1, '$2a$12$9a8pHjbRPJOoXI8VRaEUiOzhHuIDbWw5PIBuA1QH.HuN7IApqs116', 'joao_dolfox', 'OTICA','32112332112321', '2023-09-18 16:54:32.000000', '2023-09-18 17:05:00.000000', 'Optica para todos', 'Optica para todos', 1, 5);

INSERT INTO `tb_receita`(`id`, `adicao`, `data_cadastro`, `data_ultima_modificacao`, `observacao`, `od_cilindrico_longe`, `od_cilindrico_perto`, `od_eixo_longe`, `od_eixo_perto`, `od_esferico_longe`, `od_esferico_perto`, `oe_cilindrico_longe`, `oe_cilindrico_perto`, `oe_eixo_longe`, `oe_esferico_longe`, `oe_esferico_perto`, `oe_eixo_perto`) VALUES (1, 1, '2023-11-10 09:13:57.000000', '2023-11-10 09:13:57.000000', 'Multifocal', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);

INSERT INTO `tb_pedido`(`id`, `data_de_cadastro`, `data_de_ultima_modificacao`, `status_pedido`, `avaliacao_id`, `oculos_id`, `otica_id`) VALUES (1, '2023-09-28 15:33:21.000000', '2023-09-28 15:33:23.000000', 'OCULOS_CONCLUIDO', 1, NULL, 1);

INSERT INTO `tb_oculos`(`id`, `cor`, `data_cadastro`, `data_ultima_modificacao`, `modelo`, `aluno_id`, `pedido_id`, `receita_id`) VALUES (1, 'black', '2023-09-18 17:14:57.000000', '2023-09-18 17:15:00.000000', 'tx1', 1, 1, 1);

INSERT INTO `tb_acompanhamento`(`id`, `ano`, `avaliacao_id`, `pedido_id`, `turma_id`) VALUES (1, 2023, 1, 1, 1);
INSERT INTO `tb_facilitador_aluno` VALUES (1, 1, 1);