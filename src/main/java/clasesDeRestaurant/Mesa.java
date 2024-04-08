package clasesDeRestaurant;

import persistencia.PersistirDatos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private Integer capacidadDeLaMesa;
    private List<Comensal> comensales;
    private List<Pedido> pedidos;
    private double propina;

    private PersistirDatos memoria;

    private static final int CERO = 0;
    private static final int CIEN = 100;

    public Mesa(Integer capacidad, PersistirDatos memoria) {
        this.capacidadDeLaMesa = capacidad;
        this.comensales = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.memoria = memoria;
    }

    public double realizarPago(Tarjeta tarjeta, double porcentajePropina) throws IOException {
        double valorBebida = CERO;
        double valorComida = CERO;
        if (porcentajePropina < CERO) {
            throw new RuntimeException("El usuario no dejo propina");
        }
        for (Pedido pedido : pedidos) {
            valorBebida += pedido.obtenerValorBebida();
            valorComida += pedido.obtenerValorPlato();
        }
        double propina = (valorBebida + valorComida) * (porcentajePropina / CIEN);
        double totalDescontado = tarjeta.descuento(valorBebida, valorComida, propina);
        recogerPropina(propina);

        memoria.guardar(totalDescontado);

        return totalDescontado;
    }

    public void agregarComensal(Comensal unComensal) {
        if (comensales.size() <= capacidadDeLaMesa) {
            comensales.add(unComensal);
        }
    }

    public void agregarPedido (Pedido pedido){
        pedidos.add(pedido);
    }

    private void recogerPropina(double propina){
        this.propina += propina;
    }
}
