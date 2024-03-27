package clasesDeRestaurant;

public class Plato {
    private String nombreDePlato;
    private double  valor;

    public Plato (String nombreDePlato, Double valor){
        this.nombreDePlato = nombreDePlato;
        this.valor = valor;
    }

    public double getValor (){
        return this.valor;
    }
}
