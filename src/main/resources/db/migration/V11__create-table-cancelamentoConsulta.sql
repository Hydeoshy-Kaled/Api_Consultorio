ALTER TABLE consultas
add column cancelada BOOLEAN DEFAULT FALSE,
add column motivo_cancelamento VARCHAR(255);