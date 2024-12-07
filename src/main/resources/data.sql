-- Insertar tipos de usuario
INSERT INTO tipo_usuario (id_tipo_usuario, descripcion) VALUES
(1, 'Cliente'),
(2, 'Especialista');

-- Insertar especialidades
INSERT INTO especialidad (id_especialidad, descripcion) VALUES
(1, 'Plomería'),
(2, 'Electricidad'),
(3, 'Carpintería'),
(4, 'Pintura'),
(5, 'Albañilería'),
(6, 'Jardinería'),
(7, 'Cerrajería'),
(8, 'Limpieza'),
(9, 'Aire Acondicionado'),
(10, 'Remodelación');

-- Insertar usuarios (incluyendo especialistas y clientes)
INSERT INTO usuario (id_usuario, nombre, ap_paterno, ap_materno, email, telefono, contrasena, calificacionprom, id_tipo_usuario) VALUES
(1, 'Juan', 'Pérez', 'García', 'juan@email.com', 912345678, 'password123', 4, 1),
(2, 'María', 'González', 'López', 'maria@email.com', 987654321, 'password123', 4, 1),
(3, 'Carlos', 'Rodriguez', 'Martinez', 'carlos@email.com', 923456789, 'password123', 4, 2),
(4, 'Ana', 'Sánchez', 'Romero', 'ana@email.com', 934567890, 'password123', 5, 2);

-- Asignar especialidades a especialistas
INSERT INTO usuario_especialidad (id_usuario, id_especialidad) VALUES
(3, 1), -- Carlos es plomero
(3, 2), -- Carlos es electricista
(4, 3), -- Ana es carpintera
(4, 4); -- Ana es pintora

-- Insertar algunos servicios
INSERT INTO servicio (id_servicio, nombre_servicio, descripcion_servicio, valor_servicio, horario, id_usuario) VALUES
(1, 'Reparación Eléctrica', 'Servicio de reparación eléctrica general', 50000, '9:00 AM - 6:00 PM', 3),
(2, 'Instalación Plomería', 'Instalación y reparación de tuberías', 45000, '8:00 AM - 5:00 PM', 3),
(3, 'Carpintería General', 'Trabajos generales de carpintería', 60000, '9:00 AM - 7:00 PM', 4),
(4, 'Pintura Interior', 'Servicio de pintura para interiores', 55000, '8:00 AM - 6:00 PM', 4);

-- Insertar algunas reservas
INSERT INTO reserva (id_reserva, estado_reserva, fecha_reserva, hora_reserva, id_especialista, id_usuario, motivo) VALUES
(1, 'Pendiente', '2024-12-10', '10:00', 3, 1, 'Reparación eléctrica urgente'),
(2, 'Confirmada', '2024-12-11', '15:00', 4, 2, 'Pintura sala y comedor');

-- Insertar algunas reseñas
INSERT INTO resena (id_resena, calificacion, comentario) VALUES
(1, 5, 'Excelente servicio, muy profesional'),
(2, 4, 'Buen trabajo, puntual y ordenado');

-- Insertar pagos
INSERT INTO pago (id_pago, estado_pago, fecha_pago, valor_pago) VALUES
(1, 'Completado', '2024-12-10', 50000),
(2, 'Pendiente', '2024-12-11', 55000);