package clasesDeRestaurant;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private Integer capacidadDeLaMesa;
    private List<Comensal> comensales;
    private List <Pedido> pedidos;
    private double propina;
    public Mesa (Integer capacidad) {
        this.capacidadDeLaMesa = capacidad;
        this.comensales = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }
    public double realizarPago(Tarjeta tarjeta, double porcentajePropina) {
        double valorBebida = 0;
        double valorComida = 0;
        double totalDescontado = 0;
        if (porcentajePropina > 0) {
            for (Pedido pedido : pedidos) {
                valorBebida += pedido.obtenerValorBebida();
                valorComida += pedido.obtenerValorPlato();
            }
            double propina = (valorBebida + valorComida) * (porcentajePropina / 100);
            totalDescontado = tarjeta.descuento(valorBebida, valorComida, propina);
            juntarPropina(propina);
        }
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
