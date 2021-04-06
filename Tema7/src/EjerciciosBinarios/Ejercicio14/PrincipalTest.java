/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosBinarios.Ejercicio14;

/**
 *
 * @author alumno
 */
public class PrincipalTest {
    public static void main(String[] args) {
        PrincipalController principalController = new PrincipalController();        
        
        //principalController.altaLocomotora(new Locomotora(2));
        //principalController.bajaLocomotora(2);
        principalController.mostrarLocomotoras();
        
        //principalController.altaVagon(new Vagon(2));
        //principalController.bajaVagon(2);
        principalController.mostrarVagones();
        
        principalController.guardarDatosEnFicheros();
    }
}
