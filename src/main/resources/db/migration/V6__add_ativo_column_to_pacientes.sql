-- V2__add_ativo_column_to_medicos.sql
ALTER TABLE pacientes ADD COLUMN ativo boolean;

UPDATE pacientes SET ativo = true;
