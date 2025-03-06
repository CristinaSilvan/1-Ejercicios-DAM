CREATE TABLE PROVEEDORES(
Id_Proveedor INTEGER PRIMARY KEY AUTOINCREMENT,
Nombre_Prov VARCHAR(100),
NIF_Prov VARCHAR(50),
Direccion_Prov VARCHAR(255),
Poblacion_Prov VARCHAR(100),
Telefono_Prov VARCHAR(20),
Email_Prov VARCHAR(100)
);

CREATE TABLE sqlite_sequence(name,seq);

CREATE TABLE USUARIOS (
Id_Usuario INTEGER PRIMARY KEY AUTOINCREMENT,
Nombre_Us VARCHAR(100),
Telefono_Us VARCHAR(20),
Email_Us VARCHAR(100)
);

CREATE TABLE CLIENTES (
Id_Cliente INTEGER PRIMARY KEY AUTOINCREMENT,
Nombre_Cli VARCHAR(100),
NIF_Cli VARCHAR(50),
Direccion_Cli VARCHAR(255),
Poblacion_Cli VARCHAR(100),
Telefono_Cli VARCHAR(20),
Email_Cli VARCHAR(100)
);

CREATE TABLE CAB_PEDIDOS (
Num_Ped INTEGER PRIMARY KEY AUTOINCREMENT,
Fecha_Ped DATE,
Estado_Ped VARCHAR(50),
IVA_Ped DECIMAL(5, 2),
Total_Ped DECIMAL(10, 2),
        Id_Proveedor INT,
        Id_Usuario INT,
        FOREIGN KEY (Id_Proveedor) REFERENCES PROVEEDORES(Id_Proveedor),
        FOREIGN KEY (Id_Usuario) REFERENCES USUARIOS(Id_Usuario)
);

CREATE TABLE CAB_FACTURAS (
Num_Fact INTEGER PRIMARY KEY AUTOINCREMENT,
Fecha_Fact DATE,
Estado_Fact VARCHAR(50),
IVA_Fact DECIMAL(5, 2),
Total_Fact DECIMAL(10, 2),
        Id_Cliente INT,
        Id_Usuario INT,
         FOREIGN KEY (Id_Cliente) REFERENCES CLIENTES(Id_Cliente),
         FOREIGN KEY (Id_Usuario) REFERENCES USUARIOS(Id_Usuario)
);

CREATE TABLE LINEAS_PED (
Id_Linea_Ped INT PRIMARY KEY,
Cantidad_Prod_Ped INT,
Precio_Prod_Ped DECIMAL(10, 2),
Subtotal_Ped DECIMAL(10, 2),
        Num_Ped INT,
        Id_Producto INT,
        Id_Almacen INT,
        FOREIGN KEY (Num_Ped) REFERENCES CAB_PEDIDOS(Num_Ped),
        FOREIGN KEY (Id_Producto) REFERENCES PRODUCTOS(Id_Prod),
        FOREIGN KEY (Id_Almacen) REFERENCES ALMACEN(Id_Almacen)
);

CREATE TABLE LINEAS_FACT (
Id_Linea_Fact INT PRIMARY KEY,
Cantidad_Prod_Fact INT,
Precio_Prod_Fact DECIMAL(10, 2),
Subtotal_Fact DECIMAL(10, 2),
        Num_Fact INT,
        Id_Producto INT,
        Id_Almacen INT,
        FOREIGN KEY (Num_Fact) REFERENCES CAB_FACTURAS(Num_Fact),
        FOREIGN KEY (Id_Producto) REFERENCES PRODUCTOS(Id_Prod),
        FOREIGN KEY (Id_Almacen) REFERENCES ALMACEN(Id_Almacen)
);

CREATE TABLE PRODUCTOS (
Id_Prod INTEGER PRIMARY KEY AUTOINCREMENT,
Nombre_Prod VARCHAR(100),
Proveedor_Prod VARCHAR(100),
Precio_Compra DECIMAL(10, 2),
Precio_Venta DECIMAL(10, 2)
);

CREATE TABLE ALMACEN (
Id_Almacen INTEGER PRIMARY KEY AUTOINCREMENT,
Nombre_Alm VARCHAR(100),
Ubicacion_Alm VARCHAR(255)
);

CREATE TABLE PRODUCTOS_ALMACEN (
Id_Producto INT,
        Id_Almacen INT,
        Stock INT,
        PRIMARY KEY (Id_Producto, Id_Almacen),
        FOREIGN KEY (Id_Producto) REFERENCES PRODUCTOS(Id_Prod),
        FOREIGN KEY (Id_Almacen) REFERENCES ALMACEN(Id_Almacen)
);