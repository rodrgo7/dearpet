-- Insert sample data into pessoas (mix of PF and PJ)
INSERT INTO pessoas (nome, sobrenome, genero, email, contato, endereco, tipo_pessoa) VALUES
-- Pessoa Física 1-10
('João', 'Silva', 'Masculino', 'joao.silva@email.com', '(11) 99999-1111', 'Rua A, 123', 'PF'),
('Maria', 'Santos', 'Feminino', 'maria.santos@email.com', '(11) 99999-2222', 'Rua B, 456', 'PF'),
('Pedro', 'Oliveira', 'Masculino', 'pedro.oliveira@email.com', '(11) 99999-3333', 'Rua C, 789', 'PF'),
('Ana', 'Costa', 'Feminino', 'ana.costa@email.com', '(11) 99999-4444', 'Rua D, 101', 'PF'),
('Carlos', 'Pereira', 'Masculino', 'carlos.pereira@email.com', '(11) 99999-5555', 'Rua E, 202', 'PF'),
('Juliana', 'Rodrigues', 'Feminino', 'juliana.rodrigues@email.com', '(11) 99999-6666', 'Rua F, 303', 'PF'),
('Lucas', 'Martins', 'Masculino', 'lucas.martins@email.com', '(11) 99999-7777', 'Rua G, 404', 'PF'),
('Mariana', 'Ferreira', 'Feminino', 'mariana.ferreira@email.com', '(11) 99999-8888', 'Rua H, 505', 'PF'),
('Rafael', 'Almeida', 'Masculino', 'rafael.almeida@email.com', '(11) 99999-9999', 'Rua I, 606', 'PF'),
('Beatriz', 'Lima', 'Feminino', 'beatriz.lima@email.com', '(11) 99999-0000', 'Rua J, 707', 'PF'),
-- Pessoa Jurídica 11-15
('PetShop Amigo', NULL, NULL, 'contato@petshopamigo.com', '(11) 3333-1111', 'Av. Principal, 1000', 'PJ'),
('Clínica Veterinária São Francisco', NULL, NULL, 'contato@clinicasf.com', '(11) 3333-2222', 'Av. Secundária, 2000', 'PJ'),
('Hotel para Cães Felizes', NULL, NULL, 'contato@hotelcaes.com', '(11) 3333-3333', 'Rua dos Animais, 3000', 'PJ'),
('Pet Center Premium', NULL, NULL, 'contato@petcenter.com', '(11) 3333-4444', 'Av. Comercial, 4000', 'PJ'),
('Veterinária 24h', NULL, NULL, 'contato@vet24h.com', '(11) 3333-5555', 'Rua da Emergência, 5000', 'PJ');

-- Insert sample data into pessoas_fisicas
INSERT INTO pessoas_fisicas (id, cpf) VALUES
(1, '111.222.333-44'),
(2, '222.333.444-55'),
(3, '333.444.555-66'),
(4, '444.555.666-77'),
(5, '555.666.777-88'),
(6, '666.777.888-99'),
(7, '777.888.999-00'),
(8, '888.999.000-11'),
(9, '999.000.111-22'),
(10, '000.111.222-33');

-- Insert sample data into pessoas_juridicas
INSERT INTO pessoas_juridicas (id, cnpj, razao_social) VALUES
(11, '11.222.333/0001-44', 'PetShop Amigo Ltda'),
(12, '22.333.444/0001-55', 'Clínica Veterinária São Francisco S.A.'),
(13, '33.444.555/0001-66', 'Hotel para Cães Felizes EIRELI'),
(14, '44.555.666/0001-77', 'Pet Center Premium Comércio de Produtos para Animais Ltda'),
(15, '55.666.777/0001-88', 'Veterinária 24h Serviços Médicos Ltda');

-- Insert sample data into profissionais
INSERT INTO profissionais (registro_profissional, especialidade, data_inicio, data_fim, observacoes) VALUES
('CRMV-SP 12345', 'Clínica Geral', '2020-01-01', NULL, 'Especialista em pequenos animais'),
('CRMV-SP 23456', 'Cirurgia', '2019-06-15', NULL, 'Especialista em cirurgias ortopédicas'),
('CRMV-SP 34567', 'Dermatologia', '2021-03-10', NULL, 'Especialista em dermatologia animal'),
('CRMV-SP 45678', 'Oftalmologia', '2018-11-20', NULL, 'Especialista em oftalmologia veterinária'),
('CRMV-SP 56789', 'Cardiologia', '2020-08-05', NULL, 'Especialista em cardiologia animal'),
('CRMV-SP 67890', 'Nutrição', '2021-01-15', NULL, 'Especialista em nutrição animal'),
('CRMV-SP 78901', 'Comportamento', '2019-09-30', NULL, 'Especialista em comportamento animal'),
('CRMV-SP 89012', 'Endocrinologia', '2020-04-25', NULL, 'Especialista em endocrinologia animal'),
('CRMV-SP 90123', 'Oncologia', '2018-12-10', NULL, 'Especialista em oncologia veterinária'),
('CRMV-SP 01234', 'Anestesiologia', '2021-02-20', NULL, 'Especialista em anestesiologia veterinária'),
('CRMV-SP 12340', 'Odontologia', '2019-07-15', NULL, 'Especialista em odontologia veterinária'),
('CRMV-SP 23401', 'Fisioterapia', '2020-10-30', NULL, 'Especialista em fisioterapia animal'),
('CRMV-SP 34012', 'Acupuntura', '2018-05-20', NULL, 'Especialista em acupuntura veterinária'),
('CRMV-SP 40123', 'Homeopatia', '2021-04-05', NULL, 'Especialista em homeopatia veterinária'),
('CRMV-SP 01234', 'Reprodução', '2019-02-15', NULL, 'Especialista em reprodução animal');

-- Insert sample data into pets
INSERT INTO pets (nome, especie, raca, porte, sexo, data_nascimento, dono_id) VALUES
('Rex', 'Cão', 'Labrador', 'Grande', 'Macho', '2019-05-15', 1),
('Luna', 'Gato', 'Siamês', 'Médio', 'Fêmea', '2020-02-20', 1),
('Thor', 'Cão', 'Golden Retriever', 'Grande', 'Macho', '2018-11-10', 2),
('Mia', 'Gato', 'Persa', 'Pequeno', 'Fêmea', '2021-01-05', 2),
('Max', 'Cão', 'Poodle', 'Pequeno', 'Macho', '2020-07-30', 3),
('Bella', 'Gato', 'Maine Coon', 'Grande', 'Fêmea', '2019-09-25', 3),
('Rocky', 'Cão', 'Bulldog', 'Médio', 'Macho', '2020-04-12', 4),
('Lola', 'Gato', 'Ragdoll', 'Médio', 'Fêmea', '2021-03-18', 4),
('Toby', 'Cão', 'Beagle', 'Médio', 'Macho', '2019-12-22', 5),
('Nina', 'Gato', 'Sphynx', 'Médio', 'Fêmea', '2020-08-14', 5),
('Zeus', 'Cão', 'Husky Siberiano', 'Grande', 'Macho', '2018-06-30', 6),
('Lily', 'Gato', 'Bengal', 'Médio', 'Fêmea', '2020-11-05', 6),
('Duke', 'Cão', 'Doberman', 'Grande', 'Macho', '2019-03-15', 7),
('Molly', 'Gato', 'Abissínio', 'Médio', 'Fêmea', '2021-02-28', 7),
('Jack', 'Cão', 'Chihuahua', 'Pequeno', 'Macho', '2020-09-10', 8); 