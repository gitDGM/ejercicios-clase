/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IESVBBank;

/**
 *
 * @author alumno
 */
public class IESVBBankMain {
    public static void main(String[] args) {
        try {
            IESVBBank cuenta = new IESVBBank("ES2609000728501234567890", "Diego Gomez Moreno"); 
            int cantidadOpciones = 8;
            for (int opcion = 1; opcion <= cantidadOpciones; opcion++) {
                System.out.println("\n###################################");
                System.out.println("1. Datos de la cuenta");
                System.out.println("2. IBAN");
                System.out.println("3. Titular");
                System.out.println("4. Saldo");
                System.out.println("5. Ingreso");
                System.out.println("6. Retirada");
                System.out.println("7. Movimientos");
                System.out.println("8. Salir");
                System.out.println("###################################");
                switch (opcion) {
                    case 1:
                        System.out.println("\nDATOS DE LA CUENTA\n");
                        cuenta.mostarDatosCuenta();
                        break;
                    case 2:
                        System.out.println("\nIBAN\n");
                        System.out.println("IBAN: " + cuenta.getIBAN());
                        break;
                    case 3:
                        System.out.println("\nTITULAR\n");
                        System.out.println("Titular: " + cuenta.getTitular());
                        break;
                    case 4:
                        System.out.println("\nSALDO\n");
                        System.out.println("Saldo: " + cuenta.getSaldo());
                        break;
                    case 5:
                        System.out.println("\nINGRESO\n");
                        int saldoIngreso = 240;
                        if (cuenta.ingresar(saldoIngreso)) {
                            System.out.println("Has ingresado " + saldoIngreso);
                        } else {
                            System.out.println("Ingreso fallido.");
                        }
                        break;
                    case 6:
                        System.out.println("\nRETIRADA\n");
                        int saldoRetiro = 250;
                        if (cuenta.retirar(saldoRetiro)) {
                            System.out.println("Has retirado " + saldoRetiro);
                        } else {
                            System.out.println("Retirada fallida.");
                        }
                        break;
                    case 7:
                        System.out.println("\nMOVIMIENTOS\n");
                        cuenta.getMovimientos();
                        break;
                    case 8:
                        // cuenta.mostarDatosCuenta(); // TESTING
                        System.out.println("Hasta la próxima.");
                        break;
                    default:
                        System.out.println("Fuera de rango.");
                        break;
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
