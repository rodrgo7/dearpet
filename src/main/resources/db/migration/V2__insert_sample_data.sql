-- Inserções de pessoas (mistura de PF e PJ)    
INSERT INTO pessoas (nome, sobrenome, genero, email, contato, endereco, tipo_pessoa) VALUES
-- Pessoa Física 1-10
('Arthur', 'Silva', 'Masculino', 'arthur.silva@email.com', '(11) 99999-1111', 'Rua A, 123', 'PF'),
('Mara', 'Santos', 'Feminino', 'mara.santos@email.com', '(11) 99999-2222', 'Rua B, 456', 'PF'),
('Joaquim', 'Oliveira', 'Masculino', 'joaquim.oliveira@email.com', '(11) 99999-3333', 'Rua C, 789', 'PF'),
('Ana Lucia', 'Costa', 'Feminino', 'ana.lucia.costa@email.com', '(11) 99999-4444', 'Rua D, 101', 'PF'),
('Carla', 'Pereira', 'Masculino', 'carla.pereira@email.com', '(11) 99999-5555', 'Rua E, 202', 'PF'),
('Ju', 'Rodrigues', 'Feminino', 'ju.rodrigues@email.com', '(11) 99999-6666', 'Rua F, 303', 'PF'),
('Laura', 'Martins', 'Masculino', 'laura.martins@email.com', '(11) 99999-7777', 'Rua G, 404', 'PF'),
('Marina', 'Ferreira', 'Feminino', 'marina.ferreira@email.com', '(11) 99999-8888', 'Rua H, 505', 'PF'),
('Rafaela', 'Almeida', 'Masculino', 'rafaela.almeida@email.com', '(11) 99999-9999', 'Rua I, 606', 'PF'),
('Bianca', 'Lima', 'Feminino', 'bianca.lima@email.com', '(11) 99999-0000', 'Rua J, 707', 'PF'),
-- Pessoa Jurídica 11-15
('PetShop Amigo', NULL, NULL, 'contato@petshopamigo.com', '(11) 3333-1111', 'Av. Principal, 1000', 'PJ'),
('Clínica Veterinária São Francisco', NULL, NULL, 'contato@clinicasf.com', '(11) 3333-2222', 'Av. Secundária, 2000', 'PJ'),
('Hotel para Cães Felizes', NULL, NULL, 'contato@hotelcaes.com', '(11) 3333-3333', 'Rua dos Animais, 3000', 'PJ'),
('Pet Center Premium', NULL, NULL, 'contato@petcenter.com', '(11) 3333-4444', 'Av. Comercial, 4000', 'PJ'),
('Veterinária 24h', NULL, NULL, 'contato@vet24h.com', '(11) 3333-5555', 'Rua da Emergência, 5000', 'PJ');

-- Inserções para profissionais
INSERT INTO profissionais (id, nome, registro_profissional, especialidade, data_inicio, data_fim, observacoes) VALUES
(1, 'João Silva', 'CRMV-SP 12345', 'Clínica Geral', '2020-01-01', NULL, 'Especialista em pequenos animais'),
(2, 'Maria Santos', 'CRMV-SP 23456', 'Cirurgia', '2019-06-15', NULL, 'Especialista em cirurgias ortopédicas'),
(3, 'Pedro Oliveira', 'CRMV-SP 34567', 'Dermatologia', '2021-03-10', NULL, 'Especialista em dermatologia animal'),
(4, 'Ana Costa', 'CRMV-SP 45678', 'Oftalmologia', '2018-11-20', NULL, 'Especialista em oftalmologia veterinária'),
(5, 'Carlos Pereira', 'CRMV-SP 56789', 'Cardiologia', '2020-08-05', NULL, 'Especialista em cardiologia animal'),
(6, 'Juliana Rodrigues', 'CRMV-SP 67890', 'Nutrição', '2021-01-15', NULL, 'Especialista em nutrição animal'),
(7, 'Lucas Martins', 'CRMV-SP 78901', 'Comportamento', '2019-09-30', NULL, 'Especialista em comportamento animal'),
(8, 'Mariana Ferreira', 'CRMV-SP 89012', 'Endocrinologia', '2020-04-25', NULL, 'Especialista em endocrinologia animal'),
(9, 'Rafael Almeida', 'CRMV-SP 90123', 'Oncologia', '2018-12-10', NULL, 'Especialista em oncologia veterinária'),
(10, 'Beatriz Lima', 'CRMV-SP 01234', 'Anestesiologia', '2021-02-20', NULL, 'Especialista em anestesiologia veterinária'),
(11, 'Beatriz Lima', 'CRMV-SP 12340', 'Odontologia', '2019-07-15', NULL, 'Especialista em odontologia veterinária'),
(12, 'Fernanda Biazuzo', 'CRMV-SP 23401', 'Fisioterapia', '2020-10-30', NULL, 'Especialista em fisioterapia animal'),
(13, 'Rodrigo Oliveira', 'CRMV-SP 34012', 'Acupuntura', '2018-05-20', NULL, 'Especialista em acupuntura veterinária'),
(14, 'Bruno Barros', 'CRMV-SP 40123', 'Homeopatia', '2021-04-05', NULL, 'Especialista em homeopatia veterinária'),
(15, 'Neymar Junior', 'CRMV-SP 01234', 'Reprodução', '2019-02-15', NULL, 'Especialista em reprodução animal');

-- Inserções para pets
INSERT INTO pets (nome, especie, raca, porte, sexo, data_nascimento, dono_id, profissional_id, nome_profissional) VALUES
('Rex', 'Cão', 'Labrador', 'Grande', 'Macho', '2019-05-15', 1, 1, 'João Silva'),
('Luna', 'Gato', 'Siamês', 'Médio', 'Fêmea', '2020-02-20', 1, 1, 'João Silva'),
('Thor', 'Cão', 'Golden Retriever', 'Grande', 'Macho', '2018-11-10', 2, 2, 'Maria Santos'),
('Mia', 'Gato', 'Persa', 'Pequeno', 'Fêmea', '2021-01-05', 2, 2, 'Maria Santos'),
('Max', 'Cão', 'Poodle', 'Pequeno', 'Macho', '2020-07-30', 3, 3, 'Pedro Oliveira'),
('Bella', 'Gato', 'Maine Coon', 'Grande', 'Fêmea', '2019-09-25', 3, 3, 'Pedro Oliveira'),
('Rocky', 'Cão', 'Bulldog', 'Médio', 'Macho', '2020-04-12', 4, 4, 'Ana Costa'),
('Lola', 'Gato', 'Ragdoll', 'Médio', 'Fêmea', '2021-03-18', 4, 4, 'Ana Costa'),
('Toby', 'Cão', 'Beagle', 'Médio', 'Macho', '2019-12-22', 5, 5, 'Carlos Pereira'),
('Nina', 'Gato', 'Sphynx', 'Médio', 'Fêmea', '2020-08-14', 5, 5, 'Carlos Pereira'),
('Zeus', 'Cão', 'Husky Siberiano', 'Grande', 'Macho', '2018-06-30', 6, 6, 'Juliana Rodrigues'),
('Lily', 'Gato', 'Bengal', 'Médio', 'Fêmea', '2020-11-05', 6, 6, 'Juliana Rodrigues'),
('Duke', 'Cão', 'Doberman', 'Grande', 'Macho', '2019-03-15', 7, 7, 'Lucas Martins'),
('Molly', 'Gato', 'Abissínio', 'Médio', 'Fêmea', '2021-02-28', 7, 7, 'Lucas Martins'),
('Jack', 'Cão', 'Chihuahua', 'Pequeno', 'Macho', '2020-09-10', 8, 8, 'Mariana Ferreira');

-- Inserções para pessoas_fisicas
INSERT INTO pessoas_fisicas (id, nome, sobrenome, cpf, pet_id, nome_pet) VALUES
(1, 'Arthur', 'Silva', '111.222.333-44', 1, 'Rex'),
(2, 'Mara', 'Santos', '222.333.444-55', 2, 'Luna'),
(3, 'Joaquim', 'Oliveira', '333.444.555-66', 3, 'Thor'),
(4, 'Ana Lucia', 'Costa', '444.555.666-77', 4, 'Mia'),
(5, 'Carla', 'Pereira', '555.666.777-88', 5, 'Max'),
(6, 'Ju', 'Rodrigues', '666.777.888-99', 6, 'Bella'),
(7, 'Laura', 'Martins', '777.888.999-00', 7, 'Rocky'),
(8, 'Marina', 'Ferreira', '888.999.000-11', 8, 'Lola'),
(9, 'Rafaela', 'Almeida', '999.000.111-22', 9, 'Toby'),
(10, 'Bianca', 'Lima', '000.111.222-33', 10, 'Nina');

-- Inserções para pessoas_juridicas
INSERT INTO pessoas_juridicas (id, nome, cnpj, razao_social, pet_id, nome_pet) VALUES
(11, 'PetShop Amigo', '11.222.333/0001-44', 'PetShop Amigo Ltda', 1, 'Rex'),
(12, 'Clínica Veterinária São Francisco', '22.333.444/0001-55', 'Clínica Veterinária São Francisco S.A.', 2, 'Luna'),
(13, 'Hotel para Cães Felizes', '33.444.555/0001-66', 'Hotel para Cães Felizes EIRELI', 3, 'Thor'),
(14, 'Pet Center Premium', '44.555.666/0001-77', 'Pet Center Premium Comércio de Produtos para Animais Ltda', 4, 'Mia'),
(15, 'Veterinária 24h', '55.666.777/0001-88', 'Veterinária 24h Serviços Médicos Ltda', 5, 'Max'); 