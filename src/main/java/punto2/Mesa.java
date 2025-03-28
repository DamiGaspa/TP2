package punto2;

import Persistence.CostoComidaDAO;
import punto1.Exportador;
import punto1.ProveedorDeFecha;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private double costoTotal;
    private double costoBebidas;
    private double costoPlatos;
    private List<ItemMenu> bebidas;
    private List<ItemMenu> platos;
    private Exportador registro;
    private ProveedorDeFecha proveedor;

    public Mesa(Exportador registro, ProveedorDeFecha proveedor) {
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
        String menu = this.proveedor.fecha().toString() + "||" + bebida.obtenerPrecio();
        this.registro.export(menu);
        CostoComidaDAO.registrarCosto(bebida.obtenerPrecio());
    }

    public void sumarPlato(ItemMenu plato) throws IOException {
        platos.add(plato);
        String menu = this.proveedor.fecha().toString() + "||" + plato.obtenerPrecio();
        this.registro.export(menu);
        CostoComidaDAO.registrarCosto(plato.obtenerPrecio());
    }

    public List<ItemMenu> getBebidas() {
        return bebidas;
    }

    public List<ItemMenu> getPlatos() {
        return platos;
    }

}
