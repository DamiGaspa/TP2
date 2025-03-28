package punto2;

public class ItemMenu {
    private String descripcion;
    private double precio;

    public ItemMenu(String descripcion, double precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public double obtenerPrecio() {
        return precio;
    }

    public String nombre() {
        return descripcion;
    }
}
