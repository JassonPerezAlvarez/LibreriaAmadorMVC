package DAO;

import Modelo.DetalleVenta;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class DAODetalleVenta {

    public void crearDetalleVenta(DetalleVenta detalle) throws SQLException {
        String sql = """
        INSERT INTO Detalle_Ventas (
            ID_Venta, 
            ID_Producto, 
            Cantidad_Ven, 
            Precio_Ven
        ) VALUES (?, ?, ?, ?)""";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, detalle.getIdVenta());
            stmt.setInt(2, detalle.getIdProducto());
            stmt.setFloat(3, detalle.getCantidadVen());
            stmt.setFloat(4, detalle.getPrecioVen());
            stmt.executeUpdate();
        }
    }

    public List<DetalleVenta> leerTodosDetallesVenta() throws SQLException {
        String sql = "SELECT * FROM Detalle_Ventas";
        List<DetalleVenta> detalles = new ArrayList<>();

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                DetalleVenta detalle = new DetalleVenta();
                detalle.setIdDetalleVen(rs.getInt("ID_Detalle_Ven"));
                detalle.setIdVenta(rs.getInt("ID_Venta"));
                detalle.setIdProducto(rs.getInt("ID_Producto"));
                detalle.setCantidadVen(rs.getFloat("Cantidad_Ven"));
                detalle.setPrecioVen(rs.getFloat("Precio_Ven"));
                detalles.add(detalle);
            }
        }
        return detalles;
    }

    public void actualizarDetalleVenta(DetalleVenta detalle) throws SQLException {
        String sql = """
        UPDATE Detalle_Ventas 
        SET ID_Venta = ?, ID_Producto = ?, Cantidad_Ven = ?, Precio_Ven = ? 
        WHERE ID_Detalle_Ven = ?""";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, detalle.getIdVenta());
            stmt.setInt(2, detalle.getIdProducto());
            stmt.setFloat(3, detalle.getCantidadVen());
            stmt.setFloat(4, detalle.getPrecioVen());
            stmt.setInt(5, detalle.getIdDetalleVen());
            stmt.executeUpdate();
        }
    }

    public void eliminarDetalleVenta(int idDetalleVen) throws SQLException {
        String sql = "DELETE FROM Detalle_Ventas WHERE ID_Detalle_Ven = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, idDetalleVen);
            stmt.executeUpdate();
        }
    }
}
