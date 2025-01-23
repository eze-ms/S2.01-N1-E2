package gm.model;

import gm.conexion.Conexion;

import java.sql.Connection;
import java.sql.Statement;

public class CreateTables {

    public static void createTables() {
        Connection connection = Conexion.getConexion();

        String Provincia = "CREATE TABLE IF NOT EXISTS Provincia (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "nombre VARCHAR(45) NOT NULL" +
                ") ENGINE = InnoDB;";

        String Localidad = "CREATE TABLE IF NOT EXISTS Localitat (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "nombre VARCHAR(45) NOT NULL, " +
                "provincia_id INT NOT NULL, " +
                "FOREIGN KEY (provincia_id) REFERENCES Provincia(id)" +
                ") ENGINE = InnoDB;";

        String Direccion = "CREATE TABLE IF NOT EXISTS Direccion (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "calle VARCHAR(45) NOT NULL, " +
                "numero VARCHAR(10) NOT NULL, " +
                "piso VARCHAR(10), " +
                "puerta VARCHAR(10), " +
                "codigo_postal VARCHAR(10) NOT NULL, " +
                "localidad_id INT NOT NULL, " +
                "FOREIGN KEY (localidad_id) REFERENCES Localitat(id)" +
                ") ENGINE = InnoDB;";

        String Categoria = "CREATE TABLE IF NOT EXISTS Categoria (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "nombre VARCHAR(100) NOT NULL, " +
                "valido_desde DATE NOT NULL, " +
                "valido_hasta DATE DEFAULT NULL" +
                ") ENGINE = InnoDB;";

        String Producto = "CREATE TABLE IF NOT EXISTS Producto (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "nombre VARCHAR(45) NOT NULL, " +
                "descripcion TEXT, " +
                "imagen VARCHAR(255), " +
                "precio DECIMAL(10, 2) NOT NULL, " +
                "tipo_producto ENUM('pizza', 'hamburguesa', 'bebida') NOT NULL, " +
                "categoria_id INT DEFAULT NULL, " +
                "FOREIGN KEY (categoria_id) REFERENCES Categoria(id)" +
                ") ENGINE = InnoDB;";

        String Cliente = "CREATE TABLE IF NOT EXISTS Cliente (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "nombre VARCHAR(45) NOT NULL, " +
                "apellidos VARCHAR(45) NOT NULL, " +
                "telefono VARCHAR(15) NOT NULL, " +
                "direccion_id INT NOT NULL, " +
                "FOREIGN KEY (direccion_id) REFERENCES Direccion(id)" +
                ") ENGINE = InnoDB;";

        String Tienda = "CREATE TABLE IF NOT EXISTS Tienda (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "direccion_id INT NOT NULL, " +
                "FOREIGN KEY (direccion_id) REFERENCES Direccion(id)" +
                ") ENGINE = InnoDB;";

        String Empleado = "CREATE TABLE IF NOT EXISTS Empleado (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "nombre VARCHAR(45) NOT NULL, " +
                "apellidos VARCHAR(45) NOT NULL, " +
                "nif VARCHAR(20) UNIQUE NOT NULL, " +
                "telefono VARCHAR(15) NOT NULL, " +
                "rol ENUM('cocinero', 'repartidor') NOT NULL, " +
                "tienda_id INT NOT NULL, " +
                "FOREIGN KEY (tienda_id) REFERENCES Tienda(id)" +
                ") ENGINE = InnoDB;";

        String Orden = "CREATE TABLE IF NOT EXISTS Orden (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "cliente_id INT NOT NULL, " +
                "tienda_id INT NOT NULL, " +
                "empleado_id INT, " +
                "fecha_hora DATETIME NOT NULL, " +
                "tipo_entrega ENUM('domicilio', 'recogida') NOT NULL, " +
                "precio_total DECIMAL(10, 2) NOT NULL, " +
                "fecha_hora_entrega DATETIME, " +
                "FOREIGN KEY (cliente_id) REFERENCES Cliente(id), " +
                "FOREIGN KEY (tienda_id) REFERENCES Tienda(id), " +
                "FOREIGN KEY (empleado_id) REFERENCES Empleado(id)" +
                ") ENGINE = InnoDB;";

        String Orden_Producto = "CREATE TABLE IF NOT EXISTS Orden_Producto (" +
                "orden_id INT NOT NULL, " +
                "producto_id INT NOT NULL, " +
                "cantidad INT NOT NULL, " +
                "precio_unitario DECIMAL(10, 2) NOT NULL, " +
                "PRIMARY KEY (orden_id, producto_id), " +
                "FOREIGN KEY (orden_id) REFERENCES Orden(id), " +
                "FOREIGN KEY (producto_id) REFERENCES Producto(id)" +
                ") ENGINE = InnoDB;";

        try {
            Statement statement = connection.createStatement();

            // Crear tablas en el orden correcto
            statement.executeUpdate(Provincia);
            statement.executeUpdate(Localidad);
            statement.executeUpdate(Direccion);
            statement.executeUpdate(Categoria);
            statement.executeUpdate(Producto);
            statement.executeUpdate(Cliente);
            statement.executeUpdate(Tienda);
            statement.executeUpdate(Empleado);
            statement.executeUpdate(Orden);
            statement.executeUpdate(Orden_Producto);

            System.out.println("Tablas creadas con éxito.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createTables();
    }
}