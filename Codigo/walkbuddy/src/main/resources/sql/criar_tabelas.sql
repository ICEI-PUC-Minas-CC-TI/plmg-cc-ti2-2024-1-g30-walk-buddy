DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

CREATE TYPE tipo_usuario AS ENUM ('dono', 'passeador');
CREATE TABLE usuario (
  id SERIAL PRIMARY KEY,
  email VARCHAR(100) NOT NULL,
  senha VARCHAR(255) NOT NULL,
  nome VARCHAR(70) NOT NULL,
  cpf CHAR(11) NOT NULL,
  foto VARCHAR(255),
  tipo tipo_usuario NOT NULL,
  telefone1 CHAR(11) NOT NULL,
  telefone2 CHAR(11)
);

CREATE TYPE estado_passeio AS ENUM ('solicitado', 'aceito','em andamento', 'concluido', 'avaliado');
CREATE TABLE passeio (
  id SERIAL PRIMARY KEY,
  data DATE NOT NULL,
  hora TIME NOT NULL,
  estado estado_passeio NOT NULL,
  valor FLOAT8,
  observacoes VARCHAR(255),
  id_passeador INT,
  CONSTRAINT fk_passeador
    FOREIGN KEY (id_passeador)
      REFERENCES usuario(id)
);

CREATE TABLE pet (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(70) NOT NULL,
  dataNascimento VARCHAR(30) NOT NULL,
  raca VARCHAR(30) NOT NULL,
  perfilcomportamental VARCHAR(255),
  foto TEXT,
  id_dono INT NOT NULL,
  CONSTRAINT fk_dono
    FOREIGN KEY (id_dono)
      REFERENCES usuario (id)
);

CREATE TABLE passeio_pet (
  id_passeio INT NOT NULL,
  id_pet INT NOT NULL,
  PRIMARY KEY (id_passeio, id_pet),
  CONSTRAINT fk_passeio
    FOREIGN KEY (id_passeio)
      REFERENCES passeio (id),
  CONSTRAINT fk_pet
    FOREIGN KEY (id_pet)
      REFERENCES pet (id)
);
