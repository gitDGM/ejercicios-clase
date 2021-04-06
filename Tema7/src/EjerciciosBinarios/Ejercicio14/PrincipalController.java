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
public class PrincipalController {
    private final LocomotorasController locomotoraController;
    private final VagonesController vagonesController;

    public PrincipalController() {
        locomotoraController = new LocomotorasController();
        vagonesController = new VagonesController();
    }
    
    public void altaLocomotora(Locomotora nuevaLocomotora) {
        locomotoraController.addLocomotora(nuevaLocomotora);
    }
    
    public void bajaLocomotora(int idLocomotora) {
        locomotoraController.removeLocomotora(idLocomotora);
    }
    
    public void mostrarLocomotoras() {
        locomotoraController.mostrarLocomotoras();
    }
    
    public void mostrarVagones() {
        vagonesController.mostrarVagones();
    }
    
    public void guardarDatosEnFicheros() {
        locomotoraController.guardarLocomotorasEnFichero();
        vagonesController.guardarVagonesEnFichero();
    }
}
