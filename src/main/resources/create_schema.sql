CREATE TABLE filme (
  id SERIAL,
  titulo VARCHAR(50),
  genero VARCHAR(50),
  duracao DOUBLE PRECISION,
  estado VARCHAR(50),
  PRIMARY KEY (id)
);

CREATE TABLE emprestimo (
  id SERIAL,
  id_filme INT,
  data_emprestimo DATE,
  data_devolucao DATE,
  PRIMARY KEY (id),
  FOREIGN KEY (id_filme) REFERENCES filme (id)
)