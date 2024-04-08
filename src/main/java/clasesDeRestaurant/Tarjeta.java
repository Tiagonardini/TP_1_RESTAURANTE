package clasesDeRestaurant;

import java.io.IOException;
import java.time.LocalDate;

public abstract class Tarjeta {

    Integer nroDeTarjeta;
    LocalDate fechaDeVencimiento;
    double limite;
    Comensal duenio;
    double descuento;

    public Tarjeta(Integer nroDeTarjeta, LocalDate fechaDeVencimiento, double limite, Comensal duenio) {
    this.nroDeTarjeta = nroDeTarjeta;
    this.fechaDeVencimiento = fechaDeVencimiento;
    this.limite = limite;
    this.duenio = duenio;
    }
    abstract double descuento(double costoBebida, double costoPlato, double costoPropina) throws IOException;

    abstract boolean activa();

    abstract boolean superaLimite(double costoBebida, double costoComida, double costoPropina);
}
