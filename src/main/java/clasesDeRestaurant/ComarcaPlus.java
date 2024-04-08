package clasesDeRestaurant;
import java.io.IOException;
import java.time.LocalDate;
public class ComarcaPlus extends Tarjeta{

    private static final double DESCUENTO = 0.98;


    public ComarcaPlus(Integer nroDeTarjeta, LocalDate fechaDeVencimiento, double saldo, Comensal duenio) {
        super(nroDeTarjeta, fechaDeVencimiento, saldo, duenio);
    }
    @Override
    double descuento(double costoBebida, double costoPlato, double costoPropina) throws IOException {
        if (!superaLimite(costoBebida, costoPlato, costoPropina) && (activa())) {
            double totalAPagar = costoPropina + (costoBebida * DESCUENTO + costoPlato * DESCUENTO);
            limite -= totalAPagar;
            return totalAPagar;
        }
        throw new RuntimeException("El total supera el limite...");
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
