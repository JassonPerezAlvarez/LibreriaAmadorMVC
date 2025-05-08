package Controlador;
import DAO.DAOCliente;
import Modelo.Cliente;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteController {
    private final DAOCliente daoCliente;

    public ClienteController() {
        this.daoCliente = new DAOCliente();
    }

    public void crearCliente(String primerNombre, String segundoNombre, String primerApellido,
                             String segundoApellido, String cedula, String contacto) {
        try {
            // Validaciones
            if (contacto != null && contacto.length() > 20) {
                JOptionPane.showMessageDialog(null, "El contacto no puede exceder los 20 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (primerNombre == null || primerNombre.isEmpty() || primerNombre.length() > 10) {
                JOptionPane.showMessageDialog(null, "El primer nombre debe tener entre 1 y 10 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (primerApellido == null || primerApellido.isEmpty() || primerApellido.length() > 10) {
                JOptionPane.showMessageDialog(null, "El primer apellido debe tener entre 1 y 10 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Cliente cliente = new Cliente();
            cliente.setPrimerNombre(primerNombre);
            cliente.setSegundoNombre(segundoNombre);
            cliente.setPrimerApellido(primerApellido);
            cliente.setSegundoApellido(segundoApellido);
            cliente.setCedula(cedula);
            cliente.setContacto(contacto);
            daoCliente.crearCliente(cliente);
            JOptionPane.showMessageDialog(null, "Cliente creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<Cliente> obtenerTodosClientes() {
        try {
            return daoCliente.leerTodosClientes();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer los clientes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void actualizarCliente(int idCliente, String primerNombre, String segundoNombre, String primerApellido,
                                  String segundoApellido, String cedula, String contacto) {
        try {
            if (contacto != null && contacto.length() > 20) {
                JOptionPane.showMessageDialog(null, "El contacto no puede exceder los 20 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Cliente cliente = new Cliente();
            cliente.setIdCliente(idCliente);
            cliente.setPrimerNombre(primerNombre);
            cliente.setSegundoNombre(segundoNombre);
            cliente.setPrimerApellido(primerApellido);
            cliente.setSegundoApellido(segundoApellido);
            cliente.setCedula(cedula);
            cliente.setContacto(contacto);
            daoCliente.actualizarCliente(cliente);
            JOptionPane.showMessageDialog(null, "Cliente actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarCliente(int idCliente) {
        try {
            if (daoCliente.tieneVentas(idCliente)) {
                JOptionPane.showMessageDialog(null, "No se puede eliminar el cliente porque tiene ventas asociadas.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            daoCliente.eliminarCliente(idCliente);
            JOptionPane.showMessageDialog(null, "Cliente eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        ClienteController controlador = new ClienteController();

        // Crear un cliente
        controlador.crearCliente("Juan", "Antonio", "Pérez", "Gómez", "12345678", "098712345");

        // Leer todos los clientes
        List<Cliente> clientes = controlador.obtenerTodosClientes();
        if (clientes != null) {
            System.out.println("Lista de clientes:");
            for (Cliente c : clientes) {
                System.out.println("ID: " + c.getIdCliente()
                        + ", Nombre: " + c.getPrimerNombre() + " " + c.getPrimerApellido()
                        + ", Cédula: " + c.getCedula());
            }
        }

        // Actualizar un cliente (suponiendo que ID 1 existe)
        controlador.actualizarCliente(1, "Eliab", "Selva", "Pérez", "López", "87654321", "099998877");

        // Eliminar un cliente
        controlador.eliminarCliente(1);
    }
}