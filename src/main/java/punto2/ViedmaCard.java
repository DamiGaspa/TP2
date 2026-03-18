package punto2;

public class Viedma extends TarjetaCredito {
    private double descuento;

    public Viedma() {
        this.descuento = 0;
    }

    public double aplicarDescuento(double bebidas, double platos) {
        return bebidas + platos;
    }
}
