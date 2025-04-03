package Modelo;

/**
 *
 * @author Usuario
 */
public class Producto {

    private int idProducto;
    private String nombre;
    private String descripcion;
    private float cantidad;
    private float precioComp;
    private float precioVent;

    public Producto(int idProducto, String nombre, String descripcion, float cantidad, float precioComp, float precioVent) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioComp = precioComp;
        this.precioVent = precioVent;
    }

    public Producto() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioComp() {
        return precioComp;
    }

    public void setPrecioComp(float precioComp) {
        this.precioComp = precioComp;
    }

    public float getPrecioVent() {
        return precioVent;
    }

    public void setPrecioVent(float precioVent) {
        this.precioVent = precioVent;
    }

}
