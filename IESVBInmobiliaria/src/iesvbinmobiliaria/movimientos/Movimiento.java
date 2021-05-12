/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iesvbinmobiliaria.movimientos;

import iesvbinmobiliaria.personas.Cliente;
import iesvbinmobiliaria.viviendas.Vivienda;
import java.util.Date;

/**
 *
 * @author alumno
 */
public class Movimiento {

    private Cliente cliente;
    private Vivienda vivienda;
    private Date fecha;

    public Movimiento(Cliente cliente, Vivienda vivienda, float precio) {
        this.cliente = cliente;
        this.vivienda = vivienda;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
