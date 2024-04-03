package clasesDeRestaurant;

public class Pedido {

    Bebida unaBebida;
    Plato unPlato;

    public Pedido(Bebida unaBebida, Plato unPlato){
        this.unaBebida = unaBebida;
        this.unPlato = unPlato;
    }
    public double obtenerValorBebida() {
        return this.unaBebida.getValor();
    }

    public double obtenerValorPlato() {
        return this.unPlato.getValor();
    }
}
