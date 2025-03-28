import Persistence.FileExporter;
import org.junit.Test;
import punto1.ProveedorDeFecha;
import punto2.*;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.Assert.assertTrue;

public class test2 {

    @Test
    public void testVisa() throws IOException {
        var mesa = new Mesa(new FileExporter("C:/Users/gaspa.DAMI/Desktop/archivotest.txt"), new ProveedorDeFecha() {
            @Override
            public LocalDateTime fecha() {
                return LocalDateTime.now();
            }
        });
        var b1 = new ItemMenu("bebida", 2500);
        var b2 = new ItemMenu("bebida", 3000);
        var p1 = new ItemMenu("plato", 15000);
        var p2 = new ItemMenu("plato", 18000);
        var tarjeta = new Visa();
        mesa.sumarBebida(b1);
        mesa.sumarBebida(b2);
        mesa.sumarPlato(p1);
        mesa.sumarPlato(p2);
        double propina = 2;

        double precioTotal = tarjeta.aplicarDescuento(mesa.calcularCostoBebidas(), mesa.calcularCostoPlatos());
        System.out.println("Precio total: " + precioTotal);
        double precioMasPropina = mesa.darPropina(precioTotal, propina);
        System.out.println("Precio total con propina: " + precioMasPropina);

        assertTrue(precioTotal < 38500);
        assertTrue(precioMasPropina > precioTotal);
    }

    @Test
    public void testMaster() throws IOException {
        var mesa = new Mesa(new FileExporter("C:/Users/gaspa.DAMI/Desktop/archivotest.txt"), new ProveedorDeFecha() {
            @Override
            public LocalDateTime fecha() {
                return LocalDateTime.now();
            }
        });
        var b1 = new ItemMenu("bebida", 2500);
        var b2 = new ItemMenu("bebida", 3000);
        var p1 = new ItemMenu("plato", 15000);
        var p2 = new ItemMenu("plato", 18000);
        var tarjeta = new MasterCard();
        mesa.sumarBebida(b1);
        mesa.sumarBebida(b2);
        mesa.sumarPlato(p1);
        mesa.sumarPlato(p2);
        double propina = 3;

        double precioTotal = tarjeta.aplicarDescuento(mesa.calcularCostoBebidas(), mesa.calcularCostoPlatos());
        System.out.println("Precio total: " + precioTotal);
        double precioMasPropina = mesa.darPropina(precioTotal, propina);
        System.out.println("Precio total con propina: " + precioMasPropina);

        assertTrue(precioTotal < 38500);
        assertTrue(precioMasPropina > precioTotal);
    }

    @Test
    public void testComarca() throws IOException {
        var mesa = new Mesa(new FileExporter("C:/Users/gaspa.DAMI/Desktop/archivotest.txt"), new ProveedorDeFecha() {
            @Override
            public LocalDateTime fecha() {
                return LocalDateTime.now();
            }
        });
        var b1 = new ItemMenu("bebida", 2500);
        var b2 = new ItemMenu("bebida", 3000);
        var p1 = new ItemMenu("plato", 15000);
        var p2 = new ItemMenu("plato", 18000);
        var tarjeta = new ComarcaPlus();
        mesa.sumarBebida(b1);
        mesa.sumarBebida(b2);
        mesa.sumarPlato(p1);
        mesa.sumarPlato(p2);
        double propina = 5;

        double precioTotal = tarjeta.aplicarDescuento(mesa.calcularCostoBebidas(), mesa.calcularCostoPlatos());
        System.out.println("Precio total: " + precioTotal);
        double precioMasPropina = mesa.darPropina(precioTotal, propina);
        System.out.println("Precio total con propina: " + precioMasPropina);

        assertTrue(precioTotal < 38500);
        assertTrue(precioMasPropina > precioTotal);
    }

    @Test
    public void testViedma() throws IOException {
        var mesa = new Mesa(new FileExporter("C:/Users/gaspa.DAMI/Desktop/archivotest.txt"), new ProveedorDeFecha() {
            @Override
            public LocalDateTime fecha() {
                return LocalDateTime.now();
            }
        });
        var b1 = new ItemMenu("bebida", 2500);
        var b2 = new ItemMenu("bebida", 3000);
        var p1 = new ItemMenu("plato", 15000);
        var p2 = new ItemMenu("plato", 18000);
        var tarjeta = new Viedma();
        mesa.sumarBebida(b1);
        mesa.sumarBebida(b2);
        mesa.sumarPlato(p1);
        mesa.sumarPlato(p2);
        double propina = 5;

        double precioTotal = tarjeta.aplicarDescuento(mesa.calcularCostoBebidas(), mesa.calcularCostoPlatos());
        System.out.println("Precio total: " + precioTotal);
        double precioMasPropina = mesa.darPropina(precioTotal, propina);
        System.out.println("Precio total con propina: " + precioMasPropina);

        assertTrue(precioTotal == 38500);
        assertTrue(precioMasPropina > precioTotal);
    }

}
