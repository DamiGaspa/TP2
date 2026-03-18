package punto2;

public class MasterCard extends TarjetaCredito {
    private double descuento;

    public MasterCard() {
        this.descuento = 0.02;
    }

    public double aplicarDescuento(double bebidas, double platos) {
        double total = bebidas + (platos - (platos * this.descuento));
        return total;
    }
}
