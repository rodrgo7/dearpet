-- Tabela base pessoas
CREATE TABLE pessoas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    sobrenome VARCHAR(100),
    genero VARCHAR(20),
    email VARCHAR(100) NOT NULL,
    contato VARCHAR(20),
    endereco VARCHAR(200),
    tipo_pessoa VARCHAR(2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabela profissionais
CREATE TABLE profissionais (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    registro_profissional VARCHAR(50) NOT NULL,
    especialidade VARCHAR(100) NOT NULL,
    data_inicio DATE NOT NULL,
    data_fim DATE,
    observacoes TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabela pets
CREATE TABLE pets (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    especie VARCHAR(50) NOT NULL,
    raca VARCHAR(100),
    porte VARCHAR(20),
    sexo VARCHAR(10),
    data_nascimento DATE,
    dono_id BIGINT NOT NULL,
    profissional_id BIGINT,
    nome_profissional VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (dono_id) REFERENCES pessoas(id) ON DELETE CASCADE,
    FOREIGN KEY (profissional_id) REFERENCES profissionais(id)
);

-- Tabela pessoas_fisicas (com nome e sobrenome)
CREATE TABLE pessoas_fisicas (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    sobrenome VARCHAR(100),
    cpf VARCHAR(14) NOT NULL UNIQUE,
    pet_id BIGINT,
    nome_pet VARCHAR(100),
    FOREIGN KEY (id) REFERENCES pessoas(id) ON DELETE CASCADE,
    FOREIGN KEY (pet_id) REFERENCES pets(id)
);

-- Tabela pessoas_juridicas (com nome)
CREATE TABLE pessoas_juridicas (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cnpj VARCHAR(18) NOT NULL UNIQUE,
    razao_social VARCHAR(200) NOT NULL,
    pet_id BIGINT,
    nome_pet VARCHAR(100),
    FOREIGN KEY (id) REFERENCES pessoas(id) ON DELETE CASCADE,
    FOREIGN KEY (pet_id) REFERENCES pets(id)
);