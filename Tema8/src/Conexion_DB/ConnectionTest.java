/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion_DB;

import java.sql.*;

/**
 *
 * @author m_lou
 */
public class ConnectionTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Proyecto para realizar pruebas de conexión a bases de datos");
        System.out.println("===========================================================");
        System.out.println("\nMi primera prueba de conexión a bases de datos");

        //Cargaremos el driver JDBC de acceso a MariaDB  (ya no es necesario en las versiones nuevas del controlador)
        try {
            Class.forName("org.mariadb.jdbc.Driver"); //https://mariadb.com/kb/es/acerca-de-mariadb-connectorj/
        } catch (ClassNotFoundException error) {
            System.err.println("Error al cargar el driver JDBC de MySQL: " + error.getMessage());
        }

        //Realizo la conexión con el servidor MariaDB, por medio de una instancia de la
        //clase Connection (representa la conexion con la base de datos)
        //con los datos de conexión: dirección, puerto, usuario y contraseña
        //En este ejemplo suponemos que el servidor MariaDB está en localhost, puerto 3306, usuario root, sin contraseña
        Connection conexionBD = null;
        String servidor = "jdbc:mariadb://localhost:3306/";
        String bbdd = "test?serverTimezone=UTC"; //Base de datos "test", con uso horario
        String user = "alumno03";
        String password = "P@ssw0rd";
        try {
            conexionBD = DriverManager.getConnection(servidor + bbdd, user, password);
        } catch (SQLException error) {
            System.err.println("Error al conectar con el servidor MySQL/MariaDB: " + error.getMessage());
        }

        //Creamos una declaración (statement) de la conexión -> objeto de la clase Statement
        Statement objStm = null;
        try {
            objStm = conexionBD.createStatement();
        } catch (SQLException error) {
            System.err.println("Error al establecer declaración de conexión MariaDB: " + error.getMessage());
        }

        String creoTabla = "CREATE OR REPLACE TABLE animalesbis ( "
                + "COD INT(11) NOT NULL AUTO_INCREMENT, "
                + "NOMBRE VARCHAR(30) NOT NULL, "
                + "PRIMARY KEY (COD) )";
        //Esta sentencia vamos a ponerla dentro de una clase PreparedStatement
        //En estos ejemplos empleo la orden PreparedStatement, pero se podría utilizar la orden CreateStatement
        PreparedStatement sentencia = null;
        try {
            sentencia = conexionBD.prepareStatement(creoTabla);
            sentencia.execute();
        } catch (SQLException error) {
            System.err.println("Error al crear BD en servidor MariaDB: " + error.getMessage());
        }

        String insertoDatos = "INSERT INTO animalesbis (NOMBRE) VALUES ('Perro'), ('Gallina'), ('Oso'), ('Burro'), ('Lobo')";
        //Esta sentencia vamos a ponerla dentro de una clase PreparedStatement
        sentencia = null;
        try {
            sentencia = conexionBD.prepareStatement(insertoDatos);
            sentencia.execute();
        } catch (SQLException error) {
            System.err.println("Error al introducir datos en servidor MariaDB: " + error.getMessage());
        }

        //Ejecutamos una consulta SQL contra el statement anterior
        //El resultado se guardará en el ResultSet
        ResultSet resultados = null;
        try {
            resultados = objStm.executeQuery("select cod, nombre from animalesbis"); //consulta de una tabla de la BD test
            //Recorremos todos los registros del SQL devuelto en el ResultSet
            while (resultados.next()) {
                System.out.println("Animal: " + resultados.getString("cod") + " Nombre: " + resultados.getString("nombre"));
                //System.out.println("Animal: " + resultados.getString(1) + " Nombre: " + resultados.getString(2));
            }
        } catch (SQLException error) {
            System.err.println("Error al ejecutar SQL en servidor MariaDB: " + error.getMessage());
        }
        /*Podemos llamar a procedimientos almacenados poniendo como orden a ejecutar CALL y el nombre del procedimiento:
            resultados = objStm.executeQuery("CALL p1()"); */

        //Cerramos el ResultSet, el Statement, el PreparedStatement y la conexión
        try {
            if (sentencia != null) {
                sentencia.close();
            }
            if (resultados != null) {
                resultados.close();
            }
            if (objStm != null) {
                objStm.close();
            }
            if (conexionBD != null) {
                conexionBD.close(); //cierro la conexión
            }
        } catch (SQLException error) {
            System.err.println("Error al cerrar conexión a servidor MariaDB: " + error.getMessage());
        }

    }

}
