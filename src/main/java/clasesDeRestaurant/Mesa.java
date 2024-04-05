package clasesDeRestaurant;

import persistencia.PersistirDatos;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private Integer capacidadDeLaMesa;
    private List<Comensal> comensales;
    private List <Pedido> pedidos;
    private double propina;

    private PersistirDatos memoria;
    public Mesa (Integer capacidad, PersistirDatos memoria) {
        this.capacidadDeLaMesa = capacidad;
        this.comensales = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.memoria = memoria;
    }
    public double realizarPago(Tarjeta tarjeta, double porcentajePropina) throws IOException {
        double valorBebida = 0;
        double valorComida = 0;
        if (porcentajePropina < 0) {
            throw new RuntimeException("El usuario no dejo propina");
        }
        for (Pedido pedido : pedidos) {
            valorBebida += pedido.obtenerValorBebida();
            valorComida += pedido.obtenerValorPlato();
        }
        double propina = (valorBebida + valorComida) * (porcentajePropina / 100);
        double totalDescontado = tarjeta.descuento(valorBebida, valorComida, propina);
        juntarPropina(propina);

        memoria.guardar(totalDescontado);

        return totalDescontado;
    }
    public void agregarComensal  (Comensal unComensal){
        if (comensales.size() <=  capacidadDeLaMesa){
            comensales.add(unComensal);
        }
    }




    public void agregarPedido (Pedido pedido){
        pedidos.add(pedido);
    }

    private void juntarPropina (double propina){
        this.propina += propina;
    }
}
