package punto2;

public class ComarcaPlusCard extends CreditCard {
    private double descuento;

    public ComarcaPlusCard() {
        this.descuento = 0.03;
    }

    public double aplicarDescuento(double bebidas, double platos) {
        double total = platos + bebidas;
        return (total - (total * this.descuento));
    }
}
