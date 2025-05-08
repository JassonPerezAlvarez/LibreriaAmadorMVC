
package Controlador;
import DAO.DAOProveedor;
import Modelo.Proveedor;
import Modelo.Venta;
import Modelo.DetalleVenta;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ProveedorController {
    
    
    
    private final DAOProveedor daoProveedor;

    public ProveedorController() {
        this.daoProveedor = new DAOProveedor();
    }

    // Método para crear un nuevo proveedor
    public void crearProveedor(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
                               String contacto, String correo) {
        try {
            Proveedor proveedor = new Proveedor();
            proveedor.setPrimerNombre(primerNombre);
            proveedor.setSegundoNombre(segundoNombre);
            proveedor.setPrimerApellido(primerApellido);
            proveedor.setSegundoApellido(segundoApellido);
            proveedor.setContacto(contacto);
            proveedor.setCorreo(correo);
            daoProveedor.crearProveedor(proveedor);
            JOptionPane.showMessageDialog(null, "Proveedor creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el proveedor: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para obtener todos los proveedores
    public List<Proveedor> obtenerTodosProveedores() {
        try {
            return daoProveedor.leerTodosProveedores();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer los proveedores: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método para actualizar un proveedor existente
    public void actualizarProveedor(int idProveedor, String primerNombre, String segundoNombre, String primerApellido,
                                    String segundoApellido, String contacto, String correo) {
        try {
            Proveedor proveedor = new Proveedor();
            proveedor.setIdProveedor(idProveedor);
            proveedor.setPrimerNombre(primerNombre);
            proveedor.setSegundoNombre(segundoNombre);
            proveedor.setPrimerApellido(primerApellido);
            proveedor.setSegundoApellido(segundoApellido);
            proveedor.setContacto(contacto);
            proveedor.setCorreo(correo);
            daoProveedor.actualizarProveedor(proveedor);
            JOptionPane.showMessageDialog(null, "Proveedor actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el proveedor: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para eliminar un proveedor
    public void eliminarProveedor(int idProveedor) {
        try {
            daoProveedor.eliminarProveedor(idProveedor);
            JOptionPane.showMessageDialog(null, "Proveedor eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el proveedor: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método main para pruebas
    public static void main(String[] args) {
        ProveedorController controlador = new ProveedorController();

        // Crear un proveedor
        controlador.crearProveedor("Juan", "Carlos", "Pérez", "Gómez", "555-1234", "juan@proveedor.com");

        // Leer todos los proveedores
        List<Proveedor> proveedores = controlador.obtenerTodosProveedores();
        if (proveedores != null) {
            System.out.println("Lista de proveedores:");
            for (Proveedor p : proveedores) {
                System.out.println("ID: " + p.getIdProveedor()
                        + ", Nombre: " + p.getPrimerNombre() + " " + p.getPrimerApellido()
                        + ", Correo: " + p.getCorreo());
            }
        }

        // Actualizar un proveedor (suponiendo que ID 1 existe)
        controlador.actualizarProveedor(1, "Juan", "Carlos", "Pérez", "Martínez", "555-5678", "juan_nuevo@proveedor.com");

        // Eliminar un proveedor
        controlador.eliminarProveedor(1);
    }
}
