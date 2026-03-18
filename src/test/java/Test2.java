import Persistence.FileExporter;
import org.junit.Test;
import punto2.*;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class Test2 {

    @Test
    public void testVisa() throws IOException {
        var mesa = new Table(new FileExporter(), new FakeDateProvider());
        var b1 = new MenuItem("bebida", 2500);
        var b2 = new MenuItem("bebida", 3000);
        var p1 = new MenuItem("plato", 15000);
        var p2 = new MenuItem("plato", 18000);
        var tarjeta = new VisaCard();
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
        var mesa = new Table(new FileExporter(), new FakeDateProvider());
        var b1 = new MenuItem("bebida", 2500);
        var b2 = new MenuItem("bebida", 3000);
        var p1 = new MenuItem("plato", 15000);
        var p2 = new MenuItem("plato", 18000);
        var tarjeta = new Mastercard();
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
        var mesa = new Table(new FileExporter(), new FakeDateProvider());
        var b1 = new MenuItem("bebida", 2500);
        var b2 = new MenuItem("bebida", 3000);
        var p1 = new MenuItem("plato", 15000);
        var p2 = new MenuItem("plato", 18000);
        var tarjeta = new ComarcaPlusCard();
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
        var mesa = new Table(new FileExporter(), new FakeDateProvider());
        var b1 = new MenuItem("bebida", 2500);
        var b2 = new MenuItem("bebida", 3000);
        var p1 = new MenuItem("plato", 15000);
        var p2 = new MenuItem("plato", 18000);
        var tarjeta = new ViedmaCard();
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
