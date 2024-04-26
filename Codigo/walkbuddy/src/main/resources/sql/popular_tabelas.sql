INSERT INTO usuario (email, senha, nome, cpf, foto, tipo, telefone1)
VALUES 
('DonoDePet01', '123456', 'João Rosa', '11122233344', 'joao.png', 'dono', '31998989797'),
('DonoDePet02', '123456', 'Clarice Fonseca', '11122233344', 'clarice.png', 'dono', '31998989797'),
('DonoDePet03', '123456', 'Marina Lobato', '11122233344', 'marina.png', 'dono', '31998989797'),
('Passeador01', '123456', 'Mario Rodrigues', '11122233344', 'mario.png', 'passeador', '31998989797'),
('Passeador02', '123456', 'Jorge Veríssimo', '11122233344', 'jorge.png', 'passeador', '31998989797'),
('Passeador03', '123456', 'Lygia Abreu', '11122233344', 'lygia.png', 'passeador', '31998989797');

INSERT INTO pet (nome, idade, raca, perfilcomportamental, foto, id_dono)
VALUES 
('Toto', 3, 'Pastor', 'Ativo', 'toto.png', 1),
('Tete', 4, 'Pastor', 'Ativo', 'tete.png', 1),
('Agata', 1, 'Siames', 'Timido', 'agata.png', 2),
('Mimi', 3, 'Angorá', 'Arisco', 'mimi.png', 3);