package punto2;

import Persistence.FoodCostDAO;
import punto1.DateProvider;
import punto1.Exporter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private double costoTotal;
    private double costoBebidas;
    private double costoPlatos;
    private List<ItemMenu> bebidas;
    private List<ItemMenu> platos;
    private Exporter registro;
    private DateProvider proveedor;

    public Mesa(Exporter registro, DateProvider proveedor) {
        this.costoPlatos = 0;
        this.costoBebidas = 0;
        this.costoTotal = 0;
        bebidas = new ArrayList<>();
        platos = new ArrayList<>();
        this.registro = registro;
        this.proveedor = proveedor;
    }

    public double calcularCostoBebidas() {
        for (ItemMenu bebida : bebidas) {
            this.costoBebidas += bebida.obtenerPrecio();

        }
        return costoBebidas;
    }

    public double calcularCostoPlatos() {
        for (ItemMenu plato : platos) {
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

    public void sumarBebida(ItemMenu bebida) throws IOException {
        bebidas.add(bebida);
        String menu = this.proveedor.fecha().toString() + "||" + bebida.obtenerPrecio() + "\n";
        this.registro.export(menu);
        FoodCostDAO.registrarCosto(bebida.obtenerPrecio());
    }

    public void sumarPlato(ItemMenu plato) throws IOException {
        platos.add(plato);
        String menu = this.proveedor.fecha().toString() + "||" + plato.obtenerPrecio() + "\n";
        this.registro.export(menu);
        FoodCostDAO.registrarCosto(plato.obtenerPrecio());
    }

    public List<ItemMenu> getBebidas() {
        return bebidas;
    }

    public List<ItemMenu> getPlatos() {
        return platos;
    }

}
