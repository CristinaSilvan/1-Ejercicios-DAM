CREATE TABLE CLIENTE (
    ID_cliente INTEGER PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefono VARCHAR(20) NOT NULL
);

CREATE TABLE EMPLEADO (
    ID_empleado INTEGER PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefono VARCHAR(20) NOT NULL
);

CREATE TABLE PROVEEDOR (
    ID_proveedor INTEGER PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefono VARCHAR(20) NOT NULL
);

CREATE TABLE ALMACEN (
    ID_almacen INTEGER PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    ubicacion VARCHAR(200) NOT NULL
);

CREATE TABLE PEDIDO (
    ID_pedido INTEGER PRIMARY KEY,
    fecha_solicitud DATE NOT NULL,
    estado VARCHAR(50) NOT NULL,
    ID_cliente INTEGER,
    ID_empleado INTEGER,
    FOREIGN KEY (ID_cliente) REFERENCES CLIENTE(ID_cliente),
    FOREIGN KEY (ID_empleado) REFERENCES EMPLEADO(ID_empleado)
);

CREATE TABLE FACTURA (
    ID_factura INTEGER PRIMARY KEY,
    total REAL NOT NULL,
    fecha_emision DATE NOT NULL,
    ID_pedido INTEGER,
    ID_empleado INTEGER, 
    FOREIGN KEY (ID_pedido) REFERENCES PEDIDO(ID_pedido),
    FOREIGN KEY (ID_empleado) REFERENCES EMPLEADO(ID_empleado)
);

CREATE TABLE PRODUCTO (
    ID_producto INTEGER PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(500),
    precio REAL NOT NULL,
    ID_proveedor INTEGER,
    ID_almacen INTEGER,
    FOREIGN KEY (ID_proveedor) REFERENCES PROVEEDOR(ID_proveedor),
    FOREIGN KEY (ID_almacen) REFERENCES ALMACEN(ID_almacen)
);

CREATE TABLE CONTIENE (
    ID_pedido INTEGER,
    ID_producto INTEGER, 
    cantidad INTEGER NOT NULL,
    FOREIGN KEY (ID_pedido) REFERENCES PEDIDO(ID_pedido),
    FOREIGN KEY (ID_producto) REFERENCES PRODUCTO(ID_producto)
);

CREATE TABLE RECIBE (
    ID_producto INTEGER,
    ID_almacen INTEGER,
    stock INTEGER NOT NULL,
    FOREIGN KEY (ID_producto) REFERENCES PRODUCTO(ID_producto),
    FOREIGN KEY (ID_almacen) REFERENCES ALMACEN(ID_almacen)
);