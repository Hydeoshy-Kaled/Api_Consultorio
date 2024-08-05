ALTER TABLE consultas
ADD CONSTRAINT fk_paciente FOREIGN KEY (paciente_id) REFERENCES pacientes(id),
ADD CONSTRAINT fk_medico FOREIGN KEY (medico_id) REFERENCES medicos(id);