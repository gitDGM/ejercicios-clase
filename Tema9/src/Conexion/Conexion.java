package Conexion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class Conexion {

    private String servidor;
    private String bbdd;
    private String user;
    private String password;
    private Connection conexionBD;
    private Statement declaracionBD;

    public Conexion(String bbdd) {
        servidor = "jdbc:mariadb://localhost:3306/";
        this.bbdd = bbdd;
        user = "alumno";
        password = "P@ssw0rd";
        conexionBD = null;
        declaracionBD = null;
    }

    public void conectar() {
        try {
            conexionBD = DriverManager.getConnection(servidor + bbdd, user, password);
            declaracionBD = conexionBD.createStatement();
        } catch (SQLException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        }
    }

    public void ejecutarModificar(String query) {
        PreparedStatement resultado = null;

        try {
            resultado = conexionBD.prepareStatement(query);
            resultado.execute();
            System.out.println("\nATENCIÓN: Se ejecutó correctamente.\n");
        } catch (SQLException ex) {
            if (ex.getMessage().contains("Duplicate entry")) {
                System.err.println("ERROR: El registro está duplicado.");
            } else {
                System.err.println("ERROR: " + ex.getMessage());
            }
        }
    }

    public ArrayList<String> ejecutarObtener(String query) {
        ArrayList<String> data = new ArrayList();
        ResultSet resultado = null;

        try {
            resultado = declaracionBD.executeQuery(query);

            while (resultado.next()) {
                ResultSetMetaData resultadoMeta = resultado.getMetaData();
                int numCampos = resultadoMeta.getColumnCount();
                String fila = "";

                for (int i = 0; i < numCampos; i++) {
                    fila += resultado.getString(i + 1);
                    if (i != i - 1 && numCampos != 1) {
                        fila += ";";
                    }
                }
                if (resultado.next()) {
                    fila += "\n";
                }

                data.add(fila);
            }
        } catch (SQLException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        }

        return data;
    }

    public String getServidor() {
        return servidor;
    }

    public String getBbdd() {
        return bbdd;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public void setBbdd(String bbdd) {
        this.bbdd = bbdd;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
