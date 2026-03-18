package punto2;

public class Mastercard extends CreditCard {
    private double descuento;

    public Mastercard() {
        this.descuento = 0.02;
    }

    public double aplicarDescuento(double bebidas, double platos) {
        double total = bebidas + (platos - (platos * this.descuento));
        return total;
    }
}
