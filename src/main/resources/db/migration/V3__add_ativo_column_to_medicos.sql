-- V2__add_ativo_column_to_medicos.sql
ALTER TABLE medicos ADD COLUMN ativo boolean;

UPDATE medicos SET ativo = true;
