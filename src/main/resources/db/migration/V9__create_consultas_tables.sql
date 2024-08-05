CREATE TABLE consultas (
    id BIGSERIAL PRIMARY KEY,
    nome_paciente VARCHAR(255) NOT NULL,
    nome_medico VARCHAR(255) NOT NULL,
    data_hora TIMESTAMP NOT NULL
);
