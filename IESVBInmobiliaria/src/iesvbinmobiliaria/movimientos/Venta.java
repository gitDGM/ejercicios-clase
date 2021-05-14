/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iesvbinmobiliaria.movimientos;

/**
 *
 *
 * @author alumno
 */
public class Venta {

    private final int idVenta;
    private final int idCliente;
    private final int idEmpleado;
    private final int idVivienda;

    public Venta(int idVenta, int idCliente, int idEmpleado, int idVivienda) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.idVivienda = idVivienda;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public int getIdVivienda() {
        return idVivienda;
    }

}
