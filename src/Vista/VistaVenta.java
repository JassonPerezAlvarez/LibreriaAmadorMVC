package Vista;

import DAO.DAODetalleVenta;
import DAO.DAOVenta;
import Modelo.Venta;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import DAO.DAODetalleVenta;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;

import java.awt.FileDialog;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.JOptionPane;

import Modelo.Producto;
import Controlador.ProductoController;
import DAO.DAOProducto;



public class VistaVenta extends javax.swing.JPanel {
private javax.swing.JButton jButtonReporteVentas;
private javax.swing.JButton jButtonReporteVencidos;

    public VistaVenta() {
        initComponents();
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Detalle");
        modelo.addColumn("Nombre Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");

        jTableDetalleVenta.setModel(modelo);
        
jButtonGenerarReporteVentas = new javax.swing.JButton("Generar Reporte de Ventas");
jButtonGenerarReporteVentas.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        generarReporteVentas();
    }
            private void generarReporteVentas() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
jButtonReporteVencidos = new javax.swing.JButton("Generar Productos Vencidos");
jButtonReporteVencidos.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        generarReporteProductosVencidos();
    }

            private void generarReporteProductosVencidos() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });


        cargarVentas();
        jTableVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = jTableVentas.getSelectedRow();
                if (fila != -1) {
                    int idVenta = (int) jTableVentas.getValueAt(fila, 0);
                    jTextFieldIdVenta.setText(String.valueOf(idVenta));
                    jTextFieldIdClientes.setText(String.valueOf(jTableVentas.getValueAt(fila, 2)));
                    jDateChooserFechaVentas.setDate((Date) jTableVentas.getValueAt(fila, 1));
                    cargarDetallesVenta(idVenta);
                }
            }
        });

    }
    

    private void cargarVentas() {
        try {
            List<Venta> ventas = DAOVenta.obtenerTodasLasVentas();
            llenarTablaVentas(ventas);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar ventas: " + e.getMessage());
        }
    }
public class VentanaDetallesVenta extends JFrame {
    private JTable jTableDetalleVenta;
    private DefaultTableModel modelo;

    public VentanaDetallesVenta() {
        // Configuración de la ventana
        setTitle("Detalles de Venta");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializar el modelo de la tabla
        modelo = new DefaultTableModel();
        modelo.addColumn("ID Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");

        // Inicializar la tabla
        jTableDetalleVenta = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(jTableDetalleVenta);
        add(scrollPane, BorderLayout.CENTER);

        // Cargar detalles de venta (por ejemplo, para idVenta = 1)
        cargarDetallesVenta(1);
    }

    private void cargarDetallesVenta(int idVenta) {
        // Limpiar el modelo de la tabla antes de cargar nuevos datos
        modelo.setRowCount(0);

        // Obtener detalles de la venta desde la base de datos
        List<Object[]> detalles = DAODetalleVenta.obtenerDetallesPorVenta(idVenta);

        // Agregar los detalles al modelo de la tabla
        for (Object[] fila : detalles) {
            modelo.addRow(fila);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

        });
    }
}
private void cargarDetallesVenta(int idVenta) {
    DefaultTableModel modelo = (DefaultTableModel) jTableDetalleVenta.getModel();
    modelo.setRowCount(0); // Limpiar tabla

    try {
        List<Object[]> detalles = DAODetalleVenta.obtenerDetallesPorVenta(idVenta);
        if (detalles != null) {
            for (Object[] fila : detalles) {
                modelo.addRow(fila);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay detalles disponibles para esta venta.");
        }
    } catch (UnsupportedOperationException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al cargar detalles de venta: " + e.getMessage());
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado: " + e.getMessage());
    }
}




    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldIdVenta = new javax.swing.JTextField();
        jButtonEliminar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableVentas = new javax.swing.JTable();
        jButtonActualizarVenta = new javax.swing.JButton();
        jButtonEliminarVenta = new javax.swing.JButton();
        jButtonGuardarVenta = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jDateChooserFechaVentas = new com.toedter.calendar.JDateChooser();
        jButtonActualizar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jTextFieldIdClientes = new javax.swing.JTextField();
        jButtonGenerarReporteVentas = new javax.swing.JButton();
        jButtonGenerarReporteProductosVencidos = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDetalleVenta = new javax.swing.JTable();
        jButtonAgregarDetalleVenta = new javax.swing.JButton();
        jButtonQuitarDetalleVenta = new javax.swing.JButton();
        jTextFieldBuscar = new javax.swing.JTextField();
        jButtonBuscarVenta = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jScrollPane1.setViewportView(jTree1);

        setBackground(new java.awt.Color(40, 86, 115));

        jPanel2.setBackground(new java.awt.Color(40, 86, 115));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ventas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID Venta");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha Venta");

        jTextFieldIdVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdVentaActionPerformed(evt);
            }
        });

        jButtonEliminar.setBackground(new java.awt.Color(58, 114, 142));
        jButtonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jTableVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID_Venta", "Fecha_Venta", "ID_Cliente"
            }
        ));
        jScrollPane3.setViewportView(jTableVentas);

        jButtonActualizarVenta.setText("Actualizar Venta");

        jButtonEliminarVenta.setText("Eliminar Venta");

        jButtonGuardarVenta.setText("Guardar Venta");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ID Cliente");

        jButtonActualizar.setBackground(new java.awt.Color(58, 114, 142));
        jButtonActualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        jButtonGuardar.setBackground(new java.awt.Color(58, 114, 142));
        jButtonGuardar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButtonGenerarReporteVentas.setText("Generar Reporte Ventas");
        jButtonGenerarReporteVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerarReporteVentasActionPerformed(evt);
            }
        });

        jButtonGenerarReporteProductosVencidos.setText("Generar Reporte de Productos Vencidos");
        jButtonGenerarReporteProductosVencidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerarReporteProductosVencidosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldIdClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jDateChooserFechaVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonEliminar)
                            .addComponent(jButtonActualizarVenta))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jButtonEliminarVenta))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jButtonActualizar)))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonGuardar)
                            .addComponent(jButtonGuardarVenta)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonGenerarReporteProductosVencidos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonGenerarReporteVentas)
                        .addGap(24, 24, 24))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooserFechaVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldIdClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEliminar)
                    .addComponent(jButtonActualizar)
                    .addComponent(jButtonGuardar))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGenerarReporteVentas)
                    .addComponent(jButtonGenerarReporteProductosVencidos))
                .addGap(338, 338, 338)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonActualizarVenta)
                    .addComponent(jButtonEliminarVenta)
                    .addComponent(jButtonGuardarVenta))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(40, 86, 115));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle venta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jTableDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID_Detalle_Ven", "ID_Venta", "ID_Producto", "Cantidad_Ven", "Precio_Ven"
            }
        ));
        jScrollPane2.setViewportView(jTableDetalleVenta);

        jButtonAgregarDetalleVenta.setBackground(new java.awt.Color(58, 114, 142));
        jButtonAgregarDetalleVenta.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAgregarDetalleVenta.setText("Agregar Detalle");
        jButtonAgregarDetalleVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarDetalleVentaActionPerformed(evt);
            }
        });

        jButtonQuitarDetalleVenta.setBackground(new java.awt.Color(58, 114, 142));
        jButtonQuitarDetalleVenta.setForeground(new java.awt.Color(255, 255, 255));
        jButtonQuitarDetalleVenta.setText("Quitar Detalle");
        jButtonQuitarDetalleVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitarDetalleVentaActionPerformed(evt);
            }
        });

        jButtonBuscarVenta.setBackground(new java.awt.Color(58, 114, 142));
        jButtonBuscarVenta.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBuscarVenta.setText("Buscar");
        jButtonBuscarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarVentaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Buscar Venta");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButtonBuscarVenta)
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jButtonAgregarDetalleVenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonQuitarDetalleVenta)
                .addGap(75, 75, 75))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscarVenta)
                    .addComponent(jLabel3))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAgregarDetalleVenta)
                    .addComponent(jButtonQuitarDetalleVenta))
                .addGap(88, 88, 88))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 564, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        try {
            int idCliente = Integer.parseInt(jTextFieldIdClientes.getText());
            Date fecha = jDateChooserFechaVentas.getDate();

            if (fecha == null) {
                JOptionPane.showMessageDialog(this, "Seleccione una fecha válida.");
                return;
            }

            Venta nuevaVenta = new Venta();
            nuevaVenta.setIdCliente(idCliente);
            nuevaVenta.setFechaVenta(fecha);

            DAOVenta dao = new DAOVenta();
            int idGenerado = dao.crearVenta(nuevaVenta);

            JOptionPane.showMessageDialog(this, "Venta guardada con ID: " + idGenerado);
            cargarVentas(); // refrescar tabla
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar la venta: " + e.getMessage());
        }
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        try {
            int idVenta = Integer.parseInt(jTextFieldIdVenta.getText());
            int idCliente = Integer.parseInt(jTextFieldIdClientes.getText());
            Date fecha = jDateChooserFechaVentas.getDate();

            if (fecha == null) {
                JOptionPane.showMessageDialog(this, "Seleccione una fecha válida.");
                return;
            }

            Venta venta = new Venta();
            venta.setIdVenta(idVenta);
            venta.setIdCliente(idCliente);
            venta.setFechaVenta(fecha);

            DAOVenta dao = new DAOVenta();
            dao.actualizarVenta(venta);

            JOptionPane.showMessageDialog(this, "Venta actualizada correctamente.");
            cargarVentas(); // refrescar tabla
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar la venta: " + e.getMessage());
        }
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jButtonBuscarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarVentaActionPerformed
        try {
            String filtro = jTextFieldBuscar.getText();
            List<Venta> ventas = DAOVenta.buscarVentas(filtro);
            llenarTablaVentas(ventas); // Muestra resultados
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar ventas: " + e.getMessage());
        }
    }//GEN-LAST:event_jButtonBuscarVentaActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        try {
            int idVenta = Integer.parseInt(jTextFieldIdVenta.getText());
            new DAOVenta().eliminarVenta(idVenta);
            JOptionPane.showMessageDialog(this, "Venta eliminada correctamente.");
            cargarVentas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar venta: " + e.getMessage());
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jTextFieldIdVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdVentaActionPerformed

    private void jButtonQuitarDetalleVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitarDetalleVentaActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = jTableDetalleVenta.getSelectedRow();

        if (filaSeleccionada >= 0) {
            DefaultTableModel modelo = (DefaultTableModel) jTableDetalleVenta.getModel();
            modelo.removeRow(filaSeleccionada);
            JOptionPane.showMessageDialog(this, "Detalle de venta eliminado.");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un detalle para quitar.");
        }
    }//GEN-LAST:event_jButtonQuitarDetalleVentaActionPerformed

    private void jButtonAgregarDetalleVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarDetalleVentaActionPerformed
        // TODO add your handling code here:
        try {
            int idVenta = Integer.parseInt(jTextFieldIdVenta.getText());
            int idProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del Producto:"));
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad:"));
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio:"));

            DAODetalleVenta.agregarDetalle(idVenta, idProducto, cantidad, precio);
            JOptionPane.showMessageDialog(this, "Detalle agregado correctamente.");
            cargarDetallesVenta(idVenta);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al agregar detalle: " + e.getMessage());
        }
    }//GEN-LAST:event_jButtonAgregarDetalleVentaActionPerformed

    private void jButtonGenerarReporteVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerarReporteVentasActionPerformed
 try {
        FileDialog dialogoArchivo = new FileDialog((java.awt.Frame) null, "Guardar Reporte de Ventas", FileDialog.SAVE);
        dialogoArchivo.setFile("ReporteVentas.pdf");
        dialogoArchivo.setVisible(true);

        String ruta = dialogoArchivo.getDirectory();
        String nombreArchivo = dialogoArchivo.getFile();

        if (ruta == null || nombreArchivo == null) {
            JOptionPane.showMessageDialog(this, "Operación cancelada.");
            return;
        }

        if (!nombreArchivo.toLowerCase().endsWith(".pdf")) {
            nombreArchivo += ".pdf";
        }

        String rutaCompleta = Paths.get(ruta, nombreArchivo).toString();

        PdfWriter writer = new PdfWriter(rutaCompleta);
        PdfDocument pdf = new PdfDocument(writer);
        try (Document documento = new Document(pdf)) {

            documento.add(new Paragraph("Reporte de Ventas")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(20)
                    .setBold());

            documento.add(new Paragraph("Fecha: " + new java.util.Date())
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(12));

            documento.add(new Paragraph("\n"));

            Table tabla = new Table(3);
            tabla.setWidth(UnitValue.createPercentValue(100));
            tabla.addHeaderCell("ID Venta").setBold();
            tabla.addHeaderCell("Fecha de Venta").setBold();
            tabla.addHeaderCell("ID Cliente").setBold();

            DAOVenta dao = new DAOVenta();
            List<Venta> ventas = dao.obtenerTodasLasVentas();

            for (Venta venta : ventas) {
                tabla.addCell(String.valueOf(venta.getIdVenta()));
                tabla.addCell(venta.getFechaVenta().toString());
                tabla.addCell(String.valueOf(venta.getIdCliente()));
            }

            documento.add(tabla);
            documento.add(new Paragraph("\nGenerado automáticamente.").setFontSize(10).setTextAlignment(TextAlignment.RIGHT));
        }

        JOptionPane.showMessageDialog(this, "Reporte generado exitosamente.");
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al generar el reporte: " + e.getMessage());
    }       
    }//GEN-LAST:event_jButtonGenerarReporteVentasActionPerformed

    private void jButtonGenerarReporteProductosVencidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerarReporteProductosVencidosActionPerformed
    try {
        FileDialog dialogoArchivo = new FileDialog((java.awt.Frame) null, "Guardar Reporte de Productos Vencidos", FileDialog.SAVE);
        dialogoArchivo.setFile("ProductosVencidos.pdf");
        dialogoArchivo.setVisible(true);

        String ruta = dialogoArchivo.getDirectory();
        String nombreArchivo = dialogoArchivo.getFile();

        if (ruta == null || nombreArchivo == null) {
            JOptionPane.showMessageDialog(this, "Operación cancelada.");
            return;
        }

        if (!nombreArchivo.toLowerCase().endsWith(".pdf")) {
            nombreArchivo += ".pdf";
        }

        String rutaCompleta = Paths.get(ruta, nombreArchivo).toString();

        PdfWriter writer = new PdfWriter(rutaCompleta);
        PdfDocument pdf = new PdfDocument(writer);
        try (Document documento = new Document(pdf)) {

            documento.add(new Paragraph("Reporte de Productos Vencidos")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(20)
                    .setBold());

            documento.add(new Paragraph("Fecha: " + new java.util.Date())
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(12));

            documento.add(new Paragraph("\n"));

            Table tabla = new Table(3);
            tabla.setWidth(UnitValue.createPercentValue(100));
            tabla.addHeaderCell("ID Producto").setBold();
            tabla.addHeaderCell("Nombre").setBold();
            tabla.addHeaderCell("Fecha de Vencimiento").setBold();

            DAOProducto daoProducto = new DAOProducto();
            List<Producto> vencidos = daoProducto.obtenerProductosVencidos();

            for (Producto p : vencidos) {
                tabla.addCell(String.valueOf(p.getIdProducto()));
                tabla.addCell(p.getNombre());
                tabla.addCell(p.getFechaVencimiento().toString());
            }

            documento.add(tabla);
            documento.add(new Paragraph("\nGenerado automáticamente.").setFontSize(10).setTextAlignment(TextAlignment.RIGHT));
        }

        JOptionPane.showMessageDialog(this, "Reporte generado exitosamente.");
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al generar el reporte: " + e.getMessage());
    }
    }//GEN-LAST:event_jButtonGenerarReporteProductosVencidosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonActualizarVenta;
    private javax.swing.JButton jButtonAgregarDetalleVenta;
    private javax.swing.JButton jButtonBuscarVenta;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonEliminarVenta;
    private javax.swing.JButton jButtonGenerarReporteProductosVencidos;
    private javax.swing.JButton jButtonGenerarReporteVentas;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonGuardarVenta;
    private javax.swing.JButton jButtonQuitarDetalleVenta;
    private com.toedter.calendar.JDateChooser jDateChooserFechaVentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableDetalleVenta;
    private javax.swing.JTable jTableVentas;
    private javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JTextField jTextFieldIdClientes;
    private javax.swing.JTextField jTextFieldIdVenta;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables

    private void llenarTablaVentas(List<Venta> ventas) {
        DefaultTableModel model = (DefaultTableModel) jTableVentas.getModel();
        model.setRowCount(0); // Limpiar tabla

        for (Venta v : ventas) {
            model.addRow(new Object[]{
                v.getIdVenta(),
                v.getFechaVenta(),
                v.getIdCliente()
            });
        }
    }

    private void llenarTablaDetalleVentas(List<Venta> DetalleVentas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
