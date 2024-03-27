package clasesDeRestaurant;

public class Comensal {
    private String nombreDeComensal;
    public Comensal (String nombreDeComensal){
        this.nombreDeComensal = nombreDeComensal;
    }
    public void realizarPedido(Plato plato1, Bebida bebida1, Mesa mesa) {
        var pedido = new Pedido(plato1, bebida1);
        mesa.agregarPedido(pedido);
    }
}
