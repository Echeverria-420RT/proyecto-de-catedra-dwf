CREATE DATABASE IF NOT EXISTS restaurantedb;

-- Creación de la tabla Clientes
CREATE TABLE clientes (
    cliente_id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE,
    telefono VARCHAR(20),
    direccion VARCHAR(255)
);

-- Creación de la tabla Mesas
CREATE TABLE mesas (
    mesa_id INT PRIMARY KEY AUTO_INCREMENT,
    numero INT NOT NULL UNIQUE,
    capacidad INT NOT NULL,
    estado VARCHAR(50) -- Ej: 'disponible', 'ocupada', 'reservada'
);

-- Creación de la tabla Pedidos
CREATE TABLE pedidos (
    pedido_id INT PRIMARY KEY AUTO_INCREMENT,
    cliente_id INT NOT NULL,
    mesa_id INT NOT NULL,
    fecha_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR(50) NOT NULL, -- Ej: 'pendiente', 'en_preparacion', 'servido', 'pagado', 'cancelado'
    total DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES clientes(cliente_id),
    FOREIGN KEY (mesa_id) REFERENCES mesas(mesa_id)
);

-- Creación de la tabla Categorias
CREATE TABLE categorias (
    categoria_id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    descripcion TEXT
);

-- Creación de la tabla Platos
CREATE TABLE platos (
    plato_id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10, 2) NOT NULL,
    categoria_id INT NOT NULL,
    disponible BOOLEAN NOT NULL DEFAULT TRUE,
    FOREIGN KEY (categoria_id) REFERENCES categorias(categoria_id)
);

-- Creación de la tabla Opciones
CREATE TABLE opciones (
    opcion_id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL UNIQUE, -- Ej: 'extra queso', 'sin cebolla'
    precio_adicional DECIMAL(10, 2) DEFAULT 0.00
);

-- Creación de la tabla Platos_Opciones (tabla intermedia para relación N:M entre Platos y Opciones)
CREATE TABLE platos_ppciones (
    plato_id INT NOT NULL,
    opcion_id INT NOT NULL,
    PRIMARY KEY (plato_id, opcion_id), -- Clave primaria compuesta
    FOREIGN KEY (plato_id) REFERENCES platos(plato_id),
    FOREIGN KEY (opcion_id) REFERENCES opciones(opcion_id)
);

-- Creación de la tabla detalles_pedido
CREATE TABLE Detalles_Pedido (
    detalle_id INT PRIMARY KEY AUTO_INCREMENT,
    pedido_id INT NOT NULL,
    plato_id INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10, 2) NOT NULL,
    opciones TEXT, -- Para almacenar opciones específicas seleccionadas para este plato en este pedido (ej: "sin cebolla, extra picante")
    notas TEXT, -- Cualquier nota adicional para este detalle del pedido
    FOREIGN KEY (pedido_id) REFERENCES Pedidos(pedido_id),
    FOREIGN KEY (plato_id) REFERENCES Platos(plato_id)
);