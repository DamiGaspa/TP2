package punto2;

public class Visa extends TarjetaCredito {
    private double descuento;

    public Visa() {
        this.descuento = 0.03;
    }

    public double aplicarDescuento(double bebidas, double platos) {
        double total = platos + (bebidas - (bebidas * this.descuento));
        return total;
    }
}
