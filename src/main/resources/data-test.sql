-- =====================================
-- ROLES
-- =====================================
INSERT INTO roles (nombre) VALUES
    ('Administrador'),
    ('Recepcionista'),
    ('PersonaldeMantenimiento'),
    ('Cliente')
ON CONFLICT DO NOTHING;

-- =====================================
-- USUARIOS
-- =====================================
INSERT INTO usuarios (nombre, apellido, email, telefono, contrasena, id_rol) VALUES
    ('Juan', 'Pérez', 'juan.perez@example.com', '987654321', 'password123', 4),
    ('María', 'García', 'maria.garcia@example.com', '912345678', 'password123', 4),
    ('Luis', 'Ramírez', 'luis.ramirez@example.com', '998877665', 'password123', 2),
    ('Ana', 'Torres', 'ana.torres@example.com', '987112233', 'password123', 1),
    ('Pedro', 'Lopez', 'pedro.lopez@example.com', '956123789', 'password123', 3),
    ('Sofía', 'Mendoza', 'sofia.mendoza@example.com', '974556889', 'password123', 3)
ON CONFLICT DO NOTHING;

-- =====================================
-- CLIENTES
-- =====================================
INSERT INTO clientes (id_usuario, tipo_documento, documento, nacionalidad, fecha_nacimiento) VALUES
    (1, 'DNI', '12345678', 'Peruana', '1990-05-15'),
    (2, 'Pasaporte', 'P7654321', 'Chilena', '1985-10-20')
ON CONFLICT DO NOTHING;

-- =====================================
-- PERSONAL
-- =====================================
INSERT INTO personal (id_usuario, cargo, salario, fecha_contratacion) VALUES
    (3, 'Recepcionista', 1800.00, '2023-02-10'),
    (4, 'Administrador', 3000.00, '2022-08-01'),
    (5, 'Mantenimiento', 1600.00, '2022-12-15'),
    (6, 'Mantenimiento', 1600.00, '2023-01-05')
ON CONFLICT DO NOTHING;

-- =====================================
-- HUESPEDES TEMPORALES
-- =====================================
INSERT INTO huespedes_temporales (nombre, apellido, tipo_documento, documento, nacionalidad, fecha_nacimiento, registrado_por) VALUES
    ('Carlos', 'Sánchez', 'Pasaporte', 'T1234567', 'Argentina', '1992-03-10', 3),
    ('Lucía', 'Fernández', 'Pasaporte', 'T7654321', 'Brasil', '1988-11-25', 3),
    ('Mateo', 'Gómez', 'Pasaporte', 'T9876543', 'Colombia', '1995-06-15', 3),
    ('Valentina', 'Ríos', 'Pasaporte', 'T4567890', 'Ecuador', '1991-09-12', 3)
ON CONFLICT DO NOTHING;

-- =====================================
-- TIPOS DE HABITACIÓN
-- =====================================
INSERT INTO tipo_habitacion (nombre, descripcion, precio_base) VALUES
    ('Individual', 'Habitación sencilla para una persona', 100.00),
    ('Doble', 'Habitación con cama matrimonial o dos individuales', 150.00),
    ('Suite', 'Habitación de lujo con sala de estar', 300.00)
ON CONFLICT DO NOTHING;

-- =====================================
-- HABITACIONES
-- =====================================
INSERT INTO habitaciones (numero_habitacion, id_tipo, estado) VALUES
    (101, 1, 'disponible'),
    (102, 2, 'ocupada'),
    (103, 2, 'disponible'),
    (201, 3, 'disponible'),
    (202, 3, 'mantenimiento')
ON CONFLICT DO NOTHING;

-- =====================================
-- RESERVAS
-- =====================================
INSERT INTO reservas (id_cliente, id_huesped_temp, id_habitacion, fecha_reserva, check_in, noches, estado) VALUES
    (1, NULL, 1, CURRENT_TIMESTAMP, '2025-09-20', 3, 'confirmada'),
    (2, NULL, 2, CURRENT_TIMESTAMP, '2025-09-25', 2, 'pendiente'),
    (NULL, 1, 3, CURRENT_TIMESTAMP, '2025-09-22', 1, 'confirmada'),
    (NULL, 2, 1, CURRENT_TIMESTAMP, '2025-09-28', 2, 'pendiente'),
    (NULL, 3, 2, CURRENT_TIMESTAMP, '2025-10-01', 4, 'confirmada'),
    (NULL, 4, 3, CURRENT_TIMESTAMP, '2025-10-03', 3, 'pendiente')
ON CONFLICT DO NOTHING;

-- =====================================
-- PAGOS
-- =====================================
INSERT INTO pagos (id_reserva, monto, metodo_pago, tipo_pago,fecha_pago, estado) VALUES
    (1, 300.00,'TarjetadeCrédito', 'reserva',CURRENT_TIMESTAMP, 'pagado'),
    (2, 300.00, 'TarjetadeDébito', 'reserva', CURRENT_TIMESTAMP, 'pendiente'),
    (3, 300.00, 'Efectivo', 'reserva', CURRENT_TIMESTAMP, 'pagado'),
    (4, 200.00, 'TransferenciaBancaria', 'reserva', CURRENT_TIMESTAMP, 'pendiente'),
    (5, 600.00, 'TarjetadeCrédito', 'reserva', CURRENT_TIMESTAMP, 'pagado'),
    (6, 900.00, 'TarjetadeDébito', 'reserva', CURRENT_TIMESTAMP, 'pendiente')
ON CONFLICT DO NOTHING;

-- =====================================
-- FACTURACIÓN
-- =====================================
INSERT INTO Facturacion (id_pago, numero_factura,fecha_emision, total) VALUES
    (1, 'FAC-0001',CURRENT_TIMESTAMP, 300.00),
    (2, 'FAC-0002',CURRENT_TIMESTAMP, 300.00),
    (3, 'FAC-0003',CURRENT_TIMESTAMP, 300.00),
    (4, 'FAC-0004',CURRENT_TIMESTAMP, 200.00),
    (5, 'FAC-0005',CURRENT_TIMESTAMP, 600.00),
    (6, 'FAC-0006',CURRENT_TIMESTAMP, 900.00)
ON CONFLICT DO NOTHING;

-- =====================================
-- CHECK-IN
-- =====================================
INSERT INTO check_In (id_reserva,fecha, realizado_por, estado_entrega, descripcion_entrega) VALUES
    (1,CURRENT_TIMESTAMP,3, 'Optimo', 'Habitación entregada en buen estado'),
    (3,CURRENT_TIMESTAMP,3,'Observacion', 'Pequeños desperfectos'),
    (5,CURRENT_TIMESTAMP,4,'Optimo', 'Habitación revisada y limpia')
ON CONFLICT DO NOTHING;

-- =====================================
-- CHECK-OUT
-- =====================================
INSERT INTO Check_Out (id_reserva,fecha, realizado_por, estado_devolucion, descripcion_devolucion) VALUES
    (1,CURRENT_TIMESTAMP, 3, 'Sucio', 'Se encontraron toallas manchadas'),
    (3,CURRENT_TIMESTAMP, 3, 'Optimo', 'Todo en orden'),
    (5,CURRENT_TIMESTAMP, 4, 'Optimo', 'Habitación entregada correctamente')
ON CONFLICT DO NOTHING;

-- =====================================
-- PENALIZACIONES
-- =====================================
INSERT INTO Penalizaciones (id_checkout, monto, descripcion) VALUES
    (1, 100.00, 'Costo por limpieza adicional')
ON CONFLICT DO NOTHING;
