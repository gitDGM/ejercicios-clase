/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iesvbinmobiliaria.movimientos;

import iesvbinmobiliaria.personas.Cliente;
import iesvbinmobiliaria.personas.Empleado;
import iesvbinmobiliaria.viviendas.Vivienda;

/**
 *
 * @author alumno
 */
public class Venta {

    private final Cliente comprador;
    private final Cliente propietario;
    private final Empleado vendedor;
    private final Vivienda vivienda;

    public Venta(Cliente comprador, Cliente propietario, Empleado vendedor, Vivienda vivienda) {
        this.comprador = comprador;
        this.propietario = propietario;
        this.vendedor = vendedor;
        this.vivienda = vivienda;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public Cliente getPropietario() {
        return propietario;
    }

    public Empleado getVendedor() {
        return vendedor;
    }

    public Vivienda getVivienda() {
        return vivienda;
    }

}
