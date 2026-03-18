package punto2;

import Persistence.CostoComidaDAO;
import punto1.DateProvider;
import punto1.Exporter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Table {
    private double costoTotal;
    private double costoBebidas;
    private double costoPlatos;
    private List<MenuItem> bebidas;
    private List<MenuItem> platos;
    private Exporter registro;
    private DateProvider proveedor;

    public Table(Exporter registro, DateProvider proveedor) {
        this.costoPlatos = 0;
        this.costoBebidas = 0;
        this.costoTotal = 0;
        bebidas = new ArrayList<>();
        platos = new ArrayList<>();
        this.registro = registro;
        this.proveedor = proveedor;
    }

    public double calcularCostoBebidas() {
        for (MenuItem bebida : bebidas) {
            this.costoBebidas += bebida.obtenerPrecio();

        }
        return costoBebidas;
    }

    public double calcularCostoPlatos() {
        for (MenuItem plato : platos) {
            this.costoPlatos += plato.obtenerPrecio();
        }
        return costoPlatos;
    }

    public double calcularCostoTotal() {
        return costoTotal = calcularCostoBebidas() + calcularCostoPlatos();
    }

    public double darPropina(double precio, double porcentaje) {
        double propina = 1 + (porcentaje / 100);
        return precio * propina;
    }

    public void sumarBebida(MenuItem bebida) throws IOException {
        bebidas.add(bebida);
        String menu = this.proveedor.fecha().toString() + "||" + bebida.obtenerPrecio() + "\n";
        this.registro.export(menu);
        CostoComidaDAO.registrarCosto(bebida.obtenerPrecio());
    }

    public void sumarPlato(MenuItem plato) throws IOException {
        platos.add(plato);
        String menu = this.proveedor.fecha().toString() + "||" + plato.obtenerPrecio() + "\n";
        this.registro.export(menu);
        CostoComidaDAO.registrarCosto(plato.obtenerPrecio());
    }

    public List<MenuItem> getBebidas() {
        return bebidas;
    }

    public List<MenuItem> getPlatos() {
        return platos;
    }

}
