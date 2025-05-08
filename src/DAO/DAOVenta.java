package DAO;
import Modelo.Venta;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class DAOVenta {
    
    public int crearVenta(Venta venta) throws SQLException {
        String sql = """
        INSERT INTO Ventas (
            ID_Cliente, 
            Fecha_Venta
        ) VALUES (?, ?)""";

        int generatedId = -1;

        try (Connection c = ConexionDB.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, venta.getIdCliente());
            stmt.setDate(2, new java.sql.Date(venta.getFechaVenta().getTime()));
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    generatedId = rs.getInt(1);
                }
            }
        }
        return generatedId;
    }

    public List<Venta> leerTodasVentas() throws SQLException {
        String sql = "SELECT * FROM Ventas";
        List<Venta> ventas = new ArrayList<>();

        try (Connection c = ConexionDB.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Venta venta = new Venta();
                venta.setIdVenta(rs.getInt("ID_Venta"));
                venta.setIdCliente(rs.getInt("ID_Cliente"));
                venta.setFechaVenta(rs.getDate("Fecha_Venta"));
                ventas.add(venta);
            }
        }
        return ventas;
    }

    public void actualizarVenta(Venta venta) throws SQLException {
        String sql = "UPDATE Ventas SET ID_Cliente = ?, Fecha_Venta = ? WHERE ID_Venta = ?";

        try (Connection c = ConexionDB.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, venta.getIdCliente());
            stmt.setDate(2, new java.sql.Date(venta.getFechaVenta().getTime()));
            stmt.setInt(3, venta.getIdVenta());
            stmt.executeUpdate();
        }
    }

    public void eliminarVenta(int idVenta) throws SQLException {
        String sql = "DELETE FROM Ventas WHERE ID_Venta = ?";

        try (Connection c = ConexionDB.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, idVenta);
            stmt.executeUpdate();
        }
    }

    // Para probar
    public static void main(String[] args) {
        try {
            DAOVenta dao = new DAOVenta();

            // Crear nueva venta
            Venta nuevaVenta = new Venta();
            nuevaVenta.setIdCliente(1);
            nuevaVenta.setFechaVenta(new java.util.Date());
            int idVenta = dao.crearVenta(nuevaVenta);
            System.out.println("Venta creada con ID: " + idVenta);

            // Actualizar una venta
            Venta venta = new Venta();
            venta.setIdVenta(idVenta); // ID generado
            venta.setIdCliente(2);
            venta.setFechaVenta(new java.util.Date());
            dao.actualizarVenta(venta);
            System.out.println("Venta actualizada.");

            // Leer ventas
            List<Venta> ventas = dao.leerTodasVentas();
            System.out.println("Lista de ventas:");
            for (Venta v : ventas) {
                System.out.println("ID: " + v.getIdVenta()
                        + ", Cliente ID: " + v.getIdCliente()
                        + ", Fecha: " + v.getFechaVenta());
            }

            // Eliminar venta
            dao.eliminarVenta(idVenta);
            System.out.println("Venta eliminada.");

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
