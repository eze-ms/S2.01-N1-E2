# Pizzería - Gestión de Base de Datos 🍕

## 📄 Descripción
Este proyecto implementa un sistema de gestión para una pizzería, con funcionalidades de pedidos, productos y categorías. Utiliza Java para conectar con una base de datos MySQL, crear tablas e interactuar con los datos almacenados.

---

## ✨ Características

### **Conexión a la base de datos**
- Clase `Conexion` para gestionar la conexión a MySQL.

### **Creación de tablas**
- Clase `CreateTables` para crear las siguientes tablas:
   - `Provincia`
   - `Localitat`
   - `Direccion`
   - `Cliente`
   - `Tienda`
   - `Empleado`
   - `Producto`
   - `Categoria`
   - `Orden`
   - `Orden_Producto`

### **Relaciones complejas**
- Soporta relaciones entre tablas como:
   - Localidades y provincias.
   - Tiendas y direcciones.
   - Clientes y órdenes.
   - Productos y categorías (solo para pizzas).
   - Órdenes y empleados (repartidores).

### **Operaciones avanzadas**
- Diseño optimizado para futuras consultas, como:
   - Ventas por localidad.
   - Órdenes por empleado.
   - Historial de categorías de pizzas.

---

## 💻 Tecnologías Utilizadas
- **Java 17**
- **MySQL**
- **IDE recomendado**: IntelliJ IDEA.

---

## 📊 Requisitos
- **Java Development Kit (JDK)**: Versión 17 o superior.
- **MySQL**: Servidor en funcionamiento con permisos de escritura.

---

## 🛠️ Instalación

1. Clona este repositorio:
   ```bash
   git clone https://github.com/eze-ms/S2.01-N1-E2
   ```
2. Configura la base de datos:
    - Crea una base de datos llamada `pizzeria_db`.
    - Ajusta las credenciales en la clase `Conexion`:
      ```java
      var usuario = "root";
      var password = "tu_contraseña";
      ```
3. Ejecuta el archivo `CreateTables.java` para crear las tablas.

---

## 🔧 Ejecución
1. Asegúrate de tener la base de datos configurada correctamente.
2. Compila y ejecuta la clase `CreateTables` desde tu IDE o terminal.
3. Verifica que las tablas se han creado en tu base de datos MySQL.

---

## ✨ Características Adicionales
Este proyecto está diseñado para ser escalable, con soporte para futuras funcionalidades como:
- Gestión de empleados.
- Reportes detallados de ventas.
- Integración de servicios de entrega.

---

## 📢 Notas
Si tienes problemas con la conexión, verifica:
- La URL del servidor MySQL.
- Las credenciales configuradas en la clase `Conexion`.
- Que el servidor MySQL esté en funcionamiento.

---

© 2024. Proyecto desarrollado por Ezequiel Macchi Seoane.
