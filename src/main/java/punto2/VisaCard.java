package punto2;

public class VisaCard extends CreditCard {
    private double descuento;

    public VisaCard() {
        this.descuento = 0.03;
    }

    public double aplicarDescuento(double bebidas, double platos) {
        double total = platos + (bebidas - (bebidas * this.descuento));
        return total;
    }
}
