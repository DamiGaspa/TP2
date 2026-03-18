package punto2;

public class ComarcaPlus extends TarjetaCredito {
    private double descuento;

    public ComarcaPlus() {
        this.descuento = 0.03;
    }

    public double aplicarDescuento(double bebidas, double platos) {
        double total = platos + bebidas;
        return (total - (total * this.descuento));
    }
}
