package claseTest;
import clasesDeRestaurant.*;
import org.junit.Test;
import persistencia.DatosEnDisco;
import persistencia.PersistirDatos;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.Assert.*;


public class RestauranteTest {

    @Test
     public void testCalcularCostoConComarcaPlus() throws IOException {
        var memoria = new DatosEnDisco();

        Restaurante resto1 = new Restaurante("Don Juan");

        var bebida1 = new Bebida ("Coca Cola", 2000.0);
        var plato1 = new Plato("Fideos con salsa rosa", 5000.0);

        var mesa1 = new Mesa(3, memoria);

        resto1.agregarMesa(mesa1);

        Comensal tiago = new Comensal("Tiago Nardini");
        Comensal sofia = new Comensal("Sofia Villegas");
        Comensal juan = new Comensal("Juan Villegas");

        var tarjComarcaPlus = new ComarcaPlus(12345678, LocalDate.now().plusMonths(10), 50000.00, juan);

        mesa1.agregarComensal(tiago);
        mesa1.agregarComensal(sofia);
        mesa1.agregarComensal(juan);

        tiago.realizarPedido(plato1,bebida1,mesa1);
        sofia.realizarPedido(plato1,bebida1,mesa1);
        juan.realizarPedido(plato1,bebida1,mesa1);

        assertTrue(mesa1.realizarPago(tarjComarcaPlus, 5) == 21630);
    }

    @Test
   public void testCalcularCostoConMasterCard() throws IOException {
        var memoria = new DatosEnDisco();
       var resto1 = new Restaurante("Sal y Fuego");

       var bebida1 = new Bebida("Sprite", 1500.0);
       var bebida2 = new Bebida("Fanta", 1200.0);
       var bebida3 = new Bebida("Pepsi", 1800.0);

       var comida1 = new Plato("Milanesa de pollo", 11000.0);
       var comida2 = new Plato("Milanesa de carne", 15000.0);
       var comida3 = new Plato("Papas Fritas", 8000.0);

       var mesa = new Mesa( 6, memoria);

       resto1.agregarMesa(mesa);

       var felipe = new Comensal("Felipe Jimenez");
       var gaston = new Comensal("Gaston Rodriguez");
       var horacio = new Comensal("Horacio Larreta");
       var josefina = new Comensal("Josefina Hescher");
       var leonela = new Comensal("Leonela Mendy");
       var miriam = new Comensal("Miriam Jimenez");

       var tarjMasterCard = new MasterCard(87654321, LocalDate.now().plusMonths(2),100000.0, josefina);

       mesa.agregarComensal(felipe);
       mesa.agregarComensal(gaston);
       mesa.agregarComensal(horacio);
       mesa.agregarComensal(josefina);
       mesa.agregarComensal(leonela);
       mesa.agregarComensal(miriam);

       felipe.realizarPedido(comida1, bebida2, mesa);
       gaston.realizarPedido(comida2,bebida3, mesa);
       horacio.realizarPedido(comida3, bebida3, mesa);
       josefina.realizarPedido(comida3, bebida1, mesa);
       leonela.realizarPedido(comida2, bebida3, mesa);
       miriam.realizarPedido(comida2, bebida2, mesa);

       assertTrue((mesa.realizarPago(tarjMasterCard, 3))== 82299.0);
    }

    @Test
    public void calcularCostoConVisa() throws IOException {
        var memoria = new DatosEnDisco();
        Restaurante resto1 = new Restaurante("Magu");

        var bebida1 = new Bebida ("Fernet Branca", 8000.0);
        var plato1 = new Plato("Pizza Muzzarella", 10000.0);

        var mesa1 = new Mesa(1, memoria);
        resto1.agregarMesa(mesa1);
        Comensal tiago = new Comensal("Tiago Nardini");

        var tarjVisa = new Visa(12345678, LocalDate.now().plusMonths(9), 500000.00, tiago);

        mesa1.agregarComensal(tiago);


        tiago.realizarPedido(plato1,bebida1,mesa1);


        assertTrue(mesa1.realizarPago(tarjVisa,2) == 18120);
    }

    @Test
    public void calcularCostoConViedma() throws IOException {

        var memoria = new DatosEnDisco();
        Restaurante resto1 = new Restaurante("Pizza Planeta");

        var bebida1 = new Bebida ("Fernet Branca", 8000.0);
        var bebida2 = new Bebida ("Coca Cola", 3000.0);
        var plato1 = new Plato("Pizza capresse", 11000.0);
        var plato2 = new Plato("Pizza cuatro quesos", 15000.0);

        var mesa1 = new Mesa(2, memoria);


        resto1.agregarMesa(mesa1);

        Comensal tiago = new Comensal("Tiago Nardini");
        Comensal sofia = new Comensal("Sofia Villegas");

        var tarjViedma = new Viedma(12345678, LocalDate.now().plusMonths(22), 45000.00, tiago);

        mesa1.agregarComensal(tiago);
        mesa1.agregarComensal(sofia);


        tiago.realizarPedido(plato1,bebida1,mesa1);
        sofia.realizarPedido(plato2,bebida2,mesa1);


        assertTrue(mesa1.realizarPago(tarjViedma,2) == 37740);
    }


}
