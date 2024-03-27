package clasesDeRestaurant;
import java.time.LocalDate;
public class ComarcaPlus extends Tarjeta{
    public ComarcaPlus(Integer nroDeTarjeta, LocalDate fechaDeVencimiento, double saldo, Comensal duenio) {
        super(nroDeTarjeta, fechaDeVencimiento, saldo, duenio);
        descuento = 0.98;
    }
    @Override
    double descuento(double costoBebida, double costoPlato, double costoPropina) {
        if (!superaLimite(costoBebida, costoPlato, costoPropina) && (activa())) {
            double totalAPagar = costoPropina + (costoBebida * descuento + costoPlato * descuento);
            limite -= totalAPagar;
            return totalAPagar;
        }
        return 0;
    }
    @Override
    boolean activa() {
        LocalDate hoy = LocalDate.now();
        return !hoy.isAfter(fechaDeVencimiento);
    }
    @Override
    boolean superaLimite (double costoBebida, double costoComida, double costoPropina) {
        return costoPropina + costoBebida + costoComida > limite;
    }
}
