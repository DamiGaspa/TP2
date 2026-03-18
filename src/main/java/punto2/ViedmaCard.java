package punto2;

public class ViedmaCard extends CreditCard {
    private double descuento;

    public ViedmaCard() {
        this.descuento = 0;
    }

    public double aplicarDescuento(double bebidas, double platos) {
        return bebidas + platos;
    }
}
