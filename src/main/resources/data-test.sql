-- ========================
-- INSERTS DE USUARIOS
-- ========================
INSERT INTO usuarios (nombre, apellido, email, telefono, rol, contrasena) VALUES
('Juan', 'Pérez', 'juan.perez@example.com', '987654321', 'cliente', '1234'),
('María', 'López', 'maria.lopez@example.com', '987654322', 'cliente', '1234'),
('Carlos', 'Gómez', 'carlos.gomez@example.com', '987654323', 'recepcionista', '1234'),
('Ana', 'Torres', 'ana.torres@example.com', '987654324', 'admin', '1234');

-- ========================
-- INSERTS DE HABITACIONES
-- ========================
INSERT INTO habitaciones (numero_habitacion, tipo_habitacion, capacidad, precio_noche, estado) VALUES
(101, 'simple', 1, 80.00, 'disponible'),
(102, 'doble', 2, 120.00, 'disponible'),
(201, 'suite', 3, 250.00, 'ocupada'),
(202, 'doble', 2, 110.00, 'mantenimiento');

-- ========================
-- INSERTS DE RESERVAS
-- ========================
INSERT INTO reservas (id_usuario, id_habitacion, check_in, check_out, estado) VALUES
(1, 1, '2025-09-10', '2025-09-12', 'confirmada'),
(2, 3, '2025-09-15', '2025-09-18', 'pendiente');

-- ========================
-- INSERTS DE PAGOS
-- ========================
INSERT INTO pagos (id_reserva, monto, metodo_pago, estado) VALUES
(1, 160.00, 'tarjeta', 'pagado'),
(2, 250.00, 'efectivo', 'pendiente');

-- ========================
-- INSERTS DE SERVICIOS
-- ========================
INSERT INTO servicios (nombre_servicio, descripcion, precio) VALUES
('Desayuno buffet', 'Desayuno completo incluido', 20.00),
('Spa', 'Acceso al spa por 2 horas', 50.00),
('Transporte aeropuerto', 'Recojo y traslado al aeropuerto', 40.00);

-- ========================
-- INSERTS DE RESERVA_SERVICIO
-- ========================
INSERT INTO reserva_servicio (id_reserva, id_servicio, cantidad) VALUES
(1, 1, 2), -- Reserva 1 con 2 desayunos
(1, 3, 1), -- Reserva 1 con transporte
(2, 2, 1); -- Reserva 2 con spa
