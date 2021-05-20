/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import Conexion.Conexion;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

/**
 *
 * @author alumno
 */
public class PrincipalController {

    private final Conexion db;

    public PrincipalController(String bbdd) {
        db = new Conexion(bbdd);
        db.conectar();
    }

    public void insertarFuncionario(String nombre, String provincia, int edad) {
        String query = "INSERT INTO funcionarios VALUES (null, '" + nombre + "', '" + provincia + "', " + edad + ");";
        db.ejecutarModificar(query);
    }

    public void insertarContribuyente(String dni, String nombre, String poblacion, int idFuncionario, double importe, boolean pagar) {
        String query = "INSERT INTO contribuyentes values (null, '" + dni + "', '" + nombre + "', '" + poblacion + "', " + idFuncionario + ", " + importe + ", " + pagar + ", NOW());";

        if (existeFuncionario(idFuncionario) && verificarDNI(dni)) {
            db.ejecutarModificar(query);
        } else {
            System.err.println("ERROR: No ha sido posible añadir el contribuyente.");
        }
    }

    public void eliminarContribuyente(String dni) {
        String query = "DELETE FROM contribuyentes where dni='" + dni + "';";

        if (existeContribuyente(dni)) {
            db.ejecutarModificar(query);
        } else {
            System.err.println("ERROR: No existe ningún contribuyente con ese DNI.");
        }
    }

    public void modificarImporteContribuyente(String dni, double importe) {
        String query = "UPDATE contribuyentes SET importe=" + importe + " WHERE dni='" + dni + "';";

        if (existeContribuyente(dni)) {
            db.ejecutarModificar(query);
        } else {
            System.err.println("ERROR: No existe ningún contribuyente con ese DNI.");
        }
    }

    public HashMap<Integer, String> poblacionesFuncionarios() {
        HashMap<Integer, String> poblaciones = new HashMap();
        String query = "SELECT DISTINCT provincia FROM funcionarios;";

        ArrayList<String> data = db.ejecutarObtener(query);
        for (int i = 0; i < data.size(); i++) {
            poblaciones.put(i, data.get(i));
        }

        return poblaciones;
    }

    public void generarFicheroContribuyentes(String provincia) {
        String query = "SELECT * FROM contribuyentes WHERE poblacion = '" + provincia + "' AND pagar = TRUE AND fecha_realizacion < '2022-01-01';";
        String verifyQuery = "SELECT COUNT(idFuncionario) FROM contribuyentes WHERE poblacion = '" + provincia + "' AND pagar = TRUE AND fecha_realizacion < '2022-01-01';";

        if (contieneDatos(verifyQuery)) {
            ArrayList<String> resultado = db.ejecutarObtener(query);
            escribirFichero(resultado);
            mostrarResultadoAtendidos(resultado);
        } else {
            System.err.println("ERROR: No existen registros.");
        }

    }

    public void mostrarAtendidos() {
        String query = "SELECT funcionarios.nombre, contribuyentes.nombre from contribuyentes inner join funcionarios ON contribuyentes.idfuncionario = funcionarios.idFuncionario;";
        String verifyQuery = "SELECT count(funcionarios.nombre) from contribuyentes inner join funcionarios ON contribuyentes.idfuncionario = funcionarios.idFuncionario;";

        if (contieneDatos(verifyQuery)) {
            ArrayList<String> resultado = db.ejecutarObtener(query);
            mostrarResultadoAtendidos(resultado);
        } else {
            System.err.println("ERROR: No existen registros.");
        }

    }

    public boolean existeFuncionario(int idFuncionario) {
        String query = "SELECT count(idFuncionario) from funcionarios where idFuncionario=" + idFuncionario + ";";
        boolean existe;

        existe = !db.ejecutarObtener(query).get(0).equals("0");

        return existe;
    }

    public boolean existeContribuyente(String dni) {
        String query = "SELECT count(dni) from contribuyentes where dni='" + dni + "';";

        return !db.ejecutarObtener(query).get(0).equals("0");
    }

    private void mostrarResultadoAtendidos(ArrayList<String> data) {

        for (int i = 0; i < data.size(); i++) {
            System.out.println("\n####### CONTRIBUYENTES ATENDIDOS ########");
            String[] dataFila = data.get(i).split(";");
            for (String campo : dataFila) {
                System.out.print(campo + "\t");
            }
            System.out.println();
        }
        System.out.println("#########################################\n");
    }

    private boolean verificarDNI(String dni) {
        String dniRegex = "\\d{8}[A-HJ-NP-TV-Z]";

        return Pattern.matches(dniRegex, dni);
    }

    private boolean contieneDatos(String query) {
        return !db.ejecutarObtener(query).get(0).equals("0");
    }

    private boolean comprobarPagar(String pagar) {
        return pagar.equals("1");
    }

    private void escribirFichero(ArrayList<String> data) {
        File fichero = new File("src/Ejercicio2/contribuyentes.bin");
        ObjectOutputStream flujoSalida = null;

        try {
            flujoSalida = new ObjectOutputStream(new FileOutputStream(fichero));
            for (int i = 0; i < data.size(); i++) {
                String[] campos = data.get(i).split(";");
                Contribuyente contribuyente = new Contribuyente(
                        Integer.parseInt(campos[0]), // ID
                        campos[1], // DNI
                        campos[2], // NOMBRE
                        campos[3], // POBLACION
                        Integer.parseInt(campos[4]),
                        Double.parseDouble(campos[5]),
                        comprobarPagar(campos[6]),
                        LocalDate.parse(campos[7])
                );
                flujoSalida.writeObject(contribuyente);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Error!!! El fichero no existe.");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (flujoSalida != null) {
                    flujoSalida.close();
                }
            } catch (IOException ex) {
                System.err.println("Error al cerrar el fichero.");
            }
        }
    }

}
