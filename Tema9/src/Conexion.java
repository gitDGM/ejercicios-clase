/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class Conexion {

    private String servidor;
    private String bbdd;
    private String user;
    private String password;

    public Conexion(String bbdd, String user, String password) {
        servidor = "jdbc:mariadb://localhost:3306";
        this.bbdd = bbdd;
        this.user = user;
        this.password = password;
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
